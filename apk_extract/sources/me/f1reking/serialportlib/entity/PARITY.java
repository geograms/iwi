package me.f1reking.serialportlib.entity;

/* loaded from: classes.dex */
public enum PARITY {
    NONE(0),
    ODD(1),
    EVEN(2);

    int parity;

    PARITY(int i2) {
        this.parity = i2;
    }

    public int getParity() {
        return this.parity;
    }

    public static int getParity(PARITY parity) {
        return parity.getParity();
    }
}
