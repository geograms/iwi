package androidx.recyclerview.widget;

import android.R;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class z extends d1 implements l1 {
    public static final int[] C = {R.attr.state_pressed};
    public static final int[] D = new int[0];
    public int A;
    public final v B;

    /* renamed from: a, reason: collision with root package name */
    public final int f1001a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1002b;

    /* renamed from: c, reason: collision with root package name */
    public final StateListDrawable f1003c;

    /* renamed from: d, reason: collision with root package name */
    public final Drawable f1004d;

    /* renamed from: e, reason: collision with root package name */
    public final int f1005e;

    /* renamed from: f, reason: collision with root package name */
    public final int f1006f;

    /* renamed from: g, reason: collision with root package name */
    public final StateListDrawable f1007g;

    /* renamed from: h, reason: collision with root package name */
    public final Drawable f1008h;

    /* renamed from: i, reason: collision with root package name */
    public final int f1009i;

    /* renamed from: j, reason: collision with root package name */
    public final int f1010j;

    /* renamed from: k, reason: collision with root package name */
    public int f1011k;

    /* renamed from: l, reason: collision with root package name */
    public int f1012l;

    /* renamed from: m, reason: collision with root package name */
    public float f1013m;

    /* renamed from: n, reason: collision with root package name */
    public int f1014n;

    /* renamed from: o, reason: collision with root package name */
    public int f1015o;

    /* renamed from: p, reason: collision with root package name */
    public float f1016p;

    /* renamed from: s, reason: collision with root package name */
    public final RecyclerView f1019s;

    /* renamed from: z, reason: collision with root package name */
    public final ValueAnimator f1026z;

    /* renamed from: q, reason: collision with root package name */
    public int f1017q = 0;

    /* renamed from: r, reason: collision with root package name */
    public int f1018r = 0;

    /* renamed from: t, reason: collision with root package name */
    public boolean f1020t = false;

    /* renamed from: u, reason: collision with root package name */
    public boolean f1021u = false;

    /* renamed from: v, reason: collision with root package name */
    public int f1022v = 0;

    /* renamed from: w, reason: collision with root package name */
    public int f1023w = 0;

    /* renamed from: x, reason: collision with root package name */
    public final int[] f1024x = new int[2];

    /* renamed from: y, reason: collision with root package name */
    public final int[] f1025y = new int[2];

    public z(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i2, int i3, int i4) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f1026z = valueAnimatorOfFloat;
        this.A = 0;
        v vVar = new v(0, this);
        this.B = vVar;
        w wVar = new w(this);
        this.f1003c = stateListDrawable;
        this.f1004d = drawable;
        this.f1007g = stateListDrawable2;
        this.f1008h = drawable2;
        this.f1005e = Math.max(i2, stateListDrawable.getIntrinsicWidth());
        this.f1006f = Math.max(i2, drawable.getIntrinsicWidth());
        this.f1009i = Math.max(i2, stateListDrawable2.getIntrinsicWidth());
        this.f1010j = Math.max(i2, drawable2.getIntrinsicWidth());
        this.f1001a = i3;
        this.f1002b = i4;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new x(this));
        valueAnimatorOfFloat.addUpdateListener(new y(this));
        RecyclerView recyclerView2 = this.f1019s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            recyclerView2.removeItemDecoration(this);
            this.f1019s.removeOnItemTouchListener(this);
            this.f1019s.removeOnScrollListener(wVar);
            this.f1019s.removeCallbacks(vVar);
        }
        this.f1019s = recyclerView;
        if (recyclerView != null) {
            recyclerView.addItemDecoration(this);
            this.f1019s.addOnItemTouchListener(this);
            this.f1019s.addOnScrollListener(wVar);
        }
    }

    public static int c(float f2, float f3, int[] iArr, int i2, int i3, int i4) {
        int i5 = iArr[1] - iArr[0];
        if (i5 == 0) {
            return 0;
        }
        int i6 = i2 - i4;
        int i7 = (int) (((f3 - f2) / i5) * i6);
        int i8 = i3 + i7;
        if (i8 >= i6 || i8 < 0) {
            return 0;
        }
        return i7;
    }

    public final boolean a(float f2, float f3) {
        if (f3 >= this.f1018r - this.f1009i) {
            int i2 = this.f1015o;
            int i3 = this.f1014n;
            if (f2 >= i2 - (i3 / 2) && f2 <= (i3 / 2) + i2) {
                return true;
            }
        }
        return false;
    }

    public final boolean b(float f2, float f3) {
        RecyclerView recyclerView = this.f1019s;
        WeakHashMap weakHashMap = androidx.core.view.d1.f138a;
        boolean z2 = androidx.core.view.n0.d(recyclerView) == 1;
        int i2 = this.f1005e;
        if (z2) {
            if (f2 > i2 / 2) {
                return false;
            }
        } else if (f2 < this.f1017q - i2) {
            return false;
        }
        int i3 = this.f1012l;
        int i4 = this.f1011k / 2;
        return f3 >= ((float) (i3 - i4)) && f3 <= ((float) (i4 + i3));
    }

    public final void d(int i2) {
        v vVar = this.B;
        StateListDrawable stateListDrawable = this.f1003c;
        if (i2 == 2 && this.f1022v != 2) {
            stateListDrawable.setState(C);
            this.f1019s.removeCallbacks(vVar);
        }
        if (i2 == 0) {
            this.f1019s.invalidate();
        } else {
            e();
        }
        if (this.f1022v == 2 && i2 != 2) {
            stateListDrawable.setState(D);
            this.f1019s.removeCallbacks(vVar);
            this.f1019s.postDelayed(vVar, 1200);
        } else if (i2 == 1) {
            this.f1019s.removeCallbacks(vVar);
            this.f1019s.postDelayed(vVar, 1500);
        }
        this.f1022v = i2;
    }

    public final void e() {
        int i2 = this.A;
        ValueAnimator valueAnimator = this.f1026z;
        if (i2 != 0) {
            if (i2 != 3) {
                return;
            } else {
                valueAnimator.cancel();
            }
        }
        this.A = 1;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        valueAnimator.setDuration(500L);
        valueAnimator.setStartDelay(0L);
        valueAnimator.start();
    }

    @Override // androidx.recyclerview.widget.d1
    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, w1 w1Var) {
        if (this.f1017q != this.f1019s.getWidth() || this.f1018r != this.f1019s.getHeight()) {
            this.f1017q = this.f1019s.getWidth();
            this.f1018r = this.f1019s.getHeight();
            d(0);
            return;
        }
        if (this.A != 0) {
            if (this.f1020t) {
                int i2 = this.f1017q;
                int i3 = this.f1005e;
                int i4 = i2 - i3;
                int i5 = this.f1012l;
                int i6 = this.f1011k;
                int i7 = i5 - (i6 / 2);
                StateListDrawable stateListDrawable = this.f1003c;
                stateListDrawable.setBounds(0, 0, i3, i6);
                int i8 = this.f1018r;
                int i9 = this.f1006f;
                Drawable drawable = this.f1004d;
                drawable.setBounds(0, 0, i9, i8);
                RecyclerView recyclerView2 = this.f1019s;
                WeakHashMap weakHashMap = androidx.core.view.d1.f138a;
                if (androidx.core.view.n0.d(recyclerView2) == 1) {
                    drawable.draw(canvas);
                    canvas.translate(i3, i7);
                    canvas.scale(-1.0f, 1.0f);
                    stateListDrawable.draw(canvas);
                    canvas.scale(1.0f, 1.0f);
                    canvas.translate(-i3, -i7);
                } else {
                    canvas.translate(i4, 0.0f);
                    drawable.draw(canvas);
                    canvas.translate(0.0f, i7);
                    stateListDrawable.draw(canvas);
                    canvas.translate(-i4, -i7);
                }
            }
            if (this.f1021u) {
                int i10 = this.f1018r;
                int i11 = this.f1009i;
                int i12 = i10 - i11;
                int i13 = this.f1015o;
                int i14 = this.f1014n;
                int i15 = i13 - (i14 / 2);
                StateListDrawable stateListDrawable2 = this.f1007g;
                stateListDrawable2.setBounds(0, 0, i14, i11);
                int i16 = this.f1017q;
                int i17 = this.f1010j;
                Drawable drawable2 = this.f1008h;
                drawable2.setBounds(0, 0, i16, i17);
                canvas.translate(0.0f, i12);
                drawable2.draw(canvas);
                canvas.translate(i15, 0.0f);
                stateListDrawable2.draw(canvas);
                canvas.translate(-i15, -i12);
            }
        }
    }
}
