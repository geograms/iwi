package androidx.recyclerview.widget;

import android.animation.ValueAnimator;

/* loaded from: classes.dex */
public final class y implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z f993a;

    public y(z zVar) {
        this.f993a = zVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
        z zVar = this.f993a;
        zVar.f1003c.setAlpha(iFloatValue);
        zVar.f1004d.setAlpha(iFloatValue);
        zVar.f1019s.invalidate();
    }
}
