package e;

import java.util.HashMap;

/* loaded from: classes.dex */
public final class a extends g {

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f1738e = new HashMap();

    @Override // e.g
    public final c a(Object obj) {
        return (c) this.f1738e.get(obj);
    }

    @Override // e.g
    public final Object b(Object obj, Object obj2) {
        c cVarA = a(obj);
        if (cVarA != null) {
            return cVarA.f1741b;
        }
        HashMap map = this.f1738e;
        c cVar = new c(obj, obj2);
        this.f1752d++;
        c cVar2 = this.f1750b;
        if (cVar2 == null) {
            this.f1749a = cVar;
            this.f1750b = cVar;
        } else {
            cVar2.f1742c = cVar;
            cVar.f1743d = cVar2;
            this.f1750b = cVar;
        }
        map.put(obj, cVar);
        return null;
    }

    @Override // e.g
    public final Object c(Object obj) {
        Object objC = super.c(obj);
        this.f1738e.remove(obj);
        return objC;
    }
}
