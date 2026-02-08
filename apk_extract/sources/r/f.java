package r;

import android.R;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.solver.widgets.Optimizer;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: e, reason: collision with root package name */
    public static final f f2492e = new f(1, (String) null);

    /* renamed from: f, reason: collision with root package name */
    public static final f f2493f = new f(2, (String) null);

    /* renamed from: g, reason: collision with root package name */
    public static final f f2494g;

    /* renamed from: h, reason: collision with root package name */
    public static final f f2495h;

    /* renamed from: i, reason: collision with root package name */
    public static final f f2496i;

    /* renamed from: j, reason: collision with root package name */
    public static final f f2497j;

    /* renamed from: k, reason: collision with root package name */
    public static final f f2498k;

    /* renamed from: l, reason: collision with root package name */
    public static final f f2499l;

    /* renamed from: m, reason: collision with root package name */
    public static final f f2500m;

    /* renamed from: n, reason: collision with root package name */
    public static final f f2501n;

    /* renamed from: o, reason: collision with root package name */
    public static final f f2502o;

    /* renamed from: a, reason: collision with root package name */
    public final Object f2503a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2504b;

    /* renamed from: c, reason: collision with root package name */
    public final Class f2505c;

    /* renamed from: d, reason: collision with root package name */
    public final v f2506d;

    static {
        new f(4, (String) null);
        new f(8, (String) null);
        f2494g = new f(16, (String) null);
        new f(32, (String) null);
        new f(64, (String) null);
        new f(Optimizer.OPTIMIZATION_GRAPH_WRAP, (String) null);
        new f(256, o.class);
        new f(Optimizer.OPTIMIZATION_DEPENDENCY_ORDERING, o.class);
        new f(Optimizer.OPTIMIZATION_GROUPING, p.class);
        new f(2048, p.class);
        f2495h = new f(MotionScene.Transition.TransitionOnClick.JUMP_TO_START, (String) null);
        f2496i = new f(8192, (String) null);
        new f(16384, (String) null);
        new f(32768, (String) null);
        new f(65536, (String) null);
        new f(131072, t.class);
        f2497j = new f(262144, (String) null);
        f2498k = new f(524288, (String) null);
        f2499l = new f(1048576, (String) null);
        new f(2097152, u.class);
        int i2 = Build.VERSION.SDK_INT;
        new f(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
        new f(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, r.class);
        f2500m = new f(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
        new f(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
        f2501n = new f(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
        new f(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
        new f(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP, R.id.accessibilityActionPageUp, null, null, null);
        new f(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN, R.id.accessibilityActionPageDown, null, null, null);
        new f(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT, R.id.accessibilityActionPageLeft, null, null, null);
        new f(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT, R.id.accessibilityActionPageRight, null, null, null);
        new f(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
        f2502o = new f(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, s.class);
        new f(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, R.id.accessibilityActionMoveWindow, null, null, q.class);
        new f(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP, R.id.accessibilityActionShowTooltip, null, null, null);
        new f(AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP, R.id.accessibilityActionHideTooltip, null, null, null);
        new f(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
        new f(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
    }

    public f(int i2, String str) {
        this(null, i2, str, null, null);
    }

    public final int a() {
        return ((AccessibilityNodeInfo.AccessibilityAction) this.f2503a).getId();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof f)) {
            return false;
        }
        Object obj2 = ((f) obj).f2503a;
        Object obj3 = this.f2503a;
        return obj3 == null ? obj2 == null : obj3.equals(obj2);
    }

    public final int hashCode() {
        Object obj = this.f2503a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public f(int i2, Class cls) {
        this(null, i2, null, null, cls);
    }

    public f(Object obj, int i2, String str, v vVar, Class cls) {
        this.f2504b = i2;
        this.f2506d = vVar;
        if (obj == null) {
            this.f2503a = new AccessibilityNodeInfo.AccessibilityAction(i2, str);
        } else {
            this.f2503a = obj;
        }
        this.f2505c = cls;
    }
}
