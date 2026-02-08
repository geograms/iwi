package androidx.fragment.app;

/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u1 f496a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u1 f497b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f498c;

    public f(u1 u1Var, u1 u1Var2, boolean z2, g.b bVar) {
        this.f496a = u1Var;
        this.f497b = u1Var2;
        this.f498c = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j1.a(this.f496a.f618c, this.f497b.f618c, this.f498c);
    }
}
