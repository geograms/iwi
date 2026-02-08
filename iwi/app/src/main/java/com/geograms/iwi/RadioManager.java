package com.geograms.iwi;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaRecorder;
import android.os.SystemClock;
import android.util.Log;

import com.wonder.serial.SerialPort;
import me.f1reking.serialportlib.SerialPortHelper;
import me.f1reking.serialportlib.listener.ISerialPortDataListener;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Encapsulates all radio control: power, frequency, PTT.
 * Communicates with the DMR module via two serial ports:
 *   - /dev/ttyS0 at 57600 baud: command/control protocol
 *   - /dev/ttyS1 at 230400 baud: PCM audio data during TX/RX
 */
public class RadioManager {
    private static final String TAG = "RadioManager";

    // Command serial port (ttyS0)
    private static final String SERIAL_PORT = "/dev/ttyS0";
    private static final int BAUD_RATE = 57600;
    private static final int READ_BUF_SIZE = 64;
    private static final long ACK_TIMEOUT_MS = 2000;
    private static final int INIT_MAX_RETRIES = 5;
    private static final long INIT_RETRY_INTERVAL_MS = 200;
    private static final long INIT_FIRST_TIMEOUT_MS = 4000;

    // Audio serial port (ttyS1)
    private static final String AUDIO_SERIAL_PORT = "/dev/ttyS1";
    private static final int AUDIO_BAUD_RATE = 230400;
    private static final int PCM_FRAME_SIZE = 160; // 80 samples * 2 bytes (16-bit mono 8kHz = 10ms)

    private static final String SYSFS_POWER = "/sys/devices/platform/intercom/intercom_power_control";
    private static final String SYSFS_PWD = "/sys/devices/platform/intercom/intercom_pwd_control";
    private static final String SYSFS_PTT = "/sys/devices/platform/intercom/intercom_ptt_control";

    // Command IDs
    private static final byte CMD_ANALOG = 0x23;
    private static final byte CMD_LAUNCH = 0x26;
    private static final byte CMD_INIT = 0x27;
    private static final byte CMD_VERSION = 0x34;
    private static final byte CMD_MIC_GAIN = 0x2A;
    private static final byte CMD_VOLUME = 0x2E;
    private static final byte CMD_STATUS = 0x36;
    private static final byte CMD_SPK_EN = 0x3C;

    // Response status codes
    private static final byte STATUS_SUCCESS = 0x00;
    private static final byte STATUS_FAIL = 0x01;
    private static final byte STATUS_CRC_ERROR = 0x02;

    private final SerialPort serialPort = new SerialPort();
    private int fd = -1;        // command serial fd (ttyS0)
    private SerialPortHelper audioSerial;
    private boolean powered = false;
    private long lastFreqHz = -1;

    private SerialReadThread readThread;
    private AudioTransmitThread audioTransmitThread;
    private volatile CountDownLatch initLatch;
    private volatile CountDownLatch versionLatch;
    private volatile CountDownLatch channelLatch;
    private volatile CountDownLatch transferLatch;
    private volatile CountDownLatch launchLatch;
    private volatile CountDownLatch volumeLatch;
    private volatile CountDownLatch micLatch;
    private volatile CountDownLatch spkLatch;
    private volatile int lastInitStatus = -1;
    private volatile int lastVersionStatus = -1;
    private volatile int lastChannelStatus = -1;
    private volatile int lastTransferStatus = -1;
    private volatile int lastLaunchStatus = -1;
    private volatile int lastVolumeStatus = -1;
    private volatile int lastMicStatus = -1;
    private volatile int lastSpkStatus = -1;
    private volatile int squelchLevel = 5;
    private volatile String firmwareVersion = null;
    private volatile int lastModuleStatus = -1;
    private volatile boolean rxEnabled = false;
    private volatile CountDownLatch statusLatch;
    private volatile int waitForStatus = -1;

    private volatile int volumeLevel = 8;

    // TX queue
    private static final int TX_QUEUE_CAPACITY = 50;
    private static final long CHANNEL_CLEAR_MS = 500;    // silence before TX
    private static final long CHANNEL_WAIT_TIMEOUT_MS = 30000;
    private static final long DEFAULT_FREQ_HZ = 144_800_000;  // 144.8 MHz
    private final AtomicLong txJobCounter = new AtomicLong(0);
    private final LinkedBlockingQueue<TxJob> txQueue = new LinkedBlockingQueue<>(TX_QUEUE_CAPACITY);
    private TxQueueThread txQueueThread;
    volatile long lastRxAudioTime = 0;

    // Log ring buffer (thread-safe)
    private static final int LOG_RING_SIZE = 500;
    private final String[] logRing = new String[LOG_RING_SIZE];
    private int logRingHead = 0;
    private int logRingCount = 0;

    // Received APRS packets (thread-safe via synchronized)
    private final List<ReceivedPacket> receivedPackets = new ArrayList<>();

    private LogCallback logCallback;
    private final AudioReceiver audioReceiver = new AudioReceiver();
    private AX25.Demodulator aprsDemodulator;

    public RadioManager(Context context) {
    }

    public boolean isPowered() {
        return powered;
    }

    public void setSquelchLevel(int level) {
        if (level < 0) level = 0;
        if (level > 9) level = 9;
        squelchLevel = level;
    }

    public void setLogCallback(LogCallback callback) {
        this.logCallback = callback;
    }

    // --- State getters (for API server) ---

    public String getFirmwareVersion() { return firmwareVersion; }
    public int getModuleStatus() { return lastModuleStatus; }
    public long getFrequency() { return lastFreqHz; }
    public int getSquelchLevel() { return squelchLevel; }
    public int getVolumeLevel() { return volumeLevel; }

    public String getModuleStatusText() {
        switch (lastModuleStatus) {
            case 0x01: return "idle";
            case 0x02: return "rx_end";
            case 0x03: return "tx";
            case 0x04: return "transition";
            default: return "unknown";
        }
    }

    /** Get recent log entries (newest last). */
    public List<String> getRecentLog(int maxLines) {
        synchronized (logRing) {
            int count = Math.min(maxLines, logRingCount);
            List<String> result = new ArrayList<>(count);
            int start = (logRingHead - logRingCount + LOG_RING_SIZE) % LOG_RING_SIZE;
            int skip = logRingCount - count;
            for (int i = 0; i < count; i++) {
                result.add(logRing[(start + skip + i) % LOG_RING_SIZE]);
            }
            return result;
        }
    }

    /** Received APRS packet with timestamp. */
    public static class ReceivedPacket {
        public final long time;
        public final String raw;
        public final APRS.APRSPacket parsed;

        ReceivedPacket(long time, String raw, APRS.APRSPacket parsed) {
            this.time = time;
            this.raw = raw;
            this.parsed = parsed;
        }
    }

    /** Get received APRS packets, optionally filtered by time. */
    public List<ReceivedPacket> getReceivedPackets(long sinceMs) {
        synchronized (receivedPackets) {
            if (sinceMs <= 0) return new ArrayList<>(receivedPackets);
            List<ReceivedPacket> result = new ArrayList<>();
            for (ReceivedPacket p : receivedPackets) {
                if (p.time > sinceMs) result.add(p);
            }
            return result;
        }
    }

    /** Set volume and send command if powered. */
    public void setVolume(int level, Runnable onDone) {
        if (level < 0) level = 0;
        if (level > 15) level = 15;
        volumeLevel = level;
        if (powered && fd > 0) {
            int lv = level;
            new Thread(() -> {
                volumeLatch = new CountDownLatch(1);
                lastVolumeStatus = -1;
                sendVolume(lv);
                try {
                    volumeLatch.await(ACK_TIMEOUT_MS, TimeUnit.MILLISECONDS);
                } catch (InterruptedException ignored) {}
                if (onDone != null) onDone.run();
            }, "VolumeThread").start();
        } else {
            if (onDone != null) onDone.run();
        }
    }

    /** Change frequency while powered. */
    public void setFrequency(long freqHz, PowerOnCallback callback) {
        if (!powered || fd <= 0) {
            callback.onResult(false, "Radio not powered");
            return;
        }
        new Thread(() -> {
            channelLatch = new CountDownLatch(1);
            lastChannelStatus = -1;
            setAnalogChannel(freqHz);
            try {
                if (!channelLatch.await(ACK_TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
                    callback.onResult(false, "Channel ACK timeout");
                    return;
                }
                if (lastChannelStatus != STATUS_SUCCESS) {
                    callback.onResult(false, "Channel set failed: " + statusToString((byte) lastChannelStatus));
                    return;
                }
                lastFreqHz = freqHz;
                callback.onResult(true, "Frequency set to " + freqHz + " Hz");
            } catch (InterruptedException e) {
                callback.onResult(false, "Interrupted");
            }
        }, "FreqThread").start();
    }

    // --- TX Queue ---

    /** A pending APRS transmission job. */
    public static class TxJob {
        public final long id;
        public final short[] pcm;
        public final long targetFreqHz;  // 0 = use current frequency
        public final long queuedAt;
        volatile boolean completed;
        volatile boolean success;
        volatile String resultMessage;

        TxJob(long id, short[] pcm, long targetFreqHz) {
            this.id = id;
            this.pcm = pcm;
            this.targetFreqHz = targetFreqHz;
            this.queuedAt = System.currentTimeMillis();
        }
    }

    /**
     * Enqueue a PCM transmission. Returns the job (queued) or null if queue full.
     * The queue thread handles: auto power-on, frequency switch/restore,
     * RX/TX collision avoidance, and the actual transmission.
     */
    public TxJob enqueueTx(short[] pcm, long targetFreqHz) {
        TxJob job = new TxJob(txJobCounter.incrementAndGet(), pcm, targetFreqHz);
        if (txQueue.offer(job)) {
            logMessage("TX queued: job #" + job.id + " (" + txQueue.size() + " in queue)");
            return job;
        }
        return null;
    }

    public int getTxQueueSize() {
        return txQueue.size();
    }

    /** Start the TX queue worker thread. Call once after construction. */
    public void startTxQueue() {
        if (txQueueThread == null) {
            txQueueThread = new TxQueueThread();
            txQueueThread.start();
        }
    }

    /** Stop the TX queue worker thread and release resources. */
    public void shutdown() {
        txQueue.clear();
        if (txQueueThread != null) {
            txQueueThread.stopRunning();
            try { txQueueThread.join(2000); } catch (InterruptedException ignored) {}
            txQueueThread = null;
        }
    }

    /**
     * Queue worker: processes TxJobs one at a time.
     * Handles auto power-on, frequency switching, channel-clear wait, TX, and freq restore.
     */
    private class TxQueueThread extends Thread {
        volatile boolean running = true;

        TxQueueThread() {
            super("TxQueueThread");
            setDaemon(true);
        }

        void stopRunning() {
            running = false;
            interrupt();
        }

        @Override
        public void run() {
            Log.i(TAG, "TxQueueThread started");
            logMessage("TX queue started");

            while (running && !isInterrupted()) {
                try {
                    TxJob job = txQueue.poll(1, TimeUnit.SECONDS);
                    if (job == null) continue;
                    processJob(job);
                } catch (InterruptedException e) {
                    break;
                } catch (Exception e) {
                    Log.e(TAG, "TxQueue error", e);
                    logMessage("TxQueue error: " + e.getMessage());
                }
            }
            Log.i(TAG, "TxQueueThread stopped");
        }

        private void processJob(TxJob job) {
            logMessage("TX queue: processing job #" + job.id);

            // 1. Ensure radio is powered
            if (!powered) {
                long freq = job.targetFreqHz > 0 ? job.targetFreqHz : DEFAULT_FREQ_HZ;
                logMessage("TX queue: auto power-on at " + (freq / 1_000_000.0) + " MHz");
                CountDownLatch powerLatch = new CountDownLatch(1);
                final boolean[] powerOk = {false};
                final String[] powerMsg = {""};
                powerOn(freq, (success, message) -> {
                    powerOk[0] = success;
                    powerMsg[0] = message;
                    powerLatch.countDown();
                });
                try {
                    if (!powerLatch.await(15000, TimeUnit.MILLISECONDS) || !powerOk[0]) {
                        job.success = false;
                        job.resultMessage = "Auto power-on failed: " + powerMsg[0];
                        job.completed = true;
                        logMessage("TX queue: " + job.resultMessage);
                        return;
                    }
                } catch (InterruptedException e) { return; }
            }

            // 2. Switch frequency if needed
            long originalFreqHz = lastFreqHz;
            boolean freqChanged = false;
            if (job.targetFreqHz > 0 && job.targetFreqHz != lastFreqHz) {
                logMessage("TX queue: switching to " + (job.targetFreqHz / 1_000_000.0) + " MHz");
                CountDownLatch freqLatch = new CountDownLatch(1);
                final boolean[] freqOk = {false};
                setFrequency(job.targetFreqHz, (success, message) -> {
                    freqOk[0] = success;
                    freqLatch.countDown();
                });
                try {
                    if (!freqLatch.await(5000, TimeUnit.MILLISECONDS) || !freqOk[0]) {
                        job.success = false;
                        job.resultMessage = "Frequency switch failed";
                        job.completed = true;
                        logMessage("TX queue: " + job.resultMessage);
                        return;
                    }
                    freqChanged = true;
                } catch (InterruptedException e) { return; }
            }

            // 3. Wait for channel clear (no RX audio + module idle)
            waitForChannelClear();

            // 4. Transmit
            transmitPcmSync(job.pcm);

            // 5. Restore frequency if changed
            if (freqChanged && originalFreqHz > 0) {
                logMessage("TX queue: restoring " + (originalFreqHz / 1_000_000.0) + " MHz");
                CountDownLatch restoreLatch = new CountDownLatch(1);
                setFrequency(originalFreqHz, (success, message) -> restoreLatch.countDown());
                try { restoreLatch.await(5000, TimeUnit.MILLISECONDS); }
                catch (InterruptedException ignored) {}
            }

            job.success = true;
            job.resultMessage = "Transmitted";
            job.completed = true;
            logMessage("TX queue: job #" + job.id + " complete");
        }
    }

    /**
     * Wait until channel is clear: no RX audio for CHANNEL_CLEAR_MS
     * and module status is idle. Times out after CHANNEL_WAIT_TIMEOUT_MS.
     */
    private void waitForChannelClear() {
        long sinceLastRx = SystemClock.uptimeMillis() - lastRxAudioTime;
        boolean moduleIdle = isModuleIdle();
        if (sinceLastRx > CHANNEL_CLEAR_MS && moduleIdle) {
            return; // already clear
        }

        logMessage("TX queue: waiting for channel clear...");
        long startWait = SystemClock.uptimeMillis();
        while (SystemClock.uptimeMillis() - startWait < CHANNEL_WAIT_TIMEOUT_MS) {
            try { Thread.sleep(200); } catch (InterruptedException e) { return; }
            sinceLastRx = SystemClock.uptimeMillis() - lastRxAudioTime;
            moduleIdle = isModuleIdle();
            if (sinceLastRx > CHANNEL_CLEAR_MS && moduleIdle) {
                logMessage("TX queue: channel clear after " +
                    (SystemClock.uptimeMillis() - startWait) + "ms");
                return;
            }
        }
        logMessage("TX queue: channel wait timeout, transmitting anyway");
    }

    /** Module is idle for TX purposes: idle(1), rx_end(2), or unknown(-1). */
    private boolean isModuleIdle() {
        int s = lastModuleStatus;
        return s == 0x01 || s == 0x02 || s == -1;
    }

    /**
     * Synchronous PCM transmit (called from queue thread).
     * Handles PTT toggle, status wait, frame pacing, cleanup.
     */
    private void transmitPcmSync(short[] pcm) {
        if (!powered || audioSerial == null) {
            logMessage("transmitPcmSync: not powered");
            return;
        }

        logMessage("=== APRS TX (queued) ===");
        statusLatch = new CountDownLatch(1);
        waitForStatus = 0x03;
        sendSpeakerEnable(false);
        writeSysfs(SYSFS_PTT, false);
        logMessage("PTT GPIO LOW (TX)");

        try {
            if (statusLatch.await(ACK_TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
                logMessage("Module confirmed TX");
            } else {
                logMessage("TX status timeout, proceeding");
            }
        } catch (InterruptedException ignored) {}

        try {
            byte[] frame = new byte[PCM_FRAME_SIZE];
            int sampleIdx = 0;
            int frameCount = 0;
            long lastSendTime = SystemClock.uptimeMillis();

            while (sampleIdx < pcm.length) {
                int samplesInFrame = Math.min(PCM_FRAME_SIZE / 2, pcm.length - sampleIdx);
                for (int i = 0; i < samplesInFrame; i++) {
                    int idx = i * 2;
                    frame[idx] = (byte) (pcm[sampleIdx + i] & 0xFF);
                    frame[idx + 1] = (byte) ((pcm[sampleIdx + i] >> 8) & 0xFF);
                }
                for (int z = samplesInFrame * 2; z < PCM_FRAME_SIZE; z++) {
                    frame[z] = 0;
                }
                while (SystemClock.uptimeMillis() - lastSendTime < 10) { }
                lastSendTime = SystemClock.uptimeMillis();
                audioSerial.sendBytes(Arrays.copyOf(frame, PCM_FRAME_SIZE));
                sampleIdx += samplesInFrame;
                frameCount++;
            }
            logMessage("APRS TX: " + frameCount + " frames (" + pcm.length + " samples)");
        } catch (Exception e) {
            Log.e(TAG, "APRS TX error", e);
            logMessage("APRS TX error: " + e.getMessage());
        } finally {
            writeSysfs(SYSFS_PTT, true);
            logMessage("PTT GPIO HIGH (idle)");
            try { Thread.sleep(300); } catch (InterruptedException ignored) {}
            sendSpeakerEnable(true);
        }
    }

    // --- Serial Read Thread (ttyS0 command responses) ---

    private class SerialReadThread extends Thread {
        private volatile boolean running = true;

        SerialReadThread() {
            super("SerialReadThread");
            setDaemon(true);
        }

        void stopRunning() {
            running = false;
            interrupt();
        }

        @Override
        public void run() {
            byte[] buf = new byte[READ_BUF_SIZE];
            Log.i(TAG, "SerialReadThread started");
            logMessage("Read thread started");

            while (running && !isInterrupted()) {
                try {
                    if (fd <= 0) {
                        Thread.sleep(100);
                        continue;
                    }
                    int bytesRead = serialPort.readData(fd, buf);
                    if (bytesRead > 0) {
                        byte[] data = Arrays.copyOf(buf, bytesRead);
                        String hex = bytesToHex(data);
                        Log.i(TAG, "RX [" + bytesRead + "]: " + hex);
                        logMessage("RX: " + hex);
                        handleResponse(data);
                    } else {
                        Thread.sleep(10);
                    }
                } catch (InterruptedException e) {
                    break;
                } catch (Exception e) {
                    Log.e(TAG, "Read thread error", e);
                    logMessage("Read error: " + e.getMessage());
                }
            }
            Log.i(TAG, "SerialReadThread stopped");
            logMessage("Read thread stopped");
        }
    }

    // --- Audio Transmit Thread (mic -> ttyS1 during PTT) ---

    private class AudioTransmitThread extends Thread {
        private volatile boolean running = true;

        AudioTransmitThread() {
            super("AudioTransmitThread");
            setDaemon(true);
        }

        void stopRunning() {
            running = false;
            interrupt();
        }

        @Override
        public void run() {
            AudioRecord recorder = null;
            try {
                int sampleRate = 8000;

                recorder = new AudioRecord(MediaRecorder.AudioSource.MIC,
                    sampleRate, AudioFormat.CHANNEL_IN_MONO,
                    AudioFormat.ENCODING_PCM_16BIT, PCM_FRAME_SIZE);
                recorder.startRecording();
                Log.i(TAG, "AudioTransmitThread started, reading mic → ttyS1 (raw)");
                logMessage("Audio TX: mic → ttyS1 (raw PCM)");

                byte[] pcmBuf = new byte[PCM_FRAME_SIZE];
                int frameCount = 0;
                long lastSendTime = SystemClock.uptimeMillis();

                while (running && !isInterrupted()) {
                    int read = recorder.read(pcmBuf, 0, PCM_FRAME_SIZE);
                    if (read == PCM_FRAME_SIZE && audioSerial != null) {
                        // Busy-wait: ensure minimum 10ms between sends (stock app pacing)
                        while (SystemClock.uptimeMillis() - lastSendTime < 10) { }
                        lastSendTime = SystemClock.uptimeMillis();
                        audioSerial.sendBytes(Arrays.copyOf(pcmBuf, PCM_FRAME_SIZE));
                        frameCount++;
                        if (frameCount % 100 == 0) {
                            Log.d(TAG, "Audio TX: " + frameCount + " frames sent");
                        }
                    } else if (read < 0) {
                        Log.e(TAG, "AudioRecord read error: " + read);
                        break;
                    }
                }
            } catch (Exception e) {
                Log.e(TAG, "AudioTransmitThread error", e);
                logMessage("Audio TX error: " + e.getMessage());
            } finally {
                if (recorder != null) {
                    try {
                        recorder.stop();
                        recorder.release();
                    } catch (Exception e) {
                        Log.w(TAG, "AudioRecord cleanup error", e);
                    }
                }
                Log.i(TAG, "AudioTransmitThread stopped");
                logMessage("Audio TX stopped");
            }
        }
    }

    // --- Audio Receive (ttyS1) — speaker + APRS demodulator in parallel ---
    private class AudioReceiver {
        private final byte[] pcmBuf = new byte[PCM_FRAME_SIZE];
        private final short[] sampleBuf = new short[PCM_FRAME_SIZE / 2]; // 80 samples
        private final ByteArrayOutputStream rxBuffer = new ByteArrayOutputStream();
        private AudioTrack track;
        private int rxFrameCount = 0;

        synchronized void startIfNeeded() {
            if (track != null) return;
            int minBuf = AudioTrack.getMinBufferSize(8000,
                AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT);
            int bufSize = Math.max(minBuf, 16384);
            track = new AudioTrack(
                new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build(),
                new AudioFormat.Builder()
                    .setSampleRate(8000)
                    .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
                    .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                    .build(),
                bufSize,
                AudioTrack.MODE_STREAM,
                AudioManager.AUDIO_SESSION_ID_GENERATE);
            track.play();
            Log.i(TAG, "AudioReceiver started");
            logMessage("Audio RX: ttyS1 → speaker");
        }

        synchronized void stop() {
            if (track != null) {
                try {
                    track.stop();
                    track.release();
                } catch (Exception ignored) {}
                track = null;
            }
            rxBuffer.reset();
            rxFrameCount = 0;
        }

        void handleIncoming(byte[] data) {
            synchronized (this) {
                try {
                    rxBuffer.write(data);
                    byte[] buf = rxBuffer.toByteArray();
                    int idx = 0;
                    while (idx < buf.length) {
                        int start = -1;
                        for (int i = idx; i < buf.length; i++) {
                            if ((buf[i] & 0xFF) == 0xBB) {
                                start = i;
                                break;
                            }
                        }
                        if (start == -1 || buf.length - start < 167) {
                            // Not enough for a full frame yet
                            break;
                        }
                        if ((buf[start + 1] & 0xFF) == 0x00 && (buf[start + 166] & 0xFF) == 0x44) {
                            System.arraycopy(buf, start + 6, pcmBuf, 0, PCM_FRAME_SIZE);

                            // Play through speaker
                            startIfNeeded();
                            if (track != null) {
                                track.write(pcmBuf, 0, PCM_FRAME_SIZE);
                            }

                            // Feed APRS demodulator in parallel
                            if (aprsDemodulator != null) {
                                for (int s = 0; s < 80; s++) {
                                    sampleBuf[s] = (short) ((pcmBuf[s * 2] & 0xFF) |
                                                            (pcmBuf[s * 2 + 1] << 8));
                                }
                                aprsDemodulator.addSamples(sampleBuf, 80);
                            }

                            lastRxAudioTime = SystemClock.uptimeMillis();
                            rxFrameCount++;
                            if (rxFrameCount == 1) {
                                Log.i(TAG, "RX audio: first frame received");
                                logMessage("RX audio: first frame received");
                            } else if (rxFrameCount % 10 == 0) {
                                Log.i(TAG, "RX audio: " + rxFrameCount + " frames played");
                            }
                            if (rxFrameCount % 50 == 0) {
                                logMessage("RX audio: " + rxFrameCount + " frames");
                            }
                            idx = start + 167;
                        } else {
                            idx = start + 1;
                        }
                    }
                    // keep leftover
                    byte[] remaining = Arrays.copyOfRange(buf, idx, buf.length);
                    rxBuffer.reset();
                    rxBuffer.write(remaining);
                } catch (Exception e) {
                    Log.e(TAG, "AudioReceiver error", e);
                    rxBuffer.reset();
                }
            }
        }
    }

    // --- Response Handling ---

    private void handleResponse(byte[] data) {
        if (data.length < 4) {
            Log.w(TAG, "Response too short: " + data.length + " bytes");
            logMessage("Response too short: " + data.length + " bytes");
            return;
        }

        if (data[0] != 0x68) {
            Log.d(TAG, "Ignoring non-protocol data");
            return;
        }

        byte cmdId = data[1];
        byte status = data[3];
        String statusStr = statusToString(status);

        switch (cmdId) {
            case CMD_INIT: // 0x27
                Log.i(TAG, "Init response: status=" + statusStr);
                logMessage("Init ACK: " + statusStr);
                lastInitStatus = status;
                if (initLatch != null) initLatch.countDown();
                break;

            case CMD_ANALOG: // 0x23
                Log.i(TAG, "Analog channel response: status=" + statusStr);
                logMessage("Channel ACK: " + statusStr);
                lastChannelStatus = status;
                if (channelLatch != null) channelLatch.countDown();
                break;

            case CMD_LAUNCH: // 0x26
                Log.i(TAG, "Launch response: status=" + statusStr);
                logMessage("Launch ACK: " + statusStr);
                lastLaunchStatus = status;
                if (launchLatch != null) launchLatch.countDown();
                break;

            case CMD_VERSION: // 0x34
                Log.i(TAG, "Version response: status=" + statusStr);
                lastVersionStatus = status;
                if (status == STATUS_SUCCESS && data.length >= 8) {
                    int payloadLen = ((data[6] & 0xFF) << 8) | (data[7] & 0xFF);
                    if (data.length >= 8 + payloadLen) {
                        firmwareVersion = new String(data, 8, payloadLen).trim();
                        Log.i(TAG, "Firmware version: " + firmwareVersion);
                        logMessage("Firmware: " + firmwareVersion);
                    }
                }
                if (versionLatch != null) versionLatch.countDown();
                break;

            case CMD_MIC_GAIN: // 0x2A
                Log.i(TAG, "MicGain response: status=" + statusStr);
                lastMicStatus = status;
                if (micLatch != null) micLatch.countDown();
                break;

            case CMD_VOLUME: // 0x2E
                Log.i(TAG, "Volume response: status=" + statusStr);
                lastVolumeStatus = status;
                if (volumeLatch != null) volumeLatch.countDown();
                break;

            case CMD_SPK_EN: // 0x3C
                Log.i(TAG, "Speaker response: status=" + statusStr);
                lastSpkStatus = status;
                if (spkLatch != null) spkLatch.countDown();
                break;

            case 0x35: // setTransferInterrupt
                Log.i(TAG, "TransferInterrupt response: status=" + statusStr);
                lastTransferStatus = status;
                if (transferLatch != null) transferLatch.countDown();
                break;

            case CMD_STATUS: { // 0x36 status beacon
                int moduleStatus = (data.length > 8) ? (data[8] & 0xFF) : -1;
                if (moduleStatus != lastModuleStatus) {
                    String desc;
                    switch (moduleStatus) {
                        case 0x01: desc = "Idle"; break;
                        case 0x02: desc = "RX-end"; break;
                        case 0x03: desc = "TX"; break;
                        case 0x04: desc = "Transition"; break;
                        default: desc = "0x" + String.format("%02X", moduleStatus); break;
                    }
                    Log.i(TAG, "Module status: " + desc);
                    logMessage("Status: " + desc);
                    lastModuleStatus = moduleStatus;
                }
                // Signal anyone waiting for a specific module status
                if (moduleStatus == waitForStatus && statusLatch != null) {
                    statusLatch.countDown();
                }
                break;
            }

            default:
                Log.d(TAG, "Unknown command response: 0x" + String.format("%02X", cmdId));
                logMessage("Unknown CMD: 0x" + String.format("%02X", cmdId));
                break;
        }
    }

    private String statusToString(byte status) {
        switch (status) {
            case STATUS_SUCCESS: return "SUCCESS";
            case STATUS_FAIL: return "FAIL";
            case STATUS_CRC_ERROR: return "CRC_ERROR";
            default: return "UNKNOWN(0x" + String.format("%02X", status) + ")";
        }
    }

    // --- Power On ---

    public void powerOn(long freqHz, PowerOnCallback callback) {
        new Thread(() -> {
            try {
                Log.i(TAG, "Power on sequence starting...");
                logMessage("=== Power On ===");

                // 1. Reset all sysfs to 0
                writeSysfs(SYSFS_POWER, false);
                writeSysfs(SYSFS_PWD, false);
                writeSysfs(SYSFS_PTT, false);

                // 2. Wait 200ms
                Thread.sleep(200);

                // 3. Open command serial port (ttyS0)
                fd = serialPort.open(SERIAL_PORT, BAUD_RATE);
                if (fd <= 0) {
                    Log.e(TAG, "Failed to open serial port, fd=" + fd);
                    logMessage("Serial open FAILED fd=" + fd);
                    callback.onResult(false, "Serial port open failed (fd=" + fd + ")");
                    return;
                }
                logMessage("ttyS0 opened fd=" + fd);

        // 4. Open audio serial port (ttyS1) via libserialport
                audioSerial = new SerialPortHelper();
                audioSerial.setPort(AUDIO_SERIAL_PORT);
                audioSerial.setBaudRate(AUDIO_BAUD_RATE);
                audioSerial.setDataBits(8);
                audioSerial.setStopBits(1);
                audioSerial.setParity(0);
                audioSerial.setFlowCon(0);
                audioSerial.setFlags(0);
                audioSerial.setISerialPortDataListener(new ISerialPortDataListener() {
                    @Override
                    public void onDataReceived(byte[] bytes) {
                        if (rxEnabled) {
                            audioReceiver.handleIncoming(bytes);
                        }
                    }

                    @Override
                    public void onDataSend(byte[] bytes) {
                        // no-op
                    }
                });
                if (!audioSerial.open()) {
                    Log.e(TAG, "Failed to open audio serial port (PCM)");
                    logMessage("ttyS1 open FAILED (PCM)");
                    callback.onResult(false, "Audio serial port open failed (PCM)");
                    serialPort.close(fd);
                    fd = -1;
            return;
        }
        logMessage("ttyS1 (PCM) opened");

                // 5. Start command read thread
                readThread = new SerialReadThread();
                readThread.start();

                // 6. Set all sysfs controls HIGH (required for module boot)
                writeSysfs(SYSFS_POWER, true);
                writeSysfs(SYSFS_PWD, true);
                writeSysfs(SYSFS_PTT, true);

                // 7. Brief wait before init check (boot time absorbed by latch timeout)
                Thread.sleep(50);

                // 8. Send checkInitComplete: first attempt waits up to 2s (covers module boot),
                //    retries use short 200ms window (response was likely lost)
                boolean initOk = false;
                for (int attempt = 1; attempt <= INIT_MAX_RETRIES; attempt++) {
                    initLatch = new CountDownLatch(1);
                    lastInitStatus = -1;
                    sendCheckInitComplete();
                    logMessage("Init check " + attempt + "/" + INIT_MAX_RETRIES + "...");

                    long timeout = (attempt == 1) ? INIT_FIRST_TIMEOUT_MS : INIT_RETRY_INTERVAL_MS;
                    if (initLatch.await(timeout, TimeUnit.MILLISECONDS)) {
                        if (lastInitStatus == STATUS_SUCCESS) {
                            logMessage("Init OK on attempt " + attempt);
                            initOk = true;
                            break;
                        } else {
                            logMessage("Init attempt " + attempt + ": " + statusToString((byte) lastInitStatus));
                        }
                    }
                }
                if (!initOk) {
                    String msg = lastInitStatus == -1
                        ? "Module init timeout (no response after " + INIT_MAX_RETRIES + " attempts)"
                        : "Init failed: " + statusToString((byte) lastInitStatus);
                    Log.e(TAG, msg);
                    logMessage(msg);
                    callback.onResult(false, msg);
                    stopReadThread();
                    return;
                }

                // 9. Get firmware version and wait for response
                versionLatch = new CountDownLatch(1);
                lastVersionStatus = -1;
                sendGetVersion();
                logMessage("Waiting for version ACK...");

                if (!versionLatch.await(ACK_TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
                    logMessage("Version ACK timeout (non-fatal, continuing)");
                } else {
                    logMessage("Version: " + (firmwareVersion != null ? firmwareVersion : "unknown"));
                }

                // 10. Set analog channel and wait for ACK
                channelLatch = new CountDownLatch(1);
                lastChannelStatus = -1;
                setAnalogChannel(freqHz);
                logMessage("Waiting for channel ACK...");

                if (!channelLatch.await(ACK_TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
                    Log.e(TAG, "Channel ACK timeout");
                    logMessage("Channel ACK TIMEOUT");
                    callback.onResult(false, "Channel set timeout (no response to CMD 0x23)");
                    stopReadThread();
                    return;
                }
                if (lastChannelStatus != STATUS_SUCCESS) {
                    String msg = "Channel set failed: " + statusToString((byte) lastChannelStatus);
                    Log.e(TAG, msg);
                    logMessage(msg);
                    callback.onResult(false, msg);
                    stopReadThread();
                    return;
                }

                // 11. Set transfer interrupt (mode 3 matches stock app) and wait for ACK (non-fatal)
                transferLatch = new CountDownLatch(1);
                lastTransferStatus = -1;
                sendTransferInterrupt(3);
                logMessage("Waiting for transfer-interrupt ACK...");
                if (!transferLatch.await(ACK_TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
                    logMessage("Transfer-interrupt ACK timeout (continuing)");
                } else if (lastTransferStatus != STATUS_SUCCESS) {
                    logMessage("Transfer-interrupt set failed: " + statusToString((byte) lastTransferStatus) + " (continuing)");
                }

                // 12. Set mic gain to mid (10) and volume to 8 (non-fatal)
                micLatch = new CountDownLatch(1);
                lastMicStatus = -1;
                sendMicGain(10);
                if (!micLatch.await(ACK_TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
                    logMessage("MicGain ACK timeout (continuing)");
                } else if (lastMicStatus != STATUS_SUCCESS) {
                    logMessage("MicGain set failed: " + statusToString((byte) lastMicStatus));
                }

                volumeLatch = new CountDownLatch(1);
                lastVolumeStatus = -1;
                volumeLevel = 8;
                sendVolume(8);
                if (!volumeLatch.await(ACK_TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
                    logMessage("Volume ACK timeout (continuing)");
                } else if (lastVolumeStatus != STATUS_SUCCESS) {
                    logMessage("Volume set failed: " + statusToString((byte) lastVolumeStatus));
                }

                // Ensure speaker is enabled for RX by default
                spkLatch = new CountDownLatch(1);
                lastSpkStatus = -1;
                sendSpeakerEnable(true);
                if (!spkLatch.await(ACK_TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
                    logMessage("Speaker ACK timeout (continuing)");
                } else if (lastSpkStatus != STATUS_SUCCESS) {
                    logMessage("Speaker set failed: " + statusToString((byte) lastSpkStatus));
                }

                // PTT GPIO is HIGH from boot = idle/RX mode (stock app never calls launchCommand here)

                aprsDemodulator = APRS.createDemodulator(packet -> {
                    Log.i(TAG, "APRS RX: " + packet.toString());
                    logMessage("APRS: " + packet.toString());
                    synchronized (receivedPackets) {
                        receivedPackets.add(new ReceivedPacket(
                            System.currentTimeMillis(), packet.toString(), packet));
                    }
                });

                // Self-test: feed a synthetic APRS packet to verify demodulator pipeline
                {
                    byte[] testFrame = APRS.buildStatusPacket("TEST", 7, "loopback");
                    short[] testPcm = AX25.modulateFrame(testFrame);
                    Log.i(TAG, "Demod self-test: feeding " + testPcm.length + " samples");
                    logMessage("Demod self-test: " + testPcm.length + " samples");
                    int offset = 0;
                    while (offset < testPcm.length) {
                        int chunk = Math.min(80, testPcm.length - offset);
                        short[] buf = new short[chunk];
                        System.arraycopy(testPcm, offset, buf, 0, chunk);
                        aprsDemodulator.addSamples(buf, chunk);
                        offset += chunk;
                    }
                }

                powered = true;
                rxEnabled = true;
                lastFreqHz = freqHz;
                Log.i(TAG, "Power on complete, freq=" + freqHz + " Hz");
                logMessage("Power on OK, freq=" + freqHz + " Hz");
                callback.onResult(true, "Radio powered on");

            } catch (Exception e) {
                Log.e(TAG, "Power on failed", e);
                logMessage("Power on EXCEPTION: " + e.getMessage());
                callback.onResult(false, "Power on failed: " + e.getMessage());
            }
        }).start();
    }

    // --- Power Off ---

    public void powerOff() {
        Log.i(TAG, "Power off...");
        logMessage("=== Power Off ===");

        int dropped = txQueue.size();
        txQueue.clear();
        if (dropped > 0) logMessage("TX queue: dropped " + dropped + " pending jobs");

        rxEnabled = false;
        stopAudioTransmit();
        stopReadThread();
        audioReceiver.stop();

        writeSysfs(SYSFS_POWER, false);
        writeSysfs(SYSFS_PWD, false);
        writeSysfs(SYSFS_PTT, false);

        if (audioSerial != null) {
            try {
                audioSerial.close();
            } catch (Exception ignored) {}
            audioSerial = null;
        }
        if (fd > 0) {
            serialPort.close(fd);
            fd = -1;
        }

        powered = false;
        Log.i(TAG, "Power off complete");
        logMessage("Power off complete");
    }

    // --- PTT ---

    public void startTx() {
        if (!powered || fd <= 0) return;
        Log.i(TAG, "PTT press (TX start)");
        logMessage("PTT DOWN");

        sendSpeakerEnable(false);

        // Set up wait for module status 3 (TX ready) BEFORE toggling GPIO
        statusLatch = new CountDownLatch(1);
        waitForStatus = 0x03;

        // Toggle PTT GPIO LOW to enter TX mode (stock app behavior)
        writeSysfs(SYSFS_PTT, false);
        logMessage("PTT GPIO LOW (TX)");

        // Wait for module to confirm TX mode before starting audio
        new Thread(() -> {
            try {
                if (statusLatch.await(ACK_TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
                    logMessage("Module confirmed TX (status 3)");
                } else {
                    logMessage("TX status timeout, starting audio anyway");
                }
            } catch (InterruptedException ignored) {}
            startAudioTransmit();
        }, "TxStartThread").start();
    }

    public void stopTx() {
        if (!powered || fd <= 0) return;
        Log.i(TAG, "PTT release (TX stop)");
        logMessage("PTT UP");

        // Toggle PTT GPIO HIGH to exit TX mode (stock app behavior)
        writeSysfs(SYSFS_PTT, true);
        logMessage("PTT GPIO HIGH (idle)");

        // Delay 300ms then stop audio (matches stock app timing)
        new Thread(() -> {
            try { Thread.sleep(300); } catch (InterruptedException ignored) {}
            stopAudioTransmit();
            sendSpeakerEnable(true);
            logMessage("Audio TX cleanup done");
        }, "TxStopThread").start();
    }

    /**
     * Send a sequence of synthesized DTMF-like beeps over ttyS1 without using the mic.
     * The stock app pushes raw 160-byte PCM frames every ~10 ms with no extra framing.
     * Useful for automated bench tests.
     */
    public void sendToneBeepSequence(int count, int toneMs, int gapMs, Runnable onComplete) {
        new Thread(() -> {
            if (!powered || audioSerial == null) {
                logMessage("Cannot send tones: radio not powered");
                Log.w(TAG, "Tone sequence aborted: not powered or audioSerial null");
                if (onComplete != null) onComplete.run();
                return;
            }

            // DTMF-ish pair (941 Hz + 1336 Hz)
            final int sampleRate = 8000;
            final double f1 = 941.0;
            final double f2 = 1336.0;
            final double step1 = 2.0 * Math.PI * f1 / sampleRate;
            final double step2 = 2.0 * Math.PI * f2 / sampleRate;
            final short amplitude = 20000;

            byte[] pcmFrame = new byte[PCM_FRAME_SIZE];
            int frameCounter = 0;

            logMessage("=== Auto TX: beeps x" + count + " ===");
            Log.i(TAG, "Tone sequence start: count=" + count + ", toneMs=" + toneMs + ", gapMs=" + gapMs);
            // Toggle PTT GPIO LOW to enter TX mode
            statusLatch = new CountDownLatch(1);
            waitForStatus = 0x03;
            writeSysfs(SYSFS_PTT, false);
            logMessage("PTT GPIO LOW (TX for tones)");
            try {
                if (statusLatch.await(ACK_TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
                    logMessage("Module confirmed TX for tones");
                } else {
                    logMessage("TX status timeout for tones, proceeding anyway");
                }
            } catch (InterruptedException ignored) {}

            try {
                long lastSendTime = SystemClock.uptimeMillis();
                for (int i = 0; i < count; i++) {
                    double phase1 = 0.0;
                    double phase2 = 0.0;
                    int samples = (toneMs * sampleRate) / 1000;
                    for (int s = 0; s < samples; s += (PCM_FRAME_SIZE / 2)) {
                        int frameSamples = Math.min(PCM_FRAME_SIZE / 2, samples - s);
                        for (int n = 0; n < frameSamples; n++) {
                            short sample = (short) ((Math.sin(phase1) + Math.sin(phase2)) * amplitude * 0.5);
                            int idx = n * 2;
                            pcmFrame[idx] = (byte) (sample & 0xFF);
                            pcmFrame[idx + 1] = (byte) ((sample >> 8) & 0xFF);
                            phase1 += step1;
                            phase2 += step2;
                        }
                        // If the last frame is shorter, zero-fill the remainder
                        if (frameSamples * 2 < PCM_FRAME_SIZE) {
                            for (int z = frameSamples * 2; z < PCM_FRAME_SIZE; z++) {
                                pcmFrame[z] = 0;
                            }
                        }
                        // Busy-wait: ensure minimum 10ms between sends (stock app pacing)
                        while (SystemClock.uptimeMillis() - lastSendTime < 10) { }
                        lastSendTime = SystemClock.uptimeMillis();
                        audioSerial.sendBytes(Arrays.copyOf(pcmFrame, PCM_FRAME_SIZE));
                        frameCounter++;
                    }

                    // Gap (silence)
                    int gapSamples = (gapMs * sampleRate) / 1000;
                    int gapFrames = (gapSamples + (PCM_FRAME_SIZE / 2) - 1) / (PCM_FRAME_SIZE / 2);
                    Arrays.fill(pcmFrame, (byte) 0);
                    for (int g = 0; g < gapFrames; g++) {
                        // Busy-wait for gap frames too
                        while (SystemClock.uptimeMillis() - lastSendTime < 10) { }
                        lastSendTime = SystemClock.uptimeMillis();
                        audioSerial.sendBytes(Arrays.copyOf(pcmFrame, PCM_FRAME_SIZE));
                        frameCounter++;
                    }
                    logMessage("Sent beep " + (i + 1) + "/" + count);
                    Log.d(TAG, "Tone " + (i + 1) + "/" + count + " sent");
                }
                Log.i(TAG, "Tone sequence frames sent: " + frameCounter);
            } catch (Exception e) {
                Log.e(TAG, "Tone sequence error", e);
                logMessage("Tone error: " + e.getMessage());
            } finally {
                // Toggle PTT GPIO HIGH to exit TX mode
                writeSysfs(SYSFS_PTT, true);
                logMessage("PTT GPIO HIGH (idle after tones)");
                try { Thread.sleep(300); } catch (InterruptedException ignored) {}
                Log.i(TAG, "Tone sequence complete");
                if (onComplete != null) onComplete.run();
            }
        }, "ToneBeepThread").start();
    }

    /**
     * Transmit pre-generated PCM audio (e.g. APRS AFSK) over the air.
     * Handles PTT, status wait, frame pacing, and cleanup.
     */
    public void sendPcmFrames(short[] pcm, Runnable onComplete) {
        new Thread(() -> {
            if (!powered || audioSerial == null) {
                logMessage("Cannot send PCM: radio not powered");
                if (onComplete != null) onComplete.run();
                return;
            }

            logMessage("=== APRS TX ===");
            // Toggle PTT GPIO LOW to enter TX mode
            statusLatch = new CountDownLatch(1);
            waitForStatus = 0x03;
            sendSpeakerEnable(false);
            writeSysfs(SYSFS_PTT, false);
            logMessage("PTT GPIO LOW (TX for APRS)");
            try {
                if (statusLatch.await(ACK_TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
                    logMessage("Module confirmed TX for APRS");
                } else {
                    logMessage("TX status timeout for APRS, proceeding anyway");
                }
            } catch (InterruptedException ignored) {}

            try {
                byte[] frame = new byte[PCM_FRAME_SIZE];
                int sampleIdx = 0;
                int frameCount = 0;
                long lastSendTime = SystemClock.uptimeMillis();

                while (sampleIdx < pcm.length) {
                    int samplesInFrame = Math.min(PCM_FRAME_SIZE / 2, pcm.length - sampleIdx);
                    for (int i = 0; i < samplesInFrame; i++) {
                        int idx = i * 2;
                        frame[idx] = (byte) (pcm[sampleIdx + i] & 0xFF);
                        frame[idx + 1] = (byte) ((pcm[sampleIdx + i] >> 8) & 0xFF);
                    }
                    // Zero-fill if last frame is short
                    for (int z = samplesInFrame * 2; z < PCM_FRAME_SIZE; z++) {
                        frame[z] = 0;
                    }
                    // Busy-wait pacing
                    while (SystemClock.uptimeMillis() - lastSendTime < 10) { }
                    lastSendTime = SystemClock.uptimeMillis();
                    audioSerial.sendBytes(Arrays.copyOf(frame, PCM_FRAME_SIZE));
                    sampleIdx += samplesInFrame;
                    frameCount++;
                }
                logMessage("APRS TX: " + frameCount + " frames sent (" + pcm.length + " samples)");
            } catch (Exception e) {
                Log.e(TAG, "APRS TX error", e);
                logMessage("APRS TX error: " + e.getMessage());
            } finally {
                writeSysfs(SYSFS_PTT, true);
                logMessage("PTT GPIO HIGH (idle after APRS)");
                try { Thread.sleep(300); } catch (InterruptedException ignored) {}
                sendSpeakerEnable(true);
                if (onComplete != null) onComplete.run();
            }
        }, "AprsTxThread").start();
    }

    private void startAudioTransmit() {
        if (audioSerial == null) {
            Log.w(TAG, "Cannot start audio TX, ttyS1 not open");
            logMessage("WARN: ttyS1 not open for audio");
            return;
        }
        audioTransmitThread = new AudioTransmitThread();
        audioTransmitThread.start();
    }

    private void stopAudioTransmit() {
        if (audioTransmitThread != null) {
            audioTransmitThread.stopRunning();
            try {
                audioTransmitThread.join(500);
            } catch (InterruptedException ignored) {}
            audioTransmitThread = null;
        }
    }

    // --- Set Analog Channel (CMD 0x23) ---

    public void setAnalogChannel(long freqHz) {
        int freq = (int) freqHz;
        byte[] cmd = new byte[28];

        cmd[0] = 0x68;         // header
        cmd[1] = CMD_ANALOG;   // CMD: set analog
        cmd[2] = 0x01;
        cmd[3] = 0x01;
        cmd[4] = 0x00;         // CRC hi (placeholder)
        cmd[5] = 0x00;         // CRC lo (placeholder)
        cmd[6] = 0x00;         // length hi
        cmd[7] = 0x13;         // length lo = 19 bytes payload

        // RX frequency (little-endian)
        cmd[8]  = (byte) (freq & 0xFF);
        cmd[9]  = (byte) ((freq >> 8) & 0xFF);
        cmd[10] = (byte) ((freq >> 16) & 0xFF);
        cmd[11] = (byte) ((freq >> 24) & 0xFF);

        // TX frequency (same as RX for simplex)
        cmd[12] = (byte) (freq & 0xFF);
        cmd[13] = (byte) ((freq >> 8) & 0xFF);
        cmd[14] = (byte) ((freq >> 16) & 0xFF);
        cmd[15] = (byte) ((freq >> 24) & 0xFF);

        cmd[16] = 0x00;        // band: 0 = UHF
        cmd[17] = 0x01;        // power: 1 = high
        cmd[18] = (byte) squelchLevel;        // squelch level
        cmd[19] = 0x00;        // rx_type: 0 = no CTCSS/DCS
        cmd[20] = 0x00;        // rx_subcode
        cmd[21] = 0x00;        // tx_type
        cmd[22] = 0x00;        // tx_subcode
        cmd[23] = 0x02;        // pwrsave: 2 (stock default)
        cmd[24] = 0x08;        // volume: 8 (mid)
        cmd[25] = 0x02;        // monitor: 2 (stock default)
        cmd[26] = 0x02;        // relay: 2 (stock default)
        cmd[27] = 0x10;        // footer

        // Compute and insert CRC
        byte[] crc = CRC.checkSumBytes(cmd, 28);
        cmd[4] = crc[0];
        cmd[5] = crc[1];

        sendCommand(cmd);
        Log.i(TAG, "setAnalogChannel freq=" + freq + " Hz");
        logMessage("TX CMD 0x23 freq=" + freq);
    }

    // --- checkInitComplete (CMD 0x27) ---

    private void sendCheckInitComplete() {
        byte[] cmd = {0x68, CMD_INIT, 0x01, 0x01, 0x00, 0x00, 0x00, 0x01, 0x01, 0x10};
        byte[] crc = CRC.checkSumBytes(cmd, 10);
        cmd[4] = crc[0];
        cmd[5] = crc[1];
        sendCommand(cmd);
        Log.i(TAG, "Sent checkInitComplete");
        logMessage("TX CMD 0x27 (init)");
    }

    // --- getVersion (CMD 0x34) ---

    private void sendGetVersion() {
        byte[] cmd = {0x68, CMD_VERSION, 0x01, 0x01, 0x00, 0x00, 0x00, 0x00, 0x10};
        byte[] crc = CRC.checkSumBytes(cmd, 9);
        cmd[4] = crc[0];
        cmd[5] = crc[1];
        sendCommand(cmd);
        Log.i(TAG, "Sent getVersion");
        logMessage("TX CMD 0x34 (version)");
    }

    // --- setTransferInterrupt (CMD 0x35) ---

    private void sendTransferInterrupt(int mode) {
        byte[] cmd = {0x68, 0x35, 0x01, 0x01, 0x00, 0x00, 0x00, 0x01, (byte) mode, 0x10};
        byte[] crc = CRC.checkSumBytes(cmd, 10);
        cmd[4] = crc[0];
        cmd[5] = crc[1];
        sendCommand(cmd);
        Log.i(TAG, "Sent setTransferInterrupt mode=" + mode);
        logMessage("TX CMD 0x35 transfer=" + mode);
    }

    // --- setMicGain (CMD 0x2A) ---

    private void sendMicGain(int level) {
        byte[] cmd = {0x68, CMD_MIC_GAIN, 0x01, 0x01, 0x00, 0x00, 0x00, 0x01, (byte) level, 0x10};
        byte[] crc = CRC.checkSumBytes(cmd, 10);
        cmd[4] = crc[0];
        cmd[5] = crc[1];
        sendCommand(cmd);
        Log.i(TAG, "Sent setMicGain level=" + level);
        logMessage("TX CMD 0x2A mic=" + level);
    }

    // --- setVolume (CMD 0x2E) ---

    private void sendVolume(int level) {
        byte[] cmd = {0x68, CMD_VOLUME, 0x01, 0x01, 0x00, 0x00, 0x00, 0x01, (byte) level, 0x10};
        byte[] crc = CRC.checkSumBytes(cmd, 10);
        cmd[4] = crc[0];
        cmd[5] = crc[1];
        sendCommand(cmd);
        Log.i(TAG, "Sent setVolume level=" + level);
        logMessage("TX CMD 0x2E volume=" + level);
    }

    // --- setSpeakerEnable (CMD 0x3C) ---

    private void sendSpeakerEnable(boolean enable) {
        byte[] cmd = {0x68, CMD_SPK_EN, 0x01, 0x01, 0x00, 0x00, 0x00, 0x01, (byte) (enable ? 1 : 0), 0x10};
        byte[] crc = CRC.checkSumBytes(cmd, 10);
        cmd[4] = crc[0];
        cmd[5] = crc[1];
        sendCommand(cmd);
        Log.i(TAG, "Sent setSpeakerEnable enable=" + enable);
        logMessage("TX CMD 0x3C spk=" + (enable ? 1 : 0));
    }

    // --- launchCommand (CMD 0x26) ---

    private void sendLaunchCommand(int value) {
        byte[] cmd = {0x68, CMD_LAUNCH, 0x01, 0x01, 0x00, 0x00, 0x00, 0x01, (byte) value, 0x10};
        byte[] crc = CRC.checkSumBytes(cmd, 10);
        cmd[4] = crc[0];
        cmd[5] = crc[1];
        sendCommand(cmd);
        Log.i(TAG, "Sent launchCommand value=" + value);
        logMessage("TX CMD 0x26 launch=" + value);
    }

    // --- Low-level helpers ---

    private void sendCommand(byte[] data) {
        if (fd > 0) {
            String hex = bytesToHex(data);
            Log.i(TAG, "TX [" + data.length + "]: " + hex);
            int written = serialPort.writeData(fd, data);
            Log.i(TAG, "Wrote " + written + " bytes to serial");
        } else {
            Log.w(TAG, "Cannot send command, serial not open");
            logMessage("WARN: serial not open");
        }
    }

    private void writeSysfs(String path, boolean on) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            byte[] data = new byte[2];
            data[0] = (byte) (on ? '1' : '0');
            data[1] = '\n';
            fos.write(data);
            fos.close();
            Log.d(TAG, "sysfs " + path + " = " + (on ? "1" : "0"));
        } catch (IOException e) {
            Log.e(TAG, "Failed to write sysfs " + path, e);
        }
    }

    private void stopReadThread() {
        if (readThread != null) {
            readThread.stopRunning();
            try {
                readThread.join(500);
            } catch (InterruptedException ignored) {}
            readThread = null;
        }
    }

    private void logMessage(String msg) {
        // Store in ring buffer
        synchronized (logRing) {
            logRing[logRingHead] = msg;
            logRingHead = (logRingHead + 1) % LOG_RING_SIZE;
            if (logRingCount < LOG_RING_SIZE) logRingCount++;
        }
        if (logCallback != null) {
            logCallback.onLog(msg);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            if (i > 0) sb.append(' ');
            sb.append(String.format("%02X", bytes[i] & 0xFF));
        }
        return sb.toString();
    }

    // --- Callback interfaces ---

    public interface PowerOnCallback {
        void onResult(boolean success, String message);
    }

    public interface LogCallback {
        void onLog(String message);
    }
}
