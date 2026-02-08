package androidx.fragment.app;

import android.view.View;

/* loaded from: classes.dex */
public final class t implements f.a, n.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f603a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f604b;

    public /* synthetic */ t(int i2, Object obj) {
        this.f603a = i2;
        this.f604b = obj;
    }

    @Override // n.c
    public final void a() {
        int i2 = this.f603a;
        Object obj = this.f604b;
        switch (i2) {
            case 1:
                Fragment fragment = (Fragment) obj;
                if (fragment.getAnimatingAway() != null) {
                    View animatingAway = fragment.getAnimatingAway();
                    fragment.setAnimatingAway(null);
                    animatingAway.clearAnimation();
                }
                fragment.setAnimator(null);
                break;
            default:
                ((u1) obj).a();
                break;
        }
    }

    @Override // f.a
    public final Object apply(Object obj) {
        Fragment fragment = (Fragment) this.f604b;
        Object obj2 = fragment.mHost;
        return obj2 instanceof androidx.activity.result.i ? ((androidx.activity.result.i) obj2).getActivityResultRegistry() : fragment.requireActivity().getActivityResultRegistry();
    }
}
