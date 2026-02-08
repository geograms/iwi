package y0;

import java.lang.reflect.Method;
import x0.g;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Method f2688a;

    static {
        Method method;
        Method[] methods = Throwable.class.getMethods();
        g.t(methods, "throwableMethods");
        int length = methods.length;
        int i2 = 0;
        while (true) {
            method = null;
            if (i2 >= length) {
                break;
            }
            Method method2 = methods[i2];
            if (g.g(method2.getName(), "addSuppressed")) {
                Class<?>[] parameterTypes = method2.getParameterTypes();
                g.t(parameterTypes, "it.parameterTypes");
                if (g.g(parameterTypes.length == 1 ? parameterTypes[0] : null, Throwable.class)) {
                    method = method2;
                    break;
                }
            }
            i2++;
        }
        f2688a = method;
        int length2 = methods.length;
        for (int i3 = 0; i3 < length2 && !g.g(methods[i3].getName(), "getSuppressed"); i3++) {
        }
    }
}
