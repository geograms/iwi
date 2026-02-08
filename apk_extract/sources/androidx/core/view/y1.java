package androidx.core.view;

import android.os.Build;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class y1 extends WindowInsetsAnimation$Callback {

    /* renamed from: a, reason: collision with root package name */
    public final s1 f226a;

    /* renamed from: b, reason: collision with root package name */
    public List f227b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f228c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f229d;

    public y1(s1 s1Var) {
        super(s1Var.getDispatchMode());
        this.f229d = new HashMap();
        this.f226a = s1Var;
    }

    public final b2 a(WindowInsetsAnimation windowInsetsAnimation) {
        b2 b2Var = (b2) this.f229d.get(windowInsetsAnimation);
        if (b2Var == null) {
            b2Var = new b2(0, null, 0L);
            if (Build.VERSION.SDK_INT >= 30) {
                b2Var.f133a = new z1(windowInsetsAnimation);
            }
            this.f229d.put(windowInsetsAnimation, b2Var);
        }
        return b2Var;
    }

    public final void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
        this.f226a.onEnd(a(windowInsetsAnimation));
        this.f229d.remove(windowInsetsAnimation);
    }

    public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
        this.f226a.onPrepare(a(windowInsetsAnimation));
    }

    public final WindowInsets onProgress(WindowInsets windowInsets, List list) {
        ArrayList arrayList = this.f228c;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList(list.size());
            this.f228c = arrayList2;
            this.f227b = Collections.unmodifiableList(arrayList2);
        } else {
            arrayList.clear();
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            WindowInsetsAnimation windowInsetsAnimationK = x1.k(list.get(size));
            b2 b2VarA = a(windowInsetsAnimationK);
            b2VarA.f133a.d(windowInsetsAnimationK.getFraction());
            this.f228c.add(b2VarA);
        }
        return this.f226a.onProgress(n2.g(null, windowInsets), this.f227b).f();
    }

    public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
        r1 r1VarOnStart = this.f226a.onStart(a(windowInsetsAnimation), new r1(bounds));
        r1VarOnStart.getClass();
        x1.m();
        return x1.i(r1VarOnStart.f198a.d(), r1VarOnStart.f199b.d());
    }
}
