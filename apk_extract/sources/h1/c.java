package h1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import v0.k;
import x0.g;

/* loaded from: classes.dex */
public abstract class c extends e {
    public static List E0(b bVar) {
        ArrayList arrayList = new ArrayList();
        Iterator it = bVar.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        int size = arrayList.size();
        if (size == 0) {
            return k.f2600a;
        }
        if (size != 1) {
            return arrayList;
        }
        List listSingletonList = Collections.singletonList(arrayList.get(0));
        g.t(listSingletonList, "singletonList(element)");
        return listSingletonList;
    }
}
