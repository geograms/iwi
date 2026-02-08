package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.OverScroller;
import androidx.core.view.d1;
import java.util.Arrays;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: x, reason: collision with root package name */
    public static final f f266x = new f(0);

    /* renamed from: a, reason: collision with root package name */
    public int f267a;

    /* renamed from: b, reason: collision with root package name */
    public int f268b;

    /* renamed from: d, reason: collision with root package name */
    public float[] f270d;

    /* renamed from: e, reason: collision with root package name */
    public float[] f271e;

    /* renamed from: f, reason: collision with root package name */
    public float[] f272f;

    /* renamed from: g, reason: collision with root package name */
    public float[] f273g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f274h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f275i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f276j;

    /* renamed from: k, reason: collision with root package name */
    public int f277k;

    /* renamed from: l, reason: collision with root package name */
    public VelocityTracker f278l;

    /* renamed from: m, reason: collision with root package name */
    public final float f279m;

    /* renamed from: n, reason: collision with root package name */
    public float f280n;

    /* renamed from: o, reason: collision with root package name */
    public int f281o;

    /* renamed from: p, reason: collision with root package name */
    public final int f282p;

    /* renamed from: q, reason: collision with root package name */
    public int f283q;

    /* renamed from: r, reason: collision with root package name */
    public final OverScroller f284r;

    /* renamed from: s, reason: collision with root package name */
    public final g f285s;

    /* renamed from: t, reason: collision with root package name */
    public View f286t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f287u;

    /* renamed from: v, reason: collision with root package name */
    public final ViewGroup f288v;

    /* renamed from: c, reason: collision with root package name */
    public int f269c = -1;

    /* renamed from: w, reason: collision with root package name */
    public final androidx.activity.d f289w = new androidx.activity.d(2, this);

    public h(Context context, ViewGroup viewGroup, g gVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (gVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f288v = viewGroup;
        this.f285s = gVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i2 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f282p = i2;
        this.f281o = i2;
        this.f268b = viewConfiguration.getScaledTouchSlop();
        this.f279m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f280n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f284r = new OverScroller(context, f266x);
    }

    public static h h(ViewGroup viewGroup, float f2, g gVar) {
        h hVar = new h(viewGroup.getContext(), viewGroup, gVar);
        hVar.f268b = (int) ((1.0f / f2) * hVar.f268b);
        return hVar;
    }

    public final void a() {
        this.f269c = -1;
        float[] fArr = this.f270d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f271e, 0.0f);
            Arrays.fill(this.f272f, 0.0f);
            Arrays.fill(this.f273g, 0.0f);
            Arrays.fill(this.f274h, 0);
            Arrays.fill(this.f275i, 0);
            Arrays.fill(this.f276j, 0);
            this.f277k = 0;
        }
        VelocityTracker velocityTracker = this.f278l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f278l = null;
        }
    }

    public final void b(int i2, View view) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = this.f288v;
        if (parent != viewGroup) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + viewGroup + ")");
        }
        this.f286t = view;
        this.f269c = i2;
        this.f285s.onViewCaptured(view, i2);
        q(1);
    }

    public final boolean c(float f2, float f3, int i2, int i3) {
        float fAbs = Math.abs(f2);
        float fAbs2 = Math.abs(f3);
        if ((this.f274h[i2] & i3) != i3 || (this.f283q & i3) == 0 || (this.f276j[i2] & i3) == i3 || (this.f275i[i2] & i3) == i3) {
            return false;
        }
        int i4 = this.f268b;
        if (fAbs <= i4 && fAbs2 <= i4) {
            return false;
        }
        if (fAbs >= fAbs2 * 0.5f || !this.f285s.onEdgeLock(i3)) {
            return (this.f275i[i2] & i3) == 0 && fAbs > ((float) this.f268b);
        }
        int[] iArr = this.f276j;
        iArr[i2] = iArr[i2] | i3;
        return false;
    }

    public final boolean d(float f2, float f3, View view) {
        if (view == null) {
            return false;
        }
        g gVar = this.f285s;
        boolean z2 = gVar.getViewHorizontalDragRange(view) > 0;
        boolean z3 = gVar.getViewVerticalDragRange(view) > 0;
        if (!z2 || !z3) {
            return z2 ? Math.abs(f2) > ((float) this.f268b) : z3 && Math.abs(f3) > ((float) this.f268b);
        }
        float f4 = (f3 * f3) + (f2 * f2);
        int i2 = this.f268b;
        return f4 > ((float) (i2 * i2));
    }

    public final void e(int i2) {
        float[] fArr = this.f270d;
        if (fArr != null) {
            int i3 = this.f277k;
            int i4 = 1 << i2;
            if ((i3 & i4) != 0) {
                fArr[i2] = 0.0f;
                this.f271e[i2] = 0.0f;
                this.f272f[i2] = 0.0f;
                this.f273g[i2] = 0.0f;
                this.f274h[i2] = 0;
                this.f275i[i2] = 0;
                this.f276j[i2] = 0;
                this.f277k = (~i4) & i3;
            }
        }
    }

    public final int f(int i2, int i3, int i4) {
        if (i2 == 0) {
            return 0;
        }
        float width = this.f288v.getWidth() / 2;
        float fSin = (((float) Math.sin((Math.min(1.0f, Math.abs(i2) / r3) - 0.5f) * 0.47123894f)) * width) + width;
        int iAbs = Math.abs(i3);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fSin / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i2) / i4) + 1.0f) * 256.0f), 600);
    }

    public final boolean g() {
        if (this.f267a == 2) {
            OverScroller overScroller = this.f284r;
            boolean zComputeScrollOffset = overScroller.computeScrollOffset();
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int left = currX - this.f286t.getLeft();
            int top = currY - this.f286t.getTop();
            if (left != 0) {
                View view = this.f286t;
                WeakHashMap weakHashMap = d1.f138a;
                view.offsetLeftAndRight(left);
            }
            if (top != 0) {
                View view2 = this.f286t;
                WeakHashMap weakHashMap2 = d1.f138a;
                view2.offsetTopAndBottom(top);
            }
            if (left != 0 || top != 0) {
                this.f285s.onViewPositionChanged(this.f286t, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == overScroller.getFinalX() && currY == overScroller.getFinalY()) {
                overScroller.abortAnimation();
            } else if (!zComputeScrollOffset) {
            }
            this.f288v.post(this.f289w);
        }
        return this.f267a == 2;
    }

    public final View i(int i2, int i3) {
        ViewGroup viewGroup = this.f288v;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(this.f285s.getOrderedChildIndex(childCount));
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean j(int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        float f5;
        int left = this.f286t.getLeft();
        int top = this.f286t.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top;
        OverScroller overScroller = this.f284r;
        int i8 = 0;
        if (i6 == 0 && i7 == 0) {
            overScroller.abortAnimation();
            q(0);
            return false;
        }
        View view = this.f286t;
        int i9 = (int) this.f280n;
        int i10 = (int) this.f279m;
        int iAbs = Math.abs(i4);
        if (iAbs < i9) {
            i4 = 0;
        } else if (iAbs > i10) {
            i4 = i4 > 0 ? i10 : -i10;
        }
        int i11 = (int) this.f280n;
        int iAbs2 = Math.abs(i5);
        if (iAbs2 < i11) {
            i5 = i8;
        } else if (iAbs2 > i10) {
            if (i5 > 0) {
                i5 = i10;
            } else {
                i8 = -i10;
                i5 = i8;
            }
        }
        int iAbs3 = Math.abs(i6);
        int iAbs4 = Math.abs(i7);
        int iAbs5 = Math.abs(i4);
        int iAbs6 = Math.abs(i5);
        int i12 = iAbs5 + iAbs6;
        int i13 = iAbs3 + iAbs4;
        if (i4 != 0) {
            f2 = iAbs5;
            f3 = i12;
        } else {
            f2 = iAbs3;
            f3 = i13;
        }
        float f6 = f2 / f3;
        if (i5 != 0) {
            f4 = iAbs6;
            f5 = i12;
        } else {
            f4 = iAbs4;
            f5 = i13;
        }
        float f7 = f4 / f5;
        g gVar = this.f285s;
        overScroller.startScroll(left, top, i6, i7, (int) ((f(i7, i5, gVar.getViewVerticalDragRange(view)) * f7) + (f(i6, i4, gVar.getViewHorizontalDragRange(view)) * f6)));
        q(2);
        return true;
    }

    public final boolean k(int i2) {
        if ((this.f277k & (1 << i2)) != 0) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i2 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public final void l(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f278l == null) {
            this.f278l = VelocityTracker.obtain();
        }
        this.f278l.addMovement(motionEvent);
        int i2 = 0;
        g gVar = this.f285s;
        if (actionMasked == 0) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewI = i((int) x2, (int) y2);
            o(pointerId, x2, y2);
            u(pointerId, viewI);
            int i3 = this.f283q & this.f274h[pointerId];
            if (i3 != 0) {
                gVar.onEdgeTouched(i3, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f267a == 1) {
                m();
            }
            a();
            return;
        }
        if (actionMasked == 2) {
            if (this.f267a != 1) {
                int pointerCount = motionEvent.getPointerCount();
                while (i2 < pointerCount) {
                    int pointerId2 = motionEvent.getPointerId(i2);
                    if (k(pointerId2)) {
                        float x3 = motionEvent.getX(i2);
                        float y3 = motionEvent.getY(i2);
                        float f2 = x3 - this.f270d[pointerId2];
                        float f3 = y3 - this.f271e[pointerId2];
                        n(pointerId2, f2, f3);
                        if (this.f267a != 1) {
                            View viewI2 = i((int) x3, (int) y3);
                            if (d(f2, f3, viewI2) && u(pointerId2, viewI2)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    i2++;
                }
                p(motionEvent);
                return;
            }
            if (k(this.f269c)) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f269c);
                float x4 = motionEvent.getX(iFindPointerIndex);
                float y4 = motionEvent.getY(iFindPointerIndex);
                float[] fArr = this.f272f;
                int i4 = this.f269c;
                int i5 = (int) (x4 - fArr[i4]);
                int i6 = (int) (y4 - this.f273g[i4]);
                int left = this.f286t.getLeft() + i5;
                int top = this.f286t.getTop() + i6;
                int left2 = this.f286t.getLeft();
                int top2 = this.f286t.getTop();
                if (i5 != 0) {
                    left = gVar.clampViewPositionHorizontal(this.f286t, left, i5);
                    WeakHashMap weakHashMap = d1.f138a;
                    this.f286t.offsetLeftAndRight(left - left2);
                }
                int i7 = left;
                if (i6 != 0) {
                    top = gVar.clampViewPositionVertical(this.f286t, top, i6);
                    WeakHashMap weakHashMap2 = d1.f138a;
                    this.f286t.offsetTopAndBottom(top - top2);
                }
                int i8 = top;
                if (i5 != 0 || i6 != 0) {
                    this.f285s.onViewPositionChanged(this.f286t, i7, i8, i7 - left2, i8 - top2);
                }
                p(motionEvent);
                return;
            }
            return;
        }
        if (actionMasked == 3) {
            if (this.f267a == 1) {
                this.f287u = true;
                gVar.onViewReleased(this.f286t, 0.0f, 0.0f);
                this.f287u = false;
                if (this.f267a == 1) {
                    q(0);
                }
            }
            a();
            return;
        }
        if (actionMasked != 5) {
            if (actionMasked != 6) {
                return;
            }
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            if (this.f267a == 1 && pointerId3 == this.f269c) {
                int pointerCount2 = motionEvent.getPointerCount();
                while (true) {
                    if (i2 >= pointerCount2) {
                        break;
                    }
                    int pointerId4 = motionEvent.getPointerId(i2);
                    if (pointerId4 != this.f269c) {
                        View viewI3 = i((int) motionEvent.getX(i2), (int) motionEvent.getY(i2));
                        View view = this.f286t;
                        if (viewI3 == view && u(pointerId4, view)) {
                            if (this.f269c == -1) {
                                break;
                            }
                        }
                    }
                    i2++;
                }
                m();
            }
            e(pointerId3);
            return;
        }
        int pointerId5 = motionEvent.getPointerId(actionIndex);
        float x5 = motionEvent.getX(actionIndex);
        float y5 = motionEvent.getY(actionIndex);
        o(pointerId5, x5, y5);
        if (this.f267a == 0) {
            u(pointerId5, i((int) x5, (int) y5));
            int i9 = this.f283q & this.f274h[pointerId5];
            if (i9 != 0) {
                gVar.onEdgeTouched(i9, pointerId5);
                return;
            }
            return;
        }
        int i10 = (int) x5;
        int i11 = (int) y5;
        View view2 = this.f286t;
        if (view2 != null && i10 >= view2.getLeft() && i10 < view2.getRight() && i11 >= view2.getTop() && i11 < view2.getBottom()) {
            u(pointerId5, this.f286t);
        }
    }

    public final void m() {
        VelocityTracker velocityTracker = this.f278l;
        float f2 = this.f279m;
        velocityTracker.computeCurrentVelocity(1000, f2);
        float xVelocity = this.f278l.getXVelocity(this.f269c);
        float f3 = this.f280n;
        float fAbs = Math.abs(xVelocity);
        float f4 = 0.0f;
        if (fAbs < f3) {
            xVelocity = 0.0f;
        } else if (fAbs > f2) {
            xVelocity = xVelocity > 0.0f ? f2 : -f2;
        }
        float yVelocity = this.f278l.getYVelocity(this.f269c);
        float f5 = this.f280n;
        float fAbs2 = Math.abs(yVelocity);
        if (fAbs2 >= f5) {
            if (fAbs2 > f2) {
                if (yVelocity <= 0.0f) {
                    f2 = -f2;
                }
                f4 = f2;
            } else {
                f4 = yVelocity;
            }
        }
        this.f287u = true;
        this.f285s.onViewReleased(this.f286t, xVelocity, f4);
        this.f287u = false;
        if (this.f267a == 1) {
            q(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.customview.widget.g] */
    public final void n(int i2, float f2, float f3) {
        boolean zC = c(f2, f3, i2, 1);
        boolean z2 = zC;
        if (c(f3, f2, i2, 4)) {
            z2 = (zC ? 1 : 0) | 4;
        }
        boolean z3 = z2;
        if (c(f2, f3, i2, 2)) {
            z3 = (z2 ? 1 : 0) | 2;
        }
        ?? r02 = z3;
        if (c(f3, f2, i2, 8)) {
            r02 = (z3 ? 1 : 0) | 8;
        }
        if (r02 != 0) {
            int[] iArr = this.f275i;
            iArr[i2] = iArr[i2] | r02;
            this.f285s.onEdgeDragStarted(r02, i2);
        }
    }

    public final void o(int i2, float f2, float f3) {
        float[] fArr = this.f270d;
        if (fArr == null || fArr.length <= i2) {
            int i3 = i2 + 1;
            float[] fArr2 = new float[i3];
            float[] fArr3 = new float[i3];
            float[] fArr4 = new float[i3];
            float[] fArr5 = new float[i3];
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f271e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f272f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f273g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f274h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f275i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f276j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f270d = fArr2;
            this.f271e = fArr3;
            this.f272f = fArr4;
            this.f273g = fArr5;
            this.f274h = iArr;
            this.f275i = iArr2;
            this.f276j = iArr3;
        }
        float[] fArr9 = this.f270d;
        this.f272f[i2] = f2;
        fArr9[i2] = f2;
        float[] fArr10 = this.f271e;
        this.f273g[i2] = f3;
        fArr10[i2] = f3;
        int[] iArr7 = this.f274h;
        int i4 = (int) f2;
        int i5 = (int) f3;
        ViewGroup viewGroup = this.f288v;
        int i6 = i4 < viewGroup.getLeft() + this.f281o ? 1 : 0;
        if (i5 < viewGroup.getTop() + this.f281o) {
            i6 |= 4;
        }
        if (i4 > viewGroup.getRight() - this.f281o) {
            i6 |= 2;
        }
        if (i5 > viewGroup.getBottom() - this.f281o) {
            i6 |= 8;
        }
        iArr7[i2] = i6;
        this.f277k = (1 << i2) | this.f277k;
    }

    public final void p(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = motionEvent.getPointerId(i2);
            if (k(pointerId)) {
                float x2 = motionEvent.getX(i2);
                float y2 = motionEvent.getY(i2);
                this.f272f[pointerId] = x2;
                this.f273g[pointerId] = y2;
            }
        }
    }

    public final void q(int i2) {
        this.f288v.removeCallbacks(this.f289w);
        if (this.f267a != i2) {
            this.f267a = i2;
            this.f285s.onViewDragStateChanged(i2);
            if (this.f267a == 0) {
                this.f286t = null;
            }
        }
    }

    public final boolean r(int i2, int i3) {
        if (this.f287u) {
            return j(i2, i3, (int) this.f278l.getXVelocity(this.f269c), (int) this.f278l.getYVelocity(this.f269c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean s(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.h.s(android.view.MotionEvent):boolean");
    }

    public final boolean t(View view, int i2, int i3) {
        this.f286t = view;
        this.f269c = -1;
        boolean zJ = j(i2, i3, 0, 0);
        if (!zJ && this.f267a == 0 && this.f286t != null) {
            this.f286t = null;
        }
        return zJ;
    }

    public final boolean u(int i2, View view) {
        if (view == this.f286t && this.f269c == i2) {
            return true;
        }
        if (view == null || !this.f285s.tryCaptureView(view, i2)) {
            return false;
        }
        this.f269c = i2;
        b(i2, view);
        return true;
    }
}
