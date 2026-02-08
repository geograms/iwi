package androidx.recyclerview.widget;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class a0 implements f1 {

    /* renamed from: a, reason: collision with root package name */
    public int f724a;

    /* renamed from: b, reason: collision with root package name */
    public int f725b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f726c;

    /* renamed from: d, reason: collision with root package name */
    public int f727d;

    public final void a(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }
        int i4 = this.f727d;
        int i5 = i4 * 2;
        int[] iArr = this.f726c;
        if (iArr == null) {
            int[] iArr2 = new int[4];
            this.f726c = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i5 >= iArr.length) {
            int[] iArr3 = new int[i4 * 4];
            this.f726c = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        }
        int[] iArr4 = this.f726c;
        iArr4[i5] = i2;
        iArr4[i5 + 1] = i3;
        this.f727d++;
    }

    public final void b(RecyclerView recyclerView, boolean z2) {
        this.f727d = 0;
        int[] iArr = this.f726c;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        h1 h1Var = recyclerView.mLayout;
        if (recyclerView.mAdapter == null || h1Var == null || !h1Var.isItemPrefetchEnabled()) {
            return;
        }
        if (z2) {
            if (!recyclerView.mAdapterHelper.g()) {
                h1Var.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
            }
        } else if (!recyclerView.hasPendingAdapterUpdates()) {
            h1Var.collectAdjacentPrefetchPositions(this.f724a, this.f725b, recyclerView.mState, this);
        }
        int i2 = this.f727d;
        if (i2 > h1Var.mPrefetchMaxCountObserved) {
            h1Var.mPrefetchMaxCountObserved = i2;
            h1Var.mPrefetchMaxObservedInInitialPrefetch = z2;
            recyclerView.mRecycler.l();
        }
    }
}
