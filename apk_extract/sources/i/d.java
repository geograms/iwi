package i;

import android.content.Context;

/* loaded from: classes.dex */
public abstract class d {
    public static int a(Context context, int i2) {
        return context.getColor(i2);
    }

    public static <T> T b(Context context, Class<T> cls) {
        return (T) context.getSystemService(cls);
    }

    public static String c(Context context, Class<?> cls) {
        return context.getSystemServiceName(cls);
    }
}
