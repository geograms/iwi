package androidx.drawerlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import androidx.core.view.d1;
import androidx.core.view.m0;
import androidx.core.view.n0;
import androidx.core.view.n2;
import androidx.core.view.s0;
import androidx.customview.widget.h;
import androidx.drawerlayout.R$attr;
import androidx.drawerlayout.R$dimen;
import androidx.drawerlayout.R$styleable;
import java.util.ArrayList;
import java.util.WeakHashMap;
import k.j;
import u.i;
import w.a;
import w.b;
import w.c;
import w.d;
import w.e;
import w.f;

/* loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {
    public static final int[] C = {R.attr.colorPrimaryDark};
    public static final int[] D = {R.attr.layout_gravity};
    public Matrix A;
    public final j B;

    /* renamed from: a, reason: collision with root package name */
    public float f290a;

    /* renamed from: b, reason: collision with root package name */
    public final int f291b;

    /* renamed from: c, reason: collision with root package name */
    public int f292c;

    /* renamed from: d, reason: collision with root package name */
    public float f293d;

    /* renamed from: e, reason: collision with root package name */
    public final Paint f294e;

    /* renamed from: f, reason: collision with root package name */
    public final h f295f;

    /* renamed from: g, reason: collision with root package name */
    public final h f296g;

    /* renamed from: h, reason: collision with root package name */
    public final f f297h;

    /* renamed from: i, reason: collision with root package name */
    public final f f298i;

    /* renamed from: j, reason: collision with root package name */
    public int f299j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f300k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f301l;

    /* renamed from: m, reason: collision with root package name */
    public int f302m;

    /* renamed from: n, reason: collision with root package name */
    public int f303n;

    /* renamed from: o, reason: collision with root package name */
    public int f304o;

    /* renamed from: p, reason: collision with root package name */
    public int f305p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f306q;

    /* renamed from: r, reason: collision with root package name */
    public c f307r;

    /* renamed from: s, reason: collision with root package name */
    public ArrayList f308s;

    /* renamed from: t, reason: collision with root package name */
    public float f309t;

    /* renamed from: u, reason: collision with root package name */
    public float f310u;

    /* renamed from: v, reason: collision with root package name */
    public Drawable f311v;

    /* renamed from: w, reason: collision with root package name */
    public Object f312w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f313x;

    /* renamed from: y, reason: collision with root package name */
    public final ArrayList f314y;

    /* renamed from: z, reason: collision with root package name */
    public Rect f315z;

    /* JADX WARN: Illegal instructions before constructor call */
    public DrawerLayout(Context context, AttributeSet attributeSet) {
        int i2 = R$attr.drawerLayoutStyle;
        super(context, attributeSet, i2);
        new i(1);
        this.f292c = -1728053248;
        this.f294e = new Paint();
        this.f301l = true;
        this.f302m = 3;
        this.f303n = 3;
        this.f304o = 3;
        this.f305p = 3;
        this.B = new j(8, this);
        setDescendantFocusability(262144);
        float f2 = getResources().getDisplayMetrics().density;
        this.f291b = (int) ((64.0f * f2) + 0.5f);
        float f3 = f2 * 400.0f;
        f fVar = new f(this, 3);
        this.f297h = fVar;
        f fVar2 = new f(this, 5);
        this.f298i = fVar2;
        h hVarH = h.h(this, 1.0f, fVar);
        this.f295f = hVarH;
        hVarH.f283q = 1;
        hVarH.f280n = f3;
        fVar.f2614b = hVarH;
        h hVarH2 = h.h(this, 1.0f, fVar2);
        this.f296g = hVarH2;
        hVarH2.f283q = 2;
        hVarH2.f280n = f3;
        fVar2.f2614b = hVarH2;
        setFocusableInTouchMode(true);
        WeakHashMap weakHashMap = d1.f138a;
        m0.s(this, 1);
        d1.k(this, new b(this));
        setMotionEventSplittingEnabled(false);
        if (m0.b(this)) {
            setOnApplyWindowInsetsListener(new a());
            setSystemUiVisibility(1280);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(C);
            try {
                this.f311v = typedArrayObtainStyledAttributes.getDrawable(0);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.DrawerLayout, i2, 0);
        try {
            if (typedArrayObtainStyledAttributes2.hasValue(R$styleable.DrawerLayout_elevation)) {
                this.f290a = typedArrayObtainStyledAttributes2.getDimension(R$styleable.DrawerLayout_elevation, 0.0f);
            } else {
                this.f290a = getResources().getDimension(R$dimen.def_drawer_elevation);
            }
            typedArrayObtainStyledAttributes2.recycle();
            this.f314y = new ArrayList();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes2.recycle();
            throw th;
        }
    }

    public static String j(int i2) {
        return (i2 & 3) == 3 ? "LEFT" : (i2 & 5) == 5 ? "RIGHT" : Integer.toHexString(i2);
    }

    public static boolean k(View view) {
        return ((d) view.getLayoutParams()).f2604a == 0;
    }

    public static boolean l(View view) {
        if (m(view)) {
            return (((d) view.getLayoutParams()).f2607d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public static boolean m(View view) {
        int i2 = ((d) view.getLayoutParams()).f2604a;
        WeakHashMap weakHashMap = d1.f138a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i2, n0.d(view));
        return ((absoluteGravity & 3) == 0 && (absoluteGravity & 5) == 0) ? false : true;
    }

    public static boolean n(View view) {
        if (m(view)) {
            return ((d) view.getLayoutParams()).f2605b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public final boolean a(int i2, View view) {
        return (i(view) & i2) == i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i2, int i3) {
        ArrayList arrayList2;
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        int i4 = 0;
        boolean z2 = false;
        while (true) {
            arrayList2 = this.f314y;
            if (i4 >= childCount) {
                break;
            }
            View childAt = getChildAt(i4);
            if (!m(childAt)) {
                arrayList2.add(childAt);
            } else if (l(childAt)) {
                childAt.addFocusables(arrayList, i2, i3);
                z2 = true;
            }
            i4++;
        }
        if (!z2) {
            int size = arrayList2.size();
            for (int i5 = 0; i5 < size; i5++) {
                View view = (View) arrayList2.get(i5);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i2, i3);
                }
            }
        }
        arrayList2.clear();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (e() != null || m(view)) {
            WeakHashMap weakHashMap = d1.f138a;
            m0.s(view, 4);
        } else {
            WeakHashMap weakHashMap2 = d1.f138a;
            m0.s(view, 1);
        }
    }

    public final void b(View view) {
        if (!m(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        d dVar = (d) view.getLayoutParams();
        if (this.f301l) {
            dVar.f2605b = 0.0f;
            dVar.f2607d = 0;
        } else {
            dVar.f2607d |= 4;
            if (a(3, view)) {
                this.f295f.t(view, -view.getWidth(), view.getTop());
            } else {
                this.f296g.t(view, getWidth(), view.getTop());
            }
        }
        invalidate();
    }

    public final void c(boolean z2) {
        int childCount = getChildCount();
        boolean zT = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            d dVar = (d) childAt.getLayoutParams();
            if (m(childAt) && (!z2 || dVar.f2606c)) {
                zT |= a(3, childAt) ? this.f295f.t(childAt, -childAt.getWidth(), childAt.getTop()) : this.f296g.t(childAt, getWidth(), childAt.getTop());
                dVar.f2606c = false;
            }
        }
        f fVar = this.f297h;
        fVar.f2616d.removeCallbacks(fVar.f2615c);
        f fVar2 = this.f298i;
        fVar2.f2616d.removeCallbacks(fVar2.f2615c);
        if (zT) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof d) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public final void computeScroll() {
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int i2 = 0; i2 < childCount; i2++) {
            fMax = Math.max(fMax, ((d) getChildAt(i2).getLayoutParams()).f2605b);
        }
        this.f293d = fMax;
        boolean zG = this.f295f.g();
        boolean zG2 = this.f296g.g();
        if (zG || zG2) {
            WeakHashMap weakHashMap = d1.f138a;
            m0.k(this);
        }
    }

    public final View d(int i2) {
        WeakHashMap weakHashMap = d1.f138a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i2, n0.d(this)) & 7;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((i(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.View
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        boolean zDispatchGenericMotionEvent;
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f293d <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            View childAt = getChildAt(i2);
            if (this.f315z == null) {
                this.f315z = new Rect();
            }
            childAt.getHitRect(this.f315z);
            if (this.f315z.contains((int) x2, (int) y2) && !k(childAt)) {
                if (childAt.getMatrix().isIdentity()) {
                    float scrollX = getScrollX() - childAt.getLeft();
                    float scrollY = getScrollY() - childAt.getTop();
                    motionEvent.offsetLocation(scrollX, scrollY);
                    zDispatchGenericMotionEvent = childAt.dispatchGenericMotionEvent(motionEvent);
                    motionEvent.offsetLocation(-scrollX, -scrollY);
                } else {
                    float scrollX2 = getScrollX() - childAt.getLeft();
                    float scrollY2 = getScrollY() - childAt.getTop();
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    motionEventObtain.offsetLocation(scrollX2, scrollY2);
                    Matrix matrix = childAt.getMatrix();
                    if (!matrix.isIdentity()) {
                        if (this.A == null) {
                            this.A = new Matrix();
                        }
                        matrix.invert(this.A);
                        motionEventObtain.transform(this.A);
                    }
                    zDispatchGenericMotionEvent = childAt.dispatchGenericMotionEvent(motionEventObtain);
                    motionEventObtain.recycle();
                }
                if (zDispatchGenericMotionEvent) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j2) {
        Drawable background;
        int height = getHeight();
        boolean zK = k(view);
        int width = getWidth();
        int iSave = canvas.save();
        int i2 = 0;
        if (zK) {
            int childCount = getChildCount();
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt != view && childAt.getVisibility() == 0 && (background = childAt.getBackground()) != null && background.getOpacity() == -1 && m(childAt) && childAt.getHeight() >= height) {
                    if (a(3, childAt)) {
                        int right = childAt.getRight();
                        if (right > i3) {
                            i3 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i3, 0, width, getHeight());
            i2 = i3;
        }
        boolean zDrawChild = super.drawChild(canvas, view, j2);
        canvas.restoreToCount(iSave);
        float f2 = this.f293d;
        if (f2 > 0.0f && zK) {
            int i5 = this.f292c;
            Paint paint = this.f294e;
            paint.setColor((((int) ((((-16777216) & i5) >>> 24) * f2)) << 24) | (i5 & 16777215));
            canvas.drawRect(i2, 0.0f, width, getHeight(), paint);
        }
        return zDrawChild;
    }

    public final View e() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((((d) childAt.getLayoutParams()).f2607d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    public final View f() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (m(childAt) && n(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public final int g(int i2) {
        WeakHashMap weakHashMap = d1.f138a;
        int iD = n0.d(this);
        if (i2 == 3) {
            int i3 = this.f302m;
            if (i3 != 3) {
                return i3;
            }
            int i4 = iD == 0 ? this.f304o : this.f305p;
            if (i4 != 3) {
                return i4;
            }
            return 0;
        }
        if (i2 == 5) {
            int i5 = this.f303n;
            if (i5 != 3) {
                return i5;
            }
            int i6 = iD == 0 ? this.f305p : this.f304o;
            if (i6 != 3) {
                return i6;
            }
            return 0;
        }
        if (i2 == 8388611) {
            int i7 = this.f304o;
            if (i7 != 3) {
                return i7;
            }
            int i8 = iD == 0 ? this.f302m : this.f303n;
            if (i8 != 3) {
                return i8;
            }
            return 0;
        }
        if (i2 != 8388613) {
            return 0;
        }
        int i9 = this.f305p;
        if (i9 != 3) {
            return i9;
        }
        int i10 = iD == 0 ? this.f303n : this.f302m;
        if (i10 != 3) {
            return i10;
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        d dVar = new d(-1, -1);
        dVar.f2604a = 0;
        return dVar;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof d) {
            d dVar = (d) layoutParams;
            d dVar2 = new d(dVar);
            dVar2.f2604a = 0;
            dVar2.f2604a = dVar.f2604a;
            return dVar2;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            d dVar3 = new d((ViewGroup.MarginLayoutParams) layoutParams);
            dVar3.f2604a = 0;
            return dVar3;
        }
        d dVar4 = new d(layoutParams);
        dVar4.f2604a = 0;
        return dVar4;
    }

    public float getDrawerElevation() {
        return this.f290a;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f311v;
    }

    public final int h(View view) {
        if (m(view)) {
            return g(((d) view.getLayoutParams()).f2604a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public final int i(View view) {
        int i2 = ((d) view.getLayoutParams()).f2604a;
        WeakHashMap weakHashMap = d1.f138a;
        return Gravity.getAbsoluteGravity(i2, n0.d(this));
    }

    public final void o(View view) {
        if (!m(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        d dVar = (d) view.getLayoutParams();
        if (this.f301l) {
            dVar.f2605b = 1.0f;
            dVar.f2607d = 1;
            s(view, true);
            r(view);
        } else {
            dVar.f2607d |= 2;
            if (a(3, view)) {
                this.f295f.t(view, 0, view.getTop());
            } else {
                this.f296g.t(view, getWidth() - view.getWidth(), view.getTop());
            }
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f301l = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f301l = true;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f313x || this.f311v == null) {
            return;
        }
        Object obj = this.f312w;
        int systemWindowInsetTop = obj != null ? ((WindowInsets) obj).getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.f311v.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.f311v.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005e  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            int r0 = r9.getActionMasked()
            androidx.customview.widget.h r1 = r8.f295f
            boolean r2 = r1.s(r9)
            androidx.customview.widget.h r3 = r8.f296g
            boolean r3 = r3.s(r9)
            r2 = r2 | r3
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L65
            if (r0 == r3) goto L5e
            r9 = 2
            if (r0 == r9) goto L1e
            r9 = 3
            if (r0 == r9) goto L5e
            goto L63
        L1e:
            float[] r9 = r1.f270d
            int r9 = r9.length
            r0 = r4
        L22:
            if (r0 >= r9) goto L63
            int r5 = r1.f277k
            int r6 = r3 << r0
            r5 = r5 & r6
            if (r5 == 0) goto L5b
            float[] r5 = r1.f272f
            r5 = r5[r0]
            float[] r6 = r1.f270d
            r6 = r6[r0]
            float r5 = r5 - r6
            float[] r6 = r1.f273g
            r6 = r6[r0]
            float[] r7 = r1.f271e
            r7 = r7[r0]
            float r6 = r6 - r7
            float r5 = r5 * r5
            float r6 = r6 * r6
            float r6 = r6 + r5
            int r5 = r1.f268b
            int r5 = r5 * r5
            float r5 = (float) r5
            int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r5 <= 0) goto L5b
            w.f r9 = r8.f297h
            androidx.activity.d r0 = r9.f2615c
            androidx.drawerlayout.widget.DrawerLayout r9 = r9.f2616d
            r9.removeCallbacks(r0)
            w.f r9 = r8.f298i
            androidx.activity.d r0 = r9.f2615c
            androidx.drawerlayout.widget.DrawerLayout r9 = r9.f2616d
            r9.removeCallbacks(r0)
            goto L63
        L5b:
            int r0 = r0 + 1
            goto L22
        L5e:
            r8.c(r3)
            r8.f306q = r4
        L63:
            r9 = r4
            goto L8b
        L65:
            float r0 = r9.getX()
            float r9 = r9.getY()
            r8.f309t = r0
            r8.f310u = r9
            float r5 = r8.f293d
            r6 = 0
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L88
            int r0 = (int) r0
            int r9 = (int) r9
            android.view.View r9 = r1.i(r0, r9)
            if (r9 == 0) goto L88
            boolean r9 = k(r9)
            if (r9 == 0) goto L88
            r9 = r3
            goto L89
        L88:
            r9 = r4
        L89:
            r8.f306q = r4
        L8b:
            if (r2 != 0) goto Lae
            if (r9 != 0) goto Lae
            int r9 = r8.getChildCount()
            r0 = r4
        L94:
            if (r0 >= r9) goto La8
            android.view.View r1 = r8.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            w.d r1 = (w.d) r1
            boolean r1 = r1.f2606c
            if (r1 == 0) goto La5
            goto Lae
        La5:
            int r0 = r0 + 1
            goto L94
        La8:
            boolean r8 = r8.f306q
            if (r8 == 0) goto Lad
            goto Lae
        Lad:
            r3 = r4
        Lae:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4 || f() == null) {
            return super.onKeyDown(i2, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyUp(i2, keyEvent);
        }
        View viewF = f();
        if (viewF != null && h(viewF) == 0) {
            c(false);
        }
        return viewF != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        float f2;
        int i6;
        boolean z3 = true;
        this.f300k = true;
        int i7 = i4 - i2;
        int childCount = getChildCount();
        int i8 = 0;
        while (i8 < childCount) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (k(childAt)) {
                    int i9 = ((ViewGroup.MarginLayoutParams) dVar).leftMargin;
                    childAt.layout(i9, ((ViewGroup.MarginLayoutParams) dVar).topMargin, childAt.getMeasuredWidth() + i9, childAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) dVar).topMargin);
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a(3, childAt)) {
                        float f3 = measuredWidth;
                        i6 = (-measuredWidth) + ((int) (dVar.f2605b * f3));
                        f2 = (measuredWidth + i6) / f3;
                    } else {
                        float f4 = measuredWidth;
                        f2 = (i7 - r11) / f4;
                        i6 = i7 - ((int) (dVar.f2605b * f4));
                    }
                    boolean z4 = f2 != dVar.f2605b ? z3 : false;
                    int i10 = dVar.f2604a & 112;
                    if (i10 == 16) {
                        int i11 = i5 - i3;
                        int i12 = (i11 - measuredHeight) / 2;
                        int i13 = ((ViewGroup.MarginLayoutParams) dVar).topMargin;
                        if (i12 < i13) {
                            i12 = i13;
                        } else {
                            int i14 = i12 + measuredHeight;
                            int i15 = i11 - ((ViewGroup.MarginLayoutParams) dVar).bottomMargin;
                            if (i14 > i15) {
                                i12 = i15 - measuredHeight;
                            }
                        }
                        childAt.layout(i6, i12, measuredWidth + i6, measuredHeight + i12);
                    } else if (i10 != 80) {
                        int i16 = ((ViewGroup.MarginLayoutParams) dVar).topMargin;
                        childAt.layout(i6, i16, measuredWidth + i6, measuredHeight + i16);
                    } else {
                        int i17 = i5 - i3;
                        childAt.layout(i6, (i17 - ((ViewGroup.MarginLayoutParams) dVar).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i6, i17 - ((ViewGroup.MarginLayoutParams) dVar).bottomMargin);
                    }
                    if (z4) {
                        q(childAt, f2);
                    }
                    int i18 = dVar.f2605b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i18) {
                        childAt.setVisibility(i18);
                    }
                }
            }
            i8++;
            z3 = true;
        }
        WindowInsets rootWindowInsets = getRootWindowInsets();
        if (rootWindowInsets != null) {
            k.f fVarI = n2.g(null, rootWindowInsets).f189a.i();
            h hVar = this.f295f;
            hVar.f281o = Math.max(hVar.f282p, fVarI.f1926a);
            h hVar2 = this.f296g;
            hVar2.f281o = Math.max(hVar2.f282p, fVarI.f1928c);
        }
        this.f300k = false;
        this.f301l = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r18, int r19) {
        /*
            Method dump skipped, instructions count: 414
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        View viewD;
        if (!(parcelable instanceof e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.getSuperState());
        int i2 = eVar.f2608a;
        if (i2 != 0 && (viewD = d(i2)) != null) {
            o(viewD);
        }
        int i3 = eVar.f2609b;
        if (i3 != 3) {
            p(i3, 3);
        }
        int i4 = eVar.f2610c;
        if (i4 != 3) {
            p(i4, 5);
        }
        int i5 = eVar.f2611d;
        if (i5 != 3) {
            p(i5, 8388611);
        }
        int i6 = eVar.f2612e;
        if (i6 != 3) {
            p(i6, 8388613);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i2) {
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        eVar.f2608a = 0;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            d dVar = (d) getChildAt(i2).getLayoutParams();
            int i3 = dVar.f2607d;
            boolean z2 = i3 == 1;
            boolean z3 = i3 == 2;
            if (z2 || z3) {
                eVar.f2608a = dVar.f2604a;
                break;
            }
        }
        eVar.f2609b = this.f302m;
        eVar.f2610c = this.f303n;
        eVar.f2611d = this.f304o;
        eVar.f2612e = this.f305p;
        return eVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            androidx.customview.widget.h r0 = r6.f295f
            r0.l(r7)
            androidx.customview.widget.h r1 = r6.f296g
            r1.l(r7)
            int r1 = r7.getAction()
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L59
            if (r1 == r3) goto L20
            r7 = 3
            if (r1 == r7) goto L1a
            goto L67
        L1a:
            r6.c(r3)
            r6.f306q = r2
            goto L67
        L20:
            float r1 = r7.getX()
            float r7 = r7.getY()
            int r4 = (int) r1
            int r5 = (int) r7
            android.view.View r4 = r0.i(r4, r5)
            if (r4 == 0) goto L54
            boolean r4 = k(r4)
            if (r4 == 0) goto L54
            float r4 = r6.f309t
            float r1 = r1 - r4
            float r4 = r6.f310u
            float r7 = r7 - r4
            int r0 = r0.f268b
            float r1 = r1 * r1
            float r7 = r7 * r7
            float r7 = r7 + r1
            int r0 = r0 * r0
            float r0 = (float) r0
            int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r7 >= 0) goto L54
            android.view.View r7 = r6.e()
            if (r7 == 0) goto L54
            int r7 = r6.h(r7)
            r0 = 2
            if (r7 != r0) goto L55
        L54:
            r2 = r3
        L55:
            r6.c(r2)
            goto L67
        L59:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f309t = r0
            r6.f310u = r7
            r6.f306q = r2
        L67:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(int i2, int i3) {
        View viewD;
        WeakHashMap weakHashMap = d1.f138a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i3, n0.d(this));
        if (i3 == 3) {
            this.f302m = i2;
        } else if (i3 == 5) {
            this.f303n = i2;
        } else if (i3 == 8388611) {
            this.f304o = i2;
        } else if (i3 == 8388613) {
            this.f305p = i2;
        }
        if (i2 != 0) {
            (absoluteGravity == 3 ? this.f295f : this.f296g).a();
        }
        if (i2 != 1) {
            if (i2 == 2 && (viewD = d(absoluteGravity)) != null) {
                o(viewD);
                return;
            }
            return;
        }
        View viewD2 = d(absoluteGravity);
        if (viewD2 != null) {
            b(viewD2);
        }
    }

    public final void q(View view, float f2) {
        d dVar = (d) view.getLayoutParams();
        if (f2 == dVar.f2605b) {
            return;
        }
        dVar.f2605b = f2;
        ArrayList arrayList = this.f308s;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((c) this.f308s.get(size)).onDrawerSlide(view, f2);
            }
        }
    }

    public final void r(View view) {
        r.f fVar = r.f.f2499l;
        d1.i(fVar.a(), view);
        d1.g(0, view);
        if (!l(view) || h(view) == 2) {
            return;
        }
        d1.j(view, fVar, null, this.B);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z2) {
        super.requestDisallowInterceptTouchEvent(z2);
        if (z2) {
            c(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.f300k) {
            return;
        }
        super.requestLayout();
    }

    public final void s(View view, boolean z2) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((z2 || m(childAt)) && !(z2 && childAt == view)) {
                WeakHashMap weakHashMap = d1.f138a;
                m0.s(childAt, 4);
            } else {
                WeakHashMap weakHashMap2 = d1.f138a;
                m0.s(childAt, 1);
            }
        }
    }

    public void setDrawerElevation(float f2) {
        this.f290a = f2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (m(childAt)) {
                float f3 = this.f290a;
                WeakHashMap weakHashMap = d1.f138a;
                s0.s(childAt, f3);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(c cVar) {
        ArrayList arrayList;
        c cVar2 = this.f307r;
        if (cVar2 != null && (arrayList = this.f308s) != null) {
            arrayList.remove(cVar2);
        }
        if (cVar != null) {
            if (this.f308s == null) {
                this.f308s = new ArrayList();
            }
            this.f308s.add(cVar);
        }
        this.f307r = cVar;
    }

    public void setDrawerLockMode(int i2) {
        p(i2, 3);
        p(i2, 5);
    }

    public void setScrimColor(int i2) {
        this.f292c = i2;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f311v = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i2) {
        this.f311v = new ColorDrawable(i2);
        invalidate();
    }

    public final void t(int i2, View view) {
        int i3;
        View rootView;
        int i4 = this.f295f.f267a;
        int i5 = this.f296g.f267a;
        if (i4 == 1 || i5 == 1) {
            i3 = 1;
        } else {
            i3 = 2;
            if (i4 != 2 && i5 != 2) {
                i3 = 0;
            }
        }
        if (view != null && i2 == 0) {
            float f2 = ((d) view.getLayoutParams()).f2605b;
            if (f2 == 0.0f) {
                d dVar = (d) view.getLayoutParams();
                if ((dVar.f2607d & 1) == 1) {
                    dVar.f2607d = 0;
                    ArrayList arrayList = this.f308s;
                    if (arrayList != null) {
                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                            ((c) this.f308s.get(size)).onDrawerClosed(view);
                        }
                    }
                    s(view, false);
                    r(view);
                    if (hasWindowFocus() && (rootView = getRootView()) != null) {
                        rootView.sendAccessibilityEvent(32);
                    }
                }
            } else if (f2 == 1.0f) {
                d dVar2 = (d) view.getLayoutParams();
                if ((dVar2.f2607d & 1) == 0) {
                    dVar2.f2607d = 1;
                    ArrayList arrayList2 = this.f308s;
                    if (arrayList2 != null) {
                        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                            ((c) this.f308s.get(size2)).onDrawerOpened(view);
                        }
                    }
                    s(view, true);
                    r(view);
                    if (hasWindowFocus()) {
                        sendAccessibilityEvent(32);
                    }
                }
            }
        }
        if (i3 != this.f299j) {
            this.f299j = i3;
            ArrayList arrayList3 = this.f308s;
            if (arrayList3 != null) {
                for (int size3 = arrayList3.size() - 1; size3 >= 0; size3--) {
                    ((c) this.f308s.get(size3)).onDrawerStateChanged(i3);
                }
            }
        }
    }

    public void setStatusBarBackground(int i2) {
        Drawable drawableB;
        if (i2 != 0) {
            Context context = getContext();
            Object obj = i.e.f1841a;
            drawableB = i.c.b(context, i2);
        } else {
            drawableB = null;
        }
        this.f311v = drawableB;
        invalidate();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        d dVar = new d(context, attributeSet);
        dVar.f2604a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, D);
        dVar.f2604a = typedArrayObtainStyledAttributes.getInt(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return dVar;
    }
}
