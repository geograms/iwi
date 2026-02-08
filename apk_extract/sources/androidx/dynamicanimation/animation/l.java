package androidx.dynamicanimation.animation;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public double f351a;

    /* renamed from: b, reason: collision with root package name */
    public double f352b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f353c;

    /* renamed from: d, reason: collision with root package name */
    public double f354d;

    /* renamed from: e, reason: collision with root package name */
    public double f355e;

    /* renamed from: f, reason: collision with root package name */
    public double f356f;

    /* renamed from: g, reason: collision with root package name */
    public double f357g;

    /* renamed from: h, reason: collision with root package name */
    public double f358h;

    /* renamed from: i, reason: collision with root package name */
    public double f359i;

    /* renamed from: j, reason: collision with root package name */
    public final f f360j;

    public l() {
        this.f351a = Math.sqrt(1500.0d);
        this.f352b = 0.5d;
        this.f353c = false;
        this.f359i = Double.MAX_VALUE;
        this.f360j = new f();
    }

    public final f a(long j2, double d2, double d3) {
        double dCos;
        double dPow;
        if (!this.f353c) {
            if (this.f359i == Double.MAX_VALUE) {
                throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
            }
            double d4 = this.f352b;
            if (d4 > 1.0d) {
                double d5 = this.f351a;
                this.f356f = (Math.sqrt((d4 * d4) - 1.0d) * d5) + ((-d4) * d5);
                double d6 = this.f352b;
                double d7 = this.f351a;
                this.f357g = ((-d6) * d7) - (Math.sqrt((d6 * d6) - 1.0d) * d7);
            } else if (d4 >= 0.0d && d4 < 1.0d) {
                this.f358h = Math.sqrt(1.0d - (d4 * d4)) * this.f351a;
            }
            this.f353c = true;
        }
        double d8 = j2 / 1000.0d;
        double d9 = d2 - this.f359i;
        double d10 = this.f352b;
        if (d10 > 1.0d) {
            double d11 = this.f357g;
            double d12 = this.f356f;
            double d13 = d9 - (((d11 * d9) - d3) / (d11 - d12));
            double d14 = ((d9 * d11) - d3) / (d11 - d12);
            dPow = (Math.pow(2.718281828459045d, this.f356f * d8) * d14) + (Math.pow(2.718281828459045d, d11 * d8) * d13);
            double d15 = this.f357g;
            double dPow2 = Math.pow(2.718281828459045d, d15 * d8) * d13 * d15;
            double d16 = this.f356f;
            dCos = (Math.pow(2.718281828459045d, d16 * d8) * d14 * d16) + dPow2;
        } else if (d10 == 1.0d) {
            double d17 = this.f351a;
            double d18 = (d17 * d9) + d3;
            double d19 = (d18 * d8) + d9;
            double dPow3 = Math.pow(2.718281828459045d, (-d17) * d8) * d19;
            double dPow4 = Math.pow(2.718281828459045d, (-this.f351a) * d8) * d19;
            double d20 = this.f351a;
            dCos = (Math.pow(2.718281828459045d, (-d20) * d8) * d18) + (dPow4 * (-d20));
            dPow = dPow3;
        } else {
            double d21 = 1.0d / this.f358h;
            double d22 = this.f351a;
            double d23 = ((d10 * d22 * d9) + d3) * d21;
            double dSin = ((Math.sin(this.f358h * d8) * d23) + (Math.cos(this.f358h * d8) * d9)) * Math.pow(2.718281828459045d, (-d10) * d22 * d8);
            double d24 = this.f351a;
            double d25 = this.f352b;
            double d26 = (-d24) * dSin * d25;
            double dPow5 = Math.pow(2.718281828459045d, (-d25) * d24 * d8);
            double d27 = this.f358h;
            double dSin2 = Math.sin(d27 * d8) * (-d27) * d9;
            double d28 = this.f358h;
            dCos = (((Math.cos(d28 * d8) * d23 * d28) + dSin2) * dPow5) + d26;
            dPow = dSin;
        }
        float f2 = (float) (dPow + this.f359i);
        f fVar = this.f360j;
        fVar.f327a = f2;
        fVar.f328b = (float) dCos;
        return fVar;
    }

    public l(float f2) {
        this.f351a = Math.sqrt(1500.0d);
        this.f352b = 0.5d;
        this.f353c = false;
        this.f360j = new f();
        this.f359i = f2;
    }
}
