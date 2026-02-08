package androidx.fragment.app;

import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.fragment.R$id;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class w0 {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public ArrayList E;
    public ArrayList F;
    public ArrayList G;
    public a1 H;
    public final d0 I;

    /* renamed from: b, reason: collision with root package name */
    public boolean f648b;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f650d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f651e;

    /* renamed from: g, reason: collision with root package name */
    public androidx.activity.k f653g;

    /* renamed from: k, reason: collision with root package name */
    public final Map f657k;

    /* renamed from: l, reason: collision with root package name */
    public final n0 f658l;

    /* renamed from: m, reason: collision with root package name */
    public final d f659m;

    /* renamed from: n, reason: collision with root package name */
    public final CopyOnWriteArrayList f660n;

    /* renamed from: o, reason: collision with root package name */
    public int f661o;

    /* renamed from: p, reason: collision with root package name */
    public k0 f662p;

    /* renamed from: q, reason: collision with root package name */
    public i0 f663q;

    /* renamed from: r, reason: collision with root package name */
    public Fragment f664r;

    /* renamed from: s, reason: collision with root package name */
    public Fragment f665s;

    /* renamed from: t, reason: collision with root package name */
    public final p0 f666t;

    /* renamed from: u, reason: collision with root package name */
    public final n0 f667u;

    /* renamed from: v, reason: collision with root package name */
    public androidx.activity.result.e f668v;

    /* renamed from: w, reason: collision with root package name */
    public androidx.activity.result.e f669w;

    /* renamed from: x, reason: collision with root package name */
    public androidx.activity.result.e f670x;

    /* renamed from: y, reason: collision with root package name */
    public ArrayDeque f671y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f672z;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f647a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final f1 f649c = new f1();

    /* renamed from: f, reason: collision with root package name */
    public final m0 f652f = new m0(this);

    /* renamed from: h, reason: collision with root package name */
    public final o0 f654h = new o0(this);

    /* renamed from: i, reason: collision with root package name */
    public final AtomicInteger f655i = new AtomicInteger();

    /* renamed from: j, reason: collision with root package name */
    public final Map f656j = Collections.synchronizedMap(new HashMap());

    public w0() {
        Collections.synchronizedMap(new HashMap());
        this.f657k = Collections.synchronizedMap(new HashMap());
        this.f658l = new n0(this, 2);
        this.f659m = new d(this);
        this.f660n = new CopyOnWriteArrayList();
        this.f661o = -1;
        this.f666t = new p0(this);
        int i2 = 3;
        this.f667u = new n0(this, i2);
        this.f671y = new ArrayDeque();
        this.I = new d0(i2, this);
    }

    public static boolean B(Fragment fragment) {
        if (!fragment.mHasMenu || !fragment.mMenuVisible) {
            Iterator it = fragment.mChildFragmentManager.f649c.e().iterator();
            boolean zB = false;
            while (it.hasNext()) {
                Fragment fragment2 = (Fragment) it.next();
                if (fragment2 != null) {
                    zB = B(fragment2);
                }
                if (zB) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean C(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        w0 w0Var = fragment.mFragmentManager;
        return fragment.equals(w0Var.f665s) && C(w0Var.f664r);
    }

    public static void R(Fragment fragment) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public final void A(Fragment fragment) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        Q(fragment);
    }

    public final void D(int i2, boolean z2) {
        HashMap map;
        k0 k0Var;
        if (this.f662p == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z2 || i2 != this.f661o) {
            this.f661o = i2;
            f1 f1Var = this.f649c;
            Iterator it = f1Var.f501a.iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                map = f1Var.f502b;
                if (!zHasNext) {
                    break;
                }
                e1 e1Var = (e1) map.get(((Fragment) it.next()).mWho);
                if (e1Var != null) {
                    e1Var.k();
                }
            }
            for (e1 e1Var2 : map.values()) {
                if (e1Var2 != null) {
                    e1Var2.k();
                    Fragment fragment = e1Var2.f493c;
                    if (fragment.mRemoving && !fragment.isInBackStack()) {
                        f1Var.h(e1Var2);
                    }
                }
            }
            S();
            if (this.f672z && (k0Var = this.f662p) != null && this.f661o == 7) {
                ((b0) k0Var).f457e.supportInvalidateOptionsMenu();
                this.f672z = false;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E(androidx.fragment.app.Fragment r18, int r19) {
        /*
            Method dump skipped, instructions count: 537
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.w0.E(androidx.fragment.app.Fragment, int):void");
    }

    public final void F() {
        if (this.f662p == null) {
            return;
        }
        this.A = false;
        this.B = false;
        this.H.f442f = false;
        for (Fragment fragment : this.f649c.f()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    public final boolean G() {
        s(false);
        r(true);
        Fragment fragment = this.f665s;
        if (fragment != null && fragment.getChildFragmentManager().G()) {
            return true;
        }
        boolean zH = H(this.E, this.F, null, -1, 0);
        if (zH) {
            this.f648b = true;
            try {
                J(this.E, this.F);
            } finally {
                d();
            }
        }
        T();
        if (this.D) {
            this.D = false;
            S();
        }
        this.f649c.f502b.values().removeAll(Collections.singleton(null));
        return zH;
    }

    public final boolean H(ArrayList arrayList, ArrayList arrayList2, String str, int i2, int i3) {
        int i4;
        ArrayList arrayList3 = this.f650d;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f650d.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i2 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    a aVar = (a) this.f650d.get(size2);
                    if ((str != null && str.equals(aVar.f530h)) || (i2 >= 0 && i2 == aVar.f434r)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        a aVar2 = (a) this.f650d.get(size2);
                        if (str == null || !str.equals(aVar2.f530h)) {
                            if (i2 < 0 || i2 != aVar2.f434r) {
                                break;
                            }
                        }
                    }
                }
                i4 = size2;
            } else {
                i4 = -1;
            }
            if (i4 == this.f650d.size() - 1) {
                return false;
            }
            for (int size3 = this.f650d.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.f650d.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    public final void I(Fragment fragment) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z2 = !fragment.isInBackStack();
        if (!fragment.mDetached || z2) {
            f1 f1Var = this.f649c;
            synchronized (f1Var.f501a) {
                f1Var.f501a.remove(fragment);
            }
            fragment.mAdded = false;
            if (B(fragment)) {
                this.f672z = true;
            }
            fragment.mRemoving = true;
            Q(fragment);
        }
    }

    public final void J(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            if (!((a) arrayList.get(i2)).f537o) {
                if (i3 != i2) {
                    u(arrayList, arrayList2, i3, i2);
                }
                i3 = i2 + 1;
                if (((Boolean) arrayList2.get(i2)).booleanValue()) {
                    while (i3 < size && ((Boolean) arrayList2.get(i3)).booleanValue() && !((a) arrayList.get(i3)).f537o) {
                        i3++;
                    }
                }
                u(arrayList, arrayList2, i2, i3);
                i2 = i3 - 1;
            }
            i2++;
        }
        if (i3 != size) {
            u(arrayList, arrayList2, i3, size);
        }
    }

    public final void K(Parcelable parcelable) {
        int i2;
        d dVar;
        int i3;
        e1 e1Var;
        if (parcelable == null) {
            return;
        }
        y0 y0Var = (y0) parcelable;
        if (y0Var.f679a == null) {
            return;
        }
        f1 f1Var = this.f649c;
        f1Var.f502b.clear();
        Iterator it = y0Var.f679a.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            i2 = 2;
            dVar = this.f659m;
            if (!zHasNext) {
                break;
            }
            c1 c1Var = (c1) it.next();
            if (c1Var != null) {
                Fragment fragment = (Fragment) this.H.f437a.get(c1Var.f464b);
                if (fragment != null) {
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragment);
                    }
                    e1Var = new e1(dVar, f1Var, fragment, c1Var);
                } else {
                    e1Var = new e1(this.f659m, this.f649c, this.f662p.f554b.getClassLoader(), y(), c1Var);
                }
                Fragment fragment2 = e1Var.f493c;
                fragment2.mFragmentManager = this;
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + fragment2.mWho + "): " + fragment2);
                }
                e1Var.m(this.f662p.f554b.getClassLoader());
                f1Var.g(e1Var);
                e1Var.f495e = this.f661o;
            }
        }
        a1 a1Var = this.H;
        a1Var.getClass();
        Iterator it2 = new ArrayList(a1Var.f437a.values()).iterator();
        while (it2.hasNext()) {
            Fragment fragment3 = (Fragment) it2.next();
            if (!(f1Var.f502b.get(fragment3.mWho) != null)) {
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment3 + " that was not found in the set of active Fragments " + y0Var.f679a);
                }
                this.H.b(fragment3);
                fragment3.mFragmentManager = this;
                e1 e1Var2 = new e1(dVar, f1Var, fragment3);
                e1Var2.f495e = 1;
                e1Var2.k();
                fragment3.mRemoving = true;
                e1Var2.k();
            }
        }
        ArrayList<String> arrayList = y0Var.f680b;
        f1Var.f501a.clear();
        if (arrayList != null) {
            for (String str : arrayList) {
                Fragment fragmentB = f1Var.b(str);
                if (fragmentB == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + fragmentB);
                }
                f1Var.a(fragmentB);
            }
        }
        Fragment fragment4 = null;
        if (y0Var.f681c != null) {
            this.f650d = new ArrayList(y0Var.f681c.length);
            int i4 = 0;
            while (true) {
                b[] bVarArr = y0Var.f681c;
                if (i4 >= bVarArr.length) {
                    break;
                }
                b bVar = bVarArr[i4];
                bVar.getClass();
                a aVar = new a(this);
                int i5 = 0;
                int i6 = 0;
                while (true) {
                    int[] iArr = bVar.f443a;
                    if (i5 >= iArr.length) {
                        break;
                    }
                    g1 g1Var = new g1();
                    int i7 = i5 + 1;
                    g1Var.f512a = iArr[i5];
                    if (Log.isLoggable("FragmentManager", i2)) {
                        Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i6 + " base fragment #" + iArr[i7]);
                    }
                    String str2 = (String) bVar.f444b.get(i6);
                    if (str2 != null) {
                        g1Var.f513b = f1Var.b(str2);
                    } else {
                        g1Var.f513b = fragment4;
                    }
                    g1Var.f518g = Lifecycle.State.values()[bVar.f445c[i6]];
                    g1Var.f519h = Lifecycle.State.values()[bVar.f446d[i6]];
                    int i8 = iArr[i7];
                    g1Var.f514c = i8;
                    int i9 = iArr[i5 + 2];
                    g1Var.f515d = i9;
                    int i10 = i5 + 4;
                    int i11 = iArr[i5 + 3];
                    g1Var.f516e = i11;
                    i5 += 5;
                    int i12 = iArr[i10];
                    g1Var.f517f = i12;
                    aVar.f524b = i8;
                    aVar.f525c = i9;
                    aVar.f526d = i11;
                    aVar.f527e = i12;
                    aVar.b(g1Var);
                    i6++;
                    fragment4 = null;
                    i2 = 2;
                }
                aVar.f528f = bVar.f447e;
                aVar.f530h = bVar.f448f;
                aVar.f434r = bVar.f449g;
                aVar.f529g = true;
                aVar.f531i = bVar.f450h;
                aVar.f532j = bVar.f451i;
                aVar.f533k = bVar.f452j;
                aVar.f534l = bVar.f453k;
                aVar.f535m = bVar.f454l;
                aVar.f536n = bVar.f455m;
                aVar.f537o = bVar.f456n;
                aVar.d(1);
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i4 + " (index " + aVar.f434r + "): " + aVar);
                    PrintWriter printWriter = new PrintWriter(new s1());
                    aVar.f("  ", printWriter, false);
                    printWriter.close();
                }
                this.f650d.add(aVar);
                i4++;
                i2 = 2;
                fragment4 = null;
            }
            i3 = 0;
        } else {
            i3 = 0;
            this.f650d = null;
        }
        this.f655i.set(y0Var.f682d);
        String str3 = y0Var.f683e;
        if (str3 != null) {
            Fragment fragmentB2 = f1Var.b(str3);
            this.f665s = fragmentB2;
            m(fragmentB2);
        }
        ArrayList arrayList2 = y0Var.f684f;
        if (arrayList2 != null) {
            while (i3 < arrayList2.size()) {
                Bundle bundle = (Bundle) y0Var.f685g.get(i3);
                bundle.setClassLoader(this.f662p.f554b.getClassLoader());
                this.f656j.put(arrayList2.get(i3), bundle);
                i3++;
            }
        }
        this.f671y = new ArrayDeque(y0Var.f686h);
    }

    public final y0 L() {
        int i2;
        ArrayList arrayList;
        b[] bVarArr;
        int size;
        w();
        Iterator it = e().iterator();
        while (it.hasNext()) {
            ((w1) it.next()).e();
        }
        s(true);
        this.A = true;
        this.H.f442f = true;
        f1 f1Var = this.f649c;
        f1Var.getClass();
        HashMap map = f1Var.f502b;
        ArrayList arrayList2 = new ArrayList(map.size());
        Iterator it2 = map.values().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            e1 e1Var = (e1) it2.next();
            if (e1Var != null) {
                Fragment fragment = e1Var.f493c;
                c1 c1Var = new c1(fragment);
                if (fragment.mState <= -1 || c1Var.f475m != null) {
                    c1Var.f475m = fragment.mSavedFragmentState;
                } else {
                    Bundle bundle = new Bundle();
                    fragment.performSaveInstanceState(bundle);
                    e1Var.f491a.l(false);
                    Bundle bundle2 = bundle.isEmpty() ? null : bundle;
                    if (fragment.mView != null) {
                        e1Var.o();
                    }
                    if (fragment.mSavedViewState != null) {
                        if (bundle2 == null) {
                            bundle2 = new Bundle();
                        }
                        bundle2.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
                    }
                    if (fragment.mSavedViewRegistryState != null) {
                        if (bundle2 == null) {
                            bundle2 = new Bundle();
                        }
                        bundle2.putBundle("android:view_registry_state", fragment.mSavedViewRegistryState);
                    }
                    if (!fragment.mUserVisibleHint) {
                        if (bundle2 == null) {
                            bundle2 = new Bundle();
                        }
                        bundle2.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
                    }
                    c1Var.f475m = bundle2;
                    if (fragment.mTargetWho != null) {
                        if (bundle2 == null) {
                            c1Var.f475m = new Bundle();
                        }
                        c1Var.f475m.putString("android:target_state", fragment.mTargetWho);
                        int i3 = fragment.mTargetRequestCode;
                        if (i3 != 0) {
                            c1Var.f475m.putInt("android:target_req_state", i3);
                        }
                    }
                }
                arrayList2.add(c1Var);
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + c1Var.f475m);
                }
            }
        }
        if (arrayList2.isEmpty()) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        f1 f1Var2 = this.f649c;
        synchronized (f1Var2.f501a) {
            try {
                if (f1Var2.f501a.isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(f1Var2.f501a.size());
                    Iterator it3 = f1Var2.f501a.iterator();
                    while (it3.hasNext()) {
                        Fragment fragment2 = (Fragment) it3.next();
                        arrayList.add(fragment2.mWho);
                        if (Log.isLoggable("FragmentManager", 2)) {
                            Log.v("FragmentManager", "saveAllState: adding fragment (" + fragment2.mWho + "): " + fragment2);
                        }
                    }
                }
            } finally {
            }
        }
        ArrayList arrayList3 = this.f650d;
        if (arrayList3 == null || (size = arrayList3.size()) <= 0) {
            bVarArr = null;
        } else {
            bVarArr = new b[size];
            for (i2 = 0; i2 < size; i2++) {
                bVarArr[i2] = new b((a) this.f650d.get(i2));
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f650d.get(i2));
                }
            }
        }
        y0 y0Var = new y0();
        y0Var.f683e = null;
        ArrayList arrayList4 = new ArrayList();
        y0Var.f684f = arrayList4;
        ArrayList arrayList5 = new ArrayList();
        y0Var.f685g = arrayList5;
        y0Var.f679a = arrayList2;
        y0Var.f680b = arrayList;
        y0Var.f681c = bVarArr;
        y0Var.f682d = this.f655i.get();
        Fragment fragment3 = this.f665s;
        if (fragment3 != null) {
            y0Var.f683e = fragment3.mWho;
        }
        arrayList4.addAll(this.f656j.keySet());
        arrayList5.addAll(this.f656j.values());
        y0Var.f686h = new ArrayList(this.f671y);
        return y0Var;
    }

    public final void M() {
        synchronized (this.f647a) {
            try {
                if (this.f647a.size() == 1) {
                    this.f662p.f555c.removeCallbacks(this.I);
                    this.f662p.f555c.post(this.I);
                    T();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void N(Fragment fragment, boolean z2) {
        ViewGroup viewGroupX = x(fragment);
        if (viewGroupX == null || !(viewGroupX instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupX).setDrawDisappearingViewsLast(!z2);
    }

    public final void O(Fragment fragment, Lifecycle.State state) {
        if (fragment.equals(this.f649c.b(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = state;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public final void P(Fragment fragment) {
        if (fragment != null) {
            if (!fragment.equals(this.f649c.b(fragment.mWho)) || (fragment.mHost != null && fragment.mFragmentManager != this)) {
                throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
            }
        }
        Fragment fragment2 = this.f665s;
        this.f665s = fragment;
        m(fragment2);
        m(this.f665s);
    }

    public final void Q(Fragment fragment) {
        ViewGroup viewGroupX = x(fragment);
        if (viewGroupX != null) {
            if (fragment.getPopExitAnim() + fragment.getPopEnterAnim() + fragment.getExitAnim() + fragment.getEnterAnim() > 0) {
                if (viewGroupX.getTag(R$id.visible_removing_fragment_view_tag) == null) {
                    viewGroupX.setTag(R$id.visible_removing_fragment_view_tag, fragment);
                }
                ((Fragment) viewGroupX.getTag(R$id.visible_removing_fragment_view_tag)).setPopDirection(fragment.getPopDirection());
            }
        }
    }

    public final void S() {
        Iterator it = this.f649c.d().iterator();
        while (it.hasNext()) {
            e1 e1Var = (e1) it.next();
            Fragment fragment = e1Var.f493c;
            if (fragment.mDeferStart) {
                if (this.f648b) {
                    this.D = true;
                } else {
                    fragment.mDeferStart = false;
                    e1Var.k();
                }
            }
        }
    }

    public final void T() {
        synchronized (this.f647a) {
            try {
                if (!this.f647a.isEmpty()) {
                    this.f654h.f578a = true;
                    return;
                }
                o0 o0Var = this.f654h;
                ArrayList arrayList = this.f650d;
                o0Var.f578a = arrayList != null && arrayList.size() > 0 && C(this.f664r);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final e1 a(Fragment fragment) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        e1 e1VarF = f(fragment);
        fragment.mFragmentManager = this;
        f1 f1Var = this.f649c;
        f1Var.g(e1VarF);
        if (!fragment.mDetached) {
            f1Var.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (B(fragment)) {
                this.f672z = true;
            }
        }
        return e1VarF;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(k0 k0Var, i0 i0Var, Fragment fragment) {
        if (this.f662p != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f662p = k0Var;
        this.f663q = i0Var;
        this.f664r = fragment;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f660n;
        if (fragment != null) {
            copyOnWriteArrayList.add(new q0(fragment));
        } else if (k0Var instanceof b1) {
            copyOnWriteArrayList.add((b1) k0Var);
        }
        if (this.f664r != null) {
            T();
        }
        if (k0Var instanceof androidx.activity.l) {
            androidx.activity.l lVar = (androidx.activity.l) k0Var;
            androidx.activity.k onBackPressedDispatcher = lVar.getOnBackPressedDispatcher();
            this.f653g = onBackPressedDispatcher;
            LifecycleOwner lifecycleOwner = lVar;
            if (fragment != null) {
                lifecycleOwner = fragment;
            }
            onBackPressedDispatcher.a(lifecycleOwner, this.f654h);
        }
        int i2 = 0;
        if (fragment != null) {
            a1 a1Var = fragment.mFragmentManager.H;
            HashMap map = a1Var.f438b;
            a1 a1Var2 = (a1) map.get(fragment.mWho);
            if (a1Var2 == null) {
                a1Var2 = new a1(a1Var.f440d);
                map.put(fragment.mWho, a1Var2);
            }
            this.H = a1Var2;
        } else if (k0Var instanceof ViewModelStoreOwner) {
            this.H = (a1) new ViewModelProvider(((ViewModelStoreOwner) k0Var).getViewModelStore(), a1.f436g).get(a1.class);
        } else {
            this.H = new a1(false);
        }
        a1 a1Var3 = this.H;
        int i3 = 1;
        a1Var3.f442f = this.A || this.B;
        this.f649c.f503c = a1Var3;
        Object obj = this.f662p;
        if (obj instanceof androidx.activity.result.i) {
            androidx.activity.result.h activityResultRegistry = ((androidx.activity.result.i) obj).getActivityResultRegistry();
            String str = "FragmentManager:" + (fragment != null ? a.a.e(new StringBuilder(), fragment.mWho, ":") : "");
            this.f668v = activityResultRegistry.d(a.a.d(str, "StartActivityForResult"), new c.e(), new n0(this, 4));
            this.f669w = activityResultRegistry.d(a.a.d(str, "StartIntentSenderForResult"), new r0(), new n0(this, i2));
            this.f670x = activityResultRegistry.d(a.a.d(str, "RequestPermissions"), new c.d(), new n0(this, i3));
        }
    }

    public final void c(Fragment fragment) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.f649c.a(fragment);
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (B(fragment)) {
                this.f672z = true;
            }
        }
    }

    public final void d() {
        this.f648b = false;
        this.F.clear();
        this.E.clear();
    }

    public final HashSet e() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f649c.d().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((e1) it.next()).f493c.mContainer;
            if (viewGroup != null) {
                hashSet.add(w1.f(viewGroup, z()));
            }
        }
        return hashSet;
    }

    public final e1 f(Fragment fragment) {
        String str = fragment.mWho;
        f1 f1Var = this.f649c;
        e1 e1Var = (e1) f1Var.f502b.get(str);
        if (e1Var != null) {
            return e1Var;
        }
        e1 e1Var2 = new e1(this.f659m, f1Var, fragment);
        e1Var2.m(this.f662p.f554b.getClassLoader());
        e1Var2.f495e = this.f661o;
        return e1Var2;
    }

    public final void g(Fragment fragment) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            f1 f1Var = this.f649c;
            synchronized (f1Var.f501a) {
                f1Var.f501a.remove(fragment);
            }
            fragment.mAdded = false;
            if (B(fragment)) {
                this.f672z = true;
            }
            Q(fragment);
        }
    }

    public final boolean h(MenuItem menuItem) {
        if (this.f661o < 1) {
            return false;
        }
        for (Fragment fragment : this.f649c.f()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final boolean i(Menu menu, MenuInflater menuInflater) {
        if (this.f661o < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z2 = false;
        for (Fragment fragment : this.f649c.f()) {
            if (fragment != null && fragment.isMenuVisible() && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fragment);
                z2 = true;
            }
        }
        if (this.f651e != null) {
            for (int i2 = 0; i2 < this.f651e.size(); i2++) {
                Fragment fragment2 = (Fragment) this.f651e.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f651e = arrayList;
        return z2;
    }

    public final void j() {
        this.C = true;
        s(true);
        Iterator it = e().iterator();
        while (it.hasNext()) {
            ((w1) it.next()).e();
        }
        o(-1);
        this.f662p = null;
        this.f663q = null;
        this.f664r = null;
        if (this.f653g != null) {
            Iterator it2 = this.f654h.f579b.iterator();
            while (it2.hasNext()) {
                ((androidx.activity.a) it2.next()).cancel();
            }
            this.f653g = null;
        }
        androidx.activity.result.e eVar = this.f668v;
        if (eVar != null) {
            eVar.b();
            this.f669w.b();
            this.f670x.b();
        }
    }

    public final boolean k(MenuItem menuItem) {
        if (this.f661o < 1) {
            return false;
        }
        for (Fragment fragment : this.f649c.f()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void l(Menu menu) {
        if (this.f661o < 1) {
            return;
        }
        for (Fragment fragment : this.f649c.f()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    public final void m(Fragment fragment) {
        if (fragment != null) {
            if (fragment.equals(this.f649c.b(fragment.mWho))) {
                fragment.performPrimaryNavigationFragmentChanged();
            }
        }
    }

    public final boolean n(Menu menu) {
        boolean z2 = false;
        if (this.f661o < 1) {
            return false;
        }
        for (Fragment fragment : this.f649c.f()) {
            if (fragment != null && fragment.isMenuVisible() && fragment.performPrepareOptionsMenu(menu)) {
                z2 = true;
            }
        }
        return z2;
    }

    public final void o(int i2) {
        try {
            this.f648b = true;
            for (e1 e1Var : this.f649c.f502b.values()) {
                if (e1Var != null) {
                    e1Var.f495e = i2;
                }
            }
            D(i2, false);
            Iterator it = e().iterator();
            while (it.hasNext()) {
                ((w1) it.next()).e();
            }
            this.f648b = false;
            s(true);
        } catch (Throwable th) {
            this.f648b = false;
            throw th;
        }
    }

    public final void p(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String strD = a.a.d(str, "    ");
        f1 f1Var = this.f649c;
        f1Var.getClass();
        String str2 = str + "    ";
        HashMap map = f1Var.f502b;
        if (!map.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (e1 e1Var : map.values()) {
                printWriter.print(str);
                if (e1Var != null) {
                    Fragment fragment = e1Var.f493c;
                    printWriter.println(fragment);
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        ArrayList arrayList = f1Var.f501a;
        int size3 = arrayList.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size3; i2++) {
                Fragment fragment2 = (Fragment) arrayList.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        ArrayList arrayList2 = this.f651e;
        if (arrayList2 != null && (size2 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size2; i3++) {
                Fragment fragment3 = (Fragment) this.f651e.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        ArrayList arrayList3 = this.f650d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size; i4++) {
                a aVar = (a) this.f650d.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.f(strD, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f655i.get());
        synchronized (this.f647a) {
            try {
                int size4 = this.f647a.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i5 = 0; i5 < size4; i5++) {
                        Object obj = (t0) this.f647a.get(i5);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i5);
                        printWriter.print(": ");
                        printWriter.println(obj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f662p);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f663q);
        if (this.f664r != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f664r);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f661o);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.A);
        printWriter.print(" mStopped=");
        printWriter.print(this.B);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.C);
        if (this.f672z) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f672z);
        }
    }

    public final void q(t0 t0Var, boolean z2) {
        if (!z2) {
            if (this.f662p == null) {
                if (!this.C) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            if (this.A || this.B) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.f647a) {
            try {
                if (this.f662p == null) {
                    if (!z2) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f647a.add(t0Var);
                    M();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void r(boolean z2) {
        if (this.f648b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f662p == null) {
            if (!this.C) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f662p.f555c.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z2 && (this.A || this.B)) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.E == null) {
            this.E = new ArrayList();
            this.F = new ArrayList();
        }
        this.f648b = false;
    }

    public final boolean s(boolean z2) {
        r(z2);
        boolean z3 = false;
        while (true) {
            ArrayList arrayList = this.E;
            ArrayList arrayList2 = this.F;
            synchronized (this.f647a) {
                try {
                    if (this.f647a.isEmpty()) {
                        break;
                    }
                    int size = this.f647a.size();
                    boolean zA = false;
                    for (int i2 = 0; i2 < size; i2++) {
                        zA |= ((t0) this.f647a.get(i2)).a(arrayList, arrayList2);
                    }
                    this.f647a.clear();
                    this.f662p.f555c.removeCallbacks(this.I);
                    if (!zA) {
                        break;
                    }
                    z3 = true;
                    this.f648b = true;
                    try {
                        J(this.E, this.F);
                    } finally {
                        d();
                    }
                } finally {
                }
            }
        }
        T();
        if (this.D) {
            this.D = false;
            S();
        }
        this.f649c.f502b.values().removeAll(Collections.singleton(null));
        return z3;
    }

    public final void t(t0 t0Var, boolean z2) {
        if (z2 && (this.f662p == null || this.C)) {
            return;
        }
        r(z2);
        if (t0Var.a(this.E, this.F)) {
            this.f648b = true;
            try {
                J(this.E, this.F);
            } finally {
                d();
            }
        }
        T();
        if (this.D) {
            this.D = false;
            S();
        }
        this.f649c.f502b.values().removeAll(Collections.singleton(null));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(Optimizer.OPTIMIZATION_GRAPH_WRAP);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.f664r;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f664r)));
            sb.append("}");
        } else {
            k0 k0Var = this.f662p;
            if (k0Var != null) {
                sb.append(k0Var.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f662p)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(java.util.ArrayList r21, java.util.ArrayList r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 716
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.w0.u(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    public final Fragment v(int i2) {
        f1 f1Var = this.f649c;
        ArrayList arrayList = f1Var.f501a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) arrayList.get(size);
            if (fragment != null && fragment.mFragmentId == i2) {
                return fragment;
            }
        }
        for (e1 e1Var : f1Var.f502b.values()) {
            if (e1Var != null) {
                Fragment fragment2 = e1Var.f493c;
                if (fragment2.mFragmentId == i2) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public final void w() {
        Iterator it = e().iterator();
        while (it.hasNext()) {
            w1 w1Var = (w1) it.next();
            if (w1Var.f677e) {
                w1Var.f677e = false;
                w1Var.c();
            }
        }
    }

    public final ViewGroup x(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.f663q.c()) {
            View viewB = this.f663q.b(fragment.mContainerId);
            if (viewB instanceof ViewGroup) {
                return (ViewGroup) viewB;
            }
        }
        return null;
    }

    public final p0 y() {
        Fragment fragment = this.f664r;
        return fragment != null ? fragment.mFragmentManager.y() : this.f666t;
    }

    public final n0 z() {
        Fragment fragment = this.f664r;
        return fragment != null ? fragment.mFragmentManager.z() : this.f667u;
    }
}
