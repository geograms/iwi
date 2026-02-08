package androidx.room;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.room.RoomDatabase;
import c0.j;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import v0.h;
import v0.k;

/* loaded from: classes.dex */
public final class QueryInterceptorDatabase implements c0.b {
    private final c0.b delegate;
    private final RoomDatabase.QueryCallback queryCallback;
    private final Executor queryCallbackExecutor;

    public QueryInterceptorDatabase(c0.b bVar, Executor executor, RoomDatabase.QueryCallback queryCallback) {
        x0.g.u(bVar, "delegate");
        x0.g.u(executor, "queryCallbackExecutor");
        x0.g.u(queryCallback, "queryCallback");
        this.delegate = bVar;
        this.queryCallbackExecutor = executor;
        this.queryCallback = queryCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void beginTransaction$lambda$0(QueryInterceptorDatabase queryInterceptorDatabase) {
        x0.g.u(queryInterceptorDatabase, "this$0");
        queryInterceptorDatabase.queryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", k.f2600a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void beginTransactionNonExclusive$lambda$1(QueryInterceptorDatabase queryInterceptorDatabase) {
        x0.g.u(queryInterceptorDatabase, "this$0");
        queryInterceptorDatabase.queryCallback.onQuery("BEGIN DEFERRED TRANSACTION", k.f2600a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void beginTransactionWithListener$lambda$2(QueryInterceptorDatabase queryInterceptorDatabase) {
        x0.g.u(queryInterceptorDatabase, "this$0");
        queryInterceptorDatabase.queryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", k.f2600a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void beginTransactionWithListenerNonExclusive$lambda$3(QueryInterceptorDatabase queryInterceptorDatabase) {
        x0.g.u(queryInterceptorDatabase, "this$0");
        queryInterceptorDatabase.queryCallback.onQuery("BEGIN DEFERRED TRANSACTION", k.f2600a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void endTransaction$lambda$4(QueryInterceptorDatabase queryInterceptorDatabase) {
        x0.g.u(queryInterceptorDatabase, "this$0");
        queryInterceptorDatabase.queryCallback.onQuery("END TRANSACTION", k.f2600a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execSQL$lambda$10(QueryInterceptorDatabase queryInterceptorDatabase, String str) {
        x0.g.u(queryInterceptorDatabase, "this$0");
        x0.g.u(str, "$sql");
        queryInterceptorDatabase.queryCallback.onQuery(str, k.f2600a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execSQL$lambda$12(QueryInterceptorDatabase queryInterceptorDatabase, String str, List list) {
        x0.g.u(queryInterceptorDatabase, "this$0");
        x0.g.u(str, "$sql");
        x0.g.u(list, "$inputArguments");
        queryInterceptorDatabase.queryCallback.onQuery(str, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void query$lambda$6(QueryInterceptorDatabase queryInterceptorDatabase, String str) {
        x0.g.u(queryInterceptorDatabase, "this$0");
        x0.g.u(str, "$query");
        queryInterceptorDatabase.queryCallback.onQuery(str, k.f2600a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void query$lambda$7(QueryInterceptorDatabase queryInterceptorDatabase, String str, Object[] objArr) {
        x0.g.u(queryInterceptorDatabase, "this$0");
        x0.g.u(str, "$query");
        x0.g.u(objArr, "$bindArgs");
        queryInterceptorDatabase.queryCallback.onQuery(str, v0.f.J0(objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void query$lambda$8(QueryInterceptorDatabase queryInterceptorDatabase, j jVar, QueryInterceptorProgram queryInterceptorProgram) {
        x0.g.u(queryInterceptorDatabase, "this$0");
        x0.g.u(jVar, "$query");
        x0.g.u(queryInterceptorProgram, "$queryInterceptorProgram");
        queryInterceptorDatabase.queryCallback.onQuery(jVar.getSql(), queryInterceptorProgram.getBindArgsCache$room_runtime_release());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void query$lambda$9(QueryInterceptorDatabase queryInterceptorDatabase, j jVar, QueryInterceptorProgram queryInterceptorProgram) {
        x0.g.u(queryInterceptorDatabase, "this$0");
        x0.g.u(jVar, "$query");
        x0.g.u(queryInterceptorProgram, "$queryInterceptorProgram");
        queryInterceptorDatabase.queryCallback.onQuery(jVar.getSql(), queryInterceptorProgram.getBindArgsCache$room_runtime_release());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTransactionSuccessful$lambda$5(QueryInterceptorDatabase queryInterceptorDatabase) {
        x0.g.u(queryInterceptorDatabase, "this$0");
        queryInterceptorDatabase.queryCallback.onQuery("TRANSACTION SUCCESSFUL", k.f2600a);
    }

    @Override // c0.b
    public void beginTransaction() {
        this.queryCallbackExecutor.execute(new c(this, 3));
        this.delegate.beginTransaction();
    }

    @Override // c0.b
    public void beginTransactionNonExclusive() {
        this.queryCallbackExecutor.execute(new c(this, 0));
        this.delegate.beginTransactionNonExclusive();
    }

    @Override // c0.b
    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        x0.g.u(sQLiteTransactionListener, "transactionListener");
        this.queryCallbackExecutor.execute(new c(this, 5));
        this.delegate.beginTransactionWithListener(sQLiteTransactionListener);
    }

    @Override // c0.b
    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        x0.g.u(sQLiteTransactionListener, "transactionListener");
        this.queryCallbackExecutor.execute(new c(this, 2));
        this.delegate.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // c0.b
    public c0.k compileStatement(String str) {
        x0.g.u(str, "sql");
        return new QueryInterceptorStatement(this.delegate.compileStatement(str), str, this.queryCallbackExecutor, this.queryCallback);
    }

    @Override // c0.b
    public int delete(String str, String str2, Object[] objArr) {
        x0.g.u(str, "table");
        return this.delegate.delete(str, str2, objArr);
    }

    @Override // c0.b
    public void disableWriteAheadLogging() {
        this.delegate.disableWriteAheadLogging();
    }

    @Override // c0.b
    public boolean enableWriteAheadLogging() {
        return this.delegate.enableWriteAheadLogging();
    }

    @Override // c0.b
    public void endTransaction() {
        this.queryCallbackExecutor.execute(new c(this, 4));
        this.delegate.endTransaction();
    }

    @Override // c0.b
    public void execPerConnectionSQL(String str, @SuppressLint({"ArrayReturn"}) Object[] objArr) {
        x0.g.u(str, "sql");
        this.delegate.execPerConnectionSQL(str, objArr);
    }

    @Override // c0.b
    public void execSQL(String str, Object[] objArr) {
        x0.g.u(str, "sql");
        x0.g.u(objArr, "bindArgs");
        w0.b bVar = new w0.b();
        h.M0(bVar, objArr);
        x0.g.k(bVar);
        this.queryCallbackExecutor.execute(new androidx.emoji2.text.k(this, str, bVar, 2));
        this.delegate.execSQL(str, bVar.toArray(new Object[0]));
    }

    @Override // c0.b
    public List<Pair<String, String>> getAttachedDbs() {
        return this.delegate.getAttachedDbs();
    }

    @Override // c0.b
    public long getMaximumSize() {
        return this.delegate.getMaximumSize();
    }

    @Override // c0.b
    public long getPageSize() {
        return this.delegate.getPageSize();
    }

    @Override // c0.b
    public String getPath() {
        return this.delegate.getPath();
    }

    @Override // c0.b
    public int getVersion() {
        return this.delegate.getVersion();
    }

    @Override // c0.b
    public boolean inTransaction() {
        return this.delegate.inTransaction();
    }

    @Override // c0.b
    public long insert(String str, int i2, ContentValues contentValues) {
        x0.g.u(str, "table");
        x0.g.u(contentValues, "values");
        return this.delegate.insert(str, i2, contentValues);
    }

    @Override // c0.b
    public boolean isDatabaseIntegrityOk() {
        return this.delegate.isDatabaseIntegrityOk();
    }

    @Override // c0.b
    public boolean isDbLockedByCurrentThread() {
        return this.delegate.isDbLockedByCurrentThread();
    }

    @Override // c0.b
    public boolean isExecPerConnectionSQLSupported() {
        return this.delegate.isExecPerConnectionSQLSupported();
    }

    @Override // c0.b
    public boolean isOpen() {
        return this.delegate.isOpen();
    }

    @Override // c0.b
    public boolean isReadOnly() {
        return this.delegate.isReadOnly();
    }

    @Override // c0.b
    public boolean isWriteAheadLoggingEnabled() {
        return this.delegate.isWriteAheadLoggingEnabled();
    }

    @Override // c0.b
    public boolean needUpgrade(int i2) {
        return this.delegate.needUpgrade(i2);
    }

    @Override // c0.b
    public Cursor query(String str) {
        x0.g.u(str, "query");
        this.queryCallbackExecutor.execute(new e(this, str, 0));
        return this.delegate.query(str);
    }

    @Override // c0.b
    public void setForeignKeyConstraintsEnabled(boolean z2) {
        this.delegate.setForeignKeyConstraintsEnabled(z2);
    }

    @Override // c0.b
    public void setLocale(Locale locale) {
        x0.g.u(locale, "locale");
        this.delegate.setLocale(locale);
    }

    @Override // c0.b
    public void setMaxSqlCacheSize(int i2) {
        this.delegate.setMaxSqlCacheSize(i2);
    }

    @Override // c0.b
    public long setMaximumSize(long j2) {
        return this.delegate.setMaximumSize(j2);
    }

    @Override // c0.b
    public void setPageSize(long j2) {
        this.delegate.setPageSize(j2);
    }

    @Override // c0.b
    public void setTransactionSuccessful() {
        this.queryCallbackExecutor.execute(new c(this, 1));
        this.delegate.setTransactionSuccessful();
    }

    @Override // c0.b
    public void setVersion(int i2) {
        this.delegate.setVersion(i2);
    }

    @Override // c0.b
    public int update(String str, int i2, ContentValues contentValues, String str2, Object[] objArr) {
        x0.g.u(str, "table");
        x0.g.u(contentValues, "values");
        return this.delegate.update(str, i2, contentValues, str2, objArr);
    }

    @Override // c0.b
    public boolean yieldIfContendedSafely() {
        return this.delegate.yieldIfContendedSafely();
    }

    @Override // c0.b
    public boolean yieldIfContendedSafely(long j2) {
        return this.delegate.yieldIfContendedSafely(j2);
    }

    @Override // c0.b
    public Cursor query(String str, Object[] objArr) {
        x0.g.u(str, "query");
        x0.g.u(objArr, "bindArgs");
        this.queryCallbackExecutor.execute(new androidx.emoji2.text.k(this, str, objArr, 1));
        return this.delegate.query(str, objArr);
    }

    @Override // c0.b
    public Cursor query(j jVar) {
        x0.g.u(jVar, "query");
        QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        jVar.bindTo(queryInterceptorProgram);
        this.queryCallbackExecutor.execute(new d(this, jVar, queryInterceptorProgram, 1));
        return this.delegate.query(jVar);
    }

    @Override // c0.b
    public void execSQL(String str) {
        x0.g.u(str, "sql");
        this.queryCallbackExecutor.execute(new e(this, str, 1));
        this.delegate.execSQL(str);
    }

    @Override // c0.b
    public Cursor query(j jVar, CancellationSignal cancellationSignal) {
        x0.g.u(jVar, "query");
        QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        jVar.bindTo(queryInterceptorProgram);
        this.queryCallbackExecutor.execute(new d(this, jVar, queryInterceptorProgram, 0));
        return this.delegate.query(jVar);
    }
}
