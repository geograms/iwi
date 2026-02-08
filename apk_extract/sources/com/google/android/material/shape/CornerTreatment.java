package com.google.android.material.shape;

import android.graphics.RectF;

/* loaded from: classes.dex */
public class CornerTreatment {
    @Deprecated
    public void getCornerPath(float f2, float f3, ShapePath shapePath) {
    }

    public void getCornerPath(ShapePath shapePath, float f2, float f3, float f4) {
        getCornerPath(f2, f3, shapePath);
    }

    public void getCornerPath(ShapePath shapePath, float f2, float f3, RectF rectF, CornerSize cornerSize) {
        getCornerPath(shapePath, f2, f3, cornerSize.getCornerSize(rectF));
    }
}
