package com.google.android.material.sidesheet;

/* loaded from: classes.dex */
final class SheetUtils {
    private SheetUtils() {
    }

    public static boolean isSwipeMostlyHorizontal(float f2, float f3) {
        return Math.abs(f2) > Math.abs(f3);
    }
}
