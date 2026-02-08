package androidx.core.view;

/* loaded from: classes.dex */
public abstract class f2 {

    /* renamed from: a, reason: collision with root package name */
    public final n2 f146a;

    /* renamed from: b, reason: collision with root package name */
    public k.f[] f147b;

    public f2() {
        this(new n2());
    }

    public final void a() {
        k.f[] fVarArr = this.f147b;
        if (fVarArr != null) {
            k.f fVarF = fVarArr[x0.g.U(1)];
            k.f fVarF2 = this.f147b[x0.g.U(2)];
            n2 n2Var = this.f146a;
            if (fVarF2 == null) {
                fVarF2 = n2Var.f189a.f(2);
            }
            if (fVarF == null) {
                fVarF = n2Var.f189a.f(1);
            }
            f(k.f.a(fVarF, fVarF2));
            k.f fVar = this.f147b[x0.g.U(16)];
            if (fVar != null) {
                e(fVar);
            }
            k.f fVar2 = this.f147b[x0.g.U(32)];
            if (fVar2 != null) {
                d(fVar2);
            }
            k.f fVar3 = this.f147b[x0.g.U(64)];
            if (fVar3 != null) {
                g(fVar3);
            }
        }
    }

    public abstract n2 b();

    public void c(int i2, k.f fVar) {
        if (this.f147b == null) {
            this.f147b = new k.f[9];
        }
        for (int i3 = 1; i3 <= 256; i3 <<= 1) {
            if ((i2 & i3) != 0) {
                this.f147b[x0.g.U(i3)] = fVar;
            }
        }
    }

    public abstract void d(k.f fVar);

    public abstract void e(k.f fVar);

    public abstract void f(k.f fVar);

    public abstract void g(k.f fVar);

    public f2(n2 n2Var) {
        this.f146a = n2Var;
    }
}
