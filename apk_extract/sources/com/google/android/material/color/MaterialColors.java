package com.google.android.material.color;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import com.google.android.material.R;
import com.google.android.material.color.utilities.Blend;
import com.google.android.material.color.utilities.Hct;
import com.google.android.material.resources.MaterialAttributes;
import i.e;
import k.d;

/* loaded from: classes.dex */
public class MaterialColors {
    public static final float ALPHA_DISABLED = 0.38f;
    public static final float ALPHA_DISABLED_LOW = 0.12f;
    public static final float ALPHA_FULL = 1.0f;
    public static final float ALPHA_LOW = 0.32f;
    public static final float ALPHA_MEDIUM = 0.54f;
    private static final int TONE_ACCENT_CONTAINER_DARK = 30;
    private static final int TONE_ACCENT_CONTAINER_LIGHT = 90;
    private static final int TONE_ACCENT_DARK = 80;
    private static final int TONE_ACCENT_LIGHT = 40;
    private static final int TONE_ON_ACCENT_CONTAINER_DARK = 90;
    private static final int TONE_ON_ACCENT_CONTAINER_LIGHT = 10;
    private static final int TONE_ON_ACCENT_DARK = 20;
    private static final int TONE_ON_ACCENT_LIGHT = 100;

    private MaterialColors() {
    }

    public static int compositeARGBWithAlpha(int i2, int i3) {
        return d.e(i2, (Color.alpha(i2) * i3) / 255);
    }

    public static int getColor(View view, int i2) {
        return resolveColor(view.getContext(), MaterialAttributes.resolveTypedValueOrThrow(view, i2));
    }

    private static int getColorRole(int i2, int i3) {
        Hct hctFromInt = Hct.fromInt(i2);
        hctFromInt.setTone(i3);
        return hctFromInt.toInt();
    }

    public static ColorRoles getColorRoles(Context context, int i2) {
        return getColorRoles(i2, MaterialAttributes.resolveBoolean(context, R.attr.isLightTheme, true));
    }

    public static ColorStateList getColorStateList(Context context, int i2, ColorStateList colorStateList) {
        TypedValue typedValueResolve = MaterialAttributes.resolve(context, i2);
        ColorStateList colorStateListResolveColorStateList = typedValueResolve != null ? resolveColorStateList(context, typedValueResolve) : null;
        return colorStateListResolveColorStateList == null ? colorStateList : colorStateListResolveColorStateList;
    }

    public static ColorStateList getColorStateListOrNull(Context context, int i2) {
        TypedValue typedValueResolve = MaterialAttributes.resolve(context, i2);
        if (typedValueResolve == null) {
            return null;
        }
        int i3 = typedValueResolve.resourceId;
        if (i3 != 0) {
            return e.b(context, i3);
        }
        int i4 = typedValueResolve.data;
        if (i4 != 0) {
            return ColorStateList.valueOf(i4);
        }
        return null;
    }

    public static int harmonize(int i2, int i3) {
        return Blend.harmonize(i2, i3);
    }

    public static int harmonizeWithPrimary(Context context, int i2) {
        return harmonize(i2, getColor(context, R.attr.colorPrimary, MaterialColors.class.getCanonicalName()));
    }

    public static boolean isColorLight(int i2) {
        boolean z2;
        if (i2 != 0) {
            ThreadLocal threadLocal = d.f1924a;
            double[] dArr = (double[]) threadLocal.get();
            if (dArr == null) {
                dArr = new double[3];
                threadLocal.set(dArr);
            }
            int iRed = Color.red(i2);
            int iGreen = Color.green(i2);
            int iBlue = Color.blue(i2);
            if (dArr.length != 3) {
                throw new IllegalArgumentException("outXyz must have a length of 3.");
            }
            double d2 = iRed / 255.0d;
            double dPow = d2 < 0.04045d ? d2 / 12.92d : Math.pow((d2 + 0.055d) / 1.055d, 2.4d);
            double d3 = iGreen / 255.0d;
            double dPow2 = d3 < 0.04045d ? d3 / 12.92d : Math.pow((d3 + 0.055d) / 1.055d, 2.4d);
            double d4 = iBlue / 255.0d;
            double dPow3 = d4 < 0.04045d ? d4 / 12.92d : Math.pow((d4 + 0.055d) / 1.055d, 2.4d);
            z2 = false;
            dArr[0] = ((0.1805d * dPow3) + (0.3576d * dPow2) + (0.4124d * dPow)) * 100.0d;
            double d5 = ((0.0722d * dPow3) + (0.7152d * dPow2) + (0.2126d * dPow)) * 100.0d;
            dArr[1] = d5;
            dArr[2] = ((dPow3 * 0.9505d) + (dPow2 * 0.1192d) + (dPow * 0.0193d)) * 100.0d;
            if (d5 / 100.0d > 0.5d) {
                return true;
            }
        } else {
            z2 = false;
        }
        return z2;
    }

    public static int layer(View view, int i2, int i3) {
        return layer(view, i2, i3, 1.0f);
    }

    private static int resolveColor(Context context, TypedValue typedValue) {
        int i2 = typedValue.resourceId;
        if (i2 == 0) {
            return typedValue.data;
        }
        Object obj = e.f1841a;
        return i.d.a(context, i2);
    }

    private static ColorStateList resolveColorStateList(Context context, TypedValue typedValue) {
        int i2 = typedValue.resourceId;
        return i2 != 0 ? e.b(context, i2) : ColorStateList.valueOf(typedValue.data);
    }

    public static int layer(View view, int i2, int i3, float f2) {
        return layer(getColor(view, i2), getColor(view, i3), f2);
    }

    public static ColorRoles getColorRoles(int i2, boolean z2) {
        if (z2) {
            return new ColorRoles(getColorRole(i2, 40), getColorRole(i2, TONE_ON_ACCENT_LIGHT), getColorRole(i2, 90), getColorRole(i2, 10));
        }
        return new ColorRoles(getColorRole(i2, TONE_ACCENT_DARK), getColorRole(i2, 20), getColorRole(i2, 30), getColorRole(i2, 90));
    }

    public static int getColor(Context context, int i2, String str) {
        return resolveColor(context, MaterialAttributes.resolveTypedValueOrThrow(context, i2, str));
    }

    public static int layer(int i2, int i3, float f2) {
        return layer(i2, d.e(i3, Math.round(Color.alpha(i3) * f2)));
    }

    public static int getColor(View view, int i2, int i3) {
        return getColor(view.getContext(), i2, i3);
    }

    public static int getColor(Context context, int i2, int i3) {
        TypedValue typedValueResolve = MaterialAttributes.resolve(context, i2);
        return typedValueResolve != null ? resolveColor(context, typedValueResolve) : i3;
    }

    public static int layer(int i2, int i3) {
        return d.c(i3, i2);
    }
}
