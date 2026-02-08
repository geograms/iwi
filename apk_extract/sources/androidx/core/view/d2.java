package androidx.core.view;

import android.view.WindowInsets;

/* loaded from: classes.dex */
public class d2 extends f2 {

    /* renamed from: c, reason: collision with root package name */
    public final WindowInsets.Builder f142c;

    public d2() {
        this.f142c = new WindowInsets.Builder();
    }

    @Override // androidx.core.view.f2
    public n2 b() {
        a();
        n2 n2VarG = n2.g(null, this.f142c.build());
        n2VarG.f189a.o(this.f147b);
        return n2VarG;
    }

    @Override // androidx.core.view.f2
    public void d(k.f fVar) {
        this.f142c.setMandatorySystemGestureInsets(fVar.d());
    }

    @Override // androidx.core.view.f2
    public void e(k.f fVar) {
        this.f142c.setSystemGestureInsets(fVar.d());
    }

    @Override // androidx.core.view.f2
    public void f(k.f fVar) {
        this.f142c.setSystemWindowInsets(fVar.d());
    }

    @Override // androidx.core.view.f2
    public void g(k.f fVar) {
        this.f142c.setTappableElementInsets(fVar.d());
    }

    public void h(k.f fVar) {
        this.f142c.setStableInsets(fVar.d());
    }

    public d2(n2 n2Var) {
        WindowInsets.Builder builder;
        super(n2Var);
        WindowInsets windowInsetsF = n2Var.f();
        if (windowInsetsF != null) {
            builder = new WindowInsets.Builder(windowInsetsF);
        } else {
            builder = new WindowInsets.Builder();
        }
        this.f142c = builder;
    }
}
