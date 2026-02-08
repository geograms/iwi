package androidx.coordinatorlayout.widget;

import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final o.j f98a = new o.j(10);

    /* renamed from: b, reason: collision with root package name */
    public final g.l f99b = new g.l();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f100c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f101d = new HashSet();

    public final void a(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) this.f99b.getOrDefault(obj, null);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                a(arrayList2.get(i2), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }
}
