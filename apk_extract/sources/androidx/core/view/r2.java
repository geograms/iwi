package androidx.core.view;

import android.view.Window;

/* loaded from: classes.dex */
public final class r2 extends q2 {
    @Override // c.c
    public final void l(boolean z2) {
        if (!z2) {
            r(16);
            return;
        }
        Window window = this.f192b;
        window.clearFlags(134217728);
        window.addFlags(Integer.MIN_VALUE);
        q(16);
    }
}
