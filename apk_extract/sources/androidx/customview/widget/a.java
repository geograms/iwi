package androidx.customview.widget;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import r.k;

/* loaded from: classes.dex */
public final class a extends k {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f260b;

    public a(b bVar) {
        this.f260b = bVar;
    }

    @Override // r.k
    public final r.g a(int i2) {
        return new r.g(AccessibilityNodeInfo.obtain(this.f260b.obtainAccessibilityNodeInfo(i2).f2507a));
    }

    @Override // r.k
    public final r.g b(int i2) {
        b bVar = this.f260b;
        int i3 = i2 == 2 ? bVar.mAccessibilityFocusedVirtualViewId : bVar.mKeyboardFocusedVirtualViewId;
        if (i3 == Integer.MIN_VALUE) {
            return null;
        }
        return a(i3);
    }

    @Override // r.k
    public final boolean c(int i2, int i3, Bundle bundle) {
        return this.f260b.performAction(i2, i3, bundle);
    }
}
