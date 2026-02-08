package z0;

import x0.g;

/* loaded from: classes.dex */
public class b extends y0.b {
    @Override // y0.b
    public final void a(Throwable th, Throwable th2) {
        g.u(th, "cause");
        g.u(th2, "exception");
        Integer num = a.f2695a;
        if (num == null || num.intValue() >= 19) {
            th.addSuppressed(th2);
        } else {
            super.a(th, th2);
        }
    }
}
