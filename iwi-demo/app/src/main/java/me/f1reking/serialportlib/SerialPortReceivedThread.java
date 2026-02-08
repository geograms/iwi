package me.f1reking.serialportlib;

import java.io.IOException;
import java.io.InputStream;

public abstract class SerialPortReceivedThread extends Thread {
    private boolean isStop = false;
    private InputStream mInputStream;

    public SerialPortReceivedThread(InputStream inputStream) {
        this.mInputStream = inputStream;
    }

    public abstract void onDataReceived(byte[] bArr);

    public void release() throws IOException {
        this.isStop = true;
        InputStream inputStream = this.mInputStream;
        if (inputStream != null) {
            inputStream.close();
            this.mInputStream = null;
        }
    }

    @Override
    public void run() {
        while (!this.isStop) {
            try {
                InputStream inputStream = this.mInputStream;
                if (inputStream == null) {
                    return;
                }
                int available = inputStream.available();
                if (available <= 0) {
                    continue;
                }
                byte[] bArr = new byte[available];
                int read = this.mInputStream.read(bArr);
                if (read > 0) {
                    onDataReceived(bArr);
                }
            } catch (IOException unused) {
                return;
            }
        }
    }
}
