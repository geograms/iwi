package androidx.transition;

import android.view.View;
import android.view.WindowId;

/* loaded from: classes.dex */
public final class o0 implements p0 {

    /* renamed from: a, reason: collision with root package name */
    public final WindowId f1108a;

    public o0(View view) {
        this.f1108a = view.getWindowId();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof o0) && ((o0) obj).f1108a.equals(this.f1108a);
    }

    public final int hashCode() {
        return this.f1108a.hashCode();
    }
}
