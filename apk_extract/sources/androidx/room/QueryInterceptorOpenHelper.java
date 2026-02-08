package androidx.room;

import androidx.room.RoomDatabase;
import c0.h;
import java.io.IOException;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class QueryInterceptorOpenHelper implements h, DelegatingOpenHelper {
    private final h delegate;
    private final RoomDatabase.QueryCallback queryCallback;
    private final Executor queryCallbackExecutor;

    public QueryInterceptorOpenHelper(h hVar, Executor executor, RoomDatabase.QueryCallback queryCallback) {
        x0.g.u(hVar, "delegate");
        x0.g.u(executor, "queryCallbackExecutor");
        x0.g.u(queryCallback, "queryCallback");
        this.delegate = hVar;
        this.queryCallbackExecutor = executor;
        this.queryCallback = queryCallback;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // c0.h
    public String getDatabaseName() {
        return this.delegate.getDatabaseName();
    }

    @Override // androidx.room.DelegatingOpenHelper
    public h getDelegate() {
        return this.delegate;
    }

    @Override // c0.h
    public c0.b getReadableDatabase() {
        return new QueryInterceptorDatabase(getDelegate().getReadableDatabase(), this.queryCallbackExecutor, this.queryCallback);
    }

    @Override // c0.h
    public c0.b getWritableDatabase() {
        return new QueryInterceptorDatabase(getDelegate().getWritableDatabase(), this.queryCallbackExecutor, this.queryCallback);
    }

    @Override // c0.h
    public void setWriteAheadLoggingEnabled(boolean z2) {
        this.delegate.setWriteAheadLoggingEnabled(z2);
    }
}
