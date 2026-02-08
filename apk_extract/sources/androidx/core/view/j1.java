package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* loaded from: classes.dex */
public final class j1 extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f171a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f172b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f173c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f174d;

    public /* synthetic */ j1(Object obj, Object obj2, View view, int i2) {
        this.f171a = i2;
        this.f174d = obj;
        this.f173c = obj2;
        this.f172b = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        switch (this.f171a) {
            case 0:
                ((m1) this.f173c).onAnimationCancel(this.f172b);
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i2 = this.f171a;
        View view = this.f172b;
        Object obj = this.f173c;
        switch (i2) {
            case 0:
                ((m1) obj).onAnimationEnd(view);
                break;
            default:
                b2 b2Var = (b2) obj;
                b2Var.f133a.d(1.0f);
                w1.e(view, b2Var);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f171a) {
            case 0:
                ((m1) this.f173c).onAnimationStart(this.f172b);
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
