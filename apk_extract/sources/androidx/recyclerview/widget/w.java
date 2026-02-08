package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public final class w extends m1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z f975a;

    public w(z zVar) {
        this.f975a = zVar;
    }

    @Override // androidx.recyclerview.widget.m1
    public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        int iComputeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
        int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
        z zVar = this.f975a;
        int iComputeVerticalScrollRange = zVar.f1019s.computeVerticalScrollRange();
        int i4 = zVar.f1018r;
        int i5 = iComputeVerticalScrollRange - i4;
        int i6 = zVar.f1001a;
        zVar.f1020t = i5 > 0 && i4 >= i6;
        int iComputeHorizontalScrollRange = zVar.f1019s.computeHorizontalScrollRange();
        int i7 = zVar.f1017q;
        boolean z2 = iComputeHorizontalScrollRange - i7 > 0 && i7 >= i6;
        zVar.f1021u = z2;
        boolean z3 = zVar.f1020t;
        if (!z3 && !z2) {
            if (zVar.f1022v != 0) {
                zVar.d(0);
                return;
            }
            return;
        }
        if (z3) {
            float f2 = i4;
            zVar.f1012l = (int) ((((f2 / 2.0f) + iComputeVerticalScrollOffset) * f2) / iComputeVerticalScrollRange);
            zVar.f1011k = Math.min(i4, (i4 * i4) / iComputeVerticalScrollRange);
        }
        if (zVar.f1021u) {
            float f3 = iComputeHorizontalScrollOffset;
            float f4 = i7;
            zVar.f1015o = (int) ((((f4 / 2.0f) + f3) * f4) / iComputeHorizontalScrollRange);
            zVar.f1014n = Math.min(i7, (i7 * i7) / iComputeHorizontalScrollRange);
        }
        int i8 = zVar.f1022v;
        if (i8 == 0 || i8 == 1) {
            zVar.d(1);
        }
    }
}
