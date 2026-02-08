package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class r1 extends x0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f947a;

    public r1(RecyclerView recyclerView) {
        this.f947a = recyclerView;
    }

    public final void a() {
        boolean z2 = RecyclerView.POST_UPDATES_ON_ANIMATION;
        RecyclerView recyclerView = this.f947a;
        if (!z2 || !recyclerView.mHasFixedSize || !recyclerView.mIsAttached) {
            recyclerView.mAdapterUpdateDuringMeasure = true;
            recyclerView.requestLayout();
        } else {
            Runnable runnable = recyclerView.mUpdateChildViewsRunnable;
            WeakHashMap weakHashMap = androidx.core.view.d1.f138a;
            androidx.core.view.m0.m(recyclerView, runnable);
        }
    }

    @Override // androidx.recyclerview.widget.x0
    public final void onChanged() {
        RecyclerView recyclerView = this.f947a;
        recyclerView.assertNotInLayoutOrScroll(null);
        recyclerView.mState.f981f = true;
        recyclerView.processDataSetCompletelyChanged(true);
        if (recyclerView.mAdapterHelper.g()) {
            return;
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.x0
    public final void onItemRangeChanged(int i2, int i3, Object obj) {
        RecyclerView recyclerView = this.f947a;
        recyclerView.assertNotInLayoutOrScroll(null);
        b bVar = recyclerView.mAdapterHelper;
        if (i3 < 1) {
            bVar.getClass();
            return;
        }
        ArrayList arrayList = bVar.f731b;
        arrayList.add(bVar.h(obj, 4, i2, i3));
        bVar.f735f |= 4;
        if (arrayList.size() == 1) {
            a();
        }
    }

    @Override // androidx.recyclerview.widget.x0
    public final void onItemRangeInserted(int i2, int i3) {
        RecyclerView recyclerView = this.f947a;
        recyclerView.assertNotInLayoutOrScroll(null);
        b bVar = recyclerView.mAdapterHelper;
        if (i3 < 1) {
            bVar.getClass();
            return;
        }
        ArrayList arrayList = bVar.f731b;
        arrayList.add(bVar.h(null, 1, i2, i3));
        bVar.f735f |= 1;
        if (arrayList.size() == 1) {
            a();
        }
    }

    @Override // androidx.recyclerview.widget.x0
    public final void onItemRangeMoved(int i2, int i3, int i4) {
        RecyclerView recyclerView = this.f947a;
        recyclerView.assertNotInLayoutOrScroll(null);
        b bVar = recyclerView.mAdapterHelper;
        bVar.getClass();
        if (i2 == i3) {
            return;
        }
        ArrayList arrayList = bVar.f731b;
        arrayList.add(bVar.h(null, 8, i2, i3));
        bVar.f735f |= 8;
        if (arrayList.size() == 1) {
            a();
        }
    }

    @Override // androidx.recyclerview.widget.x0
    public final void onItemRangeRemoved(int i2, int i3) {
        RecyclerView recyclerView = this.f947a;
        recyclerView.assertNotInLayoutOrScroll(null);
        b bVar = recyclerView.mAdapterHelper;
        if (i3 < 1) {
            bVar.getClass();
            return;
        }
        ArrayList arrayList = bVar.f731b;
        arrayList.add(bVar.h(null, 2, i2, i3));
        bVar.f735f |= 2;
        if (arrayList.size() == 1) {
            a();
        }
    }
}
