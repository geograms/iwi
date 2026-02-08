package o;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class g implements q.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2226a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2227b;

    public /* synthetic */ g(int i2, Object obj) {
        this.f2226a = i2;
        this.f2227b = obj;
    }

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        switch (this.f2226a) {
            case 0:
                b((h) obj);
                break;
            default:
                b((h) obj);
                break;
        }
    }

    public final void b(h hVar) {
        switch (this.f2226a) {
            case 0:
                if (hVar == null) {
                    hVar = new h(-3);
                }
                ((androidx.fragment.app.d) this.f2227b).u(hVar);
                return;
            default:
                synchronized (i.f2232c) {
                    try {
                        g.l lVar = i.f2233d;
                        ArrayList arrayList = (ArrayList) lVar.getOrDefault((String) this.f2227b, null);
                        if (arrayList == null) {
                            return;
                        }
                        lVar.remove((String) this.f2227b);
                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                            ((g) ((q.a) arrayList.get(i2))).a(hVar);
                        }
                        return;
                    } finally {
                    }
                }
        }
    }
}
