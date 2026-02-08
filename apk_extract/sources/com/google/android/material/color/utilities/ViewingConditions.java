package com.google.android.material.color.utilities;

/* loaded from: classes.dex */
public final class ViewingConditions {
    public static final ViewingConditions DEFAULT = defaultWithBackgroundLstar(50.0d);
    private final double aw;

    /* renamed from: c, reason: collision with root package name */
    private final double f1540c;
    private final double fl;
    private final double flRoot;

    /* renamed from: n, reason: collision with root package name */
    private final double f1541n;
    private final double nbb;
    private final double nc;
    private final double ncb;
    private final double[] rgbD;

    /* renamed from: z, reason: collision with root package name */
    private final double f1542z;

    private ViewingConditions(double d2, double d3, double d4, double d5, double d6, double d7, double[] dArr, double d8, double d9, double d10) {
        this.f1541n = d2;
        this.aw = d3;
        this.nbb = d4;
        this.ncb = d5;
        this.f1540c = d6;
        this.nc = d7;
        this.rgbD = dArr;
        this.fl = d8;
        this.flRoot = d9;
        this.f1542z = d10;
    }

    public static ViewingConditions defaultWithBackgroundLstar(double d2) {
        return make(ColorUtils.whitePointD65(), (ColorUtils.yFromLstar(50.0d) * 63.66197723675813d) / 100.0d, d2, 2.0d, false);
    }

    public static ViewingConditions make(double[] dArr, double d2, double d3, double d4, boolean z2) {
        double dMax = Math.max(0.1d, d3);
        double[][] dArr2 = Cam16.XYZ_TO_CAM16RGB;
        double d5 = dArr[0];
        double[] dArr3 = dArr2[0];
        double d6 = dArr3[0] * d5;
        double d7 = dArr[1];
        double d8 = (dArr3[1] * d7) + d6;
        double d9 = dArr[2];
        double d10 = (dArr3[2] * d9) + d8;
        double[] dArr4 = dArr2[1];
        double d11 = (dArr4[2] * d9) + (dArr4[1] * d7) + (dArr4[0] * d5);
        double[] dArr5 = dArr2[2];
        double d12 = (d9 * dArr5[2]) + (d7 * dArr5[1]) + (d5 * dArr5[0]);
        double d13 = (d4 / 10.0d) + 0.8d;
        double dLerp = d13 >= 0.9d ? MathUtils.lerp(0.59d, 0.69d, (d13 - 0.9d) * 10.0d) : MathUtils.lerp(0.525d, 0.59d, (d13 - 0.8d) * 10.0d);
        double dClampDouble = MathUtils.clampDouble(0.0d, 1.0d, z2 ? 1.0d : (1.0d - (Math.exp(((-d2) - 42.0d) / 92.0d) * 0.2777777777777778d)) * d13);
        double[] dArr6 = {(((100.0d / d10) * dClampDouble) + 1.0d) - dClampDouble, (((100.0d / d11) * dClampDouble) + 1.0d) - dClampDouble, (((100.0d / d12) * dClampDouble) + 1.0d) - dClampDouble};
        double d14 = 5.0d * d2;
        double d15 = 1.0d / (d14 + 1.0d);
        double d16 = d15 * d15 * d15 * d15;
        double d17 = 1.0d - d16;
        double dCbrt = (Math.cbrt(d14) * 0.1d * d17 * d17) + (d16 * d2);
        double dYFromLstar = ColorUtils.yFromLstar(dMax) / dArr[1];
        double dSqrt = Math.sqrt(dYFromLstar) + 1.48d;
        double dPow = 0.725d / Math.pow(dYFromLstar, 0.2d);
        double dPow2 = Math.pow(((dArr6[2] * dCbrt) * d12) / 100.0d, 0.42d);
        double[] dArr7 = {Math.pow(((dArr6[0] * dCbrt) * d10) / 100.0d, 0.42d), Math.pow(((dArr6[1] * dCbrt) * d11) / 100.0d, 0.42d), dPow2};
        double d18 = dArr7[0];
        double d19 = dArr7[1];
        return new ViewingConditions(dYFromLstar, ((((400.0d * dPow2) / (dPow2 + 27.13d)) * 0.05d) + (((d18 * 400.0d) / (d18 + 27.13d)) * 2.0d) + ((d19 * 400.0d) / (d19 + 27.13d))) * dPow, dPow, dPow, dLerp, d13, dArr6, dCbrt, Math.pow(dCbrt, 0.25d), dSqrt);
    }

    public double getAw() {
        return this.aw;
    }

    public double getC() {
        return this.f1540c;
    }

    public double getFl() {
        return this.fl;
    }

    public double getFlRoot() {
        return this.flRoot;
    }

    public double getN() {
        return this.f1541n;
    }

    public double getNbb() {
        return this.nbb;
    }

    public double getNc() {
        return this.nc;
    }

    public double getNcb() {
        return this.ncb;
    }

    public double[] getRgbD() {
        return this.rgbD;
    }

    public double getZ() {
        return this.f1542z;
    }
}
