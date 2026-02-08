package kotlinx.coroutines.scheduling;

import androidx.constraintlayout.solver.widgets.Optimizer;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f2080b = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "lastScheduledTask");

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f2081c = AtomicIntegerFieldUpdater.newUpdater(m.class, "producerIndex");

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f2082d = AtomicIntegerFieldUpdater.newUpdater(m.class, "consumerIndex");

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f2083e = AtomicIntegerFieldUpdater.newUpdater(m.class, "blockingTasksInBuffer");

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray f2084a = new AtomicReferenceArray(Optimizer.OPTIMIZATION_GRAPH_WRAP);
    private volatile /* synthetic */ Object lastScheduledTask = null;
    private volatile /* synthetic */ int producerIndex = 0;
    private volatile /* synthetic */ int consumerIndex = 0;
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;

    public final h a(h hVar) {
        if (hVar.f2069b.f2070a == 1) {
            f2083e.incrementAndGet(this);
        }
        if (this.producerIndex - this.consumerIndex == 127) {
            return hVar;
        }
        int i2 = this.producerIndex & 127;
        while (this.f2084a.get(i2) != null) {
            Thread.yield();
        }
        this.f2084a.lazySet(i2, hVar);
        f2081c.incrementAndGet(this);
        return null;
    }

    public final int b() {
        return this.lastScheduledTask != null ? (this.producerIndex - this.consumerIndex) + 1 : this.producerIndex - this.consumerIndex;
    }

    public final h c() {
        h hVar;
        while (true) {
            int i2 = this.consumerIndex;
            if (i2 - this.producerIndex == 0) {
                return null;
            }
            int i3 = i2 & 127;
            if (f2082d.compareAndSet(this, i2, i2 + 1) && (hVar = (h) this.f2084a.getAndSet(i3, null)) != null) {
                if (hVar.f2069b.f2070a == 1) {
                    f2083e.decrementAndGet(this);
                }
                return hVar;
            }
        }
    }

    public final long d(m mVar) {
        int i2 = mVar.producerIndex;
        AtomicReferenceArray atomicReferenceArray = mVar.f2084a;
        for (int i3 = mVar.consumerIndex; i3 != i2; i3++) {
            int i4 = i3 & 127;
            if (mVar.blockingTasksInBuffer == 0) {
                break;
            }
            h hVar = (h) atomicReferenceArray.get(i4);
            if (hVar != null && hVar.f2069b.f2070a == 1) {
                while (!atomicReferenceArray.compareAndSet(i4, hVar, null)) {
                    if (atomicReferenceArray.get(i4) != hVar) {
                        break;
                    }
                }
                f2083e.decrementAndGet(mVar);
                h hVar2 = (h) f2080b.getAndSet(this, hVar);
                if (hVar2 == null) {
                    return -1L;
                }
                a(hVar2);
                return -1L;
            }
        }
        return e(mVar, true);
    }

    public final long e(m mVar, boolean z2) {
        while (true) {
            h hVar = (h) mVar.lastScheduledTask;
            if (hVar == null) {
                return -2L;
            }
            if (z2 && hVar.f2069b.f2070a != 1) {
                return -2L;
            }
            k.f2076e.getClass();
            long jNanoTime = System.nanoTime() - hVar.f2068a;
            long j2 = k.f2072a;
            if (jNanoTime < j2) {
                return j2 - jNanoTime;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2080b;
            while (!atomicReferenceFieldUpdater.compareAndSet(mVar, hVar, null)) {
                if (atomicReferenceFieldUpdater.get(mVar) != hVar) {
                    break;
                }
            }
            h hVar2 = (h) f2080b.getAndSet(this, hVar);
            if (hVar2 == null) {
                return -1L;
            }
            a(hVar2);
            return -1L;
        }
    }
}
