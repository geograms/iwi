package me.f1reking.serialportlib;

import androidx.constraintlayout.solver.widgets.Optimizer;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public abstract class SerialPortReceivedThread extends Thread {
    private static final String TAG = "SerialPortReceivedThread";
    private InputStream mInputStream;
    private byte[] mReceivedBuffer = new byte[Optimizer.OPTIMIZATION_GROUPING];

    public SerialPortReceivedThread(InputStream inputStream) {
        this.mInputStream = inputStream;
    }

    public abstract void onDataReceived(byte[] bArr);

    public void release() throws IOException {
        interrupt();
        InputStream inputStream = this.mInputStream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.mInputStream = null;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        InputStream inputStream;
        int i2;
        super.run();
        while (!isInterrupted()) {
            try {
                inputStream = this.mInputStream;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            if (inputStream == null || (i2 = inputStream.read(this.mReceivedBuffer)) <= 0) {
                return;
            }
            byte[] bArr = new byte[i2];
            System.arraycopy(this.mReceivedBuffer, 0, bArr, 0, i2);
            onDataReceived(bArr);
        }
    }
}
