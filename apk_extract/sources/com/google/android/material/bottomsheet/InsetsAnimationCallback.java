package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.core.view.b2;
import androidx.core.view.n2;
import androidx.core.view.r1;
import androidx.core.view.s1;
import com.google.android.material.animation.AnimationUtils;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class InsetsAnimationCallback extends s1 {
    private int startTranslationY;
    private int startY;
    private final int[] tmpLocation = new int[2];
    private final View view;

    public InsetsAnimationCallback(View view) {
        this.view = view;
    }

    @Override // androidx.core.view.s1
    public void onEnd(b2 b2Var) {
        this.view.setTranslationY(0.0f);
    }

    @Override // androidx.core.view.s1
    public void onPrepare(b2 b2Var) {
        this.view.getLocationOnScreen(this.tmpLocation);
        this.startY = this.tmpLocation[1];
    }

    @Override // androidx.core.view.s1
    public n2 onProgress(n2 n2Var, List<b2> list) {
        Iterator<b2> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if ((it.next().f133a.c() & 8) != 0) {
                this.view.setTranslationY(AnimationUtils.lerp(this.startTranslationY, 0, r0.f133a.b()));
                break;
            }
        }
        return n2Var;
    }

    @Override // androidx.core.view.s1
    public r1 onStart(b2 b2Var, r1 r1Var) {
        this.view.getLocationOnScreen(this.tmpLocation);
        int i2 = this.startY - this.tmpLocation[1];
        this.startTranslationY = i2;
        this.view.setTranslationY(i2);
        return r1Var;
    }
}
