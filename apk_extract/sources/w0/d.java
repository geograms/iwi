package w0;

import java.util.Map;

/* loaded from: classes.dex */
public final class d implements Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public final f f2627a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2628b;

    public d(f fVar, int i2) {
        x0.g.u(fVar, "map");
        this.f2627a = fVar;
        this.f2628b = i2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (x0.g.g(entry.getKey(), getKey()) && x0.g.g(entry.getValue(), getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f2627a.f2632a[this.f2628b];
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        Object[] objArr = this.f2627a.f2633b;
        x0.g.q(objArr);
        return objArr[this.f2628b];
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object key = getKey();
        int iHashCode = key != null ? key.hashCode() : 0;
        Object value = getValue();
        return iHashCode ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        f fVar = this.f2627a;
        fVar.b();
        Object[] objArr = fVar.f2633b;
        if (objArr == null) {
            int length = fVar.f2632a.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.".toString());
            }
            objArr = new Object[length];
            fVar.f2633b = objArr;
        }
        int i2 = this.f2628b;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKey());
        sb.append('=');
        sb.append(getValue());
        return sb.toString();
    }
}
