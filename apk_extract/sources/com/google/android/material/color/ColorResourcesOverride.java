package com.google.android.material.color;

import android.content.Context;
import android.os.Build;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public interface ColorResourcesOverride {
    static ColorResourcesOverride getInstance() {
        int i2 = Build.VERSION.SDK_INT;
        if (30 <= i2 && i2 <= 33) {
            return ResourcesLoaderColorResourcesOverride.getInstance();
        }
        if (i2 < 33) {
            return null;
        }
        String str = Build.VERSION.CODENAME;
        if ("REL".equals(str)) {
            return null;
        }
        Locale locale = Locale.ROOT;
        if (str.toUpperCase(locale).compareTo("UpsideDownCake".toUpperCase(locale)) >= 0) {
            return ResourcesLoaderColorResourcesOverride.getInstance();
        }
        return null;
    }

    boolean applyIfPossible(Context context, Map<Integer, Integer> map);

    Context wrapContextIfPossible(Context context, Map<Integer, Integer> map);
}
