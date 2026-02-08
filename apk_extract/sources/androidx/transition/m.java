package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.q1;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class m extends q1 {
    public static boolean u(v vVar) {
        return (q1.h(vVar.getTargetIds()) && q1.h(vVar.getTargetNames()) && q1.h(vVar.getTargetTypes())) ? false : true;
    }

    @Override // androidx.fragment.app.q1
    public final void a(View view, Object obj) {
        if (obj != null) {
            ((v) obj).addTarget(view);
        }
    }

    @Override // androidx.fragment.app.q1
    public final void b(Object obj, ArrayList arrayList) {
        v vVar = (v) obj;
        if (vVar == null) {
            return;
        }
        int i2 = 0;
        if (vVar instanceof b0) {
            b0 b0Var = (b0) vVar;
            int size = b0Var.f1047a.size();
            while (i2 < size) {
                b((i2 < 0 || i2 >= b0Var.f1047a.size()) ? null : (v) b0Var.f1047a.get(i2), arrayList);
                i2++;
            }
            return;
        }
        if (u(vVar) || !q1.h(vVar.getTargets())) {
            return;
        }
        int size2 = arrayList.size();
        while (i2 < size2) {
            vVar.addTarget((View) arrayList.get(i2));
            i2++;
        }
    }

    @Override // androidx.fragment.app.q1
    public final void c(ViewGroup viewGroup, Object obj) {
        y.a(viewGroup, (v) obj);
    }

    @Override // androidx.fragment.app.q1
    public final boolean e(Object obj) {
        return obj instanceof v;
    }

    @Override // androidx.fragment.app.q1
    public final Object f(Object obj) {
        if (obj != null) {
            return ((v) obj).mo2clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.q1
    public final Object i(Object obj, Object obj2, Object obj3) {
        v vVar = (v) obj;
        v vVar2 = (v) obj2;
        v vVar3 = (v) obj3;
        if (vVar != null && vVar2 != null) {
            b0 b0Var = new b0();
            b0Var.e(vVar);
            b0Var.e(vVar2);
            b0Var.i(1);
            vVar = b0Var;
        } else if (vVar == null) {
            vVar = vVar2 != null ? vVar2 : null;
        }
        if (vVar3 == null) {
            return vVar;
        }
        b0 b0Var2 = new b0();
        if (vVar != null) {
            b0Var2.e(vVar);
        }
        b0Var2.e(vVar3);
        return b0Var2;
    }

    @Override // androidx.fragment.app.q1
    public final Object j(Object obj, Object obj2, Object obj3) {
        b0 b0Var = new b0();
        if (obj != null) {
            b0Var.e((v) obj);
        }
        if (obj2 != null) {
            b0Var.e((v) obj2);
        }
        if (obj3 != null) {
            b0Var.e((v) obj3);
        }
        return b0Var;
    }

    @Override // androidx.fragment.app.q1
    public final void l(Object obj, View view, ArrayList arrayList) {
        ((v) obj).addListener(new k(view, arrayList));
    }

    @Override // androidx.fragment.app.q1
    public final void m(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3) {
        ((v) obj).addListener(new l(this, obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.q1
    public final void n(View view, Object obj) {
        if (view != null) {
            Rect rect = new Rect();
            q1.g(view, rect);
            ((v) obj).setEpicenterCallback(new j(rect, 0));
        }
    }

    @Override // androidx.fragment.app.q1
    public final void o(Object obj, Rect rect) {
        if (obj != null) {
            ((v) obj).setEpicenterCallback(new j(rect, 1));
        }
    }

    @Override // androidx.fragment.app.q1
    public final void r(Object obj, View view, ArrayList arrayList) {
        b0 b0Var = (b0) obj;
        List<View> targets = b0Var.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            q1.d((View) arrayList.get(i2), targets);
        }
        targets.add(view);
        arrayList.add(view);
        b(b0Var, arrayList);
    }

    @Override // androidx.fragment.app.q1
    public final void s(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        b0 b0Var = (b0) obj;
        if (b0Var != null) {
            b0Var.getTargets().clear();
            b0Var.getTargets().addAll(arrayList2);
            v(b0Var, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.q1
    public final Object t(Object obj) {
        if (obj == null) {
            return null;
        }
        b0 b0Var = new b0();
        b0Var.e((v) obj);
        return b0Var;
    }

    public final void v(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        v vVar = (v) obj;
        int i2 = 0;
        if (vVar instanceof b0) {
            b0 b0Var = (b0) vVar;
            int size = b0Var.f1047a.size();
            while (i2 < size) {
                v((i2 < 0 || i2 >= b0Var.f1047a.size()) ? null : (v) b0Var.f1047a.get(i2), arrayList, arrayList2);
                i2++;
            }
            return;
        }
        if (u(vVar)) {
            return;
        }
        List<View> targets = vVar.getTargets();
        if (targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
            int size2 = arrayList2 == null ? 0 : arrayList2.size();
            while (i2 < size2) {
                vVar.addTarget((View) arrayList2.get(i2));
                i2++;
            }
            for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                vVar.removeTarget((View) arrayList.get(size3));
            }
        }
    }
}
