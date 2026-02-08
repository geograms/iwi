package com.geograms.iwi;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.util.Log;

import com.wonder.serial.SerialPort;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

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
    private static final int INIT_MAX_RETRIES = 10;
    private static final long INIT_RETRY_INTERVAL_MS = 500;

    // Audio serial port (ttyS1)
    private static final String AUDIO_SERIAL_PORT = "/dev/ttyS1";
    private static final int AUDIO_BAUD_RATE = 230400;
    private static final int PCM_FRAME_SIZE = 160; // 80 samples * 2 bytes (16-bit mono 8kHz = 10ms)
    // TX audio frame: BB 00 [4 header bytes] [160 PCM bytes] 44 = 167 bytes
    private static final int TX_FRAME_SIZE = 167;
    private static final byte TX_FRAME_START_1 = (byte) 0xBB;
    private static final byte TX_FRAME_START_2 = (byte) 0x00;
    private static final byte TX_FRAME_END = (byte) 0x44;

    private static final String SYSFS_POWER = "/sys/devices/platform/intercom/intercom_power_control";
    private static final String SYSFS_PWD = "/sys/devices/platform/intercom/intercom_pwd_control";
    private static final String SYSFS_PTT = "/sys/devices/platform/intercom/intercom_ptt_control";

    // Command IDs
    private static final byte CMD_ANALOG = 0x23;
    private static final byte CMD_LAUNCH = 0x26;
    private static final byte CMD_INIT = 0x27;
    private static final byte CMD_VERSION = 0x34;

    // Response status codes
    private static final byte STATUS_SUCCESS = 0x00;
    private static final byte STATUS_FAIL = 0x01;
    private static final byte STATUS_CRC_ERROR = 0x02;

    private final SerialPort serialPort = new SerialPort();
    private final AudioManager audioManager;
    private int fd = -1;        // command serial fd (ttyS0)
    private int audioFd = -1;   // audio serial fd (ttyS1)
    private boolean powered = false;

    private SerialReadThread readThread;
    private AudioTransmitThread audioTransmitThread;
    private volatile CountDownLatch initLatch;
    private volatile CountDownLatch versionLatch;
    private volatile CountDownLatch channelLatch;
    private volatile int lastInitStatus = -1;
    private volatile int lastVersionStatus = -1;
    private volatile int lastChannelStatus = -1;
    private volatile String firmwareVersion = null;

    private LogCallback logCallback;

    public RadioManager(Context context) {
        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
    }

    public boolean isPowered() {
        return powered;
    }

    public void setLogCallback(LogCallback callback) {
        this.logCallback = callback;
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
                int bufSize = AudioRecord.getMinBufferSize(sampleRate,
                    AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT);
                if (bufSize < PCM_FRAME_SIZE) bufSize = PCM_FRAME_SIZE;

                recorder = new AudioRecord(MediaRecorder.AudioSource.MIC,
                    sampleRate, AudioFormat.CHANNEL_IN_MONO,
                    AudioFormat.ENCODING_PCM_16BIT, bufSize);
                recorder.startRecording();
                Log.i(TAG, "AudioTransmitThread started, reading mic → ttyS1 (framed)");
                logMessage("Audio TX: mic → ttyS1 (framed)");

                byte[] pcmBuf = new byte[PCM_FRAME_SIZE];
                byte[] txFrame = new byte[TX_FRAME_SIZE];
                // Pre-fill frame header and footer
                txFrame[0] = TX_FRAME_START_1;  // 0xBB
                txFrame[1] = TX_FRAME_START_2;  // 0x00
                txFrame[2] = 0x00;  // header byte 3
                txFrame[3] = 0x00;  // header byte 4
                txFrame[4] = 0x00;  // header byte 5
                txFrame[5] = 0x00;  // header byte 6
                txFrame[TX_FRAME_SIZE - 1] = TX_FRAME_END;  // 0x44
                int frameCount = 0;

                while (running && !isInterrupted()) {
                    int read = recorder.read(pcmBuf, 0, PCM_FRAME_SIZE);
                    if (read == PCM_FRAME_SIZE && audioFd > 0) {
                        // Copy PCM data into frame at offset 6
                        System.arraycopy(pcmBuf, 0, txFrame, 6, PCM_FRAME_SIZE);
                        serialPort.writeData(audioFd, txFrame);
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

    // --- Response Handling ---

    private void handleResponse(byte[] data) {
        if (data.length < 4) {
            Log.w(TAG, "Response too short: " + data.length + " bytes");
            logMessage("Response too short: " + data.length + " bytes");
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

                // 4. Open audio serial port (ttyS1)
                audioFd = serialPort.open(AUDIO_SERIAL_PORT, AUDIO_BAUD_RATE);
                if (audioFd <= 0) {
                    Log.e(TAG, "Failed to open audio serial port, audioFd=" + audioFd);
                    logMessage("ttyS1 open FAILED fd=" + audioFd);
                    callback.onResult(false, "Audio serial port open failed (fd=" + audioFd + ")");
                    serialPort.close(fd);
                    fd = -1;
                    return;
                }
                logMessage("ttyS1 opened fd=" + audioFd);

                // 5. Start command read thread
                readThread = new SerialReadThread();
                readThread.start();

                // 6. Wait 100ms then set sysfs to 1
                Thread.sleep(100);
                writeSysfs(SYSFS_POWER, true);
                writeSysfs(SYSFS_PWD, true);
                writeSysfs(SYSFS_PTT, true);

                // 7. Wait for module to boot
                Thread.sleep(500);

                // 8. Poll checkInitComplete until ACK (module boot time varies)
                boolean initOk = false;
                for (int attempt = 1; attempt <= INIT_MAX_RETRIES; attempt++) {
                    initLatch = new CountDownLatch(1);
                    lastInitStatus = -1;
                    sendCheckInitComplete();
                    logMessage("Init attempt " + attempt + "/" + INIT_MAX_RETRIES + "...");

                    if (initLatch.await(INIT_RETRY_INTERVAL_MS, TimeUnit.MILLISECONDS)) {
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

                powered = true;
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

        stopAudioTransmit();
        stopReadThread();

        writeSysfs(SYSFS_POWER, false);
        writeSysfs(SYSFS_PWD, false);
        writeSysfs(SYSFS_PTT, false);

        if (audioFd > 0) {
            serialPort.close(audioFd);
            audioFd = -1;
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

        sendLaunchCommand(1);
        startAudioTransmit();
    }

    public void stopTx() {
        if (!powered || fd <= 0) return;
        Log.i(TAG, "PTT release (TX stop)");
        logMessage("PTT UP");

        stopAudioTransmit();
        sendLaunchCommand(0);
    }

    private void startAudioTransmit() {
        if (audioFd <= 0) {
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
        cmd[18] = 0x05;        // squelch: 5 (stock default)
        cmd[19] = 0x00;        // rx_type: 0 = no CTCSS/DCS
        cmd[20] = 0x00;        // rx_subcode
        cmd[21] = 0x00;        // tx_type
        cmd[22] = 0x00;        // tx_subcode
        cmd[23] = 0x02;        // pwrsave: 2 (stock default)
        cmd[24] = 0x00;        // volume: 0 (stock default in analog cmd)
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
