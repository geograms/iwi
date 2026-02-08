package w0;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
public final class f implements Map, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f2632a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f2633b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f2634c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f2635d;

    /* renamed from: e, reason: collision with root package name */
    public int f2636e;

    /* renamed from: f, reason: collision with root package name */
    public int f2637f;

    /* renamed from: g, reason: collision with root package name */
    public int f2638g;

    /* renamed from: h, reason: collision with root package name */
    public int f2639h;

    /* renamed from: i, reason: collision with root package name */
    public g f2640i;

    /* renamed from: j, reason: collision with root package name */
    public h f2641j;

    /* renamed from: k, reason: collision with root package name */
    public g f2642k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f2643l;

    public f() {
        int iHighestOneBit = Integer.highestOneBit(24);
        this.f2632a = new Object[8];
        this.f2633b = null;
        this.f2634c = new int[8];
        this.f2635d = new int[iHighestOneBit];
        this.f2636e = 2;
        this.f2637f = 0;
        this.f2638g = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
    }

    public final int a(Object obj) {
        b();
        while (true) {
            int iH = h(obj);
            int i2 = this.f2636e * 2;
            int length = this.f2635d.length / 2;
            if (i2 > length) {
                i2 = length;
            }
            int i3 = 0;
            while (true) {
                int[] iArr = this.f2635d;
                int i4 = iArr[iH];
                if (i4 <= 0) {
                    int i5 = this.f2637f;
                    Object[] objArr = this.f2632a;
                    if (i5 < objArr.length) {
                        int i6 = i5 + 1;
                        this.f2637f = i6;
                        objArr[i5] = obj;
                        this.f2634c[i5] = iH;
                        iArr[iH] = i6;
                        this.f2639h++;
                        if (i3 > this.f2636e) {
                            this.f2636e = i3;
                        }
                        return i5;
                    }
                    e(1);
                } else {
                    if (x0.g.g(this.f2632a[i4 - 1], obj)) {
                        return -i4;
                    }
                    i3++;
                    if (i3 > i2) {
                        i(this.f2635d.length * 2);
                        break;
                    }
                    iH = iH == 0 ? this.f2635d.length - 1 : iH - 1;
                }
            }
        }
    }

    public final void b() {
        if (this.f2643l) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean c(Collection collection) {
        x0.g.u(collection, "m");
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    if (!d((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map
    public final void clear() {
        int i2;
        b();
        int i3 = new f1.c(0, this.f2637f - 1, 1).f1764b;
        boolean z2 = i3 >= 0;
        int i4 = z2 ? 0 : i3;
        while (z2) {
            if (i4 != i3) {
                i2 = i4 + 1;
            } else {
                if (!z2) {
                    throw new NoSuchElementException();
                }
                i2 = i4;
                z2 = false;
            }
            int[] iArr = this.f2634c;
            int i5 = iArr[i4];
            if (i5 >= 0) {
                this.f2635d[i5] = 0;
                iArr[i4] = -1;
            }
            i4 = i2;
        }
        x0.g.s0(0, this.f2637f, this.f2632a);
        Object[] objArr = this.f2633b;
        if (objArr != null) {
            x0.g.s0(0, this.f2637f, objArr);
        }
        this.f2639h = 0;
        this.f2637f = 0;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return g(obj) >= 0;
    }

    public final boolean d(Map.Entry entry) {
        x0.g.u(entry, "entry");
        int iF = f(entry.getKey());
        if (iF < 0) {
            return false;
        }
        Object[] objArr = this.f2633b;
        x0.g.q(objArr);
        return x0.g.g(objArr[iF], entry.getValue());
    }

    public final void e(int i2) {
        Object[] objArrCopyOf;
        Object[] objArr = this.f2632a;
        int length = objArr.length;
        int i3 = this.f2637f;
        int i4 = length - i3;
        int i5 = i3 - this.f2639h;
        if (i4 < i2 && i4 + i5 >= i2 && i5 >= objArr.length / 4) {
            i(this.f2635d.length);
            return;
        }
        int i6 = i3 + i2;
        if (i6 < 0) {
            throw new OutOfMemoryError();
        }
        if (i6 > objArr.length) {
            int length2 = (objArr.length * 3) / 2;
            if (i6 <= length2) {
                i6 = length2;
            }
            Object[] objArrCopyOf2 = Arrays.copyOf(objArr, i6);
            x0.g.t(objArrCopyOf2, "copyOf(this, newSize)");
            this.f2632a = objArrCopyOf2;
            Object[] objArr2 = this.f2633b;
            if (objArr2 != null) {
                objArrCopyOf = Arrays.copyOf(objArr2, i6);
                x0.g.t(objArrCopyOf, "copyOf(this, newSize)");
            } else {
                objArrCopyOf = null;
            }
            this.f2633b = objArrCopyOf;
            int[] iArrCopyOf = Arrays.copyOf(this.f2634c, i6);
            x0.g.t(iArrCopyOf, "copyOf(this, newSize)");
            this.f2634c = iArrCopyOf;
            if (i6 < 1) {
                i6 = 1;
            }
            int iHighestOneBit = Integer.highestOneBit(i6 * 3);
            if (iHighestOneBit > this.f2635d.length) {
                i(iHighestOneBit);
            }
        }
    }

    @Override // java.util.Map
    public final Set entrySet() {
        g gVar = this.f2642k;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this, 0);
        this.f2642k = gVar2;
        return gVar2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                if (this.f2639h != map.size() || !c(map.entrySet())) {
                }
            }
            return false;
        }
        return true;
    }

    public final int f(Object obj) {
        int iH = h(obj);
        int i2 = this.f2636e;
        while (true) {
            int i3 = this.f2635d[iH];
            if (i3 == 0) {
                return -1;
            }
            if (i3 > 0) {
                int i4 = i3 - 1;
                if (x0.g.g(this.f2632a[i4], obj)) {
                    return i4;
                }
            }
            i2--;
            if (i2 < 0) {
                return -1;
            }
            iH = iH == 0 ? this.f2635d.length - 1 : iH - 1;
        }
    }

    public final int g(Object obj) {
        int i2 = this.f2637f;
        while (true) {
            i2--;
            if (i2 < 0) {
                return -1;
            }
            if (this.f2634c[i2] >= 0) {
                Object[] objArr = this.f2633b;
                x0.g.q(objArr);
                if (x0.g.g(objArr[i2], obj)) {
                    return i2;
                }
            }
        }
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        int iF = f(obj);
        if (iF < 0) {
            return null;
        }
        Object[] objArr = this.f2633b;
        x0.g.q(objArr);
        return objArr[iF];
    }

    public final int h(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.f2638g;
    }

    @Override // java.util.Map
    public final int hashCode() {
        c cVar = new c(this, 0);
        int i2 = 0;
        while (cVar.hasNext()) {
            int i3 = cVar.f2630b;
            f fVar = cVar.f2629a;
            if (i3 >= fVar.f2637f) {
                throw new NoSuchElementException();
            }
            cVar.f2630b = i3 + 1;
            cVar.f2631c = i3;
            Object obj = fVar.f2632a[i3];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = fVar.f2633b;
            x0.g.q(objArr);
            Object obj2 = objArr[cVar.f2631c];
            int iHashCode2 = obj2 != null ? obj2.hashCode() : 0;
            cVar.a();
            i2 += iHashCode ^ iHashCode2;
        }
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0065, code lost:
    
        r3[r0] = r7;
        r6.f2634c[r2] = r0;
        r2 = r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(int r7) {
        /*
            r6 = this;
            int r0 = r6.f2637f
            int r1 = r6.f2639h
            r2 = 0
            if (r0 <= r1) goto L34
            java.lang.Object[] r0 = r6.f2633b
            r1 = r2
            r3 = r1
        Lb:
            int r4 = r6.f2637f
            if (r1 >= r4) goto L26
            int[] r4 = r6.f2634c
            r4 = r4[r1]
            if (r4 < 0) goto L23
            java.lang.Object[] r4 = r6.f2632a
            r5 = r4[r1]
            r4[r3] = r5
            if (r0 == 0) goto L21
            r4 = r0[r1]
            r0[r3] = r4
        L21:
            int r3 = r3 + 1
        L23:
            int r1 = r1 + 1
            goto Lb
        L26:
            java.lang.Object[] r1 = r6.f2632a
            x0.g.s0(r3, r4, r1)
            if (r0 == 0) goto L32
            int r1 = r6.f2637f
            x0.g.s0(r3, r1, r0)
        L32:
            r6.f2637f = r3
        L34:
            int[] r0 = r6.f2635d
            int r1 = r0.length
            if (r7 == r1) goto L46
            int[] r0 = new int[r7]
            r6.f2635d = r0
            int r7 = java.lang.Integer.numberOfLeadingZeros(r7)
            int r7 = r7 + 1
            r6.f2638g = r7
            goto L4f
        L46:
            int r7 = r0.length
            java.lang.String r1 = "<this>"
            x0.g.u(r0, r1)
            java.util.Arrays.fill(r0, r2, r7, r2)
        L4f:
            int r7 = r6.f2637f
            if (r2 >= r7) goto L83
            int r7 = r2 + 1
            java.lang.Object[] r0 = r6.f2632a
            r0 = r0[r2]
            int r0 = r6.h(r0)
            int r1 = r6.f2636e
        L5f:
            int[] r3 = r6.f2635d
            r4 = r3[r0]
            if (r4 != 0) goto L6d
            r3[r0] = r7
            int[] r1 = r6.f2634c
            r1[r2] = r0
            r2 = r7
            goto L4f
        L6d:
            int r1 = r1 + (-1)
            if (r1 < 0) goto L7b
            int r4 = r0 + (-1)
            if (r0 != 0) goto L79
            int r0 = r3.length
            int r0 = r0 + (-1)
            goto L5f
        L79:
            r0 = r4
            goto L5f
        L7b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?"
            r6.<init>(r7)
            throw r6
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.f.i(int):void");
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f2639h == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0062 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[LOOP:0: B:6:0x001e->B:30:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(int r12) {
        /*
            r11 = this;
            java.lang.Object[] r0 = r11.f2632a
            java.lang.String r1 = "<this>"
            x0.g.u(r0, r1)
            r1 = 0
            r0[r12] = r1
            int[] r0 = r11.f2634c
            r0 = r0[r12]
            int r1 = r11.f2636e
            int r1 = r1 * 2
            int[] r2 = r11.f2635d
            int r2 = r2.length
            int r2 = r2 / 2
            if (r1 <= r2) goto L1a
            r1 = r2
        L1a:
            r2 = 0
            r3 = r1
            r4 = r2
            r1 = r0
        L1e:
            int r5 = r0 + (-1)
            if (r0 != 0) goto L28
            int[] r0 = r11.f2635d
            int r0 = r0.length
            int r0 = r0 + (-1)
            goto L29
        L28:
            r0 = r5
        L29:
            int r4 = r4 + 1
            int r5 = r11.f2636e
            r6 = -1
            if (r4 <= r5) goto L35
            int[] r0 = r11.f2635d
            r0[r1] = r2
            goto L66
        L35:
            int[] r5 = r11.f2635d
            r7 = r5[r0]
            if (r7 != 0) goto L3e
            r5[r1] = r2
            goto L66
        L3e:
            if (r7 >= 0) goto L45
            r5[r1] = r6
        L42:
            r1 = r0
            r4 = r2
            goto L5f
        L45:
            java.lang.Object[] r5 = r11.f2632a
            int r8 = r7 + (-1)
            r5 = r5[r8]
            int r5 = r11.h(r5)
            int r5 = r5 - r0
            int[] r9 = r11.f2635d
            int r10 = r9.length
            int r10 = r10 + (-1)
            r5 = r5 & r10
            if (r5 < r4) goto L5f
            r9[r1] = r7
            int[] r4 = r11.f2634c
            r4[r8] = r1
            goto L42
        L5f:
            int r3 = r3 + r6
            if (r3 >= 0) goto L1e
            int[] r0 = r11.f2635d
            r0[r1] = r6
        L66:
            int[] r0 = r11.f2634c
            r0[r12] = r6
            int r12 = r11.f2639h
            int r12 = r12 + r6
            r11.f2639h = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.f.j(int):void");
    }

    @Override // java.util.Map
    public final Set keySet() {
        g gVar = this.f2640i;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this, 1);
        this.f2640i = gVar2;
        return gVar2;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        b();
        int iA = a(obj);
        Object[] objArr = this.f2633b;
        if (objArr == null) {
            int length = this.f2632a.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.".toString());
            }
            objArr = new Object[length];
            this.f2633b = objArr;
        }
        if (iA >= 0) {
            objArr[iA] = obj2;
            return null;
        }
        int i2 = (-iA) - 1;
        Object obj3 = objArr[i2];
        objArr[i2] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        x0.g.u(map, "from");
        b();
        Set<Map.Entry> setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        e(setEntrySet.size());
        for (Map.Entry entry : setEntrySet) {
            int iA = a(entry.getKey());
            Object[] objArr = this.f2633b;
            if (objArr == null) {
                int length = this.f2632a.length;
                if (length < 0) {
                    throw new IllegalArgumentException("capacity must be non-negative.".toString());
                }
                objArr = new Object[length];
                this.f2633b = objArr;
            }
            if (iA >= 0) {
                objArr[iA] = entry.getValue();
            } else {
                int i2 = (-iA) - 1;
                if (!x0.g.g(entry.getValue(), objArr[i2])) {
                    objArr[i2] = entry.getValue();
                }
            }
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        b();
        int iF = f(obj);
        if (iF < 0) {
            iF = -1;
        } else {
            j(iF);
        }
        if (iF < 0) {
            return null;
        }
        Object[] objArr = this.f2633b;
        x0.g.q(objArr);
        Object obj2 = objArr[iF];
        objArr[iF] = null;
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.f2639h;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.f2639h * 3) + 2);
        sb.append("{");
        int i2 = 0;
        c cVar = new c(this, 0);
        while (cVar.hasNext()) {
            if (i2 > 0) {
                sb.append(", ");
            }
            int i3 = cVar.f2630b;
            f fVar = cVar.f2629a;
            if (i3 >= fVar.f2637f) {
                throw new NoSuchElementException();
            }
            cVar.f2630b = i3 + 1;
            cVar.f2631c = i3;
            Object obj = fVar.f2632a[i3];
            if (x0.g.g(obj, fVar)) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = fVar.f2633b;
            x0.g.q(objArr);
            Object obj2 = objArr[cVar.f2631c];
            if (x0.g.g(obj2, fVar)) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            cVar.a();
            i2++;
        }
        sb.append("}");
        String string = sb.toString();
        x0.g.t(string, "sb.toString()");
        return string;
    }

    @Override // java.util.Map
    public final Collection values() {
        h hVar = this.f2641j;
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h(this);
        this.f2641j = hVar2;
        return hVar2;
    }
}
