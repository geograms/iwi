package n1;

import j1.i;
import kotlinx.coroutines.scheduling.l;
import x0.j;

/* loaded from: classes.dex */
public final class a extends j1.c implements Runnable, i {

    /* renamed from: b, reason: collision with root package name */
    public final j1.c f2195b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2196c;

    /* renamed from: d, reason: collision with root package name */
    public final b f2197d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f2198e;
    private volatile int runningWorkers;

    /* JADX WARN: Multi-variable type inference failed */
    public a(l lVar, int i2) {
        this.f2195b = lVar;
        this.f2196c = i2;
        if ((lVar instanceof i ? (i) lVar : null) == null) {
            int i3 = j1.h.f1914a;
        }
        this.f2197d = new b();
        this.f2198e = new Object();
    }

    @Override // j1.c
    public final void a(j jVar, Runnable runnable) {
        this.f2197d.a(runnable);
        if (this.runningWorkers >= this.f2196c) {
            return;
        }
        synchronized (this.f2198e) {
            if (this.runningWorkers >= this.f2196c) {
                return;
            }
            this.runningWorkers++;
            this.f2195b.a(this, this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0028, code lost:
    
        r1 = r3.f2198e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002a, code lost:
    
        monitor-enter(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
    
        r3.runningWorkers--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        if (r3.f2197d.c() != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0039, code lost:
    
        monitor-exit(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003b, code lost:
    
        r3.runningWorkers++;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r3 = this;
            r0 = 0
        L1:
            r1 = r0
        L2:
            n1.b r2 = r3.f2197d
            java.lang.Object r2 = r2.d()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            if (r2 == 0) goto L28
            r2.run()     // Catch: java.lang.Throwable -> L10
            goto L14
        L10:
            r2 = move-exception
            j1.f.a(r2)
        L14:
            int r1 = r1 + 1
            r2 = 16
            if (r1 < r2) goto L2
            j1.c r2 = r3.f2195b
            boolean r2 = r2.b()
            if (r2 == 0) goto L2
            j1.c r0 = r3.f2195b
            r0.a(r3, r3)
            return
        L28:
            java.lang.Object r1 = r3.f2198e
            monitor-enter(r1)
            int r2 = r3.runningWorkers     // Catch: java.lang.Throwable -> L43
            int r2 = r2 + (-1)
            r3.runningWorkers = r2     // Catch: java.lang.Throwable -> L43
            n1.b r2 = r3.f2197d     // Catch: java.lang.Throwable -> L43
            int r2 = r2.c()     // Catch: java.lang.Throwable -> L43
            if (r2 != 0) goto L3b
            monitor-exit(r1)
            return
        L3b:
            int r2 = r3.runningWorkers     // Catch: java.lang.Throwable -> L43
            int r2 = r2 + 1
            r3.runningWorkers = r2     // Catch: java.lang.Throwable -> L43
            monitor-exit(r1)
            goto L1
        L43:
            r3 = move-exception
            monitor-exit(r1)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.a.run():void");
    }
}
