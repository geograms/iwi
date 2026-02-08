package e;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class d extends f implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public c f1744a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1745b = true;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f1746c;

    public d(g gVar) {
        this.f1746c = gVar;
    }

    @Override // e.f
    public final void a(c cVar) {
        c cVar2 = this.f1744a;
        if (cVar == cVar2) {
            c cVar3 = cVar2.f1743d;
            this.f1744a = cVar3;
            this.f1745b = cVar3 == null;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f1745b) {
            return this.f1746c.f1749a != null;
        }
        c cVar = this.f1744a;
        return (cVar == null || cVar.f1742c == null) ? false : true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f1745b) {
            this.f1745b = false;
            this.f1744a = this.f1746c.f1749a;
        } else {
            c cVar = this.f1744a;
            this.f1744a = cVar != null ? cVar.f1742c : null;
        }
        return this.f1744a;
    }
}
