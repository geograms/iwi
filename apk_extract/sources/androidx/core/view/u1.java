package androidx.core.view;

import android.animation.ValueAnimator;
import android.view.View;

/* loaded from: classes.dex */
public final class u1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f214a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b2 f215b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r1 f216c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f217d;

    public u1(View view, b2 b2Var, r1 r1Var, ValueAnimator valueAnimator) {
        this.f214a = view;
        this.f215b = b2Var;
        this.f216c = r1Var;
        this.f217d = valueAnimator;
    }

    @Override // java.lang.Runnable
    public final void run() {
        w1.h(this.f214a, this.f215b, this.f216c);
        this.f217d.start();
    }
}
