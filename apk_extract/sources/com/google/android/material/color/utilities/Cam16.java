package com.google.android.material.color.utilities;

/* loaded from: classes.dex */
public final class Cam16 {
    private final double astar;
    private final double bstar;
    private final double chroma;
    private final double hue;

    /* renamed from: j, reason: collision with root package name */
    private final double f1529j;
    private final double jstar;

    /* renamed from: m, reason: collision with root package name */
    private final double f1530m;

    /* renamed from: q, reason: collision with root package name */
    private final double f1531q;

    /* renamed from: s, reason: collision with root package name */
    private final double f1532s;
    private final double[] tempArray = {0.0d, 0.0d, 0.0d};
    static final double[][] XYZ_TO_CAM16RGB = {new double[]{0.401288d, 0.650173d, -0.051461d}, new double[]{-0.250268d, 1.204414d, 0.045854d}, new double[]{-0.002079d, 0.048952d, 0.953127d}};
    static final double[][] CAM16RGB_TO_XYZ = {new double[]{1.8620678d, -1.0112547d, 0.14918678d}, new double[]{0.38752654d, 0.62144744d, -0.00897398d}, new double[]{-0.0158415d, -0.03412294d, 1.0499644d}};

    private Cam16(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        this.hue = d2;
        this.chroma = d3;
        this.f1529j = d4;
        this.f1531q = d5;
        this.f1530m = d6;
        this.f1532s = d7;
        this.jstar = d8;
        this.astar = d9;
        this.bstar = d10;
    }

    public static Cam16 fromInt(int i2) {
        return fromIntInViewingConditions(i2, ViewingConditions.DEFAULT);
    }

    public static Cam16 fromIntInViewingConditions(int i2, ViewingConditions viewingConditions) {
        double dLinearized = ColorUtils.linearized((16711680 & i2) >> 16);
        double dLinearized2 = ColorUtils.linearized((65280 & i2) >> 8);
        double dLinearized3 = ColorUtils.linearized(i2 & 255);
        return fromXyzInViewingConditions((0.18051042d * dLinearized3) + (0.35762064d * dLinearized2) + (0.41233895d * dLinearized), (0.0722d * dLinearized3) + (0.7152d * dLinearized2) + (0.2126d * dLinearized), (dLinearized3 * 0.95034478d) + (dLinearized2 * 0.11916382d) + (dLinearized * 0.01932141d), viewingConditions);
    }

    public static Cam16 fromJch(double d2, double d3, double d4) {
        return fromJchInViewingConditions(d2, d3, d4, ViewingConditions.DEFAULT);
    }

    private static Cam16 fromJchInViewingConditions(double d2, double d3, double d4, ViewingConditions viewingConditions) {
        double d5 = d2 / 100.0d;
        double aw = (viewingConditions.getAw() + 4.0d) * Math.sqrt(d5) * (4.0d / viewingConditions.getC()) * viewingConditions.getFlRoot();
        double flRoot = viewingConditions.getFlRoot() * d3;
        double dSqrt = Math.sqrt((viewingConditions.getC() * (d3 / Math.sqrt(d5))) / (viewingConditions.getAw() + 4.0d)) * 50.0d;
        double radians = Math.toRadians(d4);
        double d6 = (1.7000000000000002d * d2) / ((0.007d * d2) + 1.0d);
        double dLog1p = 43.859649122807014d * Math.log1p(flRoot * 0.0228d);
        return new Cam16(d4, d3, d2, aw, flRoot, dSqrt, d6, Math.cos(radians) * dLog1p, Math.sin(radians) * dLog1p);
    }

    public static Cam16 fromUcs(double d2, double d3, double d4) {
        return fromUcsInViewingConditions(d2, d3, d4, ViewingConditions.DEFAULT);
    }

    public static Cam16 fromUcsInViewingConditions(double d2, double d3, double d4, ViewingConditions viewingConditions) {
        double dExpm1 = (Math.expm1(Math.hypot(d3, d4) * 0.0228d) / 0.0228d) / viewingConditions.getFlRoot();
        double dAtan2 = Math.atan2(d4, d3) * 57.29577951308232d;
        if (dAtan2 < 0.0d) {
            dAtan2 += 360.0d;
        }
        return fromJchInViewingConditions(d2 / (1.0d - ((d2 - 100.0d) * 0.007d)), dExpm1, dAtan2, viewingConditions);
    }

    public static Cam16 fromXyzInViewingConditions(double d2, double d3, double d4, ViewingConditions viewingConditions) {
        double[][] dArr = XYZ_TO_CAM16RGB;
        double[] dArr2 = dArr[0];
        double d5 = (dArr2[2] * d4) + (dArr2[1] * d3) + (dArr2[0] * d2);
        double[] dArr3 = dArr[1];
        double d6 = (dArr3[2] * d4) + (dArr3[1] * d3) + (dArr3[0] * d2);
        double[] dArr4 = dArr[2];
        double d7 = (dArr4[2] * d4) + (dArr4[1] * d3) + (dArr4[0] * d2);
        double d8 = viewingConditions.getRgbD()[0] * d5;
        double d9 = viewingConditions.getRgbD()[1] * d6;
        double d10 = viewingConditions.getRgbD()[2] * d7;
        double dPow = Math.pow((Math.abs(d8) * viewingConditions.getFl()) / 100.0d, 0.42d);
        double dPow2 = Math.pow((Math.abs(d9) * viewingConditions.getFl()) / 100.0d, 0.42d);
        double dPow3 = Math.pow((Math.abs(d10) * viewingConditions.getFl()) / 100.0d, 0.42d);
        double dSignum = ((Math.signum(d8) * 400.0d) * dPow) / (dPow + 27.13d);
        double dSignum2 = ((Math.signum(d9) * 400.0d) * dPow2) / (dPow2 + 27.13d);
        double dSignum3 = ((Math.signum(d10) * 400.0d) * dPow3) / (dPow3 + 27.13d);
        double d11 = ((((-12.0d) * dSignum2) + (dSignum * 11.0d)) + dSignum3) / 11.0d;
        double d12 = ((dSignum + dSignum2) - (dSignum3 * 2.0d)) / 9.0d;
        double d13 = dSignum2 * 20.0d;
        double d14 = ((21.0d * dSignum3) + ((dSignum * 20.0d) + d13)) / 20.0d;
        double d15 = (((dSignum * 40.0d) + d13) + dSignum3) / 20.0d;
        double degrees = Math.toDegrees(Math.atan2(d12, d11));
        if (degrees < 0.0d) {
            degrees += 360.0d;
        } else if (degrees >= 360.0d) {
            degrees -= 360.0d;
        }
        double d16 = degrees;
        double radians = Math.toRadians(d16);
        double dPow4 = Math.pow((viewingConditions.getNbb() * d15) / viewingConditions.getAw(), viewingConditions.getC() * viewingConditions.getZ()) * 100.0d;
        double d17 = dPow4 / 100.0d;
        double flRoot = viewingConditions.getFlRoot() * (viewingConditions.getAw() + 4.0d) * Math.sqrt(d17) * (4.0d / viewingConditions.getC());
        double dPow5 = Math.pow((Math.hypot(d11, d12) * (viewingConditions.getNcb() * (viewingConditions.getNc() * (((Math.cos(Math.toRadians(d16 < 20.14d ? d16 + 360.0d : d16) + 2.0d) + 3.8d) * 0.25d) * 3846.153846153846d)))) / (d14 + 0.305d), 0.9d) * Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d);
        double dSqrt = Math.sqrt(d17) * dPow5;
        double flRoot2 = viewingConditions.getFlRoot() * dSqrt;
        double dSqrt2 = Math.sqrt((viewingConditions.getC() * dPow5) / (viewingConditions.getAw() + 4.0d)) * 50.0d;
        double d18 = (1.7000000000000002d * dPow4) / ((0.007d * dPow4) + 1.0d);
        double dLog1p = Math.log1p(flRoot2 * 0.0228d) * 43.859649122807014d;
        return new Cam16(d16, dSqrt, dPow4, flRoot, flRoot2, dSqrt2, d18, Math.cos(radians) * dLog1p, Math.sin(radians) * dLog1p);
    }

    public double distance(Cam16 cam16) {
        double jstar = getJstar() - cam16.getJstar();
        double astar = getAstar() - cam16.getAstar();
        double bstar = getBstar() - cam16.getBstar();
        return Math.pow(Math.sqrt((bstar * bstar) + (astar * astar) + (jstar * jstar)), 0.63d) * 1.41d;
    }

    public double getAstar() {
        return this.astar;
    }

    public double getBstar() {
        return this.bstar;
    }

    public double getChroma() {
        return this.chroma;
    }

    public double getHue() {
        return this.hue;
    }

    public double getJ() {
        return this.f1529j;
    }

    public double getJstar() {
        return this.jstar;
    }

    public double getM() {
        return this.f1530m;
    }

    public double getQ() {
        return this.f1531q;
    }

    public double getS() {
        return this.f1532s;
    }

    public int toInt() {
        return viewed(ViewingConditions.DEFAULT);
    }

    public int viewed(ViewingConditions viewingConditions) {
        double[] dArrXyzInViewingConditions = xyzInViewingConditions(viewingConditions, this.tempArray);
        return ColorUtils.argbFromXyz(dArrXyzInViewingConditions[0], dArrXyzInViewingConditions[1], dArrXyzInViewingConditions[2]);
    }

    public double[] xyzInViewingConditions(ViewingConditions viewingConditions, double[] dArr) {
        double dPow = Math.pow(((getChroma() == 0.0d || getJ() == 0.0d) ? 0.0d : getChroma() / Math.sqrt(getJ() / 100.0d)) / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d), 1.1111111111111112d);
        double radians = Math.toRadians(getHue());
        double dCos = (Math.cos(2.0d + radians) + 3.8d) * 0.25d;
        double dPow2 = Math.pow(getJ() / 100.0d, (1.0d / viewingConditions.getC()) / viewingConditions.getZ()) * viewingConditions.getAw();
        double ncb = viewingConditions.getNcb() * viewingConditions.getNc() * dCos * 3846.153846153846d;
        double nbb = dPow2 / viewingConditions.getNbb();
        double dSin = Math.sin(radians);
        double dCos2 = Math.cos(radians);
        double d2 = (((0.305d + nbb) * 23.0d) * dPow) / (((dPow * 108.0d) * dSin) + (((11.0d * dPow) * dCos2) + (ncb * 23.0d)));
        double d3 = dCos2 * d2;
        double d4 = d2 * dSin;
        double d5 = nbb * 460.0d;
        double d6 = ((288.0d * d4) + ((451.0d * d3) + d5)) / 1403.0d;
        double d7 = ((d5 - (891.0d * d3)) - (261.0d * d4)) / 1403.0d;
        double d8 = ((d5 - (d3 * 220.0d)) - (d4 * 6300.0d)) / 1403.0d;
        double dPow3 = Math.pow(Math.max(0.0d, (Math.abs(d6) * 27.13d) / (400.0d - Math.abs(d6))), 2.380952380952381d) * (100.0d / viewingConditions.getFl()) * Math.signum(d6);
        double dPow4 = Math.pow(Math.max(0.0d, (Math.abs(d7) * 27.13d) / (400.0d - Math.abs(d7))), 2.380952380952381d) * (100.0d / viewingConditions.getFl()) * Math.signum(d7);
        double dPow5 = Math.pow(Math.max(0.0d, (Math.abs(d8) * 27.13d) / (400.0d - Math.abs(d8))), 2.380952380952381d) * (100.0d / viewingConditions.getFl()) * Math.signum(d8);
        double d9 = dPow3 / viewingConditions.getRgbD()[0];
        double d10 = dPow4 / viewingConditions.getRgbD()[1];
        double d11 = dPow5 / viewingConditions.getRgbD()[2];
        double[][] dArr2 = CAM16RGB_TO_XYZ;
        double[] dArr3 = dArr2[0];
        double d12 = (dArr3[2] * d11) + (dArr3[1] * d10) + (dArr3[0] * d9);
        double[] dArr4 = dArr2[1];
        double d13 = (dArr4[2] * d11) + (dArr4[1] * d10) + (dArr4[0] * d9);
        double[] dArr5 = dArr2[2];
        double d14 = (d11 * dArr5[2]) + (d10 * dArr5[1]) + (d9 * dArr5[0]);
        if (dArr == null) {
            return new double[]{d12, d13, d14};
        }
        dArr[0] = d12;
        dArr[1] = d13;
        dArr[2] = d14;
        return dArr;
    }
}
