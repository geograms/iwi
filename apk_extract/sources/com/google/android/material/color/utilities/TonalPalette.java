package com.google.android.material.color.utilities;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class TonalPalette {
    Map<Integer, Integer> cache = new HashMap();
    double chroma;
    double hue;

    private TonalPalette(double d2, double d3) {
        this.hue = d2;
        this.chroma = d3;
    }

    public static final TonalPalette fromHct(Hct hct) {
        return fromHueAndChroma(hct.getHue(), hct.getChroma());
    }

    public static final TonalPalette fromHueAndChroma(double d2, double d3) {
        return new TonalPalette(d2, d3);
    }

    public static final TonalPalette fromInt(int i2) {
        return fromHct(Hct.fromInt(i2));
    }

    public double getChroma() {
        return this.chroma;
    }

    public Hct getHct(double d2) {
        return Hct.from(this.hue, this.chroma, d2);
    }

    public double getHue() {
        return this.hue;
    }

    public int tone(int i2) {
        Integer numValueOf = this.cache.get(Integer.valueOf(i2));
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(Hct.from(this.hue, this.chroma, i2).toInt());
            this.cache.put(Integer.valueOf(i2), numValueOf);
        }
        return numValueOf.intValue();
    }
}
