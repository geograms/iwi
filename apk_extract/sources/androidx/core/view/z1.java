package androidx.core.view;

import android.view.WindowInsetsAnimation;

/* loaded from: classes.dex */
public final class z1 extends a2 {

    /* renamed from: e, reason: collision with root package name */
    public final WindowInsetsAnimation f230e;

    public z1(WindowInsetsAnimation windowInsetsAnimation) {
        super(0, null, 0L);
        this.f230e = windowInsetsAnimation;
    }

    @Override // androidx.core.view.a2
    public final long a() {
        return this.f230e.getDurationMillis();
    }

    @Override // androidx.core.view.a2
    public final float b() {
        return this.f230e.getInterpolatedFraction();
    }

    @Override // androidx.core.view.a2
    public final int c() {
        return this.f230e.getTypeMask();
    }

    @Override // androidx.core.view.a2
    public final void d(float f2) {
        this.f230e.setFraction(f2);
    }
}
