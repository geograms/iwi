package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class c0 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public static final ThreadLocal f746e = new ThreadLocal();

    /* renamed from: f, reason: collision with root package name */
    public static final androidx.coordinatorlayout.widget.j f747f = new androidx.coordinatorlayout.widget.j(2);

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f748a;

    /* renamed from: b, reason: collision with root package name */
    public long f749b;

    /* renamed from: c, reason: collision with root package name */
    public long f750c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f751d;

    public static z1 c(RecyclerView recyclerView, int i2, long j2) {
        int iH = recyclerView.mChildHelper.h();
        for (int i3 = 0; i3 < iH; i3++) {
            z1 childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.g(i3));
            if (childViewHolderInt.mPosition == i2 && !childViewHolderInt.isInvalid()) {
                return null;
            }
        }
        p1 p1Var = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            z1 z1VarJ = p1Var.j(i2, j2);
            if (z1VarJ != null) {
                if (!z1VarJ.isBound() || z1VarJ.isInvalid()) {
                    p1Var.a(z1VarJ, false);
                } else {
                    p1Var.g(z1VarJ.itemView);
                }
            }
            recyclerView.onExitLayoutOrScroll(false);
            return z1VarJ;
        } catch (Throwable th) {
            recyclerView.onExitLayoutOrScroll(false);
            throw th;
        }
    }

    public final void a(RecyclerView recyclerView, int i2, int i3) {
        if (recyclerView.isAttachedToWindow() && this.f749b == 0) {
            this.f749b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        a0 a0Var = recyclerView.mPrefetchRegistry;
        a0Var.f724a = i2;
        a0Var.f725b = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(long r16) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.c0.b(long):void");
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            n.e.a("RV Prefetch");
            ArrayList arrayList = this.f748a;
            if (arrayList.isEmpty()) {
                return;
            }
            int size = arrayList.size();
            long jMax = 0;
            for (int i2 = 0; i2 < size; i2++) {
                RecyclerView recyclerView = (RecyclerView) arrayList.get(i2);
                if (recyclerView.getWindowVisibility() == 0) {
                    jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                }
            }
            if (jMax == 0) {
                return;
            }
            b(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f750c);
        } finally {
            this.f749b = 0L;
            n.e.b();
        }
    }
}
