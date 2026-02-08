package androidx.transition;

import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class e extends w {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1060a = false;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f1061b;

    public e(ViewGroup viewGroup) {
        this.f1061b = viewGroup;
    }

    @Override // androidx.transition.w, androidx.transition.u
    public final void onTransitionCancel(v vVar) {
        this.f1061b.suppressLayout(false);
        this.f1060a = true;
    }

    @Override // androidx.transition.u
    public final void onTransitionEnd(v vVar) {
        if (!this.f1060a) {
            this.f1061b.suppressLayout(false);
        }
        vVar.removeListener(this);
    }

    @Override // androidx.transition.w, androidx.transition.u
    public final void onTransitionPause(v vVar) {
        this.f1061b.suppressLayout(false);
    }

    @Override // androidx.transition.w, androidx.transition.u
    public final void onTransitionResume(v vVar) {
        this.f1061b.suppressLayout(true);
    }
}
