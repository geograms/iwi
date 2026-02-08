package androidx.room;

import c0.k;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class SharedSQLiteStatement {
    private final RoomDatabase database;
    private final AtomicBoolean lock;
    private final u0.a stmt$delegate;

    public SharedSQLiteStatement(RoomDatabase roomDatabase) {
        x0.g.u(roomDatabase, "database");
        this.database = roomDatabase;
        this.lock = new AtomicBoolean(false);
        this.stmt$delegate = new u0.d(new SharedSQLiteStatement$stmt$2(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k createNewStatement() {
        return this.database.compileStatement(createQuery());
    }

    private final k getStmt() {
        return (k) this.stmt$delegate.getValue();
    }

    public k acquire() {
        assertNotMainThread();
        return getStmt(this.lock.compareAndSet(false, true));
    }

    public void assertNotMainThread() {
        this.database.assertNotMainThread();
    }

    public abstract String createQuery();

    public void release(k kVar) {
        x0.g.u(kVar, "statement");
        if (kVar == getStmt()) {
            this.lock.set(false);
        }
    }

    private final k getStmt(boolean z2) {
        return z2 ? getStmt() : createNewStatement();
    }
}
