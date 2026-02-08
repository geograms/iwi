package j1;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public abstract class l extends m implements i {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f1917b = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_queue");
    private volatile /* synthetic */ Object _queue = null;
    private volatile /* synthetic */ Object _delayed = null;
    private volatile /* synthetic */ int _isCompleted = 0;

    static {
        AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_delayed");
    }

    @Override // j1.c
    public final void a(x0.j jVar, Runnable runnable) {
        d(runnable);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0046, code lost:
    
        j1.g.f1912c.d(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(java.lang.Runnable r5) {
        /*
            r4 = this;
        L0:
            java.lang.Object r0 = r4._queue
            int r1 = r4._isCompleted
            if (r1 == 0) goto L7
            goto L46
        L7:
            if (r0 != 0) goto L1a
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = j1.l.f1917b
        Lb:
            r0 = 0
            boolean r0 = r1.compareAndSet(r4, r0, r5)
            if (r0 == 0) goto L13
            goto L64
        L13:
            java.lang.Object r0 = r1.get(r4)
            if (r0 == 0) goto Lb
            goto L0
        L1a:
            boolean r1 = r0 instanceof n1.d
            r2 = 1
            if (r1 == 0) goto L42
            r1 = r0
            n1.d r1 = (n1.d) r1
            int r3 = r1.a(r5)
            if (r3 == 0) goto L64
            if (r3 == r2) goto L2e
            r0 = 2
            if (r3 == r0) goto L46
            goto L0
        L2e:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = j1.l.f1917b
            n1.d r1 = r1.e()
        L34:
            boolean r3 = r2.compareAndSet(r4, r0, r1)
            if (r3 == 0) goto L3b
            goto L0
        L3b:
            java.lang.Object r3 = r2.get(r4)
            if (r3 == r0) goto L34
            goto L0
        L42:
            k.j r1 = j1.n.f1918a
            if (r0 != r1) goto L4c
        L46:
            j1.g r4 = j1.g.f1912c
            r4.d(r5)
            goto L71
        L4c:
            n1.d r1 = new n1.d
            r3 = 8
            r1.<init>(r3, r2)
            r2 = r0
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r1.a(r2)
            r1.a(r5)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = j1.l.f1917b
        L5e:
            boolean r3 = r2.compareAndSet(r4, r0, r1)
            if (r3 == 0) goto L72
        L64:
            java.lang.Thread r4 = r4.c()
            java.lang.Thread r5 = java.lang.Thread.currentThread()
            if (r5 == r4) goto L71
            java.util.concurrent.locks.LockSupport.unpark(r4)
        L71:
            return
        L72:
            java.lang.Object r3 = r2.get(r4)
            if (r3 == r0) goto L5e
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.l.d(java.lang.Runnable):void");
    }

    public final boolean e() {
        a.a.j(this._delayed);
        Object obj = this._queue;
        if (obj == null) {
            return true;
        }
        return obj instanceof n1.d ? ((n1.d) obj).d() : obj == n.f1918a;
    }

    public final long f() {
        Runnable runnable;
        a.a.j(this._delayed);
        loop0: while (true) {
            Object obj = this._queue;
            runnable = null;
            if (obj == null) {
                break;
            }
            if (!(obj instanceof n1.d)) {
                if (obj != n.f1918a) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1917b;
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    runnable = (Runnable) obj;
                    break loop0;
                }
                break;
            }
            n1.d dVar = (n1.d) obj;
            Object objF = dVar.f();
            if (objF != n1.d.f2203g) {
                runnable = (Runnable) objF;
                break;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f1917b;
            n1.d dVarE = dVar.e();
            while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj, dVarE) && atomicReferenceFieldUpdater2.get(this) == obj) {
            }
        }
        if (runnable != null) {
            runnable.run();
            return 0L;
        }
        Object obj2 = this._queue;
        if (obj2 == null) {
            a.a.j(this._delayed);
        } else if (obj2 instanceof n1.d) {
            if (!((n1.d) obj2).d()) {
                return 0L;
            }
            a.a.j(this._delayed);
        } else if (obj2 != n.f1918a) {
            return 0L;
        }
        return Long.MAX_VALUE;
    }

    public final void g() {
        this._queue = null;
        this._delayed = null;
    }
}
