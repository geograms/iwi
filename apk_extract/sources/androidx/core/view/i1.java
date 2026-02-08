package androidx.core.view;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import com.google.android.material.internal.ExpandCollapseAnimationHelper;

/* loaded from: classes.dex */
public final /* synthetic */ class i1 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f161a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f162b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f163c;

    public /* synthetic */ i1(int i2, Object obj, Object obj2) {
        this.f161a = i2;
        this.f162b = obj;
        this.f163c = obj2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i2 = this.f161a;
        Object obj = this.f163c;
        Object obj2 = this.f162b;
        switch (i2) {
            case 0:
                ((o1) obj2).onAnimationUpdate((View) obj);
                break;
            default:
                ((ExpandCollapseAnimationHelper) obj2).lambda$getExpandCollapseAnimator$0((Rect) obj, valueAnimator);
                break;
        }
    }
}
