package androidx.core.view;

import android.view.WindowInsets;

/* loaded from: classes.dex */
public abstract class h2 extends g2 {

    /* renamed from: m, reason: collision with root package name */
    public k.f f159m;

    public h2(n2 n2Var, WindowInsets windowInsets) {
        super(n2Var, windowInsets);
        this.f159m = null;
    }

    @Override // androidx.core.view.l2
    public n2 b() {
        return n2.g(null, this.f153c.consumeStableInsets());
    }

    @Override // androidx.core.view.l2
    public n2 c() {
        return n2.g(null, this.f153c.consumeSystemWindowInsets());
    }

    @Override // androidx.core.view.l2
    public final k.f h() {
        if (this.f159m == null) {
            WindowInsets windowInsets = this.f153c;
            this.f159m = k.f.b(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.f159m;
    }

    @Override // androidx.core.view.l2
    public boolean m() {
        return this.f153c.isConsumed();
    }
}
