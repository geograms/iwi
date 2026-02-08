package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.recyclerview.R$styleable;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class h1 {
    boolean mAutoMeasure;
    i mChildHelper;
    private int mHeight;
    private int mHeightMode;
    k2 mHorizontalBoundCheck;
    private final j2 mHorizontalBoundCheckCallback;
    boolean mIsAttachedToWindow;
    private boolean mItemPrefetchEnabled;
    private boolean mMeasurementCacheEnabled;
    int mPrefetchMaxCountObserved;
    boolean mPrefetchMaxObservedInInitialPrefetch;
    RecyclerView mRecyclerView;
    boolean mRequestedSimpleAnimations;
    v1 mSmoothScroller;
    k2 mVerticalBoundCheck;
    private final j2 mVerticalBoundCheckCallback;
    private int mWidth;
    private int mWidthMode;

    public h1() {
        e1 e1Var = new e1(this, 0);
        this.mHorizontalBoundCheckCallback = e1Var;
        e1 e1Var2 = new e1(this, 1);
        this.mVerticalBoundCheckCallback = e1Var2;
        this.mHorizontalBoundCheck = new k2(e1Var);
        this.mVerticalBoundCheck = new k2(e1Var2);
        this.mRequestedSimpleAnimations = false;
        this.mIsAttachedToWindow = false;
        this.mAutoMeasure = false;
        this.mMeasurementCacheEnabled = true;
        this.mItemPrefetchEnabled = true;
    }

    public static boolean b(int i2, int i3, int i4) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (i4 > 0 && i2 != i4) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i2;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i2;
        }
        return true;
    }

    public static int chooseSize(int i2, int i3, int i4) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i3, i4) : size : Math.min(size, Math.max(i3, i4));
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000c A[PHI: r3
      0x000c: PHI (r3v5 int) = (r3v0 int), (r3v2 int), (r3v0 int) binds: [B:7:0x0010, B:11:0x0016, B:4:0x000a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000e  */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int getChildMeasureSpec(int r1, int r2, int r3, boolean r4) {
        /*
            int r1 = r1 - r2
            r2 = 0
            int r1 = java.lang.Math.max(r2, r1)
            r0 = 1073741824(0x40000000, float:2.0)
            if (r4 == 0) goto L10
            if (r3 < 0) goto Le
        Lc:
            r2 = r0
            goto L1e
        Le:
            r3 = r2
            goto L1e
        L10:
            if (r3 < 0) goto L13
            goto Lc
        L13:
            r4 = -1
            if (r3 != r4) goto L18
            r3 = r1
            goto Lc
        L18:
            r4 = -2
            if (r3 != r4) goto Le
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1
        L1e:
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.h1.getChildMeasureSpec(int, int, int, boolean):int");
    }

    public static g1 getProperties(Context context, AttributeSet attributeSet, int i2, int i3) {
        g1 g1Var = new g1();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecyclerView, i2, i3);
        g1Var.f811a = typedArrayObtainStyledAttributes.getInt(R$styleable.RecyclerView_android_orientation, 1);
        g1Var.f812b = typedArrayObtainStyledAttributes.getInt(R$styleable.RecyclerView_spanCount, 1);
        g1Var.f813c = typedArrayObtainStyledAttributes.getBoolean(R$styleable.RecyclerView_reverseLayout, false);
        g1Var.f814d = typedArrayObtainStyledAttributes.getBoolean(R$styleable.RecyclerView_stackFromEnd, false);
        typedArrayObtainStyledAttributes.recycle();
        return g1Var;
    }

    public final void a(View view, int i2, boolean z2) {
        z1 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (z2 || childViewHolderInt.isRemoved()) {
            g.l lVar = this.mRecyclerView.mViewInfoStore.f901a;
            l2 l2VarA = (l2) lVar.getOrDefault(childViewHolderInt, null);
            if (l2VarA == null) {
                l2VarA = l2.a();
                lVar.put(childViewHolderInt, l2VarA);
            }
            l2VarA.f882a |= 1;
        } else {
            this.mRecyclerView.mViewInfoStore.c(childViewHolderInt);
        }
        i1 i1Var = (i1) view.getLayoutParams();
        if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            this.mChildHelper.b(view, i2, view.getLayoutParams(), false);
        } else if (view.getParent() == this.mRecyclerView) {
            int iJ = this.mChildHelper.j(view);
            if (i2 == -1) {
                i2 = this.mChildHelper.e();
            }
            if (iJ == -1) {
                StringBuilder sb = new StringBuilder("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                sb.append(this.mRecyclerView.indexOfChild(view));
                throw new IllegalStateException(a.a.b(this.mRecyclerView, sb));
            }
            if (iJ != i2) {
                this.mRecyclerView.mLayout.moveView(iJ, i2);
            }
        } else {
            this.mChildHelper.a(view, i2, false);
            i1Var.f854c = true;
            v1 v1Var = this.mSmoothScroller;
            if (v1Var != null && v1Var.isRunning()) {
                this.mSmoothScroller.onChildAttachedToWindow(view);
            }
        }
        if (i1Var.f855d) {
            childViewHolderInt.itemView.invalidate();
            i1Var.f855d = false;
        }
    }

    public void addDisappearingView(View view) {
        addDisappearingView(view, -1);
    }

    public void addView(View view) {
        addView(view, -1);
    }

    public void assertInLayoutOrScroll(String str) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.assertInLayoutOrScroll(str);
        }
    }

    public void assertNotInLayoutOrScroll(String str) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.assertNotInLayoutOrScroll(str);
        }
    }

    public void attachView(View view, int i2, i1 i1Var) {
        z1 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt.isRemoved()) {
            g.l lVar = this.mRecyclerView.mViewInfoStore.f901a;
            l2 l2VarA = (l2) lVar.getOrDefault(childViewHolderInt, null);
            if (l2VarA == null) {
                l2VarA = l2.a();
                lVar.put(childViewHolderInt, l2VarA);
            }
            l2VarA.f882a |= 1;
        } else {
            this.mRecyclerView.mViewInfoStore.c(childViewHolderInt);
        }
        this.mChildHelper.b(view, i2, i1Var, childViewHolderInt.isRemoved());
    }

    public final void c(p1 p1Var, int i2, View view) {
        z1 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt.shouldIgnore()) {
            return;
        }
        if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !this.mRecyclerView.mAdapter.hasStableIds()) {
            removeViewAt(i2);
            p1Var.h(childViewHolderInt);
        } else {
            detachViewAt(i2);
            p1Var.i(view);
            this.mRecyclerView.mViewInfoStore.c(childViewHolderInt);
        }
    }

    public void calculateItemDecorationsForChild(View view, Rect rect) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(recyclerView.getItemDecorInsetsForChild(view));
        }
    }

    public abstract boolean canScrollHorizontally();

    public boolean canScrollVertically() {
        return false;
    }

    public boolean checkLayoutParams(i1 i1Var) {
        return i1Var != null;
    }

    public void collectAdjacentPrefetchPositions(int i2, int i3, w1 w1Var, f1 f1Var) {
    }

    public void collectInitialPrefetchPositions(int i2, f1 f1Var) {
    }

    public abstract int computeHorizontalScrollExtent(w1 w1Var);

    public abstract int computeHorizontalScrollOffset(w1 w1Var);

    public abstract int computeHorizontalScrollRange(w1 w1Var);

    public int computeVerticalScrollExtent(w1 w1Var) {
        return 0;
    }

    public int computeVerticalScrollOffset(w1 w1Var) {
        return 0;
    }

    public int computeVerticalScrollRange(w1 w1Var) {
        return 0;
    }

    public void detachAndScrapAttachedViews(p1 p1Var) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            c(p1Var, childCount, getChildAt(childCount));
        }
    }

    public void detachAndScrapView(View view, p1 p1Var) {
        c(p1Var, this.mChildHelper.j(view), view);
    }

    public void detachAndScrapViewAt(int i2, p1 p1Var) {
        c(p1Var, i2, getChildAt(i2));
    }

    public void detachView(View view) {
        int iJ = this.mChildHelper.j(view);
        if (iJ >= 0) {
            this.mChildHelper.c(iJ);
        }
    }

    public void detachViewAt(int i2) {
        getChildAt(i2);
        this.mChildHelper.c(i2);
    }

    public void dispatchAttachedToWindow(RecyclerView recyclerView) {
        this.mIsAttachedToWindow = true;
        onAttachedToWindow(recyclerView);
    }

    public void dispatchDetachedFromWindow(RecyclerView recyclerView, p1 p1Var) {
        this.mIsAttachedToWindow = false;
        onDetachedFromWindow(recyclerView, p1Var);
    }

    public void endAnimation(View view) {
        c1 c1Var = this.mRecyclerView.mItemAnimator;
        if (c1Var != null) {
            c1Var.d(RecyclerView.getChildViewHolderInt(view));
        }
    }

    public View findContainingItemView(View view) {
        View viewFindContainingItemView;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || (viewFindContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.k(viewFindContainingItemView)) {
            return null;
        }
        return viewFindContainingItemView;
    }

    public View findViewByPosition(int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            z1 childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
            if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i2 && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.f982g || !childViewHolderInt.isRemoved())) {
                return childAt;
            }
        }
        return null;
    }

    public abstract i1 generateDefaultLayoutParams();

    public i1 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof i1 ? new i1((i1) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new i1((ViewGroup.MarginLayoutParams) layoutParams) : new i1(layoutParams);
    }

    public int getBaseline() {
        return -1;
    }

    public int getBottomDecorationHeight(View view) {
        return ((i1) view.getLayoutParams()).f853b.bottom;
    }

    public View getChildAt(int i2) {
        i iVar = this.mChildHelper;
        if (iVar != null) {
            return iVar.d(i2);
        }
        return null;
    }

    public int getChildCount() {
        i iVar = this.mChildHelper;
        if (iVar != null) {
            return iVar.e();
        }
        return 0;
    }

    public boolean getClipToPadding() {
        RecyclerView recyclerView = this.mRecyclerView;
        return recyclerView != null && recyclerView.mClipToPadding;
    }

    public int getColumnCountForAccessibility(p1 p1Var, w1 w1Var) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || recyclerView.mAdapter == null || !canScrollHorizontally()) {
            return 1;
        }
        return this.mRecyclerView.mAdapter.getItemCount();
    }

    public int getDecoratedBottom(View view) {
        return getBottomDecorationHeight(view) + view.getBottom();
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
    }

    public int getDecoratedLeft(View view) {
        return view.getLeft() - getLeftDecorationWidth(view);
    }

    public int getDecoratedMeasuredHeight(View view) {
        Rect rect = ((i1) view.getLayoutParams()).f853b;
        return view.getMeasuredHeight() + rect.top + rect.bottom;
    }

    public int getDecoratedMeasuredWidth(View view) {
        Rect rect = ((i1) view.getLayoutParams()).f853b;
        return view.getMeasuredWidth() + rect.left + rect.right;
    }

    public int getDecoratedRight(View view) {
        return getRightDecorationWidth(view) + view.getRight();
    }

    public int getDecoratedTop(View view) {
        return view.getTop() - getTopDecorationHeight(view);
    }

    public View getFocusedChild() {
        View focusedChild;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.k(focusedChild)) {
            return null;
        }
        return focusedChild;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getHeightMode() {
        return this.mHeightMode;
    }

    public int getItemCount() {
        RecyclerView recyclerView = this.mRecyclerView;
        v0 adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        if (adapter != null) {
            return adapter.getItemCount();
        }
        return 0;
    }

    public int getItemViewType(View view) {
        return RecyclerView.getChildViewHolderInt(view).getItemViewType();
    }

    public int getLayoutDirection() {
        RecyclerView recyclerView = this.mRecyclerView;
        WeakHashMap weakHashMap = androidx.core.view.d1.f138a;
        return androidx.core.view.n0.d(recyclerView);
    }

    public int getLeftDecorationWidth(View view) {
        return ((i1) view.getLayoutParams()).f853b.left;
    }

    public int getMinimumHeight() {
        RecyclerView recyclerView = this.mRecyclerView;
        WeakHashMap weakHashMap = androidx.core.view.d1.f138a;
        return androidx.core.view.m0.d(recyclerView);
    }

    public int getMinimumWidth() {
        RecyclerView recyclerView = this.mRecyclerView;
        WeakHashMap weakHashMap = androidx.core.view.d1.f138a;
        return androidx.core.view.m0.e(recyclerView);
    }

    public int getPaddingBottom() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return recyclerView.getPaddingBottom();
        }
        return 0;
    }

    public int getPaddingEnd() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return 0;
        }
        WeakHashMap weakHashMap = androidx.core.view.d1.f138a;
        return androidx.core.view.n0.e(recyclerView);
    }

    public int getPaddingLeft() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }

    public int getPaddingRight() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return recyclerView.getPaddingRight();
        }
        return 0;
    }

    public int getPaddingStart() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return 0;
        }
        WeakHashMap weakHashMap = androidx.core.view.d1.f138a;
        return androidx.core.view.n0.f(recyclerView);
    }

    public int getPaddingTop() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    public int getPosition(View view) {
        return ((i1) view.getLayoutParams()).f852a.getLayoutPosition();
    }

    public int getRightDecorationWidth(View view) {
        return ((i1) view.getLayoutParams()).f853b.right;
    }

    public int getRowCountForAccessibility(p1 p1Var, w1 w1Var) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || recyclerView.mAdapter == null || !canScrollVertically()) {
            return 1;
        }
        return this.mRecyclerView.mAdapter.getItemCount();
    }

    public int getSelectionModeForAccessibility(p1 p1Var, w1 w1Var) {
        return 0;
    }

    public int getTopDecorationHeight(View view) {
        return ((i1) view.getLayoutParams()).f853b.top;
    }

    public void getTransformedBoundingBox(View view, boolean z2, Rect rect) {
        Matrix matrix;
        if (z2) {
            Rect rect2 = ((i1) view.getLayoutParams()).f853b;
            rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
        } else {
            rect.set(0, 0, view.getWidth(), view.getHeight());
        }
        if (this.mRecyclerView != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
            RectF rectF = this.mRecyclerView.mTempRectF;
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
        }
        rect.offset(view.getLeft(), view.getTop());
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getWidthMode() {
        return this.mWidthMode;
    }

    public boolean hasFlexibleChildInBothOrientations() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ViewGroup.LayoutParams layoutParams = getChildAt(i2).getLayoutParams();
            if (layoutParams.width < 0 && layoutParams.height < 0) {
                return true;
            }
        }
        return false;
    }

    public boolean hasFocus() {
        RecyclerView recyclerView = this.mRecyclerView;
        return recyclerView != null && recyclerView.hasFocus();
    }

    public void ignoreView(View view) {
        ViewParent parent = view.getParent();
        RecyclerView recyclerView = this.mRecyclerView;
        if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
            throw new IllegalArgumentException(a.a.b(this.mRecyclerView, new StringBuilder("View should be fully attached to be ignored")));
        }
        z1 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        childViewHolderInt.addFlags(Optimizer.OPTIMIZATION_GRAPH_WRAP);
        this.mRecyclerView.mViewInfoStore.d(childViewHolderInt);
    }

    public boolean isAttachedToWindow() {
        return this.mIsAttachedToWindow;
    }

    public boolean isAutoMeasureEnabled() {
        return this.mAutoMeasure;
    }

    public boolean isFocused() {
        RecyclerView recyclerView = this.mRecyclerView;
        return recyclerView != null && recyclerView.isFocused();
    }

    public final boolean isItemPrefetchEnabled() {
        return this.mItemPrefetchEnabled;
    }

    public boolean isLayoutHierarchical(p1 p1Var, w1 w1Var) {
        return false;
    }

    public boolean isMeasurementCacheEnabled() {
        return this.mMeasurementCacheEnabled;
    }

    public boolean isSmoothScrolling() {
        v1 v1Var = this.mSmoothScroller;
        return v1Var != null && v1Var.isRunning();
    }

    public boolean isViewPartiallyVisible(View view, boolean z2, boolean z3) {
        boolean z4 = this.mHorizontalBoundCheck.b(view) && this.mVerticalBoundCheck.b(view);
        return z2 ? z4 : !z4;
    }

    public void layoutDecorated(View view, int i2, int i3, int i4, int i5) {
        Rect rect = ((i1) view.getLayoutParams()).f853b;
        view.layout(i2 + rect.left, i3 + rect.top, i4 - rect.right, i5 - rect.bottom);
    }

    public void layoutDecoratedWithMargins(View view, int i2, int i3, int i4, int i5) {
        i1 i1Var = (i1) view.getLayoutParams();
        Rect rect = i1Var.f853b;
        view.layout(i2 + rect.left + ((ViewGroup.MarginLayoutParams) i1Var).leftMargin, i3 + rect.top + ((ViewGroup.MarginLayoutParams) i1Var).topMargin, (i4 - rect.right) - ((ViewGroup.MarginLayoutParams) i1Var).rightMargin, (i5 - rect.bottom) - ((ViewGroup.MarginLayoutParams) i1Var).bottomMargin);
    }

    public void measureChild(View view, int i2, int i3) {
        i1 i1Var = (i1) view.getLayoutParams();
        Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
        int i4 = itemDecorInsetsForChild.left + itemDecorInsetsForChild.right + i2;
        int i5 = itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom + i3;
        int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + i4, ((ViewGroup.MarginLayoutParams) i1Var).width, canScrollHorizontally());
        int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + i5, ((ViewGroup.MarginLayoutParams) i1Var).height, canScrollVertically());
        if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, i1Var)) {
            view.measure(childMeasureSpec, childMeasureSpec2);
        }
    }

    public void measureChildWithMargins(View view, int i2, int i3) {
        i1 i1Var = (i1) view.getLayoutParams();
        Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
        int i4 = itemDecorInsetsForChild.left + itemDecorInsetsForChild.right + i2;
        int i5 = itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom + i3;
        int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) i1Var).leftMargin + ((ViewGroup.MarginLayoutParams) i1Var).rightMargin + i4, ((ViewGroup.MarginLayoutParams) i1Var).width, canScrollHorizontally());
        int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + ((ViewGroup.MarginLayoutParams) i1Var).topMargin + ((ViewGroup.MarginLayoutParams) i1Var).bottomMargin + i5, ((ViewGroup.MarginLayoutParams) i1Var).height, canScrollVertically());
        if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, i1Var)) {
            view.measure(childMeasureSpec, childMeasureSpec2);
        }
    }

    public void moveView(int i2, int i3) {
        View childAt = getChildAt(i2);
        if (childAt != null) {
            detachViewAt(i2);
            attachView(childAt, i3);
        } else {
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i2 + this.mRecyclerView.toString());
        }
    }

    public void offsetChildrenHorizontal(int i2) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.offsetChildrenHorizontal(i2);
        }
    }

    public void offsetChildrenVertical(int i2) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.offsetChildrenVertical(i2);
        }
    }

    public void onAdapterChanged(v0 v0Var, v0 v0Var2) {
    }

    public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i2, int i3) {
        return false;
    }

    public void onAttachedToWindow(RecyclerView recyclerView) {
    }

    @Deprecated
    public void onDetachedFromWindow(RecyclerView recyclerView) {
    }

    public View onFocusSearchFailed(View view, int i2, p1 p1Var, w1 w1Var) {
        return null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        RecyclerView recyclerView = this.mRecyclerView;
        onInitializeAccessibilityEvent(recyclerView.mRecycler, recyclerView.mState, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(r.g gVar) {
        RecyclerView recyclerView = this.mRecyclerView;
        onInitializeAccessibilityNodeInfo(recyclerView.mRecycler, recyclerView.mState, gVar);
    }

    public void onInitializeAccessibilityNodeInfoForItem(View view, r.g gVar) {
        z1 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt == null || childViewHolderInt.isRemoved() || this.mChildHelper.k(childViewHolderInt.itemView)) {
            return;
        }
        RecyclerView recyclerView = this.mRecyclerView;
        onInitializeAccessibilityNodeInfoForItem(recyclerView.mRecycler, recyclerView.mState, view, gVar);
    }

    public View onInterceptFocusSearch(View view, int i2) {
        return null;
    }

    public void onItemsAdded(RecyclerView recyclerView, int i2, int i3) {
    }

    public void onItemsChanged(RecyclerView recyclerView) {
    }

    public void onItemsMoved(RecyclerView recyclerView, int i2, int i3, int i4) {
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i2, int i3) {
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i2, int i3) {
    }

    public abstract void onLayoutChildren(p1 p1Var, w1 w1Var);

    public abstract void onLayoutCompleted(w1 w1Var);

    public void onMeasure(p1 p1Var, w1 w1Var, int i2, int i3) {
        this.mRecyclerView.defaultOnMeasure(i2, i3);
    }

    @Deprecated
    public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
        return isSmoothScrolling() || recyclerView.isComputingLayout();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public void onScrollStateChanged(int i2) {
    }

    public void onSmoothScrollerStopped(v1 v1Var) {
        if (this.mSmoothScroller == v1Var) {
            this.mSmoothScroller = null;
        }
    }

    public boolean performAccessibilityAction(int i2, Bundle bundle) {
        RecyclerView recyclerView = this.mRecyclerView;
        return performAccessibilityAction(recyclerView.mRecycler, recyclerView.mState, i2, bundle);
    }

    public boolean performAccessibilityActionForItem(p1 p1Var, w1 w1Var, View view, int i2, Bundle bundle) {
        return false;
    }

    public void postOnAnimation(Runnable runnable) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            WeakHashMap weakHashMap = androidx.core.view.d1.f138a;
            androidx.core.view.m0.m(recyclerView, runnable);
        }
    }

    public void removeAllViews() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            i iVar = this.mChildHelper;
            int iF = iVar.f(childCount);
            u0 u0Var = iVar.f837a;
            View childAt = u0Var.f972a.getChildAt(iF);
            if (childAt != null) {
                if (iVar.f838b.f(iF)) {
                    iVar.l(childAt);
                }
                u0Var.b(iF);
            }
        }
    }

    public void removeAndRecycleAllViews(p1 p1Var) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                removeAndRecycleViewAt(childCount, p1Var);
            }
        }
    }

    public void removeAndRecycleScrapInt(p1 p1Var) {
        ArrayList arrayList;
        int size = p1Var.f925a.size();
        int i2 = size - 1;
        while (true) {
            arrayList = p1Var.f925a;
            if (i2 < 0) {
                break;
            }
            View view = ((z1) arrayList.get(i2)).itemView;
            z1 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.setIsRecyclable(false);
                if (childViewHolderInt.isTmpDetached()) {
                    this.mRecyclerView.removeDetachedView(view, false);
                }
                c1 c1Var = this.mRecyclerView.mItemAnimator;
                if (c1Var != null) {
                    c1Var.d(childViewHolderInt);
                }
                childViewHolderInt.setIsRecyclable(true);
                z1 childViewHolderInt2 = RecyclerView.getChildViewHolderInt(view);
                childViewHolderInt2.mScrapContainer = null;
                childViewHolderInt2.mInChangeScrap = false;
                childViewHolderInt2.clearReturnedFromScrapFlag();
                p1Var.h(childViewHolderInt2);
            }
            i2--;
        }
        arrayList.clear();
        ArrayList arrayList2 = p1Var.f926b;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        if (size > 0) {
            this.mRecyclerView.invalidate();
        }
    }

    public void removeAndRecycleView(View view, p1 p1Var) {
        removeView(view);
        p1Var.g(view);
    }

    public void removeAndRecycleViewAt(int i2, p1 p1Var) {
        View childAt = getChildAt(i2);
        removeViewAt(i2);
        p1Var.g(childAt);
    }

    public boolean removeCallbacks(Runnable runnable) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return recyclerView.removeCallbacks(runnable);
        }
        return false;
    }

    public void removeDetachedView(View view) {
        this.mRecyclerView.removeDetachedView(view, false);
    }

    public void removeView(View view) {
        i iVar = this.mChildHelper;
        u0 u0Var = iVar.f837a;
        int iIndexOfChild = u0Var.f972a.indexOfChild(view);
        if (iIndexOfChild < 0) {
            return;
        }
        if (iVar.f838b.f(iIndexOfChild)) {
            iVar.l(view);
        }
        u0Var.b(iIndexOfChild);
    }

    public void removeViewAt(int i2) {
        if (getChildAt(i2) != null) {
            i iVar = this.mChildHelper;
            int iF = iVar.f(i2);
            u0 u0Var = iVar.f837a;
            View childAt = u0Var.f972a.getChildAt(iF);
            if (childAt == null) {
                return;
            }
            if (iVar.f838b.f(iF)) {
                iVar.l(childAt);
            }
            u0Var.b(iF);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean requestChildRectangleOnScreen(androidx.recyclerview.widget.RecyclerView r9, android.view.View r10, android.graphics.Rect r11, boolean r12, boolean r13) {
        /*
            r8 = this;
            int r0 = r8.getPaddingLeft()
            int r1 = r8.getPaddingTop()
            int r2 = r8.getWidth()
            int r3 = r8.getPaddingRight()
            int r2 = r2 - r3
            int r3 = r8.getHeight()
            int r4 = r8.getPaddingBottom()
            int r3 = r3 - r4
            int r4 = r10.getLeft()
            int r5 = r11.left
            int r4 = r4 + r5
            int r5 = r10.getScrollX()
            int r4 = r4 - r5
            int r5 = r10.getTop()
            int r6 = r11.top
            int r5 = r5 + r6
            int r10 = r10.getScrollY()
            int r5 = r5 - r10
            int r10 = r11.width()
            int r10 = r10 + r4
            int r11 = r11.height()
            int r11 = r11 + r5
            int r4 = r4 - r0
            r0 = 0
            int r6 = java.lang.Math.min(r0, r4)
            int r5 = r5 - r1
            int r1 = java.lang.Math.min(r0, r5)
            int r10 = r10 - r2
            int r2 = java.lang.Math.max(r0, r10)
            int r11 = r11 - r3
            int r11 = java.lang.Math.max(r0, r11)
            int r3 = r8.getLayoutDirection()
            r7 = 1
            if (r3 != r7) goto L60
            if (r2 == 0) goto L5b
            goto L68
        L5b:
            int r2 = java.lang.Math.max(r6, r10)
            goto L68
        L60:
            if (r6 == 0) goto L63
            goto L67
        L63:
            int r6 = java.lang.Math.min(r4, r2)
        L67:
            r2 = r6
        L68:
            if (r1 == 0) goto L6b
            goto L6f
        L6b:
            int r1 = java.lang.Math.min(r5, r11)
        L6f:
            if (r13 == 0) goto Lae
            android.view.View r10 = r9.getFocusedChild()
            if (r10 != 0) goto L78
            goto Lb3
        L78:
            int r11 = r8.getPaddingLeft()
            int r13 = r8.getPaddingTop()
            int r3 = r8.getWidth()
            int r4 = r8.getPaddingRight()
            int r3 = r3 - r4
            int r4 = r8.getHeight()
            int r5 = r8.getPaddingBottom()
            int r4 = r4 - r5
            androidx.recyclerview.widget.RecyclerView r5 = r8.mRecyclerView
            android.graphics.Rect r5 = r5.mTempRect
            r8.getDecoratedBoundsWithMargins(r10, r5)
            int r8 = r5.left
            int r8 = r8 - r2
            if (r8 >= r3) goto Lb3
            int r8 = r5.right
            int r8 = r8 - r2
            if (r8 <= r11) goto Lb3
            int r8 = r5.top
            int r8 = r8 - r1
            if (r8 >= r4) goto Lb3
            int r8 = r5.bottom
            int r8 = r8 - r1
            if (r8 > r13) goto Lae
            goto Lb3
        Lae:
            if (r2 != 0) goto Lb4
            if (r1 == 0) goto Lb3
            goto Lb4
        Lb3:
            return r0
        Lb4:
            if (r12 == 0) goto Lba
            r9.scrollBy(r2, r1)
            goto Lbd
        Lba:
            r9.smoothScrollBy(r2, r1)
        Lbd:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.h1.requestChildRectangleOnScreen(androidx.recyclerview.widget.RecyclerView, android.view.View, android.graphics.Rect, boolean, boolean):boolean");
    }

    public void requestLayout() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.requestLayout();
        }
    }

    public void requestSimpleAnimationsInNextLayout() {
        this.mRequestedSimpleAnimations = true;
    }

    public abstract int scrollHorizontallyBy(int i2, p1 p1Var, w1 w1Var);

    public abstract void scrollToPosition(int i2);

    public int scrollVerticallyBy(int i2, p1 p1Var, w1 w1Var) {
        return 0;
    }

    @Deprecated
    public void setAutoMeasureEnabled(boolean z2) {
        this.mAutoMeasure = z2;
    }

    public void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
        setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), BasicMeasure.EXACTLY));
    }

    public final void setItemPrefetchEnabled(boolean z2) {
        if (z2 != this.mItemPrefetchEnabled) {
            this.mItemPrefetchEnabled = z2;
            this.mPrefetchMaxCountObserved = 0;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.mRecycler.l();
            }
        }
    }

    public void setMeasureSpecs(int i2, int i3) {
        this.mWidth = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        this.mWidthMode = mode;
        if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
            this.mWidth = 0;
        }
        this.mHeight = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        this.mHeightMode = mode2;
        if (mode2 != 0 || RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
            return;
        }
        this.mHeight = 0;
    }

    public void setMeasuredDimension(Rect rect, int i2, int i3) {
        setMeasuredDimension(chooseSize(i2, getPaddingRight() + getPaddingLeft() + rect.width(), getMinimumWidth()), chooseSize(i3, getPaddingBottom() + getPaddingTop() + rect.height(), getMinimumHeight()));
    }

    public void setMeasuredDimensionFromChildren(int i2, int i3) {
        int childCount = getChildCount();
        if (childCount == 0) {
            this.mRecyclerView.defaultOnMeasure(i2, i3);
            return;
        }
        int i4 = Integer.MIN_VALUE;
        int i5 = Integer.MAX_VALUE;
        int i6 = Integer.MIN_VALUE;
        int i7 = Integer.MAX_VALUE;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            Rect rect = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(childAt, rect);
            int i9 = rect.left;
            if (i9 < i7) {
                i7 = i9;
            }
            int i10 = rect.right;
            if (i10 > i4) {
                i4 = i10;
            }
            int i11 = rect.top;
            if (i11 < i5) {
                i5 = i11;
            }
            int i12 = rect.bottom;
            if (i12 > i6) {
                i6 = i12;
            }
        }
        this.mRecyclerView.mTempRect.set(i7, i5, i4, i6);
        setMeasuredDimension(this.mRecyclerView.mTempRect, i2, i3);
    }

    public void setMeasurementCacheEnabled(boolean z2) {
        this.mMeasurementCacheEnabled = z2;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.mRecyclerView = null;
            this.mChildHelper = null;
            this.mWidth = 0;
            this.mHeight = 0;
        } else {
            this.mRecyclerView = recyclerView;
            this.mChildHelper = recyclerView.mChildHelper;
            this.mWidth = recyclerView.getWidth();
            this.mHeight = recyclerView.getHeight();
        }
        this.mWidthMode = BasicMeasure.EXACTLY;
        this.mHeightMode = BasicMeasure.EXACTLY;
    }

    public boolean shouldMeasureChild(View view, int i2, int i3, i1 i1Var) {
        return (!view.isLayoutRequested() && this.mMeasurementCacheEnabled && b(view.getWidth(), i2, ((ViewGroup.MarginLayoutParams) i1Var).width) && b(view.getHeight(), i3, ((ViewGroup.MarginLayoutParams) i1Var).height)) ? false : true;
    }

    public boolean shouldMeasureTwice() {
        return false;
    }

    public boolean shouldReMeasureChild(View view, int i2, int i3, i1 i1Var) {
        return (this.mMeasurementCacheEnabled && b(view.getMeasuredWidth(), i2, ((ViewGroup.MarginLayoutParams) i1Var).width) && b(view.getMeasuredHeight(), i3, ((ViewGroup.MarginLayoutParams) i1Var).height)) ? false : true;
    }

    public abstract void smoothScrollToPosition(RecyclerView recyclerView, w1 w1Var, int i2);

    public void startSmoothScroll(v1 v1Var) {
        v1 v1Var2 = this.mSmoothScroller;
        if (v1Var2 != null && v1Var != v1Var2 && v1Var2.isRunning()) {
            this.mSmoothScroller.stop();
        }
        this.mSmoothScroller = v1Var;
        v1Var.start(this.mRecyclerView, this);
    }

    public void stopIgnoringView(View view) {
        z1 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        childViewHolderInt.stopIgnoring();
        childViewHolderInt.resetInternal();
        childViewHolderInt.addFlags(4);
    }

    public void stopSmoothScroller() {
        v1 v1Var = this.mSmoothScroller;
        if (v1Var != null) {
            v1Var.stop();
        }
    }

    public boolean supportsPredictiveItemAnimations() {
        return false;
    }

    public void addDisappearingView(View view, int i2) {
        a(view, i2, true);
    }

    public void addView(View view, int i2) {
        a(view, i2, false);
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, p1 p1Var) {
        onDetachedFromWindow(recyclerView);
    }

    public void onInitializeAccessibilityEvent(p1 p1Var, w1 w1Var, AccessibilityEvent accessibilityEvent) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || accessibilityEvent == null) {
            return;
        }
        boolean z2 = true;
        if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
            z2 = false;
        }
        accessibilityEvent.setScrollable(z2);
        v0 v0Var = this.mRecyclerView.mAdapter;
        if (v0Var != null) {
            accessibilityEvent.setItemCount(v0Var.getItemCount());
        }
    }

    public void onInitializeAccessibilityNodeInfo(p1 p1Var, w1 w1Var, r.g gVar) {
        if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
            gVar.a(8192);
            gVar.f2507a.setScrollable(true);
        }
        if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
            gVar.a(MotionScene.Transition.TransitionOnClick.JUMP_TO_START);
            gVar.f2507a.setScrollable(true);
        }
        c.a aVarB = c.a.b(getRowCountForAccessibility(p1Var, w1Var), getColumnCountForAccessibility(p1Var, w1Var), getSelectionModeForAccessibility(p1Var, w1Var), isLayoutHierarchical(p1Var, w1Var));
        gVar.getClass();
        gVar.f2507a.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) aVarB.f1221a);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i2, int i3, Object obj) {
        onItemsUpdated(recyclerView, i2, i3);
    }

    public boolean onRequestChildFocus(RecyclerView recyclerView, w1 w1Var, View view, View view2) {
        return onRequestChildFocus(recyclerView, view, view2);
    }

    public boolean performAccessibilityAction(p1 p1Var, w1 w1Var, int i2, Bundle bundle) {
        int height;
        int width;
        int i3;
        int i4;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return false;
        }
        if (i2 == 4096) {
            height = recyclerView.canScrollVertically(1) ? (getHeight() - getPaddingTop()) - getPaddingBottom() : 0;
            if (this.mRecyclerView.canScrollHorizontally(1)) {
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                i3 = height;
                i4 = width;
            }
            i3 = height;
            i4 = 0;
        } else if (i2 != 8192) {
            i4 = 0;
            i3 = 0;
        } else {
            height = recyclerView.canScrollVertically(-1) ? -((getHeight() - getPaddingTop()) - getPaddingBottom()) : 0;
            if (this.mRecyclerView.canScrollHorizontally(-1)) {
                width = -((getWidth() - getPaddingLeft()) - getPaddingRight());
                i3 = height;
                i4 = width;
            }
            i3 = height;
            i4 = 0;
        }
        if (i3 == 0 && i4 == 0) {
            return false;
        }
        this.mRecyclerView.smoothScrollBy(i4, i3, null, Integer.MIN_VALUE, true);
        return true;
    }

    public boolean performAccessibilityActionForItem(View view, int i2, Bundle bundle) {
        RecyclerView recyclerView = this.mRecyclerView;
        return performAccessibilityActionForItem(recyclerView.mRecycler, recyclerView.mState, view, i2, bundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int getChildMeasureSpec(int r4, int r5, int r6, int r7, boolean r8) {
        /*
            int r4 = r4 - r6
            r6 = 0
            int r4 = java.lang.Math.max(r6, r4)
            r0 = -2
            r1 = -1
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            if (r8 == 0) goto L1d
            if (r7 < 0) goto L12
        L10:
            r5 = r3
            goto L30
        L12:
            if (r7 != r1) goto L1a
            if (r5 == r2) goto L22
            if (r5 == 0) goto L1a
            if (r5 == r3) goto L22
        L1a:
            r5 = r6
            r7 = r5
            goto L30
        L1d:
            if (r7 < 0) goto L20
            goto L10
        L20:
            if (r7 != r1) goto L24
        L22:
            r7 = r4
            goto L30
        L24:
            if (r7 != r0) goto L1a
            if (r5 == r2) goto L2e
            if (r5 != r3) goto L2b
            goto L2e
        L2b:
            r7 = r4
            r5 = r6
            goto L30
        L2e:
            r7 = r4
            r5 = r2
        L30:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.h1.getChildMeasureSpec(int, int, int, int, boolean):int");
    }

    public void onInitializeAccessibilityNodeInfoForItem(p1 p1Var, w1 w1Var, View view, r.g gVar) {
        gVar.g(c.a.a(canScrollVertically() ? getPosition(view) : 0, 1, canScrollHorizontally() ? getPosition(view) : 0, 1, false, false));
    }

    public i1 generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new i1(context, attributeSet);
    }

    public void setMeasuredDimension(int i2, int i3) {
        this.mRecyclerView.setMeasuredDimension(i2, i3);
    }

    public void attachView(View view, int i2) {
        attachView(view, i2, (i1) view.getLayoutParams());
    }

    public void attachView(View view) {
        attachView(view, -1);
    }

    public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z2) {
        return requestChildRectangleOnScreen(recyclerView, view, rect, z2, false);
    }
}
