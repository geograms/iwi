package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f861a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f862b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p f863c;

    public /* synthetic */ j(p pVar, ArrayList arrayList, int i2) {
        this.f861a = i2;
        this.f863c = pVar;
        this.f862b = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        float f2;
        int i2 = this.f861a;
        float f3 = 0.0f;
        p pVar = this.f863c;
        ArrayList arrayList = this.f862b;
        switch (i2) {
            case 0:
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    o oVar = (o) it.next();
                    z1 z1Var = oVar.f903a;
                    pVar.getClass();
                    View view = z1Var.itemView;
                    int i3 = oVar.f906d - oVar.f904b;
                    int i4 = oVar.f907e - oVar.f905c;
                    if (i3 != 0) {
                        f2 = 0.0f;
                        view.animate().translationX(0.0f);
                    } else {
                        f2 = 0.0f;
                    }
                    if (i4 != 0) {
                        view.animate().translationY(f2);
                    }
                    ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                    pVar.f921p.add(z1Var);
                    viewPropertyAnimatorAnimate.setDuration(pVar.f756e).setListener(new l(pVar, z1Var, i3, view, i4, viewPropertyAnimatorAnimate)).start();
                }
                arrayList.clear();
                pVar.f918m.remove(arrayList);
                break;
            case 1:
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    n nVar = (n) it2.next();
                    pVar.getClass();
                    z1 z1Var2 = nVar.f891a;
                    View view2 = z1Var2 == null ? null : z1Var2.itemView;
                    z1 z1Var3 = nVar.f892b;
                    View view3 = z1Var3 != null ? z1Var3.itemView : null;
                    ArrayList arrayList2 = pVar.f923r;
                    long j2 = pVar.f757f;
                    if (view2 != null) {
                        ViewPropertyAnimator duration = view2.animate().setDuration(j2);
                        arrayList2.add(nVar.f891a);
                        duration.translationX(nVar.f895e - nVar.f893c);
                        duration.translationY(nVar.f896f - nVar.f894d);
                        duration.alpha(f3).setListener(new m(pVar, nVar, duration, view2, 0)).start();
                    }
                    if (view3 != null) {
                        ViewPropertyAnimator viewPropertyAnimatorAnimate2 = view3.animate();
                        arrayList2.add(nVar.f892b);
                        viewPropertyAnimatorAnimate2.translationX(0.0f).translationY(0.0f).setDuration(j2).alpha(1.0f).setListener(new m(pVar, nVar, viewPropertyAnimatorAnimate2, view3, 1)).start();
                    }
                    f3 = 0.0f;
                }
                arrayList.clear();
                pVar.f919n.remove(arrayList);
                break;
            default:
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    z1 z1Var4 = (z1) it3.next();
                    pVar.getClass();
                    View view4 = z1Var4.itemView;
                    ViewPropertyAnimator viewPropertyAnimatorAnimate3 = view4.animate();
                    pVar.f920o.add(z1Var4);
                    viewPropertyAnimatorAnimate3.alpha(1.0f).setDuration(pVar.f754c).setListener(new k(pVar, z1Var4, view4, viewPropertyAnimatorAnimate3)).start();
                }
                arrayList.clear();
                pVar.f917l.remove(arrayList);
                break;
        }
    }
}
