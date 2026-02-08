package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public final class w1 {

    /* renamed from: a, reason: collision with root package name */
    public int f976a;

    /* renamed from: b, reason: collision with root package name */
    public int f977b;

    /* renamed from: c, reason: collision with root package name */
    public int f978c;

    /* renamed from: d, reason: collision with root package name */
    public int f979d;

    /* renamed from: e, reason: collision with root package name */
    public int f980e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f981f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f982g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f983h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f984i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f985j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f986k;

    /* renamed from: l, reason: collision with root package name */
    public int f987l;

    /* renamed from: m, reason: collision with root package name */
    public long f988m;

    /* renamed from: n, reason: collision with root package name */
    public int f989n;

    public final void a(int i2) {
        if ((this.f979d & i2) != 0) {
            return;
        }
        throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i2) + " but it is " + Integer.toBinaryString(this.f979d));
    }

    public final int b() {
        return this.f982g ? this.f977b - this.f978c : this.f980e;
    }

    public final String toString() {
        return "State{mTargetPosition=" + this.f976a + ", mData=null, mItemCount=" + this.f980e + ", mIsMeasuring=" + this.f984i + ", mPreviousLayoutItemCount=" + this.f977b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f978c + ", mStructureChanged=" + this.f981f + ", mInPreLayout=" + this.f982g + ", mRunSimpleAnimations=" + this.f985j + ", mRunPredictiveAnimations=" + this.f986k + '}';
    }
}
