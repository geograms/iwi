package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final u0 f837a;

    /* renamed from: b, reason: collision with root package name */
    public final h f838b = new h();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f839c = new ArrayList();

    public i(u0 u0Var) {
        this.f837a = u0Var;
    }

    public final void a(View view, int i2, boolean z2) {
        u0 u0Var = this.f837a;
        int childCount = i2 < 0 ? u0Var.f972a.getChildCount() : f(i2);
        this.f838b.e(childCount, z2);
        if (z2) {
            i(view);
        }
        RecyclerView recyclerView = u0Var.f972a;
        recyclerView.addView(view, childCount);
        recyclerView.dispatchChildAttached(view);
    }

    public final void b(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z2) {
        u0 u0Var = this.f837a;
        int childCount = i2 < 0 ? u0Var.f972a.getChildCount() : f(i2);
        this.f838b.e(childCount, z2);
        if (z2) {
            i(view);
        }
        u0Var.getClass();
        z1 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        RecyclerView recyclerView = u0Var.f972a;
        if (childViewHolderInt != null) {
            if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                StringBuilder sb = new StringBuilder("Called attach on a child which is not detached: ");
                sb.append(childViewHolderInt);
                throw new IllegalArgumentException(a.a.b(recyclerView, sb));
            }
            childViewHolderInt.clearTmpDetachFlag();
        }
        recyclerView.attachViewToParent(view, childCount, layoutParams);
    }

    public final void c(int i2) {
        z1 childViewHolderInt;
        int iF = f(i2);
        this.f838b.f(iF);
        RecyclerView recyclerView = this.f837a.f972a;
        View childAt = recyclerView.getChildAt(iF);
        if (childAt != null && (childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt)) != null) {
            if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                StringBuilder sb = new StringBuilder("called detach on an already detached child ");
                sb.append(childViewHolderInt);
                throw new IllegalArgumentException(a.a.b(recyclerView, sb));
            }
            childViewHolderInt.addFlags(256);
        }
        recyclerView.detachViewFromParent(iF);
    }

    public final View d(int i2) {
        return this.f837a.f972a.getChildAt(f(i2));
    }

    public final int e() {
        return this.f837a.f972a.getChildCount() - this.f839c.size();
    }

    public final int f(int i2) {
        if (i2 < 0) {
            return -1;
        }
        int childCount = this.f837a.f972a.getChildCount();
        int i3 = i2;
        while (i3 < childCount) {
            h hVar = this.f838b;
            int iB = i2 - (i3 - hVar.b(i3));
            if (iB == 0) {
                while (hVar.d(i3)) {
                    i3++;
                }
                return i3;
            }
            i3 += iB;
        }
        return -1;
    }

    public final View g(int i2) {
        return this.f837a.f972a.getChildAt(i2);
    }

    public final int h() {
        return this.f837a.f972a.getChildCount();
    }

    public final void i(View view) {
        this.f839c.add(view);
        u0 u0Var = this.f837a;
        u0Var.getClass();
        z1 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            childViewHolderInt.onEnteredHiddenState(u0Var.f972a);
        }
    }

    public final int j(View view) {
        int iIndexOfChild = this.f837a.f972a.indexOfChild(view);
        if (iIndexOfChild == -1) {
            return -1;
        }
        h hVar = this.f838b;
        if (hVar.d(iIndexOfChild)) {
            return -1;
        }
        return iIndexOfChild - hVar.b(iIndexOfChild);
    }

    public final boolean k(View view) {
        return this.f839c.contains(view);
    }

    public final void l(View view) {
        if (this.f839c.remove(view)) {
            u0 u0Var = this.f837a;
            u0Var.getClass();
            z1 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onLeftHiddenState(u0Var.f972a);
            }
        }
    }

    public final String toString() {
        return this.f838b.toString() + ", hidden list:" + this.f839c.size();
    }
}
