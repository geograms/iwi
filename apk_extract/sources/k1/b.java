package k1;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.lang.reflect.InvocationTargetException;
import u0.c;

/* loaded from: classes.dex */
public abstract class b {
    private static volatile Choreographer choreographer;

    static {
        Object cVar;
        try {
            cVar = new a(a(Looper.getMainLooper()));
        } catch (Throwable th) {
            cVar = new c(th);
        }
        if (cVar instanceof c) {
            cVar = null;
        }
    }

    public static final Handler a(Looper looper) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        if (objInvoke != null) {
            return (Handler) objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
    }
}
