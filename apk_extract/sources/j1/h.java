package j1;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f1914a = 0;

    static {
        String property;
        int i2 = n1.h.f2209a;
        try {
            property = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null || !Boolean.parseBoolean(property)) {
            g gVar = g.f1912c;
            return;
        }
        kotlinx.coroutines.scheduling.c cVar = k.f1916a;
        x0.j jVar = n1.f.f2208a;
        k1.a aVar = ((k1.a) jVar).f2034e;
        if (jVar instanceof i) {
        } else {
            g gVar2 = g.f1912c;
        }
    }
}
