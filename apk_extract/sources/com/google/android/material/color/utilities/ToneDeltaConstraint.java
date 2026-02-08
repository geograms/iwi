package com.google.android.material.color.utilities;

/* loaded from: classes.dex */
public final class ToneDeltaConstraint {
    public final double delta;
    public final DynamicColor keepAway;
    public final TonePolarity keepAwayPolarity;

    public ToneDeltaConstraint(double d2, DynamicColor dynamicColor, TonePolarity tonePolarity) {
        this.delta = d2;
        this.keepAway = dynamicColor;
        this.keepAwayPolarity = tonePolarity;
    }
}
