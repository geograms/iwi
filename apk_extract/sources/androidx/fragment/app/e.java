package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

/* loaded from: classes.dex */
public final class e implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f481a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f482b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f483c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f484d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f485e;

    public e(ViewGroup viewGroup, Fragment fragment, n0 n0Var, n.d dVar) {
        this.f482b = viewGroup;
        this.f483c = fragment;
        this.f484d = n0Var;
        this.f485e = dVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        int i2 = this.f481a;
        ViewGroup viewGroup = this.f482b;
        switch (i2) {
            case 0:
                viewGroup.post(new d0(1, this));
                break;
            default:
                viewGroup.post(new d0(0, this));
                break;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }

    public e(View view, ViewGroup viewGroup, i iVar, l lVar) {
        this.f485e = lVar;
        this.f482b = viewGroup;
        this.f483c = view;
        this.f484d = iVar;
    }
}
