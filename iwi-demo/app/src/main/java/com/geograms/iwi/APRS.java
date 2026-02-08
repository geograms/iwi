package com.geograms.iwi;

import java.util.Locale;

/**
 * APRS (Automatic Packet Reporting System) application layer.
 *
 * Builds APRS packets (position, message, status) as AX.25 frames
 * and provides convenience methods to modulate them directly to PCM.
 *
 * Also parses received AX.25 frames back into structured APRS packets.
 *
 * Uses AX25.java for all lower-layer operations (framing, AFSK, demod).
 */
public class APRS {

    // --- Constants ---
    public static final String DEST_CALL = "APZ001"; // experimental destination
    public static final int DEST_SSID = 0;
    public static final String[] DEFAULT_PATH = {"WIDE1-1", "WIDE2-1"};

    // APRS data type identifiers
    public static final char TYPE_POSITION_NO_TS = '=';     // position without timestamp
    public static final char TYPE_POSITION_NO_TS_2 = '!';   // position without timestamp (alt)
    public static final char TYPE_POSITION_WITH_TS = '/';   // position with timestamp
    public static final char TYPE_POSITION_WITH_TS_2 = '@'; // position with timestamp (alt)
    public static final char TYPE_MESSAGE = ':';
    public static final char TYPE_STATUS = '>';

    // ========================================================================
    // COORDINATE ENCODING
    // ========================================================================

    /**
     * Encode latitude as APRS format: DDMM.hhN or DDMM.hhS
     * DD = degrees, MM = minutes, hh = hundredths of minutes
     */
    public static String encodeLatitude(double lat) {
        char ns = lat >= 0 ? 'N' : 'S';
        lat = Math.abs(lat);
        int deg = (int) lat;
        double min = (lat - deg) * 60.0;
        return String.format(Locale.US, "%02d%05.2f%c", deg, min, ns);
    }

    /**
     * Encode longitude as APRS format: DDDMM.hhE or DDDMM.hhW
     * DDD = degrees, MM = minutes, hh = hundredths of minutes
     */
    public static String encodeLongitude(double lon) {
        char ew = lon >= 0 ? 'E' : 'W';
        lon = Math.abs(lon);
        int deg = (int) lon;
        double min = (lon - deg) * 60.0;
        return String.format(Locale.US, "%03d%05.2f%c", deg, min, ew);
    }

    /**
     * Parse APRS latitude string (DDMM.hhN) to decimal degrees.
     */
    public static double parseLatitude(String s) {
        if (s == null || s.length() < 8) return 0;
        int deg = Integer.parseInt(s.substring(0, 2));
        double min = Double.parseDouble(s.substring(2, 7));
        double lat = deg + min / 60.0;
        if (s.charAt(7) == 'S') lat = -lat;
        return lat;
    }

    /**
     * Parse APRS longitude string (DDDMM.hhE) to decimal degrees.
     */
    public static double parseLongitude(String s) {
        if (s == null || s.length() < 9) return 0;
        int deg = Integer.parseInt(s.substring(0, 3));
        double min = Double.parseDouble(s.substring(3, 8));
        double lon = deg + min / 60.0;
        if (s.charAt(8) == 'W') lon = -lon;
        return lon;
    }

    // ========================================================================
    // PACKET BUILDING (returns AX.25 frames, not yet modulated)
    // ========================================================================

    /**
     * Build an APRS position packet (uncompressed, no timestamp).
     *
     * @param srcCall     source callsign
     * @param srcSsid     source SSID
     * @param lat         latitude in decimal degrees (positive = N)
     * @param lon         longitude in decimal degrees (positive = E)
     * @param symbolTable '/' for primary, '\\' for alternate
     * @param symbolCode  symbol character (e.g. '[' for jogger, '-' for house)
     * @param comment     optional comment text (may be null)
     */
    public static byte[] buildPositionPacket(String srcCall, int srcSsid,
                                             double lat, double lon,
                                             char symbolTable, char symbolCode,
                                             String comment) {
        StringBuilder info = new StringBuilder();
        info.append(TYPE_POSITION_NO_TS);
        info.append(encodeLatitude(lat));
        info.append(symbolTable);
        info.append(encodeLongitude(lon));
        info.append(symbolCode);
        if (comment != null && !comment.isEmpty()) {
            info.append(comment);
        }
        return AX25.buildUIFrame(srcCall, srcSsid, DEST_CALL, DEST_SSID,
                DEFAULT_PATH, info.toString().getBytes());
    }

    /**
     * Build an APRS message packet.
     *
     * @param srcCall  source callsign
     * @param srcSsid  source SSID
     * @param destCall addressee callsign (padded to 9 chars in output)
     * @param message  message text
     * @param msgId    message ID for ACK tracking (may be null for no-ack)
     */
    public static byte[] buildMessagePacket(String srcCall, int srcSsid,
                                            String destCall, String message,
                                            String msgId) {
        StringBuilder info = new StringBuilder();
        info.append(TYPE_MESSAGE);
        // Addressee field: 9 characters, space-padded
        String padded = destCall;
        while (padded.length() < 9) padded += " ";
        if (padded.length() > 9) padded = padded.substring(0, 9);
        info.append(padded);
        info.append(TYPE_MESSAGE);
        info.append(message);
        if (msgId != null && !msgId.isEmpty()) {
            info.append('{');
            info.append(msgId);
        }
        return AX25.buildUIFrame(srcCall, srcSsid, DEST_CALL, DEST_SSID,
                DEFAULT_PATH, info.toString().getBytes());
    }

    /**
     * Build an APRS status packet.
     *
     * @param srcCall source callsign
     * @param srcSsid source SSID
     * @param status  status text
     */
    public static byte[] buildStatusPacket(String srcCall, int srcSsid, String status) {
        String info = TYPE_STATUS + status;
        return AX25.buildUIFrame(srcCall, srcSsid, DEST_CALL, DEST_SSID,
                DEFAULT_PATH, info.getBytes());
    }

    /**
     * Build an APRS message acknowledgment.
     *
     * @param srcCall  source callsign
     * @param srcSsid  source SSID
     * @param destCall original sender's callsign
     * @param msgId    message ID being acknowledged
     */
    public static byte[] buildMessageAck(String srcCall, int srcSsid,
                                         String destCall, String msgId) {
        StringBuilder info = new StringBuilder();
        info.append(TYPE_MESSAGE);
        String padded = destCall;
        while (padded.length() < 9) padded += " ";
        if (padded.length() > 9) padded = padded.substring(0, 9);
        info.append(padded);
        info.append(":ack");
        info.append(msgId);
        return AX25.buildUIFrame(srcCall, srcSsid, DEST_CALL, DEST_SSID,
                DEFAULT_PATH, info.toString().getBytes());
    }

    // ========================================================================
    // TX CONVENIENCE (packet → PCM in one call)
    // ========================================================================

    /** Build and modulate an APRS position packet to PCM audio. */
    public static short[] modulatePositionPacket(String srcCall, int srcSsid,
                                                 double lat, double lon,
                                                 char symbolTable, char symbolCode,
                                                 String comment) {
        return AX25.modulateFrame(buildPositionPacket(srcCall, srcSsid,
                lat, lon, symbolTable, symbolCode, comment));
    }

    /** Build and modulate an APRS message packet to PCM audio. */
    public static short[] modulateMessagePacket(String srcCall, int srcSsid,
                                                String destCall, String message,
                                                String msgId) {
        return AX25.modulateFrame(buildMessagePacket(srcCall, srcSsid,
                destCall, message, msgId));
    }

    /** Build and modulate an APRS status packet to PCM audio. */
    public static short[] modulateStatusPacket(String srcCall, int srcSsid,
                                               String status) {
        return AX25.modulateFrame(buildStatusPacket(srcCall, srcSsid, status));
    }

    // ========================================================================
    // RX PARSING
    // ========================================================================

    /** Parsed APRS packet. */
    public static class APRSPacket {
        public String srcCall;
        public int srcSsid;
        public String dstCall;
        public int dstSsid;
        public String[] digipeaters;
        public char type;

        // Position fields
        public double lat;
        public double lon;
        public char symbolTable;
        public char symbolCode;

        // Message fields
        public String addressee;
        public String message;
        public String messageId;
        public boolean isAck;

        // General
        public String comment;
        public String raw; // raw info field as string

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
            sb.append(':').append(raw);
            return sb.toString();
        }
    }

    /** Callback for decoded APRS packets. */
    public interface APRSCallback {
        void onPacket(APRSPacket packet);
    }

    /**
     * Parse an AX.25 ParsedFrame into an APRSPacket.
     * Handles position (=/!/@), message (:), and status (>) packet types.
     * Returns null if the info field is empty or unrecognized.
     */
    public static APRSPacket parseAPRS(AX25.ParsedFrame frame) {
        if (frame == null || frame.info == null || frame.info.length == 0) return null;

        APRSPacket pkt = new APRSPacket();
        pkt.srcCall = frame.srcCall;
        pkt.srcSsid = frame.srcSsid;
        pkt.dstCall = frame.dstCall;
        pkt.dstSsid = frame.dstSsid;
        pkt.digipeaters = frame.digipeaters;
        pkt.raw = new String(frame.info);

        char typeChar = (char) (frame.info[0] & 0xFF);
        pkt.type = typeChar;

        switch (typeChar) {
            case '=':
            case '!':
                // Uncompressed position without timestamp
                // Format: =DDMM.hhN/DDDMM.hhE[sym]comment
                return parsePosition(pkt, frame.info, 1);

            case '/':
            case '@':
                // Position with timestamp — skip 7-char timestamp
                if (frame.info.length < 8) return pkt;
                return parsePosition(pkt, frame.info, 8);

            case ':':
                // Message
                return parseMessage(pkt, frame.info);

            case '>':
                // Status
                pkt.comment = pkt.raw.substring(1);
                return pkt;

            default:
                // Unknown type — return raw
                return pkt;
        }
    }

    private static APRSPacket parsePosition(APRSPacket pkt, byte[] info, int offset) {
        String s = new String(info);
        if (s.length() < offset + 19) return pkt; // need lat(8) + sym(1) + lon(9) + sym(1)

        String latStr = s.substring(offset, offset + 8);
        pkt.symbolTable = s.charAt(offset + 8);
        String lonStr = s.substring(offset + 9, offset + 18);
        pkt.symbolCode = s.charAt(offset + 18);

        pkt.lat = parseLatitude(latStr);
        pkt.lon = parseLongitude(lonStr);

        if (s.length() > offset + 19) {
            pkt.comment = s.substring(offset + 19);
        }

        return pkt;
    }

    private static APRSPacket parseMessage(APRSPacket pkt, byte[] info) {
        String s = new String(info);
        // Format: :ADDRESSEE:message{id
        if (s.length() < 11) return pkt; // : + 9 addressee + :

        pkt.addressee = s.substring(1, 10).trim();

        String body = s.substring(11);

        // Check for ack
        if (body.startsWith("ack")) {
            pkt.isAck = true;
            pkt.messageId = body.substring(3);
            return pkt;
        }

        // Check for message ID
        int bracePos = body.lastIndexOf('{');
        if (bracePos >= 0) {
            pkt.message = body.substring(0, bracePos);
            pkt.messageId = body.substring(bracePos + 1);
        } else {
            pkt.message = body;
        }

        return pkt;
    }

    /**
     * Parse a raw AX.25 frame (FCS stripped) into an APRSPacket.
     * Convenience: parseFrame + parseAPRS in one call.
     */
    public static APRSPacket demodulateAndParse(byte[] ax25Frame) {
        AX25.ParsedFrame frame = AX25.parseFrame(ax25Frame);
        if (frame == null) return null;
        return parseAPRS(frame);
    }

    /**
     * Create a streaming demodulator that delivers parsed APRS packets.
     * Feed PCM audio via addSamples(); packets arrive via callback.
     */
    public static AX25.Demodulator createDemodulator(final APRSCallback callback) {
        return new AX25.Demodulator(new AX25.FrameCallback() {
            @Override
            public void onFrame(byte[] frame) {
                APRSPacket pkt = demodulateAndParse(frame);
                if (pkt != null) {
                    callback.onPacket(pkt);
                }
            }
        });
    }
}
