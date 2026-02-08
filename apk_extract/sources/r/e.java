package r;

import android.view.accessibility.AccessibilityManager;

/* loaded from: classes.dex */
public final class e implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final d f2491a;

    public e(d dVar) {
        this.f2491a = dVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            return this.f2491a.equals(((e) obj).f2491a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2491a.hashCode();
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z2) {
        this.f2491a.onTouchExplorationStateChanged(z2);
    }
}
