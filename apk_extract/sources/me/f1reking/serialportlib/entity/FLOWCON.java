package me.f1reking.serialportlib.entity;

/* loaded from: classes.dex */
public enum FLOWCON {
    NONE(0),
    HARD(1),
    SOFT(2);

    int flowCon;

    FLOWCON(int i2) {
        this.flowCon = i2;
    }

    public int getFlowCon() {
        return this.flowCon;
    }

    public static int getFlowCon(FLOWCON flowcon) {
        return flowcon.getFlowCon();
    }
}
