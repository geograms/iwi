package com.geograms.iwi;

/**
 * AX.25 data-link layer + Bell 202 AFSK physical layer.
 *
 * TX pipeline (all static, stateless):
 *   buildUIFrame → frameWithFCS → hdlcEncode → nrziEncode → modulateAfsk
 *   or just: modulateFrame(ax25Frame) for the whole chain.
 *
 * RX pipeline (stateful):
 *   new Demodulator(callback) → addSamples(pcm) → callback.onFrame(ax25)
 *
 * Designed for 8kHz/16-bit/mono PCM (the DMR module's native format).
 * At 8kHz sample rate, 1200 baud gives ~6.67 samples/bit.
 */
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;

public class AX25 {

    private static final String TAG = "AX25";

    // --- Constants ---
    public static final int BAUD_RATE = 1200;
    public static final int MARK_FREQ = 1200;   // Hz — binary 1
    public static final int SPACE_FREQ = 2200;   // Hz — binary 0
    public static final int SAMPLE_RATE = 8000;
    public static final int FLAG = 0x7E;
    public static final int CONTROL_UI = 0x03;
    public static final int PID_NO_L3 = 0xF0;
    public static final int CRC_POLY = 0x8408;   // CRC-CCITT reflected
    public static int txAmplitude = 16000; // adjustable for radio module tuning
    public static final int PREAMBLE_FLAGS = 40;  // ~267ms at 1200 baud
    public static final int TRAILER_FLAGS = 4;
    public static final int WARMUP_SAMPLES = 1600; // 200ms at 8kHz — TX warmup silence

    // Per-tone amplitude scaling (adjustable via /aprs/config API for tuning).
    // Default 1.0/1.0 — set to different values only if radio module frequency
    // response needs compensation (measure with HackRF capture first).
    public static double markAmplitudeScale = 1.0;
    public static double spaceAmplitudeScale = 1.0;

    private static final double SAMPLES_PER_BIT = (double) SAMPLE_RATE / BAUD_RATE;
    private static final double TWO_PI = 2.0 * Math.PI;

    // ========================================================================
    // TX PIPELINE
    // ========================================================================

    /**
     * Encode a callsign + SSID into an AX.25 address field (7 bytes).
     * Characters are left-shifted by 1 as per AX.25 spec.
     *
     * @param callsign up to 6 characters, padded with spaces
     * @param ssid     0-15
     * @param isLast   true if this is the last address in the header
     */
    public static byte[] encodeAddress(String callsign, int ssid, boolean isLast,
                                        boolean commandBit) {
        byte[] addr = new byte[7];
        String padded = callsign.toUpperCase();
        while (padded.length() < 6) padded += " ";

        for (int i = 0; i < 6; i++) {
            addr[i] = (byte) (padded.charAt(i) << 1);
        }

        // SSID byte: CRRSSID0  C=command/response (bit 7), RR=11 (reserved), extension bit (bit 0)
        addr[6] = (byte) (0x60 | ((ssid & 0x0F) << 1) | (isLast ? 0x01 : 0x00));
        if (commandBit) addr[6] |= (byte) 0x80;
        return addr;
    }

    /** Backward-compatible overload — commandBit defaults to false. */
    public static byte[] encodeAddress(String callsign, int ssid, boolean isLast) {
        return encodeAddress(callsign, ssid, isLast, false);
    }

    /**
     * Build an AX.25 UI frame (without FCS).
     *
     * @param src         source callsign
     * @param srcSsid     source SSID (0-15)
     * @param dst         destination callsign
     * @param dstSsid     destination SSID (0-15)
     * @param digipeaters array of "CALL-N" strings (e.g. "WIDE1-1"), may be null
     * @param info        information field bytes
     */
    public static byte[] buildUIFrame(String src, int srcSsid, String dst, int dstSsid,
                                      String[] digipeaters, byte[] info) {
        int digiCount = (digipeaters != null) ? digipeaters.length : 0;
        // 7 dst + 7 src + 7*digiCount + 1 control + 1 PID + info
        int len = 14 + digiCount * 7 + 2 + info.length;
        byte[] frame = new byte[len];
        int pos = 0;

        // Destination address (command bit set for command frames per AX.25 spec)
        byte[] dstBytes = encodeAddress(dst, dstSsid, false, true);
        System.arraycopy(dstBytes, 0, frame, pos, 7);
        pos += 7;

        // Source address (last if no digipeaters)
        boolean srcIsLast = (digiCount == 0);
        byte[] srcBytes = encodeAddress(src, srcSsid, srcIsLast, false);
        System.arraycopy(srcBytes, 0, frame, pos, 7);
        pos += 7;

        // Digipeaters
        for (int i = 0; i < digiCount; i++) {
            String digi = digipeaters[i];
            int digiSsid = 0;
            String digiCall = digi;
            int dash = digi.indexOf('-');
            if (dash >= 0) {
                digiCall = digi.substring(0, dash);
                digiSsid = Integer.parseInt(digi.substring(dash + 1));
            }
            boolean digiIsLast = (i == digiCount - 1);
            byte[] digiBytes = encodeAddress(digiCall, digiSsid, digiIsLast);
            System.arraycopy(digiBytes, 0, frame, pos, 7);
            pos += 7;
        }

        frame[pos++] = CONTROL_UI;
        frame[pos++] = (byte) PID_NO_L3;

        System.arraycopy(info, 0, frame, pos, info.length);
        return frame;
    }

    /**
     * CRC-CCITT as used in AX.25 (polynomial 0x8408, init 0xFFFF, final XOR 0xFFFF).
     * Bit-by-bit computation for clarity and correctness.
     */
    public static int crcCcitt(byte[] data, int offset, int length) {
        int crc = 0xFFFF;
        for (int i = offset; i < offset + length; i++) {
            int b = data[i] & 0xFF;
            for (int bit = 0; bit < 8; bit++) {
                if (((crc ^ b) & 0x01) != 0) {
                    crc = (crc >> 1) ^ CRC_POLY;
                } else {
                    crc >>= 1;
                }
                b >>= 1;
            }
        }
        return crc ^ 0xFFFF;
    }

    /**
     * Append FCS (Frame Check Sequence) to an AX.25 frame.
     * CRC is stored in little-endian order.
     */
    public static byte[] frameWithFCS(byte[] frame) {
        int crc = crcCcitt(frame, 0, frame.length);
        byte[] result = new byte[frame.length + 2];
        System.arraycopy(frame, 0, result, 0, frame.length);
        result[frame.length] = (byte) (crc & 0xFF);
        result[frame.length + 1] = (byte) ((crc >> 8) & 0xFF);
        return result;
    }

    /**
     * HDLC encode: preamble flags + bit-stuffed data + trailer flags.
     * Flags are 0x7E sent LSB first. Data bits are sent LSB first with
     * zero-insertion after five consecutive 1-bits.
     */
    public static boolean[] hdlcEncode(byte[] frameWithCrc, int preambleFlags, int trailerFlags) {
        // Estimate max size: flags are 8 bits each, data could expand by ~20% from stuffing
        int maxBits = (preambleFlags + trailerFlags) * 8 + frameWithCrc.length * 10;
        boolean[] bits = new boolean[maxBits];
        int pos = 0;

        // Preamble flags (no bit stuffing)
        for (int f = 0; f < preambleFlags; f++) {
            pos = appendByte(bits, pos, FLAG, false);
        }

        // Data with bit stuffing
        int onesCount = 0;
        for (byte b : frameWithCrc) {
            int val = b & 0xFF;
            for (int bit = 0; bit < 8; bit++) {
                boolean bitVal = ((val >> bit) & 1) == 1;
                bits[pos++] = bitVal;
                if (bitVal) {
                    onesCount++;
                    if (onesCount == 5) {
                        bits[pos++] = false; // stuff a zero
                        onesCount = 0;
                    }
                } else {
                    onesCount = 0;
                }
            }
        }

        // Trailer flags (no bit stuffing)
        for (int f = 0; f < trailerFlags; f++) {
            pos = appendByte(bits, pos, FLAG, false);
        }

        // Trim to actual size
        boolean[] result = new boolean[pos];
        System.arraycopy(bits, 0, result, 0, pos);
        return result;
    }

    /** Append a byte LSB-first to the bit array. Returns new position. */
    private static int appendByte(boolean[] bits, int pos, int value, boolean stuff) {
        for (int bit = 0; bit < 8; bit++) {
            bits[pos++] = ((value >> bit) & 1) == 1;
        }
        return pos;
    }

    /**
     * NRZI encode: 0-bit = toggle, 1-bit = no change.
     * Initial state is false (space) to match direwolf/standard convention.
     */
    public static boolean[] nrziEncode(boolean[] hdlcBits) {
        boolean[] tones = new boolean[hdlcBits.length];
        boolean current = false; // start with space (matches direwolf/standard convention)
        for (int i = 0; i < hdlcBits.length; i++) {
            if (!hdlcBits[i]) {
                current = !current; // 0 = toggle
            }
            // 1 = no change
            tones[i] = current; // true = mark (1200Hz), false = space (2200Hz)
        }
        return tones;
    }

    /**
     * Generate Bell 202 AFSK audio from a tone sequence.
     * Continuous-phase sine generation with fractional sample accumulator.
     *
     * @param tones true = mark (1200Hz), false = space (2200Hz)
     * @return 16-bit PCM samples at 8kHz
     */
    public static short[] modulateAfsk(boolean[] tones) {
        int totalSamples = (int) Math.ceil(tones.length * SAMPLES_PER_BIT);
        short[] pcm = new short[WARMUP_SAMPLES + totalSamples];
        // First WARMUP_SAMPLES entries are zero (silence) — lets PA ramp up
        double phase = 0.0;
        int sampleIdx = WARMUP_SAMPLES;

        for (int bitIdx = 0; bitIdx < tones.length; bitIdx++) {
            boolean isMark = tones[bitIdx];
            double freq = isMark ? MARK_FREQ : SPACE_FREQ;
            double phaseIncrement = TWO_PI * freq / SAMPLE_RATE;
            // Per-tone amplitude: compensates for module's frequency response
            double amplitude = txAmplitude * (isMark ? markAmplitudeScale : spaceAmplitudeScale);

            // Number of samples for this bit (fractional accumulator)
            double bitEnd = WARMUP_SAMPLES + (bitIdx + 1) * SAMPLES_PER_BIT;
            while (sampleIdx < bitEnd && sampleIdx < pcm.length) {
                pcm[sampleIdx] = (short) Math.max(-32767, Math.min(32767,
                    (int)(amplitude * Math.sin(phase))));
                phase += phaseIncrement;
                if (phase >= TWO_PI) phase -= TWO_PI;
                sampleIdx++;
            }
        }

        // Trim to actual sample count
        if (sampleIdx < pcm.length) {
            short[] trimmed = new short[sampleIdx];
            System.arraycopy(pcm, 0, trimmed, 0, sampleIdx);
            return trimmed;
        }
        return pcm;
    }

    /**
     * Convenience: full TX pipeline from AX.25 frame to PCM audio.
     * frame → FCS → HDLC → NRZI → AFSK
     */
    public static short[] modulateFrame(byte[] ax25Frame) {
        byte[] withFcs = frameWithFCS(ax25Frame);
        boolean[] hdlc = hdlcEncode(withFcs, PREAMBLE_FLAGS, TRAILER_FLAGS);
        boolean[] nrzi = nrziEncode(hdlc);
        return modulateAfsk(nrzi);
    }

    // ========================================================================
    // FRAME PARSING
    // ========================================================================

    /** Parsed AX.25 frame. */
    public static class ParsedFrame {
        public String srcCall;
        public int srcSsid;
        public String dstCall;
        public int dstSsid;
        public String[] digipeaters;
        public byte[] info;

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(srcCall);
            if (srcSsid != 0) sb.append('-').append(srcSsid);
            sb.append('>');
            sb.append(dstCall);
            if (dstSsid != 0) sb.append('-').append(dstSsid);
            if (digipeaters != null) {
                for (String d : digipeaters) {
                    sb.append(',').append(d);
                }
            }
            sb.append(':');
            if (info != null) sb.append(new String(info));
            return sb.toString();
        }
    }

    /** Decode a callsign from an AX.25 address field (right-shift chars, trim spaces). */
    public static String decodeCallsign(byte[] data, int offset) {
        char[] chars = new char[6];
        for (int i = 0; i < 6; i++) {
            chars[i] = (char) ((data[offset + i] & 0xFF) >> 1);
        }
        return new String(chars).trim();
    }

    /** Extract SSID from an AX.25 address SSID byte. */
    public static int decodeSsid(byte ssidByte) {
        return (ssidByte >> 1) & 0x0F;
    }

    /**
     * Parse a validated AX.25 frame (FCS already stripped).
     * Returns null if frame is too short or not a UI frame.
     */
    public static ParsedFrame parseFrame(byte[] frame) {
        // Minimum: 7 dst + 7 src + 1 control + 1 PID = 16 bytes
        if (frame == null || frame.length < 16) return null;

        ParsedFrame pf = new ParsedFrame();
        pf.dstCall = decodeCallsign(frame, 0);
        pf.dstSsid = decodeSsid(frame[6]);

        pf.srcCall = decodeCallsign(frame, 7);
        pf.srcSsid = decodeSsid(frame[13]);

        int pos = 14;

        // Check for digipeaters (extension bit = 0 means more addresses follow)
        if ((frame[13] & 0x01) == 0) {
            // Count digipeater addresses
            int digiStart = pos;
            int digiCount = 0;
            while (pos + 7 <= frame.length) {
                digiCount++;
                boolean isLast = (frame[pos + 6] & 0x01) != 0;
                pos += 7;
                if (isLast) break;
            }
            pf.digipeaters = new String[digiCount];
            for (int i = 0; i < digiCount; i++) {
                int off = digiStart + i * 7;
                String call = decodeCallsign(frame, off);
                int ssid = decodeSsid(frame[off + 6]);
                pf.digipeaters[i] = call + (ssid != 0 ? "-" + ssid : "");
            }
        }

        // Control + PID
        if (pos + 2 > frame.length) return null;
        // We accept any control/PID for flexibility, but typical is 0x03/0xF0
        pos += 2;

        // Info field
        if (pos <= frame.length) {
            pf.info = new byte[frame.length - pos];
            System.arraycopy(frame, pos, pf.info, 0, pf.info.length);
        } else {
            pf.info = new byte[0];
        }

        return pf;
    }

    // ========================================================================
    // RX PIPELINE — Demodulator
    // ========================================================================

    /** Callback for decoded AX.25 frames. */
    public interface FrameCallback {
        void onFrame(byte[] frame);
    }

    /**
     * Streaming Bell 202 AFSK demodulator.
     *
     * Uses sliding-window Goertzel-style correlation to detect mark/space
     * tones, with a simple PLL for bit clock recovery from tone transitions.
     * Then NRZI decodes, detects HDLC flags, destuffs bits, assembles bytes,
     * and validates CRC.
     *
     * Optimized for 8kHz sample rate (~6.67 samples per bit).
     */
    public static class Demodulator {
        private final FrameCallback callback;

        // Correlation window = 1 bit period
        private static final int CORR_WINDOW = (int) Math.round(SAMPLES_PER_BIT);

        // Circular sample buffer — 2x window so we can correlate without wrap issues
        private static final int BUF_SIZE = CORR_WINDOW * 2;
        private final double[] sampleBuf = new double[BUF_SIZE];
        private int bufWritePos = 0;
        private long totalSamples = 0;

        // Debug counters
        private int flagCount = 0;
        private int crcFailCount = 0;
        private int tooShortCount = 0;

        // Precomputed correlation coefficients
        private final double[] markSin = new double[CORR_WINDOW];
        private final double[] markCos = new double[CORR_WINDOW];
        private final double[] spaceSin = new double[CORR_WINDOW];
        private final double[] spaceCos = new double[CORR_WINDOW];

        // Per-sample tone detection (for PLL edge detection)
        private boolean prevTone = true; // true=mark

        // Bit clock
        private double bitClock = 0.0;    // counts up to SAMPLES_PER_BIT
        private static final double PLL_SHIFT = 0.5; // how much to nudge on transition

        // NRZI state
        private boolean lastNrziTone = true;

        // HDLC state
        private boolean inFrame = false;
        private int onesCount = 0;
        private int bitCount = 0;
        private int currentByte = 0;
        private byte[] frameBuffer = new byte[330];
        private int frameLen = 0;

        // CRC residue: crcCcitt() final XOR makes 0xF0B8 → 0x0F47
        private static final int CRC_VALID_RESIDUE = 0x0F47;

        public Demodulator(FrameCallback callback) {
            this.callback = callback;
            for (int i = 0; i < CORR_WINDOW; i++) {
                double t = TWO_PI * i / SAMPLE_RATE;
                markSin[i] = Math.sin(MARK_FREQ * t);
                markCos[i] = Math.cos(MARK_FREQ * t);
                spaceSin[i] = Math.sin(SPACE_FREQ * t);
                spaceCos[i] = Math.cos(SPACE_FREQ * t);
            }
        }

        /**
         * Feed PCM samples into the demodulator. May be called with any
         * chunk size. Decoded frames are delivered via the callback.
         */
        public void addSamples(short[] pcm, int count) {
            if (totalSamples == 0) {
                Log.i(TAG, "Demod: first samples arriving, count=" + count);
            }
            // Log peak amplitude every 800 samples (~100ms) for diagnostics
            if (totalSamples % 800 < count) {
                int peak = 0;
                for (int j = 0; j < count; j++) {
                    int abs = Math.abs(pcm[j]);
                    if (abs > peak) peak = abs;
                }
                Log.i(TAG, "Demod: samples=" + totalSamples + " peak=" + peak
                    + " flags=" + flagCount + " crcFail=" + crcFailCount
                    + " tooShort=" + tooShortCount);
            }
            for (int i = 0; i < count; i++) {
                // Store sample in circular buffer
                sampleBuf[bufWritePos] = pcm[i] / 32768.0;
                bufWritePos = (bufWritePos + 1) % BUF_SIZE;
                totalSamples++;

                // Need at least one full window before we can correlate
                if (totalSamples < CORR_WINDOW) continue;

                // Detect tone on every sample (for PLL edge tracking)
                boolean currentTone = detectTone();

                // PLL: on tone transition, nudge clock toward boundary
                if (currentTone != prevTone) {
                    // We want transitions to occur near bitClock = 0
                    // If bitClock is in first half, we're late: speed up
                    // If bitClock is in second half, we're early: slow down
                    if (bitClock < SAMPLES_PER_BIT / 2) {
                        bitClock += PLL_SHIFT;
                    } else {
                        bitClock -= PLL_SHIFT;
                    }
                    prevTone = currentTone;
                }

                // Advance bit clock
                bitClock += 1.0;
                if (bitClock >= SAMPLES_PER_BIT) {
                    bitClock -= SAMPLES_PER_BIT;
                    // Sample at bit center (we're at the end of a bit period,
                    // so the current tone detection is our decision)
                    processBit(prevTone);
                }
            }
        }

        /**
         * Correlate the most recent CORR_WINDOW samples against mark and space.
         * Returns true for mark, false for space.
         */
        private boolean detectTone() {
            double mSin = 0, mCos = 0, sSin = 0, sCos = 0;
            // The most recent CORR_WINDOW samples end at bufWritePos-1
            int start = (bufWritePos - CORR_WINDOW + BUF_SIZE) % BUF_SIZE;
            for (int i = 0; i < CORR_WINDOW; i++) {
                double s = sampleBuf[(start + i) % BUF_SIZE];
                mSin += s * markSin[i];
                mCos += s * markCos[i];
                sSin += s * spaceSin[i];
                sCos += s * spaceCos[i];
            }
            double markEnergy = mSin * mSin + mCos * mCos;
            double spaceEnergy = sSin * sSin + sCos * sCos;
            return markEnergy >= spaceEnergy;
        }

        /** Process one demodulated bit (after tone detection). */
        private void processBit(boolean isMark) {
            // NRZI decode: same tone = 1, different tone = 0
            boolean dataBit = (isMark == lastNrziTone);
            lastNrziTone = isMark;

            if (dataBit) {
                onesCount++;
                if (onesCount == 6) return; // flag preamble, wait for trailing 0
                if (onesCount >= 7) { resetFrame(); return; }
                if (inFrame) appendBit(true);
            } else {
                if (onesCount == 6) {
                    // Flag detected (01111110)
                    flagCount++;
                    if (flagCount <= 5 || flagCount % 50 == 0) {
                        Log.d(TAG, "Demod: HDLC flag #" + flagCount
                            + " inFrame=" + inFrame + " frameLen=" + frameLen);
                    }
                    if (inFrame && frameLen > 0) deliverFrame();
                    inFrame = true;
                    bitCount = 0;
                    currentByte = 0;
                    frameLen = 0;
                    onesCount = 0;
                    return;
                }
                if (onesCount == 5) {
                    onesCount = 0; // destuff
                    return;
                }
                onesCount = 0;
                if (inFrame) appendBit(false);
            }
        }

        private void appendBit(boolean bit) {
            if (bit) currentByte |= (1 << bitCount);
            bitCount++;
            if (bitCount == 8) {
                if (frameLen < frameBuffer.length) {
                    frameBuffer[frameLen++] = (byte) currentByte;
                }
                bitCount = 0;
                currentByte = 0;
            }
        }

        private void deliverFrame() {
            if (frameLen < 18) {
                Log.d(TAG, "Demod: frame too short: " + frameLen + " bytes");
                tooShortCount++;
                resetFrame();
                return;
            }
            int crc = crcCcitt(frameBuffer, 0, frameLen);
            Log.i(TAG, "Demod: candidate frame len=" + frameLen
                + " crc=0x" + String.format("%04X", crc)
                + " expect=0x" + String.format("%04X", CRC_VALID_RESIDUE));
            if (crc != CRC_VALID_RESIDUE) {
                // Log ALL bytes of failed frame for diagnostics
                StringBuilder hex = new StringBuilder();
                for (int i = 0; i < frameLen; i++) {
                    if (i > 0) hex.append(' ');
                    hex.append(String.format("%02X", frameBuffer[i] & 0xFF));
                }
                Log.w(TAG, "Demod: CRC FAIL, all bytes: " + hex);
                crcFailCount++;
                resetFrame();
                return;
            }
            Log.i(TAG, "Demod: VALID FRAME len=" + frameLen);
            byte[] frame = new byte[frameLen - 2];
            System.arraycopy(frameBuffer, 0, frame, 0, frameLen - 2);
            callback.onFrame(frame);
            resetFrame();
        }

        private void resetFrame() {
            inFrame = false;
            bitCount = 0;
            currentByte = 0;
            frameLen = 0;
            onesCount = 0;
        }
    }

    // ========================================================================
    // DIAGNOSTICS
    // ========================================================================

    /**
     * Save PCM samples as a WAV file for offline testing with Direwolf/multimon-ng.
     * Format: 8kHz, 16-bit, mono, little-endian PCM.
     */
    public static void savePcmAsWav(short[] pcm, String filePath) throws IOException {
        int dataSize = pcm.length * 2;
        byte[] header = new byte[44];
        // RIFF header
        header[0] = 'R'; header[1] = 'I'; header[2] = 'F'; header[3] = 'F';
        writeLE32(header, 4, 36 + dataSize);
        header[8] = 'W'; header[9] = 'A'; header[10] = 'V'; header[11] = 'E';
        // fmt chunk
        header[12] = 'f'; header[13] = 'm'; header[14] = 't'; header[15] = ' ';
        writeLE32(header, 16, 16);
        writeLE16(header, 20, (short) 1);  // PCM format
        writeLE16(header, 22, (short) 1);  // mono
        writeLE32(header, 24, SAMPLE_RATE);
        writeLE32(header, 28, SAMPLE_RATE * 2); // byte rate
        writeLE16(header, 32, (short) 2);  // block align
        writeLE16(header, 34, (short) 16); // bits per sample
        // data chunk
        header[36] = 'd'; header[37] = 'a'; header[38] = 't'; header[39] = 'a';
        writeLE32(header, 40, dataSize);

        FileOutputStream fos = new FileOutputStream(filePath);
        fos.write(header);
        byte[] buf = new byte[dataSize];
        for (int i = 0; i < pcm.length; i++) {
            buf[i * 2] = (byte) (pcm[i] & 0xFF);
            buf[i * 2 + 1] = (byte) ((pcm[i] >> 8) & 0xFF);
        }
        fos.write(buf);
        fos.close();
        Log.i(TAG, "Saved WAV: " + filePath + " (" + pcm.length + " samples)");
    }

    private static void writeLE16(byte[] buf, int offset, short value) {
        buf[offset] = (byte) (value & 0xFF);
        buf[offset + 1] = (byte) ((value >> 8) & 0xFF);
    }

    private static void writeLE32(byte[] buf, int offset, int value) {
        buf[offset] = (byte) (value & 0xFF);
        buf[offset + 1] = (byte) ((value >> 8) & 0xFF);
        buf[offset + 2] = (byte) ((value >> 16) & 0xFF);
        buf[offset + 3] = (byte) ((value >> 24) & 0xFF);
    }
}
