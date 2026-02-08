package androidx.fragment.app;

/* loaded from: classes.dex */
public final class t1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f605a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u1 f606b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w1 f607c;

    public /* synthetic */ t1(w1 w1Var, u1 u1Var, int i2) {
        this.f605a = i2;
        this.f607c = w1Var;
        this.f606b = u1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f605a;
        u1 u1Var = this.f606b;
        w1 w1Var = this.f607c;
        switch (i2) {
            case 0:
                if (w1Var.f674b.contains(u1Var)) {
                    v1.a(u1Var.f616a, u1Var.f618c.mView);
                    break;
                }
                break;
            default:
                w1Var.f674b.remove(u1Var);
                w1Var.f675c.remove(u1Var);
                break;
        }
    }
}
