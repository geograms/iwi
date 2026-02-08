package d0;

import android.content.Context;

/* loaded from: classes.dex */
public final class i implements c0.h {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1726a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1727b;

    /* renamed from: c, reason: collision with root package name */
    public final c0.d f1728c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f1729d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f1730e;

    /* renamed from: f, reason: collision with root package name */
    public final u0.d f1731f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1732g;

    public i(Context context, String str, c0.d dVar, boolean z2, boolean z3) {
        x0.g.u(context, "context");
        x0.g.u(dVar, "callback");
        this.f1726a = context;
        this.f1727b = str;
        this.f1728c = dVar;
        this.f1729d = z2;
        this.f1730e = z3;
        this.f1731f = new u0.d(new h(this));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f1731f.f2592b != u0.e.f2594a) {
            ((g) this.f1731f.getValue()).close();
        }
    }

    @Override // c0.h
    public final String getDatabaseName() {
        return this.f1727b;
    }

    @Override // c0.h
    public final c0.b getReadableDatabase() {
        return ((g) this.f1731f.getValue()).a(false);
    }

    @Override // c0.h
    public final c0.b getWritableDatabase() {
        return ((g) this.f1731f.getValue()).a(true);
    }

    @Override // c0.h
    public final void setWriteAheadLoggingEnabled(boolean z2) {
        if (this.f1731f.f2592b != u0.e.f2594a) {
            g gVar = (g) this.f1731f.getValue();
            x0.g.u(gVar, "sQLiteOpenHelper");
            gVar.setWriteAheadLoggingEnabled(z2);
        }
        this.f1732g = z2;
    }
}
