package j1;

/* loaded from: classes.dex */
public abstract class c extends x0.a implements x0.f {

    /* renamed from: a, reason: collision with root package name */
    public static final b f1908a = new b(0);

    public c() {
        super(x0.e.f2659a);
    }

    public abstract void a(x0.j jVar, Runnable runnable);

    public boolean b() {
        return !(this instanceof r);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    @Override // x0.a, x0.j
    public final x0.h get(x0.i iVar) {
        ?? r3;
        x0.g.u(iVar, "key");
        if (iVar instanceof x0.b) {
            x0.b bVar = (x0.b) iVar;
            x0.i key = getKey();
            x0.g.u(key, "key");
            if (key != bVar && bVar.f2653b != key) {
                return null;
            }
            x0.h hVar = (x0.h) bVar.f2652a.invoke(this);
            boolean z2 = hVar instanceof x0.h;
            r3 = hVar;
            if (!z2) {
                return null;
            }
        } else {
            this = this;
            if (x0.e.f2659a != iVar) {
                r3 = 0;
            }
        }
        return r3;
    }

    @Override // x0.a, x0.j
    public final x0.j minusKey(x0.i iVar) {
        x0.g.u(iVar, "key");
        boolean z2 = iVar instanceof x0.b;
        x0.k kVar = x0.k.f2662a;
        if (z2) {
            x0.b bVar = (x0.b) iVar;
            x0.i key = getKey();
            x0.g.u(key, "key");
            if ((key != bVar && bVar.f2653b != key) || ((x0.h) bVar.f2652a.invoke(this)) == null) {
                return this;
            }
        } else if (x0.e.f2659a != iVar) {
            return this;
        }
        return kVar;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
    }
}
