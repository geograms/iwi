package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import com.google.android.material.internal.FadeThroughDrawable;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1583a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1584b;

    public /* synthetic */ d(int i2, Object obj) {
        this.f1583a = i2;
        this.f1584b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i2 = this.f1583a;
        Object obj = this.f1584b;
        switch (i2) {
            case 0:
                ((View) obj).setAlpha(0.0f);
                break;
            case 1:
                SearchViewAnimationHelper.lambda$addFadeThroughDrawableAnimatorIfNeeded$4((FadeThroughDrawable) obj, valueAnimator);
                break;
            default:
                SearchViewAnimationHelper.lambda$addDrawerArrowDrawableAnimatorIfNeeded$3((DrawerArrowDrawable) obj, valueAnimator);
                break;
        }
    }
}
