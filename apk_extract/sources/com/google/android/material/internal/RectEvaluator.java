package com.google.android.material.internal;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* loaded from: classes.dex */
public class RectEvaluator implements TypeEvaluator<Rect> {
    private final Rect rect;

    public RectEvaluator(Rect rect) {
        this.rect = rect;
    }

    @Override // android.animation.TypeEvaluator
    public Rect evaluate(float f2, Rect rect, Rect rect2) {
        this.rect.set(rect.left + ((int) ((rect2.left - r0) * f2)), rect.top + ((int) ((rect2.top - r1) * f2)), rect.right + ((int) ((rect2.right - r2) * f2)), rect.bottom + ((int) ((rect2.bottom - r6) * f2)));
        return this.rect;
    }
}
