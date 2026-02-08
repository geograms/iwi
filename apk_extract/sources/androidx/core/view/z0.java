package androidx.core.view;

import android.view.View;
import android.view.WindowInsetsController;

/* loaded from: classes.dex */
public abstract class z0 {
    public static CharSequence a(View view) {
        return view.getStateDescription();
    }

    public static u2 b(View view) {
        WindowInsetsController windowInsetsController = view.getWindowInsetsController();
        if (windowInsetsController != null) {
            return new u2(windowInsetsController);
        }
        return null;
    }

    public static void c(View view, CharSequence charSequence) {
        view.setStateDescription(charSequence);
    }
}
