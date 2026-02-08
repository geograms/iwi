package androidx.appcompat.content.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ResourceManagerInternal;
import i.e;

@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public final class AppCompatResources {
    private AppCompatResources() {
    }

    public static ColorStateList getColorStateList(Context context, int i2) {
        return e.b(context, i2);
    }

    public static Drawable getDrawable(Context context, int i2) {
        return ResourceManagerInternal.get().getDrawable(context, i2);
    }
}
