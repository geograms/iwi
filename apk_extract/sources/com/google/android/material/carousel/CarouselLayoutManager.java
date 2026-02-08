package com.google.android.material.carousel;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.d1;
import androidx.recyclerview.widget.h1;
import androidx.recyclerview.widget.i1;
import androidx.recyclerview.widget.k0;
import androidx.recyclerview.widget.p1;
import androidx.recyclerview.widget.w1;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.carousel.KeylineState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import k.d;
import x0.g;

/* loaded from: classes.dex */
public class CarouselLayoutManager extends h1 implements Carousel {
    private static final String TAG = "CarouselLayoutManager";
    private CarouselStrategy carouselStrategy;
    private KeylineState currentKeylineState;
    private int horizontalScrollOffset;
    private KeylineStateList keylineStateList;
    private int maxHorizontalScroll;
    private int minHorizontalScroll;
    private boolean isDebuggingEnabled = false;
    private final DebugItemDecoration debugItemDecoration = new DebugItemDecoration();
    private int currentFillStartPosition = 0;

    public static final class ChildCalculations {
        View child;
        float locOffset;
        KeylineRange range;

        public ChildCalculations(View view, float f2, KeylineRange keylineRange) {
            this.child = view;
            this.locOffset = f2;
            this.range = keylineRange;
        }
    }

    public static class DebugItemDecoration extends d1 {
        private List<KeylineState.Keyline> keylines;
        private final Paint linePaint;

        public DebugItemDecoration() {
            Paint paint = new Paint();
            this.linePaint = paint;
            this.keylines = Collections.unmodifiableList(new ArrayList());
            paint.setStrokeWidth(5.0f);
            paint.setColor(-65281);
        }

        @Override // androidx.recyclerview.widget.d1
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, w1 w1Var) {
            super.onDrawOver(canvas, recyclerView, w1Var);
            this.linePaint.setStrokeWidth(recyclerView.getResources().getDimension(R.dimen.m3_carousel_debug_keyline_width));
            for (KeylineState.Keyline keyline : this.keylines) {
                this.linePaint.setColor(d.b(-65281, -16776961, keyline.mask));
                canvas.drawLine(keyline.locOffset, ((CarouselLayoutManager) recyclerView.getLayoutManager()).getParentTop(), keyline.locOffset, ((CarouselLayoutManager) recyclerView.getLayoutManager()).getParentBottom(), this.linePaint);
            }
        }

        public void setKeylines(List<KeylineState.Keyline> list) {
            this.keylines = Collections.unmodifiableList(list);
        }
    }

    public static class KeylineRange {
        final KeylineState.Keyline left;
        final KeylineState.Keyline right;

        public KeylineRange(KeylineState.Keyline keyline, KeylineState.Keyline keyline2) {
            if (keyline.loc > keyline2.loc) {
                throw new IllegalArgumentException();
            }
            this.left = keyline;
            this.right = keyline2;
        }
    }

    public CarouselLayoutManager() {
        setCarouselStrategy(new MultiBrowseCarouselStrategy());
    }

    private void addAndLayoutView(View view, int i2, float f2) {
        float itemSize = this.currentKeylineState.getItemSize() / 2.0f;
        addView(view, i2);
        layoutDecoratedWithMargins(view, (int) (f2 - itemSize), getParentTop(), (int) (f2 + itemSize), getParentBottom());
    }

    private int addEnd(int i2, int i3) {
        return isLayoutRtl() ? i2 - i3 : i2 + i3;
    }

    private int addStart(int i2, int i3) {
        return isLayoutRtl() ? i2 + i3 : i2 - i3;
    }

    private void addViewsEnd(p1 p1Var, w1 w1Var, int i2) {
        int iCalculateChildStartForFill = calculateChildStartForFill(i2);
        while (i2 < w1Var.b()) {
            ChildCalculations childCalculationsMakeChildCalculations = makeChildCalculations(p1Var, iCalculateChildStartForFill, i2);
            if (isLocOffsetOutOfFillBoundsEnd(childCalculationsMakeChildCalculations.locOffset, childCalculationsMakeChildCalculations.range)) {
                return;
            }
            iCalculateChildStartForFill = addEnd(iCalculateChildStartForFill, (int) this.currentKeylineState.getItemSize());
            if (!isLocOffsetOutOfFillBoundsStart(childCalculationsMakeChildCalculations.locOffset, childCalculationsMakeChildCalculations.range)) {
                addAndLayoutView(childCalculationsMakeChildCalculations.child, -1, childCalculationsMakeChildCalculations.locOffset);
            }
            i2++;
        }
    }

    private void addViewsStart(p1 p1Var, int i2) {
        int iCalculateChildStartForFill = calculateChildStartForFill(i2);
        while (i2 >= 0) {
            ChildCalculations childCalculationsMakeChildCalculations = makeChildCalculations(p1Var, iCalculateChildStartForFill, i2);
            if (isLocOffsetOutOfFillBoundsStart(childCalculationsMakeChildCalculations.locOffset, childCalculationsMakeChildCalculations.range)) {
                return;
            }
            iCalculateChildStartForFill = addStart(iCalculateChildStartForFill, (int) this.currentKeylineState.getItemSize());
            if (!isLocOffsetOutOfFillBoundsEnd(childCalculationsMakeChildCalculations.locOffset, childCalculationsMakeChildCalculations.range)) {
                addAndLayoutView(childCalculationsMakeChildCalculations.child, 0, childCalculationsMakeChildCalculations.locOffset);
            }
            i2--;
        }
    }

    private float calculateChildOffsetCenterForLocation(View view, float f2, KeylineRange keylineRange) {
        KeylineState.Keyline keyline = keylineRange.left;
        float f3 = keyline.locOffset;
        KeylineState.Keyline keyline2 = keylineRange.right;
        float fLerp = AnimationUtils.lerp(f3, keyline2.locOffset, keyline.loc, keyline2.loc, f2);
        if (keylineRange.right != this.currentKeylineState.getFirstKeyline() && keylineRange.left != this.currentKeylineState.getLastKeyline()) {
            return fLerp;
        }
        i1 i1Var = (i1) view.getLayoutParams();
        float itemSize = (((ViewGroup.MarginLayoutParams) i1Var).rightMargin + ((ViewGroup.MarginLayoutParams) i1Var).leftMargin) / this.currentKeylineState.getItemSize();
        KeylineState.Keyline keyline3 = keylineRange.right;
        return fLerp + (((1.0f - keyline3.mask) + itemSize) * (f2 - keyline3.loc));
    }

    private int calculateChildStartForFill(int i2) {
        return addEnd(getParentStart() - this.horizontalScrollOffset, (int) (this.currentKeylineState.getItemSize() * i2));
    }

    private int calculateEndHorizontalScroll(w1 w1Var, KeylineStateList keylineStateList) {
        boolean zIsLayoutRtl = isLayoutRtl();
        KeylineState leftState = zIsLayoutRtl ? keylineStateList.getLeftState() : keylineStateList.getRightState();
        KeylineState.Keyline firstFocalKeyline = zIsLayoutRtl ? leftState.getFirstFocalKeyline() : leftState.getLastFocalKeyline();
        float fB = (((w1Var.b() - 1) * leftState.getItemSize()) + getPaddingEnd()) * (zIsLayoutRtl ? -1.0f : 1.0f);
        float parentStart = firstFocalKeyline.loc - getParentStart();
        float parentEnd = getParentEnd() - firstFocalKeyline.loc;
        if (Math.abs(parentStart) > Math.abs(fB)) {
            return 0;
        }
        return (int) ((fB - parentStart) + parentEnd);
    }

    private static int calculateShouldHorizontallyScrollBy(int i2, int i3, int i4, int i5) {
        int i6 = i3 + i2;
        return i6 < i4 ? i4 - i3 : i6 > i5 ? i5 - i3 : i2;
    }

    private int calculateStartHorizontalScroll(KeylineStateList keylineStateList) {
        boolean zIsLayoutRtl = isLayoutRtl();
        KeylineState rightState = zIsLayoutRtl ? keylineStateList.getRightState() : keylineStateList.getLeftState();
        return (int) (((getPaddingStart() * (zIsLayoutRtl ? 1 : -1)) + getParentStart()) - addStart((int) (zIsLayoutRtl ? rightState.getLastFocalKeyline() : rightState.getFirstFocalKeyline()).loc, (int) (rightState.getItemSize() / 2.0f)));
    }

    private void fill(p1 p1Var, w1 w1Var) {
        removeAndRecycleOutOfBoundsViews(p1Var);
        if (getChildCount() == 0) {
            addViewsStart(p1Var, this.currentFillStartPosition - 1);
            addViewsEnd(p1Var, w1Var, this.currentFillStartPosition);
        } else {
            int position = getPosition(getChildAt(0));
            int position2 = getPosition(getChildAt(getChildCount() - 1));
            addViewsStart(p1Var, position - 1);
            addViewsEnd(p1Var, w1Var, position2 + 1);
        }
        validateChildOrderIfDebugging();
    }

    private float getDecoratedCenterXWithMargins(View view) {
        super.getDecoratedBoundsWithMargins(view, new Rect());
        return r0.centerX();
    }

    private float getMaskedItemSizeForLocOffset(float f2, KeylineRange keylineRange) {
        KeylineState.Keyline keyline = keylineRange.left;
        float f3 = keyline.maskedItemSize;
        KeylineState.Keyline keyline2 = keylineRange.right;
        return AnimationUtils.lerp(f3, keyline2.maskedItemSize, keyline.locOffset, keyline2.locOffset, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getParentBottom() {
        return getHeight() - getPaddingBottom();
    }

    private int getParentEnd() {
        if (isLayoutRtl()) {
            return 0;
        }
        return getWidth();
    }

    private int getParentStart() {
        if (isLayoutRtl()) {
            return getWidth();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getParentTop() {
        return getPaddingTop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getScrollOffsetForPosition(KeylineState keylineState, int i2) {
        if (isLayoutRtl()) {
            return (int) (((getContainerWidth() - keylineState.getLastFocalKeyline().loc) - (i2 * keylineState.getItemSize())) - (keylineState.getItemSize() / 2.0f));
        }
        return (int) ((keylineState.getItemSize() / 2.0f) + ((i2 * keylineState.getItemSize()) - keylineState.getFirstFocalKeyline().loc));
    }

    private static KeylineRange getSurroundingKeylineRange(List<KeylineState.Keyline> list, float f2, boolean z2) {
        float f3 = Float.MAX_VALUE;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        float f4 = -3.4028235E38f;
        float f5 = Float.MAX_VALUE;
        float f6 = Float.MAX_VALUE;
        for (int i6 = 0; i6 < list.size(); i6++) {
            KeylineState.Keyline keyline = list.get(i6);
            float f7 = z2 ? keyline.locOffset : keyline.loc;
            float fAbs = Math.abs(f7 - f2);
            if (f7 <= f2 && fAbs <= f3) {
                i2 = i6;
                f3 = fAbs;
            }
            if (f7 > f2 && fAbs <= f5) {
                i4 = i6;
                f5 = fAbs;
            }
            if (f7 <= f6) {
                i3 = i6;
                f6 = f7;
            }
            if (f7 > f4) {
                i5 = i6;
                f4 = f7;
            }
        }
        if (i2 == -1) {
            i2 = i3;
        }
        if (i4 == -1) {
            i4 = i5;
        }
        return new KeylineRange(list.get(i2), list.get(i4));
    }

    private boolean isLayoutRtl() {
        return getLayoutDirection() == 1;
    }

    private boolean isLocOffsetOutOfFillBoundsEnd(float f2, KeylineRange keylineRange) {
        int iAddStart = addStart((int) f2, (int) (getMaskedItemSizeForLocOffset(f2, keylineRange) / 2.0f));
        if (isLayoutRtl()) {
            if (iAddStart >= 0) {
                return false;
            }
        } else if (iAddStart <= getContainerWidth()) {
            return false;
        }
        return true;
    }

    private boolean isLocOffsetOutOfFillBoundsStart(float f2, KeylineRange keylineRange) {
        int iAddEnd = addEnd((int) f2, (int) (getMaskedItemSizeForLocOffset(f2, keylineRange) / 2.0f));
        if (isLayoutRtl()) {
            if (iAddEnd <= getContainerWidth()) {
                return false;
            }
        } else if (iAddEnd >= 0) {
            return false;
        }
        return true;
    }

    private void logChildrenIfDebugging() {
        if (this.isDebuggingEnabled && Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "internal representation of views on the screen");
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                Log.d(TAG, "item position " + getPosition(childAt) + ", center:" + getDecoratedCenterXWithMargins(childAt) + ", child index:" + i2);
            }
            Log.d(TAG, "==============");
        }
    }

    private ChildCalculations makeChildCalculations(p1 p1Var, float f2, int i2) {
        float itemSize = this.currentKeylineState.getItemSize() / 2.0f;
        View view = p1Var.j(i2, Long.MAX_VALUE).itemView;
        measureChildWithMargins(view, 0, 0);
        float fAddEnd = addEnd((int) f2, (int) itemSize);
        KeylineRange surroundingKeylineRange = getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), fAddEnd, false);
        float fCalculateChildOffsetCenterForLocation = calculateChildOffsetCenterForLocation(view, fAddEnd, surroundingKeylineRange);
        updateChildMaskForLocation(view, fAddEnd, surroundingKeylineRange);
        return new ChildCalculations(view, fCalculateChildOffsetCenterForLocation, surroundingKeylineRange);
    }

    private void offsetChildLeftAndRight(View view, float f2, float f3, Rect rect) {
        float fAddEnd = addEnd((int) f2, (int) f3);
        KeylineRange surroundingKeylineRange = getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), fAddEnd, false);
        float fCalculateChildOffsetCenterForLocation = calculateChildOffsetCenterForLocation(view, fAddEnd, surroundingKeylineRange);
        updateChildMaskForLocation(view, fAddEnd, surroundingKeylineRange);
        super.getDecoratedBoundsWithMargins(view, rect);
        view.offsetLeftAndRight((int) (fCalculateChildOffsetCenterForLocation - (rect.left + f3)));
    }

    private void removeAndRecycleOutOfBoundsViews(p1 p1Var) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            float decoratedCenterXWithMargins = getDecoratedCenterXWithMargins(childAt);
            if (!isLocOffsetOutOfFillBoundsStart(decoratedCenterXWithMargins, getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), decoratedCenterXWithMargins, true))) {
                break;
            } else {
                removeAndRecycleView(childAt, p1Var);
            }
        }
        while (getChildCount() - 1 >= 0) {
            View childAt2 = getChildAt(getChildCount() - 1);
            float decoratedCenterXWithMargins2 = getDecoratedCenterXWithMargins(childAt2);
            if (!isLocOffsetOutOfFillBoundsEnd(decoratedCenterXWithMargins2, getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), decoratedCenterXWithMargins2, true))) {
                return;
            } else {
                removeAndRecycleView(childAt2, p1Var);
            }
        }
    }

    private int scrollBy(int i2, p1 p1Var, w1 w1Var) {
        if (getChildCount() == 0 || i2 == 0) {
            return 0;
        }
        int iCalculateShouldHorizontallyScrollBy = calculateShouldHorizontallyScrollBy(i2, this.horizontalScrollOffset, this.minHorizontalScroll, this.maxHorizontalScroll);
        this.horizontalScrollOffset += iCalculateShouldHorizontallyScrollBy;
        updateCurrentKeylineStateForScrollOffset();
        float itemSize = this.currentKeylineState.getItemSize() / 2.0f;
        int iCalculateChildStartForFill = calculateChildStartForFill(getPosition(getChildAt(0)));
        Rect rect = new Rect();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            offsetChildLeftAndRight(getChildAt(i3), iCalculateChildStartForFill, itemSize, rect);
            iCalculateChildStartForFill = addEnd(iCalculateChildStartForFill, (int) this.currentKeylineState.getItemSize());
        }
        fill(p1Var, w1Var);
        return iCalculateShouldHorizontallyScrollBy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateChildMaskForLocation(View view, float f2, KeylineRange keylineRange) {
        if (view instanceof Maskable) {
            KeylineState.Keyline keyline = keylineRange.left;
            float f3 = keyline.mask;
            KeylineState.Keyline keyline2 = keylineRange.right;
            ((Maskable) view).setMaskXPercentage(AnimationUtils.lerp(f3, keyline2.mask, keyline.loc, keyline2.loc, f2));
        }
    }

    private void updateCurrentKeylineStateForScrollOffset() {
        int i2 = this.maxHorizontalScroll;
        int i3 = this.minHorizontalScroll;
        if (i2 <= i3) {
            this.currentKeylineState = isLayoutRtl() ? this.keylineStateList.getRightState() : this.keylineStateList.getLeftState();
        } else {
            this.currentKeylineState = this.keylineStateList.getShiftedState(this.horizontalScrollOffset, i3, i2);
        }
        this.debugItemDecoration.setKeylines(this.currentKeylineState.getKeylines());
    }

    private void validateChildOrderIfDebugging() {
        if (!this.isDebuggingEnabled || getChildCount() < 1) {
            return;
        }
        int i2 = 0;
        while (i2 < getChildCount() - 1) {
            int position = getPosition(getChildAt(i2));
            int i3 = i2 + 1;
            int position2 = getPosition(getChildAt(i3));
            if (position > position2) {
                logChildrenIfDebugging();
                throw new IllegalStateException("Detected invalid child order. Child at index [" + i2 + "] had adapter position [" + position + "] and child at index [" + i3 + "] had adapter position [" + position2 + "].");
            }
            i2 = i3;
        }
    }

    @Override // androidx.recyclerview.widget.h1
    public boolean canScrollHorizontally() {
        return true;
    }

    @Override // androidx.recyclerview.widget.h1
    public int computeHorizontalScrollExtent(w1 w1Var) {
        return (int) this.keylineStateList.getDefaultState().getItemSize();
    }

    @Override // androidx.recyclerview.widget.h1
    public int computeHorizontalScrollOffset(w1 w1Var) {
        return this.horizontalScrollOffset;
    }

    @Override // androidx.recyclerview.widget.h1
    public int computeHorizontalScrollRange(w1 w1Var) {
        return this.maxHorizontalScroll - this.minHorizontalScroll;
    }

    @Override // androidx.recyclerview.widget.h1
    public i1 generateDefaultLayoutParams() {
        return new i1(-2, -2);
    }

    @Override // com.google.android.material.carousel.Carousel
    public int getContainerWidth() {
        return getWidth();
    }

    @Override // androidx.recyclerview.widget.h1
    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        super.getDecoratedBoundsWithMargins(view, rect);
        float fCenterX = rect.centerX();
        float fWidth = (rect.width() - getMaskedItemSizeForLocOffset(fCenterX, getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), fCenterX, true))) / 2.0f;
        rect.set((int) (rect.left + fWidth), rect.top, (int) (rect.right - fWidth), rect.bottom);
    }

    @Override // androidx.recyclerview.widget.h1
    public void measureChildWithMargins(View view, int i2, int i3) {
        if (!(view instanceof Maskable)) {
            throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
        }
        i1 i1Var = (i1) view.getLayoutParams();
        Rect rect = new Rect();
        calculateItemDecorationsForChild(view, rect);
        int i4 = rect.left + rect.right + i2;
        int i5 = rect.top + rect.bottom + i3;
        KeylineStateList keylineStateList = this.keylineStateList;
        view.measure(h1.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) i1Var).leftMargin + ((ViewGroup.MarginLayoutParams) i1Var).rightMargin + i4, (int) (keylineStateList != null ? keylineStateList.getDefaultState().getItemSize() : ((ViewGroup.MarginLayoutParams) i1Var).width), canScrollHorizontally()), h1.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + ((ViewGroup.MarginLayoutParams) i1Var).topMargin + ((ViewGroup.MarginLayoutParams) i1Var).bottomMargin + i5, ((ViewGroup.MarginLayoutParams) i1Var).height, canScrollVertically()));
    }

    @Override // androidx.recyclerview.widget.h1
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(getPosition(getChildAt(0)));
            accessibilityEvent.setToIndex(getPosition(getChildAt(getChildCount() - 1)));
        }
    }

    @Override // androidx.recyclerview.widget.h1
    public void onLayoutChildren(p1 p1Var, w1 w1Var) {
        if (w1Var.b() <= 0) {
            removeAndRecycleAllViews(p1Var);
            this.currentFillStartPosition = 0;
            return;
        }
        boolean zIsLayoutRtl = isLayoutRtl();
        boolean z2 = this.keylineStateList == null;
        if (z2) {
            View view = p1Var.j(0, Long.MAX_VALUE).itemView;
            measureChildWithMargins(view, 0, 0);
            KeylineState keylineStateOnFirstChildMeasuredWithMargins = this.carouselStrategy.onFirstChildMeasuredWithMargins(this, view);
            if (zIsLayoutRtl) {
                keylineStateOnFirstChildMeasuredWithMargins = KeylineState.reverse(keylineStateOnFirstChildMeasuredWithMargins);
            }
            this.keylineStateList = KeylineStateList.from(this, keylineStateOnFirstChildMeasuredWithMargins);
        }
        int iCalculateStartHorizontalScroll = calculateStartHorizontalScroll(this.keylineStateList);
        int iCalculateEndHorizontalScroll = calculateEndHorizontalScroll(w1Var, this.keylineStateList);
        int i2 = zIsLayoutRtl ? iCalculateEndHorizontalScroll : iCalculateStartHorizontalScroll;
        this.minHorizontalScroll = i2;
        if (zIsLayoutRtl) {
            iCalculateEndHorizontalScroll = iCalculateStartHorizontalScroll;
        }
        this.maxHorizontalScroll = iCalculateEndHorizontalScroll;
        if (z2) {
            this.horizontalScrollOffset = iCalculateStartHorizontalScroll;
        } else {
            int i3 = this.horizontalScrollOffset;
            this.horizontalScrollOffset = i3 + calculateShouldHorizontallyScrollBy(0, i3, i2, iCalculateEndHorizontalScroll);
        }
        this.currentFillStartPosition = g.x(this.currentFillStartPosition, 0, w1Var.b());
        updateCurrentKeylineStateForScrollOffset();
        detachAndScrapAttachedViews(p1Var);
        fill(p1Var, w1Var);
    }

    @Override // androidx.recyclerview.widget.h1
    public void onLayoutCompleted(w1 w1Var) {
        if (getChildCount() == 0) {
            this.currentFillStartPosition = 0;
        } else {
            this.currentFillStartPosition = getPosition(getChildAt(0));
        }
        validateChildOrderIfDebugging();
    }

    @Override // androidx.recyclerview.widget.h1
    public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z2, boolean z3) {
        KeylineStateList keylineStateList = this.keylineStateList;
        if (keylineStateList == null) {
            return false;
        }
        int scrollOffsetForPosition = getScrollOffsetForPosition(keylineStateList.getDefaultState(), getPosition(view)) - this.horizontalScrollOffset;
        if (z3 || scrollOffsetForPosition == 0) {
            return false;
        }
        recyclerView.scrollBy(scrollOffsetForPosition, 0);
        return true;
    }

    @Override // androidx.recyclerview.widget.h1
    public int scrollHorizontallyBy(int i2, p1 p1Var, w1 w1Var) {
        if (canScrollHorizontally()) {
            return scrollBy(i2, p1Var, w1Var);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.h1
    public void scrollToPosition(int i2) {
        KeylineStateList keylineStateList = this.keylineStateList;
        if (keylineStateList == null) {
            return;
        }
        this.horizontalScrollOffset = getScrollOffsetForPosition(keylineStateList.getDefaultState(), i2);
        this.currentFillStartPosition = g.x(i2, 0, Math.max(0, getItemCount() - 1));
        updateCurrentKeylineStateForScrollOffset();
        requestLayout();
    }

    public void setCarouselStrategy(CarouselStrategy carouselStrategy) {
        this.carouselStrategy = carouselStrategy;
        this.keylineStateList = null;
        requestLayout();
    }

    public void setDebuggingEnabled(RecyclerView recyclerView, boolean z2) {
        this.isDebuggingEnabled = z2;
        recyclerView.removeItemDecoration(this.debugItemDecoration);
        if (z2) {
            recyclerView.addItemDecoration(this.debugItemDecoration);
        }
        recyclerView.invalidateItemDecorations();
    }

    @Override // androidx.recyclerview.widget.h1
    public void smoothScrollToPosition(RecyclerView recyclerView, w1 w1Var, int i2) {
        k0 k0Var = new k0(recyclerView.getContext()) { // from class: com.google.android.material.carousel.CarouselLayoutManager.1
            @Override // androidx.recyclerview.widget.k0
            public int calculateDxToMakeVisible(View view, int i3) {
                CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
                return (int) (CarouselLayoutManager.this.horizontalScrollOffset - carouselLayoutManager.getScrollOffsetForPosition(carouselLayoutManager.keylineStateList.getDefaultState(), CarouselLayoutManager.this.getPosition(view)));
            }

            @Override // androidx.recyclerview.widget.v1
            public PointF computeScrollVectorForPosition(int i3) {
                if (CarouselLayoutManager.this.keylineStateList == null) {
                    return null;
                }
                CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
                return new PointF(carouselLayoutManager.getScrollOffsetForPosition(carouselLayoutManager.keylineStateList.getDefaultState(), i3) - CarouselLayoutManager.this.horizontalScrollOffset, 0.0f);
            }
        };
        k0Var.setTargetPosition(i2);
        startSmoothScroll(k0Var);
    }
}
