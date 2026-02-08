package com.geograms.iwi;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Minimal WAV file parser.
 * Reads PCM WAV data and converts to 8kHz 16-bit mono
 * (the format expected by the radio module's ttyS1 audio path).
 *
 * Supports: 8/16-bit PCM, mono/stereo, any sample rate (resampled to 8kHz).
 * Rejects: compressed formats (MP3, ADPCM, etc.), float WAV, >2 channels.
 */
public class WavReader {

    // RIFF chunk IDs (little-endian int representation)
    private static final int RIFF = 0x46464952;  // "RIFF"
    private static final int WAVE = 0x45564157;  // "WAVE"
    private static final int FMT  = 0x20746D66;  // "fmt "
    private static final int DATA = 0x61746164;  // "data"

    private static final int MAX_DURATION_SAMPLES = 8000 * 60;  // 60 seconds at 8kHz

    /** Result of WAV decoding. */
    public static class Result {
        public final short[] pcm;           // 8kHz mono 16-bit samples
        public final int originalSampleRate;
        public final int originalChannels;
        public final int originalBitsPerSample;

        Result(short[] pcm, int sampleRate, int channels, int bits) {
            this.pcm = pcm;
            this.originalSampleRate = sampleRate;
            this.originalChannels = channels;
            this.originalBitsPerSample = bits;
        }

        public int getDurationMs() {
            return pcm.length * 1000 / 8000;
        }
    }

    /**
     * Decode a WAV byte array to 8kHz 16-bit mono PCM.
     *
     * @param wav raw WAV file bytes
     * @return decoded result with PCM samples and original format info
     * @throws IllegalArgumentException if the file is invalid or unsupported
     */
    public static Result decode(byte[] wav) {
        if (wav.length < 44) {
            throw new IllegalArgumentException("File too small for WAV header (" + wav.length + " bytes)");
        }

        ByteBuffer bb = ByteBuffer.wrap(wav).order(ByteOrder.LITTLE_ENDIAN);

        // Validate RIFF/WAVE header
        if (bb.getInt(0) != RIFF) throw new IllegalArgumentException("Not a RIFF file");
        if (bb.getInt(8) != WAVE) throw new IllegalArgumentException("Not a WAVE file");

        // Scan for fmt and data chunks
        int pos = 12;
        int audioFormat = 0, channels = 0, sampleRate = 0, bitsPerSample = 0;
        boolean foundFmt = false;
        int dataOffset = -1, dataSize = -1;

        while (pos + 8 <= wav.length) {
            int chunkId = bb.getInt(pos);
            int chunkSize = bb.getInt(pos + 4);

            if (chunkId == FMT) {
                if (pos + 8 + 16 > wav.length) {
                    throw new IllegalArgumentException("fmt chunk truncated");
                }
                audioFormat = bb.getShort(pos + 8) & 0xFFFF;
                channels = bb.getShort(pos + 10) & 0xFFFF;
                sampleRate = bb.getInt(pos + 12);
                bitsPerSample = bb.getShort(pos + 22) & 0xFFFF;
                foundFmt = true;
            } else if (chunkId == DATA) {
                dataOffset = pos + 8;
                dataSize = chunkSize;
                break;
            }

            pos += 8 + chunkSize;
            if (chunkSize % 2 != 0) pos++;  // RIFF padding to even boundary
        }

        if (!foundFmt) throw new IllegalArgumentException("Missing fmt chunk");
        if (dataOffset < 0) throw new IllegalArgumentException("Missing data chunk");
        if (audioFormat != 1) {
            throw new IllegalArgumentException(
                "Only PCM WAV supported (got format code " + audioFormat + ")");
        }
        if (channels < 1 || channels > 2) {
            throw new IllegalArgumentException(
                "Only mono/stereo supported (got " + channels + " channels)");
        }
        if (bitsPerSample != 8 && bitsPerSample != 16) {
            throw new IllegalArgumentException(
                "Only 8/16-bit PCM supported (got " + bitsPerSample + "-bit)");
        }
        if (sampleRate < 1000 || sampleRate > 192000) {
            throw new IllegalArgumentException(
                "Unsupported sample rate: " + sampleRate + " Hz");
        }

        // Clamp data size to file bounds
        if (dataOffset + dataSize > wav.length) {
            dataSize = wav.length - dataOffset;
        }

        // Extract samples to 16-bit mono
        int bytesPerSample = bitsPerSample / 8;
        int frameSize = bytesPerSample * channels;
        int numFrames = dataSize / frameSize;
        short[] mono = new short[numFrames];

        for (int i = 0; i < numFrames; i++) {
            int offset = dataOffset + i * frameSize;
            int sum = 0;
            for (int ch = 0; ch < channels; ch++) {
                int sampleOffset = offset + ch * bytesPerSample;
                short sample;
                if (bitsPerSample == 16) {
                    sample = bb.getShort(sampleOffset);
                } else {
                    // 8-bit WAV is unsigned (128 = silence)
                    sample = (short) (((wav[sampleOffset] & 0xFF) - 128) << 8);
                }
                sum += sample;
            }
            mono[i] = (short) (sum / channels);
        }

        // Resample to 8kHz if needed
        if (sampleRate != 8000) {
            mono = resample(mono, sampleRate, 8000);
        }

        // Enforce max duration
        if (mono.length > MAX_DURATION_SAMPLES) {
            throw new IllegalArgumentException(
                "Audio too long: " + (mono.length / 8) + "ms (max 60000ms)");
        }

        return new Result(mono, sampleRate, channels, bitsPerSample);
    }

    /**
     * Linear interpolation resampling.
     * Simple but sufficient for voice/APRS quality over radio.
     */
    static short[] resample(short[] input, int fromRate, int toRate) {
        if (fromRate == toRate) return input;
        double ratio = (double) fromRate / toRate;
        int outLen = (int) (input.length / ratio);
        short[] output = new short[outLen];
        for (int i = 0; i < outLen; i++) {
            double srcIdx = i * ratio;
            int idx = (int) srcIdx;
            double frac = srcIdx - idx;
            if (idx + 1 < input.length) {
                output[i] = (short) (input[idx] * (1.0 - frac) + input[idx + 1] * frac);
            } else {
                output[i] = input[Math.min(idx, input.length - 1)];
            }
        }
        return output;
    }
}
