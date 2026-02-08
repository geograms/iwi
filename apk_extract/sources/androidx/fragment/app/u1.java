package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class u1 {

    /* renamed from: a, reason: collision with root package name */
    public int f616a;

    /* renamed from: b, reason: collision with root package name */
    public int f617b;

    /* renamed from: c, reason: collision with root package name */
    public final Fragment f618c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f619d;

    /* renamed from: e, reason: collision with root package name */
    public final HashSet f620e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f621f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f622g;

    /* renamed from: h, reason: collision with root package name */
    public final e1 f623h;

    public u1(int i2, int i3, e1 e1Var, n.d dVar) {
        Fragment fragment = e1Var.f493c;
        this.f619d = new ArrayList();
        this.f620e = new HashSet();
        this.f621f = false;
        this.f622g = false;
        this.f616a = i2;
        this.f617b = i3;
        this.f618c = fragment;
        dVar.b(new t(2, this));
        this.f623h = e1Var;
    }

    public final void a() {
        if (this.f621f) {
            return;
        }
        this.f621f = true;
        HashSet hashSet = this.f620e;
        if (hashSet.isEmpty()) {
            b();
            return;
        }
        Iterator it = new ArrayList(hashSet).iterator();
        while (it.hasNext()) {
            ((n.d) it.next()).a();
        }
    }

    public final void b() {
        if (!this.f622g) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f622g = true;
            Iterator it = this.f619d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }
        this.f623h.k();
    }

    public final void c(int i2, int i3) {
        if (i3 == 0) {
            throw null;
        }
        int i4 = i3 - 1;
        Fragment fragment = this.f618c;
        if (i4 == 0) {
            if (this.f616a != 1) {
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + fragment + " mFinalState = " + v1.g(this.f616a) + " -> " + v1.g(i2) + ". ");
                }
                this.f616a = i2;
                return;
            }
            return;
        }
        if (i4 == 1) {
            if (this.f616a == 1) {
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + fragment + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + v1.f(this.f617b) + " to ADDING.");
                }
                this.f616a = 2;
                this.f617b = 2;
                return;
            }
            return;
        }
        if (i4 != 2) {
            return;
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + fragment + " mFinalState = " + v1.g(this.f616a) + " -> REMOVED. mLifecycleImpact  = " + v1.f(this.f617b) + " to REMOVING.");
        }
        this.f616a = 1;
        this.f617b = 3;
    }

    public final void d() {
        if (this.f617b == 2) {
            e1 e1Var = this.f623h;
            Fragment fragment = e1Var.f493c;
            View viewFindFocus = fragment.mView.findFocus();
            if (viewFindFocus != null) {
                fragment.setFocusedView(viewFindFocus);
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragment);
                }
            }
            View viewRequireView = this.f618c.requireView();
            if (viewRequireView.getParent() == null) {
                e1Var.b();
                viewRequireView.setAlpha(0.0f);
            }
            if (viewRequireView.getAlpha() == 0.0f && viewRequireView.getVisibility() == 0) {
                viewRequireView.setVisibility(4);
            }
            viewRequireView.setAlpha(fragment.getPostOnViewCreatedAlpha());
        }
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final String toString() {
        return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + v1.g(this.f616a) + "} {mLifecycleImpact = " + v1.f(this.f617b) + "} {mFragment = " + this.f618c + "}";
    }
}
