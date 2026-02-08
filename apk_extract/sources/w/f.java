package w;

import android.view.View;
import androidx.customview.widget.g;
import androidx.customview.widget.h;
import androidx.drawerlayout.widget.DrawerLayout;

/* loaded from: classes.dex */
public final class f extends g {

    /* renamed from: a, reason: collision with root package name */
    public final int f2613a;

    /* renamed from: b, reason: collision with root package name */
    public h f2614b;

    /* renamed from: c, reason: collision with root package name */
    public final androidx.activity.d f2615c = new androidx.activity.d(3, this);

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DrawerLayout f2616d;

    public f(DrawerLayout drawerLayout, int i2) {
        this.f2616d = drawerLayout;
        this.f2613a = i2;
    }

    @Override // androidx.customview.widget.g
    public final int clampViewPositionHorizontal(View view, int i2, int i3) {
        DrawerLayout drawerLayout = this.f2616d;
        if (drawerLayout.a(3, view)) {
            return Math.max(-view.getWidth(), Math.min(i2, 0));
        }
        int width = drawerLayout.getWidth();
        return Math.max(width - view.getWidth(), Math.min(i2, width));
    }

    @Override // androidx.customview.widget.g
    public final int clampViewPositionVertical(View view, int i2, int i3) {
        return view.getTop();
    }

    @Override // androidx.customview.widget.g
    public final int getViewHorizontalDragRange(View view) {
        this.f2616d.getClass();
        if (DrawerLayout.m(view)) {
            return view.getWidth();
        }
        return 0;
    }

    @Override // androidx.customview.widget.g
    public final void onEdgeDragStarted(int i2, int i3) {
        int i4 = i2 & 1;
        DrawerLayout drawerLayout = this.f2616d;
        View viewD = i4 == 1 ? drawerLayout.d(3) : drawerLayout.d(5);
        if (viewD == null || drawerLayout.h(viewD) != 0) {
            return;
        }
        this.f2614b.b(i3, viewD);
    }

    @Override // androidx.customview.widget.g
    public final boolean onEdgeLock(int i2) {
        return false;
    }

    @Override // androidx.customview.widget.g
    public final void onEdgeTouched(int i2, int i3) {
        this.f2616d.postDelayed(this.f2615c, 160L);
    }

    @Override // androidx.customview.widget.g
    public final void onViewCaptured(View view, int i2) {
        ((d) view.getLayoutParams()).f2606c = false;
        int i3 = this.f2613a == 3 ? 5 : 3;
        DrawerLayout drawerLayout = this.f2616d;
        View viewD = drawerLayout.d(i3);
        if (viewD != null) {
            drawerLayout.b(viewD);
        }
    }

    @Override // androidx.customview.widget.g
    public final void onViewDragStateChanged(int i2) {
        this.f2616d.t(i2, this.f2614b.f286t);
    }

    @Override // androidx.customview.widget.g
    public final void onViewPositionChanged(View view, int i2, int i3, int i4, int i5) {
        int width = view.getWidth();
        DrawerLayout drawerLayout = this.f2616d;
        float width2 = (drawerLayout.a(3, view) ? i2 + width : drawerLayout.getWidth() - i2) / width;
        drawerLayout.q(view, width2);
        view.setVisibility(width2 == 0.0f ? 4 : 0);
        drawerLayout.invalidate();
    }

    @Override // androidx.customview.widget.g
    public final void onViewReleased(View view, float f2, float f3) {
        int i2;
        DrawerLayout drawerLayout = this.f2616d;
        drawerLayout.getClass();
        float f4 = ((d) view.getLayoutParams()).f2605b;
        int width = view.getWidth();
        if (drawerLayout.a(3, view)) {
            i2 = (f2 > 0.0f || (f2 == 0.0f && f4 > 0.5f)) ? 0 : -width;
        } else {
            int width2 = drawerLayout.getWidth();
            if (f2 < 0.0f || (f2 == 0.0f && f4 > 0.5f)) {
                width2 -= width;
            }
            i2 = width2;
        }
        this.f2614b.r(i2, view.getTop());
        drawerLayout.invalidate();
    }

    @Override // androidx.customview.widget.g
    public final boolean tryCaptureView(View view, int i2) {
        DrawerLayout drawerLayout = this.f2616d;
        drawerLayout.getClass();
        return DrawerLayout.m(view) && drawerLayout.a(this.f2613a, view) && drawerLayout.h(view) == 0;
    }
}
