package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.widget.ActivityChooserView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends h1 implements u1 {

    /* renamed from: a, reason: collision with root package name */
    public final int f698a;

    /* renamed from: b, reason: collision with root package name */
    public final h2[] f699b;

    /* renamed from: c, reason: collision with root package name */
    public final q0 f700c;

    /* renamed from: d, reason: collision with root package name */
    public final q0 f701d;

    /* renamed from: e, reason: collision with root package name */
    public final int f702e;

    /* renamed from: f, reason: collision with root package name */
    public int f703f;

    /* renamed from: g, reason: collision with root package name */
    public final f0 f704g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f705h;

    /* renamed from: j, reason: collision with root package name */
    public final BitSet f707j;

    /* renamed from: m, reason: collision with root package name */
    public final androidx.fragment.app.d f710m;

    /* renamed from: n, reason: collision with root package name */
    public final int f711n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f712o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f713p;

    /* renamed from: q, reason: collision with root package name */
    public g2 f714q;

    /* renamed from: r, reason: collision with root package name */
    public final Rect f715r;

    /* renamed from: s, reason: collision with root package name */
    public final d2 f716s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f717t;

    /* renamed from: u, reason: collision with root package name */
    public int[] f718u;

    /* renamed from: v, reason: collision with root package name */
    public final v f719v;

    /* renamed from: i, reason: collision with root package name */
    public boolean f706i = false;

    /* renamed from: k, reason: collision with root package name */
    public int f708k = -1;

    /* renamed from: l, reason: collision with root package name */
    public int f709l = Integer.MIN_VALUE;

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.f698a = -1;
        this.f705h = false;
        androidx.fragment.app.d dVar = new androidx.fragment.app.d();
        this.f710m = dVar;
        this.f711n = 2;
        this.f715r = new Rect();
        this.f716s = new d2(this);
        this.f717t = true;
        this.f719v = new v(1, this);
        g1 properties = h1.getProperties(context, attributeSet, i2, i3);
        int i4 = properties.f811a;
        if (i4 != 0 && i4 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (i4 != this.f702e) {
            this.f702e = i4;
            q0 q0Var = this.f700c;
            this.f700c = this.f701d;
            this.f701d = q0Var;
            requestLayout();
        }
        int i5 = properties.f812b;
        assertNotInLayoutOrScroll(null);
        if (i5 != this.f698a) {
            dVar.b();
            requestLayout();
            this.f698a = i5;
            this.f707j = new BitSet(this.f698a);
            this.f699b = new h2[this.f698a];
            for (int i6 = 0; i6 < this.f698a; i6++) {
                this.f699b[i6] = new h2(this, i6);
            }
            requestLayout();
        }
        boolean z2 = properties.f813c;
        assertNotInLayoutOrScroll(null);
        g2 g2Var = this.f714q;
        if (g2Var != null && g2Var.f822h != z2) {
            g2Var.f822h = z2;
        }
        this.f705h = z2;
        requestLayout();
        f0 f0Var = new f0();
        f0Var.f788a = true;
        f0Var.f793f = 0;
        f0Var.f794g = 0;
        this.f704g = f0Var;
        this.f700c = q0.a(this, this.f702e);
        this.f701d = q0.a(this, 1 - this.f702e);
    }

    public static int E(int i2, int i3, int i4) {
        if (i3 == 0 && i4 == 0) {
            return i2;
        }
        int mode = View.MeasureSpec.getMode(i2);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i2) - i3) - i4), mode) : i2;
    }

    public final void A() {
        if (this.f702e == 1 || !isLayoutRTL()) {
            this.f706i = this.f705h;
        } else {
            this.f706i = !this.f705h;
        }
    }

    public final void B(int i2) {
        f0 f0Var = this.f704g;
        f0Var.f792e = i2;
        f0Var.f791d = this.f706i != (i2 == -1) ? -1 : 1;
    }

    public final void C(int i2, w1 w1Var) {
        int i3;
        int i4;
        int width;
        int width2;
        int i5;
        f0 f0Var = this.f704g;
        boolean z2 = false;
        f0Var.f789b = 0;
        f0Var.f790c = i2;
        if (!isSmoothScrolling() || (i5 = w1Var.f976a) == -1) {
            i3 = 0;
            i4 = 0;
        } else {
            if (this.f706i == (i5 < i2)) {
                i3 = this.f700c.i();
                i4 = 0;
            } else {
                i4 = this.f700c.i();
                i3 = 0;
            }
        }
        if (getClipToPadding()) {
            f0Var.f793f = this.f700c.h() - i4;
            f0Var.f794g = this.f700c.f() + i3;
        } else {
            p0 p0Var = (p0) this.f700c;
            int i6 = p0Var.f924d;
            h1 h1Var = p0Var.f940a;
            switch (i6) {
                case 0:
                    width = h1Var.getWidth();
                    break;
                default:
                    width = h1Var.getHeight();
                    break;
            }
            f0Var.f794g = width + i3;
            f0Var.f793f = -i4;
        }
        f0Var.f795h = false;
        f0Var.f788a = true;
        if (this.f700c.g() == 0) {
            p0 p0Var2 = (p0) this.f700c;
            int i7 = p0Var2.f924d;
            h1 h1Var2 = p0Var2.f940a;
            switch (i7) {
                case 0:
                    width2 = h1Var2.getWidth();
                    break;
                default:
                    width2 = h1Var2.getHeight();
                    break;
            }
            if (width2 == 0) {
                z2 = true;
            }
        }
        f0Var.f796i = z2;
    }

    public final void D(h2 h2Var, int i2, int i3) {
        int i4 = h2Var.f834d;
        int i5 = h2Var.f835e;
        if (i2 != -1) {
            int i6 = h2Var.f833c;
            if (i6 == Integer.MIN_VALUE) {
                h2Var.a();
                i6 = h2Var.f833c;
            }
            if (i6 - i4 >= i3) {
                this.f707j.set(i5, false);
                return;
            }
            return;
        }
        int i7 = h2Var.f832b;
        if (i7 == Integer.MIN_VALUE) {
            View view = (View) h2Var.f831a.get(0);
            e2 e2Var = (e2) view.getLayoutParams();
            h2Var.f832b = h2Var.f836f.f700c.e(view);
            e2Var.getClass();
            i7 = h2Var.f832b;
        }
        if (i7 + i4 <= i3) {
            this.f707j.set(i5, false);
        }
    }

    @Override // androidx.recyclerview.widget.h1
    public final void assertNotInLayoutOrScroll(String str) {
        if (this.f714q == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    @Override // androidx.recyclerview.widget.h1
    public final boolean canScrollHorizontally() {
        return this.f702e == 0;
    }

    @Override // androidx.recyclerview.widget.h1
    public final boolean canScrollVertically() {
        return this.f702e == 1;
    }

    @Override // androidx.recyclerview.widget.h1
    public final boolean checkLayoutParams(i1 i1Var) {
        return i1Var instanceof e2;
    }

    @Override // androidx.recyclerview.widget.h1
    public final void collectAdjacentPrefetchPositions(int i2, int i3, w1 w1Var, f1 f1Var) {
        f0 f0Var;
        int iF;
        int iH;
        if (this.f702e != 0) {
            i2 = i3;
        }
        if (getChildCount() == 0 || i2 == 0) {
            return;
        }
        w(i2, w1Var);
        int[] iArr = this.f718u;
        if (iArr == null || iArr.length < this.f698a) {
            this.f718u = new int[this.f698a];
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = this.f698a;
            f0Var = this.f704g;
            if (i4 >= i6) {
                break;
            }
            if (f0Var.f791d == -1) {
                iF = f0Var.f793f;
                iH = this.f699b[i4].h(iF);
            } else {
                iF = this.f699b[i4].f(f0Var.f794g);
                iH = f0Var.f794g;
            }
            int i7 = iF - iH;
            if (i7 >= 0) {
                this.f718u[i5] = i7;
                i5++;
            }
            i4++;
        }
        Arrays.sort(this.f718u, 0, i5);
        for (int i8 = 0; i8 < i5; i8++) {
            int i9 = f0Var.f790c;
            if (i9 < 0 || i9 >= w1Var.b()) {
                return;
            }
            ((a0) f1Var).a(f0Var.f790c, this.f718u[i8]);
            f0Var.f790c += f0Var.f791d;
        }
    }

    @Override // androidx.recyclerview.widget.h1
    public final int computeHorizontalScrollExtent(w1 w1Var) {
        return f(w1Var);
    }

    @Override // androidx.recyclerview.widget.h1
    public final int computeHorizontalScrollOffset(w1 w1Var) {
        return g(w1Var);
    }

    @Override // androidx.recyclerview.widget.h1
    public final int computeHorizontalScrollRange(w1 w1Var) {
        return h(w1Var);
    }

    @Override // androidx.recyclerview.widget.u1
    public final PointF computeScrollVectorForPosition(int i2) {
        int iD = d(i2);
        PointF pointF = new PointF();
        if (iD == 0) {
            return null;
        }
        if (this.f702e == 0) {
            pointF.x = iD;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = iD;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.h1
    public final int computeVerticalScrollExtent(w1 w1Var) {
        return f(w1Var);
    }

    @Override // androidx.recyclerview.widget.h1
    public final int computeVerticalScrollOffset(w1 w1Var) {
        return g(w1Var);
    }

    @Override // androidx.recyclerview.widget.h1
    public final int computeVerticalScrollRange(w1 w1Var) {
        return h(w1Var);
    }

    public final int d(int i2) {
        if (getChildCount() == 0) {
            return this.f706i ? 1 : -1;
        }
        return (i2 < n()) != this.f706i ? -1 : 1;
    }

    public final boolean e() {
        int iN;
        if (getChildCount() != 0 && this.f711n != 0 && isAttachedToWindow()) {
            if (this.f706i) {
                iN = o();
                n();
            } else {
                iN = n();
                o();
            }
            androidx.fragment.app.d dVar = this.f710m;
            if (iN == 0 && s() != null) {
                dVar.b();
                requestSimpleAnimationsInNextLayout();
                requestLayout();
                return true;
            }
        }
        return false;
    }

    public final int f(w1 w1Var) {
        if (getChildCount() == 0) {
            return 0;
        }
        q0 q0Var = this.f700c;
        boolean z2 = this.f717t;
        return x0.g.A(w1Var, q0Var, k(!z2), j(!z2), this, this.f717t);
    }

    public final int g(w1 w1Var) {
        if (getChildCount() == 0) {
            return 0;
        }
        q0 q0Var = this.f700c;
        boolean z2 = this.f717t;
        return x0.g.B(w1Var, q0Var, k(!z2), j(!z2), this, this.f717t, this.f706i);
    }

    @Override // androidx.recyclerview.widget.h1
    public final i1 generateDefaultLayoutParams() {
        return this.f702e == 0 ? new e2(-2, -1) : new e2(-1, -2);
    }

    @Override // androidx.recyclerview.widget.h1
    public final i1 generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new e2(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.h1
    public final int getColumnCountForAccessibility(p1 p1Var, w1 w1Var) {
        return this.f702e == 1 ? this.f698a : super.getColumnCountForAccessibility(p1Var, w1Var);
    }

    @Override // androidx.recyclerview.widget.h1
    public final int getRowCountForAccessibility(p1 p1Var, w1 w1Var) {
        return this.f702e == 0 ? this.f698a : super.getRowCountForAccessibility(p1Var, w1Var);
    }

    public final int h(w1 w1Var) {
        if (getChildCount() == 0) {
            return 0;
        }
        q0 q0Var = this.f700c;
        boolean z2 = this.f717t;
        return x0.g.C(w1Var, q0Var, k(!z2), j(!z2), this, this.f717t);
    }

    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v56 */
    public final int i(p1 p1Var, f0 f0Var, w1 w1Var) {
        h2 h2Var;
        ?? r1;
        int iC;
        int iC2;
        int iH;
        int iC3;
        View view;
        int i2;
        int i3;
        int i4;
        p1 p1Var2 = p1Var;
        int i5 = 0;
        int i6 = 1;
        this.f707j.set(0, this.f698a, true);
        f0 f0Var2 = this.f704g;
        int i7 = f0Var2.f796i ? f0Var.f792e == 1 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : Integer.MIN_VALUE : f0Var.f792e == 1 ? f0Var.f794g + f0Var.f789b : f0Var.f793f - f0Var.f789b;
        int i8 = f0Var.f792e;
        for (int i9 = 0; i9 < this.f698a; i9++) {
            if (!this.f699b[i9].f831a.isEmpty()) {
                D(this.f699b[i9], i8, i7);
            }
        }
        int iF = this.f706i ? this.f700c.f() : this.f700c.h();
        boolean z2 = false;
        while (true) {
            int i10 = f0Var.f790c;
            int i11 = -1;
            if (((i10 < 0 || i10 >= w1Var.b()) ? i5 : i6) == 0 || (!f0Var2.f796i && this.f707j.isEmpty())) {
                break;
            }
            View view2 = p1Var2.j(f0Var.f790c, Long.MAX_VALUE).itemView;
            f0Var.f790c += f0Var.f791d;
            e2 e2Var = (e2) view2.getLayoutParams();
            int layoutPosition = e2Var.f852a.getLayoutPosition();
            androidx.fragment.app.d dVar = this.f710m;
            int[] iArr = (int[]) dVar.f476a;
            int i12 = (iArr == null || layoutPosition >= iArr.length) ? -1 : iArr[layoutPosition];
            if (i12 == -1) {
                if (v(f0Var.f792e)) {
                    i3 = this.f698a - i6;
                    i4 = -1;
                } else {
                    i11 = this.f698a;
                    i3 = i5;
                    i4 = i6;
                }
                h2 h2Var2 = null;
                if (f0Var.f792e == i6) {
                    int iH2 = this.f700c.h();
                    int i13 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    while (i3 != i11) {
                        h2 h2Var3 = this.f699b[i3];
                        int iF2 = h2Var3.f(iH2);
                        if (iF2 < i13) {
                            i13 = iF2;
                            h2Var2 = h2Var3;
                        }
                        i3 += i4;
                    }
                } else {
                    int iF3 = this.f700c.f();
                    int i14 = Integer.MIN_VALUE;
                    while (i3 != i11) {
                        h2 h2Var4 = this.f699b[i3];
                        int iH3 = h2Var4.h(iF3);
                        if (iH3 > i14) {
                            h2Var2 = h2Var4;
                            i14 = iH3;
                        }
                        i3 += i4;
                    }
                }
                h2Var = h2Var2;
                dVar.q(layoutPosition);
                ((int[]) dVar.f476a)[layoutPosition] = h2Var.f835e;
            } else {
                h2Var = this.f699b[i12];
            }
            h2 h2Var5 = h2Var;
            e2Var.f779e = h2Var5;
            if (f0Var.f792e == 1) {
                addView(view2);
                r1 = 0;
            } else {
                r1 = 0;
                addView(view2, 0);
            }
            if (this.f702e == 1) {
                t(view2, h1.getChildMeasureSpec(this.f703f, getWidthMode(), r1, ((ViewGroup.MarginLayoutParams) e2Var).width, r1), h1.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop(), ((ViewGroup.MarginLayoutParams) e2Var).height, true));
            } else {
                t(view2, h1.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft(), ((ViewGroup.MarginLayoutParams) e2Var).width, true), h1.getChildMeasureSpec(this.f703f, getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) e2Var).height, false));
            }
            if (f0Var.f792e == 1) {
                int iF4 = h2Var5.f(iF);
                iC2 = iF4;
                iC = this.f700c.c(view2) + iF4;
            } else {
                int iH4 = h2Var5.h(iF);
                iC = iH4;
                iC2 = iH4 - this.f700c.c(view2);
            }
            if (f0Var.f792e == 1) {
                h2 h2Var6 = e2Var.f779e;
                h2Var6.getClass();
                e2 e2Var2 = (e2) view2.getLayoutParams();
                e2Var2.f779e = h2Var6;
                ArrayList arrayList = h2Var6.f831a;
                arrayList.add(view2);
                h2Var6.f833c = Integer.MIN_VALUE;
                if (arrayList.size() == 1) {
                    h2Var6.f832b = Integer.MIN_VALUE;
                }
                if (e2Var2.f852a.isRemoved() || e2Var2.f852a.isUpdated()) {
                    h2Var6.f834d = h2Var6.f836f.f700c.c(view2) + h2Var6.f834d;
                }
            } else {
                h2 h2Var7 = e2Var.f779e;
                h2Var7.getClass();
                e2 e2Var3 = (e2) view2.getLayoutParams();
                e2Var3.f779e = h2Var7;
                ArrayList arrayList2 = h2Var7.f831a;
                arrayList2.add(0, view2);
                h2Var7.f832b = Integer.MIN_VALUE;
                if (arrayList2.size() == 1) {
                    h2Var7.f833c = Integer.MIN_VALUE;
                }
                if (e2Var3.f852a.isRemoved() || e2Var3.f852a.isUpdated()) {
                    h2Var7.f834d = h2Var7.f836f.f700c.c(view2) + h2Var7.f834d;
                }
            }
            if (isLayoutRTL() && this.f702e == 1) {
                iC3 = this.f701d.f() - (((this.f698a - 1) - h2Var5.f835e) * this.f703f);
                iH = iC3 - this.f701d.c(view2);
            } else {
                iH = this.f701d.h() + (h2Var5.f835e * this.f703f);
                iC3 = this.f701d.c(view2) + iH;
            }
            int i15 = iC3;
            int i16 = iH;
            if (this.f702e == 1) {
                view = view2;
                layoutDecoratedWithMargins(view2, i16, iC2, i15, iC);
            } else {
                view = view2;
                layoutDecoratedWithMargins(view, iC2, i16, iC, i15);
            }
            D(h2Var5, f0Var2.f792e, i7);
            x(p1Var, f0Var2);
            if (f0Var2.f795h && view.hasFocusable()) {
                i2 = 0;
                this.f707j.set(h2Var5.f835e, false);
            } else {
                i2 = 0;
            }
            p1Var2 = p1Var;
            i5 = i2;
            z2 = true;
            i6 = 1;
        }
        p1 p1Var3 = p1Var2;
        int i17 = i5;
        if (!z2) {
            x(p1Var3, f0Var2);
        }
        int iH5 = f0Var2.f792e == -1 ? this.f700c.h() - q(this.f700c.h()) : p(this.f700c.f()) - this.f700c.f();
        return iH5 > 0 ? Math.min(f0Var.f789b, iH5) : i17;
    }

    @Override // androidx.recyclerview.widget.h1
    public final boolean isAutoMeasureEnabled() {
        return this.f711n != 0;
    }

    public final boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public final View j(boolean z2) {
        int iH = this.f700c.h();
        int iF = this.f700c.f();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int iE = this.f700c.e(childAt);
            int iB = this.f700c.b(childAt);
            if (iB > iH && iE < iF) {
                if (iB <= iF || !z2) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public final View k(boolean z2) {
        int iH = this.f700c.h();
        int iF = this.f700c.f();
        int childCount = getChildCount();
        View view = null;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int iE = this.f700c.e(childAt);
            if (this.f700c.b(childAt) > iH && iE < iF) {
                if (iE >= iH || !z2) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public final void l(p1 p1Var, w1 w1Var, boolean z2) {
        int iF;
        int iP = p(Integer.MIN_VALUE);
        if (iP != Integer.MIN_VALUE && (iF = this.f700c.f() - iP) > 0) {
            int i2 = iF - (-scrollBy(-iF, p1Var, w1Var));
            if (!z2 || i2 <= 0) {
                return;
            }
            this.f700c.m(i2);
        }
    }

    public final void m(p1 p1Var, w1 w1Var, boolean z2) {
        int iH;
        int iQ = q(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        if (iQ != Integer.MAX_VALUE && (iH = iQ - this.f700c.h()) > 0) {
            int iScrollBy = iH - scrollBy(iH, p1Var, w1Var);
            if (!z2 || iScrollBy <= 0) {
                return;
            }
            this.f700c.m(-iScrollBy);
        }
    }

    public final int n() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    public final int o() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    @Override // androidx.recyclerview.widget.h1
    public final void offsetChildrenHorizontal(int i2) {
        super.offsetChildrenHorizontal(i2);
        for (int i3 = 0; i3 < this.f698a; i3++) {
            h2 h2Var = this.f699b[i3];
            int i4 = h2Var.f832b;
            if (i4 != Integer.MIN_VALUE) {
                h2Var.f832b = i4 + i2;
            }
            int i5 = h2Var.f833c;
            if (i5 != Integer.MIN_VALUE) {
                h2Var.f833c = i5 + i2;
            }
        }
    }

    @Override // androidx.recyclerview.widget.h1
    public final void offsetChildrenVertical(int i2) {
        super.offsetChildrenVertical(i2);
        for (int i3 = 0; i3 < this.f698a; i3++) {
            h2 h2Var = this.f699b[i3];
            int i4 = h2Var.f832b;
            if (i4 != Integer.MIN_VALUE) {
                h2Var.f832b = i4 + i2;
            }
            int i5 = h2Var.f833c;
            if (i5 != Integer.MIN_VALUE) {
                h2Var.f833c = i5 + i2;
            }
        }
    }

    @Override // androidx.recyclerview.widget.h1
    public final void onDetachedFromWindow(RecyclerView recyclerView, p1 p1Var) {
        super.onDetachedFromWindow(recyclerView, p1Var);
        removeCallbacks(this.f719v);
        for (int i2 = 0; i2 < this.f698a; i2++) {
            this.f699b[i2].b();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x004d  */
    @Override // androidx.recyclerview.widget.h1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View onFocusSearchFailed(android.view.View r9, int r10, androidx.recyclerview.widget.p1 r11, androidx.recyclerview.widget.w1 r12) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.p1, androidx.recyclerview.widget.w1):android.view.View");
    }

    @Override // androidx.recyclerview.widget.h1
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View viewK = k(false);
            View viewJ = j(false);
            if (viewK == null || viewJ == null) {
                return;
            }
            int position = getPosition(viewK);
            int position2 = getPosition(viewJ);
            if (position < position2) {
                accessibilityEvent.setFromIndex(position);
                accessibilityEvent.setToIndex(position2);
            } else {
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    @Override // androidx.recyclerview.widget.h1
    public final void onInitializeAccessibilityNodeInfoForItem(p1 p1Var, w1 w1Var, View view, r.g gVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof e2)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, gVar);
            return;
        }
        e2 e2Var = (e2) layoutParams;
        if (this.f702e == 0) {
            h2 h2Var = e2Var.f779e;
            gVar.g(c.a.a(h2Var != null ? h2Var.f835e : -1, 1, -1, -1, false, false));
        } else {
            h2 h2Var2 = e2Var.f779e;
            gVar.g(c.a.a(-1, -1, h2Var2 != null ? h2Var2.f835e : -1, 1, false, false));
        }
    }

    @Override // androidx.recyclerview.widget.h1
    public final void onItemsAdded(RecyclerView recyclerView, int i2, int i3) {
        r(i2, i3, 1);
    }

    @Override // androidx.recyclerview.widget.h1
    public final void onItemsChanged(RecyclerView recyclerView) {
        this.f710m.b();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.h1
    public final void onItemsMoved(RecyclerView recyclerView, int i2, int i3, int i4) {
        r(i2, i3, 8);
    }

    @Override // androidx.recyclerview.widget.h1
    public final void onItemsRemoved(RecyclerView recyclerView, int i2, int i3) {
        r(i2, i3, 2);
    }

    @Override // androidx.recyclerview.widget.h1
    public final void onItemsUpdated(RecyclerView recyclerView, int i2, int i3, Object obj) {
        r(i2, i3, 4);
    }

    @Override // androidx.recyclerview.widget.h1
    public final void onLayoutChildren(p1 p1Var, w1 w1Var) {
        u(p1Var, w1Var, true);
    }

    @Override // androidx.recyclerview.widget.h1
    public final void onLayoutCompleted(w1 w1Var) {
        this.f708k = -1;
        this.f709l = Integer.MIN_VALUE;
        this.f714q = null;
        this.f716s.a();
    }

    @Override // androidx.recyclerview.widget.h1
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof g2) {
            this.f714q = (g2) parcelable;
            requestLayout();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005d  */
    @Override // androidx.recyclerview.widget.h1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Parcelable onSaveInstanceState() {
        /*
            r5 = this;
            androidx.recyclerview.widget.g2 r0 = r5.f714q
            if (r0 == 0) goto L32
            androidx.recyclerview.widget.g2 r5 = new androidx.recyclerview.widget.g2
            r5.<init>()
            int r1 = r0.f817c
            r5.f817c = r1
            int r1 = r0.f815a
            r5.f815a = r1
            int r1 = r0.f816b
            r5.f816b = r1
            int[] r1 = r0.f818d
            r5.f818d = r1
            int r1 = r0.f819e
            r5.f819e = r1
            int[] r1 = r0.f820f
            r5.f820f = r1
            boolean r1 = r0.f822h
            r5.f822h = r1
            boolean r1 = r0.f823i
            r5.f823i = r1
            boolean r1 = r0.f824j
            r5.f824j = r1
            java.util.List r0 = r0.f821g
            r5.f821g = r0
            return r5
        L32:
            androidx.recyclerview.widget.g2 r0 = new androidx.recyclerview.widget.g2
            r0.<init>()
            boolean r1 = r5.f705h
            r0.f822h = r1
            boolean r1 = r5.f712o
            r0.f823i = r1
            boolean r1 = r5.f713p
            r0.f824j = r1
            r1 = 0
            androidx.fragment.app.d r2 = r5.f710m
            if (r2 == 0) goto L5d
            java.lang.Object r3 = r2.f476a
            r4 = r3
            int[] r4 = (int[]) r4
            if (r4 == 0) goto L5d
            int[] r3 = (int[]) r3
            r0.f820f = r3
            int r3 = r3.length
            r0.f819e = r3
            java.lang.Object r2 = r2.f477b
            java.util.List r2 = (java.util.List) r2
            r0.f821g = r2
            goto L5f
        L5d:
            r0.f819e = r1
        L5f:
            int r2 = r5.getChildCount()
            r3 = -1
            if (r2 <= 0) goto Lc8
            boolean r2 = r5.f712o
            if (r2 == 0) goto L6f
            int r2 = r5.o()
            goto L73
        L6f:
            int r2 = r5.n()
        L73:
            r0.f815a = r2
            boolean r2 = r5.f706i
            r4 = 1
            if (r2 == 0) goto L7f
            android.view.View r2 = r5.j(r4)
            goto L83
        L7f:
            android.view.View r2 = r5.k(r4)
        L83:
            if (r2 != 0) goto L86
            goto L8a
        L86:
            int r3 = r5.getPosition(r2)
        L8a:
            r0.f816b = r3
            int r2 = r5.f698a
            r0.f817c = r2
            int[] r2 = new int[r2]
            r0.f818d = r2
        L94:
            int r2 = r5.f698a
            if (r1 >= r2) goto Lce
            boolean r2 = r5.f712o
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r2 == 0) goto Lb0
            androidx.recyclerview.widget.h2[] r2 = r5.f699b
            r2 = r2[r1]
            int r2 = r2.f(r3)
            if (r2 == r3) goto Lc1
            androidx.recyclerview.widget.q0 r3 = r5.f700c
            int r3 = r3.f()
        Lae:
            int r2 = r2 - r3
            goto Lc1
        Lb0:
            androidx.recyclerview.widget.h2[] r2 = r5.f699b
            r2 = r2[r1]
            int r2 = r2.h(r3)
            if (r2 == r3) goto Lc1
            androidx.recyclerview.widget.q0 r3 = r5.f700c
            int r3 = r3.h()
            goto Lae
        Lc1:
            int[] r3 = r0.f818d
            r3[r1] = r2
            int r1 = r1 + 1
            goto L94
        Lc8:
            r0.f815a = r3
            r0.f816b = r3
            r0.f817c = r1
        Lce:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.onSaveInstanceState():android.os.Parcelable");
    }

    @Override // androidx.recyclerview.widget.h1
    public final void onScrollStateChanged(int i2) {
        if (i2 == 0) {
            e();
        }
    }

    public final int p(int i2) {
        int iF = this.f699b[0].f(i2);
        for (int i3 = 1; i3 < this.f698a; i3++) {
            int iF2 = this.f699b[i3].f(i2);
            if (iF2 > iF) {
                iF = iF2;
            }
        }
        return iF;
    }

    public final int q(int i2) {
        int iH = this.f699b[0].h(i2);
        for (int i3 = 1; i3 < this.f698a; i3++) {
            int iH2 = this.f699b[i3].h(i2);
            if (iH2 < iH) {
                iH = iH2;
            }
        }
        return iH;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(int r8, int r9, int r10) {
        /*
            r7 = this;
            boolean r0 = r7.f706i
            if (r0 == 0) goto L9
            int r0 = r7.o()
            goto Ld
        L9:
            int r0 = r7.n()
        Ld:
            r1 = 8
            if (r10 != r1) goto L1b
            if (r8 >= r9) goto L17
            int r2 = r9 + 1
        L15:
            r3 = r8
            goto L1e
        L17:
            int r2 = r8 + 1
            r3 = r9
            goto L1e
        L1b:
            int r2 = r8 + r9
            goto L15
        L1e:
            androidx.fragment.app.d r4 = r7.f710m
            r4.r(r3)
            r5 = 1
            if (r10 == r5) goto L37
            r6 = 2
            if (r10 == r6) goto L33
            if (r10 == r1) goto L2c
            goto L3a
        L2c:
            r4.t(r8, r5)
            r4.s(r9, r5)
            goto L3a
        L33:
            r4.t(r8, r9)
            goto L3a
        L37:
            r4.s(r8, r9)
        L3a:
            if (r2 > r0) goto L3d
            return
        L3d:
            boolean r8 = r7.f706i
            if (r8 == 0) goto L46
            int r8 = r7.n()
            goto L4a
        L46:
            int r8 = r7.o()
        L4a:
            if (r3 > r8) goto L4f
            r7.requestLayout()
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.r(int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ff A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x002c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View s() {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.s():android.view.View");
    }

    public final int scrollBy(int i2, p1 p1Var, w1 w1Var) {
        if (getChildCount() == 0 || i2 == 0) {
            return 0;
        }
        w(i2, w1Var);
        f0 f0Var = this.f704g;
        int i3 = i(p1Var, f0Var, w1Var);
        if (f0Var.f789b >= i3) {
            i2 = i2 < 0 ? -i3 : i3;
        }
        this.f700c.m(-i2);
        this.f712o = this.f706i;
        f0Var.f789b = 0;
        x(p1Var, f0Var);
        return i2;
    }

    @Override // androidx.recyclerview.widget.h1
    public final int scrollHorizontallyBy(int i2, p1 p1Var, w1 w1Var) {
        return scrollBy(i2, p1Var, w1Var);
    }

    @Override // androidx.recyclerview.widget.h1
    public final void scrollToPosition(int i2) {
        g2 g2Var = this.f714q;
        if (g2Var != null && g2Var.f815a != i2) {
            g2Var.f818d = null;
            g2Var.f817c = 0;
            g2Var.f815a = -1;
            g2Var.f816b = -1;
        }
        this.f708k = i2;
        this.f709l = Integer.MIN_VALUE;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.h1
    public final int scrollVerticallyBy(int i2, p1 p1Var, w1 w1Var) {
        return scrollBy(i2, p1Var, w1Var);
    }

    @Override // androidx.recyclerview.widget.h1
    public final void setMeasuredDimension(Rect rect, int i2, int i3) {
        int iChooseSize;
        int iChooseSize2;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.f702e == 1) {
            iChooseSize2 = h1.chooseSize(i3, rect.height() + paddingBottom, getMinimumHeight());
            iChooseSize = h1.chooseSize(i2, (this.f703f * this.f698a) + paddingRight, getMinimumWidth());
        } else {
            iChooseSize = h1.chooseSize(i2, rect.width() + paddingRight, getMinimumWidth());
            iChooseSize2 = h1.chooseSize(i3, (this.f703f * this.f698a) + paddingBottom, getMinimumHeight());
        }
        setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    @Override // androidx.recyclerview.widget.h1
    public final void smoothScrollToPosition(RecyclerView recyclerView, w1 w1Var, int i2) {
        k0 k0Var = new k0(recyclerView.getContext());
        k0Var.setTargetPosition(i2);
        startSmoothScroll(k0Var);
    }

    @Override // androidx.recyclerview.widget.h1
    public final boolean supportsPredictiveItemAnimations() {
        return this.f714q == null;
    }

    public final void t(View view, int i2, int i3) {
        Rect rect = this.f715r;
        calculateItemDecorationsForChild(view, rect);
        e2 e2Var = (e2) view.getLayoutParams();
        int iE = E(i2, ((ViewGroup.MarginLayoutParams) e2Var).leftMargin + rect.left, ((ViewGroup.MarginLayoutParams) e2Var).rightMargin + rect.right);
        int iE2 = E(i3, ((ViewGroup.MarginLayoutParams) e2Var).topMargin + rect.top, ((ViewGroup.MarginLayoutParams) e2Var).bottomMargin + rect.bottom);
        if (shouldMeasureChild(view, iE, iE2, e2Var)) {
            view.measure(iE, iE2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0401  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(androidx.recyclerview.widget.p1 r17, androidx.recyclerview.widget.w1 r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 1052
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.u(androidx.recyclerview.widget.p1, androidx.recyclerview.widget.w1, boolean):void");
    }

    public final boolean v(int i2) {
        if (this.f702e == 0) {
            return (i2 == -1) != this.f706i;
        }
        return ((i2 == -1) == this.f706i) == isLayoutRTL();
    }

    public final void w(int i2, w1 w1Var) {
        int iN;
        int i3;
        if (i2 > 0) {
            iN = o();
            i3 = 1;
        } else {
            iN = n();
            i3 = -1;
        }
        f0 f0Var = this.f704g;
        f0Var.f788a = true;
        C(iN, w1Var);
        B(i3);
        f0Var.f790c = iN + f0Var.f791d;
        f0Var.f789b = Math.abs(i2);
    }

    public final void x(p1 p1Var, f0 f0Var) {
        if (!f0Var.f788a || f0Var.f796i) {
            return;
        }
        if (f0Var.f789b == 0) {
            if (f0Var.f792e == -1) {
                y(p1Var, f0Var.f794g);
                return;
            } else {
                z(p1Var, f0Var.f793f);
                return;
            }
        }
        int i2 = 1;
        if (f0Var.f792e == -1) {
            int i3 = f0Var.f793f;
            int iH = this.f699b[0].h(i3);
            while (i2 < this.f698a) {
                int iH2 = this.f699b[i2].h(i3);
                if (iH2 > iH) {
                    iH = iH2;
                }
                i2++;
            }
            int i4 = i3 - iH;
            y(p1Var, i4 < 0 ? f0Var.f794g : f0Var.f794g - Math.min(i4, f0Var.f789b));
            return;
        }
        int i5 = f0Var.f794g;
        int iF = this.f699b[0].f(i5);
        while (i2 < this.f698a) {
            int iF2 = this.f699b[i2].f(i5);
            if (iF2 < iF) {
                iF = iF2;
            }
            i2++;
        }
        int i6 = iF - f0Var.f794g;
        z(p1Var, i6 < 0 ? f0Var.f793f : Math.min(i6, f0Var.f789b) + f0Var.f793f);
    }

    public final void y(p1 p1Var, int i2) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.f700c.e(childAt) < i2 || this.f700c.l(childAt) < i2) {
                return;
            }
            e2 e2Var = (e2) childAt.getLayoutParams();
            e2Var.getClass();
            if (e2Var.f779e.f831a.size() == 1) {
                return;
            }
            h2 h2Var = e2Var.f779e;
            ArrayList arrayList = h2Var.f831a;
            int size = arrayList.size();
            View view = (View) arrayList.remove(size - 1);
            e2 e2Var2 = (e2) view.getLayoutParams();
            e2Var2.f779e = null;
            if (e2Var2.f852a.isRemoved() || e2Var2.f852a.isUpdated()) {
                h2Var.f834d -= h2Var.f836f.f700c.c(view);
            }
            if (size == 1) {
                h2Var.f832b = Integer.MIN_VALUE;
            }
            h2Var.f833c = Integer.MIN_VALUE;
            removeAndRecycleView(childAt, p1Var);
        }
    }

    public final void z(p1 p1Var, int i2) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.f700c.b(childAt) > i2 || this.f700c.k(childAt) > i2) {
                return;
            }
            e2 e2Var = (e2) childAt.getLayoutParams();
            e2Var.getClass();
            if (e2Var.f779e.f831a.size() == 1) {
                return;
            }
            h2 h2Var = e2Var.f779e;
            ArrayList arrayList = h2Var.f831a;
            View view = (View) arrayList.remove(0);
            e2 e2Var2 = (e2) view.getLayoutParams();
            e2Var2.f779e = null;
            if (arrayList.size() == 0) {
                h2Var.f833c = Integer.MIN_VALUE;
            }
            if (e2Var2.f852a.isRemoved() || e2Var2.f852a.isUpdated()) {
                h2Var.f834d -= h2Var.f836f.f700c.c(view);
            }
            h2Var.f832b = Integer.MIN_VALUE;
            removeAndRecycleView(childAt, p1Var);
        }
    }

    @Override // androidx.recyclerview.widget.h1
    public final i1 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new e2((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new e2(layoutParams);
    }
}
