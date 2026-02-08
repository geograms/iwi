package u0;

import java.io.Serializable;
import x0.g;

/* loaded from: classes.dex */
public final class c implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f2590a;

    public c(Throwable th) {
        this.f2590a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            if (g.g(this.f2590a, ((c) obj).f2590a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f2590a.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.f2590a + ')';
    }
}
