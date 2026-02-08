package androidx.fragment.app;

/* loaded from: classes.dex */
public final class p0 {

    /* renamed from: b, reason: collision with root package name */
    public static final g.l f583b = new g.l();

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w0 f584a;

    public p0(w0 w0Var) {
        this.f584a = w0Var;
    }

    public static Class a(ClassLoader classLoader, String str) throws ClassNotFoundException {
        g.l lVar = f583b;
        g.l lVar2 = (g.l) lVar.getOrDefault(classLoader, null);
        if (lVar2 == null) {
            lVar2 = new g.l();
            lVar.put(classLoader, lVar2);
        }
        Class cls = (Class) lVar2.getOrDefault(str, null);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        lVar2.put(str, cls2);
        return cls2;
    }

    public static Class b(ClassLoader classLoader, String str) {
        try {
            return a(classLoader, str);
        } catch (ClassCastException e2) {
            throw new w("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e2);
        } catch (ClassNotFoundException e3) {
            throw new w("Unable to instantiate fragment " + str + ": make sure class name exists", e3);
        }
    }
}
