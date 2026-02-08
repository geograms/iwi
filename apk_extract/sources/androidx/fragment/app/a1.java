package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class a1 extends ViewModel {

    /* renamed from: g, reason: collision with root package name */
    public static final z0 f436g = new z0();

    /* renamed from: d, reason: collision with root package name */
    public final boolean f440d;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f437a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f438b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f439c = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public boolean f441e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f442f = false;

    public a1(boolean z2) {
        this.f440d = z2;
    }

    public final void a(Fragment fragment) {
        if (this.f442f) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        HashMap map = this.f437a;
        if (map.containsKey(fragment.mWho)) {
            return;
        }
        map.put(fragment.mWho, fragment);
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
        }
    }

    public final void b(Fragment fragment) {
        if (this.f442f) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f437a.remove(fragment.mWho) == null || !Log.isLoggable("FragmentManager", 2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a1.class != obj.getClass()) {
            return false;
        }
        a1 a1Var = (a1) obj;
        return this.f437a.equals(a1Var.f437a) && this.f438b.equals(a1Var.f438b) && this.f439c.equals(a1Var.f439c);
    }

    public final int hashCode() {
        return this.f439c.hashCode() + ((this.f438b.hashCode() + (this.f437a.hashCode() * 31)) * 31);
    }

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f441e = true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.f437a.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.f438b.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.f439c.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
