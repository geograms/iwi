package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class e0 extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f486a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f487b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Fragment f488c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ n0 f489d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ n.d f490e;

    public e0(ViewGroup viewGroup, View view, Fragment fragment, n0 n0Var, n.d dVar) {
        this.f486a = viewGroup;
        this.f487b = view;
        this.f488c = fragment;
        this.f489d = n0Var;
        this.f490e = dVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ViewGroup viewGroup = this.f486a;
        View view = this.f487b;
        viewGroup.endViewTransition(view);
        Fragment fragment = this.f488c;
        Animator animator2 = fragment.getAnimator();
        fragment.setAnimator(null);
        if (animator2 == null || viewGroup.indexOfChild(view) >= 0) {
            return;
        }
        this.f489d.c(fragment, this.f490e);
    }
}
