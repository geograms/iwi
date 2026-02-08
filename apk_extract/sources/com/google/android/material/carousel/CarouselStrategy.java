package com.google.android.material.carousel;

import android.view.View;

/* loaded from: classes.dex */
public abstract class CarouselStrategy {
    public static float getChildMaskPercentage(float f2, float f3, float f4) {
        return 1.0f - ((f2 - f4) / (f3 - f4));
    }

    public abstract KeylineState onFirstChildMeasuredWithMargins(Carousel carousel, View view);
}
