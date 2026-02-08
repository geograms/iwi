package g;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: classes.dex */
public class l {

    /* renamed from: d, reason: collision with root package name */
    public static Object[] f1806d;

    /* renamed from: e, reason: collision with root package name */
    public static int f1807e;

    /* renamed from: f, reason: collision with root package name */
    public static Object[] f1808f;

    /* renamed from: g, reason: collision with root package name */
    public static int f1809g;

    /* renamed from: a, reason: collision with root package name */
    public int[] f1810a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f1811b;

    /* renamed from: c, reason: collision with root package name */
    public int f1812c;

    public l() {
        this.f1810a = d.f1783a;
        this.f1811b = d.f1785c;
        this.f1812c = 0;
    }

    public static void c(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (l.class) {
                try {
                    if (f1809g < 10) {
                        objArr[0] = f1808f;
                        objArr[1] = iArr;
                        for (int i3 = (i2 << 1) - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        f1808f = objArr;
                        f1809g++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (l.class) {
                try {
                    if (f1807e < 10) {
                        objArr[0] = f1806d;
                        objArr[1] = iArr;
                        for (int i4 = (i2 << 1) - 1; i4 >= 2; i4--) {
                            objArr[i4] = null;
                        }
                        f1806d = objArr;
                        f1807e++;
                    }
                } finally {
                }
            }
        }
    }

    public final void a(int i2) {
        if (i2 == 8) {
            synchronized (l.class) {
                try {
                    Object[] objArr = f1808f;
                    if (objArr != null) {
                        this.f1811b = objArr;
                        f1808f = (Object[]) objArr[0];
                        this.f1810a = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f1809g--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i2 == 4) {
            synchronized (l.class) {
                try {
                    Object[] objArr2 = f1806d;
                    if (objArr2 != null) {
                        this.f1811b = objArr2;
                        f1806d = (Object[]) objArr2[0];
                        this.f1810a = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f1807e--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f1810a = new int[i2];
        this.f1811b = new Object[i2 << 1];
    }

    public final void b(int i2) {
        int i3 = this.f1812c;
        int[] iArr = this.f1810a;
        if (iArr.length < i2) {
            Object[] objArr = this.f1811b;
            a(i2);
            if (this.f1812c > 0) {
                System.arraycopy(iArr, 0, this.f1810a, 0, i3);
                System.arraycopy(objArr, 0, this.f1811b, 0, i3 << 1);
            }
            c(iArr, objArr, i3);
        }
        if (this.f1812c != i3) {
            throw new ConcurrentModificationException();
        }
    }

    public final void clear() {
        int i2 = this.f1812c;
        if (i2 > 0) {
            int[] iArr = this.f1810a;
            Object[] objArr = this.f1811b;
            this.f1810a = d.f1783a;
            this.f1811b = d.f1785c;
            this.f1812c = 0;
            c(iArr, objArr, i2);
        }
        if (this.f1812c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean containsKey(Object obj) {
        return e(obj) >= 0;
    }

    public final boolean containsValue(Object obj) {
        return g(obj) >= 0;
    }

    public final int d(int i2, Object obj) {
        int i3 = this.f1812c;
        if (i3 == 0) {
            return -1;
        }
        try {
            int iA = d.a(i3, i2, this.f1810a);
            if (iA < 0 || obj.equals(this.f1811b[iA << 1])) {
                return iA;
            }
            int i4 = iA + 1;
            while (i4 < i3 && this.f1810a[i4] == i2) {
                if (obj.equals(this.f1811b[i4 << 1])) {
                    return i4;
                }
                i4++;
            }
            for (int i5 = iA - 1; i5 >= 0 && this.f1810a[i5] == i2; i5--) {
                if (obj.equals(this.f1811b[i5 << 1])) {
                    return i5;
                }
            }
            return ~i4;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final int e(Object obj) {
        return obj == null ? f() : d(obj.hashCode(), obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (this.f1812c != lVar.f1812c) {
                return false;
            }
            for (int i2 = 0; i2 < this.f1812c; i2++) {
                try {
                    Object objH = h(i2);
                    Object objJ = j(i2);
                    Object orDefault = lVar.getOrDefault(objH, null);
                    if (objJ == null) {
                        if (orDefault != null || !lVar.containsKey(objH)) {
                            return false;
                        }
                    } else if (!objJ.equals(orDefault)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this.f1812c != map.size()) {
                return false;
            }
            for (int i3 = 0; i3 < this.f1812c; i3++) {
                try {
                    Object objH2 = h(i3);
                    Object objJ2 = j(i3);
                    Object obj2 = map.get(objH2);
                    if (objJ2 == null) {
                        if (obj2 != null || !map.containsKey(objH2)) {
                            return false;
                        }
                    } else if (!objJ2.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public final int f() {
        int i2 = this.f1812c;
        if (i2 == 0) {
            return -1;
        }
        try {
            int iA = d.a(i2, 0, this.f1810a);
            if (iA < 0 || this.f1811b[iA << 1] == null) {
                return iA;
            }
            int i3 = iA + 1;
            while (i3 < i2 && this.f1810a[i3] == 0) {
                if (this.f1811b[i3 << 1] == null) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = iA - 1; i4 >= 0 && this.f1810a[i4] == 0; i4--) {
                if (this.f1811b[i4 << 1] == null) {
                    return i4;
                }
            }
            return ~i3;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final int g(Object obj) {
        int i2 = this.f1812c * 2;
        Object[] objArr = this.f1811b;
        if (obj == null) {
            for (int i3 = 1; i3 < i2; i3 += 2) {
                if (objArr[i3] == null) {
                    return i3 >> 1;
                }
            }
            return -1;
        }
        for (int i4 = 1; i4 < i2; i4 += 2) {
            if (obj.equals(objArr[i4])) {
                return i4 >> 1;
            }
        }
        return -1;
    }

    public final Object get(Object obj) {
        return getOrDefault(obj, null);
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        int iE = e(obj);
        return iE >= 0 ? this.f1811b[(iE << 1) + 1] : obj2;
    }

    public final Object h(int i2) {
        return this.f1811b[i2 << 1];
    }

    public final int hashCode() {
        int[] iArr = this.f1810a;
        Object[] objArr = this.f1811b;
        int i2 = this.f1812c;
        int i3 = 1;
        int i4 = 0;
        int iHashCode = 0;
        while (i4 < i2) {
            Object obj = objArr[i3];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i4];
            i4++;
            i3 += 2;
        }
        return iHashCode;
    }

    public final Object i(int i2) {
        Object[] objArr = this.f1811b;
        int i3 = i2 << 1;
        Object obj = objArr[i3 + 1];
        int i4 = this.f1812c;
        int i5 = 0;
        if (i4 <= 1) {
            c(this.f1810a, objArr, i4);
            this.f1810a = d.f1783a;
            this.f1811b = d.f1785c;
        } else {
            int i6 = i4 - 1;
            int[] iArr = this.f1810a;
            if (iArr.length <= 8 || i4 >= iArr.length / 3) {
                if (i2 < i6) {
                    int i7 = i2 + 1;
                    int i8 = i6 - i2;
                    System.arraycopy(iArr, i7, iArr, i2, i8);
                    Object[] objArr2 = this.f1811b;
                    System.arraycopy(objArr2, i7 << 1, objArr2, i3, i8 << 1);
                }
                Object[] objArr3 = this.f1811b;
                int i9 = i6 << 1;
                objArr3[i9] = null;
                objArr3[i9 + 1] = null;
            } else {
                a(i4 > 8 ? i4 + (i4 >> 1) : 8);
                if (i4 != this.f1812c) {
                    throw new ConcurrentModificationException();
                }
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.f1810a, 0, i2);
                    System.arraycopy(objArr, 0, this.f1811b, 0, i3);
                }
                if (i2 < i6) {
                    int i10 = i2 + 1;
                    int i11 = i6 - i2;
                    System.arraycopy(iArr, i10, this.f1810a, i2, i11);
                    System.arraycopy(objArr, i10 << 1, this.f1811b, i3, i11 << 1);
                }
            }
            i5 = i6;
        }
        if (i4 != this.f1812c) {
            throw new ConcurrentModificationException();
        }
        this.f1812c = i5;
        return obj;
    }

    public final boolean isEmpty() {
        return this.f1812c <= 0;
    }

    public final Object j(int i2) {
        return this.f1811b[(i2 << 1) + 1];
    }

    public final Object put(Object obj, Object obj2) {
        int i2;
        int iD;
        int i3 = this.f1812c;
        if (obj == null) {
            iD = f();
            i2 = 0;
        } else {
            int iHashCode = obj.hashCode();
            i2 = iHashCode;
            iD = d(iHashCode, obj);
        }
        if (iD >= 0) {
            int i4 = (iD << 1) + 1;
            Object[] objArr = this.f1811b;
            Object obj3 = objArr[i4];
            objArr[i4] = obj2;
            return obj3;
        }
        int i5 = ~iD;
        int[] iArr = this.f1810a;
        if (i3 >= iArr.length) {
            int i6 = 8;
            if (i3 >= 8) {
                i6 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i6 = 4;
            }
            Object[] objArr2 = this.f1811b;
            a(i6);
            if (i3 != this.f1812c) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f1810a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f1811b, 0, objArr2.length);
            }
            c(iArr, objArr2, i3);
        }
        if (i5 < i3) {
            int[] iArr3 = this.f1810a;
            int i7 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i7, i3 - i5);
            Object[] objArr3 = this.f1811b;
            System.arraycopy(objArr3, i5 << 1, objArr3, i7 << 1, (this.f1812c - i5) << 1);
        }
        int i8 = this.f1812c;
        if (i3 == i8) {
            int[] iArr4 = this.f1810a;
            if (i5 < iArr4.length) {
                iArr4[i5] = i2;
                Object[] objArr4 = this.f1811b;
                int i9 = i5 << 1;
                objArr4[i9] = obj;
                objArr4[i9 + 1] = obj2;
                this.f1812c = i8 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        Object orDefault = getOrDefault(obj, null);
        return orDefault == null ? put(obj, obj2) : orDefault;
    }

    public final Object remove(Object obj) {
        int iE = e(obj);
        if (iE >= 0) {
            return i(iE);
        }
        return null;
    }

    public final Object replace(Object obj, Object obj2) {
        int iE = e(obj);
        if (iE < 0) {
            return null;
        }
        int i2 = (iE << 1) + 1;
        Object[] objArr = this.f1811b;
        Object obj3 = objArr[i2];
        objArr[i2] = obj2;
        return obj3;
    }

    public final int size() {
        return this.f1812c;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1812c * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f1812c; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object objH = h(i2);
            if (objH != this) {
                sb.append(objH);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object objJ = j(i2);
            if (objJ != this) {
                sb.append(objJ);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public l(int i2) {
        if (i2 == 0) {
            this.f1810a = d.f1783a;
            this.f1811b = d.f1785c;
        } else {
            a(i2);
        }
        this.f1812c = 0;
    }

    public final boolean remove(Object obj, Object obj2) {
        int iE = e(obj);
        if (iE < 0) {
            return false;
        }
        Object objJ = j(iE);
        if (obj2 != objJ && (obj2 == null || !obj2.equals(objJ))) {
            return false;
        }
        i(iE);
        return true;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int iE = e(obj);
        if (iE < 0) {
            return false;
        }
        Object objJ = j(iE);
        if (objJ != obj2 && (obj2 == null || !obj2.equals(objJ))) {
            return false;
        }
        int i2 = (iE << 1) + 1;
        Object[] objArr = this.f1811b;
        Object obj4 = objArr[i2];
        objArr[i2] = obj3;
        return true;
    }
}
