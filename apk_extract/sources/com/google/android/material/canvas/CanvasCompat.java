package com.google.android.material.canvas;

import android.graphics.Canvas;
import android.graphics.RectF;

/* loaded from: classes.dex */
public class CanvasCompat {

    public interface CanvasOperation {
        void run(Canvas canvas);
    }

    private CanvasCompat() {
    }

    public static int saveLayerAlpha(Canvas canvas, RectF rectF, int i2) {
        return canvas.saveLayerAlpha(rectF, i2);
    }

    public static int saveLayerAlpha(Canvas canvas, float f2, float f3, float f4, float f5, int i2) {
        return canvas.saveLayerAlpha(f2, f3, f4, f5, i2);
    }
}
