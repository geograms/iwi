package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class n2 {

    /* renamed from: b, reason: collision with root package name */
    public static final n2 f188b;

    /* renamed from: a, reason: collision with root package name */
    public final l2 f189a;

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f188b = k2.f182q;
        } else {
            f188b = l2.f185b;
        }
    }

    public n2(WindowInsets windowInsets) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f189a = new k2(this, windowInsets);
        } else {
            this.f189a = new j2(this, windowInsets);
        }
    }

    public static k.f e(k.f fVar, int i2, int i3, int i4, int i5) {
        int iMax = Math.max(0, fVar.f1926a - i2);
        int iMax2 = Math.max(0, fVar.f1927b - i3);
        int iMax3 = Math.max(0, fVar.f1928c - i4);
        int iMax4 = Math.max(0, fVar.f1929d - i5);
        return (iMax == i2 && iMax2 == i3 && iMax3 == i4 && iMax4 == i5) ? fVar : k.f.b(iMax, iMax2, iMax3, iMax4);
    }

    public static n2 g(View view, WindowInsets windowInsets) {
        windowInsets.getClass();
        n2 n2Var = new n2(windowInsets);
        if (view != null) {
            WeakHashMap weakHashMap = d1.f138a;
            if (p0.b(view)) {
                n2 n2VarA = t0.a(view);
                l2 l2Var = n2Var.f189a;
                l2Var.p(n2VarA);
                l2Var.d(view.getRootView());
            }
        }
        return n2Var;
    }

    public final int a() {
        return this.f189a.j().f1929d;
    }

    public final int b() {
        return this.f189a.j().f1926a;
    }

    public final int c() {
        return this.f189a.j().f1928c;
    }

    public final int d() {
        return this.f189a.j().f1927b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n2)) {
            return false;
        }
        return q.b.a(this.f189a, ((n2) obj).f189a);
    }

    public final WindowInsets f() {
        l2 l2Var = this.f189a;
        if (l2Var instanceof g2) {
            return ((g2) l2Var).f153c;
        }
        return null;
    }

    public final int hashCode() {
        l2 l2Var = this.f189a;
        if (l2Var == null) {
            return 0;
        }
        return l2Var.hashCode();
    }

    public n2() {
        this.f189a = new l2(this);
    }
}
