package l1;

import x0.g;

/* loaded from: classes.dex */
public final class b implements a {
    private volatile /* synthetic */ Object _state;

    /* renamed from: a, reason: collision with root package name */
    public int f2089a;

    public b(Object obj) {
        this._state = obj;
    }

    public final void a(Object obj) {
        int i2;
        if (obj == null) {
            obj = m1.a.f2134a;
        }
        synchronized (this) {
            if (g.g(this._state, obj)) {
                return;
            }
            this._state = obj;
            int i3 = this.f2089a;
            if ((i3 & 1) != 0) {
                this.f2089a = i3 + 2;
                return;
            }
            int i4 = i3 + 1;
            this.f2089a = i4;
            while (true) {
                synchronized (this) {
                    i2 = this.f2089a;
                    if (i2 == i4) {
                        this.f2089a = i4 + 1;
                        return;
                    }
                }
                i4 = i2;
            }
        }
    }
}
