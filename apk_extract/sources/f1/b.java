package f1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class b implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final int f1766a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1767b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1768c;

    /* renamed from: d, reason: collision with root package name */
    public int f1769d;

    public b(int i2, int i3, int i4) {
        this.f1766a = i4;
        this.f1767b = i3;
        boolean z2 = true;
        if (i4 <= 0 ? i2 < i3 : i2 > i3) {
            z2 = false;
        }
        this.f1768c = z2;
        this.f1769d = z2 ? i2 : i3;
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final /* bridge */ /* synthetic */ Object next() {
        return Integer.valueOf(b());
    }

    public final int b() {
        int i2 = this.f1769d;
        if (i2 != this.f1767b) {
            this.f1769d = this.f1766a + i2;
        } else {
            if (!this.f1768c) {
                throw new NoSuchElementException();
            }
            this.f1768c = false;
        }
        return i2;
    }

    public final void c() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1768c;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void remove() {
        c();
        throw null;
    }
}
