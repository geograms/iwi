package v0;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class i extends h {
    public static final void N0(Iterable iterable, AbstractCollection abstractCollection) {
        x0.g.u(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static int[] O0(List list) {
        x0.g.u(list, "<this>");
        int[] iArr = new int[list.size()];
        Iterator it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            iArr[i2] = ((Number) it.next()).intValue();
            i2++;
        }
        return iArr;
    }

    public static List P0(Iterable iterable) {
        ArrayList arrayList;
        x0.g.u(iterable, "<this>");
        boolean z2 = iterable instanceof Collection;
        k kVar = k.f2600a;
        if (z2) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return kVar;
            }
            if (size != 1) {
                return new ArrayList(collection);
            }
            List listSingletonList = Collections.singletonList(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
            x0.g.t(listSingletonList, "singletonList(element)");
            return listSingletonList;
        }
        if (z2) {
            arrayList = new ArrayList((Collection) iterable);
        } else {
            arrayList = new ArrayList();
            N0(iterable, arrayList);
        }
        int size2 = arrayList.size();
        if (size2 == 0) {
            return kVar;
        }
        if (size2 != 1) {
            return arrayList;
        }
        List listSingletonList2 = Collections.singletonList(arrayList.get(0));
        x0.g.t(listSingletonList2, "singletonList(element)");
        return listSingletonList2;
    }

    public static Set Q0(ArrayList arrayList) {
        m mVar = m.f2602a;
        int size = arrayList.size();
        if (size == 0) {
            return mVar;
        }
        if (size != 1) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(x0.g.a0(arrayList.size()));
            N0(arrayList, linkedHashSet);
            return linkedHashSet;
        }
        Set setSingleton = Collections.singleton(arrayList.get(0));
        x0.g.t(setSingleton, "singleton(element)");
        return setSingleton;
    }
}
