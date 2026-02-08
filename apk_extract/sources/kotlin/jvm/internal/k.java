package kotlin.jvm.internal;

/* loaded from: classes.dex */
public abstract class k extends p implements g1.h {
    @Override // kotlin.jvm.internal.c
    public g1.b computeReflected() {
        r.f2043a.getClass();
        return this;
    }

    @Override // g1.k
    public Object getDelegate(Object obj) {
        return ((g1.h) getReflected()).getDelegate(obj);
    }

    public /* bridge */ /* synthetic */ g1.i getGetter() {
        mo3getGetter();
        return null;
    }

    public /* bridge */ /* synthetic */ g1.f getSetter() {
        mo4getSetter();
        return null;
    }

    @Override // c1.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    @Override // g1.k
    /* renamed from: getGetter, reason: collision with other method in class */
    public g1.j mo3getGetter() {
        ((g1.h) getReflected()).mo3getGetter();
        return null;
    }

    @Override // g1.h
    /* renamed from: getSetter, reason: collision with other method in class */
    public g1.g mo4getSetter() {
        ((g1.h) getReflected()).mo4getSetter();
        return null;
    }
}
