package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

/* loaded from: classes.dex */
public final class g0 extends AnimationSet implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f507a;

    /* renamed from: b, reason: collision with root package name */
    public final View f508b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f509c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f510d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f511e;

    public g0(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.f511e = true;
        this.f507a = viewGroup;
        this.f508b = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public final boolean getTransformation(long j2, Transformation transformation) {
        this.f511e = true;
        if (this.f509c) {
            return !this.f510d;
        }
        if (!super.getTransformation(j2, transformation)) {
            this.f509c = true;
            androidx.core.view.f0.a(this.f507a, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z2 = this.f509c;
        ViewGroup viewGroup = this.f507a;
        if (z2 || !this.f511e) {
            viewGroup.endViewTransition(this.f508b);
            this.f510d = true;
        } else {
            this.f511e = false;
            viewGroup.post(this);
        }
    }

    @Override // android.view.animation.Animation
    public final boolean getTransformation(long j2, Transformation transformation, float f2) {
        this.f511e = true;
        if (this.f509c) {
            return !this.f510d;
        }
        if (!super.getTransformation(j2, transformation, f2)) {
            this.f509c = true;
            androidx.core.view.f0.a(this.f507a, this);
        }
        return true;
    }
}
