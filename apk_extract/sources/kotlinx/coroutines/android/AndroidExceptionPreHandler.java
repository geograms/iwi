package kotlinx.coroutines.android;

import androidx.annotation.Keep;
import j1.d;
import j1.e;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import x0.a;
import x0.j;

@Keep
/* loaded from: classes.dex */
public final class AndroidExceptionPreHandler extends a implements e {
    private volatile Object _preHandler;

    public AndroidExceptionPreHandler() {
        super(d.f1909a);
        this._preHandler = this;
    }

    private final Method preHandler() {
        Object obj = this._preHandler;
        if (obj != this) {
            return (Method) obj;
        }
        Method method = null;
        try {
            Method declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
            if (Modifier.isPublic(declaredMethod.getModifiers())) {
                if (Modifier.isStatic(declaredMethod.getModifiers())) {
                    method = declaredMethod;
                }
            }
        } catch (Throwable unused) {
        }
        this._preHandler = method;
        return method;
    }

    @Override // j1.e
    public void handleException(j jVar, Throwable th) {
    }
}
