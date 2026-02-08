package b0;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.Recreator;
import java.util.Map;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final g f1218a;

    /* renamed from: b, reason: collision with root package name */
    public final e f1219b = new e();

    /* renamed from: c, reason: collision with root package name */
    public boolean f1220c;

    public f(g gVar) {
        this.f1218a = gVar;
    }

    public final void a() {
        g gVar = this.f1218a;
        Lifecycle lifecycle = gVar.getLifecycle();
        x0.g.t(lifecycle, "owner.lifecycle");
        if (lifecycle.getCurrentState() != Lifecycle.State.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
        }
        lifecycle.addObserver(new Recreator(gVar));
        final e eVar = this.f1219b;
        eVar.getClass();
        if (!(!eVar.f1213b)) {
            throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
        }
        lifecycle.addObserver(new LifecycleEventObserver() { // from class: b0.b
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                e eVar2 = eVar;
                x0.g.u(eVar2, "this$0");
                x0.g.u(lifecycleOwner, "<anonymous parameter 0>");
                x0.g.u(event, "event");
                if (event == Lifecycle.Event.ON_START) {
                    eVar2.f1217f = true;
                } else if (event == Lifecycle.Event.ON_STOP) {
                    eVar2.f1217f = false;
                }
            }
        });
        eVar.f1213b = true;
        this.f1220c = true;
    }

    public final void b(Bundle bundle) {
        if (!this.f1220c) {
            a();
        }
        Lifecycle lifecycle = this.f1218a.getLifecycle();
        x0.g.t(lifecycle, "owner.lifecycle");
        if (!(!lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED))) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.getCurrentState()).toString());
        }
        e eVar = this.f1219b;
        if (!eVar.f1213b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        }
        if (!(!eVar.f1215d)) {
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
        eVar.f1214c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        eVar.f1215d = true;
    }

    public final void c(Bundle bundle) {
        x0.g.u(bundle, "outBundle");
        e eVar = this.f1219b;
        eVar.getClass();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = eVar.f1214c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        e.g gVar = eVar.f1212a;
        gVar.getClass();
        e.d dVar = new e.d(gVar);
        gVar.f1751c.put(dVar, Boolean.FALSE);
        while (dVar.hasNext()) {
            Map.Entry entry = (Map.Entry) dVar.next();
            bundle2.putBundle((String) entry.getKey(), ((d) entry.getValue()).saveState());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
