package androidx.core.view;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public abstract class c2 {

    /* renamed from: a, reason: collision with root package name */
    public static final Field f134a;

    /* renamed from: b, reason: collision with root package name */
    public static final Field f135b;

    /* renamed from: c, reason: collision with root package name */
    public static final Field f136c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f137d;

    static {
        try {
            Field declaredField = View.class.getDeclaredField("mAttachInfo");
            f134a = declaredField;
            declaredField.setAccessible(true);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            Field declaredField2 = cls.getDeclaredField("mStableInsets");
            f135b = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("mContentInsets");
            f136c = declaredField3;
            declaredField3.setAccessible(true);
            f137d = true;
        } catch (ReflectiveOperationException e2) {
            Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e2.getMessage(), e2);
        }
    }
}
