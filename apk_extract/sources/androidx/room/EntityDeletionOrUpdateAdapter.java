package androidx.room;

import c0.k;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class EntityDeletionOrUpdateAdapter<T> extends SharedSQLiteStatement {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntityDeletionOrUpdateAdapter(RoomDatabase roomDatabase) {
        super(roomDatabase);
        x0.g.u(roomDatabase, "database");
    }

    public abstract void bind(k kVar, T t2);

    @Override // androidx.room.SharedSQLiteStatement
    public abstract String createQuery();

    public final int handle(T t2) {
        k kVarAcquire = acquire();
        try {
            bind(kVarAcquire, t2);
            return kVarAcquire.executeUpdateDelete();
        } finally {
            release(kVarAcquire);
        }
    }

    public final int handleMultiple(Iterable<? extends T> iterable) {
        x0.g.u(iterable, "entities");
        k kVarAcquire = acquire();
        try {
            Iterator<? extends T> it = iterable.iterator();
            int iExecuteUpdateDelete = 0;
            while (it.hasNext()) {
                bind(kVarAcquire, it.next());
                iExecuteUpdateDelete += kVarAcquire.executeUpdateDelete();
            }
            return iExecuteUpdateDelete;
        } finally {
            release(kVarAcquire);
        }
    }

    public final int handleMultiple(T[] tArr) {
        x0.g.u(tArr, "entities");
        k kVarAcquire = acquire();
        try {
            int iExecuteUpdateDelete = 0;
            for (T t2 : tArr) {
                bind(kVarAcquire, t2);
                iExecuteUpdateDelete += kVarAcquire.executeUpdateDelete();
            }
            return iExecuteUpdateDelete;
        } finally {
            release(kVarAcquire);
        }
    }
}
