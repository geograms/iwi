package androidx.core.view;

import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class g1 {
    public static int a(ViewGroup viewGroup) {
        return viewGroup.getNestedScrollAxes();
    }

    public static boolean b(ViewGroup viewGroup) {
        return viewGroup.isTransitionGroup();
    }

    public static void c(ViewGroup viewGroup, boolean z2) {
        viewGroup.setTransitionGroup(z2);
    }
}
