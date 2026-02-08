package androidx.room.util;

import androidx.room.RoomDatabase;
import c1.l;
import g.b;
import g.e;
import java.util.HashMap;
import x0.g;

/* loaded from: classes.dex */
public final class RelationUtil {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> void recursiveFetchArrayMap(b bVar, boolean z2, l lVar) {
        g.u(bVar, "map");
        g.u(lVar, "fetchBlock");
        b bVar2 = new b(RoomDatabase.MAX_BIND_PARAMETER_CNT);
        int i2 = bVar.f1812c;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            if (z2) {
                bVar2.put(bVar.h(i3), bVar.j(i3));
            } else {
                bVar2.put(bVar.h(i3), null);
            }
            i3++;
            i4++;
            if (i4 == 999) {
                lVar.invoke(bVar2);
                if (!z2) {
                    bVar.putAll(bVar2);
                }
                bVar2.clear();
                i4 = 0;
            }
        }
        if (i4 > 0) {
            lVar.invoke(bVar2);
            if (z2) {
                return;
            }
            bVar.putAll(bVar2);
        }
    }

    public static final <K, V> void recursiveFetchHashMap(HashMap<K, V> map, boolean z2, l lVar) {
        int i2;
        g.u(map, "map");
        g.u(lVar, "fetchBlock");
        HashMap map2 = new HashMap(RoomDatabase.MAX_BIND_PARAMETER_CNT);
        loop0: while (true) {
            i2 = 0;
            for (K k2 : map.keySet()) {
                if (z2) {
                    g.t(k2, "key");
                    map2.put(k2, map.get(k2));
                } else {
                    g.t(k2, "key");
                    map2.put(k2, null);
                }
                i2++;
                if (i2 == 999) {
                    lVar.invoke(map2);
                    if (!z2) {
                        map.putAll(map2);
                    }
                    map2.clear();
                }
            }
            break loop0;
        }
        if (i2 > 0) {
            lVar.invoke(map2);
            if (z2) {
                return;
            }
            map.putAll(map2);
        }
    }

    public static final <V> void recursiveFetchLongSparseArray(e eVar, boolean z2, l lVar) {
        g.u(eVar, "map");
        g.u(lVar, "fetchBlock");
        e eVar2 = new e(RoomDatabase.MAX_BIND_PARAMETER_CNT);
        int iH = eVar.h();
        int i2 = 0;
        int i3 = 0;
        while (i2 < iH) {
            if (z2) {
                eVar2.g(eVar.f(i2), eVar.i(i2));
            } else {
                eVar2.g(eVar.f(i2), null);
            }
            i2++;
            i3++;
            if (i3 == 999) {
                lVar.invoke(eVar2);
                if (!z2) {
                    int iH2 = eVar2.h();
                    for (int i4 = 0; i4 < iH2; i4++) {
                        eVar.g(eVar2.f(i4), eVar2.i(i4));
                    }
                }
                eVar2.b();
                i3 = 0;
            }
        }
        if (i3 > 0) {
            lVar.invoke(eVar2);
            if (z2) {
                return;
            }
            int iH3 = eVar2.h();
            for (int i5 = 0; i5 < iH3; i5++) {
                eVar.g(eVar2.f(i5), eVar2.i(i5));
            }
        }
    }
}
