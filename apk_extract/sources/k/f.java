package k;

import android.graphics.Insets;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: e, reason: collision with root package name */
    public static final f f1925e = new f(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f1926a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1927b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1928c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1929d;

    public f(int i2, int i3, int i4, int i5) {
        this.f1926a = i2;
        this.f1927b = i3;
        this.f1928c = i4;
        this.f1929d = i5;
    }

    public static f a(f fVar, f fVar2) {
        return b(Math.max(fVar.f1926a, fVar2.f1926a), Math.max(fVar.f1927b, fVar2.f1927b), Math.max(fVar.f1928c, fVar2.f1928c), Math.max(fVar.f1929d, fVar2.f1929d));
    }

    public static f b(int i2, int i3, int i4, int i5) {
        return (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) ? f1925e : new f(i2, i3, i4, i5);
    }

    public static f c(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public final Insets d() {
        return e.a(this.f1926a, this.f1927b, this.f1928c, this.f1929d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return this.f1929d == fVar.f1929d && this.f1926a == fVar.f1926a && this.f1928c == fVar.f1928c && this.f1927b == fVar.f1927b;
    }

    public final int hashCode() {
        return (((((this.f1926a * 31) + this.f1927b) * 31) + this.f1928c) * 31) + this.f1929d;
    }

    public final String toString() {
        return "Insets{left=" + this.f1926a + ", top=" + this.f1927b + ", right=" + this.f1928c + ", bottom=" + this.f1929d + '}';
    }
}
