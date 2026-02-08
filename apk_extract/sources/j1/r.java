package j1;

/* loaded from: classes.dex */
public final class r extends c {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f1920b = 0;

    static {
        new r();
    }

    @Override // j1.c
    public final void a(x0.j jVar, Runnable runnable) {
        a.a.k(jVar.get(s.f1921a));
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    @Override // j1.c
    public final String toString() {
        return "Dispatchers.Unconfined";
    }
}
