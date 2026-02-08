package androidx.recyclerview.widget;

import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class y1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public int f994a;

    /* renamed from: b, reason: collision with root package name */
    public int f995b;

    /* renamed from: c, reason: collision with root package name */
    public OverScroller f996c;

    /* renamed from: d, reason: collision with root package name */
    public Interpolator f997d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f998e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f999f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f1000g;

    public y1(RecyclerView recyclerView) {
        this.f1000g = recyclerView;
        Interpolator interpolator = RecyclerView.sQuinticInterpolator;
        this.f997d = interpolator;
        this.f998e = false;
        this.f999f = false;
        this.f996c = new OverScroller(recyclerView.getContext(), interpolator);
    }

    public final void a() {
        if (this.f998e) {
            this.f999f = true;
            return;
        }
        RecyclerView recyclerView = this.f1000g;
        recyclerView.removeCallbacks(this);
        WeakHashMap weakHashMap = androidx.core.view.d1.f138a;
        androidx.core.view.m0.m(recyclerView, this);
    }

    public final void b(int i2, int i3, Interpolator interpolator, int i4) {
        int iRound;
        RecyclerView recyclerView = this.f1000g;
        if (i4 == Integer.MIN_VALUE) {
            int iAbs = Math.abs(i2);
            int iAbs2 = Math.abs(i3);
            boolean z2 = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt(0);
            int iSqrt2 = (int) Math.sqrt((i3 * i3) + (i2 * i2));
            int width = z2 ? recyclerView.getWidth() : recyclerView.getHeight();
            int i5 = width / 2;
            float f2 = width;
            float f3 = i5;
            float fSin = (((float) Math.sin((Math.min(1.0f, (iSqrt2 * 1.0f) / f2) - 0.5f) * 0.47123894f)) * f3) + f3;
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fSin / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z2) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f2) + 1.0f) * 300.0f);
            }
            i4 = Math.min(iRound, 2000);
        }
        int i6 = i4;
        if (interpolator == null) {
            interpolator = RecyclerView.sQuinticInterpolator;
        }
        if (this.f997d != interpolator) {
            this.f997d = interpolator;
            this.f996c = new OverScroller(recyclerView.getContext(), interpolator);
        }
        this.f995b = 0;
        this.f994a = 0;
        recyclerView.setScrollState(2);
        this.f996c.startScroll(0, 0, i2, i3, i6);
        a();
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2;
        int i3;
        int i4;
        int i5;
        RecyclerView recyclerView = this.f1000g;
        if (recyclerView.mLayout == null) {
            recyclerView.removeCallbacks(this);
            this.f996c.abortAnimation();
            return;
        }
        this.f999f = false;
        this.f998e = true;
        recyclerView.consumePendingUpdateOperations();
        OverScroller overScroller = this.f996c;
        if (overScroller.computeScrollOffset()) {
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int i6 = currX - this.f994a;
            int i7 = currY - this.f995b;
            this.f994a = currX;
            this.f995b = currY;
            int[] iArr = recyclerView.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            if (recyclerView.dispatchNestedPreScroll(i6, i7, iArr, null, 1)) {
                int[] iArr2 = recyclerView.mReusableIntPair;
                i6 -= iArr2[0];
                i7 -= iArr2[1];
            }
            if (recyclerView.getOverScrollMode() != 2) {
                recyclerView.considerReleasingGlowsOnScroll(i6, i7);
            }
            if (recyclerView.mAdapter != null) {
                int[] iArr3 = recyclerView.mReusableIntPair;
                iArr3[0] = 0;
                iArr3[1] = 0;
                recyclerView.scrollStep(i6, i7, iArr3);
                int[] iArr4 = recyclerView.mReusableIntPair;
                int i8 = iArr4[0];
                int i9 = iArr4[1];
                int i10 = i6 - i8;
                int i11 = i7 - i9;
                v1 v1Var = recyclerView.mLayout.mSmoothScroller;
                if (v1Var != null && !v1Var.isPendingInitialRun() && v1Var.isRunning()) {
                    int iB = recyclerView.mState.b();
                    if (iB == 0) {
                        v1Var.stop();
                    } else if (v1Var.getTargetPosition() >= iB) {
                        v1Var.setTargetPosition(iB - 1);
                        v1Var.onAnimation(i8, i9);
                    } else {
                        v1Var.onAnimation(i8, i9);
                    }
                }
                i4 = i9;
                i5 = i8;
                i2 = i10;
                i3 = i11;
            } else {
                i2 = i6;
                i3 = i7;
                i4 = 0;
                i5 = 0;
            }
            if (!recyclerView.mItemDecorations.isEmpty()) {
                recyclerView.invalidate();
            }
            int[] iArr5 = recyclerView.mReusableIntPair;
            iArr5[0] = 0;
            iArr5[1] = 0;
            recyclerView.dispatchNestedScroll(i5, i4, i2, i3, null, 1, iArr5);
            int[] iArr6 = recyclerView.mReusableIntPair;
            int i12 = i2 - iArr6[0];
            int i13 = i3 - iArr6[1];
            if (i5 != 0 || i4 != 0) {
                recyclerView.dispatchOnScrolled(i5, i4);
            }
            if (!recyclerView.awakenScrollBars()) {
                recyclerView.invalidate();
            }
            boolean z2 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i12 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i13 != 0));
            v1 v1Var2 = recyclerView.mLayout.mSmoothScroller;
            if ((v1Var2 == null || !v1Var2.isPendingInitialRun()) && z2) {
                if (recyclerView.getOverScrollMode() != 2) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    int i14 = i12 < 0 ? -currVelocity : i12 > 0 ? currVelocity : 0;
                    if (i13 < 0) {
                        currVelocity = -currVelocity;
                    } else if (i13 <= 0) {
                        currVelocity = 0;
                    }
                    recyclerView.absorbGlows(i14, currVelocity);
                }
                if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                    a0 a0Var = recyclerView.mPrefetchRegistry;
                    int[] iArr7 = a0Var.f726c;
                    if (iArr7 != null) {
                        Arrays.fill(iArr7, -1);
                    }
                    a0Var.f727d = 0;
                }
            } else {
                a();
                c0 c0Var = recyclerView.mGapWorker;
                if (c0Var != null) {
                    c0Var.a(recyclerView, i5, i4);
                }
            }
        }
        v1 v1Var3 = recyclerView.mLayout.mSmoothScroller;
        if (v1Var3 != null && v1Var3.isPendingInitialRun()) {
            v1Var3.onAnimation(0, 0);
        }
        this.f998e = false;
        if (!this.f999f) {
            recyclerView.setScrollState(0);
            recyclerView.stopNestedScroll(1);
        } else {
            recyclerView.removeCallbacks(this);
            WeakHashMap weakHashMap = androidx.core.view.d1.f138a;
            androidx.core.view.m0.m(recyclerView, this);
        }
    }
}
