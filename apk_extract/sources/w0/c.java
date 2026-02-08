package w0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class c extends e implements Iterator {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f2626d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(f fVar, int i2) {
        super(fVar);
        this.f2626d = i2;
        if (i2 == 1) {
            x0.g.u(fVar, "map");
            super(fVar);
        } else if (i2 != 2) {
            x0.g.u(fVar, "map");
        } else {
            x0.g.u(fVar, "map");
            super(fVar);
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i2 = this.f2626d;
        f fVar = this.f2629a;
        switch (i2) {
            case 0:
                int i3 = this.f2630b;
                if (i3 >= fVar.f2637f) {
                    throw new NoSuchElementException();
                }
                this.f2630b = i3 + 1;
                this.f2631c = i3;
                d dVar = new d(fVar, i3);
                a();
                return dVar;
            case 1:
                int i4 = this.f2630b;
                if (i4 >= fVar.f2637f) {
                    throw new NoSuchElementException();
                }
                this.f2630b = i4 + 1;
                this.f2631c = i4;
                Object obj = fVar.f2632a[i4];
                a();
                return obj;
            default:
                int i5 = this.f2630b;
                if (i5 >= fVar.f2637f) {
                    throw new NoSuchElementException();
                }
                this.f2630b = i5 + 1;
                this.f2631c = i5;
                Object[] objArr = fVar.f2633b;
                x0.g.q(objArr);
                Object obj2 = objArr[this.f2631c];
                a();
                return obj2;
        }
    }
}
