package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class t0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f962a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f963b;

    public /* synthetic */ t0(RecyclerView recyclerView, int i2) {
        this.f962a = i2;
        this.f963b = recyclerView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f962a;
        RecyclerView recyclerView = this.f963b;
        switch (i2) {
            case 0:
                if (recyclerView.mFirstLayoutComplete && !recyclerView.isLayoutRequested()) {
                    if (!recyclerView.mIsAttached) {
                        recyclerView.requestLayout();
                        break;
                    } else if (!recyclerView.mLayoutSuppressed) {
                        recyclerView.consumePendingUpdateOperations();
                        break;
                    } else {
                        recyclerView.mLayoutWasDefered = true;
                        break;
                    }
                }
                break;
            default:
                c1 c1Var = recyclerView.mItemAnimator;
                if (c1Var != null) {
                    p pVar = (p) c1Var;
                    ArrayList arrayList = pVar.f913h;
                    boolean z2 = !arrayList.isEmpty();
                    ArrayList arrayList2 = pVar.f915j;
                    boolean z3 = !arrayList2.isEmpty();
                    ArrayList arrayList3 = pVar.f916k;
                    boolean z4 = !arrayList3.isEmpty();
                    ArrayList arrayList4 = pVar.f914i;
                    boolean z5 = !arrayList4.isEmpty();
                    if (z2 || z3 || z5 || z4) {
                        Iterator it = arrayList.iterator();
                        while (true) {
                            boolean zHasNext = it.hasNext();
                            long j2 = pVar.f755d;
                            if (zHasNext) {
                                z1 z1Var = (z1) it.next();
                                View view = z1Var.itemView;
                                ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                                pVar.f922q.add(z1Var);
                                viewPropertyAnimatorAnimate.setDuration(j2).alpha(0.0f).setListener(new k(pVar, z1Var, viewPropertyAnimatorAnimate, view)).start();
                                it = it;
                            } else {
                                arrayList.clear();
                                if (z3) {
                                    ArrayList arrayList5 = new ArrayList();
                                    arrayList5.addAll(arrayList2);
                                    pVar.f918m.add(arrayList5);
                                    arrayList2.clear();
                                    j jVar = new j(pVar, arrayList5, 0);
                                    if (z2) {
                                        View view2 = ((o) arrayList5.get(0)).f903a.itemView;
                                        WeakHashMap weakHashMap = androidx.core.view.d1.f138a;
                                        androidx.core.view.m0.n(view2, jVar, j2);
                                    } else {
                                        jVar.run();
                                    }
                                }
                                if (z4) {
                                    ArrayList arrayList6 = new ArrayList();
                                    arrayList6.addAll(arrayList3);
                                    pVar.f919n.add(arrayList6);
                                    arrayList3.clear();
                                    j jVar2 = new j(pVar, arrayList6, 1);
                                    if (z2) {
                                        View view3 = ((n) arrayList6.get(0)).f891a.itemView;
                                        WeakHashMap weakHashMap2 = androidx.core.view.d1.f138a;
                                        androidx.core.view.m0.n(view3, jVar2, j2);
                                    } else {
                                        jVar2.run();
                                    }
                                }
                                if (z5) {
                                    ArrayList arrayList7 = new ArrayList();
                                    arrayList7.addAll(arrayList4);
                                    pVar.f917l.add(arrayList7);
                                    arrayList4.clear();
                                    j jVar3 = new j(pVar, arrayList7, 2);
                                    if (z2 || z3 || z4) {
                                        if (!z2) {
                                            j2 = 0;
                                        }
                                        long jMax = Math.max(z3 ? pVar.f756e : 0L, z4 ? pVar.f757f : 0L) + j2;
                                        View view4 = ((z1) arrayList7.get(0)).itemView;
                                        WeakHashMap weakHashMap3 = androidx.core.view.d1.f138a;
                                        androidx.core.view.m0.n(view4, jVar3, jMax);
                                    } else {
                                        jVar3.run();
                                    }
                                }
                            }
                        }
                    }
                }
                recyclerView.mPostedAnimatorRunner = false;
                break;
        }
    }
}
