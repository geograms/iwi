package h;

import android.app.Activity;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f1833a;

    /* renamed from: b, reason: collision with root package name */
    public static final Method f1834b;

    /* renamed from: c, reason: collision with root package name */
    public static final Method f1835c;

    static {
        Class<?> cls;
        Method declaredMethod;
        new Handler(Looper.getMainLooper());
        Method method = null;
        try {
            cls = Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            cls = null;
        }
        f1833a = cls;
        try {
            Activity.class.getDeclaredField("mMainThread").setAccessible(true);
        } catch (Throwable unused2) {
        }
        try {
            Activity.class.getDeclaredField("mToken").setAccessible(true);
        } catch (Throwable unused3) {
        }
        Class cls2 = f1833a;
        if (cls2 == null) {
            declaredMethod = null;
        } else {
            try {
                declaredMethod = cls2.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
                declaredMethod.setAccessible(true);
            } catch (Throwable unused4) {
            }
        }
        f1834b = declaredMethod;
        Class cls3 = f1833a;
        if (cls3 != null) {
            try {
                Method declaredMethod2 = cls3.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
                declaredMethod2.setAccessible(true);
                method = declaredMethod2;
            } catch (Throwable unused5) {
            }
        }
        f1835c = method;
    }
}
