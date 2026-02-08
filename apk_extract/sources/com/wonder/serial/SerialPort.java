package com.wonder.serial;

import android.util.Log;

/* loaded from: classes.dex */
public class SerialPort {
    static {
        String str;
        try {
            Log.i("SerialPort", "System.loadLibrary(serialport)");
            System.loadLibrary("wonder_serialport");
        } catch (SecurityException e2) {
            e = e2;
            str = "Error: System.load SecurityException";
            Log.e("SerialPort", str);
            e.printStackTrace();
        } catch (UnsatisfiedLinkError e3) {
            e = e3;
            str = "Error: System.load UnsatisfiedLinkError";
            Log.e("SerialPort", str);
            e.printStackTrace();
        }
    }

    private native void native_close(int i2);

    private native int native_open(String str, int i2);

    private native int native_readData(int i2, byte[] bArr, int i3, int i4);

    private native int native_setup(int i2, int i3, int i4, char c2, int i5);

    private native int native_writeData(int i2, byte[] bArr, int i3);

    public void close(int i2) {
        Log.i("SerialPort", "close fd:" + i2);
        native_close(i2);
    }

    public int open(String str, int i2) {
        int iNative_open = native_open(str, i2);
        Log.i("SerialPort", "open port:" + str + " baudrate:" + i2 + ", ret: " + iNative_open);
        return iNative_open;
    }

    public int readData(int i2, byte[] bArr) {
        return native_readData(i2, bArr, bArr.length, 0);
    }

    public int setup(int i2, int i3, int i4, char c2, int i5) {
        Log.i("SerialPort", "setup fd:" + i2 + " baudrate:" + i3 + ", nbits: " + i4 + ", parary: " + c2 + ", stopbits: " + i5);
        return native_setup(i2, i3, i4, c2, i5);
    }

    public int writeData(int i2, byte[] bArr) {
        return native_writeData(i2, bArr, bArr.length);
    }
}
