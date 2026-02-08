package d0;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.Build;
import android.os.CancellationSignal;
import android.text.TextUtils;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class d implements c0.b {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f1710b = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f1711c = new String[0];

    /* renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f1712a;

    public d(SQLiteDatabase sQLiteDatabase) {
        x0.g.u(sQLiteDatabase, "delegate");
        this.f1712a = sQLiteDatabase;
    }

    @Override // c0.b
    public final void beginTransaction() {
        this.f1712a.beginTransaction();
    }

    @Override // c0.b
    public final void beginTransactionNonExclusive() {
        this.f1712a.beginTransactionNonExclusive();
    }

    @Override // c0.b
    public final void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        x0.g.u(sQLiteTransactionListener, "transactionListener");
        this.f1712a.beginTransactionWithListener(sQLiteTransactionListener);
    }

    @Override // c0.b
    public final void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        x0.g.u(sQLiteTransactionListener, "transactionListener");
        this.f1712a.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f1712a.close();
    }

    @Override // c0.b
    public final c0.k compileStatement(String str) throws SQLException {
        x0.g.u(str, "sql");
        SQLiteStatement sQLiteStatementCompileStatement = this.f1712a.compileStatement(str);
        x0.g.t(sQLiteStatementCompileStatement, "delegate.compileStatement(sql)");
        return new k(sQLiteStatementCompileStatement);
    }

    @Override // c0.b
    public final int delete(String str, String str2, Object[] objArr) throws SQLException {
        x0.g.u(str, "table");
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append(str);
        if (str2 != null && str2.length() != 0) {
            sb.append(" WHERE ");
            sb.append(str2);
        }
        String string = sb.toString();
        x0.g.t(string, "StringBuilder().apply(builderAction).toString()");
        c0.k kVarCompileStatement = compileStatement(string);
        c.c.a(kVarCompileStatement, objArr);
        return ((k) kVarCompileStatement).f1734b.executeUpdateDelete();
    }

    @Override // c0.b
    public final void disableWriteAheadLogging() {
        SQLiteDatabase sQLiteDatabase = this.f1712a;
        x0.g.u(sQLiteDatabase, "sQLiteDatabase");
        sQLiteDatabase.disableWriteAheadLogging();
    }

    @Override // c0.b
    public final boolean enableWriteAheadLogging() {
        return this.f1712a.enableWriteAheadLogging();
    }

    @Override // c0.b
    public final void endTransaction() {
        this.f1712a.endTransaction();
    }

    @Override // c0.b
    public final void execPerConnectionSQL(String str, Object[] objArr) {
        x0.g.u(str, "sql");
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 30) {
            throw new UnsupportedOperationException(a.a.c("execPerConnectionSQL is not supported on a SDK version lower than 30, current version is: ", i2));
        }
        b.f1708a.a(this.f1712a, str, objArr);
    }

    @Override // c0.b
    public final void execSQL(String str) throws SQLException {
        x0.g.u(str, "sql");
        this.f1712a.execSQL(str);
    }

    @Override // c0.b
    public final List getAttachedDbs() {
        return this.f1712a.getAttachedDbs();
    }

    @Override // c0.b
    public final long getMaximumSize() {
        return this.f1712a.getMaximumSize();
    }

    @Override // c0.b
    public final long getPageSize() {
        return this.f1712a.getPageSize();
    }

    @Override // c0.b
    public final String getPath() {
        return this.f1712a.getPath();
    }

    @Override // c0.b
    public final int getVersion() {
        return this.f1712a.getVersion();
    }

    @Override // c0.b
    public final boolean inTransaction() {
        return this.f1712a.inTransaction();
    }

    @Override // c0.b
    public final long insert(String str, int i2, ContentValues contentValues) {
        x0.g.u(str, "table");
        x0.g.u(contentValues, "values");
        return this.f1712a.insertWithOnConflict(str, null, contentValues, i2);
    }

    @Override // c0.b
    public final boolean isDatabaseIntegrityOk() {
        return this.f1712a.isDatabaseIntegrityOk();
    }

    @Override // c0.b
    public final boolean isDbLockedByCurrentThread() {
        return this.f1712a.isDbLockedByCurrentThread();
    }

    @Override // c0.b
    public final boolean isExecPerConnectionSQLSupported() {
        return Build.VERSION.SDK_INT >= 30;
    }

    @Override // c0.b
    public final boolean isOpen() {
        return this.f1712a.isOpen();
    }

    @Override // c0.b
    public final boolean isReadOnly() {
        return this.f1712a.isReadOnly();
    }

    @Override // c0.b
    public final boolean isWriteAheadLoggingEnabled() {
        SQLiteDatabase sQLiteDatabase = this.f1712a;
        x0.g.u(sQLiteDatabase, "sQLiteDatabase");
        return sQLiteDatabase.isWriteAheadLoggingEnabled();
    }

    @Override // c0.b
    public final boolean needUpgrade(int i2) {
        return this.f1712a.needUpgrade(i2);
    }

    @Override // c0.b
    public final Cursor query(String str) {
        x0.g.u(str, "query");
        return query(new c0.a(str));
    }

    @Override // c0.b
    public final void setForeignKeyConstraintsEnabled(boolean z2) {
        SQLiteDatabase sQLiteDatabase = this.f1712a;
        x0.g.u(sQLiteDatabase, "sQLiteDatabase");
        sQLiteDatabase.setForeignKeyConstraintsEnabled(z2);
    }

    @Override // c0.b
    public final void setLocale(Locale locale) {
        x0.g.u(locale, "locale");
        this.f1712a.setLocale(locale);
    }

    @Override // c0.b
    public final void setMaxSqlCacheSize(int i2) {
        this.f1712a.setMaxSqlCacheSize(i2);
    }

    @Override // c0.b
    public final long setMaximumSize(long j2) {
        SQLiteDatabase sQLiteDatabase = this.f1712a;
        sQLiteDatabase.setMaximumSize(j2);
        return sQLiteDatabase.getMaximumSize();
    }

    @Override // c0.b
    public final void setPageSize(long j2) {
        this.f1712a.setPageSize(j2);
    }

    @Override // c0.b
    public final void setTransactionSuccessful() {
        this.f1712a.setTransactionSuccessful();
    }

    @Override // c0.b
    public final void setVersion(int i2) {
        this.f1712a.setVersion(i2);
    }

    @Override // c0.b
    public final int update(String str, int i2, ContentValues contentValues, String str2, Object[] objArr) throws SQLException {
        x0.g.u(str, "table");
        x0.g.u(contentValues, "values");
        if (contentValues.size() == 0) {
            throw new IllegalArgumentException("Empty values".toString());
        }
        int size = contentValues.size();
        int length = objArr == null ? size : objArr.length + size;
        Object[] objArr2 = new Object[length];
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(f1710b[i2]);
        sb.append(str);
        sb.append(" SET ");
        int i3 = 0;
        for (String str3 : contentValues.keySet()) {
            sb.append(i3 > 0 ? "," : "");
            sb.append(str3);
            objArr2[i3] = contentValues.get(str3);
            sb.append("=?");
            i3++;
        }
        if (objArr != null) {
            for (int i4 = size; i4 < length; i4++) {
                objArr2[i4] = objArr[i4 - size];
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(" WHERE ");
            sb.append(str2);
        }
        String string = sb.toString();
        x0.g.t(string, "StringBuilder().apply(builderAction).toString()");
        c0.k kVarCompileStatement = compileStatement(string);
        c.c.a(kVarCompileStatement, objArr2);
        return ((k) kVarCompileStatement).f1734b.executeUpdateDelete();
    }

    @Override // c0.b
    public final boolean yieldIfContendedSafely() {
        return this.f1712a.yieldIfContendedSafely();
    }

    @Override // c0.b
    public final void execSQL(String str, Object[] objArr) throws SQLException {
        x0.g.u(str, "sql");
        x0.g.u(objArr, "bindArgs");
        this.f1712a.execSQL(str, objArr);
    }

    @Override // c0.b
    public final Cursor query(String str, Object[] objArr) {
        x0.g.u(str, "query");
        x0.g.u(objArr, "bindArgs");
        return query(new c0.a(str, objArr));
    }

    @Override // c0.b
    public final boolean yieldIfContendedSafely(long j2) {
        return this.f1712a.yieldIfContendedSafely(j2);
    }

    @Override // c0.b
    public final Cursor query(c0.j jVar) {
        x0.g.u(jVar, "query");
        Cursor cursorRawQueryWithFactory = this.f1712a.rawQueryWithFactory(new a(1, new c(jVar)), jVar.getSql(), f1711c, null);
        x0.g.t(cursorRawQueryWithFactory, "delegate.rawQueryWithFac…EMPTY_STRING_ARRAY, null)");
        return cursorRawQueryWithFactory;
    }

    @Override // c0.b
    public final Cursor query(c0.j jVar, CancellationSignal cancellationSignal) {
        x0.g.u(jVar, "query");
        String sql = jVar.getSql();
        String[] strArr = f1711c;
        x0.g.q(cancellationSignal);
        a aVar = new a(0, jVar);
        SQLiteDatabase sQLiteDatabase = this.f1712a;
        x0.g.u(sQLiteDatabase, "sQLiteDatabase");
        x0.g.u(sql, "sql");
        Cursor cursorRawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(aVar, sql, strArr, null, cancellationSignal);
        x0.g.t(cursorRawQueryWithFactory, "sQLiteDatabase.rawQueryW…ationSignal\n            )");
        return cursorRawQueryWithFactory;
    }
}
