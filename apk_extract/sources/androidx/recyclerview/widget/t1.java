package androidx.recyclerview.widget;

import android.util.Log;
import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public final class t1 {

    /* renamed from: a, reason: collision with root package name */
    public int f964a;

    /* renamed from: b, reason: collision with root package name */
    public int f965b;

    /* renamed from: c, reason: collision with root package name */
    public int f966c;

    /* renamed from: d, reason: collision with root package name */
    public int f967d;

    /* renamed from: e, reason: collision with root package name */
    public Interpolator f968e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f969f;

    /* renamed from: g, reason: collision with root package name */
    public int f970g;

    public final void a(RecyclerView recyclerView) {
        int i2 = this.f967d;
        if (i2 >= 0) {
            this.f967d = -1;
            recyclerView.jumpToPositionForSmoothScroller(i2);
            this.f969f = false;
            return;
        }
        if (!this.f969f) {
            this.f970g = 0;
            return;
        }
        Interpolator interpolator = this.f968e;
        if (interpolator != null && this.f966c < 1) {
            throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        }
        int i3 = this.f966c;
        if (i3 < 1) {
            throw new IllegalStateException("Scroll duration must be a positive number");
        }
        recyclerView.mViewFlinger.b(this.f964a, this.f965b, interpolator, i3);
        int i4 = this.f970g + 1;
        this.f970g = i4;
        if (i4 > 10) {
            Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
        }
        this.f969f = false;
    }
}
