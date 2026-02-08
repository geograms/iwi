package com.google.android.material.internal;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.p1;
import androidx.core.view.q1;
import androidx.core.view.u2;
import com.google.android.material.color.MaterialColors;

/* loaded from: classes.dex */
public class EdgeToEdgeUtils {
    private static final int EDGE_TO_EDGE_BAR_ALPHA = 128;

    private EdgeToEdgeUtils() {
    }

    public static void applyEdgeToEdge(Window window, boolean z2) {
        applyEdgeToEdge(window, z2, null, null);
    }

    @TargetApi(ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT)
    private static int getNavigationBarColor(Context context, boolean z2) {
        if (z2) {
            return 0;
        }
        return MaterialColors.getColor(context, R.attr.navigationBarColor, -16777216);
    }

    @TargetApi(ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT)
    private static int getStatusBarColor(Context context, boolean z2) {
        if (z2) {
            return 0;
        }
        return MaterialColors.getColor(context, R.attr.statusBarColor, -16777216);
    }

    private static boolean isUsingLightSystemBar(int i2, boolean z2) {
        return MaterialColors.isColorLight(i2) || (i2 == 0 && z2);
    }

    public static void setLightNavigationBar(Window window, boolean z2) {
        new u2(window, window.getDecorView()).f218a.l(z2);
    }

    public static void setLightStatusBar(Window window, boolean z2) {
        new u2(window, window.getDecorView()).f218a.m(z2);
    }

    public static void applyEdgeToEdge(Window window, boolean z2, Integer num, Integer num2) {
        boolean z3 = true;
        boolean z4 = num == null || num.intValue() == 0;
        if (num2 != null && num2.intValue() != 0) {
            z3 = false;
        }
        if (z4 || z3) {
            int color = MaterialColors.getColor(window.getContext(), R.attr.colorBackground, -16777216);
            if (z4) {
                num = Integer.valueOf(color);
            }
            if (z3) {
                num2 = Integer.valueOf(color);
            }
        }
        boolean z5 = !z2;
        if (Build.VERSION.SDK_INT >= 30) {
            q1.a(window, z5);
        } else {
            p1.a(window, z5);
        }
        int statusBarColor = getStatusBarColor(window.getContext(), z2);
        int navigationBarColor = getNavigationBarColor(window.getContext(), z2);
        window.setStatusBarColor(statusBarColor);
        window.setNavigationBarColor(navigationBarColor);
        setLightStatusBar(window, isUsingLightSystemBar(statusBarColor, MaterialColors.isColorLight(num.intValue())));
        setLightNavigationBar(window, isUsingLightSystemBar(navigationBarColor, MaterialColors.isColorLight(num2.intValue())));
    }
}
