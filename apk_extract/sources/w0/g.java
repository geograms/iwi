package w0;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class g extends v0.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2644a;

    /* renamed from: b, reason: collision with root package name */
    public final f f2645b;

    public g(f fVar, int i2) {
        this.f2644a = i2;
        if (i2 != 1) {
            x0.g.u(fVar, "backing");
            this.f2645b = fVar;
        } else {
            x0.g.u(fVar, "backing");
            this.f2645b = fVar;
        }
    }

    @Override // v0.d
    public final int a() {
        int i2 = this.f2644a;
        f fVar = this.f2645b;
        switch (i2) {
        }
        return fVar.f2639h;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        switch (this.f2644a) {
            case 0:
                x0.g.u((Map.Entry) obj, "element");
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        switch (this.f2644a) {
            case 0:
                x0.g.u(collection, "elements");
                throw new UnsupportedOperationException();
            default:
                x0.g.u(collection, "elements");
                throw new UnsupportedOperationException();
        }
    }

    public final boolean b(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        x0.g.u(entry, "element");
        return this.f2645b.d(entry);
    }

    public final boolean c(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        x0.g.u(entry, "element");
        f fVar = this.f2645b;
        fVar.getClass();
        fVar.b();
        int iF = fVar.f(entry.getKey());
        if (iF < 0) {
            return false;
        }
        Object[] objArr = fVar.f2633b;
        x0.g.q(objArr);
        if (!x0.g.g(objArr[iF], entry.getValue())) {
            return false;
        }
        fVar.j(iF);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        int i2 = this.f2644a;
        f fVar = this.f2645b;
        switch (i2) {
            case 0:
                fVar.clear();
                break;
            default:
                fVar.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f2644a) {
            case 0:
                return b(obj);
            default:
                return this.f2645b.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        switch (this.f2644a) {
            case 0:
                x0.g.u(collection, "elements");
                return this.f2645b.c(collection);
            default:
                return super.containsAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        int i2 = this.f2644a;
        f fVar = this.f2645b;
        switch (i2) {
        }
        return fVar.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        int i2 = this.f2644a;
        f fVar = this.f2645b;
        switch (i2) {
            case 0:
                fVar.getClass();
                return new c(fVar, 0);
            default:
                fVar.getClass();
                return new c(fVar, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.f2644a) {
            case 0:
                return c(obj);
            default:
                f fVar = this.f2645b;
                fVar.b();
                int iF = fVar.f(obj);
                if (iF >= 0) {
                    fVar.j(iF);
                    if (iF >= 0) {
                        return true;
                    }
                }
                return false;
        }
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        int i2 = this.f2644a;
        f fVar = this.f2645b;
        switch (i2) {
            case 0:
                x0.g.u(collection, "elements");
                fVar.b();
                break;
            default:
                x0.g.u(collection, "elements");
                fVar.b();
                break;
        }
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        int i2 = this.f2644a;
        f fVar = this.f2645b;
        switch (i2) {
            case 0:
                x0.g.u(collection, "elements");
                fVar.b();
                break;
            default:
                x0.g.u(collection, "elements");
                fVar.b();
                break;
        }
        return super.retainAll(collection);
    }
}
