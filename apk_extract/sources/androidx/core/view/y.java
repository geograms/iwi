package androidx.core.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public ViewParent f221a;

    /* renamed from: b, reason: collision with root package name */
    public ViewParent f222b;

    /* renamed from: c, reason: collision with root package name */
    public final View f223c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f224d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f225e;

    public y(View view) {
        this.f223c = view;
    }

    public final boolean a(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        ViewParent viewParentC;
        int i5;
        int i6;
        int[] iArr3;
        if (!this.f224d || (viewParentC = c(i4)) == null) {
            return false;
        }
        if (i2 == 0 && i3 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        View view = this.f223c;
        if (iArr2 != null) {
            view.getLocationInWindow(iArr2);
            i5 = iArr2[0];
            i6 = iArr2[1];
        } else {
            i5 = 0;
            i6 = 0;
        }
        if (iArr == null) {
            if (this.f225e == null) {
                this.f225e = new int[2];
            }
            iArr3 = this.f225e;
        } else {
            iArr3 = iArr;
        }
        iArr3[0] = 0;
        iArr3[1] = 0;
        x0.g.i0(viewParentC, this.f223c, i2, i3, iArr3, i4);
        if (iArr2 != null) {
            view.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i5;
            iArr2[1] = iArr2[1] - i6;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }

    public final boolean b(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        ViewParent viewParentC;
        int i7;
        int i8;
        int[] iArr3;
        if (!this.f224d || (viewParentC = c(i6)) == null) {
            return false;
        }
        if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        View view = this.f223c;
        if (iArr != null) {
            view.getLocationInWindow(iArr);
            i7 = iArr[0];
            i8 = iArr[1];
        } else {
            i7 = 0;
            i8 = 0;
        }
        if (iArr2 == null) {
            if (this.f225e == null) {
                this.f225e = new int[2];
            }
            int[] iArr4 = this.f225e;
            iArr4[0] = 0;
            iArr4[1] = 0;
            iArr3 = iArr4;
        } else {
            iArr3 = iArr2;
        }
        x0.g.j0(viewParentC, this.f223c, i2, i3, i4, i5, i6, iArr3);
        if (iArr != null) {
            view.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i7;
            iArr[1] = iArr[1] - i8;
        }
        return true;
    }

    public final ViewParent c(int i2) {
        if (i2 == 0) {
            return this.f221a;
        }
        if (i2 != 1) {
            return null;
        }
        return this.f222b;
    }

    public final boolean d(int i2) {
        return c(i2) != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0077 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(int r9, int r10) {
        /*
            r8 = this;
            boolean r0 = r8.d(r10)
            r1 = 1
            if (r0 == 0) goto L8
            return r1
        L8:
            boolean r0 = r8.f224d
            if (r0 == 0) goto L7c
            android.view.View r0 = r8.f223c
            android.view.ViewParent r2 = r0.getParent()
            r3 = r0
        L13:
            if (r2 == 0) goto L7c
            boolean r4 = r2 instanceof androidx.core.view.z
            java.lang.String r5 = "ViewParentCompat"
            java.lang.String r6 = "ViewParent "
            if (r4 == 0) goto L25
            r7 = r2
            androidx.core.view.z r7 = (androidx.core.view.z) r7
            boolean r7 = r7.onStartNestedScroll(r3, r0, r9, r10)
            goto L2b
        L25:
            if (r10 != 0) goto L70
            boolean r7 = androidx.core.view.h1.f(r2, r3, r0, r9)     // Catch: java.lang.AbstractMethodError -> L5b
        L2b:
            if (r7 == 0) goto L70
            if (r10 == 0) goto L35
            if (r10 == r1) goto L32
            goto L37
        L32:
            r8.f222b = r2
            goto L37
        L35:
            r8.f221a = r2
        L37:
            if (r4 == 0) goto L3f
            androidx.core.view.z r2 = (androidx.core.view.z) r2
            r2.onNestedScrollAccepted(r3, r0, r9, r10)
            goto L5a
        L3f:
            if (r10 != 0) goto L5a
            androidx.core.view.h1.e(r2, r3, r0, r9)     // Catch: java.lang.AbstractMethodError -> L45
            goto L5a
        L45:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r6)
            r9.append(r2)
            java.lang.String r10 = " does not implement interface method onNestedScrollAccepted"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            android.util.Log.e(r5, r9, r8)
        L5a:
            return r1
        L5b:
            r4 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r6)
            r7.append(r2)
            java.lang.String r6 = " does not implement interface method onStartNestedScroll"
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            android.util.Log.e(r5, r6, r4)
        L70:
            boolean r4 = r2 instanceof android.view.View
            if (r4 == 0) goto L77
            r3 = r2
            android.view.View r3 = (android.view.View) r3
        L77:
            android.view.ViewParent r2 = r2.getParent()
            goto L13
        L7c:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.y.e(int, int):boolean");
    }

    public final void f(int i2) {
        ViewParent viewParentC = c(i2);
        if (viewParentC != null) {
            boolean z2 = viewParentC instanceof z;
            View view = this.f223c;
            if (z2) {
                ((z) viewParentC).onStopNestedScroll(view, i2);
            } else if (i2 == 0) {
                try {
                    h1.g(viewParentC, view);
                } catch (AbstractMethodError e2) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParentC + " does not implement interface method onStopNestedScroll", e2);
                }
            }
            if (i2 == 0) {
                this.f221a = null;
            } else {
                if (i2 != 1) {
                    return;
                }
                this.f222b = null;
            }
        }
    }
}
