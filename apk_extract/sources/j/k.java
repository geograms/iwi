package j;

import android.content.res.ColorStateList;
import android.content.res.Resources;

/* loaded from: classes.dex */
public abstract class k {
    public static int a(Resources resources, int i2, Resources.Theme theme) {
        return resources.getColor(i2, theme);
    }

    public static ColorStateList b(Resources resources, int i2, Resources.Theme theme) {
        return resources.getColorStateList(i2, theme);
    }
}
