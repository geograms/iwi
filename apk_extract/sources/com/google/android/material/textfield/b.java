package com.google.android.material.textfield;

import android.animation.ValueAnimator;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1610a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EndIconDelegate f1611b;

    public /* synthetic */ b(EndIconDelegate endIconDelegate, int i2) {
        this.f1610a = i2;
        this.f1611b = endIconDelegate;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i2 = this.f1610a;
        EndIconDelegate endIconDelegate = this.f1611b;
        switch (i2) {
            case 0:
                ((ClearTextEndIconDelegate) endIconDelegate).lambda$getScaleAnimator$4(valueAnimator);
                break;
            case 1:
                ((ClearTextEndIconDelegate) endIconDelegate).lambda$getAlphaAnimator$3(valueAnimator);
                break;
            default:
                ((DropdownMenuEndIconDelegate) endIconDelegate).lambda$getAlphaAnimator$6(valueAnimator);
                break;
        }
    }
}
