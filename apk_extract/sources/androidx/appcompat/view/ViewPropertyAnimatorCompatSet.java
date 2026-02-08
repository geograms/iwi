package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.l1;
import androidx.core.view.m1;
import androidx.core.view.n1;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ViewPropertyAnimatorCompatSet {
    private Interpolator mInterpolator;
    private boolean mIsStarted;
    m1 mListener;
    private long mDuration = -1;
    private final n1 mProxyListener = new n1() { // from class: androidx.appcompat.view.ViewPropertyAnimatorCompatSet.1
        private boolean mProxyStarted = false;
        private int mProxyEndCount = 0;

        @Override // androidx.core.view.m1
        public void onAnimationEnd(View view) {
            int i2 = this.mProxyEndCount + 1;
            this.mProxyEndCount = i2;
            if (i2 == ViewPropertyAnimatorCompatSet.this.mAnimators.size()) {
                m1 m1Var = ViewPropertyAnimatorCompatSet.this.mListener;
                if (m1Var != null) {
                    m1Var.onAnimationEnd(null);
                }
                onEnd();
            }
        }

        @Override // androidx.core.view.n1, androidx.core.view.m1
        public void onAnimationStart(View view) {
            if (this.mProxyStarted) {
                return;
            }
            this.mProxyStarted = true;
            m1 m1Var = ViewPropertyAnimatorCompatSet.this.mListener;
            if (m1Var != null) {
                m1Var.onAnimationStart(null);
            }
        }

        public void onEnd() {
            this.mProxyEndCount = 0;
            this.mProxyStarted = false;
            ViewPropertyAnimatorCompatSet.this.onAnimationsEnded();
        }
    };
    final ArrayList<l1> mAnimators = new ArrayList<>();

    public void cancel() {
        if (this.mIsStarted) {
            Iterator<l1> it = this.mAnimators.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.mIsStarted = false;
        }
    }

    public void onAnimationsEnded() {
        this.mIsStarted = false;
    }

    public ViewPropertyAnimatorCompatSet play(l1 l1Var) {
        if (!this.mIsStarted) {
            this.mAnimators.add(l1Var);
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet playSequentially(l1 l1Var, l1 l1Var2) {
        this.mAnimators.add(l1Var);
        View view = (View) l1Var.f184a.get();
        long duration = view != null ? view.animate().getDuration() : 0L;
        View view2 = (View) l1Var2.f184a.get();
        if (view2 != null) {
            view2.animate().setStartDelay(duration);
        }
        this.mAnimators.add(l1Var2);
        return this;
    }

    public ViewPropertyAnimatorCompatSet setDuration(long j2) {
        if (!this.mIsStarted) {
            this.mDuration = j2;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setInterpolator(Interpolator interpolator) {
        if (!this.mIsStarted) {
            this.mInterpolator = interpolator;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setListener(m1 m1Var) {
        if (!this.mIsStarted) {
            this.mListener = m1Var;
        }
        return this;
    }

    public void start() {
        View view;
        if (this.mIsStarted) {
            return;
        }
        Iterator<l1> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            l1 next = it.next();
            long j2 = this.mDuration;
            if (j2 >= 0) {
                next.c(j2);
            }
            Interpolator interpolator = this.mInterpolator;
            if (interpolator != null && (view = (View) next.f184a.get()) != null) {
                view.animate().setInterpolator(interpolator);
            }
            if (this.mListener != null) {
                next.d(this.mProxyListener);
            }
            View view2 = (View) next.f184a.get();
            if (view2 != null) {
                view2.animate().start();
            }
        }
        this.mIsStarted = true;
    }
}
