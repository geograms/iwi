package w;

import android.graphics.Rect;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.d1;
import androidx.core.view.n0;
import androidx.drawerlayout.widget.DrawerLayout;
import java.util.WeakHashMap;
import r.g;

/* loaded from: classes.dex */
public final class b extends androidx.core.view.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DrawerLayout f2603a;

    public b(DrawerLayout drawerLayout) {
        this.f2603a = drawerLayout;
        new Rect();
    }

    @Override // androidx.core.view.c
    public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }
        accessibilityEvent.getText();
        DrawerLayout drawerLayout = this.f2603a;
        View viewF = drawerLayout.f();
        if (viewF == null) {
            return true;
        }
        int i2 = drawerLayout.i(viewF);
        drawerLayout.getClass();
        WeakHashMap weakHashMap = d1.f138a;
        Gravity.getAbsoluteGravity(i2, n0.d(drawerLayout));
        return true;
    }

    @Override // androidx.core.view.c
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
    }

    @Override // androidx.core.view.c
    public final void onInitializeAccessibilityNodeInfo(View view, g gVar) {
        int[] iArr = DrawerLayout.C;
        super.onInitializeAccessibilityNodeInfo(view, gVar);
        gVar.f("androidx.drawerlayout.widget.DrawerLayout");
        AccessibilityNodeInfo accessibilityNodeInfo = gVar.f2507a;
        accessibilityNodeInfo.setFocusable(false);
        accessibilityNodeInfo.setFocused(false);
        accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) r.f.f2492e.f2503a);
        accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) r.f.f2493f.f2503a);
    }

    @Override // androidx.core.view.c
    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        int[] iArr = DrawerLayout.C;
        return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }
}
