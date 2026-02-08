package androidx.fragment.app;

import java.util.HashSet;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public final u1 f545a;

    /* renamed from: b, reason: collision with root package name */
    public final n.d f546b;

    public j(u1 u1Var, n.d dVar) {
        this.f545a = u1Var;
        this.f546b = dVar;
    }

    public final void a() {
        u1 u1Var = this.f545a;
        HashSet hashSet = u1Var.f620e;
        if (hashSet.remove(this.f546b) && hashSet.isEmpty()) {
            u1Var.b();
        }
    }

    public final boolean b() {
        u1 u1Var = this.f545a;
        int iC = v1.c(u1Var.f618c.mView);
        int i2 = u1Var.f616a;
        return iC == i2 || !(iC == 2 || i2 == 2);
    }
}
