package androidx.fragment.app;

import android.view.View;

/* loaded from: classes.dex */
public final class s extends i0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Fragment f598a;

    public s(Fragment fragment) {
        this.f598a = fragment;
    }

    @Override // androidx.fragment.app.i0
    public final View b(int i2) {
        Fragment fragment = this.f598a;
        View view = fragment.mView;
        if (view != null) {
            return view.findViewById(i2);
        }
        throw new IllegalStateException("Fragment " + fragment + " does not have a view");
    }

    @Override // androidx.fragment.app.i0
    public final boolean c() {
        return this.f598a.mView != null;
    }
}
