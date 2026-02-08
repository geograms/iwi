package kotlinx.coroutines.scheduling;

import j1.o;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* loaded from: classes.dex */
public abstract class g extends o {

    /* renamed from: b, reason: collision with root package name */
    public final b f2067b;

    public g(int i2, int i3, long j2) {
        this.f2067b = new b(i2, i3, j2, "DefaultDispatcher");
    }

    @Override // j1.c
    public final void a(x0.j jVar, Runnable runnable) {
        b bVar = this.f2067b;
        AtomicLongFieldUpdater atomicLongFieldUpdater = b.f2052h;
        bVar.b(runnable, k.f2077f, false);
    }
}
