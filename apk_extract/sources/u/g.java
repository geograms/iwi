package u;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.ListView;

/* loaded from: classes.dex */
public final class g implements View.OnTouchListener {

    /* renamed from: r, reason: collision with root package name */
    public static final int f2568r = ViewConfiguration.getTapTimeout();

    /* renamed from: a, reason: collision with root package name */
    public final a f2569a;

    /* renamed from: b, reason: collision with root package name */
    public final AccelerateInterpolator f2570b;

    /* renamed from: c, reason: collision with root package name */
    public final View f2571c;

    /* renamed from: d, reason: collision with root package name */
    public androidx.activity.d f2572d;

    /* renamed from: e, reason: collision with root package name */
    public final float[] f2573e;

    /* renamed from: f, reason: collision with root package name */
    public final float[] f2574f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2575g;

    /* renamed from: h, reason: collision with root package name */
    public final int f2576h;

    /* renamed from: i, reason: collision with root package name */
    public final float[] f2577i;

    /* renamed from: j, reason: collision with root package name */
    public final float[] f2578j;

    /* renamed from: k, reason: collision with root package name */
    public final float[] f2579k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f2580l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2581m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f2582n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f2583o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f2584p;

    /* renamed from: q, reason: collision with root package name */
    public final ListView f2585q;

    public g(ListView listView) {
        a aVar = new a();
        aVar.f2563e = Long.MIN_VALUE;
        aVar.f2565g = -1L;
        aVar.f2564f = 0L;
        this.f2569a = aVar;
        this.f2570b = new AccelerateInterpolator();
        this.f2573e = new float[]{0.0f, 0.0f};
        this.f2574f = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.f2577i = new float[]{0.0f, 0.0f};
        this.f2578j = new float[]{0.0f, 0.0f};
        this.f2579k = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.f2571c = listView;
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        float[] fArr = this.f2579k;
        float f3 = ((int) ((1575.0f * f2) + 0.5f)) / 1000.0f;
        fArr[0] = f3;
        fArr[1] = f3;
        float[] fArr2 = this.f2578j;
        float f4 = ((int) ((f2 * 315.0f) + 0.5f)) / 1000.0f;
        fArr2[0] = f4;
        fArr2[1] = f4;
        this.f2575g = 1;
        float[] fArr3 = this.f2574f;
        fArr3[0] = Float.MAX_VALUE;
        fArr3[1] = Float.MAX_VALUE;
        float[] fArr4 = this.f2573e;
        fArr4[0] = 0.2f;
        fArr4[1] = 0.2f;
        float[] fArr5 = this.f2577i;
        fArr5[0] = 0.001f;
        fArr5[1] = 0.001f;
        this.f2576h = f2568r;
        aVar.f2559a = 500;
        aVar.f2560b = 500;
        this.f2585q = listView;
    }

    public static float b(float f2, float f3, float f4) {
        return f2 > f4 ? f4 : f2 < f3 ? f3 : f2;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float a(int r4, float r5, float r6, float r7) {
        /*
            r3 = this;
            float[] r0 = r3.f2573e
            r0 = r0[r4]
            float[] r1 = r3.f2574f
            r1 = r1[r4]
            float r0 = r0 * r6
            r2 = 0
            float r0 = b(r0, r2, r1)
            float r1 = r3.c(r5, r0)
            float r6 = r6 - r5
            float r5 = r3.c(r6, r0)
            float r5 = r5 - r1
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            android.view.animation.AccelerateInterpolator r0 = r3.f2570b
            if (r6 >= 0) goto L25
            float r5 = -r5
            float r5 = r0.getInterpolation(r5)
            float r5 = -r5
            goto L2d
        L25:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 <= 0) goto L36
            float r5 = r0.getInterpolation(r5)
        L2d:
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r5 = b(r5, r6, r0)
            goto L37
        L36:
            r5 = r2
        L37:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 != 0) goto L3c
            goto L58
        L3c:
            float[] r0 = r3.f2577i
            r0 = r0[r4]
            float[] r1 = r3.f2578j
            r1 = r1[r4]
            float[] r3 = r3.f2579k
            r3 = r3[r4]
            float r0 = r0 * r7
            if (r6 <= 0) goto L51
            float r5 = r5 * r0
            float r2 = b(r5, r1, r3)
            goto L58
        L51:
            float r4 = -r5
            float r4 = r4 * r0
            float r3 = b(r4, r1, r3)
            float r2 = -r3
        L58:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: u.g.a(int, float, float, float):float");
    }

    public final float c(float f2, float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        int i2 = this.f2575g;
        if (i2 == 0 || i2 == 1) {
            if (f2 < f3) {
                return f2 >= 0.0f ? 1.0f - (f2 / f3) : (this.f2583o && i2 == 1) ? 1.0f : 0.0f;
            }
            return 0.0f;
        }
        if (i2 == 2 && f2 < 0.0f) {
            return f2 / (-f3);
        }
        return 0.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            boolean r0 = r7.f2584p
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r9.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r8 = 3
            if (r0 == r8) goto L16
            goto L7b
        L16:
            r7.e()
            goto L7b
        L1a:
            r7.f2582n = r2
            r7.f2580l = r1
        L1e:
            float r0 = r9.getX()
            int r3 = r8.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r7.f2571c
            int r5 = r4.getWidth()
            float r5 = (float) r5
            float r0 = r7.a(r1, r0, r3, r5)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r8 = r7.a(r2, r9, r8, r3)
            u.a r9 = r7.f2569a
            r9.f2561c = r0
            r9.f2562d = r8
            boolean r8 = r7.f2583o
            if (r8 != 0) goto L7b
            boolean r8 = r7.f()
            if (r8 == 0) goto L7b
            androidx.activity.d r8 = r7.f2572d
            if (r8 != 0) goto L5f
            androidx.activity.d r8 = new androidx.activity.d
            r8.<init>(r2, r7)
            r7.f2572d = r8
        L5f:
            r7.f2583o = r2
            r7.f2581m = r2
            boolean r8 = r7.f2580l
            if (r8 != 0) goto L74
            int r8 = r7.f2576h
            if (r8 <= 0) goto L74
            androidx.activity.d r9 = r7.f2572d
            long r5 = (long) r8
            java.util.WeakHashMap r8 = androidx.core.view.d1.f138a
            androidx.core.view.m0.n(r4, r9, r5)
            goto L79
        L74:
            androidx.activity.d r8 = r7.f2572d
            r8.run()
        L79:
            r7.f2580l = r2
        L7b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: u.g.d(android.view.View, android.view.MotionEvent):boolean");
    }

    public final void e() {
        int i2 = 0;
        if (this.f2581m) {
            this.f2583o = false;
            return;
        }
        a aVar = this.f2569a;
        aVar.getClass();
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i3 = (int) (jCurrentAnimationTimeMillis - aVar.f2563e);
        int i4 = aVar.f2560b;
        if (i3 > i4) {
            i2 = i4;
        } else if (i3 >= 0) {
            i2 = i3;
        }
        aVar.f2567i = i2;
        aVar.f2566h = aVar.a(jCurrentAnimationTimeMillis);
        aVar.f2565g = jCurrentAnimationTimeMillis;
    }

    public final boolean f() {
        ListView listView;
        int count;
        a aVar = this.f2569a;
        float f2 = aVar.f2562d;
        int iAbs = (int) (f2 / Math.abs(f2));
        Math.abs(aVar.f2561c);
        if (iAbs == 0 || (count = (listView = this.f2585q).getCount()) == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (iAbs > 0) {
            if (i2 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else {
            if (iAbs >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public final /* bridge */ /* synthetic */ boolean onTouch(View view, MotionEvent motionEvent) {
        d(view, motionEvent);
        return false;
    }
}
