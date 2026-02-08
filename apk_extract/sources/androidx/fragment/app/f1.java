package androidx.fragment.app;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class f1 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f501a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f502b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public a1 f503c;

    public final void a(Fragment fragment) {
        if (this.f501a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f501a) {
            this.f501a.add(fragment);
        }
        fragment.mAdded = true;
    }

    public final Fragment b(String str) {
        e1 e1Var = (e1) this.f502b.get(str);
        if (e1Var != null) {
            return e1Var.f493c;
        }
        return null;
    }

    public final Fragment c(String str) {
        Fragment fragmentFindFragmentByWho;
        for (e1 e1Var : this.f502b.values()) {
            if (e1Var != null && (fragmentFindFragmentByWho = e1Var.f493c.findFragmentByWho(str)) != null) {
                return fragmentFindFragmentByWho;
            }
        }
        return null;
    }

    public final ArrayList d() {
        ArrayList arrayList = new ArrayList();
        for (e1 e1Var : this.f502b.values()) {
            if (e1Var != null) {
                arrayList.add(e1Var);
            }
        }
        return arrayList;
    }

    public final ArrayList e() {
        ArrayList arrayList = new ArrayList();
        for (e1 e1Var : this.f502b.values()) {
            if (e1Var != null) {
                arrayList.add(e1Var.f493c);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public final List f() {
        ArrayList arrayList;
        if (this.f501a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f501a) {
            arrayList = new ArrayList(this.f501a);
        }
        return arrayList;
    }

    public final void g(e1 e1Var) {
        Fragment fragment = e1Var.f493c;
        String str = fragment.mWho;
        HashMap map = this.f502b;
        if (map.get(str) != null) {
            return;
        }
        map.put(fragment.mWho, e1Var);
        if (fragment.mRetainInstanceChangedWhileDetached) {
            if (fragment.mRetainInstance) {
                this.f503c.a(fragment);
            } else {
                this.f503c.b(fragment);
            }
            fragment.mRetainInstanceChangedWhileDetached = false;
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragment);
        }
    }

    public final void h(e1 e1Var) {
        Fragment fragment = e1Var.f493c;
        if (fragment.mRetainInstance) {
            this.f503c.b(fragment);
        }
        if (((e1) this.f502b.put(fragment.mWho, null)) != null && Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragment);
        }
    }
}
