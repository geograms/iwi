package k0;

/* loaded from: classes.dex */
public final class m extends x0.g {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1992c;

    public /* synthetic */ m(int i2) {
        this.f1992c = i2;
    }

    @Override // x0.g
    public final boolean f(Object obj, Object obj2) {
        switch (this.f1992c) {
            case 0:
                a aVar = (a) obj;
                a aVar2 = (a) obj2;
                if (aVar.f1938b == aVar2.f1938b) {
                    String str = aVar.f1940d;
                    String str2 = aVar2.f1940d;
                    if (((str == null && str2 == null) || (str != null && str2 != null && str.equals(str2))) && aVar.f1941e == aVar2.f1941e && aVar.f1942f == aVar2.f1942f && aVar.f1943g == aVar2.f1943g && aVar.f1944h == aVar2.f1944h && aVar.f1945i == aVar2.f1945i && aVar.f1946j == aVar2.f1946j && aVar.f1947k == aVar2.f1947k && aVar.f1948l == aVar2.f1948l && aVar.f1949m == aVar2.f1949m && aVar.f1950n == aVar2.f1950n) {
                        String str3 = aVar.f1951o;
                        String str4 = aVar2.f1951o;
                        if (((str3 == null && str4 == null) || (str3 != null && str4 != null && str3.equals(str4))) && aVar.f1952p == aVar2.f1952p && aVar.f1953q == aVar2.f1953q && aVar.f1954r == aVar2.f1954r && aVar.f1955s == aVar2.f1955s && aVar.f1956t == aVar2.f1956t && aVar.f1957u == aVar2.f1957u && aVar.f1958v == aVar2.f1958v) {
                            String str5 = aVar.f1959w;
                            String str6 = aVar2.f1959w;
                            if (((str5 == null && str6 == null) || (str5 != null && str6 != null && str5.equals(str6))) && aVar.f1960x == aVar2.f1960x && aVar.f1961y == aVar2.f1961y && aVar.f1962z == aVar2.f1962z && aVar.A == aVar2.A && aVar.B == aVar2.B && aVar.C == aVar2.C && aVar.D == aVar2.D && aVar.E == aVar2.E) {
                                break;
                            }
                        }
                    }
                }
                break;
            case 1:
                u uVar = (u) obj;
                u uVar2 = (u) obj2;
                boolean zEquals = uVar.f2017b.equals(uVar2.f2017b);
                boolean z2 = uVar.f2018c == uVar2.f2018c;
                if (zEquals && z2) {
                    break;
                }
                break;
            case 2:
                n0.a aVar3 = (n0.a) obj;
                n0.a aVar4 = (n0.a) obj2;
                if (aVar3.f2141d.equals(aVar4.f2141d) && aVar3.f2142e == aVar4.f2142e) {
                    break;
                }
                break;
            default:
                n0.e eVar = (n0.e) obj;
                n0.e eVar2 = (n0.e) obj2;
                if (eVar.f2164h.equals(eVar2.f2164h) && eVar.f2165i == eVar2.f2165i && eVar.f2167k == eVar2.f2167k) {
                    break;
                }
                break;
        }
        return true;
    }

    @Override // x0.g
    public final boolean h(Object obj, Object obj2) {
        switch (this.f1992c) {
            case 0:
                if (((a) obj).f1937a == ((a) obj2).f1937a) {
                    break;
                }
                break;
            case 1:
                if (((u) obj).f2016a == ((u) obj2).f2016a) {
                    break;
                }
                break;
            case 2:
                n0.a aVar = (n0.a) obj;
                n0.a aVar2 = (n0.a) obj2;
                if (aVar.f2138a == aVar2.f2138a && aVar.f2139b == aVar2.f2139b) {
                    break;
                }
                break;
            default:
                if (((n0.e) obj).f2157a == ((n0.e) obj2).f2157a) {
                    break;
                }
                break;
        }
        return true;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m() {
        this(2);
        this.f1992c = 2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(Object obj) {
        this(3);
        this.f1992c = 3;
    }
}
