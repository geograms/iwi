package androidx.core.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f211a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f212b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f213c = new HashMap();

    public u(Runnable runnable) {
        this.f211a = runnable;
    }

    public final void a(LifecycleOwner lifecycleOwner) {
        this.f212b.add(null);
        this.f211a.run();
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        HashMap map = this.f213c;
        t tVar = (t) map.remove(null);
        if (tVar != null) {
            tVar.f202a.removeObserver(tVar.f203b);
            tVar.f203b = null;
        }
        map.put(null, new t(lifecycle, new LifecycleEventObserver() { // from class: androidx.core.view.r
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                u uVar = this.f194a;
                uVar.getClass();
                if (event == Lifecycle.Event.ON_DESTROY) {
                    uVar.c();
                }
            }
        }));
    }

    public final void b(LifecycleOwner lifecycleOwner, final Lifecycle.State state) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        HashMap map = this.f213c;
        t tVar = (t) map.remove(null);
        if (tVar != null) {
            tVar.f202a.removeObserver(tVar.f203b);
            tVar.f203b = null;
        }
        map.put(null, new t(lifecycle, new LifecycleEventObserver() { // from class: androidx.core.view.s
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                u uVar = this.f200a;
                uVar.getClass();
                Lifecycle.State state2 = state;
                Lifecycle.Event eventUpTo = Lifecycle.Event.upTo(state2);
                Runnable runnable = uVar.f211a;
                CopyOnWriteArrayList copyOnWriteArrayList = uVar.f212b;
                if (event == eventUpTo) {
                    copyOnWriteArrayList.add(null);
                    runnable.run();
                } else if (event == Lifecycle.Event.ON_DESTROY) {
                    uVar.c();
                } else if (event == Lifecycle.Event.downFrom(state2)) {
                    copyOnWriteArrayList.remove((Object) null);
                    runnable.run();
                }
            }
        }));
    }

    public final void c() {
        this.f212b.remove((Object) null);
        t tVar = (t) this.f213c.remove(null);
        if (tVar != null) {
            tVar.f202a.removeObserver(tVar.f203b);
            tVar.f203b = null;
        }
        this.f211a.run();
    }
}
