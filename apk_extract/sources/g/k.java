package g;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public h f1803a;

    /* renamed from: b, reason: collision with root package name */
    public h f1804b;

    /* renamed from: c, reason: collision with root package name */
    public j f1805c;

    public static boolean d(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static boolean e(Map map, Collection collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public abstract Object a(int i2, int i3);

    public abstract int b();

    public abstract void c(int i2);

    public final Object[] f(Object[] objArr, int i2) {
        int iB = b();
        if (objArr.length < iB) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), iB);
        }
        for (int i3 = 0; i3 < iB; i3++) {
            objArr[i3] = a(i3, i2);
        }
        if (objArr.length > iB) {
            objArr[iB] = null;
        }
        return objArr;
    }
}
