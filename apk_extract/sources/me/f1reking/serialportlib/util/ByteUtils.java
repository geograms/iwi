package me.f1reking.serialportlib.util;

/* loaded from: classes.dex */
public class ByteUtils {
    public static byte HexToByte(String str) {
        return (byte) Integer.parseInt(str, 16);
    }

    public static int HexToInt(String str) {
        return Integer.parseInt(str, 16);
    }

    public static byte[] hexToByteArr(String str) {
        byte[] bArr;
        int length = str.length();
        if (isOdd(length) == 1) {
            length++;
            bArr = new byte[length / 2];
            str = "0".concat(str);
        } else {
            bArr = new byte[length / 2];
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i2 + 2;
            bArr[i3] = HexToByte(str.substring(i2, i4));
            i3++;
            i2 = i4;
        }
        return bArr;
    }

    public static int isOdd(int i2) {
        return i2 & 1;
    }
}
