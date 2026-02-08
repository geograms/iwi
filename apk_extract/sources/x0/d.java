package x0;

import c1.p;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class d implements j, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final j f2657a;

    /* renamed from: b, reason: collision with root package name */
    public final h f2658b;

    public d(h hVar, j jVar) {
        g.u(jVar, "left");
        g.u(hVar, "element");
        this.f2657a = jVar;
        this.f2658b = hVar;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof d) {
                d dVar = (d) obj;
                dVar.getClass();
                int i2 = 2;
                d dVar2 = dVar;
                int i3 = 2;
                while (true) {
                    j jVar = dVar2.f2657a;
                    dVar2 = jVar instanceof d ? (d) jVar : null;
                    if (dVar2 == null) {
                        break;
                    }
                    i3++;
                }
                d dVar3 = this;
                while (true) {
                    j jVar2 = dVar3.f2657a;
                    dVar3 = jVar2 instanceof d ? (d) jVar2 : null;
                    if (dVar3 == null) {
                        break;
                    }
                    i2++;
                }
                if (i3 == i2) {
                    while (true) {
                        h hVar = this.f2658b;
                        if (!g.g(dVar.get(hVar.getKey()), hVar)) {
                            break;
                        }
                        j jVar3 = this.f2657a;
                        if (jVar3 instanceof d) {
                            this = (d) jVar3;
                        } else {
                            g.r(jVar3, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                            h hVar2 = (h) jVar3;
                            if (g.g(dVar.get(hVar2.getKey()), hVar2)) {
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // x0.j
    public final Object fold(Object obj, p pVar) {
        return ((c) pVar).a(this.f2657a.fold(obj, pVar), this.f2658b);
    }

    @Override // x0.j
    public final h get(i iVar) {
        g.u(iVar, "key");
        while (true) {
            h hVar = this.f2658b.get(iVar);
            if (hVar != null) {
                return hVar;
            }
            j jVar = this.f2657a;
            if (!(jVar instanceof d)) {
                return jVar.get(iVar);
            }
            this = (d) jVar;
        }
    }

    public final int hashCode() {
        return this.f2658b.hashCode() + this.f2657a.hashCode();
    }

    @Override // x0.j
    public final j minusKey(i iVar) {
        g.u(iVar, "key");
        h hVar = this.f2658b;
        h hVar2 = hVar.get(iVar);
        j jVar = this.f2657a;
        if (hVar2 != null) {
            return jVar;
        }
        j jVarMinusKey = jVar.minusKey(iVar);
        return jVarMinusKey == jVar ? this : jVarMinusKey == k.f2662a ? hVar : new d(hVar, jVarMinusKey);
    }

    public final String toString() {
        return "[" + ((String) fold("", c.f2654b)) + ']';
    }
}
