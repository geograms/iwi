package com.google.android.material.carousel;

import android.graphics.RectF;

/* loaded from: classes.dex */
interface Maskable {
    RectF getMaskRectF();

    float getMaskXPercentage();

    void setMaskXPercentage(float f2);

    void setOnMaskChangedListener(OnMaskChangedListener onMaskChangedListener);
}
