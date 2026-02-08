package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* loaded from: classes.dex */
public final class l extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z1 f874a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f875b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f876c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f877d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f878e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ p f879f;

    public l(p pVar, z1 z1Var, int i2, View view, int i3, ViewPropertyAnimator viewPropertyAnimator) {
        this.f879f = pVar;
        this.f874a = z1Var;
        this.f875b = i2;
        this.f876c = view;
        this.f877d = i3;
        this.f878e = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        int i2 = this.f875b;
        View view = this.f876c;
        if (i2 != 0) {
            view.setTranslationX(0.0f);
        }
        if (this.f877d != 0) {
            view.setTranslationY(0.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f878e.setListener(null);
        p pVar = this.f879f;
        z1 z1Var = this.f874a;
        pVar.c(z1Var);
        pVar.f921p.remove(z1Var);
        pVar.i();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f879f.getClass();
    }
}
