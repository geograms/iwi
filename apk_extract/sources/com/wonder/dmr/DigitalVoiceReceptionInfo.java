package com.wonder.dmr;

/* loaded from: classes.dex */
public class DigitalVoiceReceptionInfo {
    public static int BROADCAST = 2;
    public static int GROUP = 1;
    public static int PERSONAL;

    /* renamed from: a, reason: collision with root package name */
    public int f1656a;

    /* renamed from: b, reason: collision with root package name */
    public int f1657b;

    /* renamed from: c, reason: collision with root package name */
    public int f1658c;

    public int getId() {
        return this.f1657b;
    }

    public int getNumber() {
        return this.f1658c;
    }

    public int getType() {
        return this.f1656a;
    }

    public void setId(int i2) {
        this.f1657b = i2;
    }

    public void setNumber(int i2) {
        this.f1658c = i2;
    }

    public void setType(int i2) {
        this.f1656a = i2;
    }
}
