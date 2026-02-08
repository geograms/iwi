package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class l0 extends AnimatorListenerAdapter implements u {

    /* renamed from: a, reason: collision with root package name */
    public final View f1094a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1095b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewGroup f1096c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1098e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1099f = false;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f1097d = true;

    public l0(View view, int i2) {
        this.f1094a = view;
        this.f1095b = i2;
        this.f1096c = (ViewGroup) view.getParent();
        a(true);
    }

    public final void a(boolean z2) {
        ViewGroup viewGroup;
        if (!this.f1097d || this.f1098e == z2 || (viewGroup = this.f1096c) == null) {
            return;
        }
        this.f1098e = z2;
        viewGroup.suppressLayout(z2);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f1099f = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (!this.f1099f) {
            c cVar = e0.f1062a;
            this.f1094a.setTransitionVisibility(this.f1095b);
            ViewGroup viewGroup = this.f1096c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        a(false);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationPause(Animator animator) {
        if (this.f1099f) {
            return;
        }
        c cVar = e0.f1062a;
        this.f1094a.setTransitionVisibility(this.f1095b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationResume(Animator animator) {
        if (this.f1099f) {
            return;
        }
        c cVar = e0.f1062a;
        this.f1094a.setTransitionVisibility(0);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }

    @Override // androidx.transition.u
    public final void onTransitionCancel(v vVar) {
    }

    @Override // androidx.transition.u
    public final void onTransitionEnd(v vVar) {
        if (!this.f1099f) {
            c cVar = e0.f1062a;
            this.f1094a.setTransitionVisibility(this.f1095b);
            ViewGroup viewGroup = this.f1096c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        a(false);
        vVar.removeListener(this);
    }

    @Override // androidx.transition.u
    public final void onTransitionPause(v vVar) {
        a(false);
    }

    @Override // androidx.transition.u
    public final void onTransitionResume(v vVar) {
        a(true);
    }

    @Override // androidx.transition.u
    public final void onTransitionStart(v vVar) {
    }
}
