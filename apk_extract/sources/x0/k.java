package x0;

import c1.p;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class k implements j, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final k f2662a = new k();

    @Override // x0.j
    public final Object fold(Object obj, p pVar) {
        return obj;
    }

    @Override // x0.j
    public final h get(i iVar) {
        g.u(iVar, "key");
        return null;
    }

    public final int hashCode() {
        return 0;
    }

    @Override // x0.j
    public final j minusKey(i iVar) {
        g.u(iVar, "key");
        return this;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }
}
