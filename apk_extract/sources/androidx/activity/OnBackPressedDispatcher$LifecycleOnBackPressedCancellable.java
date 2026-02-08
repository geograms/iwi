package androidx.activity;

import androidx.fragment.app.o0;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayDeque;

/* loaded from: classes.dex */
class OnBackPressedDispatcher$LifecycleOnBackPressedCancellable implements LifecycleEventObserver, a {

    /* renamed from: a, reason: collision with root package name */
    public final Lifecycle f13a;

    /* renamed from: b, reason: collision with root package name */
    public final o0 f14b;

    /* renamed from: c, reason: collision with root package name */
    public j f15c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ k f16d;

    public OnBackPressedDispatcher$LifecycleOnBackPressedCancellable(k kVar, Lifecycle lifecycle, o0 o0Var) {
        this.f16d = kVar;
        this.f13a = lifecycle;
        this.f14b = o0Var;
        lifecycle.addObserver(this);
    }

    @Override // androidx.activity.a
    public final void cancel() {
        this.f13a.removeObserver(this);
        this.f14b.f579b.remove(this);
        j jVar = this.f15c;
        if (jVar != null) {
            jVar.cancel();
            this.f15c = null;
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_START) {
            k kVar = this.f16d;
            ArrayDeque arrayDeque = kVar.f32b;
            o0 o0Var = this.f14b;
            arrayDeque.add(o0Var);
            j jVar = new j(kVar, o0Var);
            o0Var.f579b.add(jVar);
            this.f15c = jVar;
            return;
        }
        if (event != Lifecycle.Event.ON_STOP) {
            if (event == Lifecycle.Event.ON_DESTROY) {
                cancel();
            }
        } else {
            j jVar2 = this.f15c;
            if (jVar2 != null) {
                jVar2.cancel();
            }
        }
    }
}
