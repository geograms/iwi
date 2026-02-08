package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class l0 implements View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f559a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e1 f560b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f561c;

    public l0(m0 m0Var, e1 e1Var) {
        this.f561c = m0Var;
        this.f560b = e1Var;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        int i2 = this.f559a;
        Object obj = this.f561c;
        switch (i2) {
            case 0:
                e1 e1Var = this.f560b;
                Fragment fragment = e1Var.f493c;
                e1Var.k();
                w1.g((ViewGroup) fragment.mView.getParent(), ((m0) obj).f565a).e();
                break;
            default:
                View view2 = (View) obj;
                view2.removeOnAttachStateChangeListener(this);
                WeakHashMap weakHashMap = androidx.core.view.d1.f138a;
                androidx.core.view.q0.c(view2);
                break;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }

    public l0(e1 e1Var, View view) {
        this.f560b = e1Var;
        this.f561c = view;
    }
}
