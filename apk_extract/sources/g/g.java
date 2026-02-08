package g;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class g implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final int f1791a;

    /* renamed from: b, reason: collision with root package name */
    public int f1792b;

    /* renamed from: c, reason: collision with root package name */
    public int f1793c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1794d = false;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ k f1795e;

    public g(k kVar, int i2) {
        this.f1795e = kVar;
        this.f1791a = i2;
        this.f1792b = kVar.b();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1793c < this.f1792b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object objA = this.f1795e.a(this.f1793c, this.f1791a);
        this.f1793c++;
        this.f1794d = true;
        return objA;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f1794d) {
            throw new IllegalStateException();
        }
        int i2 = this.f1793c - 1;
        this.f1793c = i2;
        this.f1792b--;
        this.f1794d = false;
        this.f1795e.c(i2);
    }
}
