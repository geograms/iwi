package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* loaded from: classes.dex */
public final class k extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f867a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z1 f868b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f869c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f870d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ p f871e;

    public k(p pVar, z1 z1Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f871e = pVar;
        this.f868b = z1Var;
        this.f870d = viewPropertyAnimator;
        this.f869c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        switch (this.f867a) {
            case 1:
                this.f869c.setAlpha(1.0f);
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i2 = this.f867a;
        z1 z1Var = this.f868b;
        p pVar = this.f871e;
        ViewPropertyAnimator viewPropertyAnimator = this.f870d;
        switch (i2) {
            case 0:
                viewPropertyAnimator.setListener(null);
                this.f869c.setAlpha(1.0f);
                pVar.c(z1Var);
                pVar.f922q.remove(z1Var);
                pVar.i();
                break;
            default:
                viewPropertyAnimator.setListener(null);
                pVar.c(z1Var);
                pVar.f920o.remove(z1Var);
                pVar.i();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        int i2 = this.f867a;
        p pVar = this.f871e;
        switch (i2) {
            case 0:
                pVar.getClass();
                break;
            default:
                pVar.getClass();
                break;
        }
    }

    public k(p pVar, z1 z1Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.f871e = pVar;
        this.f868b = z1Var;
        this.f869c = view;
        this.f870d = viewPropertyAnimator;
    }
}
