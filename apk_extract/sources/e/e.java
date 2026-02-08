package e;

import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class e extends f implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public c f1747a;

    /* renamed from: b, reason: collision with root package name */
    public c f1748b;

    @Override // e.f
    public final void a(c cVar) {
        c cVar2;
        c cVar3;
        c cVar4 = null;
        if (this.f1747a == cVar && cVar == this.f1748b) {
            this.f1748b = null;
            this.f1747a = null;
        }
        c cVar5 = this.f1747a;
        if (cVar5 == cVar) {
            switch (((b) this).f1739c) {
                case 0:
                    cVar3 = cVar5.f1743d;
                    break;
                default:
                    cVar3 = cVar5.f1742c;
                    break;
            }
            this.f1747a = cVar3;
        }
        c cVar6 = this.f1748b;
        if (cVar6 == cVar) {
            c cVar7 = this.f1747a;
            if (cVar6 != cVar7 && cVar7 != null) {
                switch (((b) this).f1739c) {
                    case 0:
                        cVar2 = cVar6.f1742c;
                        break;
                    default:
                        cVar2 = cVar6.f1743d;
                        break;
                }
                cVar4 = cVar2;
            }
            this.f1748b = cVar4;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1748b != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        c cVar;
        c cVar2 = this.f1748b;
        c cVar3 = this.f1747a;
        if (cVar2 != cVar3 && cVar3 != null) {
            switch (((b) this).f1739c) {
                case 0:
                    cVar = cVar2.f1742c;
                    break;
                default:
                    cVar = cVar2.f1743d;
                    break;
            }
        } else {
            cVar = null;
        }
        this.f1748b = cVar;
        return cVar2;
    }
}
