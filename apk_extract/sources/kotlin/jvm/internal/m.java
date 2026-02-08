package kotlin.jvm.internal;

/* loaded from: classes.dex */
public final class m implements d {

    /* renamed from: a, reason: collision with root package name */
    public final Class f2041a;

    public m(Class cls) {
        x0.g.u(cls, "jClass");
        this.f2041a = cls;
    }

    @Override // kotlin.jvm.internal.d
    public final Class a() {
        return this.f2041a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof m) {
            if (x0.g.g(this.f2041a, ((m) obj).f2041a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f2041a.hashCode();
    }

    public final String toString() {
        return this.f2041a.toString() + " (Kotlin reflection is not available)";
    }
}
