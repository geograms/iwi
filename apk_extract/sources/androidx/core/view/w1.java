package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import androidx.core.R$id;
import java.util.List;

/* loaded from: classes.dex */
public final class w1 extends a2 {
    public static void e(View view, b2 b2Var) {
        s1 s1VarJ = j(view);
        if (s1VarJ != null) {
            s1VarJ.onEnd(b2Var);
            if (s1VarJ.getDispatchMode() == 0) {
                return;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                e(viewGroup.getChildAt(i2), b2Var);
            }
        }
    }

    public static void f(View view, b2 b2Var, WindowInsets windowInsets, boolean z2) {
        s1 s1VarJ = j(view);
        if (s1VarJ != null) {
            s1VarJ.mDispachedInsets = windowInsets;
            if (!z2) {
                s1VarJ.onPrepare(b2Var);
                z2 = s1VarJ.getDispatchMode() == 0;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                f(viewGroup.getChildAt(i2), b2Var, windowInsets, z2);
            }
        }
    }

    public static void g(View view, n2 n2Var, List list) {
        s1 s1VarJ = j(view);
        if (s1VarJ != null) {
            n2Var = s1VarJ.onProgress(n2Var, list);
            if (s1VarJ.getDispatchMode() == 0) {
                return;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                g(viewGroup.getChildAt(i2), n2Var, list);
            }
        }
    }

    public static void h(View view, b2 b2Var, r1 r1Var) {
        s1 s1VarJ = j(view);
        if (s1VarJ != null) {
            s1VarJ.onStart(b2Var, r1Var);
            if (s1VarJ.getDispatchMode() == 0) {
                return;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                h(viewGroup.getChildAt(i2), b2Var, r1Var);
            }
        }
    }

    public static WindowInsets i(View view, WindowInsets windowInsets) {
        return view.getTag(R$id.tag_on_apply_window_listener) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
    }

    public static s1 j(View view) {
        Object tag = view.getTag(R$id.tag_window_insets_animation_callback);
        if (tag instanceof v1) {
            return ((v1) tag).f219a;
        }
        return null;
    }
}
