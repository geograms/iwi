package androidx.fragment.app;

import android.transition.Transition;

/* loaded from: classes.dex */
public final class k extends j {

    /* renamed from: c, reason: collision with root package name */
    public final Object f550c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f551d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f552e;

    public k(u1 u1Var, n.d dVar, boolean z2, boolean z3) {
        super(u1Var, dVar);
        int i2 = u1Var.f616a;
        Fragment fragment = u1Var.f618c;
        if (i2 == 2) {
            this.f550c = z2 ? fragment.getReenterTransition() : fragment.getEnterTransition();
            this.f551d = z2 ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        } else {
            this.f550c = z2 ? fragment.getReturnTransition() : fragment.getExitTransition();
            this.f551d = true;
        }
        if (!z3) {
            this.f552e = null;
        } else if (z2) {
            this.f552e = fragment.getSharedElementReturnTransition();
        } else {
            this.f552e = fragment.getSharedElementEnterTransition();
        }
    }

    public final q1 c(Object obj) {
        if (obj == null) {
            return null;
        }
        o1 o1Var = j1.f548a;
        if (obj instanceof Transition) {
            return o1Var;
        }
        q1 q1Var = j1.f549b;
        if (q1Var != null && q1Var.e(obj)) {
            return q1Var;
        }
        throw new IllegalArgumentException("Transition " + obj + " for fragment " + this.f545a.f618c + " is not a valid framework Transition or AndroidX Transition");
    }
}
