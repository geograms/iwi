package androidx.core.view;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.animation.DecelerateInterpolator;
import java.util.Objects;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class v1 implements View.OnApplyWindowInsetsListener {

    /* renamed from: a, reason: collision with root package name */
    public final s1 f219a;

    /* renamed from: b, reason: collision with root package name */
    public n2 f220b;

    public v1(View view, s1 s1Var) {
        n2 n2VarB;
        this.f219a = s1Var;
        WeakHashMap weakHashMap = d1.f138a;
        n2 n2VarA = t0.a(view);
        if (n2VarA != null) {
            n2VarB = (Build.VERSION.SDK_INT >= 30 ? new e2(n2VarA) : new d2(n2VarA)).b();
        } else {
            n2VarB = null;
        }
        this.f220b = n2VarB;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        l2 l2Var;
        if (!view.isLaidOut()) {
            this.f220b = n2.g(view, windowInsets);
            return w1.i(view, windowInsets);
        }
        n2 n2VarG = n2.g(view, windowInsets);
        if (this.f220b == null) {
            WeakHashMap weakHashMap = d1.f138a;
            this.f220b = t0.a(view);
        }
        if (this.f220b == null) {
            this.f220b = n2VarG;
            return w1.i(view, windowInsets);
        }
        s1 s1VarJ = w1.j(view);
        if (s1VarJ != null && Objects.equals(s1VarJ.mDispachedInsets, windowInsets)) {
            return w1.i(view, windowInsets);
        }
        n2 n2Var = this.f220b;
        int i2 = 1;
        int i3 = 0;
        while (true) {
            l2Var = n2VarG.f189a;
            if (i2 > 256) {
                break;
            }
            if (!l2Var.f(i2).equals(n2Var.f189a.f(i2))) {
                i3 |= i2;
            }
            i2 <<= 1;
        }
        if (i3 == 0) {
            return w1.i(view, windowInsets);
        }
        n2 n2Var2 = this.f220b;
        b2 b2Var = new b2(i3, new DecelerateInterpolator(), 160L);
        b2Var.f133a.d(0.0f);
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(b2Var.f133a.a());
        k.f fVarF = l2Var.f(i3);
        k.f fVarF2 = n2Var2.f189a.f(i3);
        int iMin = Math.min(fVarF.f1926a, fVarF2.f1926a);
        int i4 = fVarF.f1927b;
        int i5 = fVarF2.f1927b;
        int iMin2 = Math.min(i4, i5);
        int i6 = fVarF.f1928c;
        int i7 = fVarF2.f1928c;
        int iMin3 = Math.min(i6, i7);
        int i8 = fVarF.f1929d;
        int i9 = i3;
        int i10 = fVarF2.f1929d;
        r1 r1Var = new r1(k.f.b(iMin, iMin2, iMin3, Math.min(i8, i10)), k.f.b(Math.max(fVarF.f1926a, fVarF2.f1926a), Math.max(i4, i5), Math.max(i6, i7), Math.max(i8, i10)));
        w1.f(view, b2Var, windowInsets, false);
        duration.addUpdateListener(new t1(b2Var, n2VarG, n2Var2, i9, view));
        duration.addListener(new j1(this, b2Var, view, 1));
        f0.a(view, new u1(view, b2Var, r1Var, duration));
        this.f220b = n2VarG;
        return w1.i(view, windowInsets);
    }
}
