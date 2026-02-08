package androidx.transition;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class k0 extends w {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f1083a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f1084b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f1085c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ n0 f1086d;

    public k0(n0 n0Var, ViewGroup viewGroup, View view, View view2) {
        this.f1086d = n0Var;
        this.f1083a = viewGroup;
        this.f1084b = view;
        this.f1085c = view2;
    }

    @Override // androidx.transition.u
    public final void onTransitionEnd(v vVar) {
        this.f1085c.setTag(R$id.save_overlay_view, null);
        this.f1083a.getOverlay().remove(this.f1084b);
        vVar.removeListener(this);
    }

    @Override // androidx.transition.w, androidx.transition.u
    public final void onTransitionPause(v vVar) {
        this.f1083a.getOverlay().remove(this.f1084b);
    }

    @Override // androidx.transition.w, androidx.transition.u
    public final void onTransitionResume(v vVar) {
        View view = this.f1084b;
        if (view.getParent() == null) {
            this.f1083a.getOverlay().add(view);
        } else {
            this.f1086d.cancel();
        }
    }
}
