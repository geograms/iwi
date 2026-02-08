package g;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class j implements Collection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f1802a;

    public j(k kVar) {
        this.f1802a = kVar;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final void clear() {
        a aVar = (a) this.f1802a;
        int i2 = aVar.f1770d;
        Object obj = aVar.f1771e;
        switch (i2) {
            case 0:
                ((b) obj).clear();
                break;
            default:
                ((c) obj).clear();
                break;
        }
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        int iG;
        a aVar = (a) this.f1802a;
        int i2 = aVar.f1770d;
        Object obj2 = aVar.f1771e;
        switch (i2) {
            case 0:
                iG = ((b) obj2).g(obj);
                break;
            default:
                iG = ((c) obj2).indexOf(obj);
                break;
        }
        return iG >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f1802a.b() == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new g(this.f1802a, 1);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        int iG;
        k kVar = this.f1802a;
        a aVar = (a) kVar;
        int i2 = aVar.f1770d;
        Object obj2 = aVar.f1771e;
        switch (i2) {
            case 0:
                iG = ((b) obj2).g(obj);
                break;
            default:
                iG = ((c) obj2).indexOf(obj);
                break;
        }
        if (iG < 0) {
            return false;
        }
        kVar.c(iG);
        return true;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        k kVar = this.f1802a;
        int iB = kVar.b();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < iB) {
            if (collection.contains(kVar.a(i2, 1))) {
                kVar.c(i2);
                i2--;
                iB--;
                z2 = true;
            }
            i2++;
        }
        return z2;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        k kVar = this.f1802a;
        int iB = kVar.b();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < iB) {
            if (!collection.contains(kVar.a(i2, 1))) {
                kVar.c(i2);
                i2--;
                iB--;
                z2 = true;
            }
            i2++;
        }
        return z2;
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f1802a.b();
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return this.f1802a.f(objArr, 1);
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        k kVar = this.f1802a;
        int iB = kVar.b();
        Object[] objArr = new Object[iB];
        for (int i2 = 0; i2 < iB; i2++) {
            objArr[i2] = kVar.a(i2, 1);
        }
        return objArr;
    }
}
