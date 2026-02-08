package com.wonder.dmr.utils;

/* loaded from: classes.dex */
public class CRC {
    public static byte[] calculateCRC16XMODEM(byte[] bArr) {
        int i2 = 0;
        for (byte b2 : bArr) {
            i2 ^= (b2 & 255) << 8;
            for (int i3 = 0; i3 < 8; i3++) {
                int i4 = 32768 & i2;
                i2 <<= 1;
                if (i4 != 0) {
                    i2 ^= 4129;
                }
            }
        }
        return new byte[]{(byte) (((65535 & i2) >> 8) & 255), (byte) (i2 & 255)};
    }

    public static int checkSum(byte[] bArr, int i2) {
        int i3 = 0;
        int i4 = 0;
        while (i2 > 1) {
            i3 += (65280 & (bArr[i4] << 8)) | (bArr[i4 + 1] & 255);
            bArr = (byte[]) bArr.clone();
            i4 += 2;
            i2 -= 2;
        }
        if (i2 > 0) {
            i3 += (bArr[i4] << 8) & 65280;
        }
        while (true) {
            int i5 = i3 >> 16;
            if (i5 <= 0) {
                return (i3 ^ 65535) & 65535;
            }
            i3 = (65535 & i3) + i5;
        }
    }

    public static byte[] checkSumBytes(byte[] bArr, int i2) {
        int i3 = 0;
        int i4 = 0;
        while (i2 > 1) {
            i3 += (65280 & (bArr[i4] << 8)) | (bArr[i4 + 1] & 255);
            bArr = (byte[]) bArr.clone();
            i4 += 2;
            i2 -= 2;
        }
        if (i2 > 0) {
            i3 += (bArr[i4] << 8) & 65280;
        }
        while (true) {
            int i5 = i3 >> 16;
            if (i5 <= 0) {
                int i6 = i3 ^ 65535;
                return new byte[]{(byte) (((65535 & i6) >> 8) & 255), (byte) (i6 & 255)};
            }
            i3 = (65535 & i3) + i5;
        }
    }
}
