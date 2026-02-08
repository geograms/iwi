package y0;

import d1.e;
import java.lang.reflect.Method;
import x0.g;

/* loaded from: classes.dex */
public class b {
    public void a(Throwable th, Throwable th2) {
        g.u(th, "cause");
        g.u(th2, "exception");
        Method method = a.f2688a;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    public e b() {
        return new d1.c();
    }
}
