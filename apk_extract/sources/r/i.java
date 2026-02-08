package r;

import android.view.accessibility.AccessibilityNodeInfo;

/* loaded from: classes.dex */
public abstract class i extends h {
    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo findFocus(int i2) {
        g gVarB = this.f2510a.b(i2);
        if (gVarB == null) {
            return null;
        }
        return gVarB.f2507a;
    }
}
