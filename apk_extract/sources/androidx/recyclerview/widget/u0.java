package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: classes.dex */
public final class u0 implements m2, a1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f972a;

    public /* synthetic */ u0(RecyclerView recyclerView) {
        this.f972a = recyclerView;
    }

    public final void a(a aVar) {
        int i2 = aVar.f720a;
        RecyclerView recyclerView = this.f972a;
        if (i2 == 1) {
            recyclerView.mLayout.onItemsAdded(recyclerView, aVar.f721b, aVar.f723d);
            return;
        }
        if (i2 == 2) {
            recyclerView.mLayout.onItemsRemoved(recyclerView, aVar.f721b, aVar.f723d);
        } else if (i2 == 4) {
            recyclerView.mLayout.onItemsUpdated(recyclerView, aVar.f721b, aVar.f723d, aVar.f722c);
        } else {
            if (i2 != 8) {
                return;
            }
            recyclerView.mLayout.onItemsMoved(recyclerView, aVar.f721b, aVar.f723d, 1);
        }
    }

    public final void b(int i2) {
        RecyclerView recyclerView = this.f972a;
        View childAt = recyclerView.getChildAt(i2);
        if (childAt != null) {
            recyclerView.dispatchChildDetached(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeViewAt(i2);
    }
}
