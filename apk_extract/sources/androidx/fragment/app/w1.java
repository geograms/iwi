package androidx.fragment.app;

import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.R$id;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class w1 {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f673a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f674b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f675c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public boolean f676d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f677e = false;

    public w1(ViewGroup viewGroup) {
        this.f673a = viewGroup;
    }

    public static w1 f(ViewGroup viewGroup, n0 n0Var) {
        Object tag = viewGroup.getTag(R$id.special_effects_controller_view_tag);
        if (tag instanceof w1) {
            return (w1) tag;
        }
        n0Var.getClass();
        l lVar = new l(viewGroup);
        viewGroup.setTag(R$id.special_effects_controller_view_tag, lVar);
        return lVar;
    }

    public static w1 g(ViewGroup viewGroup, w0 w0Var) {
        return f(viewGroup, w0Var.z());
    }

    public final void a(int i2, int i3, e1 e1Var) {
        synchronized (this.f674b) {
            try {
                n.d dVar = new n.d();
                u1 u1VarD = d(e1Var.f493c);
                if (u1VarD != null) {
                    u1VarD.c(i2, i3);
                    return;
                }
                u1 u1Var = new u1(i2, i3, e1Var, dVar);
                this.f674b.add(u1Var);
                u1Var.f619d.add(new t1(this, u1Var, 0));
                u1Var.f619d.add(new t1(this, u1Var, 1));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void b(ArrayList arrayList, boolean z2);

    public final void c() {
        if (this.f677e) {
            return;
        }
        ViewGroup viewGroup = this.f673a;
        WeakHashMap weakHashMap = androidx.core.view.d1.f138a;
        if (!androidx.core.view.p0.b(viewGroup)) {
            e();
            this.f676d = false;
            return;
        }
        synchronized (this.f674b) {
            try {
                if (!this.f674b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.f675c);
                    this.f675c.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        u1 u1Var = (u1) it.next();
                        if (Log.isLoggable("FragmentManager", 2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + u1Var);
                        }
                        u1Var.a();
                        if (!u1Var.f622g) {
                            this.f675c.add(u1Var);
                        }
                    }
                    i();
                    ArrayList arrayList2 = new ArrayList(this.f674b);
                    this.f674b.clear();
                    this.f675c.addAll(arrayList2);
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ((u1) it2.next()).d();
                    }
                    b(arrayList2, this.f676d);
                    this.f676d = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final u1 d(Fragment fragment) {
        Iterator it = this.f674b.iterator();
        while (it.hasNext()) {
            u1 u1Var = (u1) it.next();
            if (u1Var.f618c.equals(fragment) && !u1Var.f621f) {
                return u1Var;
            }
        }
        return null;
    }

    public final void e() {
        String str;
        String str2;
        ViewGroup viewGroup = this.f673a;
        WeakHashMap weakHashMap = androidx.core.view.d1.f138a;
        boolean zB = androidx.core.view.p0.b(viewGroup);
        synchronized (this.f674b) {
            try {
                i();
                Iterator it = this.f674b.iterator();
                while (it.hasNext()) {
                    ((u1) it.next()).d();
                }
                Iterator it2 = new ArrayList(this.f675c).iterator();
                while (it2.hasNext()) {
                    u1 u1Var = (u1) it2.next();
                    if (Log.isLoggable("FragmentManager", 2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SpecialEffectsController: ");
                        if (zB) {
                            str2 = "";
                        } else {
                            str2 = "Container " + this.f673a + " is not attached to window. ";
                        }
                        sb.append(str2);
                        sb.append("Cancelling running operation ");
                        sb.append(u1Var);
                        Log.v("FragmentManager", sb.toString());
                    }
                    u1Var.a();
                }
                Iterator it3 = new ArrayList(this.f674b).iterator();
                while (it3.hasNext()) {
                    u1 u1Var2 = (u1) it3.next();
                    if (Log.isLoggable("FragmentManager", 2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: ");
                        if (zB) {
                            str = "";
                        } else {
                            str = "Container " + this.f673a + " is not attached to window. ";
                        }
                        sb2.append(str);
                        sb2.append("Cancelling pending operation ");
                        sb2.append(u1Var2);
                        Log.v("FragmentManager", sb2.toString());
                    }
                    u1Var2.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h() {
        synchronized (this.f674b) {
            try {
                i();
                this.f677e = false;
                int size = this.f674b.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    u1 u1Var = (u1) this.f674b.get(size);
                    int iC = v1.c(u1Var.f618c.mView);
                    if (u1Var.f616a == 2 && iC != 2) {
                        this.f677e = u1Var.f618c.isPostponed();
                        break;
                    }
                    size--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void i() {
        Iterator it = this.f674b.iterator();
        while (it.hasNext()) {
            u1 u1Var = (u1) it.next();
            if (u1Var.f617b == 2) {
                u1Var.c(v1.b(u1Var.f618c.requireView().getVisibility()), 1);
            }
        }
    }
}
