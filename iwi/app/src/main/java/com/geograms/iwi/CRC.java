package com.geograms.iwi;

/**
 * CRC checksum — reused from com.wonder.dmr.utils.CRC.
 * Only the checkSumBytes() method needed for serial command framing.
 */
public class CRC {

    public static byte[] checkSumBytes(byte[] data, int len) {
        int sum = 0;
        int idx = 0;
        while (len > 1) {
            sum += ((data[idx] << 8) & 0xFF00) | (data[idx + 1] & 0xFF);
            data = data.clone();
            idx += 2;
            len -= 2;
        }
        if (len > 0) {
            sum += (data[idx] << 8) & 0xFF00;
        }
        while (true) {
            int carry = sum >> 16;
            if (carry <= 0) {
                int result = (sum ^ 0xFFFF) & 0xFFFF;
                return new byte[]{(byte) ((result >> 8) & 0xFF), (byte) (result & 0xFF)};
            }
            sum = (sum & 0xFFFF) + carry;
        }
    }
}
