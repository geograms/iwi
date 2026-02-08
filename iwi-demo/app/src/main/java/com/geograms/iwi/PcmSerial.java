package com.geograms.iwi;

import android.util.Log;
import java.io.FileDescriptor;
import java.io.FileOutputStream;

/**
 * Minimal wrapper around libserialport for the high-speed PCM UART (ttyS1).
 * Only implements the pieces we need: open, write, close.
 */
public class PcmSerial {
    private static final String TAG = "PcmSerial";

    static {
        try {
            System.loadLibrary("serialport");
            Log.i(TAG, "Loaded libserialport.so");
        } catch (UnsatisfiedLinkError e) {
            Log.e(TAG, "Failed to load libserialport.so", e);
        }
    }

    private native FileDescriptor nativeOpen(String path, int baudrate,
                                            int dataBits, int stopBits,
                                            int parity, int flowCon, int flags);
    private native void nativeClose();

    private FileDescriptor fd;
    private FileOutputStream out;

    public boolean open(String path, int baudrate, int dataBits, int stopBits, int parity, int flowCon, int flags) {
        try {
            fd = nativeOpen(path, baudrate, dataBits, stopBits, parity, flowCon, flags);
            if (fd == null) {
                Log.e(TAG, "nativeOpen returned null");
                return false;
            }
            out = new FileOutputStream(fd);
            return true;
        } catch (Exception e) {
            Log.e(TAG, "PCM open failed", e);
            return false;
        }
    }

    public int write(byte[] data) {
        if (out == null) return -1;
        try {
            out.write(data);
            return data.length;
        } catch (Exception e) {
            Log.e(TAG, "PCM write failed", e);
            return -1;
        }
    }

    public void close() {
        try {
            if (out != null) {
                out.close();
                out = null;
            }
            nativeClose();
        } catch (Exception e) {
            Log.w(TAG, "PCM close error", e);
        }
        fd = null;
    }
}
