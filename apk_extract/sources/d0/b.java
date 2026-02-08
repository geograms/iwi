package d0;

import android.database.sqlite.SQLiteDatabase;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f1708a = new b();

    public final void a(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr) {
        x0.g.u(sQLiteDatabase, "sQLiteDatabase");
        x0.g.u(str, "sql");
        sQLiteDatabase.execPerConnectionSQL(str, objArr);
    }
}
