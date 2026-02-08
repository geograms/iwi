package androidx.core.view;

import android.view.Window;

/* loaded from: classes.dex */
public abstract class q2 extends p2 {
    @Override // c.c
    public final boolean i() {
        return (this.f192b.getDecorView().getSystemUiVisibility() & 8192) != 0;
    }

    @Override // c.c
    public final void m(boolean z2) {
        if (!z2) {
            r(8192);
            return;
        }
        Window window = this.f192b;
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        q(8192);
    }
}
