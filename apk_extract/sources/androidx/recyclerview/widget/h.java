package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public long f825a = 0;

    /* renamed from: b, reason: collision with root package name */
    public h f826b;

    public final void a(int i2) {
        if (i2 < 64) {
            this.f825a &= ~(1 << i2);
            return;
        }
        h hVar = this.f826b;
        if (hVar != null) {
            hVar.a(i2 - 64);
        }
    }

    public final int b(int i2) {
        h hVar = this.f826b;
        if (hVar == null) {
            if (i2 >= 64) {
                return Long.bitCount(this.f825a);
            }
            return Long.bitCount(((1 << i2) - 1) & this.f825a);
        }
        if (i2 < 64) {
            return Long.bitCount(((1 << i2) - 1) & this.f825a);
        }
        return Long.bitCount(this.f825a) + hVar.b(i2 - 64);
    }

    public final void c() {
        if (this.f826b == null) {
            this.f826b = new h();
        }
    }

    public final boolean d(int i2) {
        if (i2 < 64) {
            return ((1 << i2) & this.f825a) != 0;
        }
        c();
        return this.f826b.d(i2 - 64);
    }

    public final void e(int i2, boolean z2) {
        if (i2 >= 64) {
            c();
            this.f826b.e(i2 - 64, z2);
            return;
        }
        long j2 = this.f825a;
        boolean z3 = (Long.MIN_VALUE & j2) != 0;
        long j3 = (1 << i2) - 1;
        this.f825a = ((j2 & (~j3)) << 1) | (j2 & j3);
        if (z2) {
            h(i2);
        } else {
            a(i2);
        }
        if (z3 || this.f826b != null) {
            c();
            this.f826b.e(0, z3);
        }
    }

    public final boolean f(int i2) {
        if (i2 >= 64) {
            c();
            return this.f826b.f(i2 - 64);
        }
        long j2 = 1 << i2;
        long j3 = this.f825a;
        boolean z2 = (j3 & j2) != 0;
        long j4 = j3 & (~j2);
        this.f825a = j4;
        long j5 = j2 - 1;
        this.f825a = (j4 & j5) | Long.rotateRight((~j5) & j4, 1);
        h hVar = this.f826b;
        if (hVar != null) {
            if (hVar.d(0)) {
                h(63);
            }
            this.f826b.f(0);
        }
        return z2;
    }

    public final void g() {
        this.f825a = 0L;
        h hVar = this.f826b;
        if (hVar != null) {
            hVar.g();
        }
    }

    public final void h(int i2) {
        if (i2 < 64) {
            this.f825a |= 1 << i2;
        } else {
            c();
            this.f826b.h(i2 - 64);
        }
    }

    public final String toString() {
        if (this.f826b == null) {
            return Long.toBinaryString(this.f825a);
        }
        return this.f826b.toString() + "xx" + Long.toBinaryString(this.f825a);
    }
}
