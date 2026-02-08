package v0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class f extends x0.g {
    public static int E0(Iterable iterable) {
        x0.g.u(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return 10;
    }

    public static void F0(Object[] objArr, Object[] objArr2, int i2, int i3, int i4) {
        x0.g.u(objArr, "<this>");
        x0.g.u(objArr2, "destination");
        System.arraycopy(objArr, i3, objArr2, i2, i4 - i3);
    }

    public static String G0(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        int i2 = 0;
        for (Object obj : objArr) {
            i2++;
            if (i2 > 1) {
                sb.append((CharSequence) ", ");
            }
            x0.g.e(sb, obj, null);
        }
        sb.append((CharSequence) "");
        String string = sb.toString();
        x0.g.t(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static LinkedHashSet H0(Set set, Set set2) {
        int size;
        x0.g.u(set, "<this>");
        x0.g.u(set2, "elements");
        Integer numValueOf = Integer.valueOf(set2.size());
        if (numValueOf != null) {
            size = set.size() + numValueOf.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(x0.g.a0(size));
        linkedHashSet.addAll(set);
        linkedHashSet.addAll(set2);
        return linkedHashSet;
    }

    public static char I0(char[] cArr) {
        x0.g.u(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static List J0(Object[] objArr) {
        x0.g.u(objArr, "<this>");
        int length = objArr.length;
        if (length == 0) {
            return k.f2600a;
        }
        if (length != 1) {
            return new ArrayList(new e(objArr));
        }
        List listSingletonList = Collections.singletonList(objArr[0]);
        x0.g.t(listSingletonList, "singletonList(element)");
        return listSingletonList;
    }

    public static Map K0(ArrayList arrayList) {
        l lVar = l.f2601a;
        int size = arrayList.size();
        if (size == 0) {
            return lVar;
        }
        if (size != 1) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(x0.g.a0(arrayList.size()));
            L0(arrayList, linkedHashMap);
            return linkedHashMap;
        }
        u0.b bVar = (u0.b) arrayList.get(0);
        x0.g.u(bVar, "pair");
        Map mapSingletonMap = Collections.singletonMap(bVar.f2588a, bVar.f2589b);
        x0.g.t(mapSingletonMap, "singletonMap(pair.first, pair.second)");
        return mapSingletonMap;
    }

    public static final void L0(ArrayList arrayList, LinkedHashMap linkedHashMap) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            u0.b bVar = (u0.b) it.next();
            linkedHashMap.put(bVar.f2588a, bVar.f2589b);
        }
    }
}
