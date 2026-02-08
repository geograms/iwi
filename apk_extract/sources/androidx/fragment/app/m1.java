package androidx.fragment.app;

import android.transition.Transition;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class m1 implements Transition.TransitionListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f566a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f567b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f568c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ArrayList f569d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f570e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ArrayList f571f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ o1 f572g;

    public m1(o1 o1Var, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
        this.f572g = o1Var;
        this.f566a = obj;
        this.f567b = arrayList;
        this.f568c = obj2;
        this.f569d = arrayList2;
        this.f570e = obj3;
        this.f571f = arrayList3;
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition transition) {
        o1 o1Var = this.f572g;
        Object obj = this.f566a;
        if (obj != null) {
            o1Var.v(obj, this.f567b, null);
        }
        Object obj2 = this.f568c;
        if (obj2 != null) {
            o1Var.v(obj2, this.f569d, null);
        }
        Object obj3 = this.f570e;
        if (obj3 != null) {
            o1Var.v(obj3, this.f571f, null);
        }
    }
}
