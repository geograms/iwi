package androidx.recyclerview.widget;

import android.animation.ValueAnimator;

/* loaded from: classes.dex */
public final class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f973a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f974b;

    public /* synthetic */ v(int i2, Object obj) {
        this.f973a = i2;
        this.f974b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f973a;
        Object obj = this.f974b;
        switch (i2) {
            case 0:
                z zVar = (z) obj;
                int i3 = zVar.A;
                ValueAnimator valueAnimator = zVar.f1026z;
                if (i3 == 1) {
                    valueAnimator.cancel();
                } else if (i3 != 2) {
                }
                zVar.A = 3;
                valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
                valueAnimator.setDuration(500);
                valueAnimator.start();
                break;
            default:
                ((StaggeredGridLayoutManager) obj).e();
                break;
        }
    }
}
