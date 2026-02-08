package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class j1 {

    /* renamed from: a, reason: collision with root package name */
    public static final o1 f548a = new o1();

    /* renamed from: b, reason: collision with root package name */
    public static final q1 f549b;

    static {
        q1 q1Var;
        try {
            q1Var = (q1) androidx.transition.m.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            q1Var = null;
        }
        f549b = q1Var;
    }

    public static void a(Fragment fragment, Fragment fragment2, boolean z2) {
        if (z2) {
            fragment2.getEnterTransitionCallback();
        } else {
            fragment.getEnterTransitionCallback();
        }
    }

    public static void b(ArrayList arrayList, int i2) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((View) arrayList.get(size)).setVisibility(i2);
        }
    }
}
