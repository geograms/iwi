package androidx.customview.widget;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public final class f implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f265a;

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f2) {
        switch (this.f265a) {
            case 0:
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            default:
                float f4 = f2 - 1.0f;
                return (f4 * f4 * f4 * f4 * f4) + 1.0f;
        }
    }
}
