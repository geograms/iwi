package kotlinx.coroutines.scheduling;

import androidx.fragment.app.v1;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* loaded from: classes.dex */
public final class b implements Executor, Closeable {
    private volatile /* synthetic */ int _isTerminated;

    /* renamed from: a, reason: collision with root package name */
    public final int f2056a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2057b;

    /* renamed from: c, reason: collision with root package name */
    public final long f2058c;
    volatile /* synthetic */ long controlState;

    /* renamed from: d, reason: collision with root package name */
    public final String f2059d;

    /* renamed from: e, reason: collision with root package name */
    public final e f2060e;

    /* renamed from: f, reason: collision with root package name */
    public final e f2061f;

    /* renamed from: g, reason: collision with root package name */
    public final n1.g f2062g;
    private volatile /* synthetic */ long parkedWorkersStack;

    /* renamed from: k, reason: collision with root package name */
    public static final k.j f2055k = new k.j(24, "NOT_IN_STACK");

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f2052h = AtomicLongFieldUpdater.newUpdater(b.class, "parkedWorkersStack");

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f2053i = AtomicLongFieldUpdater.newUpdater(b.class, "controlState");

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f2054j = AtomicIntegerFieldUpdater.newUpdater(b.class, "_isTerminated");

    public b(int i2, int i3, long j2, String str) {
        this.f2056a = i2;
        this.f2057b = i3;
        this.f2058c = j2;
        this.f2059d = str;
        if (i2 < 1) {
            throw new IllegalArgumentException(("Core pool size " + i2 + " should be at least 1").toString());
        }
        if (i3 < i2) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should be greater than or equals to core pool size " + i2).toString());
        }
        if (i3 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j2 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
        }
        this.f2060e = new e();
        this.f2061f = new e();
        this.parkedWorkersStack = 0L;
        this.f2062g = new n1.g(i2 + 1);
        this.controlState = i2 << 42;
        this._isTerminated = 0;
    }

    public final int a() {
        synchronized (this.f2062g) {
            if (this._isTerminated != 0) {
                return -1;
            }
            long j2 = this.controlState;
            int i2 = (int) (j2 & 2097151);
            int i3 = i2 - ((int) ((j2 & 4398044413952L) >> 21));
            if (i3 < 0) {
                i3 = 0;
            }
            if (i3 >= this.f2056a) {
                return 0;
            }
            if (i2 >= this.f2057b) {
                return 0;
            }
            int i4 = ((int) (this.controlState & 2097151)) + 1;
            if (i4 <= 0 || this.f2062g.b(i4) != null) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            a aVar = new a(this, i4);
            this.f2062g.c(i4, aVar);
            if (i4 != ((int) (2097151 & f2053i.incrementAndGet(this)))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            aVar.start();
            return i3 + 1;
        }
    }

    public final void b(Runnable runnable, i iVar, boolean z2) {
        h jVar;
        int i2;
        k.f2076e.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof h) {
            jVar = (h) runnable;
            jVar.f2068a = jNanoTime;
            jVar.f2069b = iVar;
        } else {
            jVar = new j(runnable, jNanoTime, iVar);
        }
        Thread threadCurrentThread = Thread.currentThread();
        h hVarA = null;
        a aVar = threadCurrentThread instanceof a ? (a) threadCurrentThread : null;
        if (aVar == null || !x0.g.g(aVar.f2051g, this)) {
            aVar = null;
        }
        if (aVar == null || (i2 = aVar.f2046b) == 5 || (jVar.f2069b.f2070a == 0 && i2 == 2)) {
            hVarA = jVar;
        } else {
            aVar.f2050f = true;
            m mVar = aVar.f2045a;
            if (z2) {
                hVarA = mVar.a(jVar);
            } else {
                mVar.getClass();
                h hVar = (h) m.f2080b.getAndSet(mVar, jVar);
                if (hVar != null) {
                    hVarA = mVar.a(hVar);
                }
            }
        }
        if (hVarA != null) {
            if (!(hVarA.f2069b.f2070a == 1 ? this.f2061f.a(hVarA) : this.f2060e.a(hVarA))) {
                throw new RejectedExecutionException(x0.g.y0(" was terminated", this.f2059d));
            }
        }
        boolean z3 = z2 && aVar != null;
        if (jVar.f2069b.f2070a == 0) {
            if (z3 || g() || f(this.controlState)) {
                return;
            }
            g();
            return;
        }
        long jAddAndGet = f2053i.addAndGet(this, 2097152L);
        if (z3 || g() || f(jAddAndGet)) {
            return;
        }
        g();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    public final boolean c() {
        return this._isTerminated;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws InterruptedException {
        int i2;
        if (f2054j.compareAndSet(this, 0, 1)) {
            Thread threadCurrentThread = Thread.currentThread();
            a aVar = threadCurrentThread instanceof a ? (a) threadCurrentThread : null;
            if (aVar == null || !x0.g.g(aVar.f2051g, this)) {
                aVar = null;
            }
            synchronized (this.f2062g) {
                i2 = (int) (this.controlState & 2097151);
            }
            if (1 <= i2) {
                int i3 = 1;
                while (true) {
                    int i4 = i3 + 1;
                    Object objB = this.f2062g.b(i3);
                    x0.g.q(objB);
                    a aVar2 = (a) objB;
                    if (aVar2 != aVar) {
                        while (aVar2.isAlive()) {
                            LockSupport.unpark(aVar2);
                            aVar2.join(10000L);
                        }
                        m mVar = aVar2.f2045a;
                        e eVar = this.f2061f;
                        mVar.getClass();
                        h hVar = (h) m.f2080b.getAndSet(mVar, null);
                        if (hVar != null) {
                            eVar.a(hVar);
                        }
                        while (true) {
                            h hVarC = mVar.c();
                            if (hVarC == null) {
                                break;
                            } else {
                                eVar.a(hVarC);
                            }
                        }
                    }
                    if (i3 == i2) {
                        break;
                    } else {
                        i3 = i4;
                    }
                }
            }
            this.f2061f.b();
            this.f2060e.b();
            while (true) {
                h hVarA = aVar == null ? null : aVar.a(true);
                if (hVarA == null && (hVarA = (h) this.f2060e.d()) == null && (hVarA = (h) this.f2061f.d()) == null) {
                    break;
                }
                try {
                    ((j) hVarA).run();
                } catch (Throwable th) {
                    Thread threadCurrentThread2 = Thread.currentThread();
                    threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
                }
            }
            if (aVar != null) {
                aVar.h(5);
            }
            this.parkedWorkersStack = 0L;
            this.controlState = 0L;
        }
    }

    public final void d(a aVar) {
        long j2;
        int iB;
        if (aVar.c() != f2055k) {
            return;
        }
        do {
            j2 = this.parkedWorkersStack;
            iB = aVar.b();
            aVar.g(this.f2062g.b((int) (2097151 & j2)));
        } while (!f2052h.compareAndSet(this, j2, iB | ((2097152 + j2) & (-2097152))));
    }

    public final void e(a aVar, int i2, int i3) {
        while (true) {
            long j2 = this.parkedWorkersStack;
            int i4 = (int) (2097151 & j2);
            long j3 = (2097152 + j2) & (-2097152);
            if (i4 == i2) {
                if (i3 == 0) {
                    Object objC = aVar.c();
                    while (true) {
                        if (objC == f2055k) {
                            i4 = -1;
                            break;
                        }
                        if (objC == null) {
                            i4 = 0;
                            break;
                        }
                        a aVar2 = (a) objC;
                        int iB = aVar2.b();
                        if (iB != 0) {
                            i4 = iB;
                            break;
                        }
                        objC = aVar2.c();
                    }
                } else {
                    i4 = i3;
                }
            }
            if (i4 >= 0 && f2052h.compareAndSet(this, j2, j3 | i4)) {
                return;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        b(runnable, k.f2077f, false);
    }

    public final boolean f(long j2) {
        int i2 = ((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21));
        if (i2 < 0) {
            i2 = 0;
        }
        int i3 = this.f2056a;
        if (i2 < i3) {
            int iA = a();
            if (iA == 1 && i3 > 1) {
                a();
            }
            if (iA > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean g() {
        k.j jVar;
        int iB;
        while (true) {
            long j2 = this.parkedWorkersStack;
            a aVar = (a) this.f2062g.b((int) (2097151 & j2));
            if (aVar == null) {
                aVar = null;
            } else {
                long j3 = (2097152 + j2) & (-2097152);
                Object objC = aVar.c();
                while (true) {
                    jVar = f2055k;
                    if (objC == jVar) {
                        iB = -1;
                        break;
                    }
                    if (objC == null) {
                        iB = 0;
                        break;
                    }
                    a aVar2 = (a) objC;
                    iB = aVar2.b();
                    if (iB != 0) {
                        break;
                    }
                    objC = aVar2.c();
                }
                if (iB >= 0 && f2052h.compareAndSet(this, j2, iB | j3)) {
                    aVar.g(jVar);
                }
            }
            if (aVar == null) {
                return false;
            }
            if (a.f2044h.compareAndSet(aVar, -1, 0)) {
                LockSupport.unpark(aVar);
                return true;
            }
        }
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        int iA = this.f2062g.a();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 1;
        while (i7 < iA) {
            int i8 = i7 + 1;
            a aVar = (a) this.f2062g.b(i7);
            if (aVar != null) {
                int iB = aVar.f2045a.b();
                int iE = v1.e(aVar.f2046b);
                if (iE == 0) {
                    i2++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(iB);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (iE == 1) {
                    i3++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(iB);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (iE == 2) {
                    i4++;
                } else if (iE == 3) {
                    i5++;
                    if (iB > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(iB);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (iE == 4) {
                    i6++;
                }
            }
            i7 = i8;
        }
        long j2 = this.controlState;
        return this.f2059d + '@' + Integer.toHexString(System.identityHashCode(this)) + "[Pool Size {core = " + this.f2056a + ", max = " + this.f2057b + "}, Worker States {CPU = " + i2 + ", blocking = " + i3 + ", parked = " + i4 + ", dormant = " + i5 + ", terminated = " + i6 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f2060e.c() + ", global blocking queue size = " + this.f2061f.c() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + ", CPUs acquired = " + (this.f2056a - ((int) ((9223367638808264704L & j2) >> 42))) + "}]";
    }
}
