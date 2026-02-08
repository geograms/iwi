package u;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f2559a;

    /* renamed from: b, reason: collision with root package name */
    public int f2560b;

    /* renamed from: c, reason: collision with root package name */
    public float f2561c;

    /* renamed from: d, reason: collision with root package name */
    public float f2562d;

    /* renamed from: e, reason: collision with root package name */
    public long f2563e;

    /* renamed from: f, reason: collision with root package name */
    public long f2564f;

    /* renamed from: g, reason: collision with root package name */
    public long f2565g;

    /* renamed from: h, reason: collision with root package name */
    public float f2566h;

    /* renamed from: i, reason: collision with root package name */
    public int f2567i;

    public final float a(long j2) {
        if (j2 < this.f2563e) {
            return 0.0f;
        }
        long j3 = this.f2565g;
        if (j3 < 0 || j2 < j3) {
            return g.b((j2 - r0) / this.f2559a, 0.0f, 1.0f) * 0.5f;
        }
        float f2 = this.f2566h;
        return (g.b((j2 - j3) / this.f2567i, 0.0f, 1.0f) * f2) + (1.0f - f2);
    }
}
