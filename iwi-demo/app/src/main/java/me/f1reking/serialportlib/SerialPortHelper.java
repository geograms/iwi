package me.f1reking.serialportlib;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import me.f1reking.serialportlib.listener.IOpenSerialPortListener;
import me.f1reking.serialportlib.listener.ISerialPortDataListener;
import me.f1reking.serialportlib.listener.Status;
import me.f1reking.serialportlib.util.ByteUtils;

/**
 * Trimmed version of the stock SerialPortHelper (me.f1reking). Only the pieces needed for
 * opening/writing ttyS1 are retained.
 */
public class SerialPortHelper {
    private static final String TAG = "SerialPortHelper";
    private static int mBaudRate;
    private static int mDataBits;
    private static int mFlags;
    private static int mFlowCon;
    private static int mParity;
    private static String mPort;
    private static int mStopBits;
    private boolean isOpen = false;
    private FileDescriptor mFD;
    private FileInputStream mFileInputStream;
    private FileOutputStream mFileOutputStream;
    private IOpenSerialPortListener mIOpenSerialPortListener;
    private ISerialPortDataListener mISerialPortDataListener;
    private Handler mSendingHandler;
    private HandlerThread mSendingHandlerThread;
    private SerialPortReceivedThread mSerialPortReceivedThread;

    public static class Builder {
        public Builder(String str, int i2) {
            mPort = str;
            mBaudRate = i2;
        }

        public SerialPortHelper build() {
            return new SerialPortHelper();
        }

        public Builder setDataBits(int i2) {
            mDataBits = i2;
            return this;
        }

        public Builder setFlags(int i2) {
            mFlags = i2;
            return this;
        }

        public Builder setFlowCon(int i2) {
            mFlowCon = i2;
            return this;
        }

        public Builder setParity(int i2) {
            mParity = i2;
            return this;
        }

        public Builder setStopBits(int i2) {
            mStopBits = i2;
            return this;
        }
    }

    static {
        System.loadLibrary("serialport");
        mPort = "/dev/ttyUSB0";
        mBaudRate = 115200;
        mStopBits = 2;
        mDataBits = 8;
        mParity = 0;
        mFlowCon = 0;
        mFlags = 0;
    }

    private boolean chmod777(File file) throws IOException {
        if (file != null && file.exists()) {
            try {
                Process processExec = Runtime.getRuntime().exec("/system/bin/su");
                processExec.getOutputStream().write(("chmod 777" + file.getAbsolutePath() + "\nexit\n").getBytes());
                if (processExec.waitFor() == 0 && file.canRead() && file.canWrite()) {
                    if (file.canExecute()) {
                        return true;
                    }
                }
            } catch (IOException | InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    private void closeSafe() throws IOException {
        if (this.mFD != null) {
            nativeClose();
            this.mFD = null;
        }
        if (this.mFileInputStream != null) {
            try {
                this.mFileInputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.mFileInputStream = null;
        }
        if (this.mFileOutputStream != null) {
            try {
                this.mFileOutputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            this.mFileOutputStream = null;
        }
    }

    private void closeSerialPort() throws IOException {
        stopSendThread();
        stopReceivedThread();
        closeSafe();
        this.isOpen = false;
    }

    private static native FileDescriptor nativeOpen(String str, int i2, int i3, int i4, int i5, int i6, int i7);

    private boolean openSafe(File file, int i2, int i3, int i4, int i5, int i6, int i7) {
        String str = TAG;
        Log.i(str, String.format("SerialPort: %s: %d,%d,%d,%d,%d,%d", file.getPath(), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)));
        try {
            if ((!file.canRead() || !file.canWrite()) && !chmod777(file)) {
                Log.e(str, file.getPath() + " : no read/write permission");
                IOpenSerialPortListener iOpenSerialPortListener = this.mIOpenSerialPortListener;
                if (iOpenSerialPortListener != null) {
                    iOpenSerialPortListener.onFail(file, Status.NO_READ_WRITE_PERMISSION);
                }
                return false;
            }
        } catch (Exception ePerm) {
            Log.e(str, "chmod failed", ePerm);
            return false;
        }
        try {
            this.mFD = nativeOpen(file.getAbsolutePath(), i2, i3, i4, i5, i6, i7);
            this.mFileInputStream = new FileInputStream(this.mFD);
            this.mFileOutputStream = new FileOutputStream(this.mFD);
            startSendThread();
            startReceivedThread();
            IOpenSerialPortListener iOpenSerialPortListener2 = this.mIOpenSerialPortListener;
            if (iOpenSerialPortListener2 != null) {
                iOpenSerialPortListener2.onSuccess(file);
            }
            Log.i(str, file.getPath() + " : port opened");
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            IOpenSerialPortListener iOpenSerialPortListener3 = this.mIOpenSerialPortListener;
            if (iOpenSerialPortListener3 != null) {
                iOpenSerialPortListener3.onFail(file, Status.OPEN_FAIL);
            }
            return false;
        }
    }

    private boolean openSerialPort(File file, int i2, int i3, int i4, int i5, int i6, int i7) {
        boolean zOpenSafe = openSafe(file, i2, i3, i4, i5, i6, i7);
        this.isOpen = zOpenSafe;
        return zOpenSafe;
    }

    private void startReceivedThread() {
        SerialPortReceivedThread serialPortReceivedThread = new SerialPortReceivedThread(this.mFileInputStream) {
            @Override
            public void onDataReceived(byte[] bArr) {
                if (SerialPortHelper.this.mISerialPortDataListener != null) {
                    SerialPortHelper.this.mISerialPortDataListener.onDataReceived(bArr);
                }
            }
        };
        this.mSerialPortReceivedThread = serialPortReceivedThread;
        serialPortReceivedThread.start();
    }

    private void startSendThread() {
        HandlerThread handlerThread = new HandlerThread("mSendingHandlerThread");
        this.mSendingHandlerThread = handlerThread;
        handlerThread.start();
        this.mSendingHandler = new Handler(this.mSendingHandlerThread.getLooper()) {
            @Override
            public void handleMessage(Message message) {
                byte[] bArr = (byte[]) message.obj;
                if (SerialPortHelper.this.mFileOutputStream == null || bArr == null || bArr.length <= 0) {
                    return;
                }
                try {
                    SerialPortHelper.this.mFileOutputStream.write(bArr);
                    if (SerialPortHelper.this.mISerialPortDataListener != null) {
                        SerialPortHelper.this.mISerialPortDataListener.onDataSend(bArr);
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        };
    }

    private void stopReceivedThread() throws IOException {
        SerialPortReceivedThread serialPortReceivedThread = this.mSerialPortReceivedThread;
        if (serialPortReceivedThread != null) {
            serialPortReceivedThread.release();
        }
    }

    private void stopSendThread() {
        this.mSendingHandler = null;
        HandlerThread handlerThread = this.mSendingHandlerThread;
        if (handlerThread != null) {
            handlerThread.interrupt();
            this.mSendingHandlerThread.quit();
            this.mSendingHandlerThread = null;
        }
    }

    public void close() throws IOException {
        closeSerialPort();
    }

    public int getBaudRate() {
        return mBaudRate;
    }

    public int getDataBits() {
        return mDataBits;
    }

    public int getFlags() {
        return mFlags;
    }

    public int getFlowCon() {
        return mFlowCon;
    }

    public int getParity() {
        return mParity;
    }

    public String getPort() {
        return mPort;
    }

    public int getStopBits() {
        return mStopBits;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public native void nativeClose();

    public boolean open() {
        return openSerialPort(new File(mPort), mBaudRate, mStopBits, mDataBits, mParity, mFlowCon, mFlags);
    }

    public boolean sendBytes(byte[] bArr) {
        if (this.mSendingHandler == null) {
            return false;
        }
        Message messageObtain = Message.obtain();
        messageObtain.obj = bArr;
        return this.mSendingHandler.sendMessage(messageObtain);
    }

    public void sendHex(String str) {
        sendBytes(ByteUtils.hexToByteArr(str));
    }

    public void sendTxt(String str) {
        sendBytes(str.getBytes());
    }

    public boolean setBaudRate(int i2) {
        if (this.isOpen) {
            return false;
        }
        mBaudRate = i2;
        return true;
    }

    public boolean setDataBits(int i2) {
        if (this.isOpen) {
            return false;
        }
        mDataBits = i2;
        return true;
    }

    public boolean setFlags(int i2) {
        if (this.isOpen) {
            return false;
        }
        mFlags = i2;
        return true;
    }

    public boolean setFlowCon(int i2) {
        if (this.isOpen) {
            return false;
        }
        mFlowCon = i2;
        return true;
    }

    public void setIOpenSerialPortListener(IOpenSerialPortListener iOpenSerialPortListener) {
        this.mIOpenSerialPortListener = iOpenSerialPortListener;
    }

    public void setISerialPortDataListener(ISerialPortDataListener iSerialPortDataListener) {
        this.mISerialPortDataListener = iSerialPortDataListener;
    }

    public boolean setParity(int i2) {
        if (this.isOpen) {
            return false;
        }
        mParity = i2;
        return true;
    }

    public boolean setPort(String str) {
        if (this.isOpen) {
            return false;
        }
        mPort = str;
        return true;
    }

    public boolean setStopBits(int i2) {
        if (this.isOpen) {
            return false;
        }
        mStopBits = i2;
        return true;
    }
}
