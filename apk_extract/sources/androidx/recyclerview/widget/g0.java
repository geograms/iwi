package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: classes.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    public p0 f806a;

    /* renamed from: b, reason: collision with root package name */
    public int f807b;

    /* renamed from: c, reason: collision with root package name */
    public int f808c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f809d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f810e;

    public g0() {
        d();
    }

    public final void a() {
        this.f808c = this.f809d ? this.f806a.f() : this.f806a.h();
    }

    public final void b(int i2, View view) {
        if (this.f809d) {
            this.f808c = this.f806a.j() + this.f806a.b(view);
        } else {
            this.f808c = this.f806a.e(view);
        }
        this.f807b = i2;
    }

    public final void c(int i2, View view) {
        int iJ = this.f806a.j();
        if (iJ >= 0) {
            b(i2, view);
            return;
        }
        this.f807b = i2;
        if (!this.f809d) {
            int iE = this.f806a.e(view);
            int iH = iE - this.f806a.h();
            this.f808c = iE;
            if (iH > 0) {
                int iF = (this.f806a.f() - Math.min(0, (this.f806a.f() - iJ) - this.f806a.b(view))) - (this.f806a.c(view) + iE);
                if (iF < 0) {
                    this.f808c -= Math.min(iH, -iF);
                    return;
                }
                return;
            }
            return;
        }
        int iF2 = (this.f806a.f() - iJ) - this.f806a.b(view);
        this.f808c = this.f806a.f() - iF2;
        if (iF2 > 0) {
            int iC = this.f808c - this.f806a.c(view);
            int iH2 = this.f806a.h();
            int iMin = iC - (Math.min(this.f806a.e(view) - iH2, 0) + iH2);
            if (iMin < 0) {
                this.f808c = Math.min(iF2, -iMin) + this.f808c;
            }
        }
    }

    public final void d() {
        this.f807b = -1;
        this.f808c = Integer.MIN_VALUE;
        this.f809d = false;
        this.f810e = false;
    }

    public final String toString() {
        return "AnchorInfo{mPosition=" + this.f807b + ", mCoordinate=" + this.f808c + ", mLayoutFromEnd=" + this.f809d + ", mValid=" + this.f810e + '}';
    }
}
