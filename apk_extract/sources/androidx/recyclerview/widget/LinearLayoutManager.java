package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes.dex */
public class LinearLayoutManager extends h1 implements u1 {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final g0 mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final h0 mLayoutChunkResult;
    private i0 mLayoutState;
    int mOrientation;
    q0 mOrientationHelper;
    j0 mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    public LinearLayoutManager() {
        this(1, false);
    }

    @Override // androidx.recyclerview.widget.h1
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public void calculateExtraLayoutSpace(w1 w1Var, int[] iArr) {
        int i2;
        int extraLayoutSpace = getExtraLayoutSpace(w1Var);
        if (this.mLayoutState.f845f == -1) {
            i2 = 0;
        } else {
            i2 = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i2;
    }

    @Override // androidx.recyclerview.widget.h1
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override // androidx.recyclerview.widget.h1
    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    @Override // androidx.recyclerview.widget.h1
    public void collectAdjacentPrefetchPositions(int i2, int i3, w1 w1Var, f1 f1Var) {
        if (this.mOrientation != 0) {
            i2 = i3;
        }
        if (getChildCount() == 0 || i2 == 0) {
            return;
        }
        ensureLayoutState();
        o(i2 > 0 ? 1 : -1, Math.abs(i2), true, w1Var);
        collectPrefetchPositionsForLayoutState(w1Var, this.mLayoutState, f1Var);
    }

    @Override // androidx.recyclerview.widget.h1
    public void collectInitialPrefetchPositions(int i2, f1 f1Var) {
        boolean z2;
        int i3;
        j0 j0Var = this.mPendingSavedState;
        if (j0Var == null || (i3 = j0Var.f864a) < 0) {
            n();
            z2 = this.mShouldReverseLayout;
            i3 = this.mPendingScrollPosition;
            if (i3 == -1) {
                i3 = z2 ? i2 - 1 : 0;
            }
        } else {
            z2 = j0Var.f866c;
        }
        int i4 = z2 ? -1 : 1;
        for (int i5 = 0; i5 < this.mInitialPrefetchItemCount && i3 >= 0 && i3 < i2; i5++) {
            ((a0) f1Var).a(i3, 0);
            i3 += i4;
        }
    }

    public void collectPrefetchPositionsForLayoutState(w1 w1Var, i0 i0Var, f1 f1Var) {
        int i2 = i0Var.f843d;
        if (i2 < 0 || i2 >= w1Var.b()) {
            return;
        }
        ((a0) f1Var).a(i2, Math.max(0, i0Var.f846g));
    }

    @Override // androidx.recyclerview.widget.h1
    public int computeHorizontalScrollExtent(w1 w1Var) {
        return d(w1Var);
    }

    @Override // androidx.recyclerview.widget.h1
    public int computeHorizontalScrollOffset(w1 w1Var) {
        return e(w1Var);
    }

    @Override // androidx.recyclerview.widget.h1
    public int computeHorizontalScrollRange(w1 w1Var) {
        return f(w1Var);
    }

    @Override // androidx.recyclerview.widget.u1
    public PointF computeScrollVectorForPosition(int i2) {
        if (getChildCount() == 0) {
            return null;
        }
        int i3 = (i2 < getPosition(getChildAt(0))) != this.mShouldReverseLayout ? -1 : 1;
        return this.mOrientation == 0 ? new PointF(i3, 0.0f) : new PointF(0.0f, i3);
    }

    @Override // androidx.recyclerview.widget.h1
    public int computeVerticalScrollExtent(w1 w1Var) {
        return d(w1Var);
    }

    @Override // androidx.recyclerview.widget.h1
    public int computeVerticalScrollOffset(w1 w1Var) {
        return e(w1Var);
    }

    @Override // androidx.recyclerview.widget.h1
    public int computeVerticalScrollRange(w1 w1Var) {
        return f(w1Var);
    }

    public int convertFocusDirectionToLayoutDirection(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 17 ? i2 != 33 ? i2 != 66 ? (i2 == 130 && this.mOrientation == 1) ? 1 : Integer.MIN_VALUE : this.mOrientation == 0 ? 1 : Integer.MIN_VALUE : this.mOrientation == 1 ? -1 : Integer.MIN_VALUE : this.mOrientation == 0 ? -1 : Integer.MIN_VALUE : (this.mOrientation != 1 && isLayoutRTL()) ? -1 : 1 : (this.mOrientation != 1 && isLayoutRTL()) ? 1 : -1;
    }

    public i0 createLayoutState() {
        i0 i0Var = new i0();
        i0Var.f840a = true;
        i0Var.f847h = 0;
        i0Var.f848i = 0;
        i0Var.f850k = null;
        return i0Var;
    }

    public final int d(w1 w1Var) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return x0.g.A(w1Var, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    public final int e(w1 w1Var) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return x0.g.B(w1Var, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    public final int f(w1 w1Var) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return x0.g.C(w1Var, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    public int fill(p1 p1Var, i0 i0Var, w1 w1Var, boolean z2) {
        int i2;
        int i3 = i0Var.f842c;
        int i4 = i0Var.f846g;
        if (i4 != Integer.MIN_VALUE) {
            if (i3 < 0) {
                i0Var.f846g = i4 + i3;
            }
            l(p1Var, i0Var);
        }
        int i5 = i0Var.f842c + i0Var.f847h;
        h0 h0Var = this.mLayoutChunkResult;
        while (true) {
            if ((!i0Var.f851l && i5 <= 0) || (i2 = i0Var.f843d) < 0 || i2 >= w1Var.b()) {
                break;
            }
            h0Var.f827a = 0;
            h0Var.f828b = false;
            h0Var.f829c = false;
            h0Var.f830d = false;
            layoutChunk(p1Var, w1Var, i0Var, h0Var);
            if (!h0Var.f828b) {
                int i6 = i0Var.f841b;
                int i7 = h0Var.f827a;
                i0Var.f841b = (i0Var.f845f * i7) + i6;
                if (!h0Var.f829c || i0Var.f850k != null || !w1Var.f982g) {
                    i0Var.f842c -= i7;
                    i5 -= i7;
                }
                int i8 = i0Var.f846g;
                if (i8 != Integer.MIN_VALUE) {
                    int i9 = i8 + i7;
                    i0Var.f846g = i9;
                    int i10 = i0Var.f842c;
                    if (i10 < 0) {
                        i0Var.f846g = i9 + i10;
                    }
                    l(p1Var, i0Var);
                }
                if (z2 && h0Var.f830d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i3 - i0Var.f842c;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public View findFirstVisibleChildClosestToEnd(boolean z2, boolean z3) {
        return this.mShouldReverseLayout ? findOneVisibleChild(0, getChildCount(), z2, z3) : findOneVisibleChild(getChildCount() - 1, -1, z2, z3);
    }

    public View findFirstVisibleChildClosestToStart(boolean z2, boolean z3) {
        return this.mShouldReverseLayout ? findOneVisibleChild(getChildCount() - 1, -1, z2, z3) : findOneVisibleChild(0, getChildCount(), z2, z3);
    }

    public int findFirstVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public View findOnePartiallyOrCompletelyInvisibleChild(int i2, int i3) {
        int i4;
        int i5;
        ensureLayoutState();
        if (i3 <= i2 && i3 >= i2) {
            return getChildAt(i2);
        }
        if (this.mOrientationHelper.e(getChildAt(i2)) < this.mOrientationHelper.h()) {
            i4 = 16644;
            i5 = 16388;
        } else {
            i4 = 4161;
            i5 = 4097;
        }
        return this.mOrientation == 0 ? this.mHorizontalBoundCheck.a(i2, i3, i4, i5) : this.mVerticalBoundCheck.a(i2, i3, i4, i5);
    }

    public View findOneVisibleChild(int i2, int i3, boolean z2, boolean z3) {
        ensureLayoutState();
        int i4 = z2 ? 24579 : 320;
        int i5 = z3 ? 320 : 0;
        return this.mOrientation == 0 ? this.mHorizontalBoundCheck.a(i2, i3, i4, i5) : this.mVerticalBoundCheck.a(i2, i3, i4, i5);
    }

    public View findReferenceChild(p1 p1Var, w1 w1Var, int i2, int i3, int i4) {
        ensureLayoutState();
        int iH = this.mOrientationHelper.h();
        int iF = this.mOrientationHelper.f();
        int i5 = i3 > i2 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            int position = getPosition(childAt);
            if (position >= 0 && position < i4) {
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

    @Override // androidx.recyclerview.widget.h1
    public View findViewByPosition(int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i2 - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i2) {
                return childAt;
            }
        }
        return super.findViewByPosition(i2);
    }

    public final int g(int i2, p1 p1Var, w1 w1Var, boolean z2) {
        int iF;
        int iF2 = this.mOrientationHelper.f() - i2;
        if (iF2 <= 0) {
            return 0;
        }
        int i3 = -scrollBy(-iF2, p1Var, w1Var);
        int i4 = i2 + i3;
        if (!z2 || (iF = this.mOrientationHelper.f() - i4) <= 0) {
            return i3;
        }
        this.mOrientationHelper.m(iF);
        return iF + i3;
    }

    @Override // androidx.recyclerview.widget.h1
    public i1 generateDefaultLayoutParams() {
        return new i1(-2, -2);
    }

    @Deprecated
    public int getExtraLayoutSpace(w1 w1Var) {
        if (w1Var.f976a != -1) {
            return this.mOrientationHelper.i();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    public final int h(int i2, p1 p1Var, w1 w1Var, boolean z2) {
        int iH;
        int iH2 = i2 - this.mOrientationHelper.h();
        if (iH2 <= 0) {
            return 0;
        }
        int i3 = -scrollBy(iH2, p1Var, w1Var);
        int i4 = i2 + i3;
        if (!z2 || (iH = i4 - this.mOrientationHelper.h()) <= 0) {
            return i3;
        }
        this.mOrientationHelper.m(-iH);
        return i3 - iH;
    }

    public final View i() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    @Override // androidx.recyclerview.widget.h1
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    public final View j() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    public final void k() {
        Log.d(TAG, "internal representation of views on the screen");
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            Log.d(TAG, "item " + getPosition(childAt) + ", coord:" + this.mOrientationHelper.e(childAt));
        }
        Log.d(TAG, "==============");
    }

    public final void l(p1 p1Var, i0 i0Var) {
        int width;
        if (!i0Var.f840a || i0Var.f851l) {
            return;
        }
        int i2 = i0Var.f846g;
        int i3 = i0Var.f848i;
        if (i0Var.f845f != -1) {
            if (i2 < 0) {
                return;
            }
            int i4 = i2 - i3;
            int childCount = getChildCount();
            if (!this.mShouldReverseLayout) {
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = getChildAt(i5);
                    if (this.mOrientationHelper.b(childAt) > i4 || this.mOrientationHelper.k(childAt) > i4) {
                        m(p1Var, 0, i5);
                        return;
                    }
                }
                return;
            }
            int i6 = childCount - 1;
            for (int i7 = i6; i7 >= 0; i7--) {
                View childAt2 = getChildAt(i7);
                if (this.mOrientationHelper.b(childAt2) > i4 || this.mOrientationHelper.k(childAt2) > i4) {
                    m(p1Var, i6, i7);
                    return;
                }
            }
            return;
        }
        int childCount2 = getChildCount();
        if (i2 < 0) {
            return;
        }
        p0 p0Var = (p0) this.mOrientationHelper;
        int i8 = p0Var.f924d;
        h1 h1Var = p0Var.f940a;
        switch (i8) {
            case 0:
                width = h1Var.getWidth();
                break;
            default:
                width = h1Var.getHeight();
                break;
        }
        int i9 = (width - i2) + i3;
        if (this.mShouldReverseLayout) {
            for (int i10 = 0; i10 < childCount2; i10++) {
                View childAt3 = getChildAt(i10);
                if (this.mOrientationHelper.e(childAt3) < i9 || this.mOrientationHelper.l(childAt3) < i9) {
                    m(p1Var, 0, i10);
                    return;
                }
            }
            return;
        }
        int i11 = childCount2 - 1;
        for (int i12 = i11; i12 >= 0; i12--) {
            View childAt4 = getChildAt(i12);
            if (this.mOrientationHelper.e(childAt4) < i9 || this.mOrientationHelper.l(childAt4) < i9) {
                m(p1Var, i11, i12);
                return;
            }
        }
    }

    public void layoutChunk(p1 p1Var, w1 w1Var, i0 i0Var, h0 h0Var) {
        int i2;
        int i3;
        int i4;
        int paddingLeft;
        int iD;
        View viewB = i0Var.b(p1Var);
        if (viewB == null) {
            h0Var.f828b = true;
            return;
        }
        i1 i1Var = (i1) viewB.getLayoutParams();
        if (i0Var.f850k == null) {
            if (this.mShouldReverseLayout == (i0Var.f845f == -1)) {
                addView(viewB);
            } else {
                addView(viewB, 0);
            }
        } else {
            if (this.mShouldReverseLayout == (i0Var.f845f == -1)) {
                addDisappearingView(viewB);
            } else {
                addDisappearingView(viewB, 0);
            }
        }
        measureChildWithMargins(viewB, 0, 0);
        h0Var.f827a = this.mOrientationHelper.c(viewB);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                iD = getWidth() - getPaddingRight();
                paddingLeft = iD - this.mOrientationHelper.d(viewB);
            } else {
                paddingLeft = getPaddingLeft();
                iD = this.mOrientationHelper.d(viewB) + paddingLeft;
            }
            if (i0Var.f845f == -1) {
                int i5 = i0Var.f841b;
                i4 = i5;
                i3 = iD;
                i2 = i5 - h0Var.f827a;
            } else {
                int i6 = i0Var.f841b;
                i2 = i6;
                i3 = iD;
                i4 = h0Var.f827a + i6;
            }
        } else {
            int paddingTop = getPaddingTop();
            int iD2 = this.mOrientationHelper.d(viewB) + paddingTop;
            if (i0Var.f845f == -1) {
                int i7 = i0Var.f841b;
                i3 = i7;
                i2 = paddingTop;
                i4 = iD2;
                paddingLeft = i7 - h0Var.f827a;
            } else {
                int i8 = i0Var.f841b;
                i2 = paddingTop;
                i3 = h0Var.f827a + i8;
                i4 = iD2;
                paddingLeft = i8;
            }
        }
        layoutDecoratedWithMargins(viewB, paddingLeft, i2, i3, i4);
        if (i1Var.f852a.isRemoved() || i1Var.f852a.isUpdated()) {
            h0Var.f829c = true;
        }
        h0Var.f830d = viewB.hasFocusable();
    }

    public final void m(p1 p1Var, int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        if (i3 <= i2) {
            while (i2 > i3) {
                removeAndRecycleViewAt(i2, p1Var);
                i2--;
            }
        } else {
            for (int i4 = i3 - 1; i4 >= i2; i4--) {
                removeAndRecycleViewAt(i4, p1Var);
            }
        }
    }

    public final void n() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    public final void o(int i2, int i3, boolean z2, w1 w1Var) {
        int iH;
        int paddingRight;
        this.mLayoutState.f851l = resolveIsInfinite();
        this.mLayoutState.f845f = i2;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(w1Var, iArr);
        int iMax = Math.max(0, this.mReusableIntPair[0]);
        int iMax2 = Math.max(0, this.mReusableIntPair[1]);
        boolean z3 = i2 == 1;
        i0 i0Var = this.mLayoutState;
        int i4 = z3 ? iMax2 : iMax;
        i0Var.f847h = i4;
        if (!z3) {
            iMax = iMax2;
        }
        i0Var.f848i = iMax;
        if (z3) {
            p0 p0Var = (p0) this.mOrientationHelper;
            int i5 = p0Var.f924d;
            h1 h1Var = p0Var.f940a;
            switch (i5) {
                case 0:
                    paddingRight = h1Var.getPaddingRight();
                    break;
                default:
                    paddingRight = h1Var.getPaddingBottom();
                    break;
            }
            i0Var.f847h = paddingRight + i4;
            View viewI = i();
            i0 i0Var2 = this.mLayoutState;
            i0Var2.f844e = this.mShouldReverseLayout ? -1 : 1;
            int position = getPosition(viewI);
            i0 i0Var3 = this.mLayoutState;
            i0Var2.f843d = position + i0Var3.f844e;
            i0Var3.f841b = this.mOrientationHelper.b(viewI);
            iH = this.mOrientationHelper.b(viewI) - this.mOrientationHelper.f();
        } else {
            View viewJ = j();
            i0 i0Var4 = this.mLayoutState;
            i0Var4.f847h = this.mOrientationHelper.h() + i0Var4.f847h;
            i0 i0Var5 = this.mLayoutState;
            i0Var5.f844e = this.mShouldReverseLayout ? 1 : -1;
            int position2 = getPosition(viewJ);
            i0 i0Var6 = this.mLayoutState;
            i0Var5.f843d = position2 + i0Var6.f844e;
            i0Var6.f841b = this.mOrientationHelper.e(viewJ);
            iH = (-this.mOrientationHelper.e(viewJ)) + this.mOrientationHelper.h();
        }
        i0 i0Var7 = this.mLayoutState;
        i0Var7.f842c = i3;
        if (z2) {
            i0Var7.f842c = i3 - iH;
        }
        i0Var7.f846g = iH;
    }

    public void onAnchorReady(p1 p1Var, w1 w1Var, g0 g0Var, int i2) {
    }

    @Override // androidx.recyclerview.widget.h1
    public void onDetachedFromWindow(RecyclerView recyclerView, p1 p1Var) {
        super.onDetachedFromWindow(recyclerView, p1Var);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(p1Var);
            p1Var.f925a.clear();
            p1Var.e();
        }
    }

    @Override // androidx.recyclerview.widget.h1
    public View onFocusSearchFailed(View view, int i2, p1 p1Var, w1 w1Var) {
        int iConvertFocusDirectionToLayoutDirection;
        n();
        if (getChildCount() == 0 || (iConvertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i2)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        o(iConvertFocusDirectionToLayoutDirection, (int) (this.mOrientationHelper.i() * MAX_SCROLL_FACTOR), false, w1Var);
        i0 i0Var = this.mLayoutState;
        i0Var.f846g = Integer.MIN_VALUE;
        i0Var.f840a = false;
        fill(p1Var, i0Var, w1Var, true);
        View viewFindOnePartiallyOrCompletelyInvisibleChild = iConvertFocusDirectionToLayoutDirection == -1 ? this.mShouldReverseLayout ? findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1) : findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount()) : this.mShouldReverseLayout ? findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount()) : findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
        View viewJ = iConvertFocusDirectionToLayoutDirection == -1 ? j() : i();
        if (!viewJ.hasFocusable()) {
            return viewFindOnePartiallyOrCompletelyInvisibleChild;
        }
        if (viewFindOnePartiallyOrCompletelyInvisibleChild == null) {
            return null;
        }
        return viewJ;
    }

    @Override // androidx.recyclerview.widget.h1
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01a6  */
    @Override // androidx.recyclerview.widget.h1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayoutChildren(androidx.recyclerview.widget.p1 r14, androidx.recyclerview.widget.w1 r15) {
        /*
            Method dump skipped, instructions count: 1130
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.onLayoutChildren(androidx.recyclerview.widget.p1, androidx.recyclerview.widget.w1):void");
    }

    @Override // androidx.recyclerview.widget.h1
    public void onLayoutCompleted(w1 w1Var) {
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.d();
    }

    @Override // androidx.recyclerview.widget.h1
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof j0) {
            this.mPendingSavedState = (j0) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.h1
    public Parcelable onSaveInstanceState() {
        j0 j0Var = this.mPendingSavedState;
        if (j0Var != null) {
            j0 j0Var2 = new j0();
            j0Var2.f864a = j0Var.f864a;
            j0Var2.f865b = j0Var.f865b;
            j0Var2.f866c = j0Var.f866c;
            return j0Var2;
        }
        j0 j0Var3 = new j0();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z2 = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            j0Var3.f866c = z2;
            if (z2) {
                View viewI = i();
                j0Var3.f865b = this.mOrientationHelper.f() - this.mOrientationHelper.b(viewI);
                j0Var3.f864a = getPosition(viewI);
            } else {
                View viewJ = j();
                j0Var3.f864a = getPosition(viewJ);
                j0Var3.f865b = this.mOrientationHelper.e(viewJ) - this.mOrientationHelper.h();
            }
        } else {
            j0Var3.f864a = -1;
        }
        return j0Var3;
    }

    public final void p(int i2, int i3) {
        this.mLayoutState.f842c = this.mOrientationHelper.f() - i3;
        i0 i0Var = this.mLayoutState;
        i0Var.f844e = this.mShouldReverseLayout ? -1 : 1;
        i0Var.f843d = i2;
        i0Var.f845f = 1;
        i0Var.f841b = i3;
        i0Var.f846g = Integer.MIN_VALUE;
    }

    public void prepareForDrop(View view, View view2, int i2, int i3) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        n();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        char c2 = position < position2 ? (char) 1 : (char) 65535;
        if (this.mShouldReverseLayout) {
            if (c2 == 1) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.f() - (this.mOrientationHelper.c(view) + this.mOrientationHelper.e(view2)));
                return;
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.f() - this.mOrientationHelper.b(view2));
                return;
            }
        }
        if (c2 == 65535) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.e(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.b(view2) - this.mOrientationHelper.c(view));
        }
    }

    public final void q(int i2, int i3) {
        this.mLayoutState.f842c = i3 - this.mOrientationHelper.h();
        i0 i0Var = this.mLayoutState;
        i0Var.f843d = i2;
        i0Var.f844e = this.mShouldReverseLayout ? 1 : -1;
        i0Var.f845f = -1;
        i0Var.f841b = i3;
        i0Var.f846g = Integer.MIN_VALUE;
    }

    public boolean resolveIsInfinite() {
        int width;
        if (this.mOrientationHelper.g() == 0) {
            p0 p0Var = (p0) this.mOrientationHelper;
            int i2 = p0Var.f924d;
            h1 h1Var = p0Var.f940a;
            switch (i2) {
                case 0:
                    width = h1Var.getWidth();
                    break;
                default:
                    width = h1Var.getHeight();
                    break;
            }
            if (width == 0) {
                return true;
            }
        }
        return false;
    }

    public int scrollBy(int i2, p1 p1Var, w1 w1Var) {
        if (getChildCount() == 0 || i2 == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.f840a = true;
        int i3 = i2 > 0 ? 1 : -1;
        int iAbs = Math.abs(i2);
        o(i3, iAbs, true, w1Var);
        i0 i0Var = this.mLayoutState;
        int iFill = fill(p1Var, i0Var, w1Var, false) + i0Var.f846g;
        if (iFill < 0) {
            return 0;
        }
        if (iAbs > iFill) {
            i2 = i3 * iFill;
        }
        this.mOrientationHelper.m(-i2);
        this.mLayoutState.f849j = i2;
        return i2;
    }

    @Override // androidx.recyclerview.widget.h1
    public int scrollHorizontallyBy(int i2, p1 p1Var, w1 w1Var) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i2, p1Var, w1Var);
    }

    @Override // androidx.recyclerview.widget.h1
    public void scrollToPosition(int i2) {
        this.mPendingScrollPosition = i2;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        j0 j0Var = this.mPendingSavedState;
        if (j0Var != null) {
            j0Var.f864a = -1;
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i2, int i3) {
        this.mPendingScrollPosition = i2;
        this.mPendingScrollPositionOffset = i3;
        j0 j0Var = this.mPendingSavedState;
        if (j0Var != null) {
            j0Var.f864a = -1;
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.h1
    public int scrollVerticallyBy(int i2, p1 p1Var, w1 w1Var) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i2, p1Var, w1Var);
    }

    public void setInitialPrefetchItemCount(int i2) {
        this.mInitialPrefetchItemCount = i2;
    }

    public void setOrientation(int i2) {
        if (i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException(a.a.c("invalid orientation:", i2));
        }
        assertNotInLayoutOrScroll(null);
        if (i2 != this.mOrientation || this.mOrientationHelper == null) {
            p0 p0VarA = q0.a(this, i2);
            this.mOrientationHelper = p0VarA;
            this.mAnchorInfo.f806a = p0VarA;
            this.mOrientation = i2;
            requestLayout();
        }
    }

    public void setRecycleChildrenOnDetach(boolean z2) {
        this.mRecycleChildrenOnDetach = z2;
    }

    public void setReverseLayout(boolean z2) {
        assertNotInLayoutOrScroll(null);
        if (z2 == this.mReverseLayout) {
            return;
        }
        this.mReverseLayout = z2;
        requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean z2) {
        this.mSmoothScrollbarEnabled = z2;
    }

    public void setStackFromEnd(boolean z2) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd == z2) {
            return;
        }
        this.mStackFromEnd = z2;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.h1
    public boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.h1
    public void smoothScrollToPosition(RecyclerView recyclerView, w1 w1Var, int i2) {
        k0 k0Var = new k0(recyclerView.getContext());
        k0Var.setTargetPosition(i2);
        startSmoothScroll(k0Var);
    }

    @Override // androidx.recyclerview.widget.h1
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    public void validateChildOrder() {
        Log.d(TAG, "validating child count " + getChildCount());
        if (getChildCount() < 1) {
            return;
        }
        int position = getPosition(getChildAt(0));
        int iE = this.mOrientationHelper.e(getChildAt(0));
        if (this.mShouldReverseLayout) {
            for (int i2 = 1; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                int position2 = getPosition(childAt);
                int iE2 = this.mOrientationHelper.e(childAt);
                if (position2 < position) {
                    k();
                    StringBuilder sb = new StringBuilder("detected invalid position. loc invalid? ");
                    sb.append(iE2 < iE);
                    throw new RuntimeException(sb.toString());
                }
                if (iE2 > iE) {
                    k();
                    throw new RuntimeException("detected invalid location");
                }
            }
            return;
        }
        for (int i3 = 1; i3 < getChildCount(); i3++) {
            View childAt2 = getChildAt(i3);
            int position3 = getPosition(childAt2);
            int iE3 = this.mOrientationHelper.e(childAt2);
            if (position3 < position) {
                k();
                StringBuilder sb2 = new StringBuilder("detected invalid position. loc invalid? ");
                sb2.append(iE3 < iE);
                throw new RuntimeException(sb2.toString());
            }
            if (iE3 < iE) {
                k();
                throw new RuntimeException("detected invalid location");
            }
        }
    }

    public LinearLayoutManager(int i2, boolean z2) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new g0();
        this.mLayoutChunkResult = new h0();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i2);
        setReverseLayout(z2);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new g0();
        this.mLayoutChunkResult = new h0();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        g1 properties = h1.getProperties(context, attributeSet, i2, i3);
        setOrientation(properties.f811a);
        setReverseLayout(properties.f813c);
        setStackFromEnd(properties.f814d);
    }
}
