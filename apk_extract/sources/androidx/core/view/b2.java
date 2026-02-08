package androidx.core.view;

import android.os.Build;
import android.view.animation.DecelerateInterpolator;

/* loaded from: classes.dex */
public final class b2 {

    /* renamed from: a, reason: collision with root package name */
    public a2 f133a;

    public b2(int i2, DecelerateInterpolator decelerateInterpolator, long j2) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f133a = new z1(x1.j(i2, decelerateInterpolator, j2));
        } else {
            this.f133a = new w1(i2, decelerateInterpolator, j2);
        }
    }
}
