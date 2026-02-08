package j;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: k, reason: collision with root package name */
    public static final s f1882k;

    /* renamed from: a, reason: collision with root package name */
    public final float f1883a;

    /* renamed from: b, reason: collision with root package name */
    public final float f1884b;

    /* renamed from: c, reason: collision with root package name */
    public final float f1885c;

    /* renamed from: d, reason: collision with root package name */
    public final float f1886d;

    /* renamed from: e, reason: collision with root package name */
    public final float f1887e;

    /* renamed from: f, reason: collision with root package name */
    public final float f1888f;

    /* renamed from: g, reason: collision with root package name */
    public final float[] f1889g;

    /* renamed from: h, reason: collision with root package name */
    public final float f1890h;

    /* renamed from: i, reason: collision with root package name */
    public final float f1891i;

    /* renamed from: j, reason: collision with root package name */
    public final float f1892j;

    static {
        float[] fArr = b.f1852c;
        float fC = (float) ((b.c() * 63.66197723675813d) / 100.0d);
        float[][] fArr2 = b.f1850a;
        float f2 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f3 = fArr3[0] * f2;
        float f4 = fArr[1];
        float f5 = (fArr3[1] * f4) + f3;
        float f6 = fArr[2];
        float f7 = (fArr3[2] * f6) + f5;
        float[] fArr4 = fArr2[1];
        float f8 = (fArr4[2] * f6) + (fArr4[1] * f4) + (fArr4[0] * f2);
        float[] fArr5 = fArr2[2];
        float f9 = (f6 * fArr5[2]) + (f4 * fArr5[1]) + (f2 * fArr5[0]);
        float f10 = ((double) 1.0f) >= 0.9d ? 0.69f : 0.655f;
        float fExp = (1.0f - (((float) Math.exp(((-fC) - 42.0f) / 92.0f)) * 0.2777778f)) * 1.0f;
        double d2 = fExp;
        if (d2 > 1.0d) {
            fExp = 1.0f;
        } else if (d2 < 0.0d) {
            fExp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f7) * fExp) + 1.0f) - fExp, (((100.0f / f8) * fExp) + 1.0f) - fExp, (((100.0f / f9) * fExp) + 1.0f) - fExp};
        float f11 = 1.0f / ((5.0f * fC) + 1.0f);
        float f12 = f11 * f11 * f11 * f11;
        float f13 = 1.0f - f12;
        float fCbrt = (0.1f * f13 * f13 * ((float) Math.cbrt(fC * 5.0d))) + (f12 * fC);
        float fC2 = b.c() / fArr[1];
        double d3 = fC2;
        float fSqrt = ((float) Math.sqrt(d3)) + 1.48f;
        float fPow = 0.725f / ((float) Math.pow(d3, 0.2d));
        float fPow2 = (float) Math.pow(((fArr6[2] * fCbrt) * f9) / 100.0d, 0.42d);
        float[] fArr7 = {(float) Math.pow(((fArr6[0] * fCbrt) * f7) / 100.0d, 0.42d), (float) Math.pow(((fArr6[1] * fCbrt) * f8) / 100.0d, 0.42d), fPow2};
        float f14 = fArr7[0];
        float f15 = fArr7[1];
        f1882k = new s(fC2, ((((400.0f * fPow2) / (fPow2 + 27.13f)) * 0.05f) + (((f14 * 400.0f) / (f14 + 27.13f)) * 2.0f) + ((f15 * 400.0f) / (f15 + 27.13f))) * fPow, fPow, fPow, f10, 1.0f, fArr6, fCbrt, (float) Math.pow(fCbrt, 0.25d), fSqrt);
    }

    public s(float f2, float f3, float f4, float f5, float f6, float f7, float[] fArr, float f8, float f9, float f10) {
        this.f1888f = f2;
        this.f1883a = f3;
        this.f1884b = f4;
        this.f1885c = f5;
        this.f1886d = f6;
        this.f1887e = f7;
        this.f1889g = fArr;
        this.f1890h = f8;
        this.f1891i = f9;
        this.f1892j = f10;
    }
}
