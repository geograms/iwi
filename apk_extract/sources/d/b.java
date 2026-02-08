package d;

import x0.g;

/* loaded from: classes.dex */
public final class b extends g {

    /* renamed from: d, reason: collision with root package name */
    public static volatile b f1699d;

    /* renamed from: e, reason: collision with root package name */
    public static final a f1700e = new a();

    /* renamed from: c, reason: collision with root package name */
    public final d f1701c = new d();

    public static b E0() {
        if (f1699d != null) {
            return f1699d;
        }
        synchronized (b.class) {
            try {
                if (f1699d == null) {
                    f1699d = new b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f1699d;
    }

    public final boolean F0() {
        return this.f1701c.E0();
    }

    public final void G0(Runnable runnable) {
        this.f1701c.F0(runnable);
    }
}
