package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public final class n2 {

    /* renamed from: a, reason: collision with root package name */
    public final g.l f901a = new g.l();

    /* renamed from: b, reason: collision with root package name */
    public final g.e f902b = new g.e();

    public final void a(z1 z1Var, b1 b1Var) {
        g.l lVar = this.f901a;
        l2 l2VarA = (l2) lVar.getOrDefault(z1Var, null);
        if (l2VarA == null) {
            l2VarA = l2.a();
            lVar.put(z1Var, l2VarA);
        }
        l2VarA.f884c = b1Var;
        l2VarA.f882a |= 8;
    }

    public final b1 b(z1 z1Var, int i2) {
        l2 l2Var;
        b1 b1Var;
        g.l lVar = this.f901a;
        int iE = lVar.e(z1Var);
        if (iE >= 0 && (l2Var = (l2) lVar.j(iE)) != null) {
            int i3 = l2Var.f882a;
            if ((i3 & i2) != 0) {
                int i4 = i3 & (~i2);
                l2Var.f882a = i4;
                if (i2 == 4) {
                    b1Var = l2Var.f883b;
                } else {
                    if (i2 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    b1Var = l2Var.f884c;
                }
                if ((i4 & 12) == 0) {
                    lVar.i(iE);
                    l2Var.f882a = 0;
                    l2Var.f883b = null;
                    l2Var.f884c = null;
                    l2.f881d.release(l2Var);
                }
                return b1Var;
            }
        }
        return null;
    }

    public final void c(z1 z1Var) {
        l2 l2Var = (l2) this.f901a.getOrDefault(z1Var, null);
        if (l2Var == null) {
            return;
        }
        l2Var.f882a &= -2;
    }

    public final void d(z1 z1Var) {
        g.e eVar = this.f902b;
        int iH = eVar.h() - 1;
        while (true) {
            if (iH < 0) {
                break;
            }
            if (z1Var == eVar.i(iH)) {
                Object[] objArr = eVar.f1789c;
                Object obj = objArr[iH];
                Object obj2 = g.e.f1786e;
                if (obj != obj2) {
                    objArr[iH] = obj2;
                    eVar.f1787a = true;
                }
            } else {
                iH--;
            }
        }
        l2 l2Var = (l2) this.f901a.remove(z1Var);
        if (l2Var != null) {
            l2Var.f882a = 0;
            l2Var.f883b = null;
            l2Var.f884c = null;
            l2.f881d.release(l2Var);
        }
    }
}
