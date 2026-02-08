package com.wonder.serial;

import a.b;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.constraintlayout.solver.widgets.Optimizer;

/* loaded from: classes.dex */
public class SerialTools {

    /* renamed from: h, reason: collision with root package name */
    public static volatile SerialTools f1687h;

    /* renamed from: a, reason: collision with root package name */
    public int f1688a;

    /* renamed from: g, reason: collision with root package name */
    public SerialPort f1694g;

    /* renamed from: b, reason: collision with root package name */
    public Handler f1689b = null;

    /* renamed from: c, reason: collision with root package name */
    public HandlerThread f1690c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1691d = true;

    /* renamed from: e, reason: collision with root package name */
    public SendHandler f1692e = null;

    /* renamed from: f, reason: collision with root package name */
    public int f1693f = 10;
    public OnDataReceiveListener onDataReceiveListener = null;

    public class SendHandler extends Handler {
        public SendHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 256) {
                return;
            }
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null) {
                Log.e("com.wonder.serial.SerialTools", "MSG_WRITE_TO_PORT, error, data is null");
            }
            if (bArr != null) {
                SerialTools serialTools = SerialTools.this;
                Log.v("com.wonder.serial.SerialTools", "app2dev, len: " + serialTools.f1694g.writeData(serialTools.f1688a, bArr) + ", data: " + new String(bArr));
            }
        }
    }

    public class SendThread extends HandlerThread {
        public SendThread(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            SerialTools.this.f1692e = SerialTools.this.new SendHandler(getLooper());
        }
    }

    public class a extends Thread {
        public a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            Log.d("com.wonder.serial.SerialTools", "进入接收线程run");
            while (true) {
                SerialTools serialTools = SerialTools.this;
                if (serialTools.f1691d) {
                    return;
                }
                byte[] bArr = new byte[64];
                int data = serialTools.f1694g.readData(serialTools.f1688a, bArr);
                if (data > 0) {
                    byte[] bArr2 = new byte[data];
                    System.arraycopy(bArr, 0, bArr2, 0, data);
                    SerialTools serialTools2 = SerialTools.this;
                    Message messageObtainMessage = serialTools2.f1689b.obtainMessage();
                    messageObtainMessage.what = Optimizer.OPTIMIZATION_DEPENDENCY_ORDERING;
                    messageObtainMessage.obj = bArr2;
                    messageObtainMessage.arg1 = data;
                    serialTools2.f1689b.sendMessage(messageObtainMessage);
                }
            }
        }
    }

    public SerialTools() {
        Log.d("com.wonder.serial.SerialTools", "SerialTools, Instance________________");
        a();
    }

    public static SerialTools getInstance() {
        if (f1687h == null) {
            synchronized (SerialTools.class) {
                try {
                    if (f1687h == null) {
                        f1687h = new SerialTools();
                    }
                } finally {
                }
            }
        }
        return f1687h;
    }

    public final void a() {
        this.f1694g = new SerialPort();
        HandlerThread handlerThread = new HandlerThread("handlerThread");
        this.f1690c = handlerThread;
        handlerThread.start();
        this.f1689b = new b(this, this.f1690c.getLooper(), 1);
    }

    public void closeSerial() {
        int i2 = this.f1688a;
        if (i2 > 0) {
            this.f1694g.close(i2);
            this.f1691d = true;
            this.f1688a = 0;
        }
    }

    public int openSerial(String str, int i2) {
        int iOpen = this.f1694g.open(str, i2);
        this.f1688a = iOpen;
        if (iOpen > 0) {
            this.f1691d = false;
            new a().start();
            new SendThread("vanzeak.Serial sendThread").start();
        }
        return this.f1688a;
    }

    public void sendBytes(byte[] bArr) {
        SendHandler sendHandler;
        if (this.f1688a <= 0 || (sendHandler = this.f1692e) == null) {
            return;
        }
        Message messageObtainMessage = sendHandler.obtainMessage();
        messageObtainMessage.what = 256;
        messageObtainMessage.obj = bArr;
        this.f1692e.sendMessageDelayed(messageObtainMessage, this.f1693f);
    }

    public void setDelayWriteDataTime(int i2) {
        this.f1693f = i2;
    }

    public void setOnDataReceiveListener(OnDataReceiveListener onDataReceiveListener) {
        this.onDataReceiveListener = onDataReceiveListener;
    }

    public int setupSerial(int i2, int i3, char c2, int i4) {
        int i5 = this.f1688a;
        if (i5 > 0) {
            return this.f1694g.setup(i5, i2, i3, c2, i4);
        }
        return -1;
    }

    public void closeSerial(int i2) {
        if (this.f1688a > 0) {
            this.f1694g.close(i2);
            this.f1691d = true;
            this.f1688a = 0;
        }
    }
}
