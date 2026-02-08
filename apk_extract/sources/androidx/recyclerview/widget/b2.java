package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes.dex */
public class b2 extends androidx.core.view.c {
    private final a2 mItemDelegate;
    final RecyclerView mRecyclerView;

    public b2(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        androidx.core.view.c itemDelegate = getItemDelegate();
        if (itemDelegate == null || !(itemDelegate instanceof a2)) {
            this.mItemDelegate = new a2(this);
        } else {
            this.mItemDelegate = (a2) itemDelegate;
        }
    }

    public androidx.core.view.c getItemDelegate() {
        return this.mItemDelegate;
    }

    @Override // androidx.core.view.c
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || shouldIgnore()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    @Override // androidx.core.view.c
    public void onInitializeAccessibilityNodeInfo(View view, r.g gVar) {
        super.onInitializeAccessibilityNodeInfo(view, gVar);
        if (shouldIgnore() || this.mRecyclerView.getLayoutManager() == null) {
            return;
        }
        this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(gVar);
    }

    @Override // androidx.core.view.c
    public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
        if (super.performAccessibilityAction(view, i2, bundle)) {
            return true;
        }
        if (shouldIgnore() || this.mRecyclerView.getLayoutManager() == null) {
            return false;
        }
        return this.mRecyclerView.getLayoutManager().performAccessibilityAction(i2, bundle);
    }

    public boolean shouldIgnore() {
        return this.mRecyclerView.hasPendingAdapterUpdates();
    }
}
