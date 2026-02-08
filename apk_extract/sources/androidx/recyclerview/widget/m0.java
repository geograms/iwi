package androidx.recyclerview.widget;

import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public abstract class m0 extends v0 {

    /* renamed from: a, reason: collision with root package name */
    public final f f890a;

    public m0(k0.m mVar) {
        l0 l0Var = new l0(this);
        o0 o0Var = new o0(this);
        c cVar = new c();
        if (cVar.f745a == null) {
            synchronized (c.f743b) {
                try {
                    if (c.f744c == null) {
                        c.f744c = Executors.newFixedThreadPool(2);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            cVar.f745a = c.f744c;
        }
        f fVar = new f(o0Var, new t.c(cVar.f745a, mVar));
        this.f890a = fVar;
        fVar.f784d.add(l0Var);
    }

    public final Object a(int i2) {
        return this.f890a.f786f.get(i2);
    }

    @Override // androidx.recyclerview.widget.v0
    public final int getItemCount() {
        return this.f890a.f786f.size();
    }
}
