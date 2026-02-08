package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f720a;

    /* renamed from: b, reason: collision with root package name */
    public int f721b;

    /* renamed from: c, reason: collision with root package name */
    public Object f722c;

    /* renamed from: d, reason: collision with root package name */
    public int f723d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        int i2 = this.f720a;
        if (i2 != aVar.f720a) {
            return false;
        }
        if (i2 == 8 && Math.abs(this.f723d - this.f721b) == 1 && this.f723d == aVar.f721b && this.f721b == aVar.f723d) {
            return true;
        }
        if (this.f723d != aVar.f723d || this.f721b != aVar.f721b) {
            return false;
        }
        Object obj2 = this.f722c;
        if (obj2 != null) {
            if (!obj2.equals(aVar.f722c)) {
                return false;
            }
        } else if (aVar.f722c != null) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (((this.f720a * 31) + this.f721b) * 31) + this.f723d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[");
        int i2 = this.f720a;
        sb.append(i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 8 ? "??" : "mv" : "up" : "rm" : "add");
        sb.append(",s:");
        sb.append(this.f721b);
        sb.append("c:");
        sb.append(this.f723d);
        sb.append(",p:");
        sb.append(this.f722c);
        sb.append("]");
        return sb.toString();
    }
}
