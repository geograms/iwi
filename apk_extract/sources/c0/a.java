package c0;

/* loaded from: classes.dex */
public final class a implements j {

    /* renamed from: a, reason: collision with root package name */
    public final String f1223a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f1224b;

    public a(String str, Object[] objArr) {
        x0.g.u(str, "query");
        this.f1223a = str;
        this.f1224b = objArr;
    }

    @Override // c0.j
    public final void bindTo(i iVar) {
        c.c.a(iVar, this.f1224b);
    }

    @Override // c0.j
    public final int getArgCount() {
        Object[] objArr = this.f1224b;
        if (objArr != null) {
            return objArr.length;
        }
        return 0;
    }

    @Override // c0.j
    public final String getSql() {
        return this.f1223a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(String str) {
        this(str, null);
        x0.g.u(str, "query");
    }
}
