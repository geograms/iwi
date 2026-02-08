package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class x extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f990a = 1;

    /* renamed from: b, reason: collision with root package name */
    public boolean f991b = false;

    /* renamed from: c, reason: collision with root package name */
    public final Object f992c;

    public x(View view) {
        this.f992c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        switch (this.f990a) {
            case 0:
                this.f991b = true;
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i2 = this.f990a;
        Object obj = this.f992c;
        switch (i2) {
            case 0:
                if (!this.f991b) {
                    z zVar = (z) obj;
                    if (((Float) zVar.f1026z.getAnimatedValue()).floatValue() != 0.0f) {
                        zVar.A = 2;
                        zVar.f1019s.invalidate();
                        break;
                    } else {
                        zVar.A = 0;
                        zVar.d(0);
                        break;
                    }
                } else {
                    this.f991b = false;
                    break;
                }
            default:
                View view = (View) obj;
                androidx.transition.c cVar = androidx.transition.e0.f1062a;
                view.setTransitionAlpha(1.0f);
                if (this.f991b) {
                    view.setLayerType(0, null);
                    break;
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f990a) {
            case 1:
                View view = (View) this.f992c;
                WeakHashMap weakHashMap = androidx.core.view.d1.f138a;
                if (androidx.core.view.m0.h(view) && view.getLayerType() == 0) {
                    this.f991b = true;
                    view.setLayerType(2, null);
                    break;
                }
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }

    public x(z zVar) {
        this.f992c = zVar;
    }
}
