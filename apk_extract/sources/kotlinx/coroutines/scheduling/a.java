package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* loaded from: classes.dex */
public final class a extends Thread {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f2044h = AtomicIntegerFieldUpdater.newUpdater(a.class, "workerCtl");

    /* renamed from: a, reason: collision with root package name */
    public final m f2045a;

    /* renamed from: b, reason: collision with root package name */
    public int f2046b;

    /* renamed from: c, reason: collision with root package name */
    public long f2047c;

    /* renamed from: d, reason: collision with root package name */
    public long f2048d;

    /* renamed from: e, reason: collision with root package name */
    public int f2049e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2050f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ b f2051g;
    private volatile int indexInArray;
    private volatile Object nextParkedWorker;
    volatile /* synthetic */ int workerCtl;

    public a(b bVar, int i2) {
        this.f2051g = bVar;
        setDaemon(true);
        this.f2045a = new m();
        this.f2046b = 4;
        this.workerCtl = 0;
        this.nextParkedWorker = b.f2055k;
        d1.e.f1736a.getClass();
        this.f2049e = d1.e.f1737b.a();
        f(i2);
    }

    public final h a(boolean z2) {
        h hVarE;
        h hVarE2;
        long j2;
        h hVarC;
        if (this.f2046b != 1) {
            b bVar = this.f2051g;
            do {
                j2 = bVar.controlState;
                if (((int) ((9223367638808264704L & j2) >> 42)) == 0) {
                    if (z2) {
                        m mVar = this.f2045a;
                        mVar.getClass();
                        hVarC = (h) m.f2080b.getAndSet(mVar, null);
                        if (hVarC == null) {
                            hVarC = mVar.c();
                        }
                        if (hVarC == null) {
                            hVarC = (h) this.f2051g.f2061f.d();
                        }
                    } else {
                        hVarC = (h) this.f2051g.f2061f.d();
                    }
                    return hVarC == null ? i(true) : hVarC;
                }
            } while (!b.f2053i.compareAndSet(bVar, j2, j2 - 4398046511104L));
            this.f2046b = 1;
        }
        if (z2) {
            boolean z3 = d(this.f2051g.f2056a * 2) == 0;
            if (z3 && (hVarE2 = e()) != null) {
                return hVarE2;
            }
            m mVar2 = this.f2045a;
            mVar2.getClass();
            h hVar = (h) m.f2080b.getAndSet(mVar2, null);
            h hVarC2 = hVar == null ? mVar2.c() : hVar;
            if (hVarC2 != null) {
                return hVarC2;
            }
            if (!z3 && (hVarE = e()) != null) {
                return hVarE;
            }
        } else {
            h hVarE3 = e();
            if (hVarE3 != null) {
                return hVarE3;
            }
        }
        return i(false);
    }

    public final int b() {
        return this.indexInArray;
    }

    public final Object c() {
        return this.nextParkedWorker;
    }

    public final int d(int i2) {
        int i3 = this.f2049e;
        int i4 = i3 ^ (i3 << 13);
        int i5 = i4 ^ (i4 >> 17);
        int i6 = i5 ^ (i5 << 5);
        this.f2049e = i6;
        int i7 = i2 - 1;
        return (i7 & i2) == 0 ? i7 & i6 : (Integer.MAX_VALUE & i6) % i2;
    }

    public final h e() {
        int iD = d(2);
        b bVar = this.f2051g;
        if (iD == 0) {
            h hVar = (h) bVar.f2060e.d();
            return hVar == null ? (h) bVar.f2061f.d() : hVar;
        }
        h hVar2 = (h) bVar.f2061f.d();
        return hVar2 == null ? (h) bVar.f2060e.d() : hVar2;
    }

    public final void f(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2051g.f2059d);
        sb.append("-worker-");
        sb.append(i2 == 0 ? "TERMINATED" : String.valueOf(i2));
        setName(sb.toString());
        this.indexInArray = i2;
    }

    public final void g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean h(int i2) {
        int i3 = this.f2046b;
        boolean z2 = i3 == 1;
        if (z2) {
            b.f2053i.addAndGet(this.f2051g, 4398046511104L);
        }
        if (i3 != i2) {
            this.f2046b = i2;
        }
        return z2;
    }

    public final h i(boolean z2) {
        long jE;
        int i2 = (int) (this.f2051g.controlState & 2097151);
        if (i2 < 2) {
            return null;
        }
        int iD = d(i2);
        b bVar = this.f2051g;
        int i3 = 0;
        long jMin = Long.MAX_VALUE;
        while (i3 < i2) {
            i3++;
            iD++;
            if (iD > i2) {
                iD = 1;
            }
            a aVar = (a) bVar.f2062g.b(iD);
            if (aVar != null && aVar != this) {
                if (z2) {
                    jE = this.f2045a.d(aVar.f2045a);
                } else {
                    m mVar = this.f2045a;
                    m mVar2 = aVar.f2045a;
                    mVar.getClass();
                    h hVarC = mVar2.c();
                    if (hVarC != null) {
                        h hVar = (h) m.f2080b.getAndSet(mVar, hVarC);
                        if (hVar != null) {
                            mVar.a(hVar);
                        }
                        jE = -1;
                    } else {
                        jE = mVar.e(mVar2, false);
                    }
                }
                if (jE == -1) {
                    m mVar3 = this.f2045a;
                    mVar3.getClass();
                    h hVar2 = (h) m.f2080b.getAndSet(mVar3, null);
                    return hVar2 == null ? mVar3.c() : hVar2;
                }
                if (jE > 0) {
                    jMin = Math.min(jMin, jE);
                }
            }
        }
        if (jMin == Long.MAX_VALUE) {
            jMin = 0;
        }
        this.f2048d = jMin;
        return null;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        loop0: while (true) {
            boolean z2 = false;
            while (!this.f2051g.c() && this.f2046b != 5) {
                h hVarA = a(this.f2050f);
                if (hVarA != null) {
                    this.f2048d = 0L;
                    int i2 = hVarA.f2069b.f2070a;
                    this.f2047c = 0L;
                    if (this.f2046b == 3) {
                        this.f2046b = 2;
                    }
                    b bVar = this.f2051g;
                    if (i2 != 0 && h(2) && !bVar.g() && !bVar.f(bVar.controlState)) {
                        bVar.g();
                    }
                    bVar.getClass();
                    try {
                        ((j) hVarA).run();
                    } catch (Throwable th) {
                        Thread threadCurrentThread = Thread.currentThread();
                        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
                    }
                    if (i2 != 0) {
                        b.f2053i.addAndGet(bVar, -2097152L);
                        if (this.f2046b != 5) {
                            this.f2046b = 4;
                        }
                    }
                } else {
                    this.f2050f = false;
                    if (this.f2048d != 0) {
                        if (z2) {
                            h(3);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f2048d);
                            this.f2048d = 0L;
                        } else {
                            z2 = true;
                        }
                    } else if (this.nextParkedWorker != b.f2055k) {
                        this.workerCtl = -1;
                        while (this.nextParkedWorker != b.f2055k && this.workerCtl == -1 && !this.f2051g.c() && this.f2046b != 5) {
                            h(3);
                            Thread.interrupted();
                            if (this.f2047c == 0) {
                                this.f2047c = System.nanoTime() + this.f2051g.f2058c;
                            }
                            LockSupport.parkNanos(this.f2051g.f2058c);
                            if (System.nanoTime() - this.f2047c >= 0) {
                                this.f2047c = 0L;
                                b bVar2 = this.f2051g;
                                synchronized (bVar2.f2062g) {
                                    try {
                                        if (!bVar2.c()) {
                                            if (((int) (bVar2.controlState & 2097151)) > bVar2.f2056a) {
                                                if (f2044h.compareAndSet(this, -1, 1)) {
                                                    int i3 = this.indexInArray;
                                                    f(0);
                                                    bVar2.e(this, i3, 0);
                                                    int andDecrement = (int) (b.f2053i.getAndDecrement(bVar2) & 2097151);
                                                    if (andDecrement != i3) {
                                                        Object objB = bVar2.f2062g.b(andDecrement);
                                                        x0.g.q(objB);
                                                        a aVar = (a) objB;
                                                        bVar2.f2062g.c(i3, aVar);
                                                        aVar.f(i3);
                                                        bVar2.e(aVar, andDecrement, i3);
                                                    }
                                                    bVar2.f2062g.c(andDecrement, null);
                                                    this.f2046b = 5;
                                                }
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        throw th2;
                                    }
                                }
                            }
                        }
                    } else {
                        this.f2051g.d(this);
                    }
                }
            }
            break loop0;
        }
        h(5);
    }
}
