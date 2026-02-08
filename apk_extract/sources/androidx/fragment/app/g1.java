package androidx.fragment.app;

import androidx.lifecycle.Lifecycle;

/* loaded from: classes.dex */
public final class g1 {

    /* renamed from: a, reason: collision with root package name */
    public int f512a;

    /* renamed from: b, reason: collision with root package name */
    public Fragment f513b;

    /* renamed from: c, reason: collision with root package name */
    public int f514c;

    /* renamed from: d, reason: collision with root package name */
    public int f515d;

    /* renamed from: e, reason: collision with root package name */
    public int f516e;

    /* renamed from: f, reason: collision with root package name */
    public int f517f;

    /* renamed from: g, reason: collision with root package name */
    public Lifecycle.State f518g;

    /* renamed from: h, reason: collision with root package name */
    public Lifecycle.State f519h;

    public g1(Fragment fragment, int i2) {
        this.f512a = i2;
        this.f513b = fragment;
        Lifecycle.State state = Lifecycle.State.RESUMED;
        this.f518g = state;
        this.f519h = state;
    }
}
