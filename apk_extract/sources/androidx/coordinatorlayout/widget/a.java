package androidx.coordinatorlayout.widget;

import android.view.View;
import androidx.core.view.c0;
import androidx.core.view.n2;

/* loaded from: classes.dex */
public final class a implements c0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f74a;

    public a(CoordinatorLayout coordinatorLayout) {
        this.f74a = coordinatorLayout;
    }

    @Override // androidx.core.view.c0
    public final n2 onApplyWindowInsets(View view, n2 n2Var) {
        return this.f74a.setWindowInsets(n2Var);
    }
}
