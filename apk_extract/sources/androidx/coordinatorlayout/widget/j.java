package androidx.coordinatorlayout.widget;

import java.util.Comparator;

/* loaded from: classes.dex */
public final class j implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f97a;

    public /* synthetic */ j(int i2) {
        this.f97a = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
    @Override // java.util.Comparator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int compare(java.lang.Object r6, java.lang.Object r7) {
        /*
            r5 = this;
            int r5 = r5.f97a
            r0 = -1
            r1 = 1
            r2 = 0
            switch(r5) {
                case 0: goto L4d;
                case 1: goto L3c;
                default: goto L8;
            }
        L8:
            androidx.recyclerview.widget.b0 r6 = (androidx.recyclerview.widget.b0) r6
            androidx.recyclerview.widget.b0 r7 = (androidx.recyclerview.widget.b0) r7
            androidx.recyclerview.widget.RecyclerView r5 = r6.f739d
            if (r5 != 0) goto L12
            r3 = r1
            goto L13
        L12:
            r3 = r2
        L13:
            androidx.recyclerview.widget.RecyclerView r4 = r7.f739d
            if (r4 != 0) goto L19
            r4 = r1
            goto L1a
        L19:
            r4 = r2
        L1a:
            if (r3 == r4) goto L21
            if (r5 != 0) goto L1f
        L1e:
            r0 = r1
        L1f:
            r2 = r0
            goto L3b
        L21:
            boolean r5 = r6.f736a
            boolean r3 = r7.f736a
            if (r5 == r3) goto L2a
            if (r5 == 0) goto L1e
            goto L1f
        L2a:
            int r5 = r7.f737b
            int r0 = r6.f737b
            int r5 = r5 - r0
            if (r5 == 0) goto L33
        L31:
            r2 = r5
            goto L3b
        L33:
            int r5 = r6.f738c
            int r6 = r7.f738c
            int r5 = r5 - r6
            if (r5 == 0) goto L3b
            goto L31
        L3b:
            return r2
        L3c:
            androidx.recyclerview.widget.t r6 = (androidx.recyclerview.widget.t) r6
            androidx.recyclerview.widget.t r7 = (androidx.recyclerview.widget.t) r7
            int r5 = r6.f957a
            int r0 = r7.f957a
            int r5 = r5 - r0
            if (r5 != 0) goto L4c
            int r5 = r6.f958b
            int r6 = r7.f958b
            int r5 = r5 - r6
        L4c:
            return r5
        L4d:
            android.view.View r6 = (android.view.View) r6
            android.view.View r7 = (android.view.View) r7
            java.util.WeakHashMap r5 = androidx.core.view.d1.f138a
            float r5 = androidx.core.view.s0.m(r6)
            float r6 = androidx.core.view.s0.m(r7)
            int r7 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r7 <= 0) goto L60
            goto L67
        L60:
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 >= 0) goto L66
            r0 = r1
            goto L67
        L66:
            r0 = r2
        L67:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.j.compare(java.lang.Object, java.lang.Object):int");
    }
}
