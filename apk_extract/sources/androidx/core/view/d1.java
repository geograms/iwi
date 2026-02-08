package androidx.core.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.R$id;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class d1 {

    /* renamed from: a, reason: collision with root package name */
    public static WeakHashMap f138a;

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f139b;

    /* renamed from: c, reason: collision with root package name */
    public static final h0 f140c;

    /* renamed from: d, reason: collision with root package name */
    public static final j0 f141d;

    static {
        new AtomicInteger(1);
        f138a = null;
        f139b = new int[]{R$id.accessibility_custom_action_0, R$id.accessibility_custom_action_1, R$id.accessibility_custom_action_2, R$id.accessibility_custom_action_3, R$id.accessibility_custom_action_4, R$id.accessibility_custom_action_5, R$id.accessibility_custom_action_6, R$id.accessibility_custom_action_7, R$id.accessibility_custom_action_8, R$id.accessibility_custom_action_9, R$id.accessibility_custom_action_10, R$id.accessibility_custom_action_11, R$id.accessibility_custom_action_12, R$id.accessibility_custom_action_13, R$id.accessibility_custom_action_14, R$id.accessibility_custom_action_15, R$id.accessibility_custom_action_16, R$id.accessibility_custom_action_17, R$id.accessibility_custom_action_18, R$id.accessibility_custom_action_19, R$id.accessibility_custom_action_20, R$id.accessibility_custom_action_21, R$id.accessibility_custom_action_22, R$id.accessibility_custom_action_23, R$id.accessibility_custom_action_24, R$id.accessibility_custom_action_25, R$id.accessibility_custom_action_26, R$id.accessibility_custom_action_27, R$id.accessibility_custom_action_28, R$id.accessibility_custom_action_29, R$id.accessibility_custom_action_30, R$id.accessibility_custom_action_31};
        f140c = new h0();
        f141d = new j0();
    }

    public static l1 a(View view) {
        if (f138a == null) {
            f138a = new WeakHashMap();
        }
        l1 l1Var = (l1) f138a.get(view);
        if (l1Var != null) {
            return l1Var;
        }
        l1 l1Var2 = new l1(view);
        f138a.put(view, l1Var2);
        return l1Var2;
    }

    public static void b(View view, n2 n2Var) {
        WindowInsets windowInsetsF = n2Var.f();
        if (windowInsetsF != null) {
            WindowInsets windowInsetsA = q0.a(view, windowInsetsF);
            if (windowInsetsA.equals(windowInsetsF)) {
                return;
            }
            n2.g(view, windowInsetsA);
        }
    }

    public static CharSequence c(View view) {
        return x0.b(view);
    }

    public static ArrayList d(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R$id.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R$id.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    public static String[] e(View view) {
        return Build.VERSION.SDK_INT >= 31 ? a1.a(view) : (String[]) view.getTag(R$id.tag_on_receive_content_mime_types);
    }

    public static u2 f(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return z0.b(view);
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    return new u2(window, view);
                }
                return null;
            }
        }
        return null;
    }

    public static void g(int i2, View view) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z2 = c(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (p0.a(view) != 0 || z2) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z2 ? 32 : 2048);
                p0.g(accessibilityEventObtain, i2);
                if (z2) {
                    accessibilityEventObtain.getText().add(c(view));
                    if (m0.c(view) == 0) {
                        m0.s(view, 1);
                    }
                    ViewParent parent = view.getParent();
                    while (true) {
                        if (!(parent instanceof View)) {
                            break;
                        }
                        if (m0.c((View) parent) == 4) {
                            m0.s(view, 2);
                            break;
                        }
                        parent = parent.getParent();
                    }
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i2 != 32) {
                if (view.getParent() != null) {
                    try {
                        p0.e(view.getParent(), view, view, i2);
                        return;
                    } catch (AbstractMethodError e2) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e2);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.setEventType(32);
            p0.g(accessibilityEventObtain2, i2);
            accessibilityEventObtain2.setSource(view);
            view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.getText().add(c(view));
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static l h(View view, l lVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + lVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return a1.b(view, lVar);
        }
        d0 d0Var = (d0) view.getTag(R$id.tag_on_receive_content_listener);
        e0 e0Var = f140c;
        if (d0Var == null) {
            if (view instanceof e0) {
                e0Var = (e0) view;
            }
            return e0Var.onReceiveContent(lVar);
        }
        l lVarA = ((u.s) d0Var).a(view, lVar);
        if (lVarA == null) {
            return null;
        }
        if (view instanceof e0) {
            e0Var = (e0) view;
        }
        return e0Var.onReceiveContent(lVarA);
    }

    public static void i(int i2, View view) {
        ArrayList arrayListD = d(view);
        for (int i3 = 0; i3 < arrayListD.size(); i3++) {
            if (((r.f) arrayListD.get(i3)).a() == i2) {
                arrayListD.remove(i3);
                return;
            }
        }
    }

    public static void j(View view, r.f fVar, String str, r.v vVar) {
        if (vVar == null && str == null) {
            i(fVar.a(), view);
            g(0, view);
            return;
        }
        r.f fVar2 = new r.f(null, fVar.f2504b, str, vVar, fVar.f2505c);
        View.AccessibilityDelegate accessibilityDelegateA = y0.a(view);
        c cVar = accessibilityDelegateA == null ? null : accessibilityDelegateA instanceof a ? ((a) accessibilityDelegateA).f125a : new c(accessibilityDelegateA);
        if (cVar == null) {
            cVar = new c();
        }
        k(view, cVar);
        i(fVar2.a(), view);
        d(view).add(fVar2);
        g(0, view);
    }

    public static void k(View view, c cVar) {
        if (cVar == null && (y0.a(view) instanceof a)) {
            cVar = new c();
        }
        view.setAccessibilityDelegate(cVar == null ? null : cVar.getBridge());
    }

    public static void l(View view, CharSequence charSequence) {
        new i0(R$id.tag_accessibility_pane_title, 8, 28, 1 == true ? 1 : 0).b(view, charSequence);
        j0 j0Var = f141d;
        if (charSequence == null) {
            j0Var.f170a.remove(view);
            view.removeOnAttachStateChangeListener(j0Var);
            m0.o(view.getViewTreeObserver(), j0Var);
        } else {
            j0Var.f170a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(j0Var);
            if (p0.b(view)) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(j0Var);
            }
        }
    }
}
