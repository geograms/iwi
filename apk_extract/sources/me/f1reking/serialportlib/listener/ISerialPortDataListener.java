package me.f1reking.serialportlib.listener;

/* loaded from: classes.dex */
public interface ISerialPortDataListener {
    void onDataReceived(byte[] bArr);

    void onDataSend(byte[] bArr);
}
