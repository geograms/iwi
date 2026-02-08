package v0;

import java.util.AbstractList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class c extends AbstractList implements List {
    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        w0.b bVar = (w0.b) this;
        bVar.c();
        c.c.c(i2, bVar.f2622c);
        return bVar.e(bVar.f2621b + i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return ((w0.b) this).f2622c;
    }
}
