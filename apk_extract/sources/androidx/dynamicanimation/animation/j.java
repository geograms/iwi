package androidx.dynamicanimation.animation;

import android.util.FloatProperty;

/* loaded from: classes.dex */
public abstract class j {
    final String mPropertyName;

    public j(String str) {
        this.mPropertyName = str;
    }

    public static <T> j createFloatPropertyCompat(FloatProperty<T> floatProperty) {
        return new i(floatProperty.getName(), floatProperty);
    }

    public abstract float getValue(Object obj);

    public abstract void setValue(Object obj, float f2);
}
