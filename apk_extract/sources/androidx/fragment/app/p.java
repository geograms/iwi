package androidx.fragment.app;

import android.view.View;

/* loaded from: classes.dex */
public final class p extends i0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i0 f581a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f582b;

    public p(q qVar, i0 i0Var) {
        this.f582b = qVar;
        this.f581a = i0Var;
    }

    @Override // androidx.fragment.app.i0
    public final View b(int i2) {
        i0 i0Var = this.f581a;
        return i0Var.c() ? i0Var.b(i2) : this.f582b.onFindViewById(i2);
    }

    @Override // androidx.fragment.app.i0
    public final boolean c() {
        return this.f581a.c() || this.f582b.onHasView();
    }
}
