package androidx.core.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeProvider;

/* loaded from: classes.dex */
public abstract class m0 {
    public static AccessibilityNodeProvider a(View view) {
        return view.getAccessibilityNodeProvider();
    }

    public static boolean b(View view) {
        return view.getFitsSystemWindows();
    }

    public static int c(View view) {
        return view.getImportantForAccessibility();
    }

    public static int d(View view) {
        return view.getMinimumHeight();
    }

    public static int e(View view) {
        return view.getMinimumWidth();
    }

    public static ViewParent f(View view) {
        return view.getParentForAccessibility();
    }

    public static int g(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static boolean h(View view) {
        return view.hasOverlappingRendering();
    }

    public static boolean i(View view) {
        return view.hasTransientState();
    }

    public static boolean j(View view, int i2, Bundle bundle) {
        return view.performAccessibilityAction(i2, bundle);
    }

    public static void k(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void l(View view, int i2, int i3, int i4, int i5) {
        view.postInvalidateOnAnimation(i2, i3, i4, i5);
    }

    public static void m(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void n(View view, Runnable runnable, long j2) {
        view.postOnAnimationDelayed(runnable, j2);
    }

    public static void o(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public static void p(View view) {
        view.requestFitSystemWindows();
    }

    public static void q(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static void r(View view, boolean z2) {
        view.setHasTransientState(z2);
    }

    public static void s(View view, int i2) {
        view.setImportantForAccessibility(i2);
    }
}
