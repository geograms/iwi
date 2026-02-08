package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import com.google.android.material.shape.MaterialShapeDrawable;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1521a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f1522b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MaterialShapeDrawable f1523c;

    public /* synthetic */ a(AppBarLayout appBarLayout, MaterialShapeDrawable materialShapeDrawable, int i2) {
        this.f1521a = i2;
        this.f1522b = appBarLayout;
        this.f1523c = materialShapeDrawable;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i2 = this.f1521a;
        MaterialShapeDrawable materialShapeDrawable = this.f1523c;
        AppBarLayout appBarLayout = this.f1522b;
        switch (i2) {
            case 0:
                appBarLayout.lambda$initializeLiftOnScrollWithColor$0(materialShapeDrawable, valueAnimator);
                break;
            default:
                appBarLayout.lambda$initializeLiftOnScrollWithElevation$1(materialShapeDrawable, valueAnimator);
                break;
        }
    }
}
