package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.c0;
import androidx.transition.n0;

/* loaded from: classes.dex */
public final class Hold extends n0 {
    @Override // androidx.transition.n0
    public Animator onAppear(ViewGroup viewGroup, View view, c0 c0Var, c0 c0Var2) {
        return ValueAnimator.ofFloat(0.0f);
    }

    @Override // androidx.transition.n0
    public Animator onDisappear(ViewGroup viewGroup, View view, c0 c0Var, c0 c0Var2) {
        return ValueAnimator.ofFloat(0.0f);
    }
}
