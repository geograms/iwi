package x0;

import c1.p;

/* loaded from: classes.dex */
public final class c extends kotlin.jvm.internal.j implements p {

    /* renamed from: b, reason: collision with root package name */
    public static final c f2654b = new c(0);

    /* renamed from: c, reason: collision with root package name */
    public static final c f2655c = new c(1);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2656a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(int i2) {
        super(2);
        this.f2656a = i2;
    }

    @Override // c1.p
    public final Object a(Object obj, Object obj2) {
        d dVar;
        switch (this.f2656a) {
            case 0:
                String str = (String) obj;
                h hVar = (h) obj2;
                g.u(str, "acc");
                g.u(hVar, "element");
                if (str.length() == 0) {
                    return hVar.toString();
                }
                return str + ", " + hVar;
            default:
                j jVar = (j) obj;
                h hVar2 = (h) obj2;
                g.u(jVar, "acc");
                g.u(hVar2, "element");
                j jVarMinusKey = jVar.minusKey(hVar2.getKey());
                k kVar = k.f2662a;
                if (jVarMinusKey == kVar) {
                    return hVar2;
                }
                e eVar = e.f2659a;
                f fVar = (f) jVarMinusKey.get(eVar);
                if (fVar == null) {
                    dVar = new d(hVar2, jVarMinusKey);
                } else {
                    j jVarMinusKey2 = jVarMinusKey.minusKey(eVar);
                    if (jVarMinusKey2 == kVar) {
                        return new d(fVar, hVar2);
                    }
                    dVar = new d(fVar, new d(hVar2, jVarMinusKey2));
                }
                return dVar;
        }
    }
}
