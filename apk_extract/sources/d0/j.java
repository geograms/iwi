package d0;

import android.database.sqlite.SQLiteProgram;

/* loaded from: classes.dex */
public class j implements c0.i {

    /* renamed from: a, reason: collision with root package name */
    public final SQLiteProgram f1733a;

    public j(SQLiteProgram sQLiteProgram) {
        x0.g.u(sQLiteProgram, "delegate");
        this.f1733a = sQLiteProgram;
    }

    @Override // c0.i
    public final void bindBlob(int i2, byte[] bArr) {
        x0.g.u(bArr, "value");
        this.f1733a.bindBlob(i2, bArr);
    }

    @Override // c0.i
    public final void bindDouble(int i2, double d2) {
        this.f1733a.bindDouble(i2, d2);
    }

    @Override // c0.i
    public final void bindLong(int i2, long j2) {
        this.f1733a.bindLong(i2, j2);
    }

    @Override // c0.i
    public final void bindNull(int i2) {
        this.f1733a.bindNull(i2);
    }

    @Override // c0.i
    public final void bindString(int i2, String str) {
        x0.g.u(str, "value");
        this.f1733a.bindString(i2, str);
    }

    @Override // c0.i
    public final void clearBindings() {
        this.f1733a.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f1733a.close();
    }
}
