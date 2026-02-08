package w0;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class a implements ListIterator {

    /* renamed from: a, reason: collision with root package name */
    public final b f2617a;

    /* renamed from: b, reason: collision with root package name */
    public int f2618b;

    /* renamed from: c, reason: collision with root package name */
    public int f2619c;

    public a(b bVar, int i2) {
        x0.g.u(bVar, "list");
        this.f2617a = bVar;
        this.f2618b = i2;
        this.f2619c = -1;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        int i2 = this.f2618b;
        this.f2618b = i2 + 1;
        this.f2617a.add(i2, obj);
        this.f2619c = -1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f2618b < this.f2617a.f2622c;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f2618b > 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        int i2 = this.f2618b;
        b bVar = this.f2617a;
        if (i2 >= bVar.f2622c) {
            throw new NoSuchElementException();
        }
        this.f2618b = i2 + 1;
        this.f2619c = i2;
        return bVar.f2620a[bVar.f2621b + i2];
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f2618b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        int i2 = this.f2618b;
        if (i2 <= 0) {
            throw new NoSuchElementException();
        }
        int i3 = i2 - 1;
        this.f2618b = i3;
        this.f2619c = i3;
        b bVar = this.f2617a;
        return bVar.f2620a[bVar.f2621b + i3];
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f2618b - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        int i2 = this.f2619c;
        if (i2 == -1) {
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        }
        this.f2617a.remove(i2);
        this.f2618b = this.f2619c;
        this.f2619c = -1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        int i2 = this.f2619c;
        if (i2 == -1) {
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        }
        this.f2617a.set(i2, obj);
    }
}
