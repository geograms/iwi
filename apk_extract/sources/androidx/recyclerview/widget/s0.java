package androidx.recyclerview.widget;

import android.view.View;
import androidx.appcompat.widget.ActivityChooserView;

/* loaded from: classes.dex */
public final class s0 extends k1 {

    /* renamed from: a, reason: collision with root package name */
    public RecyclerView f952a;

    /* renamed from: b, reason: collision with root package name */
    public final c2 f953b = new c2(this);

    /* renamed from: c, reason: collision with root package name */
    public p0 f954c;

    /* renamed from: d, reason: collision with root package name */
    public p0 f955d;

    public static int b(View view, q0 q0Var) {
        return ((q0Var.c(view) / 2) + q0Var.e(view)) - ((q0Var.i() / 2) + q0Var.h());
    }

    public static View c(h1 h1Var, q0 q0Var) {
        int childCount = h1Var.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int i2 = (q0Var.i() / 2) + q0Var.h();
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = h1Var.getChildAt(i4);
            int iAbs = Math.abs(((q0Var.c(childAt) / 2) + q0Var.e(childAt)) - i2);
            if (iAbs < i3) {
                view = childAt;
                i3 = iAbs;
            }
        }
        return view;
    }

    public final int[] a(h1 h1Var, View view) {
        int[] iArr = new int[2];
        if (h1Var.canScrollHorizontally()) {
            iArr[0] = b(view, d(h1Var));
        } else {
            iArr[0] = 0;
        }
        if (h1Var.canScrollVertically()) {
            iArr[1] = b(view, e(h1Var));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public final q0 d(h1 h1Var) {
        p0 p0Var = this.f955d;
        if (p0Var == null || p0Var.f940a != h1Var) {
            this.f955d = new p0(h1Var, 0);
        }
        return this.f955d;
    }

    public final q0 e(h1 h1Var) {
        p0 p0Var = this.f954c;
        if (p0Var == null || p0Var.f940a != h1Var) {
            this.f954c = new p0(h1Var, 1);
        }
        return this.f954c;
    }

    public final void f() {
        h1 layoutManager;
        RecyclerView recyclerView = this.f952a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return;
        }
        View viewC = layoutManager.canScrollVertically() ? c(layoutManager, e(layoutManager)) : layoutManager.canScrollHorizontally() ? c(layoutManager, d(layoutManager)) : null;
        if (viewC == null) {
            return;
        }
        int[] iArrA = a(layoutManager, viewC);
        int i2 = iArrA[0];
        if (i2 == 0 && iArrA[1] == 0) {
            return;
        }
        this.f952a.smoothScrollBy(i2, iArrA[1]);
    }
}
