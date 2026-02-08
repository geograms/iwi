package l;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public abstract class c {
    public static int a(Drawable drawable) {
        return drawable.getLayoutDirection();
    }

    public static boolean b(Drawable drawable, int i2) {
        return drawable.setLayoutDirection(i2);
    }
}
