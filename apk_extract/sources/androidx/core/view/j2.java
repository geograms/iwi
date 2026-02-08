package androidx.core.view;

import android.view.WindowInsets;

/* loaded from: classes.dex */
public class j2 extends i2 {

    /* renamed from: n, reason: collision with root package name */
    public k.f f175n;

    /* renamed from: o, reason: collision with root package name */
    public k.f f176o;

    /* renamed from: p, reason: collision with root package name */
    public k.f f177p;

    public j2(n2 n2Var, WindowInsets windowInsets) {
        super(n2Var, windowInsets);
        this.f175n = null;
        this.f176o = null;
        this.f177p = null;
    }

    @Override // androidx.core.view.l2
    public k.f g() {
        if (this.f176o == null) {
            this.f176o = k.f.c(this.f153c.getMandatorySystemGestureInsets());
        }
        return this.f176o;
    }

    @Override // androidx.core.view.l2
    public k.f i() {
        if (this.f175n == null) {
            this.f175n = k.f.c(this.f153c.getSystemGestureInsets());
        }
        return this.f175n;
    }

    @Override // androidx.core.view.l2
    public k.f k() {
        if (this.f177p == null) {
            this.f177p = k.f.c(this.f153c.getTappableElementInsets());
        }
        return this.f177p;
    }

    @Override // androidx.core.view.l2
    public n2 l(int i2, int i3, int i4, int i5) {
        return n2.g(null, this.f153c.inset(i2, i3, i4, i5));
    }
}
