package u0;

import java.io.Serializable;
import x0.g;

/* loaded from: classes.dex */
public final class d implements a, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public c1.a f2591a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f2592b = e.f2594a;

    /* renamed from: c, reason: collision with root package name */
    public final Object f2593c = this;

    public d(c1.a aVar) {
        this.f2591a = aVar;
    }

    @Override // u0.a
    public final Object getValue() {
        Object objInvoke;
        Object obj = this.f2592b;
        e eVar = e.f2594a;
        if (obj != eVar) {
            return obj;
        }
        synchronized (this.f2593c) {
            objInvoke = this.f2592b;
            if (objInvoke == eVar) {
                c1.a aVar = this.f2591a;
                g.q(aVar);
                objInvoke = aVar.invoke();
                this.f2592b = objInvoke;
                this.f2591a = null;
            }
        }
        return objInvoke;
    }

    public final String toString() {
        return this.f2592b != e.f2594a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
