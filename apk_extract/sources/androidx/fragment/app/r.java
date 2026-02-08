package androidx.fragment.app;

/* loaded from: classes.dex */
public final class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f591a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Fragment f592b;

    public /* synthetic */ r(Fragment fragment, int i2) {
        this.f591a = i2;
        this.f592b = fragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f591a;
        Fragment fragment = this.f592b;
        switch (i2) {
            case 0:
                fragment.startPostponedEnterTransition();
                break;
            default:
                fragment.callStartTransitionListener(false);
                break;
        }
    }
}
