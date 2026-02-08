package q;

import o.j;

/* loaded from: classes.dex */
public final class e extends j {

    /* renamed from: c, reason: collision with root package name */
    public final Object f2478c;

    public e(int i2) {
        super(i2);
        this.f2478c = new Object();
    }

    @Override // o.j, q.d
    public final Object acquire() {
        Object objAcquire;
        synchronized (this.f2478c) {
            objAcquire = super.acquire();
        }
        return objAcquire;
    }

    @Override // o.j, q.d
    public final boolean release(Object obj) {
        boolean zRelease;
        synchronized (this.f2478c) {
            zRelease = super.release(obj);
        }
        return zRelease;
    }
}
