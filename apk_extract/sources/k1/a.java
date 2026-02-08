package k1;

import android.os.Handler;
import android.os.Looper;
import j1.d;
import j1.i;
import j1.k;
import j1.p;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.scheduling.c;
import n1.f;
import x0.g;
import x0.j;

/* loaded from: classes.dex */
public final class a extends p implements i {
    private volatile a _immediate;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f2031b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2032c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f2033d;

    /* renamed from: e, reason: collision with root package name */
    public final a f2034e;

    public a(Handler handler, String str, boolean z2) {
        this.f2031b = handler;
        this.f2032c = str;
        this.f2033d = z2;
        this._immediate = z2 ? this : null;
        a aVar = this._immediate;
        if (aVar == null) {
            aVar = new a(handler, str, true);
            this._immediate = aVar;
        }
        this.f2034e = aVar;
    }

    @Override // j1.c
    public final void a(j jVar, Runnable runnable) {
        if (this.f2031b.post(runnable)) {
            return;
        }
        c(jVar, runnable);
    }

    @Override // j1.c
    public final boolean b() {
        return (this.f2033d && g.g(Looper.myLooper(), this.f2031b.getLooper())) ? false : true;
    }

    public final void c(j jVar, Runnable runnable) {
        new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        a.a.k(jVar.get(d.f1910b));
        k.f1916a.a(jVar, runnable);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && ((a) obj).f2031b == this.f2031b;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f2031b);
    }

    @Override // j1.c
    public final String toString() {
        a aVar;
        String str;
        c cVar = k.f1916a;
        p pVar = f.f2208a;
        if (this == pVar) {
            str = "Dispatchers.Main";
        } else {
            try {
                aVar = ((a) pVar).f2034e;
            } catch (UnsupportedOperationException unused) {
                aVar = null;
            }
            str = this == aVar ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.f2032c;
        if (string == null) {
            string = this.f2031b.toString();
        }
        return this.f2033d ? g.y0(".immediate", string) : string;
    }

    public a(Handler handler) {
        this(handler, null, false);
    }
}
