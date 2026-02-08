package com.google.android.material.resources;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import com.google.android.material.R;

/* loaded from: classes.dex */
public class MaterialAttributes {
    public static TypedValue resolve(Context context, int i2) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i2, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean resolveBoolean(Context context, int i2, boolean z2) {
        TypedValue typedValueResolve = resolve(context, i2);
        return (typedValueResolve == null || typedValueResolve.type != 18) ? z2 : typedValueResolve.data != 0;
    }

    public static boolean resolveBooleanOrThrow(Context context, int i2, String str) {
        return resolveOrThrow(context, i2, str) != 0;
    }

    public static int resolveDimension(Context context, int i2, int i3) {
        TypedValue typedValueResolve = resolve(context, i2);
        return (int) ((typedValueResolve == null || typedValueResolve.type != 5) ? context.getResources().getDimension(i3) : typedValueResolve.getDimension(context.getResources().getDisplayMetrics()));
    }

    public static int resolveInteger(Context context, int i2, int i3) {
        TypedValue typedValueResolve = resolve(context, i2);
        return (typedValueResolve == null || typedValueResolve.type != 16) ? i3 : typedValueResolve.data;
    }

    public static int resolveMinimumAccessibleTouchTarget(Context context) {
        return resolveDimension(context, R.attr.minTouchTargetSize, R.dimen.mtrl_min_touch_target_size);
    }

    public static int resolveOrThrow(Context context, int i2, String str) {
        return resolveTypedValueOrThrow(context, i2, str).data;
    }

    public static TypedValue resolveTypedValueOrThrow(View view, int i2) {
        return resolveTypedValueOrThrow(view.getContext(), i2, view.getClass().getCanonicalName());
    }

    public static int resolveOrThrow(View view, int i2) {
        return resolveTypedValueOrThrow(view, i2).data;
    }

    public static TypedValue resolveTypedValueOrThrow(Context context, int i2, String str) {
        TypedValue typedValueResolve = resolve(context, i2);
        if (typedValueResolve != null) {
            return typedValueResolve;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i2)));
    }
}
