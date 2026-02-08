package u;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ScrollView;
import androidx.core.view.d1;
import androidx.core.view.m0;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class i extends androidx.core.view.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2586a;

    public /* synthetic */ i(int i2) {
        this.f2586a = i2;
    }

    @Override // androidx.core.view.c
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f2586a) {
            case 0:
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                NestedScrollView nestedScrollView = (NestedScrollView) view;
                accessibilityEvent.setClassName(ScrollView.class.getName());
                accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
                accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
                accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
                r.l.c(accessibilityEvent, nestedScrollView.getScrollX());
                r.l.d(accessibilityEvent, nestedScrollView.getScrollRange());
                break;
            default:
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                break;
        }
    }

    @Override // androidx.core.view.c
    public final void onInitializeAccessibilityNodeInfo(View view, r.g gVar) {
        int scrollRange;
        switch (this.f2586a) {
            case 0:
                super.onInitializeAccessibilityNodeInfo(view, gVar);
                NestedScrollView nestedScrollView = (NestedScrollView) view;
                gVar.f(ScrollView.class.getName());
                if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                    gVar.f2507a.setScrollable(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        gVar.b(r.f.f2496i);
                        gVar.b(r.f.f2500m);
                    }
                    if (nestedScrollView.getScrollY() < scrollRange) {
                        gVar.b(r.f.f2495h);
                        gVar.b(r.f.f2501n);
                        break;
                    }
                }
                break;
            default:
                super.onInitializeAccessibilityNodeInfo(view, gVar);
                int[] iArr = DrawerLayout.C;
                WeakHashMap weakHashMap = d1.f138a;
                if (m0.c(view) == 4 || m0.c(view) == 2) {
                    gVar.f2508b = -1;
                    gVar.f2507a.setParent(null);
                    break;
                }
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0076  */
    @Override // androidx.core.view.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean performAccessibilityAction(android.view.View r4, int r5, android.os.Bundle r6) {
        /*
            r3 = this;
            int r0 = r3.f2586a
            switch(r0) {
                case 0: goto La;
                default: goto L5;
            }
        L5:
            boolean r3 = super.performAccessibilityAction(r4, r5, r6)
            return r3
        La:
            boolean r3 = super.performAccessibilityAction(r4, r5, r6)
            r6 = 1
            if (r3 == 0) goto L13
            goto La0
        L13:
            androidx.core.widget.NestedScrollView r4 = (androidx.core.widget.NestedScrollView) r4
            boolean r3 = r4.isEnabled()
            r0 = 0
            if (r3 != 0) goto L1f
        L1c:
            r6 = r0
            goto La0
        L1f:
            int r3 = r4.getHeight()
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            android.graphics.Matrix r2 = r4.getMatrix()
            boolean r2 = r2.isIdentity()
            if (r2 == 0) goto L3c
            boolean r2 = r4.getGlobalVisibleRect(r1)
            if (r2 == 0) goto L3c
            int r3 = r1.height()
        L3c:
            r1 = 4096(0x1000, float:5.74E-42)
            if (r5 == r1) goto L76
            r1 = 8192(0x2000, float:1.148E-41)
            if (r5 == r1) goto L4f
            r1 = 16908344(0x1020038, float:2.3877386E-38)
            if (r5 == r1) goto L4f
            r1 = 16908346(0x102003a, float:2.3877392E-38)
            if (r5 == r1) goto L76
            goto L1c
        L4f:
            int r5 = r4.getPaddingBottom()
            int r3 = r3 - r5
            int r5 = r4.getPaddingTop()
            int r3 = r3 - r5
            int r5 = r4.getScrollY()
            int r5 = r5 - r3
            int r3 = java.lang.Math.max(r5, r0)
            int r5 = r4.getScrollY()
            if (r3 == r5) goto L1c
            int r5 = r4.getScrollX()
            int r0 = r0 - r5
            int r5 = r4.getScrollY()
            int r3 = r3 - r5
            r4.m(r0, r3, r6)
            goto La0
        L76:
            int r5 = r4.getPaddingBottom()
            int r3 = r3 - r5
            int r5 = r4.getPaddingTop()
            int r3 = r3 - r5
            int r5 = r4.getScrollY()
            int r5 = r5 + r3
            int r3 = r4.getScrollRange()
            int r3 = java.lang.Math.min(r5, r3)
            int r5 = r4.getScrollY()
            if (r3 == r5) goto L1c
            int r5 = r4.getScrollX()
            int r0 = r0 - r5
            int r5 = r4.getScrollY()
            int r3 = r3 - r5
            r4.m(r0, r3, r6)
        La0:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: u.i.performAccessibilityAction(android.view.View, int, android.os.Bundle):boolean");
    }
}
