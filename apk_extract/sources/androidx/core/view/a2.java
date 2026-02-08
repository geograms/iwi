package androidx.core.view;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public abstract class a2 {

    /* renamed from: a, reason: collision with root package name */
    public final int f126a;

    /* renamed from: b, reason: collision with root package name */
    public float f127b;

    /* renamed from: c, reason: collision with root package name */
    public final Interpolator f128c;

    /* renamed from: d, reason: collision with root package name */
    public final long f129d;

    public a2(int i2, DecelerateInterpolator decelerateInterpolator, long j2) {
        this.f126a = i2;
        this.f128c = decelerateInterpolator;
        this.f129d = j2;
    }

    public long a() {
        return this.f129d;
    }

    public float b() {
        Interpolator interpolator = this.f128c;
        return interpolator != null ? interpolator.getInterpolation(this.f127b) : this.f127b;
    }

    public int c() {
        return this.f126a;
    }

    public void d(float f2) {
        this.f127b = f2;
    }
}
