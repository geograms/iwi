package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public final class o0 implements n0 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f908a;

    public o0(d dVar) {
        this.f908a = dVar;
    }

    @Override // androidx.recyclerview.widget.n0
    public final void a(int i2, int i3) {
        ((v0) this.f908a).notifyItemRangeRemoved(i2, i3);
    }

    @Override // androidx.recyclerview.widget.n0
    public final void b(int i2, int i3) {
        ((v0) this.f908a).notifyItemRangeInserted(i2, i3);
    }

    @Override // androidx.recyclerview.widget.n0
    public final void c(int i2, int i3) {
        ((v0) this.f908a).notifyItemMoved(i2, i3);
    }

    @Override // androidx.recyclerview.widget.n0
    public final void d(int i2, int i3, Object obj) {
        ((v0) this.f908a).notifyItemRangeChanged(i2, i3, obj);
    }

    public final boolean e(int i2, int i3) {
        Object obj = this.f908a;
        Object obj2 = ((d) obj).f760a.get(i2);
        Object obj3 = ((d) obj).f761b.get(i3);
        if (obj2 != null && obj3 != null) {
            return ((x0.g) ((d) obj).f764e.f782b.f2550b).f(obj2, obj3);
        }
        if (obj2 == null && obj3 == null) {
            return true;
        }
        throw new AssertionError();
    }

    public final boolean f(int i2, int i3) {
        Object obj = this.f908a;
        Object obj2 = ((d) obj).f760a.get(i2);
        Object obj3 = ((d) obj).f761b.get(i3);
        return (obj2 == null || obj3 == null) ? obj2 == null && obj3 == null : ((x0.g) ((d) obj).f764e.f782b.f2550b).h(obj2, obj3);
    }

    public final void g(int i2, int i3) {
        d dVar = (d) this.f908a;
        Object obj = dVar.f760a.get(i2);
        Object obj2 = dVar.f761b.get(i3);
        if (obj == null || obj2 == null) {
            throw new AssertionError();
        }
        ((x0.g) dVar.f764e.f782b.f2550b).getClass();
    }

    public /* synthetic */ o0(Object obj) {
        this.f908a = obj;
    }
}
