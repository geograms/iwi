package androidx.core.view;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import java.util.Collections;

/* loaded from: classes.dex */
public final class t1 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b2 f204a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n2 f205b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n2 f206c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f207d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ View f208e;

    public t1(b2 b2Var, n2 n2Var, n2 n2Var2, int i2, View view) {
        this.f204a = b2Var;
        this.f205b = n2Var;
        this.f206c = n2Var2;
        this.f207d = i2;
        this.f208e = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        b2 b2Var = this.f204a;
        b2Var.f133a.d(animatedFraction);
        float fB = b2Var.f133a.b();
        int i2 = Build.VERSION.SDK_INT;
        n2 n2Var = this.f205b;
        f2 e2Var = i2 >= 30 ? new e2(n2Var) : new d2(n2Var);
        for (int i3 = 1; i3 <= 256; i3 <<= 1) {
            if ((this.f207d & i3) == 0) {
                e2Var.c(i3, n2Var.f189a.f(i3));
            } else {
                k.f fVarF = n2Var.f189a.f(i3);
                k.f fVarF2 = this.f206c.f189a.f(i3);
                float f2 = 1.0f - fB;
                e2Var.c(i3, n2.e(fVarF, (int) (((fVarF.f1926a - fVarF2.f1926a) * f2) + 0.5d), (int) (((fVarF.f1927b - fVarF2.f1927b) * f2) + 0.5d), (int) (((fVarF.f1928c - fVarF2.f1928c) * f2) + 0.5d), (int) (((fVarF.f1929d - fVarF2.f1929d) * f2) + 0.5d)));
            }
        }
        w1.g(this.f208e, e2Var.b(), Collections.singletonList(b2Var));
    }
}
