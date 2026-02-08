package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class a implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f2035a;

    /* renamed from: b, reason: collision with root package name */
    public int f2036b;

    public a(Object[] objArr) {
        x0.g.u(objArr, "array");
        this.f2035a = objArr;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2036b < this.f2035a.length;
    }

    @Override // java.util.Iterator
    public final Object next() {
        try {
            Object[] objArr = this.f2035a;
            int i2 = this.f2036b;
            this.f2036b = i2 + 1;
            return objArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f2036b--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
