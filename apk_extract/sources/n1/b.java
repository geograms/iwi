package n1;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f2199a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_cur");
    private volatile /* synthetic */ Object _cur = new d(8, false);

    public final boolean a(Object obj) {
        while (true) {
            d dVar = (d) this._cur;
            int iA = dVar.a(obj);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2199a;
                d dVarE = dVar.e();
                while (!atomicReferenceFieldUpdater.compareAndSet(this, dVar, dVarE) && atomicReferenceFieldUpdater.get(this) == dVar) {
                }
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            d dVar = (d) this._cur;
            if (dVar.b()) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2199a;
            d dVarE = dVar.e();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, dVar, dVarE) && atomicReferenceFieldUpdater.get(this) == dVar) {
            }
        }
    }

    public final int c() {
        return ((d) this._cur).c();
    }

    public final Object d() {
        while (true) {
            d dVar = (d) this._cur;
            Object objF = dVar.f();
            if (objF != d.f2203g) {
                return objF;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2199a;
            d dVarE = dVar.e();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, dVar, dVarE) && atomicReferenceFieldUpdater.get(this) == dVar) {
            }
        }
    }
}
