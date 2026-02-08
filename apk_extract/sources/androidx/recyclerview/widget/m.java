package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* loaded from: classes.dex */
public final class m extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f885a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f886b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f887c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f888d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ p f889e;

    public /* synthetic */ m(p pVar, n nVar, ViewPropertyAnimator viewPropertyAnimator, View view, int i2) {
        this.f885a = i2;
        this.f889e = pVar;
        this.f886b = nVar;
        this.f887c = viewPropertyAnimator;
        this.f888d = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i2 = this.f885a;
        p pVar = this.f889e;
        n nVar = this.f886b;
        View view = this.f888d;
        ViewPropertyAnimator viewPropertyAnimator = this.f887c;
        switch (i2) {
            case 0:
                viewPropertyAnimator.setListener(null);
                view.setAlpha(1.0f);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                pVar.c(nVar.f891a);
                pVar.f923r.remove(nVar.f891a);
                pVar.i();
                break;
            default:
                viewPropertyAnimator.setListener(null);
                view.setAlpha(1.0f);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                pVar.c(nVar.f892b);
                pVar.f923r.remove(nVar.f892b);
                pVar.i();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        int i2 = this.f885a;
        p pVar = this.f889e;
        n nVar = this.f886b;
        switch (i2) {
            case 0:
                z1 z1Var = nVar.f891a;
                pVar.getClass();
                break;
            default:
                z1 z1Var2 = nVar.f892b;
                pVar.getClass();
                break;
        }
    }
}
