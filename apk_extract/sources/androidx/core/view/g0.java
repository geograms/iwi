package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.PointerIcon;

/* loaded from: classes.dex */
public abstract class g0 {
    public static PointerIcon a(Bitmap bitmap, float f2, float f3) {
        return PointerIcon.create(bitmap, f2, f3);
    }

    public static PointerIcon b(Context context, int i2) {
        return PointerIcon.getSystemIcon(context, i2);
    }

    public static PointerIcon c(Resources resources, int i2) {
        return PointerIcon.load(resources, i2);
    }
}
