package p0;

import android.os.CountDownTimer;
import android.util.Log;

/* loaded from: classes.dex */
public final class m0 extends CountDownTimer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2364a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o0 f2365b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(o0 o0Var, long j2, int i2) {
        super(j2, 1000L);
        this.f2365b = o0Var;
        this.f2364a = i2;
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        Log.d("FragmentPtt", " onFinish 1274: ");
        this.f2365b.n();
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long j2) {
        this.f2365b.f2396x.setProgress(100 - ((((int) j2) * 100) / this.f2364a));
    }
}
