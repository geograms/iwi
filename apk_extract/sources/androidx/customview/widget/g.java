package androidx.customview.widget;

import android.view.View;

/* loaded from: classes.dex */
public abstract class g {
    public abstract int clampViewPositionHorizontal(View view, int i2, int i3);

    public abstract int clampViewPositionVertical(View view, int i2, int i3);

    public int getOrderedChildIndex(int i2) {
        return i2;
    }

    public int getViewHorizontalDragRange(View view) {
        return 0;
    }

    public int getViewVerticalDragRange(View view) {
        return 0;
    }

    public void onEdgeDragStarted(int i2, int i3) {
    }

    public boolean onEdgeLock(int i2) {
        return false;
    }

    public void onEdgeTouched(int i2, int i3) {
    }

    public void onViewCaptured(View view, int i2) {
    }

    public abstract void onViewDragStateChanged(int i2);

    public abstract void onViewPositionChanged(View view, int i2, int i3, int i4, int i5);

    public abstract void onViewReleased(View view, float f2, float f3);

    public abstract boolean tryCaptureView(View view, int i2);
}
