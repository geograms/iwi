package androidx.core.view;

import android.R;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.constraintlayout.solver.widgets.Optimizer;

/* loaded from: classes.dex */
public abstract class p2 extends c.c {

    /* renamed from: b, reason: collision with root package name */
    public final Window f192b;

    /* renamed from: c, reason: collision with root package name */
    public final View f193c;

    public p2(Window window, View view) {
        super(2);
        this.f192b = window;
        this.f193c = view;
    }

    @Override // c.c
    public final void h() {
        for (int i2 = 1; i2 <= 256; i2 <<= 1) {
            if ((8 & i2) != 0) {
                if (i2 == 1) {
                    q(4);
                } else if (i2 == 2) {
                    q(2);
                } else if (i2 == 8) {
                    Window window = this.f192b;
                    ((InputMethodManager) window.getContext().getSystemService("input_method")).hideSoftInputFromWindow(window.getDecorView().getWindowToken(), 0);
                }
            }
        }
    }

    @Override // c.c
    public final void o() {
        for (int i2 = 1; i2 <= 256; i2 <<= 1) {
            if ((8 & i2) != 0) {
                Window window = this.f192b;
                if (i2 == 1) {
                    r(4);
                    window.clearFlags(Optimizer.OPTIMIZATION_GROUPING);
                } else if (i2 == 2) {
                    r(2);
                } else if (i2 == 8) {
                    View viewFindViewById = this.f193c;
                    if (viewFindViewById.isInEditMode() || viewFindViewById.onCheckIsTextEditor()) {
                        viewFindViewById.requestFocus();
                    } else {
                        viewFindViewById = window.getCurrentFocus();
                    }
                    if (viewFindViewById == null) {
                        viewFindViewById = window.findViewById(R.id.content);
                    }
                    if (viewFindViewById != null && viewFindViewById.hasWindowFocus()) {
                        viewFindViewById.post(new o2(0, viewFindViewById));
                    }
                }
            }
        }
    }

    public final void q(int i2) {
        View decorView = this.f192b.getDecorView();
        decorView.setSystemUiVisibility(i2 | decorView.getSystemUiVisibility());
    }

    public final void r(int i2) {
        View decorView = this.f192b.getDecorView();
        decorView.setSystemUiVisibility((~i2) & decorView.getSystemUiVisibility());
    }
}
