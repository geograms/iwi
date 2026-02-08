package androidx.core.view;

import android.graphics.Rect;
import android.view.Gravity;

/* loaded from: classes.dex */
public abstract class o {
    public static void a(int i2, int i3, int i4, Rect rect, int i5, int i6, Rect rect2, int i7) {
        Gravity.apply(i2, i3, i4, rect, i5, i6, rect2, i7);
    }

    public static void b(int i2, int i3, int i4, Rect rect, Rect rect2, int i5) {
        Gravity.apply(i2, i3, i4, rect, rect2, i5);
    }

    public static void c(int i2, Rect rect, Rect rect2, int i3) {
        Gravity.applyDisplay(i2, rect, rect2, i3);
    }
}
