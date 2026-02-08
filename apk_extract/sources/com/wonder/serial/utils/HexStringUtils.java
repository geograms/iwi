package com.wonder.serial.utils;

import java.io.PrintStream;

/* loaded from: classes.dex */
public class HexStringUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f1698a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static int a(char c2, int i2) {
        int iDigit = Character.digit(c2, 16);
        if (iDigit != -1) {
            return iDigit;
        }
        throw new RuntimeException("Illegal hexadecimal character " + c2 + " at index " + i2);
    }

    public static byte[] chars2Bytes(char[] cArr) {
        return a(cArr);
    }

    public static byte[] hexString2Bytes(String str) {
        return a(str.toCharArray());
    }

    public static void main(String[] strArr) {
        String hexString = toHexString("abc你好".getBytes());
        PrintStream printStream = System.out;
        printStream.println("原字符串:abc你好");
        printStream.println("十六进制字符串:" + hexString);
    }

    public static String toHexString(byte[] bArr) {
        char[] cArr = new char[bArr.length << 1];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = i2 + 1;
            char[] cArr2 = f1698a;
            cArr[i2] = cArr2[(b2 & 240) >>> 4];
            i2 += 2;
            cArr[i3] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public static byte[] a(char[] cArr) {
        int length = cArr.length;
        if ((length & 1) != 0) {
            throw new RuntimeException("字符个数应该为偶数");
        }
        byte[] bArr = new byte[length >> 1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i2 + 1;
            int iA = (a(cArr[i2], i2) << 4) | a(cArr[i4], i4);
            i2 += 2;
            bArr[i3] = (byte) (iA & 255);
            i3++;
        }
        return bArr;
    }
}
