package com.geograms.iwi;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ServerSocketChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import fi.iki.elonen.NanoHTTPD;

/**
 * HTTP API server for remote radio control.
 * Runs on port 6789, routes requests to RadioManager.
 */
public class ApiServer extends NanoHTTPD {
    private static final String TAG = "ApiServer";
    private static final long OP_TIMEOUT_MS = 10000;

    private final RadioManager radio;
    private ServerSocketChannel serverChannel;
    private PowerStateListener powerStateListener;

    public interface PowerStateListener {
        void onPowerStateChanged(boolean poweredOn);
    }

    public void setPowerStateListener(PowerStateListener listener) {
        this.powerStateListener = listener;
    }

    public ApiServer(RadioManager radio, int port) {
        super("0.0.0.0", port);
        this.radio = radio;
        // Use NIO ServerSocketChannel to bypass Android's PlainSocketImpl.createImpl()
        // which fails with ECONNREFUSED on devices with broken netd/socket tagging
        setServerSocketFactory(() -> {
            serverChannel = ServerSocketChannel.open();
            return serverChannel.socket();
        });
    }

    @Override
    public void stop() {
        super.stop();
        // NanoHTTPD only closes the ServerSocket, not the underlying channel
        if (serverChannel != null) {
            try { serverChannel.close(); } catch (IOException ignored) {}
        }
    }

    private static final int MAX_WAV_SIZE = 10 * 1024 * 1024;  // 10 MB

    @Override
    public Response serve(IHTTPSession session) {
        String uri = session.getUri();
        Method method = session.getMethod();

        // WAV upload: handle BEFORE parseBody (which corrupts binary data)
        if (uri.equals("/radio/wav") && method == Method.POST) {
            try {
                return handleWavUpload(session);
            } catch (Exception e) {
                Log.e(TAG, "WAV upload error", e);
                return jsonError(Response.Status.INTERNAL_ERROR, e.getMessage());
            }
        }

        // Parse POST body (JSON endpoints)
        Map<String, String> bodyMap = new HashMap<>();
        if (method == Method.POST || method == Method.PUT) {
            try {
                session.parseBody(bodyMap);
            } catch (IOException | ResponseException e) {
                return jsonError(Response.Status.BAD_REQUEST, "Failed to parse body: " + e.getMessage());
            }
        }

        try {
            // --- Radio endpoints ---
            if (uri.equals("/radio/status") && method == Method.GET) {
                return handleRadioStatus();
            }
            if (uri.equals("/radio/power/on") && method == Method.POST) {
                return handlePowerOn(bodyMap);
            }
            if (uri.equals("/radio/power/off") && method == Method.POST) {
                return handlePowerOff();
            }
            if (uri.equals("/radio/frequency") && method == Method.POST) {
                return handleFrequency(bodyMap);
            }
            if (uri.equals("/radio/squelch") && method == Method.POST) {
                return handleSquelch(bodyMap);
            }
            if (uri.equals("/radio/volume") && method == Method.POST) {
                return handleVolume(bodyMap);
            }
            if (uri.equals("/radio/ptt/on") && method == Method.POST) {
                return handlePttOn();
            }
            if (uri.equals("/radio/ptt/off") && method == Method.POST) {
                return handlePttOff();
            }
            if (uri.equals("/radio/tone") && method == Method.POST) {
                return handleTone(bodyMap);
            }
            if (uri.equals("/radio/log") && method == Method.GET) {
                return handleLog(session);
            }
            if (uri.equals("/radio/last-rx") && method == Method.GET) {
                return handleLastRxWav();
            }

            // --- APRS endpoints ---
            if (uri.equals("/aprs/message") && method == Method.POST) {
                return handleAprsMessage(bodyMap);
            }
            if (uri.equals("/aprs/position") && method == Method.POST) {
                return handleAprsPosition(bodyMap);
            }
            if (uri.equals("/aprs/status") && method == Method.POST) {
                return handleAprsStatus(bodyMap);
            }
            if (uri.equals("/aprs/received") && method == Method.GET) {
                return handleAprsReceived(session);
            }
            if (uri.equals("/aprs/queue") && method == Method.GET) {
                return handleAprsQueue();
            }
            if (uri.equals("/aprs/amplitude-sweep") && method == Method.POST) {
                return handleAmplitudeSweep(bodyMap);
            }
            if (uri.equals("/aprs/deemphasis-sweep") && method == Method.POST) {
                return handleDeEmphasisSweep(bodyMap);
            }
            if (uri.equals("/aprs/config") && method == Method.POST) {
                return handleAprsConfig(bodyMap);
            }

            return jsonError(Response.Status.NOT_FOUND, "Unknown endpoint: " + method + " " + uri);
        } catch (Exception e) {
            Log.e(TAG, "API error: " + uri, e);
            return jsonError(Response.Status.INTERNAL_ERROR, e.getMessage());
        }
    }

    // ========================================================================
    // RADIO ENDPOINTS
    // ========================================================================

    private Response handleRadioStatus() throws Exception {
        JSONObject j = new JSONObject();
        j.put("powered", radio.isPowered());
        long freqHz = radio.getFrequency();
        if (freqHz > 0) {
            j.put("frequency_mhz", freqHz / 1_000_000.0);
        }
        j.put("squelch", radio.getSquelchLevel());
        j.put("volume", radio.getVolumeLevel());
        String fw = radio.getFirmwareVersion();
        if (fw != null) j.put("firmware", fw);
        j.put("module_status", radio.getModuleStatus());
        j.put("module_status_text", radio.getModuleStatusText());
        return jsonOk(j);
    }

    private Response handlePowerOn(Map<String, String> bodyMap) throws Exception {
        if (radio.isPowered()) {
            return jsonError(Response.Status.CONFLICT, "Radio already powered on");
        }
        JSONObject body = parseJsonBody(bodyMap);
        double freqMhz = body.optDouble("frequency_mhz", 144.8);
        int squelch = body.optInt("squelch", 0);
        long freqHz = (long) (freqMhz * 1_000_000);

        radio.setSquelchLevel(squelch);

        CountDownLatch latch = new CountDownLatch(1);
        final String[] result = new String[2]; // [0]=success, [1]=message
        radio.powerOn(freqHz, (success, message) -> {
            result[0] = String.valueOf(success);
            result[1] = message;
            latch.countDown();
        });

        if (!latch.await(OP_TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
            return jsonError(Response.Status.INTERNAL_ERROR, "Power on timeout");
        }

        boolean success = Boolean.parseBoolean(result[0]);
        if (success && powerStateListener != null) {
            powerStateListener.onPowerStateChanged(true);
        }
        JSONObject j = new JSONObject();
        j.put("success", success);
        j.put("message", result[1]);
        return success ? jsonOk(j) : jsonError(Response.Status.INTERNAL_ERROR, result[1]);
    }

    private Response handlePowerOff() throws Exception {
        if (!radio.isPowered()) {
            return jsonError(Response.Status.CONFLICT, "Radio already powered off");
        }
        radio.powerOff();
        if (powerStateListener != null) {
            powerStateListener.onPowerStateChanged(false);
        }
        JSONObject j = new JSONObject();
        j.put("success", true);
        j.put("message", "Radio powered off");
        return jsonOk(j);
    }

    private Response handleFrequency(Map<String, String> bodyMap) throws Exception {
        JSONObject body = parseJsonBody(bodyMap);
        double freqMhz = body.getDouble("frequency_mhz");
        long freqHz = (long) (freqMhz * 1_000_000);

        CountDownLatch latch = new CountDownLatch(1);
        final String[] result = new String[2];
        radio.setFrequency(freqHz, (success, message) -> {
            result[0] = String.valueOf(success);
            result[1] = message;
            latch.countDown();
        });

        if (!latch.await(OP_TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
            return jsonError(Response.Status.INTERNAL_ERROR, "Frequency change timeout");
        }

        boolean success = Boolean.parseBoolean(result[0]);
        JSONObject j = new JSONObject();
        j.put("success", success);
        j.put("message", result[1]);
        return success ? jsonOk(j) : jsonError(Response.Status.INTERNAL_ERROR, result[1]);
    }

    private Response handleSquelch(Map<String, String> bodyMap) throws Exception {
        JSONObject body = parseJsonBody(bodyMap);
        int level = body.getInt("level");
        radio.setSquelchLevel(level);
        JSONObject j = new JSONObject();
        j.put("success", true);
        j.put("squelch", level);
        return jsonOk(j);
    }

    private Response handleVolume(Map<String, String> bodyMap) throws Exception {
        JSONObject body = parseJsonBody(bodyMap);
        int level = body.getInt("level");

        CountDownLatch latch = new CountDownLatch(1);
        radio.setVolume(level, latch::countDown);

        if (!latch.await(OP_TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
            return jsonError(Response.Status.INTERNAL_ERROR, "Volume change timeout");
        }

        JSONObject j = new JSONObject();
        j.put("success", true);
        j.put("volume", level);
        return jsonOk(j);
    }

    private Response handlePttOn() throws Exception {
        if (!radio.isPowered()) {
            return jsonError(Response.Status.CONFLICT, "Radio not powered");
        }
        radio.startTx();
        JSONObject j = new JSONObject();
        j.put("success", true);
        j.put("message", "PTT keyed");
        return jsonOk(j);
    }

    private Response handlePttOff() throws Exception {
        if (!radio.isPowered()) {
            return jsonError(Response.Status.CONFLICT, "Radio not powered");
        }
        radio.stopTx();
        JSONObject j = new JSONObject();
        j.put("success", true);
        j.put("message", "PTT released");
        return jsonOk(j);
    }

    private Response handleTone(Map<String, String> bodyMap) throws Exception {
        if (!radio.isPowered()) {
            return jsonError(Response.Status.CONFLICT, "Radio not powered");
        }
        JSONObject body = parseJsonBody(bodyMap);
        int count = body.optInt("count", 3);
        int toneMs = body.optInt("tone_ms", 200);
        int gapMs = body.optInt("gap_ms", 100);

        CountDownLatch latch = new CountDownLatch(1);
        radio.sendToneBeepSequence(count, toneMs, gapMs, latch::countDown);

        long timeout = (long) (count * (toneMs + gapMs)) + 5000;
        if (!latch.await(timeout, TimeUnit.MILLISECONDS)) {
            return jsonError(Response.Status.INTERNAL_ERROR, "Tone sequence timeout");
        }

        JSONObject j = new JSONObject();
        j.put("success", true);
        j.put("message", "Tone sequence complete");
        return jsonOk(j);
    }

    private Response handleLog(IHTTPSession session) throws Exception {
        String linesParam = session.getParms().get("lines");
        int lines = 100;
        if (linesParam != null) {
            try { lines = Integer.parseInt(linesParam); } catch (NumberFormatException ignored) {}
        }

        List<String> logLines = radio.getRecentLog(lines);
        JSONObject j = new JSONObject();
        JSONArray arr = new JSONArray();
        for (String line : logLines) {
            arr.put(line);
        }
        j.put("lines", arr);
        j.put("count", logLines.size());
        return jsonOk(j);
    }

    private Response handleLastRxWav() {
        String path = radio.getLastRxWavPath();
        if (path == null) {
            return jsonError(Response.Status.NOT_FOUND, "No RX audio captured yet");
        }
        File f = new File(path);
        if (!f.exists()) {
            return jsonError(Response.Status.NOT_FOUND, "RX audio file not found");
        }
        try {
            FileInputStream fis = new FileInputStream(f);
            Response r = newFixedLengthResponse(Response.Status.OK, "audio/wav", fis, f.length());
            r.addHeader("Access-Control-Allow-Origin", "*");
            r.addHeader("Content-Disposition", "attachment; filename=\"aprs_last_rx.wav\"");
            return r;
        } catch (IOException e) {
            Log.e(TAG, "Failed to serve RX WAV", e);
            return jsonError(Response.Status.INTERNAL_ERROR, "Failed to read file: " + e.getMessage());
        }
    }

    // ========================================================================
    // APRS ENDPOINTS
    // ========================================================================

    private Response handleAprsMessage(Map<String, String> bodyMap) throws Exception {
        JSONObject body = parseJsonBody(bodyMap);
        if (!body.has("src_call")) return jsonError(Response.Status.BAD_REQUEST, "Missing src_call");
        if (!body.has("dest_call")) return jsonError(Response.Status.BAD_REQUEST, "Missing dest_call");
        if (!body.has("message")) return jsonError(Response.Status.BAD_REQUEST, "Missing message");

        String srcCall = body.getString("src_call");
        int srcSsid = body.optInt("src_ssid", 0);
        String destCall = body.getString("dest_call");
        String message = body.getString("message");
        String msgId = body.optString("msg_id", null);
        long freqHz = parseFreqHz(body);

        byte[] frame = APRS.buildMessagePacket(srcCall, srcSsid, destCall, message, msgId);
        short[] pcm = AX25.modulateFrame(frame);

        return enqueueAndRespond(pcm, freqHz, "aprs_message");
    }

    private Response handleAprsPosition(Map<String, String> bodyMap) throws Exception {
        JSONObject body = parseJsonBody(bodyMap);
        if (!body.has("src_call")) return jsonError(Response.Status.BAD_REQUEST, "Missing src_call");
        if (!body.has("lat")) return jsonError(Response.Status.BAD_REQUEST, "Missing lat");
        if (!body.has("lon")) return jsonError(Response.Status.BAD_REQUEST, "Missing lon");

        String srcCall = body.getString("src_call");
        int srcSsid = body.optInt("src_ssid", 0);
        double lat = body.getDouble("lat");
        double lon = body.getDouble("lon");
        String symbolTable = body.optString("symbol_table", "/");
        String symbolCode = body.optString("symbol_code", "[");
        String comment = body.optString("comment", null);
        long freqHz = parseFreqHz(body);

        byte[] frame = APRS.buildPositionPacket(srcCall, srcSsid, lat, lon,
                symbolTable.charAt(0), symbolCode.charAt(0), comment);
        short[] pcm = AX25.modulateFrame(frame);

        return enqueueAndRespond(pcm, freqHz, "aprs_position");
    }

    private Response handleAprsStatus(Map<String, String> bodyMap) throws Exception {
        JSONObject body = parseJsonBody(bodyMap);
        if (!body.has("src_call")) return jsonError(Response.Status.BAD_REQUEST, "Missing src_call");
        if (!body.has("status")) return jsonError(Response.Status.BAD_REQUEST, "Missing status");

        String srcCall = body.getString("src_call");
        int srcSsid = body.optInt("src_ssid", 0);
        String status = body.getString("status");
        long freqHz = parseFreqHz(body);

        byte[] frame = APRS.buildStatusPacket(srcCall, srcSsid, status);
        short[] pcm = AX25.modulateFrame(frame);

        return enqueueAndRespond(pcm, freqHz, "aprs_status");
    }

    /** Enqueue PCM for transmission and return immediate response. */
    private Response enqueueAndRespond(short[] pcm, long freqHz, String type) throws Exception {
        // Save WAV for offline analysis
        try {
            String wavPath = "/data/data/com.geograms.iwi/files/aprs_last_api.wav";
            AX25.savePcmAsWav(pcm, wavPath);
            Log.i(TAG, "Saved API WAV: " + wavPath);
        } catch (Exception e) {
            Log.w(TAG, "WAV save failed: " + e.getMessage());
        }

        RadioManager.TxJob job = radio.enqueueTx(pcm, freqHz);
        if (job == null) {
            return jsonError(Response.Status.SERVICE_UNAVAILABLE, "TX queue full (max " + 50 + ")");
        }

        JSONObject j = new JSONObject();
        j.put("queued", true);
        j.put("job_id", job.id);
        j.put("queue_size", radio.getTxQueueSize());
        j.put("type", type);
        return jsonOk(j);
    }

    /** Parse optional frequency_mhz from body; 0 means use current. */
    private long parseFreqHz(JSONObject body) {
        double freqMhz = body.optDouble("frequency_mhz", 0);
        return freqMhz > 0 ? (long) (freqMhz * 1_000_000) : 0;
    }

    private Response handleAprsReceived(IHTTPSession session) throws Exception {
        String sinceParam = session.getParms().get("since");
        long sinceMs = 0;
        if (sinceParam != null) {
            try { sinceMs = Long.parseLong(sinceParam); } catch (NumberFormatException ignored) {}
        }

        List<RadioManager.ReceivedPacket> packets = radio.getReceivedPackets(sinceMs);
        JSONArray arr = new JSONArray();
        for (RadioManager.ReceivedPacket p : packets) {
            JSONObject pj = new JSONObject();
            pj.put("time", p.time);
            pj.put("raw", p.raw);
            if (p.parsed != null) {
                pj.put("src_call", p.parsed.srcCall);
                pj.put("src_ssid", p.parsed.srcSsid);
                pj.put("type", String.valueOf(p.parsed.type));
                if (p.parsed.lat != 0 || p.parsed.lon != 0) {
                    pj.put("lat", p.parsed.lat);
                    pj.put("lon", p.parsed.lon);
                }
                if (p.parsed.message != null) pj.put("message", p.parsed.message);
                if (p.parsed.comment != null) pj.put("comment", p.parsed.comment);
            }
            arr.put(pj);
        }

        JSONObject j = new JSONObject();
        j.put("packets", arr);
        j.put("count", arr.length());
        return jsonOk(j);
    }

    private Response handleAprsQueue() throws Exception {
        JSONObject j = new JSONObject();
        j.put("queue_size", radio.getTxQueueSize());
        j.put("radio_powered", radio.isPowered());
        j.put("module_status", radio.getModuleStatusText());
        return jsonOk(j);
    }

    /**
     * Amplitude sweep: transmits APRS status packets at different audio levels.
     * Monitor with HackRF/Direwolf to see which amplitude gets decoded.
     */
    private Response handleAmplitudeSweep(Map<String, String> bodyMap) throws Exception {
        JSONObject body = bodyMap.containsKey("postData") ?
            new JSONObject(bodyMap.get("postData")) : new JSONObject();
        String srcCall = body.optString("src_call", "N0CALL");
        int srcSsid = body.optInt("src_ssid", 7);
        long freqHz = parseFreqHz(body);

        int[] levels = {2000, 4000, 6000, 8000, 10000, 12000, 16000, 20000, 24000, 28000};
        int queued = 0;

        for (int amp : levels) {
            AX25.txAmplitude = amp;
            byte[] frame = APRS.buildStatusPacket(srcCall, srcSsid, "AMP=" + amp);
            short[] pcm = AX25.modulateFrame(frame);
            RadioManager.TxJob job = radio.enqueueTx(pcm, freqHz);
            if (job != null) queued++;
        }

        // Restore default
        AX25.txAmplitude = 16000;

        JSONObject j = new JSONObject();
        j.put("sweep", true);
        j.put("levels", new JSONArray(levels));
        j.put("queued", queued);
        return jsonOk(j);
    }

    /**
     * Tone balance sweep: transmits APRS status packets at different space/mark ratios.
     * Monitor with HackRF/Direwolf to find the ratio that gets decoded.
     * Mark stays at 1.0, space is swept from 0.05 to 1.0.
     */
    private Response handleDeEmphasisSweep(Map<String, String> bodyMap) throws Exception {
        JSONObject body = bodyMap.containsKey("postData") ?
            new JSONObject(bodyMap.get("postData")) : new JSONObject();
        String srcCall = body.optString("src_call", "N0CALL");
        int srcSsid = body.optInt("src_ssid", 7);
        long freqHz = parseFreqHz(body);

        // Sweep space attenuation from heavy to none
        double[] scales = {0.05, 0.08, 0.10, 0.13, 0.15, 0.20, 0.30, 0.50, 1.0};
        int queued = 0;

        AX25.markAmplitudeScale = 1.0;
        for (double sc : scales) {
            AX25.spaceAmplitudeScale = sc;
            int pct = (int)(sc * 100);
            byte[] frame = APRS.buildStatusPacket(srcCall, srcSsid, "SP=" + pct + "%");
            short[] pcm = AX25.modulateFrame(frame);
            RadioManager.TxJob job = radio.enqueueTx(pcm, freqHz);
            if (job != null) queued++;
        }

        // Restore default
        AX25.spaceAmplitudeScale = 0.15;

        JSONObject j = new JSONObject();
        j.put("sweep", true);
        j.put("space_scales", new JSONArray(scales));
        j.put("queued", queued);
        return jsonOk(j);
    }

    /**
     * Set APRS TX config: amplitude, mark/space scaling.
     * POST /aprs/config {"amplitude": 16000, "mark_scale": 1.0, "space_scale": 0.15}
     */
    private Response handleAprsConfig(Map<String, String> bodyMap) throws Exception {
        JSONObject body = bodyMap.containsKey("postData") ?
            new JSONObject(bodyMap.get("postData")) : new JSONObject();

        if (body.has("amplitude")) {
            AX25.txAmplitude = body.getInt("amplitude");
        }
        if (body.has("mark_scale")) {
            AX25.markAmplitudeScale = body.getDouble("mark_scale");
        }
        if (body.has("space_scale")) {
            AX25.spaceAmplitudeScale = body.getDouble("space_scale");
        }

        JSONObject j = new JSONObject();
        j.put("amplitude", AX25.txAmplitude);
        j.put("mark_scale", AX25.markAmplitudeScale);
        j.put("space_scale", AX25.spaceAmplitudeScale);
        return jsonOk(j);
    }

    // ========================================================================
    // WAV UPLOAD
    // ========================================================================

    private Response handleWavUpload(IHTTPSession session) throws Exception {
        String contentType = session.getHeaders().get("content-type");
        byte[] wavBytes;
        long freqHz = 0;

        if (contentType != null && contentType.contains("multipart/form-data")) {
            // Multipart form: curl -F wav=@file.wav -F frequency_mhz=144.39
            Map<String, String> files = new HashMap<>();
            session.parseBody(files);

            String tmpPath = files.get("wav");
            if (tmpPath == null) {
                return jsonError(Response.Status.BAD_REQUEST,
                    "Missing 'wav' field. Use: curl -F wav=@file.wav");
            }
            wavBytes = readFileBytes(tmpPath);

            String freqStr = session.getParms().get("frequency_mhz");
            if (freqStr != null) {
                try { freqHz = (long) (Double.parseDouble(freqStr) * 1_000_000); }
                catch (NumberFormatException ignored) {}
            }
        } else {
            // Raw binary: curl --data-binary @file.wav -H "Content-Type: audio/wav"
            String lenStr = session.getHeaders().get("content-length");
            if (lenStr == null || lenStr.isEmpty()) {
                return jsonError(Response.Status.BAD_REQUEST,
                    "Missing Content-Length. Use: curl -F wav=@file.wav or " +
                    "curl --data-binary @file.wav -H 'Content-Type: audio/wav'");
            }
            int contentLength = Integer.parseInt(lenStr);
            if (contentLength > MAX_WAV_SIZE) {
                return jsonError(Response.Status.BAD_REQUEST,
                    "File too large (" + (contentLength / 1024) + " KB, max " +
                    (MAX_WAV_SIZE / 1024) + " KB)");
            }
            if (contentLength < 44) {
                return jsonError(Response.Status.BAD_REQUEST, "File too small for WAV");
            }

            wavBytes = new byte[contentLength];
            InputStream is = session.getInputStream();
            int off = 0;
            while (off < contentLength) {
                int n = is.read(wavBytes, off, contentLength - off);
                if (n < 0) break;
                off += n;
            }

            String freqStr = session.getParms().get("frequency_mhz");
            if (freqStr != null) {
                try { freqHz = (long) (Double.parseDouble(freqStr) * 1_000_000); }
                catch (NumberFormatException ignored) {}
            }
        }

        // Decode WAV to 8kHz mono 16-bit
        WavReader.Result result;
        try {
            result = WavReader.decode(wavBytes);
        } catch (IllegalArgumentException e) {
            return jsonError(Response.Status.BAD_REQUEST, "Invalid WAV: " + e.getMessage());
        }

        // Enqueue for TX
        RadioManager.TxJob job = radio.enqueueTx(result.pcm, freqHz);
        if (job == null) {
            return jsonError(Response.Status.SERVICE_UNAVAILABLE, "TX queue full");
        }

        JSONObject j = new JSONObject();
        j.put("queued", true);
        j.put("job_id", job.id);
        j.put("queue_size", radio.getTxQueueSize());
        j.put("type", "wav");
        j.put("duration_ms", result.getDurationMs());
        j.put("original_sample_rate", result.originalSampleRate);
        j.put("original_channels", result.originalChannels);
        j.put("original_bits", result.originalBitsPerSample);
        return jsonOk(j);
    }

    private byte[] readFileBytes(String path) throws IOException {
        File f = new File(path);
        byte[] bytes = new byte[(int) f.length()];
        FileInputStream fis = new FileInputStream(f);
        try {
            int off = 0;
            while (off < bytes.length) {
                int n = fis.read(bytes, off, bytes.length - off);
                if (n < 0) break;
                off += n;
            }
        } finally {
            fis.close();
        }
        return bytes;
    }

    // ========================================================================
    // HELPERS
    // ========================================================================

    private JSONObject parseJsonBody(Map<String, String> bodyMap) throws Exception {
        String body = bodyMap.get("postData");
        if (body == null || body.isEmpty()) return new JSONObject();
        return new JSONObject(body);
    }

    private Response jsonOk(JSONObject json) {
        Response r = newFixedLengthResponse(Response.Status.OK, "application/json", json.toString());
        r.addHeader("Access-Control-Allow-Origin", "*");
        return r;
    }

    private Response jsonError(Response.Status status, String message) {
        try {
            JSONObject j = new JSONObject();
            j.put("error", message);
            Response r = newFixedLengthResponse(status, "application/json", j.toString());
            r.addHeader("Access-Control-Allow-Origin", "*");
            return r;
        } catch (Exception e) {
            return newFixedLengthResponse(status, "text/plain", message);
        }
    }
}
