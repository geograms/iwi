package g;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class h implements Set {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1796a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f1797b;

    public /* synthetic */ h(k kVar, int i2) {
        this.f1796a = i2;
        this.f1797b = kVar;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        switch (this.f1796a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        switch (this.f1796a) {
            case 0:
                k kVar = this.f1797b;
                int iB = kVar.b();
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    a aVar = (a) kVar;
                    int i2 = aVar.f1770d;
                    Object obj = aVar.f1771e;
                    switch (i2) {
                        case 0:
                            ((b) obj).put(key, value);
                            break;
                        default:
                            ((c) obj).add(key);
                            break;
                    }
                }
                return iB != kVar.b();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        int i2 = this.f1796a;
        k kVar = this.f1797b;
        switch (i2) {
            case 0:
                a aVar = (a) kVar;
                int i3 = aVar.f1770d;
                Object obj = aVar.f1771e;
                switch (i3) {
                    case 0:
                        ((b) obj).clear();
                        break;
                    default:
                        ((c) obj).clear();
                        break;
                }
            default:
                a aVar2 = (a) kVar;
                int i4 = aVar2.f1770d;
                Object obj2 = aVar2.f1771e;
                switch (i4) {
                    case 0:
                        ((b) obj2).clear();
                        break;
                    default:
                        ((c) obj2).clear();
                        break;
                }
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        int iE;
        int iE2;
        int i2 = this.f1796a;
        k kVar = this.f1797b;
        switch (i2) {
            case 0:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    a aVar = (a) kVar;
                    int i3 = aVar.f1770d;
                    Object obj2 = aVar.f1771e;
                    switch (i3) {
                        case 0:
                            iE = ((b) obj2).e(key);
                            break;
                        default:
                            iE = ((c) obj2).indexOf(key);
                            break;
                    }
                    if (iE >= 0) {
                        Object objA = kVar.a(iE, 1);
                        Object value = entry.getValue();
                        if (objA == value || (objA != null && objA.equals(value))) {
                            break;
                        }
                    }
                }
                break;
            default:
                a aVar2 = (a) kVar;
                int i4 = aVar2.f1770d;
                Object obj3 = aVar2.f1771e;
                switch (i4) {
                    case 0:
                        iE2 = ((b) obj3).e(obj);
                        break;
                    default:
                        iE2 = ((c) obj3).indexOf(obj);
                        break;
                }
                if (iE2 >= 0) {
                    break;
                }
                break;
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        switch (this.f1796a) {
            case 0:
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    if (!contains(it.next())) {
                        return false;
                    }
                }
                return true;
            default:
                a aVar = (a) this.f1797b;
                switch (aVar.f1770d) {
                    case 0:
                        b bVar = (b) aVar.f1771e;
                        Iterator it2 = collection.iterator();
                        while (it2.hasNext()) {
                            if (!bVar.containsKey(it2.next())) {
                                return false;
                            }
                        }
                        return true;
                    default:
                        throw new UnsupportedOperationException("not a map");
                }
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        switch (this.f1796a) {
        }
        return k.d(this, obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        int i2 = this.f1796a;
        k kVar = this.f1797b;
        switch (i2) {
            case 0:
                int iHashCode = 0;
                for (int iB = kVar.b() - 1; iB >= 0; iB--) {
                    Object objA = kVar.a(iB, 0);
                    Object objA2 = kVar.a(iB, 1);
                    iHashCode += (objA == null ? 0 : objA.hashCode()) ^ (objA2 == null ? 0 : objA2.hashCode());
                }
                return iHashCode;
            default:
                int iHashCode2 = 0;
                for (int iB2 = kVar.b() - 1; iB2 >= 0; iB2--) {
                    Object objA3 = kVar.a(iB2, 0);
                    iHashCode2 += objA3 == null ? 0 : objA3.hashCode();
                }
                return iHashCode2;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        int i2 = this.f1796a;
        k kVar = this.f1797b;
        switch (i2) {
            case 0:
                if (kVar.b() == 0) {
                    break;
                }
                break;
            default:
                if (kVar.b() == 0) {
                    break;
                }
                break;
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        int i2 = this.f1796a;
        k kVar = this.f1797b;
        switch (i2) {
            case 0:
                return new i(kVar);
            default:
                return new g(kVar, 0);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        int iE;
        switch (this.f1796a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                k kVar = this.f1797b;
                a aVar = (a) kVar;
                int i2 = aVar.f1770d;
                Object obj2 = aVar.f1771e;
                switch (i2) {
                    case 0:
                        iE = ((b) obj2).e(obj);
                        break;
                    default:
                        iE = ((c) obj2).indexOf(obj);
                        break;
                }
                if (iE < 0) {
                    return false;
                }
                kVar.c(iE);
                return true;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection collection) {
        switch (this.f1796a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                a aVar = (a) this.f1797b;
                switch (aVar.f1770d) {
                    case 0:
                        b bVar = (b) aVar.f1771e;
                        int i2 = bVar.f1812c;
                        Iterator it = collection.iterator();
                        while (it.hasNext()) {
                            bVar.remove(it.next());
                        }
                        return i2 != bVar.f1812c;
                    default:
                        throw new UnsupportedOperationException("not a map");
                }
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        switch (this.f1796a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                a aVar = (a) this.f1797b;
                switch (aVar.f1770d) {
                    case 0:
                        return k.e((b) aVar.f1771e, collection);
                    default:
                        throw new UnsupportedOperationException("not a map");
                }
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        int i2 = this.f1796a;
        k kVar = this.f1797b;
        switch (i2) {
        }
        return kVar.b();
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        switch (this.f1796a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                return this.f1797b.f(objArr, 0);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        switch (this.f1796a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                k kVar = this.f1797b;
                int iB = kVar.b();
                Object[] objArr = new Object[iB];
                for (int i2 = 0; i2 < iB; i2++) {
                    objArr[i2] = kVar.a(i2, 0);
                }
                return objArr;
        }
    }
}
