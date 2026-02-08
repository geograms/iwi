package s0;

import android.content.SharedPreferences;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public static final Method f2547a;

    static {
        Method method;
        try {
            method = SharedPreferences.Editor.class.getMethod("apply", new Class[0]);
        } catch (NoSuchMethodException unused) {
            method = null;
        }
        f2547a = method;
    }

    public static void a(SharedPreferences.Editor editor) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Method method = f2547a;
            if (method != null) {
                method.invoke(editor, new Object[0]);
                return;
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
        }
        editor.commit();
    }
}
