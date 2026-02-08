package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.recyclerview.R$attr;
import androidx.recyclerview.R$dimen;
import androidx.recyclerview.R$styleable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements androidx.core.view.x {
    static final boolean DEBUG = false;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    static final int MAX_SCROLL_DURATION = 2000;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static final Interpolator sQuinticInterpolator;
    b2 mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    v0 mAdapter;
    b mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private y0 mChildDrawingOrderCallback;
    i mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private z0 mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    c0 mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private l1 mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    c1 mItemAnimator;
    private a1 mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<d1> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    h1 mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final r1 mObserver;
    private List<j1> mOnChildAttachStateListeners;
    private k1 mOnFlingListener;
    private final ArrayList<l1> mOnItemTouchListeners;
    final List<z1> mPendingAccessibilityImportanceChange;
    private s1 mPendingSavedState;
    boolean mPostedAnimatorRunner;
    a0 mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final p1 mRecycler;
    q1 mRecyclerListener;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private m1 mScrollListener;
    private List<m1> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private androidx.core.view.y mScrollingChildHelper;
    final w1 mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final y1 mViewFlinger;
    private final m2 mViewInfoProcessCallback;
    final n2 mViewInfoStore;
    private static final int[] NESTED_SCROLLING_ATTRS = {R.attr.nestedScrollingEnabled};
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC = true;
    static final boolean POST_UPDATES_ON_ANIMATION = true;
    static final boolean ALLOW_THREAD_GAP_WORK = true;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD = false;

    static {
        Class<?> cls = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, cls, cls};
        sQuinticInterpolator = new androidx.customview.widget.f(1);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.recyclerViewStyle);
    }

    public static void clearNestedRecyclerViewIfNotNested(z1 z1Var) {
        WeakReference<RecyclerView> weakReference = z1Var.mNestedRecyclerView;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == z1Var.itemView) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            z1Var.mNestedRecyclerView = null;
        }
    }

    public static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView recyclerViewFindNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i2));
            if (recyclerViewFindNestedRecyclerView != null) {
                return recyclerViewFindNestedRecyclerView;
            }
        }
        return null;
    }

    public static z1 getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((i1) view.getLayoutParams()).f852a;
    }

    public static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        i1 i1Var = (i1) view.getLayoutParams();
        Rect rect2 = i1Var.f853b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) i1Var).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) i1Var).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) i1Var).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) i1Var).bottomMargin);
    }

    private androidx.core.view.y getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new androidx.core.view.y(this);
        }
        return this.mScrollingChildHelper;
    }

    public final void a(z1 z1Var) {
        View view = z1Var.itemView;
        boolean z2 = view.getParent() == this;
        this.mRecycler.k(getChildViewHolder(view));
        if (z1Var.isTmpDetached()) {
            this.mChildHelper.b(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!z2) {
            this.mChildHelper.a(view, -1, true);
            return;
        }
        i iVar = this.mChildHelper;
        int iIndexOfChild = iVar.f837a.f972a.indexOfChild(view);
        if (iIndexOfChild >= 0) {
            iVar.f838b.h(iIndexOfChild);
            iVar.i(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public void absorbGlows(int i2, int i3) {
        if (i2 < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i2);
            }
        }
        if (i3 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i3);
            }
        } else if (i3 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i3);
            }
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        WeakHashMap weakHashMap = androidx.core.view.d1.f138a;
        androidx.core.view.m0.k(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        h1 h1Var = this.mLayout;
        if (h1Var == null || !h1Var.onAddFocusables(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    public void addItemDecoration(d1 d1Var, int i2) {
        h1 h1Var = this.mLayout;
        if (h1Var != null) {
            h1Var.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.mItemDecorations.add(d1Var);
        } else {
            this.mItemDecorations.add(i2, d1Var);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(j1 j1Var) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(j1Var);
    }

    public void addOnItemTouchListener(l1 l1Var) {
        this.mOnItemTouchListeners.add(l1Var);
    }

    public void addOnScrollListener(m1 m1Var) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(m1Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void animateAppearance(androidx.recyclerview.widget.z1 r8, androidx.recyclerview.widget.b1 r9, androidx.recyclerview.widget.b1 r10) {
        /*
            r7 = this;
            r0 = 0
            r8.setIsRecyclable(r0)
            androidx.recyclerview.widget.c1 r0 = r7.mItemAnimator
            r1 = r0
            androidx.recyclerview.widget.p r1 = (androidx.recyclerview.widget.p) r1
            if (r9 == 0) goto L26
            r1.getClass()
            int r3 = r9.f741a
            int r5 = r10.f741a
            if (r3 != r5) goto L1a
            int r0 = r9.f742b
            int r2 = r10.f742b
            if (r0 == r2) goto L26
        L1a:
            int r4 = r9.f742b
            int r6 = r10.f742b
            r2 = r8
            boolean r8 = r1.g(r2, r3, r4, r5, r6)
            if (r8 == 0) goto L37
            goto L34
        L26:
            r1.l(r8)
            android.view.View r9 = r8.itemView
            r10 = 0
            r9.setAlpha(r10)
            java.util.ArrayList r9 = r1.f914i
            r9.add(r8)
        L34:
            r7.postAnimationRunner()
        L37:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.animateAppearance(androidx.recyclerview.widget.z1, androidx.recyclerview.widget.b1, androidx.recyclerview.widget.b1):void");
    }

    public void animateDisappearance(z1 z1Var, b1 b1Var, b1 b1Var2) {
        a(z1Var);
        z1Var.setIsRecyclable(false);
        p pVar = (p) this.mItemAnimator;
        pVar.getClass();
        int i2 = b1Var.f741a;
        int i3 = b1Var.f742b;
        View view = z1Var.itemView;
        int left = b1Var2 == null ? view.getLeft() : b1Var2.f741a;
        int top = b1Var2 == null ? view.getTop() : b1Var2.f742b;
        if (z1Var.isRemoved() || (i2 == left && i3 == top)) {
            pVar.l(z1Var);
            pVar.f913h.add(z1Var);
        } else {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            if (!pVar.g(z1Var, i2, i3, left, top)) {
                return;
            }
        }
        postAnimationRunner();
    }

    public void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str != null) {
            throw new IllegalStateException(a.a.b(this, a.a.f(str)));
        }
        throw new IllegalStateException(a.a.b(this, new StringBuilder("Cannot call this method unless RecyclerView is computing a layout or scrolling")));
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException(a.a.b(this, new StringBuilder("Cannot call this method while RecyclerView is computing a layout or scrolling")));
        }
        if (this.mDispatchScrollCounter > 0) {
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(a.a.b(this, new StringBuilder(""))));
        }
    }

    public final void b() {
        l2 l2Var;
        this.mState.a(1);
        fillRemainingScrollValues(this.mState);
        this.mState.f984i = false;
        startInterceptRequestLayout();
        n2 n2Var = this.mViewInfoStore;
        n2Var.f901a.clear();
        n2Var.f902b.b();
        onEnterLayoutOrScroll();
        g();
        View focusedChild = (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) ? getFocusedChild() : null;
        z1 z1VarFindContainingViewHolder = focusedChild == null ? null : findContainingViewHolder(focusedChild);
        if (z1VarFindContainingViewHolder == null) {
            w1 w1Var = this.mState;
            w1Var.f988m = -1L;
            w1Var.f987l = -1;
            w1Var.f989n = -1;
        } else {
            this.mState.f988m = this.mAdapter.hasStableIds() ? z1VarFindContainingViewHolder.getItemId() : -1L;
            this.mState.f987l = this.mDataSetHasChangedAfterLayout ? -1 : z1VarFindContainingViewHolder.isRemoved() ? z1VarFindContainingViewHolder.mOldPosition : z1VarFindContainingViewHolder.getAdapterPosition();
            w1 w1Var2 = this.mState;
            View focusedChild2 = z1VarFindContainingViewHolder.itemView;
            int id = focusedChild2.getId();
            while (!focusedChild2.isFocused() && (focusedChild2 instanceof ViewGroup) && focusedChild2.hasFocus()) {
                focusedChild2 = ((ViewGroup) focusedChild2).getFocusedChild();
                if (focusedChild2.getId() != -1) {
                    id = focusedChild2.getId();
                }
            }
            w1Var2.f989n = id;
        }
        w1 w1Var3 = this.mState;
        w1Var3.f983h = w1Var3.f985j && this.mItemsChanged;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        w1Var3.f982g = w1Var3.f986k;
        w1Var3.f980e = this.mAdapter.getItemCount();
        e(this.mMinMaxLayoutPositions);
        if (this.mState.f985j) {
            int iE = this.mChildHelper.e();
            for (int i2 = 0; i2 < iE; i2++) {
                z1 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i2));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    c1 c1Var = this.mItemAnimator;
                    c1.b(childViewHolderInt);
                    childViewHolderInt.getUnmodifiedPayloads();
                    c1Var.getClass();
                    b1 b1Var = new b1();
                    b1Var.a(childViewHolderInt);
                    g.l lVar = this.mViewInfoStore.f901a;
                    l2 l2VarA = (l2) lVar.getOrDefault(childViewHolderInt, null);
                    if (l2VarA == null) {
                        l2VarA = l2.a();
                        lVar.put(childViewHolderInt, l2VarA);
                    }
                    l2VarA.f883b = b1Var;
                    l2VarA.f882a |= 4;
                    if (this.mState.f983h && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.f902b.g(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.f986k) {
            saveOldPositions();
            w1 w1Var4 = this.mState;
            boolean z2 = w1Var4.f981f;
            w1Var4.f981f = false;
            this.mLayout.onLayoutChildren(this.mRecycler, w1Var4);
            this.mState.f981f = z2;
            for (int i3 = 0; i3 < this.mChildHelper.e(); i3++) {
                z1 childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.d(i3));
                if (!childViewHolderInt2.shouldIgnore() && ((l2Var = (l2) this.mViewInfoStore.f901a.getOrDefault(childViewHolderInt2, null)) == null || (l2Var.f882a & 4) == 0)) {
                    c1.b(childViewHolderInt2);
                    boolean zHasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(8192);
                    c1 c1Var2 = this.mItemAnimator;
                    childViewHolderInt2.getUnmodifiedPayloads();
                    c1Var2.getClass();
                    b1 b1Var2 = new b1();
                    b1Var2.a(childViewHolderInt2);
                    if (zHasAnyOfTheFlags) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, b1Var2);
                    } else {
                        g.l lVar2 = this.mViewInfoStore.f901a;
                        l2 l2VarA2 = (l2) lVar2.getOrDefault(childViewHolderInt2, null);
                        if (l2VarA2 == null) {
                            l2VarA2 = l2.a();
                            lVar2.put(childViewHolderInt2, l2VarA2);
                        }
                        l2VarA2.f882a |= 2;
                        l2VarA2.f883b = b1Var2;
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.f979d = 2;
    }

    public final void c() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.a(6);
        this.mAdapterHelper.c();
        this.mState.f980e = this.mAdapter.getItemCount();
        w1 w1Var = this.mState;
        w1Var.f978c = 0;
        w1Var.f982g = false;
        this.mLayout.onLayoutChildren(this.mRecycler, w1Var);
        w1 w1Var2 = this.mState;
        w1Var2.f981f = false;
        this.mPendingSavedState = null;
        w1Var2.f985j = w1Var2.f985j && this.mItemAnimator != null;
        w1Var2.f979d = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    public boolean canReuseUpdatedViewHolder(z1 z1Var) {
        c1 c1Var = this.mItemAnimator;
        if (c1Var != null) {
            List<Object> unmodifiedPayloads = z1Var.getUnmodifiedPayloads();
            p pVar = (p) c1Var;
            pVar.getClass();
            if (unmodifiedPayloads.isEmpty() && pVar.f912g && !z1Var.isInvalid()) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof i1) && this.mLayout.checkLayoutParams((i1) layoutParams);
    }

    public void clearOldPositions() {
        int iH = this.mChildHelper.h();
        for (int i2 = 0; i2 < iH; i2++) {
            z1 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i2));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        p1 p1Var = this.mRecycler;
        ArrayList arrayList = p1Var.f927c;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((z1) arrayList.get(i3)).clearOldPosition();
        }
        ArrayList arrayList2 = p1Var.f925a;
        int size2 = arrayList2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            ((z1) arrayList2.get(i4)).clearOldPosition();
        }
        ArrayList arrayList3 = p1Var.f926b;
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            for (int i5 = 0; i5 < size3; i5++) {
                ((z1) p1Var.f926b.get(i5)).clearOldPosition();
            }
        }
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<j1> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<m1> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        h1 h1Var = this.mLayout;
        if (h1Var != null && h1Var.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        h1 h1Var = this.mLayout;
        if (h1Var != null && h1Var.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        h1 h1Var = this.mLayout;
        if (h1Var != null && h1Var.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        h1 h1Var = this.mLayout;
        if (h1Var != null && h1Var.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        h1 h1Var = this.mLayout;
        if (h1Var != null && h1Var.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        h1 h1Var = this.mLayout;
        if (h1Var != null && h1Var.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return 0;
    }

    public void considerReleasingGlowsOnScroll(int i2, int i3) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            zIsFinished = false;
        } else {
            this.mLeftGlow.onRelease();
            zIsFinished = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.mRightGlow.onRelease();
            zIsFinished |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.mTopGlow.onRelease();
            zIsFinished |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.mBottomGlow.onRelease();
            zIsFinished |= this.mBottomGlow.isFinished();
        }
        if (zIsFinished) {
            WeakHashMap weakHashMap = androidx.core.view.d1.f138a;
            androidx.core.view.m0.k(this);
        }
    }

    public void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            n.e.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            n.e.b();
            return;
        }
        if (this.mAdapterHelper.g()) {
            b bVar = this.mAdapterHelper;
            int i2 = bVar.f735f;
            if ((i2 & 4) == 0 || (i2 & 11) != 0) {
                if (bVar.g()) {
                    n.e.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                    dispatchLayout();
                    n.e.b();
                    return;
                }
                return;
            }
            n.e.a(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            this.mAdapterHelper.j();
            if (!this.mLayoutWasDefered) {
                int iE = this.mChildHelper.e();
                int i3 = 0;
                while (true) {
                    if (i3 < iE) {
                        z1 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i3));
                        if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                            dispatchLayout();
                            break;
                        }
                        i3++;
                    } else {
                        this.mAdapterHelper.b();
                        break;
                    }
                }
            }
            stopInterceptRequestLayout(true);
            onExitLayoutOrScroll();
            n.e.b();
        }
    }

    public final boolean d(MotionEvent motionEvent) {
        boolean z2;
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            l1 l1Var = this.mOnItemTouchListeners.get(i2);
            z zVar = (z) l1Var;
            int i3 = zVar.f1022v;
            if (i3 == 1) {
                boolean zB = zVar.b(motionEvent.getX(), motionEvent.getY());
                boolean zA = zVar.a(motionEvent.getX(), motionEvent.getY());
                if (motionEvent.getAction() == 0 && (zB || zA)) {
                    if (zA) {
                        zVar.f1023w = 1;
                        zVar.f1016p = (int) motionEvent.getX();
                    } else if (zB) {
                        zVar.f1023w = 2;
                        zVar.f1013m = (int) motionEvent.getY();
                    }
                    zVar.d(2);
                }
            } else {
                z2 = i3 == 2;
            }
            if (z2 && action != 3) {
                this.mInterceptingOnItemTouchListener = l1Var;
                return true;
            }
        }
        return false;
    }

    public void defaultOnMeasure(int i2, int i3) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        WeakHashMap weakHashMap = androidx.core.view.d1.f138a;
        setMeasuredDimension(h1.chooseSize(i2, paddingRight, androidx.core.view.m0.e(this)), h1.chooseSize(i3, getPaddingBottom() + getPaddingTop(), androidx.core.view.m0.d(this)));
    }

    public void dispatchChildAttached(View view) {
        int size;
        z1 childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        v0 v0Var = this.mAdapter;
        if (v0Var != null && childViewHolderInt != null) {
            v0Var.onViewAttachedToWindow(childViewHolderInt);
        }
        if (this.mOnChildAttachStateListeners == null || r2.size() - 1 < 0) {
            return;
        }
        a.a.j(this.mOnChildAttachStateListeners.get(size));
        throw null;
    }

    public void dispatchChildDetached(View view) {
        int size;
        z1 childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        v0 v0Var = this.mAdapter;
        if (v0Var != null && childViewHolderInt != null) {
            v0Var.onViewDetachedFromWindow(childViewHolderInt);
        }
        if (this.mOnChildAttachStateListeners == null || r2.size() - 1 < 0) {
            return;
        }
        a.a.j(this.mOnChildAttachStateListeners.get(size));
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:157:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0399  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void dispatchLayout() {
        /*
            Method dump skipped, instructions count: 1029
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.dispatchLayout():void");
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        ViewParent viewParentC;
        androidx.core.view.y scrollingChildHelper = getScrollingChildHelper();
        if (!scrollingChildHelper.f224d || (viewParentC = scrollingChildHelper.c(0)) == null) {
            return false;
        }
        return x0.g.g0(viewParentC, scrollingChildHelper.f223c, f2, f3, z2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        ViewParent viewParentC;
        androidx.core.view.y scrollingChildHelper = getScrollingChildHelper();
        if (!scrollingChildHelper.f224d || (viewParentC = scrollingChildHelper.c(0)) == null) {
            return false;
        }
        return x0.g.h0(viewParentC, scrollingChildHelper.f223c, f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().b(i2, i3, i4, i5, iArr, 0, null);
    }

    public void dispatchOnScrollStateChanged(int i2) {
        h1 h1Var = this.mLayout;
        if (h1Var != null) {
            h1Var.onScrollStateChanged(i2);
        }
        onScrollStateChanged(i2);
        m1 m1Var = this.mScrollListener;
        if (m1Var != null) {
            m1Var.onScrollStateChanged(this, i2);
        }
        List<m1> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i2);
            }
        }
    }

    public void dispatchOnScrolled(int i2, int i3) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i3);
        onScrolled(i2, i3);
        m1 m1Var = this.mScrollListener;
        if (m1Var != null) {
            m1Var.onScrolled(this, i2, i3);
        }
        List<m1> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i2, i3);
            }
        }
        this.mDispatchScrollCounter--;
    }

    public void dispatchPendingImportantForAccessibilityChanges() {
        int i2;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            z1 z1Var = this.mPendingAccessibilityImportanceChange.get(size);
            if (z1Var.itemView.getParent() == this && !z1Var.shouldIgnore() && (i2 = z1Var.mPendingAccessibilityState) != -1) {
                View view = z1Var.itemView;
                WeakHashMap weakHashMap = androidx.core.view.d1.f138a;
                androidx.core.view.m0.s(view, i2);
                z1Var.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z2;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.mItemDecorations.get(i2).onDrawOver(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 |= z3;
            canvas.restoreToCount(iSave4);
        }
        if ((z2 || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.f()) && !z2) {
            return;
        }
        WeakHashMap weakHashMap = androidx.core.view.d1.f138a;
        androidx.core.view.m0.k(this);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public final void e(int[] iArr) {
        int iE = this.mChildHelper.e();
        if (iE == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < iE; i4++) {
            z1 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i4));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i2) {
                    i2 = layoutPosition;
                }
                if (layoutPosition > i3) {
                    i3 = layoutPosition;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    public void ensureBottomGlow() {
        if (this.mBottomGlow != null) {
            return;
        }
        this.mEdgeEffectFactory.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.mBottomGlow = edgeEffect;
        if (this.mClipToPadding) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void ensureLeftGlow() {
        if (this.mLeftGlow != null) {
            return;
        }
        this.mEdgeEffectFactory.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.mLeftGlow = edgeEffect;
        if (this.mClipToPadding) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void ensureRightGlow() {
        if (this.mRightGlow != null) {
            return;
        }
        this.mEdgeEffectFactory.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.mRightGlow = edgeEffect;
        if (this.mClipToPadding) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void ensureTopGlow() {
        if (this.mTopGlow != null) {
            return;
        }
        this.mEdgeEffectFactory.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.mTopGlow = edgeEffect;
        if (this.mClipToPadding) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    public final void f(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.mLastTouchX = x2;
            this.mInitialTouchX = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.mLastTouchY = y2;
            this.mInitialTouchY = y2;
        }
    }

    public final void fillRemainingScrollValues(w1 w1Var) {
        if (getScrollState() != 2) {
            w1Var.getClass();
            return;
        }
        OverScroller overScroller = this.mViewFlinger.f996c;
        overScroller.getFinalX();
        overScroller.getCurrX();
        w1Var.getClass();
        overScroller.getFinalY();
        overScroller.getCurrY();
    }

    public View findChildViewUnder(float f2, float f3) {
        for (int iE = this.mChildHelper.e() - 1; iE >= 0; iE--) {
            View viewD = this.mChildHelper.d(iE);
            float translationX = viewD.getTranslationX();
            float translationY = viewD.getTranslationY();
            if (f2 >= viewD.getLeft() + translationX && f2 <= viewD.getRight() + translationX && f3 >= viewD.getTop() + translationY && f3 <= viewD.getBottom() + translationY) {
                return viewD;
            }
        }
        return null;
    }

    public View findContainingItemView(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public z1 findContainingViewHolder(View view) {
        View viewFindContainingItemView = findContainingItemView(view);
        if (viewFindContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(viewFindContainingItemView);
    }

    public z1 findViewHolderForAdapterPosition(int i2) {
        z1 z1Var = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int iH = this.mChildHelper.h();
        for (int i3 = 0; i3 < iH; i3++) {
            z1 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i3));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionFor(childViewHolderInt) == i2) {
                if (!this.mChildHelper.k(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                z1Var = childViewHolderInt;
            }
        }
        return z1Var;
    }

    public z1 findViewHolderForItemId(long j2) {
        v0 v0Var = this.mAdapter;
        z1 z1Var = null;
        if (v0Var != null && v0Var.hasStableIds()) {
            int iH = this.mChildHelper.h();
            for (int i2 = 0; i2 < iH; i2++) {
                z1 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i2));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j2) {
                    if (!this.mChildHelper.k(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    z1Var = childViewHolderInt;
                }
            }
        }
        return z1Var;
    }

    public z1 findViewHolderForLayoutPosition(int i2) {
        return findViewHolderForPosition(i2, false);
    }

    @Deprecated
    public z1 findViewHolderForPosition(int i2) {
        return findViewHolderForPosition(i2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean fling(int r20, int r21) {
        /*
            Method dump skipped, instructions count: 443
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.fling(int, int):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i2) {
        View viewOnFocusSearchFailed;
        int i3;
        char c2;
        boolean z2;
        int i4 = i2;
        View viewOnInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, i4);
        if (viewOnInterceptFocusSearch != null) {
            return viewOnInterceptFocusSearch;
        }
        boolean z3 = (this.mAdapter == null || this.mLayout == null || isComputingLayout() || this.mLayoutSuppressed) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z3 && (i4 == 2 || i4 == 1)) {
            if (this.mLayout.canScrollVertically()) {
                int i5 = i4 == 2 ? 130 : 33;
                z2 = focusFinder.findNextFocus(this, view, i5) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i4 = i5;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.mLayout.canScrollHorizontally()) {
                int i6 = (this.mLayout.getLayoutDirection() == 1) ^ (i4 == 2) ? 66 : 17;
                z2 = focusFinder.findNextFocus(this, view, i6) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i4 = i6;
                }
            }
            if (z2) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.onFocusSearchFailed(view, i4, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            viewOnFocusSearchFailed = focusFinder.findNextFocus(this, view, i4);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i4);
            if (viewFindNextFocus == null && z3) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                viewOnFocusSearchFailed = this.mLayout.onFocusSearchFailed(view, i4, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            } else {
                viewOnFocusSearchFailed = viewFindNextFocus;
            }
        }
        if (viewOnFocusSearchFailed != null && !viewOnFocusSearchFailed.hasFocusable()) {
            if (getFocusedChild() == null) {
                return super.focusSearch(view, i4);
            }
            h(viewOnFocusSearchFailed, null);
            return view;
        }
        if (viewOnFocusSearchFailed != null && viewOnFocusSearchFailed != this && findContainingItemView(viewOnFocusSearchFailed) != null) {
            if (view == null || findContainingItemView(view) == null) {
                return viewOnFocusSearchFailed;
            }
            this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
            this.mTempRect2.set(0, 0, viewOnFocusSearchFailed.getWidth(), viewOnFocusSearchFailed.getHeight());
            offsetDescendantRectToMyCoords(view, this.mTempRect);
            offsetDescendantRectToMyCoords(viewOnFocusSearchFailed, this.mTempRect2);
            int i7 = this.mLayout.getLayoutDirection() == 1 ? -1 : 1;
            Rect rect = this.mTempRect;
            int i8 = rect.left;
            Rect rect2 = this.mTempRect2;
            int i9 = rect2.left;
            if ((i8 < i9 || rect.right <= i9) && rect.right < rect2.right) {
                i3 = 1;
            } else {
                int i10 = rect.right;
                int i11 = rect2.right;
                i3 = ((i10 > i11 || i8 >= i11) && i8 > i9) ? -1 : 0;
            }
            int i12 = rect.top;
            int i13 = rect2.top;
            if ((i12 < i13 || rect.bottom <= i13) && rect.bottom < rect2.bottom) {
                c2 = 1;
            } else {
                int i14 = rect.bottom;
                int i15 = rect2.bottom;
                c2 = ((i14 > i15 || i12 >= i15) && i12 > i13) ? (char) 65535 : (char) 0;
            }
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 17) {
                        if (i4 != 33) {
                            if (i4 != 66) {
                                if (i4 != 130) {
                                    StringBuilder sb = new StringBuilder("Invalid direction: ");
                                    sb.append(i4);
                                    throw new IllegalArgumentException(a.a.b(this, sb));
                                }
                                if (c2 > 0) {
                                    return viewOnFocusSearchFailed;
                                }
                            } else if (i3 > 0) {
                                return viewOnFocusSearchFailed;
                            }
                        } else if (c2 < 0) {
                            return viewOnFocusSearchFailed;
                        }
                    } else if (i3 < 0) {
                        return viewOnFocusSearchFailed;
                    }
                } else {
                    if (c2 > 0) {
                        return viewOnFocusSearchFailed;
                    }
                    if (c2 == 0 && i3 * i7 >= 0) {
                        return viewOnFocusSearchFailed;
                    }
                }
            } else {
                if (c2 < 0) {
                    return viewOnFocusSearchFailed;
                }
                if (c2 == 0 && i3 * i7 <= 0) {
                    return viewOnFocusSearchFailed;
                }
            }
        }
        return super.focusSearch(view, i4);
    }

    public final void g() {
        boolean z2;
        boolean z3 = false;
        if (this.mDataSetHasChangedAfterLayout) {
            b bVar = this.mAdapterHelper;
            bVar.l(bVar.f731b);
            bVar.l(bVar.f732c);
            bVar.f735f = 0;
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (this.mItemAnimator == null || !this.mLayout.supportsPredictiveItemAnimations()) {
            this.mAdapterHelper.c();
        } else {
            this.mAdapterHelper.j();
        }
        boolean z4 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.f985j = this.mFirstLayoutComplete && this.mItemAnimator != null && ((z2 = this.mDataSetHasChangedAfterLayout) || z4 || this.mLayout.mRequestedSimpleAnimations) && (!z2 || this.mAdapter.hasStableIds());
        w1 w1Var = this.mState;
        if (w1Var.f985j && z4 && !this.mDataSetHasChangedAfterLayout && this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations()) {
            z3 = true;
        }
        w1Var.f986k = z3;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        h1 h1Var = this.mLayout;
        if (h1Var != null) {
            return h1Var.generateDefaultLayoutParams();
        }
        throw new IllegalStateException(a.a.b(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        h1 h1Var = this.mLayout;
        if (h1Var != null) {
            return h1Var.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException(a.a.b(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public v0 getAdapter() {
        return this.mAdapter;
    }

    public int getAdapterPositionFor(z1 z1Var) {
        if (z1Var.hasAnyOfTheFlags(524) || !z1Var.isBound()) {
            return -1;
        }
        b bVar = this.mAdapterHelper;
        int i2 = z1Var.mPosition;
        ArrayList arrayList = bVar.f731b;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            a aVar = (a) arrayList.get(i3);
            int i4 = aVar.f720a;
            if (i4 != 1) {
                if (i4 == 2) {
                    int i5 = aVar.f721b;
                    if (i5 <= i2) {
                        int i6 = aVar.f723d;
                        if (i5 + i6 > i2) {
                            return -1;
                        }
                        i2 -= i6;
                    } else {
                        continue;
                    }
                } else if (i4 == 8) {
                    int i7 = aVar.f721b;
                    if (i7 == i2) {
                        i2 = aVar.f723d;
                    } else {
                        if (i7 < i2) {
                            i2--;
                        }
                        if (aVar.f723d <= i2) {
                            i2++;
                        }
                    }
                }
            } else if (aVar.f721b <= i2) {
                i2 += aVar.f723d;
            }
        }
        return i2;
    }

    @Override // android.view.View
    public int getBaseline() {
        h1 h1Var = this.mLayout;
        return h1Var != null ? h1Var.getBaseline() : super.getBaseline();
    }

    public long getChangedHolderKey(z1 z1Var) {
        return this.mAdapter.hasStableIds() ? z1Var.getItemId() : z1Var.mPosition;
    }

    public int getChildAdapterPosition(View view) {
        z1 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAdapterPosition();
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        return super.getChildDrawingOrder(i2, i3);
    }

    public long getChildItemId(View view) {
        z1 childViewHolderInt;
        v0 v0Var = this.mAdapter;
        if (v0Var == null || !v0Var.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1L;
        }
        return childViewHolderInt.getItemId();
    }

    public int getChildLayoutPosition(View view) {
        z1 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public z1 getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public b2 getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    public z0 getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public c1 getItemAnimator() {
        return this.mItemAnimator;
    }

    public Rect getItemDecorInsetsForChild(View view) {
        i1 i1Var = (i1) view.getLayoutParams();
        boolean z2 = i1Var.f854c;
        Rect rect = i1Var.f853b;
        if (!z2) {
            return rect;
        }
        if (this.mState.f982g && (i1Var.f852a.isUpdated() || i1Var.f852a.isInvalid())) {
            return rect;
        }
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i2).getItemOffsets(this.mTempRect, view, this, this.mState);
            int i3 = rect.left;
            Rect rect2 = this.mTempRect;
            rect.left = i3 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        i1Var.f854c = false;
        return rect;
    }

    public d1 getItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 >= 0 && i2 < itemDecorationCount) {
            return this.mItemDecorations.get(i2);
        }
        throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public h1 getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0L;
    }

    public k1 getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public o1 getRecycledViewPool() {
        return this.mRecycler.c();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public final void h(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof i1) {
            i1 i1Var = (i1) layoutParams;
            if (!i1Var.f854c) {
                Rect rect = this.mTempRect;
                int i2 = rect.left;
                Rect rect2 = i1Var.f853b;
                rect.left = i2 - rect2.left;
                rect.right += rect2.right;
                rect.top -= rect2.top;
                rect.bottom += rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.requestChildRectangleOnScreen(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().d(0);
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.g();
    }

    public final void i() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean zIsFinished = false;
        stopNestedScroll(0);
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.mBottomGlow.isFinished();
        }
        if (zIsFinished) {
            WeakHashMap weakHashMap = androidx.core.view.d1.f138a;
            androidx.core.view.m0.k(this);
        }
    }

    public void initAdapterManager() {
        this.mAdapterHelper = new b(new u0(this));
    }

    public void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException(a.a.b(this, new StringBuilder("Trying to set fast scroller without both required drawables.")));
        }
        Resources resources = getContext().getResources();
        new z(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R$dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(R$dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(R$dimen.fastscroll_margin));
    }

    public void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() == 0) {
            return;
        }
        h1 h1Var = this.mLayout;
        if (h1Var != null) {
            h1Var.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean isAnimating() {
        c1 c1Var = this.mItemAnimator;
        return c1Var != null && c1Var.f();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().f224d;
    }

    public final void j(v0 v0Var, boolean z2, boolean z3) {
        v0 v0Var2 = this.mAdapter;
        if (v0Var2 != null) {
            v0Var2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z2 || z3) {
            removeAndRecycleViews();
        }
        b bVar = this.mAdapterHelper;
        bVar.l(bVar.f731b);
        bVar.l(bVar.f732c);
        int i2 = 0;
        bVar.f735f = 0;
        v0 v0Var3 = this.mAdapter;
        this.mAdapter = v0Var;
        if (v0Var != null) {
            v0Var.registerAdapterDataObserver(this.mObserver);
            v0Var.onAttachedToRecyclerView(this);
        }
        h1 h1Var = this.mLayout;
        if (h1Var != null) {
            h1Var.onAdapterChanged(v0Var3, this.mAdapter);
        }
        p1 p1Var = this.mRecycler;
        v0 v0Var4 = this.mAdapter;
        p1Var.f925a.clear();
        p1Var.e();
        o1 o1VarC = p1Var.c();
        if (v0Var3 != null) {
            o1VarC.f910b--;
        }
        if (!z2 && o1VarC.f910b == 0) {
            while (true) {
                SparseArray sparseArray = o1VarC.f909a;
                if (i2 >= sparseArray.size()) {
                    break;
                }
                ((n1) sparseArray.valueAt(i2)).f897a.clear();
                i2++;
            }
        }
        if (v0Var4 != null) {
            o1VarC.f910b++;
        } else {
            o1VarC.getClass();
        }
        this.mState.f981f = true;
    }

    public void jumpToPositionForSmoothScroller(int i2) {
        if (this.mLayout == null) {
            return;
        }
        setScrollState(2);
        this.mLayout.scrollToPosition(i2);
        awakenScrollBars();
    }

    public void markItemDecorInsetsDirty() {
        int iH = this.mChildHelper.h();
        for (int i2 = 0; i2 < iH; i2++) {
            ((i1) this.mChildHelper.g(i2).getLayoutParams()).f854c = true;
        }
        ArrayList arrayList = this.mRecycler.f927c;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            i1 i1Var = (i1) ((z1) arrayList.get(i3)).itemView.getLayoutParams();
            if (i1Var != null) {
                i1Var.f854c = true;
            }
        }
    }

    public void markKnownViewsInvalid() {
        int iH = this.mChildHelper.h();
        for (int i2 = 0; i2 < iH; i2++) {
            z1 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i2));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        p1 p1Var = this.mRecycler;
        ArrayList arrayList = p1Var.f927c;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            z1 z1Var = (z1) arrayList.get(i3);
            if (z1Var != null) {
                z1Var.addFlags(6);
                z1Var.addChangePayload(null);
            }
        }
        v0 v0Var = p1Var.f932h.mAdapter;
        if (v0Var == null || !v0Var.hasStableIds()) {
            p1Var.e();
        }
    }

    public void offsetChildrenHorizontal(int i2) {
        int iE = this.mChildHelper.e();
        for (int i3 = 0; i3 < iE; i3++) {
            this.mChildHelper.d(i3).offsetLeftAndRight(i2);
        }
    }

    public void offsetChildrenVertical(int i2) {
        int iE = this.mChildHelper.e();
        for (int i3 = 0; i3 < iE; i3++) {
            this.mChildHelper.d(i3).offsetTopAndBottom(i2);
        }
    }

    public void offsetPositionRecordsForInsert(int i2, int i3) {
        int iH = this.mChildHelper.h();
        for (int i4 = 0; i4 < iH; i4++) {
            z1 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i4));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i2) {
                childViewHolderInt.offsetPosition(i3, false);
                this.mState.f981f = true;
            }
        }
        ArrayList arrayList = this.mRecycler.f927c;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            z1 z1Var = (z1) arrayList.get(i5);
            if (z1Var != null && z1Var.mPosition >= i2) {
                z1Var.offsetPosition(i3, true);
            }
        }
        requestLayout();
    }

    public void offsetPositionRecordsForMove(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int iH = this.mChildHelper.h();
        int i11 = -1;
        if (i2 < i3) {
            i5 = i2;
            i4 = i3;
            i6 = -1;
        } else {
            i4 = i2;
            i5 = i3;
            i6 = 1;
        }
        for (int i12 = 0; i12 < iH; i12++) {
            z1 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i12));
            if (childViewHolderInt != null && (i10 = childViewHolderInt.mPosition) >= i5 && i10 <= i4) {
                if (i10 == i2) {
                    childViewHolderInt.offsetPosition(i3 - i2, false);
                } else {
                    childViewHolderInt.offsetPosition(i6, false);
                }
                this.mState.f981f = true;
            }
        }
        p1 p1Var = this.mRecycler;
        p1Var.getClass();
        if (i2 < i3) {
            i8 = i2;
            i7 = i3;
        } else {
            i7 = i2;
            i11 = 1;
            i8 = i3;
        }
        ArrayList arrayList = p1Var.f927c;
        int size = arrayList.size();
        for (int i13 = 0; i13 < size; i13++) {
            z1 z1Var = (z1) arrayList.get(i13);
            if (z1Var != null && (i9 = z1Var.mPosition) >= i8 && i9 <= i7) {
                if (i9 == i2) {
                    z1Var.offsetPosition(i3 - i2, false);
                } else {
                    z1Var.offsetPosition(i11, false);
                }
            }
        }
        requestLayout();
    }

    public void offsetPositionRecordsForRemove(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int iH = this.mChildHelper.h();
        for (int i5 = 0; i5 < iH; i5++) {
            z1 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i5));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                int i6 = childViewHolderInt.mPosition;
                if (i6 >= i4) {
                    childViewHolderInt.offsetPosition(-i3, z2);
                    this.mState.f981f = true;
                } else if (i6 >= i2) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(i2 - 1, -i3, z2);
                    this.mState.f981f = true;
                }
            }
        }
        p1 p1Var = this.mRecycler;
        ArrayList arrayList = p1Var.f927c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            z1 z1Var = (z1) arrayList.get(size);
            if (z1Var != null) {
                int i7 = z1Var.mPosition;
                if (i7 >= i4) {
                    z1Var.offsetPosition(-i3, z2);
                } else if (i7 >= i2) {
                    z1Var.addFlags(8);
                    p1Var.f(size);
                }
            }
        }
        requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.mLayoutOrScrollCounter = r0
            r1 = 1
            r5.mIsAttached = r1
            boolean r2 = r5.mFirstLayoutComplete
            if (r2 == 0) goto L14
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = r0
        L15:
            r5.mFirstLayoutComplete = r1
            androidx.recyclerview.widget.h1 r1 = r5.mLayout
            if (r1 == 0) goto L1e
            r1.dispatchAttachedToWindow(r5)
        L1e:
            r5.mPostedAnimatorRunner = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.ALLOW_THREAD_GAP_WORK
            if (r0 == 0) goto L73
            java.lang.ThreadLocal r0 = androidx.recyclerview.widget.c0.f746e
            java.lang.Object r1 = r0.get()
            androidx.recyclerview.widget.c0 r1 = (androidx.recyclerview.widget.c0) r1
            r5.mGapWorker = r1
            if (r1 != 0) goto L6c
            androidx.recyclerview.widget.c0 r1 = new androidx.recyclerview.widget.c0
            r1.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f748a = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f751d = r2
            r5.mGapWorker = r1
            java.util.WeakHashMap r1 = androidx.core.view.d1.f138a
            android.view.Display r1 = androidx.core.view.n0.b(r5)
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L5e
            if (r1 == 0) goto L5e
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L5e
            goto L60
        L5e:
            r1 = 1114636288(0x42700000, float:60.0)
        L60:
            androidx.recyclerview.widget.c0 r2 = r5.mGapWorker
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f750c = r3
            r0.set(r2)
        L6c:
            androidx.recyclerview.widget.c0 r0 = r5.mGapWorker
            java.util.ArrayList r0 = r0.f748a
            r0.add(r5)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        c0 c0Var;
        super.onDetachedFromWindow();
        c1 c1Var = this.mItemAnimator;
        if (c1Var != null) {
            c1Var.e();
        }
        stopScroll();
        this.mIsAttached = false;
        h1 h1Var = this.mLayout;
        if (h1Var != null) {
            h1Var.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.getClass();
        while (l2.f881d.acquire() != null) {
        }
        if (!ALLOW_THREAD_GAP_WORK || (c0Var = this.mGapWorker) == null) {
            return;
        }
        c0Var.f748a.remove(this);
        this.mGapWorker = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mItemDecorations.get(i2).onDraw(canvas, this, this.mState);
        }
    }

    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    public void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.h1 r0 = r5.mLayout
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.mLayoutSuppressed
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L77
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3e
            androidx.recyclerview.widget.h1 r0 = r5.mLayout
            boolean r0 = r0.canScrollVertically()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = r2
        L2d:
            androidx.recyclerview.widget.h1 r3 = r5.mLayout
            boolean r3 = r3.canScrollHorizontally()
            if (r3 == 0) goto L3c
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L64
        L3c:
            r3 = r2
            goto L64
        L3e:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L62
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.h1 r3 = r5.mLayout
            boolean r3 = r3.canScrollVertically()
            if (r3 == 0) goto L57
            float r0 = -r0
            goto L3c
        L57:
            androidx.recyclerview.widget.h1 r3 = r5.mLayout
            boolean r3 = r3.canScrollHorizontally()
            if (r3 == 0) goto L62
            r3 = r0
            r0 = r2
            goto L64
        L62:
            r0 = r2
            r3 = r0
        L64:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6c
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L77
        L6c:
            float r2 = r5.mScaledHorizontalScrollFactor
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.mScaledVerticalScrollFactor
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.scrollByInternal(r2, r0, r6)
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (d(motionEvent)) {
            i();
            setScrollState(0);
            return true;
        }
        h1 h1Var = this.mLayout;
        if (h1Var == null) {
            return false;
        }
        boolean zCanScrollHorizontally = h1Var.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x2;
            this.mInitialTouchX = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y2;
            this.mInitialTouchY = y2;
            if (this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            int i2 = zCanScrollHorizontally;
            if (zCanScrollVertically) {
                i2 = (zCanScrollHorizontally ? 1 : 0) | 2;
            }
            startNestedScroll(i2, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (iFindPointerIndex < 0) {
                Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.mScrollState != 1) {
                int i3 = x3 - this.mInitialTouchX;
                int i4 = y3 - this.mInitialTouchY;
                if (zCanScrollHorizontally == 0 || Math.abs(i3) <= this.mTouchSlop) {
                    z2 = false;
                } else {
                    this.mLastTouchX = x3;
                    z2 = true;
                }
                if (zCanScrollVertically && Math.abs(i4) > this.mTouchSlop) {
                    this.mLastTouchY = y3;
                } else if (z2) {
                }
                setScrollState(1);
            }
        } else if (actionMasked == 3) {
            i();
            setScrollState(0);
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x4;
            this.mInitialTouchX = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y4;
            this.mInitialTouchY = y4;
        } else if (actionMasked == 6) {
            f(motionEvent);
        }
        return this.mScrollState == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        n.e.a(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        n.e.b();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        h1 h1Var = this.mLayout;
        if (h1Var == null) {
            defaultOnMeasure(i2, i3);
            return;
        }
        if (h1Var.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.mLayout.onMeasure(this.mRecycler, this.mState, i2, i3);
            if ((mode == 1073741824 && mode2 == 1073741824) || this.mAdapter == null) {
                return;
            }
            if (this.mState.f979d == 1) {
                b();
            }
            this.mLayout.setMeasureSpecs(i2, i3);
            this.mState.f984i = true;
            c();
            this.mLayout.setMeasuredDimensionFromChildren(i2, i3);
            if (this.mLayout.shouldMeasureTwice()) {
                this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), BasicMeasure.EXACTLY));
                this.mState.f984i = true;
                c();
                this.mLayout.setMeasuredDimensionFromChildren(i2, i3);
                return;
            }
            return;
        }
        if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, i2, i3);
            return;
        }
        if (this.mAdapterUpdateDuringMeasure) {
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            g();
            onExitLayoutOrScroll();
            w1 w1Var = this.mState;
            if (w1Var.f986k) {
                w1Var.f982g = true;
            } else {
                this.mAdapterHelper.c();
                this.mState.f982g = false;
            }
            this.mAdapterUpdateDuringMeasure = false;
            stopInterceptRequestLayout(false);
        } else if (this.mState.f986k) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        v0 v0Var = this.mAdapter;
        if (v0Var != null) {
            this.mState.f980e = v0Var.getItemCount();
        } else {
            this.mState.f980e = 0;
        }
        startInterceptRequestLayout();
        this.mLayout.onMeasure(this.mRecycler, this.mState, i2, i3);
        stopInterceptRequestLayout(false);
        this.mState.f982g = false;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof s1)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        s1 s1Var = (s1) parcelable;
        this.mPendingSavedState = s1Var;
        super.onRestoreInstanceState(s1Var.getSuperState());
        h1 h1Var = this.mLayout;
        if (h1Var == null || (parcelable2 = this.mPendingSavedState.f956a) == null) {
            return;
        }
        h1Var.onRestoreInstanceState(parcelable2);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        s1 s1Var = new s1(super.onSaveInstanceState());
        s1 s1Var2 = this.mPendingSavedState;
        if (s1Var2 != null) {
            s1Var.f956a = s1Var2.f956a;
        } else {
            h1 h1Var = this.mLayout;
            if (h1Var != null) {
                s1Var.f956a = h1Var.onSaveInstanceState();
            } else {
                s1Var.f956a = null;
            }
        }
        return s1Var;
    }

    public void onScrollStateChanged(int i2) {
    }

    public void onScrolled(int i2, int i3) {
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        invalidateGlows();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e9 A[PHI: r0
      0x00e9: PHI (r0v43 int) = (r0v33 int), (r0v47 int) binds: [B:43:0x00d2, B:47:0x00e5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0102  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 752
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void postAnimationRunner() {
        if (this.mPostedAnimatorRunner || !this.mIsAttached) {
            return;
        }
        Runnable runnable = this.mItemAnimatorRunner;
        WeakHashMap weakHashMap = androidx.core.view.d1.f138a;
        androidx.core.view.m0.m(this, runnable);
        this.mPostedAnimatorRunner = true;
    }

    public void processDataSetCompletelyChanged(boolean z2) {
        this.mDispatchItemsChangedEvent = z2 | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    public void recordAnimationInfoIfBouncedHiddenView(z1 z1Var, b1 b1Var) {
        z1Var.setFlags(0, 8192);
        if (this.mState.f983h && z1Var.isUpdated() && !z1Var.isRemoved() && !z1Var.shouldIgnore()) {
            this.mViewInfoStore.f902b.g(getChangedHolderKey(z1Var), z1Var);
        }
        g.l lVar = this.mViewInfoStore.f901a;
        l2 l2VarA = (l2) lVar.getOrDefault(z1Var, null);
        if (l2VarA == null) {
            l2VarA = l2.a();
            lVar.put(z1Var, l2VarA);
        }
        l2VarA.f883b = b1Var;
        l2VarA.f882a |= 4;
    }

    public void removeAndRecycleViews() {
        c1 c1Var = this.mItemAnimator;
        if (c1Var != null) {
            c1Var.e();
        }
        h1 h1Var = this.mLayout;
        if (h1Var != null) {
            h1Var.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }
        p1 p1Var = this.mRecycler;
        p1Var.f925a.clear();
        p1Var.e();
    }

    public boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        i iVar = this.mChildHelper;
        u0 u0Var = iVar.f837a;
        int iIndexOfChild = u0Var.f972a.indexOfChild(view);
        boolean z2 = true;
        if (iIndexOfChild == -1) {
            iVar.l(view);
        } else {
            h hVar = iVar.f838b;
            if (hVar.d(iIndexOfChild)) {
                hVar.f(iIndexOfChild);
                iVar.l(view);
                u0Var.b(iIndexOfChild);
            } else {
                z2 = false;
            }
        }
        if (z2) {
            z1 childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.k(childViewHolderInt);
            this.mRecycler.h(childViewHolderInt);
        }
        stopInterceptRequestLayout(!z2);
        return z2;
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z2) {
        z1 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                StringBuilder sb = new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(childViewHolderInt);
                throw new IllegalArgumentException(a.a.b(this, sb));
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z2);
    }

    public void removeItemDecoration(d1 d1Var) {
        h1 h1Var = this.mLayout;
        if (h1Var != null) {
            h1Var.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(d1Var);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 >= 0 && i2 < itemDecorationCount) {
            removeItemDecoration(getItemDecorationAt(i2));
            return;
        }
        throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
    }

    public void removeOnChildAttachStateChangeListener(j1 j1Var) {
        List<j1> list = this.mOnChildAttachStateListeners;
        if (list == null) {
            return;
        }
        list.remove(j1Var);
    }

    public void removeOnItemTouchListener(l1 l1Var) {
        this.mOnItemTouchListeners.remove(l1Var);
        if (this.mInterceptingOnItemTouchListener == l1Var) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(m1 m1Var) {
        List<m1> list = this.mScrollListeners;
        if (list != null) {
            list.remove(m1Var);
        }
    }

    public void repositionShadowingViews() {
        z1 z1Var;
        int iE = this.mChildHelper.e();
        for (int i2 = 0; i2 < iE; i2++) {
            View viewD = this.mChildHelper.d(i2);
            z1 childViewHolder = getChildViewHolder(viewD);
            if (childViewHolder != null && (z1Var = childViewHolder.mShadowingHolder) != null) {
                View view = z1Var.itemView;
                int left = viewD.getLeft();
                int top = viewD.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            h(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.mOnItemTouchListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mOnItemTouchListeners.get(i2).getClass();
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth != 0 || this.mLayoutSuppressed) {
            this.mLayoutWasDefered = true;
        } else {
            super.requestLayout();
        }
    }

    public void saveOldPositions() {
        int iH = this.mChildHelper.h();
        for (int i2 = 0; i2 < iH; i2++) {
            z1 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i2));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        h1 h1Var = this.mLayout;
        if (h1Var == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        boolean zCanScrollHorizontally = h1Var.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (zCanScrollHorizontally || zCanScrollVertically) {
            if (!zCanScrollHorizontally) {
                i2 = 0;
            }
            if (!zCanScrollVertically) {
                i3 = 0;
            }
            scrollByInternal(i2, i3, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean scrollByInternal(int r19, int r20, android.view.MotionEvent r21) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.scrollByInternal(int, int, android.view.MotionEvent):boolean");
    }

    public void scrollStep(int i2, int i3, int[] iArr) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        n.e.a(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        int iScrollHorizontallyBy = i2 != 0 ? this.mLayout.scrollHorizontallyBy(i2, this.mRecycler, this.mState) : 0;
        int iScrollVerticallyBy = i3 != 0 ? this.mLayout.scrollVerticallyBy(i3, this.mRecycler, this.mState) : 0;
        n.e.b();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = iScrollHorizontallyBy;
            iArr[1] = iScrollVerticallyBy;
        }
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i2) {
        if (this.mLayoutSuppressed) {
            return;
        }
        stopScroll();
        h1 h1Var = this.mLayout;
        if (h1Var == null) {
            Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            h1Var.scrollToPosition(i2);
            awakenScrollBars();
        }
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (shouldDeferAccessibilityEvent(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(b2 b2Var) {
        this.mAccessibilityDelegate = b2Var;
        androidx.core.view.d1.k(this, b2Var);
    }

    public void setAdapter(v0 v0Var) {
        setLayoutFrozen(false);
        j(v0Var, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(y0 y0Var) {
        if (y0Var == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    public boolean setChildImportantForAccessibilityInternal(z1 z1Var, int i2) {
        if (isComputingLayout()) {
            z1Var.mPendingAccessibilityState = i2;
            this.mPendingAccessibilityImportanceChange.add(z1Var);
            return false;
        }
        View view = z1Var.itemView;
        WeakHashMap weakHashMap = androidx.core.view.d1.f138a;
        androidx.core.view.m0.s(view, i2);
        return true;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z2) {
        if (z2 != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z2;
        super.setClipToPadding(z2);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(z0 z0Var) {
        z0Var.getClass();
        this.mEdgeEffectFactory = z0Var;
        invalidateGlows();
    }

    public void setHasFixedSize(boolean z2) {
        this.mHasFixedSize = z2;
    }

    public void setItemAnimator(c1 c1Var) {
        c1 c1Var2 = this.mItemAnimator;
        if (c1Var2 != null) {
            c1Var2.e();
            this.mItemAnimator.f752a = null;
        }
        this.mItemAnimator = c1Var;
        if (c1Var != null) {
            c1Var.f752a = this.mItemAnimatorListener;
        }
    }

    public void setItemViewCacheSize(int i2) {
        p1 p1Var = this.mRecycler;
        p1Var.f929e = i2;
        p1Var.l();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z2) {
        suppressLayout(z2);
    }

    public void setLayoutManager(h1 h1Var) {
        u0 u0Var;
        if (h1Var == this.mLayout) {
            return;
        }
        stopScroll();
        if (this.mLayout != null) {
            c1 c1Var = this.mItemAnimator;
            if (c1Var != null) {
                c1Var.e();
            }
            this.mLayout.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
            p1 p1Var = this.mRecycler;
            p1Var.f925a.clear();
            p1Var.e();
            if (this.mIsAttached) {
                this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
            }
            this.mLayout.setRecyclerView(null);
            this.mLayout = null;
        } else {
            p1 p1Var2 = this.mRecycler;
            p1Var2.f925a.clear();
            p1Var2.e();
        }
        i iVar = this.mChildHelper;
        iVar.f838b.g();
        ArrayList arrayList = iVar.f839c;
        int size = arrayList.size();
        while (true) {
            size--;
            u0Var = iVar.f837a;
            if (size < 0) {
                break;
            }
            View view = (View) arrayList.get(size);
            u0Var.getClass();
            z1 childViewHolderInt = getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onLeftHiddenState(u0Var.f972a);
            }
            arrayList.remove(size);
        }
        RecyclerView recyclerView = u0Var.f972a;
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            recyclerView.dispatchChildDetached(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeAllViews();
        this.mLayout = h1Var;
        if (h1Var != null) {
            if (h1Var.mRecyclerView != null) {
                StringBuilder sb = new StringBuilder("LayoutManager ");
                sb.append(h1Var);
                sb.append(" is already attached to a RecyclerView:");
                throw new IllegalArgumentException(a.a.b(h1Var.mRecyclerView, sb));
            }
            h1Var.setRecyclerView(this);
            if (this.mIsAttached) {
                this.mLayout.dispatchAttachedToWindow(this);
            }
        }
        this.mRecycler.l();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        androidx.core.view.y scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.f224d) {
            WeakHashMap weakHashMap = androidx.core.view.d1.f138a;
            androidx.core.view.s0.z(scrollingChildHelper.f223c);
        }
        scrollingChildHelper.f224d = z2;
    }

    public void setOnFlingListener(k1 k1Var) {
        this.mOnFlingListener = k1Var;
    }

    @Deprecated
    public void setOnScrollListener(m1 m1Var) {
        this.mScrollListener = m1Var;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.mPreserveFocusAfterLayout = z2;
    }

    public void setRecycledViewPool(o1 o1Var) {
        p1 p1Var = this.mRecycler;
        if (p1Var.f931g != null) {
            r0.f910b--;
        }
        p1Var.f931g = o1Var;
        if (o1Var == null || p1Var.f932h.getAdapter() == null) {
            return;
        }
        p1Var.f931g.f910b++;
    }

    public void setRecyclerListener(q1 q1Var) {
    }

    public void setScrollState(int i2) {
        if (i2 == this.mScrollState) {
            return;
        }
        this.mScrollState = i2;
        if (i2 != 2) {
            y1 y1Var = this.mViewFlinger;
            y1Var.f1000g.removeCallbacks(y1Var);
            y1Var.f996c.abortAnimation();
            h1 h1Var = this.mLayout;
            if (h1Var != null) {
                h1Var.stopSmoothScroller();
            }
        }
        dispatchOnScrollStateChanged(i2);
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 == 1) {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(x1 x1Var) {
        this.mRecycler.getClass();
    }

    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!isComputingLayout()) {
            return false;
        }
        int iA = accessibilityEvent != null ? r.b.a(accessibilityEvent) : 0;
        this.mEatenAccessibilityChangeFlags |= iA != 0 ? iA : 0;
        return true;
    }

    public void smoothScrollBy(int i2, int i3) {
        smoothScrollBy(i2, i3, null);
    }

    public void smoothScrollToPosition(int i2) {
        if (this.mLayoutSuppressed) {
            return;
        }
        h1 h1Var = this.mLayout;
        if (h1Var == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            h1Var.smoothScrollToPosition(this, this.mState, i2);
        }
    }

    public void startInterceptRequestLayout() {
        int i2 = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = i2;
        if (i2 != 1 || this.mLayoutSuppressed) {
            return;
        }
        this.mLayoutWasDefered = false;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().e(i2, 0);
    }

    public void stopInterceptRequestLayout(boolean z2) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z2 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z2 && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        getScrollingChildHelper().f(0);
    }

    public void stopScroll() {
        setScrollState(0);
        y1 y1Var = this.mViewFlinger;
        y1Var.f1000g.removeCallbacks(y1Var);
        y1Var.f996c.abortAnimation();
        h1 h1Var = this.mLayout;
        if (h1Var != null) {
            h1Var.stopSmoothScroller();
        }
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z2) {
        if (z2 != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (z2) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.mLayoutSuppressed = true;
                this.mIgnoreMotionEventTillDown = true;
                stopScroll();
                return;
            }
            this.mLayoutSuppressed = false;
            if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
                requestLayout();
            }
            this.mLayoutWasDefered = false;
        }
    }

    public void swapAdapter(v0 v0Var, boolean z2) {
        setLayoutFrozen(false);
        j(v0Var, true, z2);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void viewRangeUpdate(int i2, int i3, Object obj) {
        int i4;
        int i5;
        int iH = this.mChildHelper.h();
        int i6 = i3 + i2;
        for (int i7 = 0; i7 < iH; i7++) {
            View viewG = this.mChildHelper.g(i7);
            z1 childViewHolderInt = getChildViewHolderInt(viewG);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && (i5 = childViewHolderInt.mPosition) >= i2 && i5 < i6) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((i1) viewG.getLayoutParams()).f854c = true;
            }
        }
        p1 p1Var = this.mRecycler;
        ArrayList arrayList = p1Var.f927c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            z1 z1Var = (z1) arrayList.get(size);
            if (z1Var != null && (i4 = z1Var.mPosition) >= i2 && i4 < i6) {
                z1Var.addFlags(2);
                p1Var.f(size);
            }
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) throws NoSuchMethodException, SecurityException {
        Constructor constructor;
        Object[] objArr;
        super(context, attributeSet, i2);
        this.mObserver = new r1(this);
        this.mRecycler = new p1(this);
        this.mViewInfoStore = new n2();
        this.mUpdateChildViewsRunnable = new t0(this, 0);
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new z0();
        p pVar = new p();
        pVar.f752a = null;
        pVar.f753b = new ArrayList();
        pVar.f754c = 120L;
        pVar.f755d = 120L;
        pVar.f756e = 250L;
        pVar.f757f = 250L;
        int i3 = 1;
        pVar.f912g = true;
        pVar.f913h = new ArrayList();
        pVar.f914i = new ArrayList();
        pVar.f915j = new ArrayList();
        pVar.f916k = new ArrayList();
        pVar.f917l = new ArrayList();
        pVar.f918m = new ArrayList();
        pVar.f919n = new ArrayList();
        pVar.f920o = new ArrayList();
        pVar.f921p = new ArrayList();
        pVar.f922q = new ArrayList();
        pVar.f923r = new ArrayList();
        this.mItemAnimator = pVar;
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new y1(this);
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new a0() : null;
        w1 w1Var = new w1();
        w1Var.f976a = -1;
        w1Var.f977b = 0;
        w1Var.f978c = 0;
        w1Var.f979d = 1;
        w1Var.f980e = 0;
        w1Var.f981f = false;
        w1Var.f982g = false;
        w1Var.f983h = false;
        w1Var.f984i = false;
        w1Var.f985j = false;
        w1Var.f986k = false;
        this.mState = w1Var;
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new u0(this);
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new t0(this, i3);
        this.mViewInfoProcessCallback = new u0(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = androidx.core.view.e1.a(viewConfiguration);
        this.mScaledVerticalScrollFactor = androidx.core.view.e1.b(viewConfiguration);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.f752a = this.mItemAnimatorListener;
        initAdapterManager();
        this.mChildHelper = new i(new u0(this));
        WeakHashMap weakHashMap = androidx.core.view.d1.f138a;
        if (androidx.core.view.v0.b(this) == 0) {
            androidx.core.view.v0.l(this, 8);
        }
        if (androidx.core.view.m0.c(this) == 0) {
            androidx.core.view.m0.s(this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new b2(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecyclerView, i2, 0);
        saveAttributeDataForStyleable(context, R$styleable.RecyclerView, attributeSet, typedArrayObtainStyledAttributes, i2, 0);
        String string = typedArrayObtainStyledAttributes.getString(R$styleable.RecyclerView_layoutManager);
        if (typedArrayObtainStyledAttributes.getInt(R$styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = typedArrayObtainStyledAttributes.getBoolean(R$styleable.RecyclerView_android_clipToPadding, true);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.RecyclerView_fastScrollEnabled, false);
        this.mEnableFastScroller = z2;
        if (z2) {
            initFastScroller((StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollVerticalThumbDrawable), typedArrayObtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollHorizontalThumbDrawable), typedArrayObtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        typedArrayObtainStyledAttributes.recycle();
        if (string != null) {
            String strTrim = string.trim();
            if (!strTrim.isEmpty()) {
                if (strTrim.charAt(0) == '.') {
                    strTrim = context.getPackageName() + strTrim;
                } else if (!strTrim.contains(".")) {
                    strTrim = RecyclerView.class.getPackage().getName() + '.' + strTrim;
                }
                String str = strTrim;
                try {
                    Class<? extends U> clsAsSubclass = Class.forName(str, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(h1.class);
                    try {
                        constructor = clsAsSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), 0};
                    } catch (NoSuchMethodException e2) {
                        try {
                            constructor = clsAsSubclass.getConstructor(new Class[0]);
                            objArr = null;
                        } catch (NoSuchMethodException e3) {
                            e3.initCause(e2);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + str, e3);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((h1) constructor.newInstance(objArr));
                } catch (ClassCastException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + str, e4);
                } catch (ClassNotFoundException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + str, e5);
                } catch (IllegalAccessException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + str, e6);
                } catch (InstantiationException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e7);
                } catch (InvocationTargetException e8) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e8);
                }
            }
        }
        int[] iArr = NESTED_SCROLLING_ATTRS;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes2, i2, 0);
        boolean z3 = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        typedArrayObtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z3);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.recyclerview.widget.z1 findViewHolderForPosition(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.i r0 = r5.mChildHelper
            int r0 = r0.h()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            androidx.recyclerview.widget.i r3 = r5.mChildHelper
            android.view.View r3 = r3.g(r2)
            androidx.recyclerview.widget.z1 r3 = getChildViewHolderInt(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.isRemoved()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.mPosition
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.getLayoutPosition()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            androidx.recyclerview.widget.i r1 = r5.mChildHelper
            android.view.View r4 = r3.itemView
            boolean r1 = r1.k(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findViewHolderForPosition(int, boolean):androidx.recyclerview.widget.z1");
    }

    public void onExitLayoutOrScroll(boolean z2) {
        int i2 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i2;
        if (i2 < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z2) {
                int i3 = this.mEatenAccessibilityChangeFlags;
                this.mEatenAccessibilityChangeFlags = 0;
                if (i3 != 0 && isAccessibilityEnabled()) {
                    AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                    accessibilityEventObtain.setEventType(2048);
                    r.b.b(accessibilityEventObtain, i3);
                    sendAccessibilityEventUnchecked(accessibilityEventObtain);
                }
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    public void smoothScrollBy(int i2, int i3, Interpolator interpolator) {
        smoothScrollBy(i2, i3, interpolator, Integer.MIN_VALUE);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2, i4);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().b(i2, i3, i4, i5, iArr, i6, null);
    }

    public boolean hasNestedScrollingParent(int i2) {
        return getScrollingChildHelper().d(i2);
    }

    public void smoothScrollBy(int i2, int i3, Interpolator interpolator, int i4) {
        smoothScrollBy(i2, i3, interpolator, i4, false);
    }

    public boolean startNestedScroll(int i2, int i3) {
        return getScrollingChildHelper().e(i2, i3);
    }

    public void stopNestedScroll(int i2) {
        getScrollingChildHelper().f(i2);
    }

    public void smoothScrollBy(int i2, int i3, Interpolator interpolator, int i4, boolean z2) {
        h1 h1Var = this.mLayout;
        if (h1Var == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        if (!h1Var.canScrollHorizontally()) {
            i2 = 0;
        }
        if (!this.mLayout.canScrollVertically()) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        if (i4 != Integer.MIN_VALUE && i4 <= 0) {
            scrollBy(i2, i3);
            return;
        }
        if (z2) {
            int i5 = i2 != 0 ? 1 : 0;
            if (i3 != 0) {
                i5 |= 2;
            }
            startNestedScroll(i5, 1);
        }
        this.mViewFlinger.b(i2, i3, interpolator, i4);
    }

    public final void dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        getScrollingChildHelper().b(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public void addItemDecoration(d1 d1Var) {
        addItemDecoration(d1Var, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        h1 h1Var = this.mLayout;
        if (h1Var != null) {
            return h1Var.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException(a.a.b(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }
}
