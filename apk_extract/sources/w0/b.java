package w0;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class b extends v0.c implements RandomAccess, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f2620a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2621b;

    /* renamed from: c, reason: collision with root package name */
    public int f2622c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2623d;

    /* renamed from: e, reason: collision with root package name */
    public final b f2624e;

    /* renamed from: f, reason: collision with root package name */
    public final b f2625f;

    public b(Object[] objArr, int i2, int i3, boolean z2, b bVar, b bVar2) {
        this.f2620a = objArr;
        this.f2621b = i2;
        this.f2622c = i3;
        this.f2623d = z2;
        this.f2624e = bVar;
        this.f2625f = bVar2;
    }

    public final void a(int i2, Collection collection, int i3) {
        b bVar = this.f2624e;
        if (bVar != null) {
            bVar.a(i2, collection, i3);
            this.f2620a = bVar.f2620a;
            this.f2622c += i3;
        } else {
            d(i2, i3);
            Iterator it = collection.iterator();
            for (int i4 = 0; i4 < i3; i4++) {
                this.f2620a[i2 + i4] = it.next();
            }
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        c();
        b(this.f2621b + this.f2622c, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        x0.g.u(collection, "elements");
        c();
        int size = collection.size();
        a(this.f2621b + this.f2622c, collection, size);
        return size > 0;
    }

    public final void b(int i2, Object obj) {
        b bVar = this.f2624e;
        if (bVar == null) {
            d(i2, 1);
            this.f2620a[i2] = obj;
        } else {
            bVar.b(i2, obj);
            this.f2620a = bVar.f2620a;
            this.f2622c++;
        }
    }

    public final void c() {
        b bVar;
        if (this.f2623d || ((bVar = this.f2625f) != null && bVar.f2623d)) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        c();
        f(this.f2621b, this.f2622c);
    }

    public final void d(int i2, int i3) {
        int i4 = this.f2622c + i3;
        if (this.f2624e != null) {
            throw new IllegalStateException();
        }
        if (i4 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.f2620a;
        if (i4 > objArr.length) {
            int length = objArr.length;
            int i5 = length + (length >> 1);
            if (i5 - i4 < 0) {
                i5 = i4;
            }
            if (i5 - 2147483639 > 0) {
                i5 = i4 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            Object[] objArrCopyOf = Arrays.copyOf(objArr, i5);
            x0.g.t(objArrCopyOf, "copyOf(this, newSize)");
            this.f2620a = objArrCopyOf;
        }
        Object[] objArr2 = this.f2620a;
        v0.f.F0(objArr2, objArr2, i2 + i3, i2, this.f2621b + this.f2622c);
        this.f2622c += i3;
    }

    public final Object e(int i2) {
        b bVar = this.f2624e;
        if (bVar != null) {
            this.f2622c--;
            return bVar.e(i2);
        }
        Object[] objArr = this.f2620a;
        Object obj = objArr[i2];
        int i3 = this.f2622c;
        int i4 = this.f2621b;
        v0.f.F0(objArr, objArr, i2, i2 + 1, i3 + i4);
        Object[] objArr2 = this.f2620a;
        int i5 = (i4 + this.f2622c) - 1;
        x0.g.u(objArr2, "<this>");
        objArr2[i5] = null;
        this.f2622c--;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            Object[] objArr = this.f2620a;
            int i2 = this.f2622c;
            if (i2 != list.size()) {
                return false;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                if (!x0.g.g(objArr[this.f2621b + i3], list.get(i3))) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void f(int i2, int i3) {
        b bVar = this.f2624e;
        if (bVar != null) {
            bVar.f(i2, i3);
        } else {
            Object[] objArr = this.f2620a;
            v0.f.F0(objArr, objArr, i2, i2 + i3, this.f2622c);
            Object[] objArr2 = this.f2620a;
            int i4 = this.f2622c;
            x0.g.s0(i4 - i3, i4, objArr2);
        }
        this.f2622c -= i3;
    }

    public final int g(int i2, int i3, Collection collection, boolean z2) {
        b bVar = this.f2624e;
        if (bVar != null) {
            int iG = bVar.g(i2, i3, collection, z2);
            this.f2622c -= iG;
            return iG;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = i2 + i4;
            if (collection.contains(this.f2620a[i6]) == z2) {
                Object[] objArr = this.f2620a;
                i4++;
                objArr[i5 + i2] = objArr[i6];
                i5++;
            } else {
                i4++;
            }
        }
        int i7 = i3 - i5;
        Object[] objArr2 = this.f2620a;
        v0.f.F0(objArr2, objArr2, i2 + i5, i3 + i2, this.f2622c);
        Object[] objArr3 = this.f2620a;
        int i8 = this.f2622c;
        x0.g.s0(i8 - i7, i8, objArr3);
        this.f2622c -= i7;
        return i7;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        c.c.c(i2, this.f2622c);
        return this.f2620a[this.f2621b + i2];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        Object[] objArr = this.f2620a;
        int i2 = this.f2622c;
        int iHashCode = 1;
        for (int i3 = 0; i3 < i2; i3++) {
            Object obj = objArr[this.f2621b + i3];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        for (int i2 = 0; i2 < this.f2622c; i2++) {
            if (x0.g.g(this.f2620a[this.f2621b + i2], obj)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f2622c == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new a(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        for (int i2 = this.f2622c - 1; i2 >= 0; i2--) {
            if (x0.g.g(this.f2620a[this.f2621b + i2], obj)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return new a(this, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        c();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            remove(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        x0.g.u(collection, "elements");
        c();
        return g(this.f2621b, this.f2622c, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        x0.g.u(collection, "elements");
        c();
        return g(this.f2621b, this.f2622c, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        c();
        c.c.c(i2, this.f2622c);
        Object[] objArr = this.f2620a;
        int i3 = this.f2621b + i2;
        Object obj2 = objArr[i3];
        objArr[i3] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i2, int i3) {
        int i4 = this.f2622c;
        if (i2 < 0 || i3 > i4) {
            throw new IndexOutOfBoundsException("fromIndex: " + i2 + ", toIndex: " + i3 + ", size: " + i4);
        }
        if (i2 > i3) {
            throw new IllegalArgumentException("fromIndex: " + i2 + " > toIndex: " + i3);
        }
        Object[] objArr = this.f2620a;
        int i5 = this.f2621b + i2;
        int i6 = i3 - i2;
        boolean z2 = this.f2623d;
        b bVar = this.f2625f;
        return new b(objArr, i5, i6, z2, this, bVar == null ? this : bVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        Object[] objArr = this.f2620a;
        int i2 = this.f2622c;
        int i3 = this.f2621b;
        int i4 = i2 + i3;
        x0.g.u(objArr, "<this>");
        int length = objArr.length;
        if (i4 <= length) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, i3, i4);
            x0.g.t(objArrCopyOfRange, "copyOfRange(this, fromIndex, toIndex)");
            return objArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i4 + ") is greater than size (" + length + ").");
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        Object[] objArr = this.f2620a;
        int i2 = this.f2622c;
        StringBuilder sb = new StringBuilder((i2 * 3) + 2);
        sb.append("[");
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            sb.append(objArr[this.f2621b + i3]);
        }
        sb.append("]");
        String string = sb.toString();
        x0.g.t(string, "sb.toString()");
        return string;
    }

    public b() {
        this(new Object[10], 0, 0, false, null, null);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i2) {
        c.c.d(i2, this.f2622c);
        return new a(this, i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        c();
        c.c.d(i2, this.f2622c);
        b(this.f2621b + i2, obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection collection) {
        x0.g.u(collection, "elements");
        c();
        c.c.d(i2, this.f2622c);
        int size = collection.size();
        a(this.f2621b + i2, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        x0.g.u(objArr, "destination");
        int length = objArr.length;
        int i2 = this.f2622c;
        int i3 = this.f2621b;
        if (length < i2) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(this.f2620a, i3, i2 + i3, objArr.getClass());
            x0.g.t(objArrCopyOfRange, "copyOfRange(array, offse…h, destination.javaClass)");
            return objArrCopyOfRange;
        }
        v0.f.F0(this.f2620a, objArr, 0, i3, i2 + i3);
        int length2 = objArr.length;
        int i4 = this.f2622c;
        if (length2 > i4) {
            objArr[i4] = null;
        }
        return objArr;
    }
}
