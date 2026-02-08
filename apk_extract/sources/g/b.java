package g;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class b extends l implements Map {

    /* renamed from: h, reason: collision with root package name */
    public a f1772h;

    public b(b bVar) {
        if (bVar != null) {
            int i2 = bVar.f1812c;
            b(i2);
            if (this.f1812c != 0) {
                for (int i3 = 0; i3 < i2; i3++) {
                    put(bVar.h(i3), bVar.j(i3));
                }
            } else if (i2 > 0) {
                System.arraycopy(bVar.f1810a, 0, this.f1810a, 0, i2);
                System.arraycopy(bVar.f1811b, 0, this.f1811b, 0, i2 << 1);
                this.f1812c = i2;
            }
        }
    }

    @Override // java.util.Map
    public final Set entrySet() {
        int i2 = 0;
        if (this.f1772h == null) {
            this.f1772h = new a(0, this);
        }
        a aVar = this.f1772h;
        if (aVar.f1803a == null) {
            aVar.f1803a = new h(aVar, i2);
        }
        return aVar.f1803a;
    }

    @Override // java.util.Map
    public final Set keySet() {
        if (this.f1772h == null) {
            this.f1772h = new a(0, this);
        }
        a aVar = this.f1772h;
        if (aVar.f1804b == null) {
            aVar.f1804b = new h(aVar, 1);
        }
        return aVar.f1804b;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        b(map.size() + this.f1812c);
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        if (this.f1772h == null) {
            this.f1772h = new a(0, this);
        }
        a aVar = this.f1772h;
        if (aVar.f1805c == null) {
            aVar.f1805c = new j(aVar);
        }
        return aVar.f1805c;
    }
}
