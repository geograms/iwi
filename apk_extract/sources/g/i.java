package g;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class i implements Iterator, Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public int f1798a;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ k f1801d;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1800c = false;

    /* renamed from: b, reason: collision with root package name */
    public int f1799b = -1;

    public i(k kVar) {
        this.f1801d = kVar;
        this.f1798a = kVar.b() - 1;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!this.f1800c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        int i2 = this.f1799b;
        k kVar = this.f1801d;
        Object objA = kVar.a(i2, 0);
        if (key != objA && (key == null || !key.equals(objA))) {
            return false;
        }
        Object value = entry.getValue();
        Object objA2 = kVar.a(this.f1799b, 1);
        return value == objA2 || (value != null && value.equals(objA2));
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        if (!this.f1800c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        return this.f1801d.a(this.f1799b, 0);
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (!this.f1800c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        return this.f1801d.a(this.f1799b, 1);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1799b < this.f1798a;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        if (!this.f1800c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        int i2 = this.f1799b;
        k kVar = this.f1801d;
        Object objA = kVar.a(i2, 0);
        Object objA2 = kVar.a(this.f1799b, 1);
        return (objA == null ? 0 : objA.hashCode()) ^ (objA2 != null ? objA2.hashCode() : 0);
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f1799b++;
        this.f1800c = true;
        return this;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f1800c) {
            throw new IllegalStateException();
        }
        this.f1801d.c(this.f1799b);
        this.f1799b--;
        this.f1798a--;
        this.f1800c = false;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!this.f1800c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        int i2 = this.f1799b;
        a aVar = (a) this.f1801d;
        switch (aVar.f1770d) {
            case 0:
                int i3 = (i2 << 1) + 1;
                Object[] objArr = ((b) aVar.f1771e).f1811b;
                Object obj2 = objArr[i3];
                objArr[i3] = obj;
                return obj2;
            default:
                throw new UnsupportedOperationException("not a map");
        }
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
