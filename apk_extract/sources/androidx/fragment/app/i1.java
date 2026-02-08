package androidx.fragment.app;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class i1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f541a = 2;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f542b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f543c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f544d;

    public i1(l lVar, ArrayList arrayList, u1 u1Var) {
        this.f544d = lVar;
        this.f542b = arrayList;
        this.f543c = u1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f541a;
        Object obj = this.f544d;
        Object obj2 = this.f543c;
        Object obj3 = this.f542b;
        switch (i2) {
            case 0:
                ((n0) obj3).c((Fragment) obj2, (n.d) obj);
                break;
            case 1:
                ((n0) obj3).c((Fragment) obj2, (n.d) obj);
                break;
            default:
                List list = (List) obj3;
                u1 u1Var = (u1) obj2;
                if (list.contains(u1Var)) {
                    list.remove(u1Var);
                    ((l) obj).getClass();
                    v1.a(u1Var.f616a, u1Var.f618c.mView);
                    break;
                }
                break;
        }
    }
}
