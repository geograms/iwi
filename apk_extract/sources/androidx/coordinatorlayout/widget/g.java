package androidx.coordinatorlayout.widget;

import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
public final class g implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f94a;

    public g(CoordinatorLayout coordinatorLayout) {
        this.f94a = coordinatorLayout;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.f94a.onChildViewsChanged(0);
        return true;
    }
}
