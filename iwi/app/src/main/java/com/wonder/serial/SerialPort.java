package com.wonder.serial;

import android.util.Log;

/**
 * JNI wrapper — must be in com.wonder.serial package to match
 * the native method symbols in libwonder_serialport.so.
 */
public class SerialPort {
    private static final String TAG = "SerialPort";

    static {
        try {
            System.loadLibrary("wonder_serialport");
            Log.i(TAG, "Loaded libwonder_serialport.so");
        } catch (UnsatisfiedLinkError e) {
            Log.e(TAG, "Failed to load libwonder_serialport.so", e);
        }
    }

    private native int native_open(String port, int baudrate);
    private native void native_close(int fd);
    private native int native_readData(int fd, byte[] buf, int len, int timeout);
    private native int native_writeData(int fd, byte[] buf, int len);
    private native int native_setup(int fd, int baudrate, int nbits, char parity, int stopbits);

    public int open(String port, int baudrate) {
        int fd = native_open(port, baudrate);
        Log.i(TAG, "open port:" + port + " baudrate:" + baudrate + " fd:" + fd);
        return fd;
    }

    public void close(int fd) {
        Log.i(TAG, "close fd:" + fd);
        native_close(fd);
    }

    public int readData(int fd, byte[] buf) {
        return native_readData(fd, buf, buf.length, 0);
    }

    public int writeData(int fd, byte[] buf) {
        return native_writeData(fd, buf, buf.length);
    }

    public int setup(int fd, int baudrate, int nbits, char parity, int stopbits) {
        return native_setup(fd, baudrate, nbits, parity, stopbits);
    }
}
