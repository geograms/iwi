package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* loaded from: classes.dex */
public final class u2 {

    /* renamed from: a, reason: collision with root package name */
    public final c.c f218a;

    public u2(WindowInsetsController windowInsetsController) {
        this.f218a = new t2(windowInsetsController);
    }

    public u2(Window window, View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            t2 t2Var = new t2(window.getInsetsController());
            t2Var.f210c = window;
            this.f218a = t2Var;
            return;
        }
        this.f218a = new r2(window, view);
    }
}
