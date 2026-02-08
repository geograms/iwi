package x;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public int f2648a;

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f2649b;

    /* renamed from: c, reason: collision with root package name */
    public int f2650c;

    /* renamed from: d, reason: collision with root package name */
    public int f2651d;

    public c() {
        if (c.c.f1222a == null) {
            c.c.f1222a = new c.c();
        }
    }

    public final int a(int i2) {
        if (i2 < this.f2651d) {
            return this.f2649b.getShort(this.f2650c + i2);
        }
        return 0;
    }
}
