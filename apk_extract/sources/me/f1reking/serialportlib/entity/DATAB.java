package me.f1reking.serialportlib.entity;

/* loaded from: classes.dex */
public enum DATAB {
    CS5(5),
    CS6(6),
    CS7(7),
    CS8(8);

    int dataBit;

    DATAB(int i2) {
        this.dataBit = i2;
    }

    public int getDataBit() {
        return this.dataBit;
    }

    public static int getDataBit(DATAB datab) {
        return datab.getDataBit();
    }
}
