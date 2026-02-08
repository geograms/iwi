package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

/* loaded from: classes.dex */
public final class r0 extends k0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s0 f946a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r0(s0 s0Var, Context context) {
        super(context);
        this.f946a = s0Var;
    }

    @Override // androidx.recyclerview.widget.k0
    public final float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }

    @Override // androidx.recyclerview.widget.k0
    public final int calculateTimeForScrolling(int i2) {
        return Math.min(100, super.calculateTimeForScrolling(i2));
    }

    @Override // androidx.recyclerview.widget.k0, androidx.recyclerview.widget.v1
    public final void onTargetFound(View view, w1 w1Var, t1 t1Var) {
        s0 s0Var = this.f946a;
        int[] iArrA = s0Var.a(s0Var.f952a.getLayoutManager(), view);
        int i2 = iArrA[0];
        int i3 = iArrA[1];
        int iCalculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i2), Math.abs(i3)));
        if (iCalculateTimeForDeceleration > 0) {
            DecelerateInterpolator decelerateInterpolator = this.mDecelerateInterpolator;
            t1Var.f964a = i2;
            t1Var.f965b = i3;
            t1Var.f966c = iCalculateTimeForDeceleration;
            t1Var.f968e = decelerateInterpolator;
            t1Var.f969f = true;
        }
    }
}
