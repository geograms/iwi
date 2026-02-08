package me.f1reking.serialportlib.entity;

/* loaded from: classes.dex */
public enum STOPB {
    B1(1),
    B2(2);

    int stopBit;

    STOPB(int i2) {
        this.stopBit = i2;
    }

    public int getStopBit() {
        return this.stopBit;
    }

    public static int getStopBit(STOPB stopb) {
        return stopb.getStopBit();
    }
}
