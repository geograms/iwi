package androidx.core.view;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class i2 extends h2 {
    public i2(n2 n2Var, WindowInsets windowInsets) {
        super(n2Var, windowInsets);
    }

    @Override // androidx.core.view.l2
    public n2 a() {
        return n2.g(null, this.f153c.consumeDisplayCutout());
    }

    @Override // androidx.core.view.l2
    public n e() {
        DisplayCutout displayCutout = this.f153c.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new n(displayCutout);
    }

    @Override // androidx.core.view.l2
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i2)) {
            return false;
        }
        i2 i2Var = (i2) obj;
        return Objects.equals(this.f153c, i2Var.f153c) && Objects.equals(this.f157g, i2Var.f157g);
    }

    @Override // androidx.core.view.l2
    public int hashCode() {
        return this.f153c.hashCode();
    }
}
