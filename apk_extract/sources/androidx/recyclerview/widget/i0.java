package androidx.recyclerview.widget;

import android.view.View;
import androidx.appcompat.widget.ActivityChooserView;
import java.util.List;

/* loaded from: classes.dex */
public final class i0 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f840a;

    /* renamed from: b, reason: collision with root package name */
    public int f841b;

    /* renamed from: c, reason: collision with root package name */
    public int f842c;

    /* renamed from: d, reason: collision with root package name */
    public int f843d;

    /* renamed from: e, reason: collision with root package name */
    public int f844e;

    /* renamed from: f, reason: collision with root package name */
    public int f845f;

    /* renamed from: g, reason: collision with root package name */
    public int f846g;

    /* renamed from: h, reason: collision with root package name */
    public int f847h;

    /* renamed from: i, reason: collision with root package name */
    public int f848i;

    /* renamed from: j, reason: collision with root package name */
    public int f849j;

    /* renamed from: k, reason: collision with root package name */
    public List f850k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f851l;

    public final void a(View view) {
        int layoutPosition;
        int size = this.f850k.size();
        View view2 = null;
        int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        for (int i3 = 0; i3 < size; i3++) {
            View view3 = ((z1) this.f850k.get(i3)).itemView;
            i1 i1Var = (i1) view3.getLayoutParams();
            if (view3 != view && !i1Var.f852a.isRemoved() && (layoutPosition = (i1Var.f852a.getLayoutPosition() - this.f843d) * this.f844e) >= 0 && layoutPosition < i2) {
                view2 = view3;
                if (layoutPosition == 0) {
                    break;
                } else {
                    i2 = layoutPosition;
                }
            }
        }
        if (view2 == null) {
            this.f843d = -1;
        } else {
            this.f843d = ((i1) view2.getLayoutParams()).f852a.getLayoutPosition();
        }
    }

    public final View b(p1 p1Var) {
        List list = this.f850k;
        if (list == null) {
            View view = p1Var.j(this.f843d, Long.MAX_VALUE).itemView;
            this.f843d += this.f844e;
            return view;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = ((z1) this.f850k.get(i2)).itemView;
            i1 i1Var = (i1) view2.getLayoutParams();
            if (!i1Var.f852a.isRemoved() && this.f843d == i1Var.f852a.getLayoutPosition()) {
                a(view2);
                return view2;
            }
        }
        return null;
    }
}
