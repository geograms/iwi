package f1;

/* loaded from: classes.dex */
public final class c extends a {
    static {
        new c(1, 0, 1);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (this.f1763a == cVar.f1763a) {
                    if (this.f1764b == cVar.f1764b) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return this.f1764b + (this.f1763a * 31);
    }

    public final boolean isEmpty() {
        return this.f1763a > this.f1764b;
    }

    public final String toString() {
        return this.f1763a + ".." + this.f1764b;
    }
}
