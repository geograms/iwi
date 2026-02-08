package com.wonder.dmr;

import java.util.Arrays;

/* loaded from: classes.dex */
public class DigitalCommand {

    /* renamed from: a, reason: collision with root package name */
    public int f1639a;

    /* renamed from: b, reason: collision with root package name */
    public int f1640b;

    /* renamed from: c, reason: collision with root package name */
    public int f1641c;

    /* renamed from: e, reason: collision with root package name */
    public int f1643e;

    /* renamed from: f, reason: collision with root package name */
    public byte f1644f;

    /* renamed from: g, reason: collision with root package name */
    public byte f1645g;

    /* renamed from: h, reason: collision with root package name */
    public byte f1646h;

    /* renamed from: i, reason: collision with root package name */
    public byte f1647i;

    /* renamed from: j, reason: collision with root package name */
    public byte f1648j;

    /* renamed from: k, reason: collision with root package name */
    public byte f1649k;

    /* renamed from: l, reason: collision with root package name */
    public byte f1650l;

    /* renamed from: n, reason: collision with root package name */
    public byte f1652n;

    /* renamed from: o, reason: collision with root package name */
    public byte f1653o;

    /* renamed from: p, reason: collision with root package name */
    public byte f1654p;

    /* renamed from: q, reason: collision with root package name */
    public byte f1655q;

    /* renamed from: d, reason: collision with root package name */
    public int[] f1642d = new int[32];

    /* renamed from: m, reason: collision with root package name */
    public byte[] f1651m = new byte[8];

    public byte getCc() {
        return this.f1646h;
    }

    public byte getChannelMode() {
        return this.f1649k;
    }

    public byte getContactType() {
        return this.f1644f;
    }

    public byte[] getEncryptKey() {
        return this.f1651m;
    }

    public byte getEncryptSw() {
        return this.f1650l;
    }

    public int[] getGroupList() {
        return this.f1642d;
    }

    public byte getInboundSlot() {
        return this.f1647i;
    }

    public int getLocalId() {
        return this.f1641c;
    }

    public byte getMic() {
        return this.f1654p;
    }

    public byte getOutboundSlot() {
        return this.f1648j;
    }

    public byte getPower() {
        return this.f1645g;
    }

    public byte getPwrsave() {
        return this.f1652n;
    }

    public byte getRelay() {
        return this.f1655q;
    }

    public int getRx_freq() {
        return this.f1639a;
    }

    public int getTx_contact() {
        return this.f1643e;
    }

    public int getTx_freq() {
        return this.f1640b;
    }

    public byte getVolume() {
        return this.f1653o;
    }

    public void setCc(byte b2) {
        this.f1646h = b2;
    }

    public void setChannelMode(byte b2) {
        this.f1649k = b2;
    }

    public void setContactType(byte b2) {
        this.f1644f = b2;
    }

    public void setEncryptKey(byte[] bArr) {
        this.f1651m = bArr;
    }

    public void setEncryptSw(byte b2) {
        this.f1650l = b2;
    }

    public void setGroupList(int[] iArr) {
        this.f1642d = iArr;
    }

    public void setInboundSlot(byte b2) {
        this.f1647i = b2;
    }

    public void setLocalId(int i2) {
        this.f1641c = i2;
    }

    public void setMic(byte b2) {
        this.f1654p = b2;
    }

    public void setOutboundSlot(byte b2) {
        this.f1648j = b2;
    }

    public void setPower(byte b2) {
        this.f1645g = b2;
    }

    public void setPwrsave(byte b2) {
        this.f1652n = b2;
    }

    public void setRelay(byte b2) {
        this.f1655q = b2;
    }

    public void setRx_freq(int i2) {
        this.f1639a = i2;
    }

    public void setTx_contact(int i2) {
        this.f1643e = i2;
    }

    public void setTx_freq(int i2) {
        this.f1640b = i2;
    }

    public void setVolume(byte b2) {
        this.f1653o = b2;
    }

    public String toString() {
        return "DigitalCommand{rx_freq=" + this.f1639a + ", tx_freq=" + this.f1640b + ", localId=" + this.f1641c + ", groupList=" + Arrays.toString(this.f1642d) + ", tx_contact=" + this.f1643e + ", contactType=" + ((int) this.f1644f) + ", power=" + ((int) this.f1645g) + ", cc=" + ((int) this.f1646h) + ", inboundSlot=" + ((int) this.f1647i) + ", outboundSlot=" + ((int) this.f1648j) + ", channelMode=" + ((int) this.f1649k) + ", encryptSw=" + ((int) this.f1650l) + ", encryptKey=" + Arrays.toString(this.f1651m) + ", pwrsave=" + ((int) this.f1652n) + ", volume=" + ((int) this.f1653o) + ", mic=" + ((int) this.f1654p) + ", relay=" + ((int) this.f1655q) + '}';
    }
}
