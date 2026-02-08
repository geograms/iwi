package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
abstract class SheetDelegate {
    public abstract int calculateInnerMargin(ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract float calculateSlideOffset(int i2);

    public abstract int calculateTargetStateOnViewReleased(View view, float f2, float f3);

    public abstract int getExpandedOffset();

    public abstract int getHiddenOffset();

    public abstract <V extends View> int getOuterEdge(V v2);

    public abstract int getSheetEdge();

    public abstract boolean isSettling(View view, int i2, boolean z2);

    public abstract boolean shouldHide(View view, float f2);

    public abstract void updateCoplanarSiblingLayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3);
}
