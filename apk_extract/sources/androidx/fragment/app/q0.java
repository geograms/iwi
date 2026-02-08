package androidx.fragment.app;

/* loaded from: classes.dex */
public final class q0 implements b1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Fragment f590a;

    public q0(Fragment fragment) {
        this.f590a = fragment;
    }

    @Override // androidx.fragment.app.b1
    public final void a(Fragment fragment) {
        this.f590a.onAttachFragment(fragment);
    }
}
