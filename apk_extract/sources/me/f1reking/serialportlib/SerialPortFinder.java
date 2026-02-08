package me.f1reking.serialportlib;

import android.util.Log;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import me.f1reking.serialportlib.entity.Device;
import me.f1reking.serialportlib.entity.Driver;

/* loaded from: classes.dex */
public class SerialPortFinder {
    private static final String DRIVERS_PATH = "/proc/tty/drivers";
    private static final String SERIAL_FIELD = "serial";
    private static final String TAG = "SerialPortFinder";

    public SerialPortFinder() {
        boolean zCanRead = new File(DRIVERS_PATH).canRead();
        Log.i(TAG, "SerialPortFinder: file.canRead() = " + zCanRead);
    }

    private ArrayList<Driver> getDrivers() throws IOException {
        ArrayList<Driver> arrayList = new ArrayList<>();
        LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(DRIVERS_PATH));
        while (true) {
            String line = lineNumberReader.readLine();
            if (line == null) {
                return arrayList;
            }
            String strTrim = line.substring(0, 21).trim();
            String[] strArrSplit = line.split(" +");
            if (strArrSplit.length >= 5 && strArrSplit[strArrSplit.length - 1].equals(SERIAL_FIELD)) {
                Log.d(TAG, "Found new driver " + strTrim + " on " + strArrSplit[strArrSplit.length - 4]);
                arrayList.add(new Driver(strTrim, strArrSplit[strArrSplit.length + (-4)]));
            }
        }
    }

    public String[] getAllDeicesPath() {
        Vector vector = new Vector();
        try {
            Iterator<Driver> it = getDrivers().iterator();
            while (it.hasNext()) {
                Iterator<File> it2 = it.next().getDevices().iterator();
                while (it2.hasNext()) {
                    vector.add(it2.next().getAbsolutePath());
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return (String[]) vector.toArray(new String[vector.size()]);
    }

    public List<Device> getAllDevices() {
        ArrayList arrayList = new ArrayList();
        try {
            for (Driver driver : getDrivers()) {
                String name = driver.getName();
                for (File file : driver.getDevices()) {
                    arrayList.add(new Device(file.getName(), name, file));
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    @Deprecated
    public ArrayList<Device> getDevices() {
        return (ArrayList) getAllDevices();
    }
}
