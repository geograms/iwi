package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class c extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f458a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f459b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f460c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ u1 f461d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ i f462e;

    public c(ViewGroup viewGroup, View view, boolean z2, u1 u1Var, i iVar) {
        this.f458a = viewGroup;
        this.f459b = view;
        this.f460c = z2;
        this.f461d = u1Var;
        this.f462e = iVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ViewGroup viewGroup = this.f458a;
        View view = this.f459b;
        viewGroup.endViewTransition(view);
        if (this.f460c) {
            v1.a(this.f461d.f616a, view);
        }
        this.f462e.a();
    }
}
