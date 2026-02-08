package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;

/* loaded from: classes.dex */
public abstract class q0 {

    /* renamed from: a, reason: collision with root package name */
    public final h1 f940a;

    /* renamed from: b, reason: collision with root package name */
    public int f941b = Integer.MIN_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f942c = new Rect();

    public q0(h1 h1Var) {
        this.f940a = h1Var;
    }

    public static p0 a(h1 h1Var, int i2) {
        if (i2 == 0) {
            return new p0(h1Var, 0);
        }
        if (i2 == 1) {
            return new p0(h1Var, 1);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public abstract int b(View view);

    public abstract int c(View view);

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public final int j() {
        if (Integer.MIN_VALUE == this.f941b) {
            return 0;
        }
        return i() - this.f941b;
    }

    public abstract int k(View view);

    public abstract int l(View view);

    public abstract void m(int i2);
}
