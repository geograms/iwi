package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* loaded from: classes.dex */
public final class q extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g.b f1109a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v f1110b;

    public q(v vVar, g.b bVar) {
        this.f1110b = vVar;
        this.f1109a = bVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f1109a.remove(animator);
        this.f1110b.mCurrentAnimators.remove(animator);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f1110b.mCurrentAnimators.add(animator);
    }
}
