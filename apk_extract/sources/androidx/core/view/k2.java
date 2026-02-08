package androidx.core.view;

import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public final class k2 extends j2 {

    /* renamed from: q, reason: collision with root package name */
    public static final n2 f182q = n2.g(null, WindowInsets.CONSUMED);

    public k2(n2 n2Var, WindowInsets windowInsets) {
        super(n2Var, windowInsets);
    }

    @Override // androidx.core.view.g2, androidx.core.view.l2
    public final void d(View view) {
    }

    @Override // androidx.core.view.g2, androidx.core.view.l2
    public k.f f(int i2) {
        return k.f.c(this.f153c.getInsets(m2.a(i2)));
    }
}
