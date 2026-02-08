package d0;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements SQLiteDatabase.CursorFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1706a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1707b;

    public /* synthetic */ a(int i2, Object obj) {
        this.f1706a = i2;
        this.f1707b = obj;
    }

    @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
    public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        int i2 = this.f1706a;
        Object obj = this.f1707b;
        switch (i2) {
            case 0:
                c0.j jVar = (c0.j) obj;
                x0.g.u(jVar, "$query");
                x0.g.q(sQLiteQuery);
                jVar.bindTo(new j(sQLiteQuery));
                break;
            default:
                c cVar = (c) obj;
                x0.g.u(cVar, "$tmp0");
                x0.g.q(sQLiteQuery);
                cVar.f1709a.bindTo(new j(sQLiteQuery));
                break;
        }
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }
}
