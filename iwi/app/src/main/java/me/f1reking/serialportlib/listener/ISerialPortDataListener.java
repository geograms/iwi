package me.f1reking.serialportlib.listener;

public interface ISerialPortDataListener {
    void onDataReceived(byte[] bArr);
    void onDataSend(byte[] bArr);
}
