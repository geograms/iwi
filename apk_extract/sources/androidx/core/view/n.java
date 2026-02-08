package androidx.core.view;

import android.view.DisplayCutout;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final DisplayCutout f187a;

    public n(DisplayCutout displayCutout) {
        this.f187a = displayCutout;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        return q.b.a(this.f187a, ((n) obj).f187a);
    }

    public final int hashCode() {
        DisplayCutout displayCutout = this.f187a;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f187a + "}";
    }
}
