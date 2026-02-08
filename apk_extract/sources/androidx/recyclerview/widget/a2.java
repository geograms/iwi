package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class a2 extends androidx.core.view.c {

    /* renamed from: a, reason: collision with root package name */
    public final b2 f728a;

    /* renamed from: b, reason: collision with root package name */
    public final WeakHashMap f729b = new WeakHashMap();

    public a2(b2 b2Var) {
        this.f728a = b2Var;
    }

    @Override // androidx.core.view.c
    public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        androidx.core.view.c cVar = (androidx.core.view.c) this.f729b.get(view);
        return cVar != null ? cVar.dispatchPopulateAccessibilityEvent(view, accessibilityEvent) : super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // androidx.core.view.c
    public final r.k getAccessibilityNodeProvider(View view) {
        androidx.core.view.c cVar = (androidx.core.view.c) this.f729b.get(view);
        return cVar != null ? cVar.getAccessibilityNodeProvider(view) : super.getAccessibilityNodeProvider(view);
    }

    @Override // androidx.core.view.c
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        androidx.core.view.c cVar = (androidx.core.view.c) this.f729b.get(view);
        if (cVar != null) {
            cVar.onInitializeAccessibilityEvent(view, accessibilityEvent);
        } else {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }
    }

    @Override // androidx.core.view.c
    public final void onInitializeAccessibilityNodeInfo(View view, r.g gVar) {
        b2 b2Var = this.f728a;
        if (b2Var.shouldIgnore() || b2Var.mRecyclerView.getLayoutManager() == null) {
            super.onInitializeAccessibilityNodeInfo(view, gVar);
            return;
        }
        b2Var.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, gVar);
        androidx.core.view.c cVar = (androidx.core.view.c) this.f729b.get(view);
        if (cVar != null) {
            cVar.onInitializeAccessibilityNodeInfo(view, gVar);
        } else {
            super.onInitializeAccessibilityNodeInfo(view, gVar);
        }
    }

    @Override // androidx.core.view.c
    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        androidx.core.view.c cVar = (androidx.core.view.c) this.f729b.get(view);
        if (cVar != null) {
            cVar.onPopulateAccessibilityEvent(view, accessibilityEvent);
        } else {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }
    }

    @Override // androidx.core.view.c
    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        androidx.core.view.c cVar = (androidx.core.view.c) this.f729b.get(viewGroup);
        return cVar != null ? cVar.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent) : super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    @Override // androidx.core.view.c
    public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
        b2 b2Var = this.f728a;
        if (b2Var.shouldIgnore() || b2Var.mRecyclerView.getLayoutManager() == null) {
            return super.performAccessibilityAction(view, i2, bundle);
        }
        androidx.core.view.c cVar = (androidx.core.view.c) this.f729b.get(view);
        if (cVar != null) {
            if (cVar.performAccessibilityAction(view, i2, bundle)) {
                return true;
            }
        } else if (super.performAccessibilityAction(view, i2, bundle)) {
            return true;
        }
        return b2Var.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(view, i2, bundle);
    }

    @Override // androidx.core.view.c
    public final void sendAccessibilityEvent(View view, int i2) {
        androidx.core.view.c cVar = (androidx.core.view.c) this.f729b.get(view);
        if (cVar != null) {
            cVar.sendAccessibilityEvent(view, i2);
        } else {
            super.sendAccessibilityEvent(view, i2);
        }
    }

    @Override // androidx.core.view.c
    public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        androidx.core.view.c cVar = (androidx.core.view.c) this.f729b.get(view);
        if (cVar != null) {
            cVar.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        } else {
            super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }
    }
}
