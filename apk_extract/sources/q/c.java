package q;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2476a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2477b;

    public c(Object obj, Object obj2) {
        this.f2476a = obj;
        this.f2477b = obj2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return b.a(cVar.f2476a, this.f2476a) && b.a(cVar.f2477b, this.f2477b);
    }

    public final int hashCode() {
        Object obj = this.f2476a;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f2477b;
        return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "Pair{" + this.f2476a + " " + this.f2477b + "}";
    }
}
