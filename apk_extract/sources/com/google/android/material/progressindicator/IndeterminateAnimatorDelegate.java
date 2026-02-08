package com.google.android.material.progressindicator;

import android.animation.Animator;
import androidx.vectordrawable.graphics.drawable.c;

/* loaded from: classes.dex */
abstract class IndeterminateAnimatorDelegate<T extends Animator> {
    protected IndeterminateDrawable drawable;
    protected final int[] segmentColors;
    protected final float[] segmentPositions;

    public IndeterminateAnimatorDelegate(int i2) {
        this.segmentPositions = new float[i2 * 2];
        this.segmentColors = new int[i2];
    }

    public abstract void cancelAnimatorImmediately();

    public float getFractionInRange(int i2, int i3, int i4) {
        return (i2 - i3) / i4;
    }

    public abstract void invalidateSpecValues();

    public abstract void registerAnimatorsCompleteCallback(c cVar);

    public void registerDrawable(IndeterminateDrawable indeterminateDrawable) {
        this.drawable = indeterminateDrawable;
    }

    public abstract void requestCancelAnimatorAfterCurrentCycle();

    public abstract void startAnimator();

    public abstract void unregisterAnimatorsCompleteCallback();
}
