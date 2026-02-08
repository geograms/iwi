package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;

/* loaded from: classes.dex */
public final class z implements b0.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0 f687a;

    public z(c0 c0Var) {
        this.f687a = c0Var;
    }

    @Override // b0.d
    public final Bundle saveState() {
        Bundle bundle = new Bundle();
        c0 c0Var = this.f687a;
        c0Var.markFragmentsCreated();
        c0Var.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        y0 y0VarL = c0Var.mFragments.f547a.f556d.L();
        if (y0VarL != null) {
            bundle.putParcelable("android:support:fragments", y0VarL);
        }
        return bundle;
    }
}
