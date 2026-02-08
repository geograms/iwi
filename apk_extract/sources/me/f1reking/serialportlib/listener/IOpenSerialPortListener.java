package me.f1reking.serialportlib.listener;

import java.io.File;

/* loaded from: classes.dex */
public interface IOpenSerialPortListener {
    void onFail(File file, Status status);

    void onSuccess(File file);
}
