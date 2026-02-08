package androidx.core.view;

import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public abstract class p1 {
    public static void a(Window window, boolean z2) {
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility(z2 ? systemUiVisibility & (-1793) : systemUiVisibility | 1792);
    }
}
