package androidx.room;

import androidx.room.RoomDatabase;
import c0.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class QueryInterceptorStatement implements k {
    private final List<Object> bindArgsCache;
    private final k delegate;
    private final RoomDatabase.QueryCallback queryCallback;
    private final Executor queryCallbackExecutor;
    private final String sqlStatement;

    public QueryInterceptorStatement(k kVar, String str, Executor executor, RoomDatabase.QueryCallback queryCallback) {
        x0.g.u(kVar, "delegate");
        x0.g.u(str, "sqlStatement");
        x0.g.u(executor, "queryCallbackExecutor");
        x0.g.u(queryCallback, "queryCallback");
        this.delegate = kVar;
        this.sqlStatement = str;
        this.queryCallbackExecutor = executor;
        this.queryCallback = queryCallback;
        this.bindArgsCache = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execute$lambda$0(QueryInterceptorStatement queryInterceptorStatement) {
        x0.g.u(queryInterceptorStatement, "this$0");
        queryInterceptorStatement.queryCallback.onQuery(queryInterceptorStatement.sqlStatement, queryInterceptorStatement.bindArgsCache);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executeInsert$lambda$2(QueryInterceptorStatement queryInterceptorStatement) {
        x0.g.u(queryInterceptorStatement, "this$0");
        queryInterceptorStatement.queryCallback.onQuery(queryInterceptorStatement.sqlStatement, queryInterceptorStatement.bindArgsCache);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executeUpdateDelete$lambda$1(QueryInterceptorStatement queryInterceptorStatement) {
        x0.g.u(queryInterceptorStatement, "this$0");
        queryInterceptorStatement.queryCallback.onQuery(queryInterceptorStatement.sqlStatement, queryInterceptorStatement.bindArgsCache);
    }

    private final void saveArgsToCache(int i2, Object obj) {
        int i3 = i2 - 1;
        if (i3 >= this.bindArgsCache.size()) {
            int size = (i3 - this.bindArgsCache.size()) + 1;
            for (int i4 = 0; i4 < size; i4++) {
                this.bindArgsCache.add(null);
            }
        }
        this.bindArgsCache.set(i3, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void simpleQueryForLong$lambda$3(QueryInterceptorStatement queryInterceptorStatement) {
        x0.g.u(queryInterceptorStatement, "this$0");
        queryInterceptorStatement.queryCallback.onQuery(queryInterceptorStatement.sqlStatement, queryInterceptorStatement.bindArgsCache);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void simpleQueryForString$lambda$4(QueryInterceptorStatement queryInterceptorStatement) {
        x0.g.u(queryInterceptorStatement, "this$0");
        queryInterceptorStatement.queryCallback.onQuery(queryInterceptorStatement.sqlStatement, queryInterceptorStatement.bindArgsCache);
    }

    @Override // c0.i
    public void bindBlob(int i2, byte[] bArr) {
        x0.g.u(bArr, "value");
        saveArgsToCache(i2, bArr);
        this.delegate.bindBlob(i2, bArr);
    }

    @Override // c0.i
    public void bindDouble(int i2, double d2) {
        saveArgsToCache(i2, Double.valueOf(d2));
        this.delegate.bindDouble(i2, d2);
    }

    @Override // c0.i
    public void bindLong(int i2, long j2) {
        saveArgsToCache(i2, Long.valueOf(j2));
        this.delegate.bindLong(i2, j2);
    }

    @Override // c0.i
    public void bindNull(int i2) {
        saveArgsToCache(i2, null);
        this.delegate.bindNull(i2);
    }

    @Override // c0.i
    public void bindString(int i2, String str) {
        x0.g.u(str, "value");
        saveArgsToCache(i2, str);
        this.delegate.bindString(i2, str);
    }

    @Override // c0.i
    public void clearBindings() {
        this.bindArgsCache.clear();
        this.delegate.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // c0.k
    public void execute() {
        this.queryCallbackExecutor.execute(new f(this, 1));
        this.delegate.execute();
    }

    @Override // c0.k
    public long executeInsert() {
        this.queryCallbackExecutor.execute(new f(this, 2));
        return this.delegate.executeInsert();
    }

    @Override // c0.k
    public int executeUpdateDelete() {
        this.queryCallbackExecutor.execute(new f(this, 0));
        return this.delegate.executeUpdateDelete();
    }

    @Override // c0.k
    public long simpleQueryForLong() {
        this.queryCallbackExecutor.execute(new f(this, 4));
        return this.delegate.simpleQueryForLong();
    }

    @Override // c0.k
    public String simpleQueryForString() {
        this.queryCallbackExecutor.execute(new f(this, 3));
        return this.delegate.simpleQueryForString();
    }
}
