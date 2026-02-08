package r;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* loaded from: classes.dex */
public abstract class h extends AccessibilityNodeProvider {

    /* renamed from: a, reason: collision with root package name */
    public final k f2510a;

    public h(k kVar) {
        this.f2510a = kVar;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i2) {
        g gVarA = this.f2510a.a(i2);
        if (gVarA == null) {
            return null;
        }
        return gVarA.f2507a;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final List findAccessibilityNodeInfosByText(String str, int i2) {
        this.f2510a.getClass();
        return null;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int i2, int i3, Bundle bundle) {
        return this.f2510a.c(i2, i3, bundle);
    }
}
