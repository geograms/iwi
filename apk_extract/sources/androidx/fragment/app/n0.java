package androidx.fragment.app;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

/* loaded from: classes.dex */
public final class n0 implements androidx.activity.result.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f574a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w0 f575b;

    public /* synthetic */ n0(w0 w0Var, int i2) {
        this.f574a = i2;
        this.f575b = w0Var;
    }

    public final void a(androidx.activity.result.b bVar) {
        int i2 = this.f574a;
        w0 w0Var = this.f575b;
        switch (i2) {
            case 0:
                s0 s0Var = (s0) w0Var.f671y.pollFirst();
                if (s0Var != null) {
                    String str = s0Var.f599a;
                    Fragment fragmentC = w0Var.f649c.c(str);
                    if (fragmentC != null) {
                        fragmentC.onActivityResult(s0Var.f600b, bVar.f38a, bVar.f39b);
                        break;
                    } else {
                        Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
                        break;
                    }
                } else {
                    Log.w("FragmentManager", "No IntentSenders were started for " + this);
                    break;
                }
            default:
                s0 s0Var2 = (s0) w0Var.f671y.pollFirst();
                if (s0Var2 != null) {
                    String str2 = s0Var2.f599a;
                    Fragment fragmentC2 = w0Var.f649c.c(str2);
                    if (fragmentC2 != null) {
                        fragmentC2.onActivityResult(s0Var2.f600b, bVar.f38a, bVar.f39b);
                        break;
                    } else {
                        Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str2);
                        break;
                    }
                } else {
                    Log.w("FragmentManager", "No Activities were started for result for " + this);
                    break;
                }
        }
    }

    public final void b(Object obj) {
        switch (this.f574a) {
            case 0:
                a((androidx.activity.result.b) obj);
                break;
            case 1:
                Map map = (Map) obj;
                String[] strArr = (String[]) map.keySet().toArray(new String[0]);
                ArrayList arrayList = new ArrayList(map.values());
                int[] iArr = new int[arrayList.size()];
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    iArr[i2] = ((Boolean) arrayList.get(i2)).booleanValue() ? 0 : -1;
                }
                w0 w0Var = this.f575b;
                s0 s0Var = (s0) w0Var.f671y.pollFirst();
                if (s0Var == null) {
                    Log.w("FragmentManager", "No permissions were requested for " + this);
                    break;
                } else {
                    String str = s0Var.f599a;
                    Fragment fragmentC = w0Var.f649c.c(str);
                    if (fragmentC == null) {
                        Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
                        break;
                    } else {
                        fragmentC.onRequestPermissionsResult(s0Var.f600b, strArr, iArr);
                        break;
                    }
                }
            default:
                a((androidx.activity.result.b) obj);
                break;
        }
    }

    public final void c(Fragment fragment, n.d dVar) {
        boolean z2;
        synchronized (dVar) {
            z2 = dVar.f2135a;
        }
        if (z2) {
            return;
        }
        w0 w0Var = this.f575b;
        Map map = w0Var.f657k;
        HashSet hashSet = (HashSet) map.get(fragment);
        if (hashSet != null && hashSet.remove(dVar) && hashSet.isEmpty()) {
            map.remove(fragment);
            if (fragment.mState < 5) {
                fragment.performDestroyView();
                w0Var.f659m.p(false);
                fragment.mContainer = null;
                fragment.mView = null;
                fragment.mViewLifecycleOwner = null;
                fragment.mViewLifecycleOwnerLiveData.setValue(null);
                fragment.mInLayout = false;
                w0Var.E(fragment, w0Var.f661o);
            }
        }
    }

    public final void d(Fragment fragment, n.d dVar) {
        Map map = this.f575b.f657k;
        if (map.get(fragment) == null) {
            map.put(fragment, new HashSet());
        }
        ((HashSet) map.get(fragment)).add(dVar);
    }
}
