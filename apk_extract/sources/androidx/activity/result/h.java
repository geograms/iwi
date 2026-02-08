package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.n0;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public Random f48a = new Random();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f49b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f50c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f51d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f52e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final transient HashMap f53f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f54g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    public final Bundle f55h = new Bundle();

    public final boolean a(int i2, int i3, Intent intent) {
        c cVar;
        String str = (String) this.f49b.get(Integer.valueOf(i2));
        if (str == null) {
            return false;
        }
        f fVar = (f) this.f53f.get(str);
        if (fVar == null || (cVar = fVar.f44a) == null || !this.f52e.contains(str)) {
            this.f54g.remove(str);
            this.f55h.putParcelable(str, new b(intent, i3));
            return true;
        }
        ((n0) cVar).b(fVar.f45b.c(intent, i3));
        this.f52e.remove(str);
        return true;
    }

    public abstract void b(int i2, c.b bVar, Object obj);

    public final e c(final String str, LifecycleOwner lifecycleOwner, final c.b bVar, final c cVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            throw new IllegalStateException("LifecycleOwner " + lifecycleOwner + " is attempting to register while current state is " + lifecycle.getCurrentState() + ". LifecycleOwners must call register before they are STARTED.");
        }
        e(str);
        HashMap map = this.f51d;
        g gVar = (g) map.get(str);
        if (gVar == null) {
            gVar = new g(lifecycle);
        }
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.activity.result.ActivityResultRegistry$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                boolean zEquals = Lifecycle.Event.ON_START.equals(event);
                String str2 = str;
                h hVar = this.f36d;
                if (!zEquals) {
                    if (Lifecycle.Event.ON_STOP.equals(event)) {
                        hVar.f53f.remove(str2);
                        return;
                    } else {
                        if (Lifecycle.Event.ON_DESTROY.equals(event)) {
                            hVar.f(str2);
                            return;
                        }
                        return;
                    }
                }
                HashMap map2 = hVar.f53f;
                c.b bVar2 = bVar;
                c cVar2 = cVar;
                map2.put(str2, new f(bVar2, cVar2));
                HashMap map3 = hVar.f54g;
                if (map3.containsKey(str2)) {
                    Object obj = map3.get(str2);
                    map3.remove(str2);
                    ((n0) cVar2).b(obj);
                }
                Bundle bundle = hVar.f55h;
                b bVar3 = (b) bundle.getParcelable(str2);
                if (bVar3 != null) {
                    bundle.remove(str2);
                    ((n0) cVar2).b(bVar2.c(bVar3.f39b, bVar3.f38a));
                }
            }
        };
        gVar.f46a.addObserver(lifecycleEventObserver);
        gVar.f47b.add(lifecycleEventObserver);
        map.put(str, gVar);
        return new e(this, str, bVar, 0);
    }

    public final e d(String str, c.b bVar, n0 n0Var) {
        e(str);
        this.f53f.put(str, new f(bVar, n0Var));
        HashMap map = this.f54g;
        if (map.containsKey(str)) {
            Object obj = map.get(str);
            map.remove(str);
            n0Var.b(obj);
        }
        Bundle bundle = this.f55h;
        b bVar2 = (b) bundle.getParcelable(str);
        if (bVar2 != null) {
            bundle.remove(str);
            n0Var.b(bVar.c(bVar2.f39b, bVar2.f38a));
        }
        return new e(this, str, bVar, 1);
    }

    public final void e(String str) {
        HashMap map = this.f50c;
        if (((Integer) map.get(str)) != null) {
            return;
        }
        int iNextInt = this.f48a.nextInt(2147418112);
        while (true) {
            int i2 = iNextInt + 65536;
            HashMap map2 = this.f49b;
            if (!map2.containsKey(Integer.valueOf(i2))) {
                map2.put(Integer.valueOf(i2), str);
                map.put(str, Integer.valueOf(i2));
                return;
            }
            iNextInt = this.f48a.nextInt(2147418112);
        }
    }

    public final void f(String str) {
        Integer num;
        if (!this.f52e.contains(str) && (num = (Integer) this.f50c.remove(str)) != null) {
            this.f49b.remove(num);
        }
        this.f53f.remove(str);
        HashMap map = this.f54g;
        if (map.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + map.get(str));
            map.remove(str);
        }
        Bundle bundle = this.f55h;
        if (bundle.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + bundle.getParcelable(str));
            bundle.remove(str);
        }
        HashMap map2 = this.f51d;
        g gVar = (g) map2.get(str);
        if (gVar != null) {
            ArrayList arrayList = gVar.f47b;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                gVar.f46a.removeObserver((LifecycleEventObserver) it.next());
            }
            arrayList.clear();
            map2.remove(str);
        }
    }
}
