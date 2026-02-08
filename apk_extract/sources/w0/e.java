package w0;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public final f f2629a;

    /* renamed from: b, reason: collision with root package name */
    public int f2630b;

    /* renamed from: c, reason: collision with root package name */
    public int f2631c;

    public e(f fVar) {
        x0.g.u(fVar, "map");
        this.f2629a = fVar;
        this.f2631c = -1;
        a();
    }

    public final void a() {
        while (true) {
            int i2 = this.f2630b;
            f fVar = this.f2629a;
            if (i2 >= fVar.f2637f || fVar.f2634c[i2] >= 0) {
                return;
            } else {
                this.f2630b = i2 + 1;
            }
        }
    }

    public final boolean hasNext() {
        return this.f2630b < this.f2629a.f2637f;
    }

    public final void remove() {
        if (this.f2631c == -1) {
            throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
        }
        f fVar = this.f2629a;
        fVar.b();
        fVar.j(this.f2631c);
        this.f2631c = -1;
    }
}
