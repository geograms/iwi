package h1;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f1839a;

    public a(d dVar) {
        this.f1839a = new AtomicReference(dVar);
    }

    @Override // h1.b
    public final Iterator iterator() {
        b bVar = (b) this.f1839a.getAndSet(null);
        if (bVar != null) {
            return bVar.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
