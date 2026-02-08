package e;

import java.util.Map;

/* loaded from: classes.dex */
public final class c implements Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1740a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1741b;

    /* renamed from: c, reason: collision with root package name */
    public c f1742c;

    /* renamed from: d, reason: collision with root package name */
    public c f1743d;

    public c(Object obj, Object obj2) {
        this.f1740a = obj;
        this.f1741b = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f1740a.equals(cVar.f1740a) && this.f1741b.equals(cVar.f1741b);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f1740a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f1741b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f1741b.hashCode() ^ this.f1740a.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public final String toString() {
        return this.f1740a + "=" + this.f1741b;
    }
}
