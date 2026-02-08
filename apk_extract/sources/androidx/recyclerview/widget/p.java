package androidx.recyclerview.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class p extends c1 {

    /* renamed from: s, reason: collision with root package name */
    public static TimeInterpolator f911s;

    /* renamed from: g, reason: collision with root package name */
    public boolean f912g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f913h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f914i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f915j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f916k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f917l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f918m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f919n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f920o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f921p;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList f922q;

    /* renamed from: r, reason: collision with root package name */
    public ArrayList f923r;

    public static void h(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((z1) arrayList.get(size)).itemView.animate().cancel();
        }
    }

    @Override // androidx.recyclerview.widget.c1
    public final boolean a(z1 z1Var, z1 z1Var2, b1 b1Var, b1 b1Var2) {
        int i2;
        int i3;
        int i4 = b1Var.f741a;
        int i5 = b1Var.f742b;
        if (z1Var2.shouldIgnore()) {
            int i6 = b1Var.f741a;
            i3 = b1Var.f742b;
            i2 = i6;
        } else {
            i2 = b1Var2.f741a;
            i3 = b1Var2.f742b;
        }
        if (z1Var == z1Var2) {
            return g(z1Var, i4, i5, i2, i3);
        }
        float translationX = z1Var.itemView.getTranslationX();
        float translationY = z1Var.itemView.getTranslationY();
        float alpha = z1Var.itemView.getAlpha();
        l(z1Var);
        z1Var.itemView.setTranslationX(translationX);
        z1Var.itemView.setTranslationY(translationY);
        z1Var.itemView.setAlpha(alpha);
        l(z1Var2);
        z1Var2.itemView.setTranslationX(-((int) ((i2 - i4) - translationX)));
        z1Var2.itemView.setTranslationY(-((int) ((i3 - i5) - translationY)));
        z1Var2.itemView.setAlpha(0.0f);
        ArrayList arrayList = this.f916k;
        n nVar = new n();
        nVar.f891a = z1Var;
        nVar.f892b = z1Var2;
        nVar.f893c = i4;
        nVar.f894d = i5;
        nVar.f895e = i2;
        nVar.f896f = i3;
        arrayList.add(nVar);
        return true;
    }

    @Override // androidx.recyclerview.widget.c1
    public final void d(z1 z1Var) {
        View view = z1Var.itemView;
        view.animate().cancel();
        ArrayList arrayList = this.f915j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((o) arrayList.get(size)).f903a == z1Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                c(z1Var);
                arrayList.remove(size);
            }
        }
        j(z1Var, this.f916k);
        if (this.f913h.remove(z1Var)) {
            view.setAlpha(1.0f);
            c(z1Var);
        }
        if (this.f914i.remove(z1Var)) {
            view.setAlpha(1.0f);
            c(z1Var);
        }
        ArrayList arrayList2 = this.f919n;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList3 = (ArrayList) arrayList2.get(size2);
            j(z1Var, arrayList3);
            if (arrayList3.isEmpty()) {
                arrayList2.remove(size2);
            }
        }
        ArrayList arrayList4 = this.f918m;
        for (int size3 = arrayList4.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList5 = (ArrayList) arrayList4.get(size3);
            int size4 = arrayList5.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (((o) arrayList5.get(size4)).f903a == z1Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    c(z1Var);
                    arrayList5.remove(size4);
                    if (arrayList5.isEmpty()) {
                        arrayList4.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        ArrayList arrayList6 = this.f917l;
        for (int size5 = arrayList6.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList7 = (ArrayList) arrayList6.get(size5);
            if (arrayList7.remove(z1Var)) {
                view.setAlpha(1.0f);
                c(z1Var);
                if (arrayList7.isEmpty()) {
                    arrayList6.remove(size5);
                }
            }
        }
        this.f922q.remove(z1Var);
        this.f920o.remove(z1Var);
        this.f923r.remove(z1Var);
        this.f921p.remove(z1Var);
        i();
    }

    @Override // androidx.recyclerview.widget.c1
    public final void e() {
        ArrayList arrayList = this.f915j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            o oVar = (o) arrayList.get(size);
            View view = oVar.f903a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            c(oVar.f903a);
            arrayList.remove(size);
        }
        ArrayList arrayList2 = this.f913h;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            c((z1) arrayList2.get(size2));
            arrayList2.remove(size2);
        }
        ArrayList arrayList3 = this.f914i;
        int size3 = arrayList3.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            z1 z1Var = (z1) arrayList3.get(size3);
            z1Var.itemView.setAlpha(1.0f);
            c(z1Var);
            arrayList3.remove(size3);
        }
        ArrayList arrayList4 = this.f916k;
        for (int size4 = arrayList4.size() - 1; size4 >= 0; size4--) {
            n nVar = (n) arrayList4.get(size4);
            z1 z1Var2 = nVar.f891a;
            if (z1Var2 != null) {
                k(nVar, z1Var2);
            }
            z1 z1Var3 = nVar.f892b;
            if (z1Var3 != null) {
                k(nVar, z1Var3);
            }
        }
        arrayList4.clear();
        if (f()) {
            ArrayList arrayList5 = this.f918m;
            for (int size5 = arrayList5.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList6 = (ArrayList) arrayList5.get(size5);
                for (int size6 = arrayList6.size() - 1; size6 >= 0; size6--) {
                    o oVar2 = (o) arrayList6.get(size6);
                    View view2 = oVar2.f903a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    c(oVar2.f903a);
                    arrayList6.remove(size6);
                    if (arrayList6.isEmpty()) {
                        arrayList5.remove(arrayList6);
                    }
                }
            }
            ArrayList arrayList7 = this.f917l;
            for (int size7 = arrayList7.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList8 = (ArrayList) arrayList7.get(size7);
                for (int size8 = arrayList8.size() - 1; size8 >= 0; size8--) {
                    z1 z1Var4 = (z1) arrayList8.get(size8);
                    z1Var4.itemView.setAlpha(1.0f);
                    c(z1Var4);
                    arrayList8.remove(size8);
                    if (arrayList8.isEmpty()) {
                        arrayList7.remove(arrayList8);
                    }
                }
            }
            ArrayList arrayList9 = this.f919n;
            for (int size9 = arrayList9.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList10 = (ArrayList) arrayList9.get(size9);
                for (int size10 = arrayList10.size() - 1; size10 >= 0; size10--) {
                    n nVar2 = (n) arrayList10.get(size10);
                    z1 z1Var5 = nVar2.f891a;
                    if (z1Var5 != null) {
                        k(nVar2, z1Var5);
                    }
                    z1 z1Var6 = nVar2.f892b;
                    if (z1Var6 != null) {
                        k(nVar2, z1Var6);
                    }
                    if (arrayList10.isEmpty()) {
                        arrayList9.remove(arrayList10);
                    }
                }
            }
            h(this.f922q);
            h(this.f921p);
            h(this.f920o);
            h(this.f923r);
            ArrayList arrayList11 = this.f753b;
            if (arrayList11.size() > 0) {
                a.a.j(arrayList11.get(0));
                throw null;
            }
            arrayList11.clear();
        }
    }

    @Override // androidx.recyclerview.widget.c1
    public final boolean f() {
        return (this.f914i.isEmpty() && this.f916k.isEmpty() && this.f915j.isEmpty() && this.f913h.isEmpty() && this.f921p.isEmpty() && this.f922q.isEmpty() && this.f920o.isEmpty() && this.f923r.isEmpty() && this.f918m.isEmpty() && this.f917l.isEmpty() && this.f919n.isEmpty()) ? false : true;
    }

    public final boolean g(z1 z1Var, int i2, int i3, int i4, int i5) {
        View view = z1Var.itemView;
        int translationX = i2 + ((int) view.getTranslationX());
        int translationY = i3 + ((int) z1Var.itemView.getTranslationY());
        l(z1Var);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            c(z1Var);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX(-i6);
        }
        if (i7 != 0) {
            view.setTranslationY(-i7);
        }
        ArrayList arrayList = this.f915j;
        o oVar = new o();
        oVar.f903a = z1Var;
        oVar.f904b = translationX;
        oVar.f905c = translationY;
        oVar.f906d = i4;
        oVar.f907e = i5;
        arrayList.add(oVar);
        return true;
    }

    public final void i() {
        if (f()) {
            return;
        }
        ArrayList arrayList = this.f753b;
        if (arrayList.size() <= 0) {
            arrayList.clear();
        } else {
            a.a.j(arrayList.get(0));
            throw null;
        }
    }

    public final void j(z1 z1Var, ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            n nVar = (n) arrayList.get(size);
            if (k(nVar, z1Var) && nVar.f891a == null && nVar.f892b == null) {
                arrayList.remove(nVar);
            }
        }
    }

    public final boolean k(n nVar, z1 z1Var) {
        if (nVar.f892b == z1Var) {
            nVar.f892b = null;
        } else {
            if (nVar.f891a != z1Var) {
                return false;
            }
            nVar.f891a = null;
        }
        z1Var.itemView.setAlpha(1.0f);
        z1Var.itemView.setTranslationX(0.0f);
        z1Var.itemView.setTranslationY(0.0f);
        c(z1Var);
        return true;
    }

    public final void l(z1 z1Var) {
        if (f911s == null) {
            f911s = new ValueAnimator().getInterpolator();
        }
        z1Var.itemView.animate().setInterpolator(f911s);
        d(z1Var);
    }
}
