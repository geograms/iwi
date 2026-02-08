package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;

/* loaded from: classes.dex */
public final class t2 extends c.c {

    /* renamed from: b, reason: collision with root package name */
    public final WindowInsetsController f209b;

    /* renamed from: c, reason: collision with root package name */
    public Window f210c;

    public t2(WindowInsetsController windowInsetsController) {
        this.f209b = windowInsetsController;
    }

    @Override // c.c
    public final void h() {
        this.f209b.hide(8);
    }

    @Override // c.c
    public final boolean i() {
        return (this.f209b.getSystemBarsAppearance() & 8) != 0;
    }

    @Override // c.c
    public final void l(boolean z2) {
        Window window = this.f210c;
        WindowInsetsController windowInsetsController = this.f209b;
        if (z2) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
            }
            windowInsetsController.setSystemBarsAppearance(16, 16);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-17));
        }
        windowInsetsController.setSystemBarsAppearance(0, 16);
    }

    @Override // c.c
    public final void m(boolean z2) {
        Window window = this.f210c;
        WindowInsetsController windowInsetsController = this.f209b;
        if (z2) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
            }
            windowInsetsController.setSystemBarsAppearance(8, 8);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-8193));
        }
        windowInsetsController.setSystemBarsAppearance(0, 8);
    }

    @Override // c.c
    public final void o() {
        Window window = this.f210c;
        if (window != null && Build.VERSION.SDK_INT < 32) {
            ((InputMethodManager) window.getContext().getSystemService("input_method")).isActive();
        }
        this.f209b.show(8);
    }
}
