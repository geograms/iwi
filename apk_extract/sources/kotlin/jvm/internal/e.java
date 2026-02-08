package kotlin.jvm.internal;

import c1.t;
import c1.u;
import c1.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class e implements g1.c, d {

    /* renamed from: b, reason: collision with root package name */
    public static final Map f2038b;

    /* renamed from: a, reason: collision with root package name */
    public final Class f2039a;

    static {
        int i2 = 0;
        List listAsList = Arrays.asList(c1.a.class, c1.l.class, c1.p.class, c1.q.class, d0.c.class, c1.r.class, c1.s.class, t.class, u.class, v.class, c1.b.class, c1.c.class, c1.d.class, c1.e.class, c1.f.class, c1.g.class, c1.h.class, c1.i.class, c1.j.class, c1.k.class, c1.m.class, c1.n.class, c1.o.class);
        x0.g.t(listAsList, "asList(this)");
        ArrayList arrayList = new ArrayList(v0.f.E0(listAsList));
        for (Object obj : listAsList) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                throw new ArithmeticException("Index overflow has happened.");
            }
            arrayList.add(new u0.b((Class) obj, Integer.valueOf(i2)));
            i2 = i3;
        }
        f2038b = v0.f.K0(arrayList);
        HashMap map = new HashMap();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        HashMap map2 = new HashMap();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        HashMap map3 = new HashMap();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        x0.g.t(collectionValues, "primitiveFqNames.values");
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder("kotlin.jvm.internal.");
            x0.g.t(str, "kotlinName");
            sb.append(i1.c.P0(str));
            sb.append("CompanionObject");
            map3.put(sb.toString(), str.concat(".Companion"));
        }
        for (Map.Entry entry : f2038b.entrySet()) {
            Class cls = (Class) entry.getKey();
            int iIntValue = ((Number) entry.getValue()).intValue();
            map3.put(cls.getName(), "kotlin.Function" + iIntValue);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(x0.g.a0(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), i1.c.P0((String) entry2.getValue()));
        }
    }

    public e(Class cls) {
        x0.g.u(cls, "jClass");
        this.f2039a = cls;
    }

    @Override // kotlin.jvm.internal.d
    public final Class a() {
        return this.f2039a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof e) && x0.g.g(x0.g.O(this), x0.g.O((g1.c) obj));
    }

    public final int hashCode() {
        return x0.g.O(this).hashCode();
    }

    public final String toString() {
        return this.f2039a.toString() + " (Kotlin reflection is not available)";
    }
}
