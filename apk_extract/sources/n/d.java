package n;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2135a;

    /* renamed from: b, reason: collision with root package name */
    public c f2136b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2137c;

    public final void a() {
        synchronized (this) {
            try {
                if (this.f2135a) {
                    return;
                }
                this.f2135a = true;
                this.f2137c = true;
                c cVar = this.f2136b;
                if (cVar != null) {
                    try {
                        cVar.a();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f2137c = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                synchronized (this) {
                    this.f2137c = false;
                    notifyAll();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void b(c cVar) {
        synchronized (this) {
            while (this.f2137c) {
                try {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.f2136b == cVar) {
                return;
            }
            this.f2136b = cVar;
            if (this.f2135a) {
                cVar.a();
            }
        }
    }
}
