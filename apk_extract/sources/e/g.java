package e;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class g implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public c f1749a;

    /* renamed from: b, reason: collision with root package name */
    public c f1750b;

    /* renamed from: c, reason: collision with root package name */
    public final WeakHashMap f1751c = new WeakHashMap();

    /* renamed from: d, reason: collision with root package name */
    public int f1752d = 0;

    public c a(Object obj) {
        c cVar = this.f1749a;
        while (cVar != null && !cVar.f1740a.equals(obj)) {
            cVar = cVar.f1742c;
        }
        return cVar;
    }

    public Object b(Object obj, Object obj2) {
        c cVarA = a(obj);
        if (cVarA != null) {
            return cVarA.f1741b;
        }
        c cVar = new c(obj, obj2);
        this.f1752d++;
        c cVar2 = this.f1750b;
        if (cVar2 == null) {
            this.f1749a = cVar;
            this.f1750b = cVar;
            return null;
        }
        cVar2.f1742c = cVar;
        cVar.f1743d = cVar2;
        this.f1750b = cVar;
        return null;
    }

    public Object c(Object obj) {
        c cVarA = a(obj);
        if (cVarA == null) {
            return null;
        }
        this.f1752d--;
        WeakHashMap weakHashMap = this.f1751c;
        if (!weakHashMap.isEmpty()) {
            Iterator it = weakHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((f) it.next()).a(cVarA);
            }
        }
        c cVar = cVarA.f1743d;
        if (cVar != null) {
            cVar.f1742c = cVarA.f1742c;
        } else {
            this.f1749a = cVarA.f1742c;
        }
        c cVar2 = cVarA.f1742c;
        if (cVar2 != null) {
            cVar2.f1743d = cVar;
        } else {
            this.f1750b = cVar;
        }
        cVarA.f1742c = null;
        cVarA.f1743d = null;
        return cVarA.f1741b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
    
        if (r1.hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        if (((e.e) r6).hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 1
            if (r6 != r5) goto L4
            return r0
        L4:
            boolean r1 = r6 instanceof e.g
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            e.g r6 = (e.g) r6
            int r1 = r5.f1752d
            int r3 = r6.f1752d
            if (r1 == r3) goto L13
            return r2
        L13:
            java.util.Iterator r5 = r5.iterator()
            java.util.Iterator r6 = r6.iterator()
        L1b:
            r1 = r5
            e.e r1 = (e.e) r1
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L44
            r3 = r6
            e.e r3 = (e.e) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L44
            java.lang.Object r1 = r1.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r3 = r3.next()
            if (r1 != 0) goto L3b
            if (r3 != 0) goto L43
        L3b:
            if (r1 == 0) goto L1b
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L1b
        L43:
            return r2
        L44:
            boolean r5 = r1.hasNext()
            if (r5 != 0) goto L53
            e.e r6 = (e.e) r6
            boolean r5 = r6.hasNext()
            if (r5 != 0) goto L53
            goto L54
        L53:
            r0 = r2
        L54:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.g.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (true) {
            e eVar = (e) it;
            if (!eVar.hasNext()) {
                return iHashCode;
            }
            iHashCode += ((Map.Entry) eVar.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        b bVar = new b(this.f1749a, this.f1750b, 0);
        this.f1751c.put(bVar, Boolean.FALSE);
        return bVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            e eVar = (e) it;
            if (!eVar.hasNext()) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(((Map.Entry) eVar.next()).toString());
            if (eVar.hasNext()) {
                sb.append(", ");
            }
        }
    }
}
