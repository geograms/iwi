package kotlin.jvm.internal;

/* loaded from: classes.dex */
public abstract class n extends p implements g1.k {
    @Override // kotlin.jvm.internal.c
    public g1.b computeReflected() {
        r.f2043a.getClass();
        return this;
    }

    @Override // g1.k
    public Object getDelegate(Object obj) {
        return ((g1.k) getReflected()).getDelegate(obj);
    }

    public /* bridge */ /* synthetic */ g1.i getGetter() {
        mo3getGetter();
        return null;
    }

    @Override // c1.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    @Override // g1.k
    /* renamed from: getGetter */
    public g1.j mo3getGetter() {
        ((g1.k) getReflected()).mo3getGetter();
        return null;
    }
}
