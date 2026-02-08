package u0;

import java.io.Serializable;
import x0.g;

/* loaded from: classes.dex */
public final class b implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2588a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2589b;

    public b(Object obj, Object obj2) {
        this.f2588a = obj;
        this.f2589b = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return g.g(this.f2588a, bVar.f2588a) && g.g(this.f2589b, bVar.f2589b);
    }

    public final int hashCode() {
        Object obj = this.f2588a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f2589b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f2588a + ", " + this.f2589b + ')';
    }
}
