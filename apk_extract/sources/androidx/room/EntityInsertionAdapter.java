package androidx.room;

import c0.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntityInsertionAdapter(RoomDatabase roomDatabase) {
        super(roomDatabase);
        x0.g.u(roomDatabase, "database");
    }

    public abstract void bind(k kVar, T t2);

    public final void insert(T t2) {
        k kVarAcquire = acquire();
        try {
            bind(kVarAcquire, t2);
            kVarAcquire.executeInsert();
        } finally {
            release(kVarAcquire);
        }
    }

    public final long insertAndReturnId(T t2) {
        k kVarAcquire = acquire();
        try {
            bind(kVarAcquire, t2);
            return kVarAcquire.executeInsert();
        } finally {
            release(kVarAcquire);
        }
    }

    public final long[] insertAndReturnIdsArray(Collection<? extends T> collection) {
        x0.g.u(collection, "entities");
        k kVarAcquire = acquire();
        try {
            long[] jArr = new long[collection.size()];
            int i2 = 0;
            for (T t2 : collection) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                bind(kVarAcquire, t2);
                jArr[i2] = kVarAcquire.executeInsert();
                i2 = i3;
            }
            release(kVarAcquire);
            return jArr;
        } catch (Throwable th) {
            release(kVarAcquire);
            throw th;
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection<? extends T> collection) {
        x0.g.u(collection, "entities");
        k kVarAcquire = acquire();
        Iterator<? extends T> it = collection.iterator();
        try {
            int size = collection.size();
            Long[] lArr = new Long[size];
            for (int i2 = 0; i2 < size; i2++) {
                bind(kVarAcquire, it.next());
                lArr[i2] = Long.valueOf(kVarAcquire.executeInsert());
            }
            return lArr;
        } finally {
            release(kVarAcquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(T[] tArr) {
        x0.g.u(tArr, "entities");
        k kVarAcquire = acquire();
        try {
            w0.b bVar = new w0.b();
            for (T t2 : tArr) {
                bind(kVarAcquire, t2);
                bVar.add(Long.valueOf(kVarAcquire.executeInsert()));
            }
            x0.g.k(bVar);
            release(kVarAcquire);
            return bVar;
        } catch (Throwable th) {
            release(kVarAcquire);
            throw th;
        }
    }

    public final void insert(T[] tArr) {
        x0.g.u(tArr, "entities");
        k kVarAcquire = acquire();
        try {
            for (T t2 : tArr) {
                bind(kVarAcquire, t2);
                kVarAcquire.executeInsert();
            }
        } finally {
            release(kVarAcquire);
        }
    }

    public final long[] insertAndReturnIdsArray(T[] tArr) {
        x0.g.u(tArr, "entities");
        k kVarAcquire = acquire();
        try {
            long[] jArr = new long[tArr.length];
            int length = tArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int i4 = i3 + 1;
                bind(kVarAcquire, tArr[i2]);
                jArr[i3] = kVarAcquire.executeInsert();
                i2++;
                i3 = i4;
            }
            return jArr;
        } finally {
            release(kVarAcquire);
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(T[] tArr) {
        x0.g.u(tArr, "entities");
        k kVarAcquire = acquire();
        try {
            int length = tArr.length;
            Long[] lArr = new Long[length];
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int i4 = i3 + 1;
                try {
                    bind(kVarAcquire, tArr[i3]);
                    lArr[i2] = Long.valueOf(kVarAcquire.executeInsert());
                    i2++;
                    i3 = i4;
                } catch (ArrayIndexOutOfBoundsException e2) {
                    throw new NoSuchElementException(e2.getMessage());
                }
            }
            release(kVarAcquire);
            return lArr;
        } catch (Throwable th) {
            release(kVarAcquire);
            throw th;
        }
    }

    public final List<Long> insertAndReturnIdsList(Collection<? extends T> collection) {
        x0.g.u(collection, "entities");
        k kVarAcquire = acquire();
        try {
            w0.b bVar = new w0.b();
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                bind(kVarAcquire, it.next());
                bVar.add(Long.valueOf(kVarAcquire.executeInsert()));
            }
            x0.g.k(bVar);
            release(kVarAcquire);
            return bVar;
        } catch (Throwable th) {
            release(kVarAcquire);
            throw th;
        }
    }

    public final void insert(Iterable<? extends T> iterable) {
        x0.g.u(iterable, "entities");
        k kVarAcquire = acquire();
        try {
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                bind(kVarAcquire, it.next());
                kVarAcquire.executeInsert();
            }
        } finally {
            release(kVarAcquire);
        }
    }
}
