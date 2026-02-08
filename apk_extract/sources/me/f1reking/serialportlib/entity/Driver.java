package me.f1reking.serialportlib.entity;

import android.util.Log;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class Driver {
    private static final String TAG = "Driver";
    private String deviceRoot;
    private String driverName;

    public Driver(String str, String str2) {
        this.driverName = str;
        this.deviceRoot = str2;
    }

    public ArrayList<File> getDevices() {
        ArrayList<File> arrayList = new ArrayList<>();
        File file = new File("/dev");
        if (!file.exists()) {
            Log.i(TAG, "getDevices: " + file.getAbsolutePath() + " no found");
            return arrayList;
        }
        if (!file.canRead()) {
            Log.i(TAG, "getDevices: " + file.getAbsolutePath() + " no read permissions");
            return arrayList;
        }
        File[] fileArrListFiles = file.listFiles();
        for (int i2 = 0; i2 < fileArrListFiles.length; i2++) {
            if (fileArrListFiles[i2].getAbsolutePath().startsWith(this.deviceRoot)) {
                Log.d(TAG, "Found new device: " + fileArrListFiles[i2]);
                arrayList.add(fileArrListFiles[i2]);
            }
        }
        return arrayList;
    }

    public String getName() {
        return this.driverName;
    }
}
