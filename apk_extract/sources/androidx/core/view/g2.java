package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class g2 extends l2 {

    /* renamed from: h, reason: collision with root package name */
    public static boolean f148h = false;

    /* renamed from: i, reason: collision with root package name */
    public static Method f149i;

    /* renamed from: j, reason: collision with root package name */
    public static Class f150j;

    /* renamed from: k, reason: collision with root package name */
    public static Field f151k;

    /* renamed from: l, reason: collision with root package name */
    public static Field f152l;

    /* renamed from: c, reason: collision with root package name */
    public final WindowInsets f153c;

    /* renamed from: d, reason: collision with root package name */
    public k.f[] f154d;

    /* renamed from: e, reason: collision with root package name */
    public k.f f155e;

    /* renamed from: f, reason: collision with root package name */
    public n2 f156f;

    /* renamed from: g, reason: collision with root package name */
    public k.f f157g;

    public g2(n2 n2Var, WindowInsets windowInsets) {
        super(n2Var);
        this.f155e = null;
        this.f153c = windowInsets;
    }

    @SuppressLint({"WrongConstant"})
    private k.f q(int i2, boolean z2) {
        k.f fVarA = k.f.f1925e;
        for (int i3 = 1; i3 <= 256; i3 <<= 1) {
            if ((i2 & i3) != 0) {
                fVarA = k.f.a(fVarA, r(i3, z2));
            }
        }
        return fVarA;
    }

    private k.f s() {
        n2 n2Var = this.f156f;
        return n2Var != null ? n2Var.f189a.h() : k.f.f1925e;
    }

    private k.f t(View view) throws IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 30) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }
        if (!f148h) {
            u();
        }
        Method method = f149i;
        if (method != null && f150j != null && f151k != null) {
            try {
                Object objInvoke = method.invoke(view, new Object[0]);
                if (objInvoke == null) {
                    Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                    return null;
                }
                Rect rect = (Rect) f151k.get(f152l.get(objInvoke));
                if (rect != null) {
                    return k.f.b(rect.left, rect.top, rect.right, rect.bottom);
                }
                return null;
            } catch (ReflectiveOperationException e2) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
            }
        }
        return null;
    }

    @SuppressLint({"PrivateApi"})
    private static void u() throws ClassNotFoundException, SecurityException {
        try {
            f149i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            f150j = cls;
            f151k = cls.getDeclaredField("mVisibleInsets");
            f152l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            f151k.setAccessible(true);
            f152l.setAccessible(true);
        } catch (ReflectiveOperationException e2) {
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
        }
        f148h = true;
    }

    @Override // androidx.core.view.l2
    public void d(View view) throws IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        k.f fVarT = t(view);
        if (fVarT == null) {
            fVarT = k.f.f1925e;
        }
        v(fVarT);
    }

    @Override // androidx.core.view.l2
    public k.f f(int i2) {
        return q(i2, false);
    }

    @Override // androidx.core.view.l2
    public final k.f j() {
        if (this.f155e == null) {
            WindowInsets windowInsets = this.f153c;
            this.f155e = k.f.b(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.f155e;
    }

    @Override // androidx.core.view.l2
    public boolean n() {
        return this.f153c.isRound();
    }

    @Override // androidx.core.view.l2
    public void o(k.f[] fVarArr) {
        this.f154d = fVarArr;
    }

    @Override // androidx.core.view.l2
    public void p(n2 n2Var) {
        this.f156f = n2Var;
    }

    public k.f r(int i2, boolean z2) {
        k.f fVarH;
        int i3;
        if (i2 == 1) {
            return z2 ? k.f.b(0, Math.max(s().f1927b, j().f1927b), 0, 0) : k.f.b(0, j().f1927b, 0, 0);
        }
        if (i2 == 2) {
            if (z2) {
                k.f fVarS = s();
                k.f fVarH2 = h();
                return k.f.b(Math.max(fVarS.f1926a, fVarH2.f1926a), 0, Math.max(fVarS.f1928c, fVarH2.f1928c), Math.max(fVarS.f1929d, fVarH2.f1929d));
            }
            k.f fVarJ = j();
            n2 n2Var = this.f156f;
            fVarH = n2Var != null ? n2Var.f189a.h() : null;
            int iMin = fVarJ.f1929d;
            if (fVarH != null) {
                iMin = Math.min(iMin, fVarH.f1929d);
            }
            return k.f.b(fVarJ.f1926a, 0, fVarJ.f1928c, iMin);
        }
        k.f fVar = k.f.f1925e;
        if (i2 == 8) {
            k.f[] fVarArr = this.f154d;
            fVarH = fVarArr != null ? fVarArr[x0.g.U(8)] : null;
            if (fVarH != null) {
                return fVarH;
            }
            k.f fVarJ2 = j();
            k.f fVarS2 = s();
            int i4 = fVarJ2.f1929d;
            if (i4 > fVarS2.f1929d) {
                return k.f.b(0, 0, 0, i4);
            }
            k.f fVar2 = this.f157g;
            return (fVar2 == null || fVar2.equals(fVar) || (i3 = this.f157g.f1929d) <= fVarS2.f1929d) ? fVar : k.f.b(0, 0, 0, i3);
        }
        if (i2 == 16) {
            return i();
        }
        if (i2 == 32) {
            return g();
        }
        if (i2 == 64) {
            return k();
        }
        if (i2 != 128) {
            return fVar;
        }
        n2 n2Var2 = this.f156f;
        n nVarE = n2Var2 != null ? n2Var2.f189a.e() : e();
        if (nVarE == null) {
            return fVar;
        }
        DisplayCutout displayCutout = nVarE.f187a;
        return k.f.b(m.d(displayCutout), m.f(displayCutout), m.e(displayCutout), m.c(displayCutout));
    }

    public void v(k.f fVar) {
        this.f157g = fVar;
    }
}
