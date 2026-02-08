package me.f1reking.serialportlib.listener;

import java.io.File;

public interface IOpenSerialPortListener {
    void onFail(File file, Status status);
    void onSuccess(File file);
}
