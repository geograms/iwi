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
