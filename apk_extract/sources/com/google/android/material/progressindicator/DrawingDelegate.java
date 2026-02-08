package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

/* loaded from: classes.dex */
abstract class DrawingDelegate<S extends BaseProgressIndicatorSpec> {
    protected DrawableWithAnimatedVisibilityChange drawable;
    S spec;

    public DrawingDelegate(S s2) {
        this.spec = s2;
    }

    public abstract void adjustCanvas(Canvas canvas, Rect rect, float f2);

    public abstract void fillIndicator(Canvas canvas, Paint paint, float f2, float f3, int i2);

    public abstract void fillTrack(Canvas canvas, Paint paint);

    public abstract int getPreferredHeight();

    public abstract int getPreferredWidth();

    public void registerDrawable(DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange) {
        this.drawable = drawableWithAnimatedVisibilityChange;
    }

    public void validateSpecAndAdjustCanvas(Canvas canvas, Rect rect, float f2) {
        this.spec.validateSpec();
        adjustCanvas(canvas, rect, f2);
    }
}
