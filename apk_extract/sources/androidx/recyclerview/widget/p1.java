package androidx.recyclerview.widget;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class p1 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f925a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f926b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f927c;

    /* renamed from: d, reason: collision with root package name */
    public final List f928d;

    /* renamed from: e, reason: collision with root package name */
    public int f929e;

    /* renamed from: f, reason: collision with root package name */
    public int f930f;

    /* renamed from: g, reason: collision with root package name */
    public o1 f931g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f932h;

    public p1(RecyclerView recyclerView) {
        this.f932h = recyclerView;
        ArrayList arrayList = new ArrayList();
        this.f925a = arrayList;
        this.f926b = null;
        this.f927c = new ArrayList();
        this.f928d = Collections.unmodifiableList(arrayList);
        this.f929e = 2;
        this.f930f = 2;
    }

    public static void d(ViewGroup viewGroup, boolean z2) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof ViewGroup) {
                d((ViewGroup) childAt, true);
            }
        }
        if (z2) {
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(4);
            } else {
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }
    }

    public final void a(z1 z1Var, boolean z2) {
        RecyclerView.clearNestedRecyclerViewIfNotNested(z1Var);
        View view = z1Var.itemView;
        RecyclerView recyclerView = this.f932h;
        b2 b2Var = recyclerView.mAccessibilityDelegate;
        if (b2Var != null) {
            androidx.core.view.c itemDelegate = b2Var.getItemDelegate();
            androidx.core.view.d1.k(view, itemDelegate instanceof a2 ? (androidx.core.view.c) ((a2) itemDelegate).f729b.remove(view) : null);
        }
        if (z2) {
            v0 v0Var = recyclerView.mAdapter;
            if (v0Var != null) {
                v0Var.onViewRecycled(z1Var);
            }
            if (recyclerView.mState != null) {
                recyclerView.mViewInfoStore.d(z1Var);
            }
        }
        z1Var.mOwnerRecyclerView = null;
        o1 o1VarC = c();
        o1VarC.getClass();
        int itemViewType = z1Var.getItemViewType();
        ArrayList arrayList = o1VarC.a(itemViewType).f897a;
        if (((n1) o1VarC.f909a.get(itemViewType)).f898b <= arrayList.size()) {
            return;
        }
        z1Var.resetInternal();
        arrayList.add(z1Var);
    }

    public final int b(int i2) {
        RecyclerView recyclerView = this.f932h;
        if (i2 >= 0 && i2 < recyclerView.mState.b()) {
            return !recyclerView.mState.f982g ? i2 : recyclerView.mAdapterHelper.f(i2, 0);
        }
        throw new IndexOutOfBoundsException("invalid position " + i2 + ". State item count is " + recyclerView.mState.b() + recyclerView.exceptionLabel());
    }

    public final o1 c() {
        if (this.f931g == null) {
            o1 o1Var = new o1();
            o1Var.f909a = new SparseArray();
            o1Var.f910b = 0;
            this.f931g = o1Var;
        }
        return this.f931g;
    }

    public final void e() {
        ArrayList arrayList = this.f927c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            f(size);
        }
        arrayList.clear();
        if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
            a0 a0Var = this.f932h.mPrefetchRegistry;
            int[] iArr = a0Var.f726c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            a0Var.f727d = 0;
        }
    }

    public final void f(int i2) {
        ArrayList arrayList = this.f927c;
        a((z1) arrayList.get(i2), true);
        arrayList.remove(i2);
    }

    public final void g(View view) {
        z1 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        boolean zIsTmpDetached = childViewHolderInt.isTmpDetached();
        RecyclerView recyclerView = this.f932h;
        if (zIsTmpDetached) {
            recyclerView.removeDetachedView(view, false);
        }
        if (childViewHolderInt.isScrap()) {
            childViewHolderInt.unScrap();
        } else if (childViewHolderInt.wasReturnedFromScrap()) {
            childViewHolderInt.clearReturnedFromScrapFlag();
        }
        h(childViewHolderInt);
        if (recyclerView.mItemAnimator == null || childViewHolderInt.isRecyclable()) {
            return;
        }
        recyclerView.mItemAnimator.d(childViewHolderInt);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0092, code lost:
    
        r5 = r5 - 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(androidx.recyclerview.widget.z1 r12) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.p1.h(androidx.recyclerview.widget.z1):void");
    }

    public final void i(View view) {
        z1 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        boolean zHasAnyOfTheFlags = childViewHolderInt.hasAnyOfTheFlags(12);
        RecyclerView recyclerView = this.f932h;
        if (!zHasAnyOfTheFlags && childViewHolderInt.isUpdated() && !recyclerView.canReuseUpdatedViewHolder(childViewHolderInt)) {
            if (this.f926b == null) {
                this.f926b = new ArrayList();
            }
            childViewHolderInt.setScrapContainer(this, true);
            this.f926b.add(childViewHolderInt);
            return;
        }
        if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !recyclerView.mAdapter.hasStableIds()) {
            throw new IllegalArgumentException(a.a.b(recyclerView, new StringBuilder("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
        }
        childViewHolderInt.setScrapContainer(this, false);
        this.f925a.add(childViewHolderInt);
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0368 A[PHI: r3 r9
      0x0368: PHI (r3v8 boolean) = (r3v7 boolean), (r3v11 boolean) binds: [B:123:0x0219, B:179:0x0313] A[DONT_GENERATE, DONT_INLINE]
      0x0368: PHI (r9v3 androidx.recyclerview.widget.z1) = (r9v2 androidx.recyclerview.widget.z1), (r9v6 androidx.recyclerview.widget.z1) binds: [B:123:0x0219, B:179:0x0313] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.recyclerview.widget.z1 j(int r25, long r26) {
        /*
            Method dump skipped, instructions count: 1261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.p1.j(int, long):androidx.recyclerview.widget.z1");
    }

    public final void k(z1 z1Var) {
        if (z1Var.mInChangeScrap) {
            this.f926b.remove(z1Var);
        } else {
            this.f925a.remove(z1Var);
        }
        z1Var.mScrapContainer = null;
        z1Var.mInChangeScrap = false;
        z1Var.clearReturnedFromScrapFlag();
    }

    public final void l() {
        h1 h1Var = this.f932h.mLayout;
        this.f930f = this.f929e + (h1Var != null ? h1Var.mPrefetchMaxCountObserved : 0);
        ArrayList arrayList = this.f927c;
        for (int size = arrayList.size() - 1; size >= 0 && arrayList.size() > this.f930f; size--) {
            f(size);
        }
    }
}
