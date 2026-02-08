package androidx.room;

import android.database.sqlite.SQLiteConstraintException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class EntityUpsertionAdapter<T> {
    private final EntityInsertionAdapter<T> insertionAdapter;
    private final EntityDeletionOrUpdateAdapter<T> updateAdapter;

    public EntityUpsertionAdapter(EntityInsertionAdapter<T> entityInsertionAdapter, EntityDeletionOrUpdateAdapter<T> entityDeletionOrUpdateAdapter) {
        x0.g.u(entityInsertionAdapter, "insertionAdapter");
        x0.g.u(entityDeletionOrUpdateAdapter, "updateAdapter");
        this.insertionAdapter = entityInsertionAdapter;
        this.updateAdapter = entityDeletionOrUpdateAdapter;
    }

    private final void checkUniquenessException(SQLiteConstraintException sQLiteConstraintException) {
        String message = sQLiteConstraintException.getMessage();
        if (message == null) {
            throw sQLiteConstraintException;
        }
        if (!i1.c.E0(message, "unique", true) && !i1.c.E0(message, "2067", false) && !i1.c.E0(message, "1555", false)) {
            throw sQLiteConstraintException;
        }
    }

    public final void upsert(T t2) {
        try {
            this.insertionAdapter.insert((EntityInsertionAdapter<T>) t2);
        } catch (SQLiteConstraintException e2) {
            checkUniquenessException(e2);
            this.updateAdapter.handle(t2);
        }
    }

    public final long upsertAndReturnId(T t2) {
        try {
            return this.insertionAdapter.insertAndReturnId(t2);
        } catch (SQLiteConstraintException e2) {
            this.checkUniquenessException(e2);
            this.updateAdapter.handle(t2);
            return -1L;
        }
    }

    public final long[] upsertAndReturnIdsArray(T[] tArr) {
        long jInsertAndReturnId;
        x0.g.u(tArr, "entities");
        int length = tArr.length;
        long[] jArr = new long[length];
        for (int i2 = 0; i2 < length; i2++) {
            try {
                jInsertAndReturnId = this.insertionAdapter.insertAndReturnId(tArr[i2]);
            } catch (SQLiteConstraintException e2) {
                checkUniquenessException(e2);
                this.updateAdapter.handle(tArr[i2]);
                jInsertAndReturnId = -1;
            }
            jArr[i2] = jInsertAndReturnId;
        }
        return jArr;
    }

    public final Long[] upsertAndReturnIdsArrayBox(T[] tArr) {
        long jInsertAndReturnId;
        x0.g.u(tArr, "entities");
        int length = tArr.length;
        Long[] lArr = new Long[length];
        for (int i2 = 0; i2 < length; i2++) {
            try {
                jInsertAndReturnId = this.insertionAdapter.insertAndReturnId(tArr[i2]);
            } catch (SQLiteConstraintException e2) {
                checkUniquenessException(e2);
                this.updateAdapter.handle(tArr[i2]);
                jInsertAndReturnId = -1;
            }
            lArr[i2] = Long.valueOf(jInsertAndReturnId);
        }
        return lArr;
    }

    public final List<Long> upsertAndReturnIdsList(Collection<? extends T> collection) {
        x0.g.u(collection, "entities");
        w0.b bVar = new w0.b();
        for (T t2 : collection) {
            try {
                bVar.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(t2)));
            } catch (SQLiteConstraintException e2) {
                checkUniquenessException(e2);
                this.updateAdapter.handle(t2);
                bVar.add(-1L);
            }
        }
        x0.g.k(bVar);
        return bVar;
    }

    public final void upsert(T[] tArr) {
        x0.g.u(tArr, "entities");
        for (T t2 : tArr) {
            try {
                this.insertionAdapter.insert((EntityInsertionAdapter<T>) t2);
            } catch (SQLiteConstraintException e2) {
                checkUniquenessException(e2);
                this.updateAdapter.handle(t2);
            }
        }
    }

    public final long[] upsertAndReturnIdsArray(Collection<? extends T> collection) {
        long jInsertAndReturnId;
        x0.g.u(collection, "entities");
        Iterator<? extends T> it = collection.iterator();
        int size = collection.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            T next = it.next();
            try {
                jInsertAndReturnId = this.insertionAdapter.insertAndReturnId(next);
            } catch (SQLiteConstraintException e2) {
                checkUniquenessException(e2);
                this.updateAdapter.handle(next);
                jInsertAndReturnId = -1;
            }
            jArr[i2] = jInsertAndReturnId;
        }
        return jArr;
    }

    public final Long[] upsertAndReturnIdsArrayBox(Collection<? extends T> collection) {
        long jInsertAndReturnId;
        x0.g.u(collection, "entities");
        Iterator<? extends T> it = collection.iterator();
        int size = collection.size();
        Long[] lArr = new Long[size];
        for (int i2 = 0; i2 < size; i2++) {
            T next = it.next();
            try {
                jInsertAndReturnId = this.insertionAdapter.insertAndReturnId(next);
            } catch (SQLiteConstraintException e2) {
                checkUniquenessException(e2);
                this.updateAdapter.handle(next);
                jInsertAndReturnId = -1;
            }
            lArr[i2] = Long.valueOf(jInsertAndReturnId);
        }
        return lArr;
    }

    public final void upsert(Iterable<? extends T> iterable) {
        x0.g.u(iterable, "entities");
        for (T t2 : iterable) {
            try {
                this.insertionAdapter.insert((EntityInsertionAdapter<T>) t2);
            } catch (SQLiteConstraintException e2) {
                checkUniquenessException(e2);
                this.updateAdapter.handle(t2);
            }
        }
    }

    public final List<Long> upsertAndReturnIdsList(T[] tArr) {
        x0.g.u(tArr, "entities");
        w0.b bVar = new w0.b();
        for (T t2 : tArr) {
            try {
                bVar.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(t2)));
            } catch (SQLiteConstraintException e2) {
                checkUniquenessException(e2);
                this.updateAdapter.handle(t2);
                bVar.add(-1L);
            }
        }
        x0.g.k(bVar);
        return bVar;
    }
}
