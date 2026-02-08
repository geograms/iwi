package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class i extends n0 {
    public i(int i2) {
        setMode(i2);
    }

    @Override // androidx.transition.n0, androidx.transition.v
    public final void captureStartValues(c0 c0Var) {
        super.captureStartValues(c0Var);
        HashMap map = c0Var.f1053a;
        View view = c0Var.f1054b;
        c cVar = e0.f1062a;
        map.put("android:fade:transitionAlpha", Float.valueOf(view.getTransitionAlpha()));
    }

    public final ObjectAnimator g(float f2, float f3, View view) {
        if (f2 == f3) {
            return null;
        }
        c cVar = e0.f1062a;
        view.setTransitionAlpha(f2);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, e0.f1062a, f3);
        objectAnimatorOfFloat.addListener(new androidx.recyclerview.widget.x(view));
        addListener(new h(0, this, view));
        return objectAnimatorOfFloat;
    }

    @Override // androidx.transition.n0
    public final Animator onAppear(ViewGroup viewGroup, View view, c0 c0Var, c0 c0Var2) {
        Float f2;
        float fFloatValue = (c0Var == null || (f2 = (Float) c0Var.f1053a.get("android:fade:transitionAlpha")) == null) ? 0.0f : f2.floatValue();
        return g(fFloatValue != 1.0f ? fFloatValue : 0.0f, 1.0f, view);
    }

    @Override // androidx.transition.n0
    public final Animator onDisappear(ViewGroup viewGroup, View view, c0 c0Var, c0 c0Var2) {
        Float f2;
        c cVar = e0.f1062a;
        return g((c0Var == null || (f2 = (Float) c0Var.f1053a.get("android:fade:transitionAlpha")) == null) ? 1.0f : f2.floatValue(), 0.0f, view);
    }
}
