package com.wonder.dmr;

/* loaded from: classes.dex */
public class AnalogCommand {

    /* renamed from: a, reason: collision with root package name */
    public int f1626a;

    /* renamed from: b, reason: collision with root package name */
    public int f1627b;

    /* renamed from: c, reason: collision with root package name */
    public byte f1628c;

    /* renamed from: d, reason: collision with root package name */
    public byte f1629d;

    /* renamed from: e, reason: collision with root package name */
    public byte f1630e;

    /* renamed from: f, reason: collision with root package name */
    public byte f1631f;

    /* renamed from: g, reason: collision with root package name */
    public byte f1632g;

    /* renamed from: h, reason: collision with root package name */
    public byte f1633h;

    /* renamed from: i, reason: collision with root package name */
    public byte f1634i;

    /* renamed from: j, reason: collision with root package name */
    public byte f1635j;

    /* renamed from: k, reason: collision with root package name */
    public byte f1636k;

    /* renamed from: l, reason: collision with root package name */
    public byte f1637l;

    /* renamed from: m, reason: collision with root package name */
    public byte f1638m;

    public byte getBand() {
        return this.f1628c;
    }

    public byte getMonitor() {
        return this.f1637l;
    }

    public byte getPower() {
        return this.f1629d;
    }

    public byte getPwrsave() {
        return this.f1635j;
    }

    public byte getRelay() {
        return this.f1638m;
    }

    public int getRx_freq() {
        return this.f1626a;
    }

    public byte getRx_subcode() {
        return this.f1632g;
    }

    public byte getRx_type() {
        return this.f1631f;
    }

    public byte getSq() {
        return this.f1630e;
    }

    public int getTx_freq() {
        return this.f1627b;
    }

    public byte getTx_subcode() {
        return this.f1634i;
    }

    public byte getTx_type() {
        return this.f1633h;
    }

    public byte getVolume() {
        return this.f1636k;
    }

    public void setBand(byte b2) {
        this.f1628c = b2;
    }

    public void setMonitor(byte b2) {
        this.f1637l = b2;
    }

    public void setPower(byte b2) {
        this.f1629d = b2;
    }

    public void setPwrsave(byte b2) {
        this.f1635j = b2;
    }

    public void setRelay(byte b2) {
        this.f1638m = b2;
    }

    public void setRx_freq(int i2) {
        this.f1626a = i2;
    }

    public void setRx_subcode(byte b2) {
        this.f1632g = b2;
    }

    public void setRx_type(byte b2) {
        this.f1631f = b2;
    }

    public void setSq(byte b2) {
        this.f1630e = b2;
    }

    public void setTx_freq(int i2) {
        this.f1627b = i2;
    }

    public void setTx_subcode(byte b2) {
        this.f1634i = b2;
    }

    public void setTx_type(byte b2) {
        this.f1633h = b2;
    }

    public void setVolume(byte b2) {
        this.f1636k = b2;
    }

    public String toString() {
        return "AnalogCommand{rx_freq=" + this.f1626a + ", tx_freq=" + this.f1627b + ", band=" + ((int) this.f1628c) + ", power=" + ((int) this.f1629d) + ", sq=" + ((int) this.f1630e) + ", rx_type=" + ((int) this.f1631f) + ", rx_subcode=" + ((int) this.f1632g) + ", tx_type=" + ((int) this.f1633h) + ", tx_subcode=" + ((int) this.f1634i) + ", pwrsave=" + ((int) this.f1635j) + ", volume=" + ((int) this.f1636k) + ", monitor=" + ((int) this.f1637l) + ", relay=" + ((int) this.f1638m) + '}';
    }
}
