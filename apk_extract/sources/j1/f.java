package j1;

import java.lang.Thread;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final List f1911a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [h1.a] */
    static {
        Iterator itH = a.a.h();
        x0.g.u(itH, "<this>");
        h1.d dVar = new h1.d(itH);
        if (!(dVar instanceof h1.a)) {
            dVar = new h1.a(dVar);
        }
        f1911a = h1.c.E0(dVar);
    }

    public static final void a(Throwable th) {
        Throwable runtimeException;
        x0.k kVar = x0.k.f2662a;
        Iterator it = f1911a.iterator();
        while (it.hasNext()) {
            try {
                ((e) it.next()).handleException(kVar, th);
            } catch (Throwable th2) {
                Thread threadCurrentThread = Thread.currentThread();
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = threadCurrentThread.getUncaughtExceptionHandler();
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    x0.g.d(runtimeException, th);
                }
                uncaughtExceptionHandler.uncaughtException(threadCurrentThread, runtimeException);
            }
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        try {
            x0.g.d(th, new j());
        } catch (Throwable unused) {
        }
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }
}
