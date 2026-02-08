package me.f1reking.serialportlib.util;

public class ByteUtils {
    public static byte[] hexToByteArr(String str) {
        if (str == null || str.equals("")) {
            return new byte[0];
        }
        String replaceAll = str.replaceAll(" ", "");
        byte[] bArr = new byte[replaceAll.length() / 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) Integer.parseInt(replaceAll.substring(i2 * 2, (i2 * 2) + 2), 16);
        }
        return bArr;
    }
}
