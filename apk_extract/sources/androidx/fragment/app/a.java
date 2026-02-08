package androidx.fragment.app;

import android.util.Log;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class a extends h1 implements t0 {

    /* renamed from: p, reason: collision with root package name */
    public final w0 f432p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f433q;

    /* renamed from: r, reason: collision with root package name */
    public int f434r;

    public a(w0 w0Var) {
        w0Var.y();
        k0 k0Var = w0Var.f662p;
        if (k0Var != null) {
            k0Var.f554b.getClassLoader();
        }
        this.f523a = new ArrayList();
        this.f537o = false;
        this.f434r = -1;
        this.f432p = w0Var;
    }

    @Override // androidx.fragment.app.t0
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f529g) {
            return true;
        }
        w0 w0Var = this.f432p;
        if (w0Var.f650d == null) {
            w0Var.f650d = new ArrayList();
        }
        w0Var.f650d.add(this);
        return true;
    }

    @Override // androidx.fragment.app.h1
    public final void c(int i2, Fragment fragment, String str, int i3) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.mTag;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i2 != 0) {
            if (i2 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i4 = fragment.mFragmentId;
            if (i4 != 0 && i4 != i2) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i2);
            }
            fragment.mFragmentId = i2;
            fragment.mContainerId = i2;
        }
        b(new g1(fragment, i3));
        fragment.mFragmentManager = this.f432p;
    }

    public final void d(int i2) {
        if (this.f529g) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i2);
            }
            ArrayList arrayList = this.f523a;
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                g1 g1Var = (g1) arrayList.get(i3);
                Fragment fragment = g1Var.f513b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i2;
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "Bump nesting of " + g1Var.f513b + " to " + g1Var.f513b.mBackStackNesting);
                    }
                }
            }
        }
    }

    public final int e(boolean z2) {
        if (this.f433q) {
            throw new IllegalStateException("commit already called");
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new s1());
            f("  ", printWriter, true);
            printWriter.close();
        }
        this.f433q = true;
        boolean z3 = this.f529g;
        w0 w0Var = this.f432p;
        if (z3) {
            this.f434r = w0Var.f655i.getAndIncrement();
        } else {
            this.f434r = -1;
        }
        w0Var.q(this, z2);
        return this.f434r;
    }

    public final void f(String str, PrintWriter printWriter, boolean z2) {
        String str2;
        if (z2) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f530h);
            printWriter.print(" mIndex=");
            printWriter.print(this.f434r);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f433q);
            if (this.f528f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f528f));
            }
            if (this.f524b != 0 || this.f525c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f524b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f525c));
            }
            if (this.f526d != 0 || this.f527e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f526d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f527e));
            }
            if (this.f531i != 0 || this.f532j != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f531i));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f532j);
            }
            if (this.f533k != 0 || this.f534l != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f533k));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f534l);
            }
        }
        ArrayList arrayList = this.f523a;
        if (arrayList.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            g1 g1Var = (g1) arrayList.get(i2);
            switch (g1Var.f512a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + g1Var.f512a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i2);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(g1Var.f513b);
            if (z2) {
                if (g1Var.f514c != 0 || g1Var.f515d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(g1Var.f514c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(g1Var.f515d));
                }
                if (g1Var.f516e != 0 || g1Var.f517f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(g1Var.f516e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(g1Var.f517f));
                }
            }
        }
    }

    public final void g() {
        ArrayList arrayList = this.f523a;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            g1 g1Var = (g1) arrayList.get(i2);
            Fragment fragment = g1Var.f513b;
            if (fragment != null) {
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.f528f);
                fragment.setSharedElementNames(this.f535m, this.f536n);
            }
            int i3 = g1Var.f512a;
            w0 w0Var = this.f432p;
            switch (i3) {
                case 1:
                    fragment.setAnimations(g1Var.f514c, g1Var.f515d, g1Var.f516e, g1Var.f517f);
                    w0Var.N(fragment, false);
                    w0Var.a(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + g1Var.f512a);
                case 3:
                    fragment.setAnimations(g1Var.f514c, g1Var.f515d, g1Var.f516e, g1Var.f517f);
                    w0Var.I(fragment);
                    break;
                case 4:
                    fragment.setAnimations(g1Var.f514c, g1Var.f515d, g1Var.f516e, g1Var.f517f);
                    w0Var.A(fragment);
                    break;
                case 5:
                    fragment.setAnimations(g1Var.f514c, g1Var.f515d, g1Var.f516e, g1Var.f517f);
                    w0Var.N(fragment, false);
                    w0.R(fragment);
                    break;
                case 6:
                    fragment.setAnimations(g1Var.f514c, g1Var.f515d, g1Var.f516e, g1Var.f517f);
                    w0Var.g(fragment);
                    break;
                case 7:
                    fragment.setAnimations(g1Var.f514c, g1Var.f515d, g1Var.f516e, g1Var.f517f);
                    w0Var.N(fragment, false);
                    w0Var.c(fragment);
                    break;
                case 8:
                    w0Var.P(fragment);
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                    w0Var.P(null);
                    break;
                case 10:
                    w0Var.O(fragment, g1Var.f519h);
                    break;
            }
        }
    }

    public final void h() {
        ArrayList arrayList = this.f523a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            g1 g1Var = (g1) arrayList.get(size);
            Fragment fragment = g1Var.f513b;
            if (fragment != null) {
                fragment.setPopDirection(true);
                int i2 = this.f528f;
                fragment.setNextTransition(i2 != 4097 ? i2 != 4099 ? i2 != 8194 ? 0 : 4097 : 4099 : 8194);
                fragment.setSharedElementNames(this.f536n, this.f535m);
            }
            int i3 = g1Var.f512a;
            w0 w0Var = this.f432p;
            switch (i3) {
                case 1:
                    fragment.setAnimations(g1Var.f514c, g1Var.f515d, g1Var.f516e, g1Var.f517f);
                    w0Var.N(fragment, true);
                    w0Var.I(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + g1Var.f512a);
                case 3:
                    fragment.setAnimations(g1Var.f514c, g1Var.f515d, g1Var.f516e, g1Var.f517f);
                    w0Var.a(fragment);
                    break;
                case 4:
                    fragment.setAnimations(g1Var.f514c, g1Var.f515d, g1Var.f516e, g1Var.f517f);
                    w0Var.getClass();
                    w0.R(fragment);
                    break;
                case 5:
                    fragment.setAnimations(g1Var.f514c, g1Var.f515d, g1Var.f516e, g1Var.f517f);
                    w0Var.N(fragment, true);
                    w0Var.A(fragment);
                    break;
                case 6:
                    fragment.setAnimations(g1Var.f514c, g1Var.f515d, g1Var.f516e, g1Var.f517f);
                    w0Var.c(fragment);
                    break;
                case 7:
                    fragment.setAnimations(g1Var.f514c, g1Var.f515d, g1Var.f516e, g1Var.f517f);
                    w0Var.N(fragment, true);
                    w0Var.g(fragment);
                    break;
                case 8:
                    w0Var.P(null);
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                    w0Var.P(fragment);
                    break;
                case 10:
                    w0Var.O(fragment, g1Var.f518g);
                    break;
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(Optimizer.OPTIMIZATION_GRAPH_WRAP);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f434r >= 0) {
            sb.append(" #");
            sb.append(this.f434r);
        }
        if (this.f530h != null) {
            sb.append(" ");
            sb.append(this.f530h);
        }
        sb.append("}");
        return sb.toString();
    }
}
