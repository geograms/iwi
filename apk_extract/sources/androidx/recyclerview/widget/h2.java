package androidx.recyclerview.widget;

import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class h2 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f831a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public int f832b = Integer.MIN_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public int f833c = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    public int f834d = 0;

    /* renamed from: e, reason: collision with root package name */
    public final int f835e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ StaggeredGridLayoutManager f836f;

    public h2(StaggeredGridLayoutManager staggeredGridLayoutManager, int i2) {
        this.f836f = staggeredGridLayoutManager;
        this.f835e = i2;
    }

    public final void a() {
        View view = (View) this.f831a.get(r0.size() - 1);
        e2 e2Var = (e2) view.getLayoutParams();
        this.f833c = this.f836f.f700c.b(view);
        e2Var.getClass();
    }

    public final void b() {
        this.f831a.clear();
        this.f832b = Integer.MIN_VALUE;
        this.f833c = Integer.MIN_VALUE;
        this.f834d = 0;
    }

    public final int c() {
        return this.f836f.f705h ? e(r1.size() - 1, -1) : e(0, this.f831a.size());
    }

    public final int d() {
        return this.f836f.f705h ? e(0, this.f831a.size()) : e(r1.size() - 1, -1);
    }

    public final int e(int i2, int i3) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f836f;
        int iH = staggeredGridLayoutManager.f700c.h();
        int iF = staggeredGridLayoutManager.f700c.f();
        int i4 = i3 > i2 ? 1 : -1;
        while (i2 != i3) {
            View view = (View) this.f831a.get(i2);
            int iE = staggeredGridLayoutManager.f700c.e(view);
            int iB = staggeredGridLayoutManager.f700c.b(view);
            boolean z2 = iE <= iF;
            boolean z3 = iB >= iH;
            if (z2 && z3 && (iE < iH || iB > iF)) {
                return staggeredGridLayoutManager.getPosition(view);
            }
            i2 += i4;
        }
        return -1;
    }

    public final int f(int i2) {
        int i3 = this.f833c;
        if (i3 != Integer.MIN_VALUE) {
            return i3;
        }
        if (this.f831a.size() == 0) {
            return i2;
        }
        a();
        return this.f833c;
    }

    public final View g(int i2, int i3) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f836f;
        ArrayList arrayList = this.f831a;
        View view = null;
        if (i3 != -1) {
            int size = arrayList.size() - 1;
            while (size >= 0) {
                View view2 = (View) arrayList.get(size);
                if ((staggeredGridLayoutManager.f705h && staggeredGridLayoutManager.getPosition(view2) >= i2) || ((!staggeredGridLayoutManager.f705h && staggeredGridLayoutManager.getPosition(view2) <= i2) || !view2.hasFocusable())) {
                    break;
                }
                size--;
                view = view2;
            }
        } else {
            int size2 = arrayList.size();
            int i4 = 0;
            while (i4 < size2) {
                View view3 = (View) arrayList.get(i4);
                if ((staggeredGridLayoutManager.f705h && staggeredGridLayoutManager.getPosition(view3) <= i2) || ((!staggeredGridLayoutManager.f705h && staggeredGridLayoutManager.getPosition(view3) >= i2) || !view3.hasFocusable())) {
                    break;
                }
                i4++;
                view = view3;
            }
        }
        return view;
    }

    public final int h(int i2) {
        int i3 = this.f832b;
        if (i3 != Integer.MIN_VALUE) {
            return i3;
        }
        if (this.f831a.size() == 0) {
            return i2;
        }
        View view = (View) this.f831a.get(0);
        e2 e2Var = (e2) view.getLayoutParams();
        this.f832b = this.f836f.f700c.e(view);
        e2Var.getClass();
        return this.f832b;
    }
}
