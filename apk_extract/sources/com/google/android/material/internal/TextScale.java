package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.c0;
import androidx.transition.v;
import java.util.HashMap;

/* loaded from: classes.dex */
public class TextScale extends v {
    private static final String PROPNAME_SCALE = "android:textscale:scale";

    private void captureValues(c0 c0Var) {
        View view = c0Var.f1054b;
        if (view instanceof TextView) {
            c0Var.f1053a.put(PROPNAME_SCALE, Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // androidx.transition.v
    public void captureEndValues(c0 c0Var) {
        captureValues(c0Var);
    }

    @Override // androidx.transition.v
    public void captureStartValues(c0 c0Var) {
        captureValues(c0Var);
    }

    @Override // androidx.transition.v
    public Animator createAnimator(ViewGroup viewGroup, c0 c0Var, c0 c0Var2) {
        if (c0Var == null || c0Var2 == null || !(c0Var.f1054b instanceof TextView)) {
            return null;
        }
        View view = c0Var2.f1054b;
        if (!(view instanceof TextView)) {
            return null;
        }
        final TextView textView = (TextView) view;
        HashMap map = c0Var.f1053a;
        HashMap map2 = c0Var2.f1053a;
        float fFloatValue = map.get(PROPNAME_SCALE) != null ? ((Float) map.get(PROPNAME_SCALE)).floatValue() : 1.0f;
        float fFloatValue2 = map2.get(PROPNAME_SCALE) != null ? ((Float) map2.get(PROPNAME_SCALE)).floatValue() : 1.0f;
        if (fFloatValue == fFloatValue2) {
            return null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fFloatValue, fFloatValue2);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.internal.TextScale.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                textView.setScaleX(fFloatValue3);
                textView.setScaleY(fFloatValue3);
            }
        });
        return valueAnimatorOfFloat;
    }
}
