package androidx.core.view;

import android.view.View;
import androidx.core.R$id;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class x0 {
    public static void a(View view, c1 c1Var) {
        g.l lVar = (g.l) view.getTag(R$id.tag_unhandled_key_listeners);
        if (lVar == null) {
            lVar = new g.l();
            view.setTag(R$id.tag_unhandled_key_listeners, lVar);
        }
        Objects.requireNonNull(c1Var);
        View.OnUnhandledKeyEventListener w0Var = new w0();
        lVar.put(c1Var, w0Var);
        view.addOnUnhandledKeyEventListener(w0Var);
    }

    public static CharSequence b(View view) {
        return view.getAccessibilityPaneTitle();
    }

    public static boolean c(View view) {
        return view.isAccessibilityHeading();
    }

    public static boolean d(View view) {
        return view.isScreenReaderFocusable();
    }

    public static void e(View view, c1 c1Var) {
        View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
        g.l lVar = (g.l) view.getTag(R$id.tag_unhandled_key_listeners);
        if (lVar == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) lVar.getOrDefault(c1Var, null)) == null) {
            return;
        }
        view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
    }

    public static <T> T f(View view, int i2) {
        return (T) view.requireViewById(i2);
    }

    public static void g(View view, boolean z2) {
        view.setAccessibilityHeading(z2);
    }

    public static void h(View view, CharSequence charSequence) {
        view.setAccessibilityPaneTitle(charSequence);
    }

    public static void i(View view, boolean z2) {
        view.setScreenReaderFocusable(z2);
    }
}
