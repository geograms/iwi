package d0;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.fragment.app.v1;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/* loaded from: classes.dex */
public final class g extends SQLiteOpenHelper {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f1717h = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Context f1718a;

    /* renamed from: b, reason: collision with root package name */
    public final k.j f1719b;

    /* renamed from: c, reason: collision with root package name */
    public final c0.d f1720c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f1721d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1722e;

    /* renamed from: f, reason: collision with root package name */
    public final e0.a f1723f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1724g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context, String str, final k.j jVar, final c0.d dVar, boolean z2) {
        super(context, str, null, dVar.version, new DatabaseErrorHandler() { // from class: d0.e
            @Override // android.database.DatabaseErrorHandler
            public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                c0.d dVar2 = dVar;
                x0.g.u(dVar2, "$callback");
                k.j jVar2 = jVar;
                x0.g.u(jVar2, "$dbRef");
                int i2 = g.f1717h;
                x0.g.t(sQLiteDatabase, "dbObj");
                dVar2.onCorruption(c.c.f(jVar2, sQLiteDatabase));
            }
        });
        x0.g.u(context, "context");
        x0.g.u(dVar, "callback");
        this.f1718a = context;
        this.f1719b = jVar;
        this.f1720c = dVar;
        this.f1721d = z2;
        if (str == null) {
            str = UUID.randomUUID().toString();
            x0.g.t(str, "randomUUID().toString()");
        }
        this.f1723f = new e0.a(str, context.getCacheDir(), false);
    }

    public final c0.b a(boolean z2) throws IOException {
        e0.a aVar = this.f1723f;
        try {
            aVar.a((this.f1724g || getDatabaseName() == null) ? false : true);
            this.f1722e = false;
            SQLiteDatabase sQLiteDatabaseD = d(z2);
            if (!this.f1722e) {
                d dVarB = b(sQLiteDatabaseD);
                aVar.b();
                return dVarB;
            }
            close();
            c0.b bVarA = a(z2);
            aVar.b();
            return bVarA;
        } catch (Throwable th) {
            aVar.b();
            throw th;
        }
    }

    public final d b(SQLiteDatabase sQLiteDatabase) {
        x0.g.u(sQLiteDatabase, "sqLiteDatabase");
        return c.c.f(this.f1719b, sQLiteDatabase);
    }

    public final SQLiteDatabase c(boolean z2) {
        if (z2) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            x0.g.t(writableDatabase, "{\n                super.…eDatabase()\n            }");
            return writableDatabase;
        }
        SQLiteDatabase readableDatabase = getReadableDatabase();
        x0.g.t(readableDatabase, "{\n                super.…eDatabase()\n            }");
        return readableDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public final void close() {
        e0.a aVar = this.f1723f;
        try {
            aVar.a(aVar.f1754a);
            super.close();
            this.f1719b.f1934b = null;
            this.f1724g = false;
        } finally {
            aVar.b();
        }
    }

    public final SQLiteDatabase d(boolean z2) throws Throwable {
        File parentFile;
        String databaseName = getDatabaseName();
        boolean z3 = this.f1724g;
        Context context = this.f1718a;
        if (databaseName != null && !z3 && (parentFile = context.getDatabasePath(databaseName).getParentFile()) != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                Log.w("SupportSQLite", "Invalid database parent file, not a directory: " + parentFile);
            }
        }
        try {
            return c(z2);
        } catch (Throwable unused) {
            super.close();
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused2) {
            }
            try {
                return this.c(z2);
            } catch (Throwable th) {
                super.close();
                if (th instanceof f) {
                    f fVar = th;
                    int iE = v1.e(fVar.f1715a);
                    Throwable th2 = fVar.f1716b;
                    if (iE == 0 || iE == 1 || iE == 2 || iE == 3 || !(th2 instanceof SQLiteException)) {
                        throw th2;
                    }
                } else if (!(th instanceof SQLiteException) || databaseName == null || !this.f1721d) {
                    throw th;
                }
                context.deleteDatabase(databaseName);
                try {
                    return this.c(z2);
                } catch (f e2) {
                    throw e2.f1716b;
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onConfigure(SQLiteDatabase sQLiteDatabase) {
        x0.g.u(sQLiteDatabase, "db");
        boolean z2 = this.f1722e;
        c0.d dVar = this.f1720c;
        if (!z2 && dVar.version != sQLiteDatabase.getVersion()) {
            sQLiteDatabase.setMaxSqlCacheSize(1);
        }
        try {
            dVar.onConfigure(b(sQLiteDatabase));
        } catch (Throwable th) {
            throw new f(1, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        x0.g.u(sQLiteDatabase, "sqLiteDatabase");
        try {
            this.f1720c.onCreate(b(sQLiteDatabase));
        } catch (Throwable th) {
            throw new f(2, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        x0.g.u(sQLiteDatabase, "db");
        this.f1722e = true;
        try {
            this.f1720c.onDowngrade(b(sQLiteDatabase), i2, i3);
        } catch (Throwable th) {
            throw new f(4, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        x0.g.u(sQLiteDatabase, "db");
        if (!this.f1722e) {
            try {
                this.f1720c.onOpen(b(sQLiteDatabase));
            } catch (Throwable th) {
                throw new f(5, th);
            }
        }
        this.f1724g = true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        x0.g.u(sQLiteDatabase, "sqLiteDatabase");
        this.f1722e = true;
        try {
            this.f1720c.onUpgrade(b(sQLiteDatabase), i2, i3);
        } catch (Throwable th) {
            throw new f(3, th);
        }
    }
}
