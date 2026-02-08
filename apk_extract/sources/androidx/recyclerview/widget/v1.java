package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.util.Log;
import android.view.View;

/* loaded from: classes.dex */
public abstract class v1 {
    private h1 mLayoutManager;
    private boolean mPendingInitialRun;
    private RecyclerView mRecyclerView;
    private final t1 mRecyclingAction;
    private boolean mRunning;
    private boolean mStarted;
    private int mTargetPosition = -1;
    private View mTargetView;

    public v1() {
        t1 t1Var = new t1();
        t1Var.f967d = -1;
        t1Var.f969f = false;
        t1Var.f970g = 0;
        t1Var.f964a = 0;
        t1Var.f965b = 0;
        t1Var.f966c = Integer.MIN_VALUE;
        t1Var.f968e = null;
        this.mRecyclingAction = t1Var;
    }

    public PointF computeScrollVectorForPosition(int i2) {
        Object layoutManager = getLayoutManager();
        if (layoutManager instanceof u1) {
            return ((u1) layoutManager).computeScrollVectorForPosition(i2);
        }
        Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + u1.class.getCanonicalName());
        return null;
    }

    public View findViewByPosition(int i2) {
        return this.mRecyclerView.mLayout.findViewByPosition(i2);
    }

    public int getChildCount() {
        return this.mRecyclerView.mLayout.getChildCount();
    }

    public int getChildPosition(View view) {
        return this.mRecyclerView.getChildLayoutPosition(view);
    }

    public h1 getLayoutManager() {
        return this.mLayoutManager;
    }

    public int getTargetPosition() {
        return this.mTargetPosition;
    }

    @Deprecated
    public void instantScrollToPosition(int i2) {
        this.mRecyclerView.scrollToPosition(i2);
    }

    public boolean isPendingInitialRun() {
        return this.mPendingInitialRun;
    }

    public boolean isRunning() {
        return this.mRunning;
    }

    public void normalize(PointF pointF) {
        float f2 = pointF.x;
        float f3 = pointF.y;
        float fSqrt = (float) Math.sqrt((f3 * f3) + (f2 * f2));
        pointF.x /= fSqrt;
        pointF.y /= fSqrt;
    }

    public void onAnimation(int i2, int i3) {
        PointF pointFComputeScrollVectorForPosition;
        RecyclerView recyclerView = this.mRecyclerView;
        if (this.mTargetPosition == -1 || recyclerView == null) {
            stop();
        }
        if (this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null && (pointFComputeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) != null) {
            float f2 = pointFComputeScrollVectorForPosition.x;
            if (f2 != 0.0f || pointFComputeScrollVectorForPosition.y != 0.0f) {
                recyclerView.scrollStep((int) Math.signum(f2), (int) Math.signum(pointFComputeScrollVectorForPosition.y), null);
            }
        }
        this.mPendingInitialRun = false;
        View view = this.mTargetView;
        if (view != null) {
            if (getChildPosition(view) == this.mTargetPosition) {
                onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
                this.mRecyclingAction.a(recyclerView);
                stop();
            } else {
                Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                this.mTargetView = null;
            }
        }
        if (this.mRunning) {
            onSeekTargetStep(i2, i3, recyclerView.mState, this.mRecyclingAction);
            t1 t1Var = this.mRecyclingAction;
            boolean z2 = t1Var.f967d >= 0;
            t1Var.a(recyclerView);
            if (z2 && this.mRunning) {
                this.mPendingInitialRun = true;
                recyclerView.mViewFlinger.a();
            }
        }
    }

    public void onChildAttachedToWindow(View view) {
        if (getChildPosition(view) == getTargetPosition()) {
            this.mTargetView = view;
        }
    }

    public abstract void onSeekTargetStep(int i2, int i3, w1 w1Var, t1 t1Var);

    public abstract void onStart();

    public abstract void onStop();

    public abstract void onTargetFound(View view, w1 w1Var, t1 t1Var);

    public void setTargetPosition(int i2) {
        this.mTargetPosition = i2;
    }

    public void start(RecyclerView recyclerView, h1 h1Var) {
        y1 y1Var = recyclerView.mViewFlinger;
        y1Var.f1000g.removeCallbacks(y1Var);
        y1Var.f996c.abortAnimation();
        if (this.mStarted) {
            Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
        }
        this.mRecyclerView = recyclerView;
        this.mLayoutManager = h1Var;
        int i2 = this.mTargetPosition;
        if (i2 == -1) {
            throw new IllegalArgumentException("Invalid target position");
        }
        recyclerView.mState.f976a = i2;
        this.mRunning = true;
        this.mPendingInitialRun = true;
        this.mTargetView = findViewByPosition(getTargetPosition());
        onStart();
        this.mRecyclerView.mViewFlinger.a();
        this.mStarted = true;
    }

    public final void stop() {
        if (this.mRunning) {
            this.mRunning = false;
            onStop();
            this.mRecyclerView.mState.f976a = -1;
            this.mTargetView = null;
            this.mTargetPosition = -1;
            this.mPendingInitialRun = false;
            this.mLayoutManager.onSmoothScrollerStopped(this);
            this.mLayoutManager = null;
            this.mRecyclerView = null;
        }
    }
}
