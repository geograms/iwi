package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public final class c2 extends m1 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f758a = false;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s0 f759b;

    public c2(s0 s0Var) {
        this.f759b = s0Var;
    }

    @Override // androidx.recyclerview.widget.m1
    public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        if (i2 == 0 && this.f758a) {
            this.f758a = false;
            this.f759b.f();
        }
    }

    @Override // androidx.recyclerview.widget.m1
    public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return;
        }
        this.f758a = true;
    }
}
