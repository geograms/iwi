package kotlinx.coroutines.scheduling;

import j1.o;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class c extends o implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public static final c f2063b = new c();

    /* renamed from: c, reason: collision with root package name */
    public static final n1.a f2064c;

    static {
        l lVar = l.f2079b;
        int i2 = n1.h.f2209a;
        if (64 >= i2) {
            i2 = 64;
        }
        int iA0 = x0.g.A0("kotlinx.coroutines.io.parallelism", i2, 0, 0, 12);
        lVar.getClass();
        if (iA0 < 1) {
            throw new IllegalArgumentException(x0.g.y0(Integer.valueOf(iA0), "Expected positive parallelism level, but got ").toString());
        }
        f2064c = new n1.a(lVar, iA0);
    }

    @Override // j1.c
    public final void a(x0.j jVar, Runnable runnable) {
        f2064c.a(jVar, runnable);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        a(x0.k.f2662a, runnable);
    }

    @Override // j1.c
    public final String toString() {
        return "Dispatchers.IO";
    }
}
