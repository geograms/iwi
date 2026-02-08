package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.d1;
import androidx.core.view.m0;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import r.k;
import r.m;

/* loaded from: classes.dex */
public abstract class b extends androidx.core.view.c {
    private static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private static final Rect INVALID_PARENT_BOUNDS = new Rect(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final c NODE_ADAPTER = new c.c(3);
    private static final d SPARSE_VALUES_ADAPTER = new c.c(4);
    private final View mHost;
    private final AccessibilityManager mManager;
    private a mNodeProvider;
    private final Rect mTempScreenRect = new Rect();
    private final Rect mTempParentRect = new Rect();
    private final Rect mTempVisibleRect = new Rect();
    private final int[] mTempGlobalRect = new int[2];
    int mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
    int mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
    private int mHoveredVirtualViewId = Integer.MIN_VALUE;

    public b(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.mHost = view;
        this.mManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        WeakHashMap weakHashMap = d1.f138a;
        if (m0.c(view) == 0) {
            m0.s(view, 1);
        }
    }

    public final AccessibilityEvent a(int i2, int i3) {
        if (i2 == -1) {
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i3);
            this.mHost.onInitializeAccessibilityEvent(accessibilityEventObtain);
            return accessibilityEventObtain;
        }
        AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain(i3);
        r.g gVarObtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(i2);
        accessibilityEventObtain2.getText().add(gVarObtainAccessibilityNodeInfo.e());
        AccessibilityNodeInfo accessibilityNodeInfo = gVarObtainAccessibilityNodeInfo.f2507a;
        accessibilityEventObtain2.setContentDescription(accessibilityNodeInfo.getContentDescription());
        accessibilityEventObtain2.setScrollable(accessibilityNodeInfo.isScrollable());
        accessibilityEventObtain2.setPassword(accessibilityNodeInfo.isPassword());
        accessibilityEventObtain2.setEnabled(accessibilityNodeInfo.isEnabled());
        accessibilityEventObtain2.setChecked(accessibilityNodeInfo.isChecked());
        onPopulateEventForVirtualView(i2, accessibilityEventObtain2);
        if (accessibilityEventObtain2.getText().isEmpty() && accessibilityEventObtain2.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        accessibilityEventObtain2.setClassName(accessibilityNodeInfo.getClassName());
        m.a(accessibilityEventObtain2, this.mHost, i2);
        accessibilityEventObtain2.setPackageName(this.mHost.getContext().getPackageName());
        return accessibilityEventObtain2;
    }

    public final r.g b(int i2) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
        r.g gVar = new r.g(accessibilityNodeInfoObtain);
        accessibilityNodeInfoObtain.setEnabled(true);
        accessibilityNodeInfoObtain.setFocusable(true);
        gVar.f(DEFAULT_CLASS_NAME);
        Rect rect = INVALID_PARENT_BOUNDS;
        accessibilityNodeInfoObtain.setBoundsInParent(rect);
        accessibilityNodeInfoObtain.setBoundsInScreen(rect);
        View view = this.mHost;
        gVar.f2508b = -1;
        accessibilityNodeInfoObtain.setParent(view);
        onPopulateNodeForVirtualView(i2, gVar);
        if (gVar.e() == null && accessibilityNodeInfoObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        gVar.d(this.mTempParentRect);
        if (this.mTempParentRect.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = accessibilityNodeInfoObtain.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((actions & Optimizer.OPTIMIZATION_GRAPH_WRAP) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        accessibilityNodeInfoObtain.setPackageName(this.mHost.getContext().getPackageName());
        View view2 = this.mHost;
        gVar.f2509c = i2;
        accessibilityNodeInfoObtain.setSource(view2, i2);
        if (this.mAccessibilityFocusedVirtualViewId == i2) {
            accessibilityNodeInfoObtain.setAccessibilityFocused(true);
            gVar.a(Optimizer.OPTIMIZATION_GRAPH_WRAP);
        } else {
            accessibilityNodeInfoObtain.setAccessibilityFocused(false);
            gVar.a(64);
        }
        boolean z2 = this.mKeyboardFocusedVirtualViewId == i2;
        if (z2) {
            gVar.a(2);
        } else if (accessibilityNodeInfoObtain.isFocusable()) {
            gVar.a(1);
        }
        accessibilityNodeInfoObtain.setFocused(z2);
        this.mHost.getLocationOnScreen(this.mTempGlobalRect);
        accessibilityNodeInfoObtain.getBoundsInScreen(this.mTempScreenRect);
        if (this.mTempScreenRect.equals(rect)) {
            gVar.d(this.mTempScreenRect);
            if (gVar.f2508b != -1) {
                r.g gVar2 = new r.g(AccessibilityNodeInfo.obtain());
                int i3 = gVar.f2508b;
                while (true) {
                    accessibilityNodeInfo = gVar2.f2507a;
                    if (i3 == -1) {
                        break;
                    }
                    View view3 = this.mHost;
                    gVar2.f2508b = -1;
                    accessibilityNodeInfo.setParent(view3, -1);
                    accessibilityNodeInfo.setBoundsInParent(INVALID_PARENT_BOUNDS);
                    onPopulateNodeForVirtualView(i3, gVar2);
                    gVar2.d(this.mTempParentRect);
                    Rect rect2 = this.mTempScreenRect;
                    Rect rect3 = this.mTempParentRect;
                    rect2.offset(rect3.left, rect3.top);
                    i3 = gVar2.f2508b;
                }
                accessibilityNodeInfo.recycle();
            }
            this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
        }
        if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
            this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
            if (this.mTempScreenRect.intersect(this.mTempVisibleRect)) {
                Rect rect4 = this.mTempScreenRect;
                AccessibilityNodeInfo accessibilityNodeInfo2 = gVar.f2507a;
                accessibilityNodeInfo2.setBoundsInScreen(rect4);
                Rect rect5 = this.mTempScreenRect;
                if (rect5 != null && !rect5.isEmpty() && this.mHost.getWindowVisibility() == 0) {
                    Object parent = this.mHost.getParent();
                    while (true) {
                        if (parent instanceof View) {
                            View view4 = (View) parent;
                            if (view4.getAlpha() <= 0.0f || view4.getVisibility() != 0) {
                                break;
                            }
                            parent = view4.getParent();
                        } else if (parent != null) {
                            accessibilityNodeInfo2.setVisibleToUser(true);
                        }
                    }
                }
            }
        }
        return gVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0199  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(int r19, android.graphics.Rect r20) {
        /*
            Method dump skipped, instructions count: 471
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.b.c(int, android.graphics.Rect):boolean");
    }

    public final boolean clearKeyboardFocusForVirtualView(int i2) {
        if (this.mKeyboardFocusedVirtualViewId != i2) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(i2, false);
        sendEventForVirtualView(i2, 8);
        return true;
    }

    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        int i2;
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int virtualViewAt = getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
            int i3 = this.mHoveredVirtualViewId;
            if (i3 != virtualViewAt) {
                this.mHoveredVirtualViewId = virtualViewAt;
                sendEventForVirtualView(virtualViewAt, Optimizer.OPTIMIZATION_GRAPH_WRAP);
                sendEventForVirtualView(i3, 256);
            }
            return virtualViewAt != Integer.MIN_VALUE;
        }
        if (action != 10 || (i2 = this.mHoveredVirtualViewId) == Integer.MIN_VALUE) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.mHoveredVirtualViewId = Integer.MIN_VALUE;
            sendEventForVirtualView(Integer.MIN_VALUE, Optimizer.OPTIMIZATION_GRAPH_WRAP);
            sendEventForVirtualView(i2, 256);
        }
        return true;
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i2 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 61) {
            if (keyEvent.hasNoModifiers()) {
                return c(2, null);
            }
            if (keyEvent.hasModifiers(1)) {
                return c(1, null);
            }
            return false;
        }
        int i3 = 66;
        if (keyCode != 66) {
            switch (keyCode) {
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                case 20:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                    if (!keyEvent.hasNoModifiers()) {
                        return false;
                    }
                    if (keyCode == 19) {
                        i3 = 33;
                    } else if (keyCode == 21) {
                        i3 = 17;
                    } else if (keyCode != 22) {
                        i3 = 130;
                    }
                    int repeatCount = keyEvent.getRepeatCount() + 1;
                    boolean z2 = false;
                    while (i2 < repeatCount && c(i3, null)) {
                        i2++;
                        z2 = true;
                    }
                    return z2;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                    break;
                default:
                    return false;
            }
        }
        if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        int i4 = this.mKeyboardFocusedVirtualViewId;
        if (i4 != Integer.MIN_VALUE) {
            onPerformActionForVirtualView(i4, 16, null);
        }
        return true;
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    @Override // androidx.core.view.c
    public k getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new a(this);
        }
        return this.mNodeProvider;
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    public abstract int getVirtualViewAt(float f2, float f3);

    public abstract void getVisibleVirtualViews(List list);

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int i2) {
        invalidateVirtualView(i2, 0);
    }

    public r.g obtainAccessibilityNodeInfo(int i2) {
        if (i2 != -1) {
            return b(i2);
        }
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(this.mHost);
        r.g gVar = new r.g(accessibilityNodeInfoObtain);
        View view = this.mHost;
        WeakHashMap weakHashMap = d1.f138a;
        view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        if (accessibilityNodeInfoObtain.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            gVar.f2507a.addChild(this.mHost, ((Integer) arrayList.get(i3)).intValue());
        }
        return gVar;
    }

    public final void onFocusChanged(boolean z2, int i2, Rect rect) {
        int i3 = this.mKeyboardFocusedVirtualViewId;
        if (i3 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i3);
        }
        if (z2) {
            c(i2, rect);
        }
    }

    @Override // androidx.core.view.c
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        onPopulateEventForHost(accessibilityEvent);
    }

    @Override // androidx.core.view.c
    public void onInitializeAccessibilityNodeInfo(View view, r.g gVar) {
        super.onInitializeAccessibilityNodeInfo(view, gVar);
        onPopulateNodeForHost(gVar);
    }

    public abstract boolean onPerformActionForVirtualView(int i2, int i3, Bundle bundle);

    public void onPopulateEventForHost(AccessibilityEvent accessibilityEvent) {
    }

    public void onPopulateEventForVirtualView(int i2, AccessibilityEvent accessibilityEvent) {
    }

    public void onPopulateNodeForHost(r.g gVar) {
    }

    public abstract void onPopulateNodeForVirtualView(int i2, r.g gVar);

    public void onVirtualViewKeyboardFocusChanged(int i2, boolean z2) {
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean performAction(int r6, int r7, android.os.Bundle r8) {
        /*
            r5 = this;
            r0 = -1
            if (r6 == r0) goto L66
            r0 = 1
            if (r7 == r0) goto L61
            r1 = 2
            if (r7 == r1) goto L5c
            r1 = 64
            r2 = 0
            r3 = 65536(0x10000, float:9.1835E-41)
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r7 == r1) goto L2d
            r1 = 128(0x80, float:1.8E-43)
            if (r7 == r1) goto L1b
            boolean r5 = r5.onPerformActionForVirtualView(r6, r7, r8)
            goto L65
        L1b:
            int r7 = r5.mAccessibilityFocusedVirtualViewId
            if (r7 != r6) goto L2a
            r5.mAccessibilityFocusedVirtualViewId = r4
            android.view.View r7 = r5.mHost
            r7.invalidate()
            r5.sendEventForVirtualView(r6, r3)
            goto L2b
        L2a:
            r0 = r2
        L2b:
            r5 = r0
            goto L65
        L2d:
            android.view.accessibility.AccessibilityManager r7 = r5.mManager
            boolean r7 = r7.isEnabled()
            if (r7 == 0) goto L2a
            android.view.accessibility.AccessibilityManager r7 = r5.mManager
            boolean r7 = r7.isTouchExplorationEnabled()
            if (r7 != 0) goto L3e
            goto L2a
        L3e:
            int r7 = r5.mAccessibilityFocusedVirtualViewId
            if (r7 == r6) goto L2a
            if (r7 == r4) goto L4e
            r5.mAccessibilityFocusedVirtualViewId = r4
            android.view.View r8 = r5.mHost
            r8.invalidate()
            r5.sendEventForVirtualView(r7, r3)
        L4e:
            r5.mAccessibilityFocusedVirtualViewId = r6
            android.view.View r7 = r5.mHost
            r7.invalidate()
            r7 = 32768(0x8000, float:4.5918E-41)
            r5.sendEventForVirtualView(r6, r7)
            goto L2b
        L5c:
            boolean r5 = r5.clearKeyboardFocusForVirtualView(r6)
            goto L65
        L61:
            boolean r5 = r5.requestKeyboardFocusForVirtualView(r6)
        L65:
            return r5
        L66:
            android.view.View r5 = r5.mHost
            java.util.WeakHashMap r6 = androidx.core.view.d1.f138a
            boolean r5 = androidx.core.view.m0.j(r5, r7, r8)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.b.performAction(int, int, android.os.Bundle):boolean");
    }

    public final boolean requestKeyboardFocusForVirtualView(int i2) {
        int i3;
        if ((!this.mHost.isFocused() && !this.mHost.requestFocus()) || (i3 = this.mKeyboardFocusedVirtualViewId) == i2) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i3);
        }
        if (i2 == Integer.MIN_VALUE) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = i2;
        onVirtualViewKeyboardFocusChanged(i2, true);
        sendEventForVirtualView(i2, 8);
        return true;
    }

    public final boolean sendEventForVirtualView(int i2, int i3) {
        ViewParent parent;
        if (i2 == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.mHost, a(i2, i3));
    }

    public final void invalidateVirtualView(int i2, int i3) {
        ViewParent parent;
        if (i2 == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return;
        }
        AccessibilityEvent accessibilityEventA = a(i2, 2048);
        r.b.b(accessibilityEventA, i3);
        parent.requestSendAccessibilityEvent(this.mHost, accessibilityEventA);
    }
}
