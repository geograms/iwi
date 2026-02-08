package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final long f2072a = x0.g.z0("kotlinx.coroutines.scheduler.resolution.ns", 100000, 1, Long.MAX_VALUE);

    /* renamed from: b, reason: collision with root package name */
    public static final int f2073b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f2074c;

    /* renamed from: d, reason: collision with root package name */
    public static final long f2075d;

    /* renamed from: e, reason: collision with root package name */
    public static final f f2076e;

    /* renamed from: f, reason: collision with root package name */
    public static final i f2077f;

    /* renamed from: g, reason: collision with root package name */
    public static final i f2078g;

    static {
        int i2 = n1.h.f2209a;
        if (i2 < 2) {
            i2 = 2;
        }
        f2073b = x0.g.A0("kotlinx.coroutines.scheduler.core.pool.size", i2, 1, 0, 8);
        f2074c = x0.g.A0("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4);
        f2075d = TimeUnit.SECONDS.toNanos(x0.g.z0("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 1L, Long.MAX_VALUE));
        f2076e = f.f2066c;
        f2077f = new i(0);
        f2078g = new i(1);
    }
}
