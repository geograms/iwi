package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.customview.widget.h;

/* loaded from: classes.dex */
final class RightSheetDelegate extends SheetDelegate {
    final SideSheetBehavior<? extends View> sheetBehavior;

    public RightSheetDelegate(SideSheetBehavior<? extends View> sideSheetBehavior) {
        this.sheetBehavior = sideSheetBehavior;
    }

    private boolean isReleasedCloseToOriginEdge(View view) {
        return view.getLeft() > (getHiddenOffset() - getExpandedOffset()) / 2;
    }

    private boolean isSwipeSignificant(float f2, float f3) {
        return SheetUtils.isSwipeMostlyHorizontal(f2, f3) && f3 > ((float) this.sheetBehavior.getSignificantVelocityThreshold());
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public int calculateInnerMargin(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public float calculateSlideOffset(int i2) {
        float hiddenOffset = getHiddenOffset();
        return (hiddenOffset - i2) / (hiddenOffset - getExpandedOffset());
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public int calculateTargetStateOnViewReleased(View view, float f2, float f3) {
        if (f2 < 0.0f) {
            return 3;
        }
        if (shouldHide(view, f2)) {
            if (!isSwipeSignificant(f2, f3) && !isReleasedCloseToOriginEdge(view)) {
                return 3;
            }
        } else if (f2 == 0.0f || !SheetUtils.isSwipeMostlyHorizontal(f2, f3)) {
            int left = view.getLeft();
            if (Math.abs(left - getExpandedOffset()) < Math.abs(left - getHiddenOffset())) {
                return 3;
            }
        }
        return 5;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public int getExpandedOffset() {
        return Math.max(0, (getHiddenOffset() - this.sheetBehavior.getChildWidth()) - this.sheetBehavior.getInnerMargin());
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public int getHiddenOffset() {
        return this.sheetBehavior.getParentWidth();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public <V extends View> int getOuterEdge(V v2) {
        return v2.getLeft() - this.sheetBehavior.getInnerMargin();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public int getSheetEdge() {
        return 0;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public boolean isSettling(View view, int i2, boolean z2) {
        int outerEdgeOffsetForState = this.sheetBehavior.getOuterEdgeOffsetForState(i2);
        h viewDragHelper = this.sheetBehavior.getViewDragHelper();
        return viewDragHelper != null && (!z2 ? !viewDragHelper.t(view, outerEdgeOffsetForState, view.getTop()) : !viewDragHelper.r(outerEdgeOffsetForState, view.getTop()));
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public boolean shouldHide(View view, float f2) {
        return Math.abs((this.sheetBehavior.getHideFriction() * f2) + ((float) view.getRight())) > this.sheetBehavior.getHideThreshold();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public void updateCoplanarSiblingLayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3) {
        int parentWidth = this.sheetBehavior.getParentWidth();
        if (i2 <= parentWidth) {
            marginLayoutParams.rightMargin = parentWidth - i2;
        }
    }
}
