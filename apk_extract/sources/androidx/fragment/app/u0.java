package androidx.fragment.app;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class u0 implements t0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f613a;

    /* renamed from: b, reason: collision with root package name */
    public final int f614b = 1;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w0 f615c;

    public u0(w0 w0Var, int i2) {
        this.f615c = w0Var;
        this.f613a = i2;
    }

    @Override // androidx.fragment.app.t0
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        Fragment fragment = this.f615c.f665s;
        if (fragment == null || this.f613a >= 0 || !fragment.getChildFragmentManager().G()) {
            return this.f615c.H(arrayList, arrayList2, null, this.f613a, this.f614b);
        }
        return false;
    }
}
