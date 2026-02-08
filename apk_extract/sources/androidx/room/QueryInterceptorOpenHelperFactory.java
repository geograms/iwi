package androidx.room;

import androidx.room.RoomDatabase;
import c0.h;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class QueryInterceptorOpenHelperFactory implements c0.g {
    private final c0.g delegate;
    private final RoomDatabase.QueryCallback queryCallback;
    private final Executor queryCallbackExecutor;

    public QueryInterceptorOpenHelperFactory(c0.g gVar, Executor executor, RoomDatabase.QueryCallback queryCallback) {
        x0.g.u(gVar, "delegate");
        x0.g.u(executor, "queryCallbackExecutor");
        x0.g.u(queryCallback, "queryCallback");
        this.delegate = gVar;
        this.queryCallbackExecutor = executor;
        this.queryCallback = queryCallback;
    }

    @Override // c0.g
    public h create(c0.f fVar) {
        x0.g.u(fVar, "configuration");
        return new QueryInterceptorOpenHelper(this.delegate.create(fVar), this.queryCallbackExecutor, this.queryCallback);
    }
}
