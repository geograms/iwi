package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {

    /* renamed from: a, reason: collision with root package name */
    public boolean f690a;

    /* renamed from: b, reason: collision with root package name */
    public int f691b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f692c;

    /* renamed from: d, reason: collision with root package name */
    public View[] f693d;

    /* renamed from: e, reason: collision with root package name */
    public final SparseIntArray f694e;

    /* renamed from: f, reason: collision with root package name */
    public final SparseIntArray f695f;

    /* renamed from: g, reason: collision with root package name */
    public final d0 f696g;

    /* renamed from: h, reason: collision with root package name */
    public final Rect f697h;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f690a = false;
        this.f691b = -1;
        this.f694e = new SparseIntArray();
        this.f695f = new SparseIntArray();
        this.f696g = new d0();
        this.f697h = new Rect();
        y(h1.getProperties(context, attributeSet, i2, i3).f812b);
    }

    @Override // androidx.recyclerview.widget.h1
    public final boolean checkLayoutParams(i1 i1Var) {
        return i1Var instanceof e0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void collectPrefetchPositionsForLayoutState(w1 w1Var, i0 i0Var, f1 f1Var) {
        int i2;
        int i3 = this.f691b;
        for (int i4 = 0; i4 < this.f691b && (i2 = i0Var.f843d) >= 0 && i2 < w1Var.b() && i3 > 0; i4++) {
            ((a0) f1Var).a(i0Var.f843d, Math.max(0, i0Var.f846g));
            this.f696g.getClass();
            i3--;
            i0Var.f843d += i0Var.f844e;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.h1
    public final int computeHorizontalScrollOffset(w1 w1Var) {
        return super.computeHorizontalScrollOffset(w1Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.h1
    public final int computeHorizontalScrollRange(w1 w1Var) {
        return super.computeHorizontalScrollRange(w1Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.h1
    public final int computeVerticalScrollOffset(w1 w1Var) {
        return super.computeVerticalScrollOffset(w1Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.h1
    public final int computeVerticalScrollRange(w1 w1Var) {
        return super.computeVerticalScrollRange(w1Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final View findReferenceChild(p1 p1Var, w1 w1Var, int i2, int i3, int i4) {
        ensureLayoutState();
        int iH = this.mOrientationHelper.h();
        int iF = this.mOrientationHelper.f();
        int i5 = i3 > i2 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            int position = getPosition(childAt);
            if (position >= 0 && position < i4 && v(position, p1Var, w1Var) == 0) {
                if (((i1) childAt.getLayoutParams()).f852a.isRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.mOrientationHelper.e(childAt) < iF && this.mOrientationHelper.b(childAt) >= iH) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i2 += i5;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.h1
    public final i1 generateDefaultLayoutParams() {
        return this.mOrientation == 0 ? new e0(-2, -1) : new e0(-1, -2);
    }

    @Override // androidx.recyclerview.widget.h1
    public final i1 generateLayoutParams(Context context, AttributeSet attributeSet) {
        e0 e0Var = new e0(context, attributeSet);
        e0Var.f775e = -1;
        e0Var.f776f = 0;
        return e0Var;
    }

    @Override // androidx.recyclerview.widget.h1
    public final int getColumnCountForAccessibility(p1 p1Var, w1 w1Var) {
        if (this.mOrientation == 1) {
            return this.f691b;
        }
        if (w1Var.b() < 1) {
            return 0;
        }
        return u(w1Var.b() - 1, p1Var, w1Var) + 1;
    }

    @Override // androidx.recyclerview.widget.h1
    public final int getRowCountForAccessibility(p1 p1Var, w1 w1Var) {
        if (this.mOrientation == 0) {
            return this.f691b;
        }
        if (w1Var.b() < 1) {
            return 0;
        }
        return u(w1Var.b() - 1, p1Var, w1Var) + 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b0  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void layoutChunk(androidx.recyclerview.widget.p1 r19, androidx.recyclerview.widget.w1 r20, androidx.recyclerview.widget.i0 r21, androidx.recyclerview.widget.h0 r22) {
        /*
            Method dump skipped, instructions count: 662
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.layoutChunk(androidx.recyclerview.widget.p1, androidx.recyclerview.widget.w1, androidx.recyclerview.widget.i0, androidx.recyclerview.widget.h0):void");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void onAnchorReady(p1 p1Var, w1 w1Var, g0 g0Var, int i2) {
        super.onAnchorReady(p1Var, w1Var, g0Var, i2);
        z();
        if (w1Var.b() > 0 && !w1Var.f982g) {
            boolean z2 = i2 == 1;
            int iV = v(g0Var.f807b, p1Var, w1Var);
            if (z2) {
                while (iV > 0) {
                    int i3 = g0Var.f807b;
                    if (i3 <= 0) {
                        break;
                    }
                    int i4 = i3 - 1;
                    g0Var.f807b = i4;
                    iV = v(i4, p1Var, w1Var);
                }
            } else {
                int iB = w1Var.b() - 1;
                int i5 = g0Var.f807b;
                while (i5 < iB) {
                    int i6 = i5 + 1;
                    int iV2 = v(i6, p1Var, w1Var);
                    if (iV2 <= iV) {
                        break;
                    }
                    i5 = i6;
                    iV = iV2;
                }
                g0Var.f807b = i5;
            }
        }
        s();
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d1, code lost:
    
        if (r13 == (r2 > r15)) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x010f  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.h1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View onFocusSearchFailed(android.view.View r24, int r25, androidx.recyclerview.widget.p1 r26, androidx.recyclerview.widget.w1 r27) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.p1, androidx.recyclerview.widget.w1):android.view.View");
    }

    @Override // androidx.recyclerview.widget.h1
    public final void onInitializeAccessibilityNodeInfoForItem(p1 p1Var, w1 w1Var, View view, r.g gVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof e0)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, gVar);
            return;
        }
        e0 e0Var = (e0) layoutParams;
        int iU = u(e0Var.f852a.getLayoutPosition(), p1Var, w1Var);
        if (this.mOrientation == 0) {
            gVar.g(c.a.a(e0Var.f775e, e0Var.f776f, iU, 1, false, false));
        } else {
            gVar.g(c.a.a(iU, 1, e0Var.f775e, e0Var.f776f, false, false));
        }
    }

    @Override // androidx.recyclerview.widget.h1
    public final void onItemsAdded(RecyclerView recyclerView, int i2, int i3) {
        d0 d0Var = this.f696g;
        d0Var.b();
        d0Var.f766b.clear();
    }

    @Override // androidx.recyclerview.widget.h1
    public final void onItemsChanged(RecyclerView recyclerView) {
        d0 d0Var = this.f696g;
        d0Var.b();
        d0Var.f766b.clear();
    }

    @Override // androidx.recyclerview.widget.h1
    public final void onItemsMoved(RecyclerView recyclerView, int i2, int i3, int i4) {
        d0 d0Var = this.f696g;
        d0Var.b();
        d0Var.f766b.clear();
    }

    @Override // androidx.recyclerview.widget.h1
    public final void onItemsRemoved(RecyclerView recyclerView, int i2, int i3) {
        d0 d0Var = this.f696g;
        d0Var.b();
        d0Var.f766b.clear();
    }

    @Override // androidx.recyclerview.widget.h1
    public final void onItemsUpdated(RecyclerView recyclerView, int i2, int i3, Object obj) {
        d0 d0Var = this.f696g;
        d0Var.b();
        d0Var.f766b.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.h1
    public final void onLayoutChildren(p1 p1Var, w1 w1Var) {
        boolean z2 = w1Var.f982g;
        SparseIntArray sparseIntArray = this.f695f;
        SparseIntArray sparseIntArray2 = this.f694e;
        if (z2) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                e0 e0Var = (e0) getChildAt(i2).getLayoutParams();
                int layoutPosition = e0Var.f852a.getLayoutPosition();
                sparseIntArray2.put(layoutPosition, e0Var.f776f);
                sparseIntArray.put(layoutPosition, e0Var.f775e);
            }
        }
        super.onLayoutChildren(p1Var, w1Var);
        sparseIntArray2.clear();
        sparseIntArray.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.h1
    public final void onLayoutCompleted(w1 w1Var) {
        super.onLayoutCompleted(w1Var);
        this.f690a = false;
    }

    public final void r(int i2) {
        int i3;
        int[] iArr = this.f692c;
        int i4 = this.f691b;
        if (iArr == null || iArr.length != i4 + 1 || iArr[iArr.length - 1] != i2) {
            iArr = new int[i4 + 1];
        }
        int i5 = 0;
        iArr[0] = 0;
        int i6 = i2 / i4;
        int i7 = i2 % i4;
        int i8 = 0;
        for (int i9 = 1; i9 <= i4; i9++) {
            i5 += i7;
            if (i5 <= 0 || i4 - i5 >= i7) {
                i3 = i6;
            } else {
                i3 = i6 + 1;
                i5 -= i4;
            }
            i8 += i3;
            iArr[i9] = i8;
        }
        this.f692c = iArr;
    }

    public final void s() {
        View[] viewArr = this.f693d;
        if (viewArr == null || viewArr.length != this.f691b) {
            this.f693d = new View[this.f691b];
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.h1
    public final int scrollHorizontallyBy(int i2, p1 p1Var, w1 w1Var) {
        z();
        s();
        return super.scrollHorizontallyBy(i2, p1Var, w1Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.h1
    public final int scrollVerticallyBy(int i2, p1 p1Var, w1 w1Var) {
        z();
        s();
        return super.scrollVerticallyBy(i2, p1Var, w1Var);
    }

    @Override // androidx.recyclerview.widget.h1
    public final void setMeasuredDimension(Rect rect, int i2, int i3) {
        int iChooseSize;
        int iChooseSize2;
        if (this.f692c == null) {
            super.setMeasuredDimension(rect, i2, i3);
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.mOrientation == 1) {
            iChooseSize2 = h1.chooseSize(i3, rect.height() + paddingBottom, getMinimumHeight());
            int[] iArr = this.f692c;
            iChooseSize = h1.chooseSize(i2, iArr[iArr.length - 1] + paddingRight, getMinimumWidth());
        } else {
            iChooseSize = h1.chooseSize(i2, rect.width() + paddingRight, getMinimumWidth());
            int[] iArr2 = this.f692c;
            iChooseSize2 = h1.chooseSize(i3, iArr2[iArr2.length - 1] + paddingBottom, getMinimumHeight());
        }
        setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void setStackFromEnd(boolean z2) {
        if (z2) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.setStackFromEnd(false);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.h1
    public final boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.f690a;
    }

    public final int t(int i2, int i3) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.f692c;
            return iArr[i3 + i2] - iArr[i2];
        }
        int[] iArr2 = this.f692c;
        int i4 = this.f691b;
        return iArr2[i4 - i2] - iArr2[(i4 - i2) - i3];
    }

    public final int u(int i2, p1 p1Var, w1 w1Var) {
        boolean z2 = w1Var.f982g;
        d0 d0Var = this.f696g;
        if (!z2) {
            int i3 = this.f691b;
            d0Var.getClass();
            return d0.a(i2, i3);
        }
        int iB = p1Var.b(i2);
        if (iB != -1) {
            int i4 = this.f691b;
            d0Var.getClass();
            return d0.a(iB, i4);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i2);
        return 0;
    }

    public final int v(int i2, p1 p1Var, w1 w1Var) {
        boolean z2 = w1Var.f982g;
        d0 d0Var = this.f696g;
        if (!z2) {
            int i3 = this.f691b;
            d0Var.getClass();
            return i2 % i3;
        }
        int i4 = this.f695f.get(i2, -1);
        if (i4 != -1) {
            return i4;
        }
        int iB = p1Var.b(i2);
        if (iB != -1) {
            int i5 = this.f691b;
            d0Var.getClass();
            return iB % i5;
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
        return 0;
    }

    public final int w(int i2, p1 p1Var, w1 w1Var) {
        boolean z2 = w1Var.f982g;
        d0 d0Var = this.f696g;
        if (!z2) {
            d0Var.getClass();
            return 1;
        }
        int i3 = this.f694e.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        if (p1Var.b(i2) != -1) {
            d0Var.getClass();
            return 1;
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
        return 1;
    }

    public final void x(View view, int i2, boolean z2) {
        int childMeasureSpec;
        int childMeasureSpec2;
        e0 e0Var = (e0) view.getLayoutParams();
        Rect rect = e0Var.f853b;
        int i3 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) e0Var).topMargin + ((ViewGroup.MarginLayoutParams) e0Var).bottomMargin;
        int i4 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) e0Var).leftMargin + ((ViewGroup.MarginLayoutParams) e0Var).rightMargin;
        int iT = t(e0Var.f775e, e0Var.f776f);
        if (this.mOrientation == 1) {
            childMeasureSpec2 = h1.getChildMeasureSpec(iT, i2, i4, ((ViewGroup.MarginLayoutParams) e0Var).width, false);
            childMeasureSpec = h1.getChildMeasureSpec(this.mOrientationHelper.i(), getHeightMode(), i3, ((ViewGroup.MarginLayoutParams) e0Var).height, true);
        } else {
            int childMeasureSpec3 = h1.getChildMeasureSpec(iT, i2, i3, ((ViewGroup.MarginLayoutParams) e0Var).height, false);
            int childMeasureSpec4 = h1.getChildMeasureSpec(this.mOrientationHelper.i(), getWidthMode(), i4, ((ViewGroup.MarginLayoutParams) e0Var).width, true);
            childMeasureSpec = childMeasureSpec3;
            childMeasureSpec2 = childMeasureSpec4;
        }
        i1 i1Var = (i1) view.getLayoutParams();
        if (z2 ? shouldReMeasureChild(view, childMeasureSpec2, childMeasureSpec, i1Var) : shouldMeasureChild(view, childMeasureSpec2, childMeasureSpec, i1Var)) {
            view.measure(childMeasureSpec2, childMeasureSpec);
        }
    }

    public final void y(int i2) {
        if (i2 == this.f691b) {
            return;
        }
        this.f690a = true;
        if (i2 < 1) {
            throw new IllegalArgumentException(a.a.c("Span count should be at least 1. Provided ", i2));
        }
        this.f691b = i2;
        this.f696g.b();
        requestLayout();
    }

    public final void z() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        r(height - paddingTop);
    }

    @Override // androidx.recyclerview.widget.h1
    public final i1 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            e0 e0Var = new e0((ViewGroup.MarginLayoutParams) layoutParams);
            e0Var.f775e = -1;
            e0Var.f776f = 0;
            return e0Var;
        }
        e0 e0Var2 = new e0(layoutParams);
        e0Var2.f775e = -1;
        e0Var2.f776f = 0;
        return e0Var2;
    }

    public GridLayoutManager(int i2) {
        super(1, false);
        this.f690a = false;
        this.f691b = -1;
        this.f694e = new SparseIntArray();
        this.f695f = new SparseIntArray();
        this.f696g = new d0();
        this.f697h = new Rect();
        y(i2);
    }
}
