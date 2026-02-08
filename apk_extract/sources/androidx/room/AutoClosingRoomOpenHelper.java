package androidx.room;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteTransactionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Pair;
import c0.h;
import c0.j;
import c0.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.o;

/* loaded from: classes.dex */
public final class AutoClosingRoomOpenHelper implements h, DelegatingOpenHelper {
    public final AutoCloser autoCloser;
    private final AutoClosingSupportSQLiteDatabase autoClosingDb;
    private final h delegate;

    public static final class AutoClosingSupportSQLiteDatabase implements c0.b {
        private final AutoCloser autoCloser;

        public AutoClosingSupportSQLiteDatabase(AutoCloser autoCloser) {
            x0.g.u(autoCloser, "autoCloser");
            this.autoCloser = autoCloser;
        }

        @Override // c0.b
        public void beginTransaction() {
            try {
                this.autoCloser.incrementCountAndEnsureDbIsOpen().beginTransaction();
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // c0.b
        public void beginTransactionNonExclusive() {
            try {
                this.autoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionNonExclusive();
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // c0.b
        public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
            x0.g.u(sQLiteTransactionListener, "transactionListener");
            try {
                this.autoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListener(sQLiteTransactionListener);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // c0.b
        public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
            x0.g.u(sQLiteTransactionListener, "transactionListener");
            try {
                this.autoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.autoCloser.closeDatabaseIfOpen();
        }

        @Override // c0.b
        public k compileStatement(String str) {
            x0.g.u(str, "sql");
            return new AutoClosingSupportSqliteStatement(str, this.autoCloser);
        }

        @Override // c0.b
        public int delete(String str, String str2, Object[] objArr) {
            x0.g.u(str, "table");
            return ((Number) this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$delete$1(str, str2, objArr))).intValue();
        }

        @Override // c0.b
        public void disableWriteAheadLogging() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        @Override // c0.b
        public boolean enableWriteAheadLogging() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        @Override // c0.b
        public void endTransaction() {
            if (this.autoCloser.getDelegateDatabase$room_runtime_release() == null) {
                throw new IllegalStateException("End transaction called but delegateDb is null".toString());
            }
            try {
                c0.b delegateDatabase$room_runtime_release = this.autoCloser.getDelegateDatabase$room_runtime_release();
                x0.g.q(delegateDatabase$room_runtime_release);
                delegateDatabase$room_runtime_release.endTransaction();
            } finally {
                this.autoCloser.decrementCountAndScheduleClose();
            }
        }

        @Override // c0.b
        public void execPerConnectionSQL(String str, @SuppressLint({"ArrayReturn"}) Object[] objArr) {
            x0.g.u(str, "sql");
            throw new UnsupportedOperationException();
        }

        @Override // c0.b
        public void execSQL(String str) {
            x0.g.u(str, "sql");
            this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$execSQL$1(str));
        }

        @Override // c0.b
        public List<Pair<String, String>> getAttachedDbs() {
            return (List) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$attachedDbs$1.INSTANCE);
        }

        @Override // c0.b
        public long getMaximumSize() {
            return ((Number) this.autoCloser.executeRefCountingFunction(new o() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$maximumSize$1
                @Override // g1.k
                public Object get(Object obj) {
                    return Long.valueOf(((c0.b) obj).getMaximumSize());
                }
            })).longValue();
        }

        @Override // c0.b
        public long getPageSize() {
            return ((Number) this.autoCloser.executeRefCountingFunction(new l() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$1
                @Override // g1.k
                public Object get(Object obj) {
                    return Long.valueOf(((c0.b) obj).getPageSize());
                }

                public void set(Object obj, Object obj2) {
                    ((c0.b) obj).setPageSize(((Number) obj2).longValue());
                }
            })).longValue();
        }

        @Override // c0.b
        public String getPath() {
            return (String) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$path$1.INSTANCE);
        }

        @Override // c0.b
        public int getVersion() {
            return ((Number) this.autoCloser.executeRefCountingFunction(new l() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1
                @Override // g1.k
                public Object get(Object obj) {
                    return Integer.valueOf(((c0.b) obj).getVersion());
                }

                public void set(Object obj, Object obj2) {
                    ((c0.b) obj).setVersion(((Number) obj2).intValue());
                }
            })).intValue();
        }

        @Override // c0.b
        public boolean inTransaction() {
            if (this.autoCloser.getDelegateDatabase$room_runtime_release() == null) {
                return false;
            }
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1.INSTANCE)).booleanValue();
        }

        @Override // c0.b
        public long insert(String str, int i2, ContentValues contentValues) {
            x0.g.u(str, "table");
            x0.g.u(contentValues, "values");
            return ((Number) this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$insert$1(str, i2, contentValues))).longValue();
        }

        @Override // c0.b
        public boolean isDatabaseIntegrityOk() {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isDatabaseIntegrityOk$1.INSTANCE)).booleanValue();
        }

        @Override // c0.b
        public boolean isDbLockedByCurrentThread() {
            if (this.autoCloser.getDelegateDatabase$room_runtime_release() == null) {
                return false;
            }
            return ((Boolean) this.autoCloser.executeRefCountingFunction(new o() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isDbLockedByCurrentThread$1
                @Override // g1.k
                public Object get(Object obj) {
                    return Boolean.valueOf(((c0.b) obj).isDbLockedByCurrentThread());
                }
            })).booleanValue();
        }

        @Override // c0.b
        public /* bridge */ /* synthetic */ boolean isExecPerConnectionSQLSupported() {
            return false;
        }

        @Override // c0.b
        public boolean isOpen() {
            c0.b delegateDatabase$room_runtime_release = this.autoCloser.getDelegateDatabase$room_runtime_release();
            if (delegateDatabase$room_runtime_release == null) {
                return false;
            }
            return delegateDatabase$room_runtime_release.isOpen();
        }

        @Override // c0.b
        public boolean isReadOnly() {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isReadOnly$1.INSTANCE)).booleanValue();
        }

        @Override // c0.b
        public boolean isWriteAheadLoggingEnabled() {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isWriteAheadLoggingEnabled$1.INSTANCE)).booleanValue();
        }

        @Override // c0.b
        public boolean needUpgrade(int i2) {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$needUpgrade$1(i2))).booleanValue();
        }

        public final void pokeOpen() {
            this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pokeOpen$1.INSTANCE);
        }

        @Override // c0.b
        public Cursor query(String str) {
            x0.g.u(str, "query");
            try {
                return new KeepAliveCursor(this.autoCloser.incrementCountAndEnsureDbIsOpen().query(str), this.autoCloser);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // c0.b
        public void setForeignKeyConstraintsEnabled(boolean z2) {
            this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setForeignKeyConstraintsEnabled$1(z2));
        }

        @Override // c0.b
        public void setLocale(Locale locale) {
            x0.g.u(locale, "locale");
            this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setLocale$1(locale));
        }

        @Override // c0.b
        public void setMaxSqlCacheSize(int i2) {
            this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setMaxSqlCacheSize$1(i2));
        }

        @Override // c0.b
        public long setMaximumSize(long j2) {
            return ((Number) this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setMaximumSize$1(j2))).longValue();
        }

        @Override // c0.b
        public void setPageSize(long j2) {
            this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$2(j2));
        }

        @Override // c0.b
        public void setTransactionSuccessful() {
            u0.f fVar;
            c0.b delegateDatabase$room_runtime_release = this.autoCloser.getDelegateDatabase$room_runtime_release();
            if (delegateDatabase$room_runtime_release != null) {
                delegateDatabase$room_runtime_release.setTransactionSuccessful();
                fVar = u0.f.f2595a;
            } else {
                fVar = null;
            }
            if (fVar == null) {
                throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null".toString());
            }
        }

        @Override // c0.b
        public void setVersion(int i2) {
            this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$2(i2));
        }

        @Override // c0.b
        public int update(String str, int i2, ContentValues contentValues, String str2, Object[] objArr) {
            x0.g.u(str, "table");
            x0.g.u(contentValues, "values");
            return ((Number) this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$update$1(str, i2, contentValues, str2, objArr))).intValue();
        }

        @Override // c0.b
        public boolean yieldIfContendedSafely() {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$1.INSTANCE)).booleanValue();
        }

        @Override // c0.b
        public void execSQL(String str, Object[] objArr) {
            x0.g.u(str, "sql");
            x0.g.u(objArr, "bindArgs");
            this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$execSQL$2(str, objArr));
        }

        @Override // c0.b
        public boolean yieldIfContendedSafely(long j2) {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$2.INSTANCE)).booleanValue();
        }

        @Override // c0.b
        public Cursor query(String str, Object[] objArr) {
            x0.g.u(str, "query");
            x0.g.u(objArr, "bindArgs");
            try {
                return new KeepAliveCursor(this.autoCloser.incrementCountAndEnsureDbIsOpen().query(str, objArr), this.autoCloser);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // c0.b
        public Cursor query(j jVar) {
            x0.g.u(jVar, "query");
            try {
                return new KeepAliveCursor(this.autoCloser.incrementCountAndEnsureDbIsOpen().query(jVar), this.autoCloser);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // c0.b
        public Cursor query(j jVar, CancellationSignal cancellationSignal) {
            x0.g.u(jVar, "query");
            try {
                return new KeepAliveCursor(this.autoCloser.incrementCountAndEnsureDbIsOpen().query(jVar, cancellationSignal), this.autoCloser);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }
    }

    public static final class AutoClosingSupportSqliteStatement implements k {
        private final AutoCloser autoCloser;
        private final ArrayList<Object> binds;
        private final String sql;

        public AutoClosingSupportSqliteStatement(String str, AutoCloser autoCloser) {
            x0.g.u(str, "sql");
            x0.g.u(autoCloser, "autoCloser");
            this.sql = str;
            this.autoCloser = autoCloser;
            this.binds = new ArrayList<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void doBinds(k kVar) {
            Iterator<T> it = this.binds.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                it.next();
                int i3 = i2 + 1;
                if (i2 < 0) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                Object obj = this.binds.get(i2);
                if (obj == null) {
                    kVar.bindNull(i3);
                } else if (obj instanceof Long) {
                    kVar.bindLong(i3, ((Number) obj).longValue());
                } else if (obj instanceof Double) {
                    kVar.bindDouble(i3, ((Number) obj).doubleValue());
                } else if (obj instanceof String) {
                    kVar.bindString(i3, (String) obj);
                } else if (obj instanceof byte[]) {
                    kVar.bindBlob(i3, (byte[]) obj);
                }
                i2 = i3;
            }
        }

        private final <T> T executeSqliteStatementWithRefCount(c1.l lVar) {
            return (T) this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeSqliteStatementWithRefCount$1(this, lVar));
        }

        private final void saveBinds(int i2, Object obj) {
            int size;
            int i3 = i2 - 1;
            if (i3 >= this.binds.size() && (size = this.binds.size()) <= i3) {
                while (true) {
                    this.binds.add(null);
                    if (size == i3) {
                        break;
                    } else {
                        size++;
                    }
                }
            }
            this.binds.set(i3, obj);
        }

        @Override // c0.i
        public void bindBlob(int i2, byte[] bArr) {
            x0.g.u(bArr, "value");
            saveBinds(i2, bArr);
        }

        @Override // c0.i
        public void bindDouble(int i2, double d2) {
            saveBinds(i2, Double.valueOf(d2));
        }

        @Override // c0.i
        public void bindLong(int i2, long j2) {
            saveBinds(i2, Long.valueOf(j2));
        }

        @Override // c0.i
        public void bindNull(int i2) {
            saveBinds(i2, null);
        }

        @Override // c0.i
        public void bindString(int i2, String str) {
            x0.g.u(str, "value");
            saveBinds(i2, str);
        }

        @Override // c0.i
        public void clearBindings() {
            this.binds.clear();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // c0.k
        public void execute() {
            executeSqliteStatementWithRefCount(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$execute$1.INSTANCE);
        }

        @Override // c0.k
        public long executeInsert() {
            return ((Number) executeSqliteStatementWithRefCount(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeInsert$1.INSTANCE)).longValue();
        }

        @Override // c0.k
        public int executeUpdateDelete() {
            return ((Number) executeSqliteStatementWithRefCount(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeUpdateDelete$1.INSTANCE)).intValue();
        }

        @Override // c0.k
        public long simpleQueryForLong() {
            return ((Number) executeSqliteStatementWithRefCount(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$simpleQueryForLong$1.INSTANCE)).longValue();
        }

        @Override // c0.k
        public String simpleQueryForString() {
            return (String) executeSqliteStatementWithRefCount(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$simpleQueryForString$1.INSTANCE);
        }
    }

    public static final class KeepAliveCursor implements Cursor {
        private final AutoCloser autoCloser;
        private final Cursor delegate;

        public KeepAliveCursor(Cursor cursor, AutoCloser autoCloser) {
            x0.g.u(cursor, "delegate");
            x0.g.u(autoCloser, "autoCloser");
            this.delegate = cursor;
            this.autoCloser = autoCloser;
        }

        @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
            this.autoCloser.decrementCountAndScheduleClose();
        }

        @Override // android.database.Cursor
        public void copyStringToBuffer(int i2, CharArrayBuffer charArrayBuffer) {
            this.delegate.copyStringToBuffer(i2, charArrayBuffer);
        }

        @Override // android.database.Cursor
        public void deactivate() {
            this.delegate.deactivate();
        }

        @Override // android.database.Cursor
        public byte[] getBlob(int i2) {
            return this.delegate.getBlob(i2);
        }

        @Override // android.database.Cursor
        public int getColumnCount() {
            return this.delegate.getColumnCount();
        }

        @Override // android.database.Cursor
        public int getColumnIndex(String str) {
            return this.delegate.getColumnIndex(str);
        }

        @Override // android.database.Cursor
        public int getColumnIndexOrThrow(String str) {
            return this.delegate.getColumnIndexOrThrow(str);
        }

        @Override // android.database.Cursor
        public String getColumnName(int i2) {
            return this.delegate.getColumnName(i2);
        }

        @Override // android.database.Cursor
        public String[] getColumnNames() {
            return this.delegate.getColumnNames();
        }

        @Override // android.database.Cursor
        public int getCount() {
            return this.delegate.getCount();
        }

        @Override // android.database.Cursor
        public double getDouble(int i2) {
            return this.delegate.getDouble(i2);
        }

        @Override // android.database.Cursor
        public Bundle getExtras() {
            return this.delegate.getExtras();
        }

        @Override // android.database.Cursor
        public float getFloat(int i2) {
            return this.delegate.getFloat(i2);
        }

        @Override // android.database.Cursor
        public int getInt(int i2) {
            return this.delegate.getInt(i2);
        }

        @Override // android.database.Cursor
        public long getLong(int i2) {
            return this.delegate.getLong(i2);
        }

        @Override // android.database.Cursor
        public Uri getNotificationUri() {
            Cursor cursor = this.delegate;
            x0.g.u(cursor, "cursor");
            Uri notificationUri = cursor.getNotificationUri();
            x0.g.t(notificationUri, "cursor.notificationUri");
            return notificationUri;
        }

        @Override // android.database.Cursor
        public List<Uri> getNotificationUris() {
            Cursor cursor = this.delegate;
            x0.g.u(cursor, "cursor");
            List<Uri> notificationUris = cursor.getNotificationUris();
            x0.g.q(notificationUris);
            return notificationUris;
        }

        @Override // android.database.Cursor
        public int getPosition() {
            return this.delegate.getPosition();
        }

        @Override // android.database.Cursor
        public short getShort(int i2) {
            return this.delegate.getShort(i2);
        }

        @Override // android.database.Cursor
        public String getString(int i2) {
            return this.delegate.getString(i2);
        }

        @Override // android.database.Cursor
        public int getType(int i2) {
            return this.delegate.getType(i2);
        }

        @Override // android.database.Cursor
        public boolean getWantsAllOnMoveCalls() {
            return this.delegate.getWantsAllOnMoveCalls();
        }

        @Override // android.database.Cursor
        public boolean isAfterLast() {
            return this.delegate.isAfterLast();
        }

        @Override // android.database.Cursor
        public boolean isBeforeFirst() {
            return this.delegate.isBeforeFirst();
        }

        @Override // android.database.Cursor
        public boolean isClosed() {
            return this.delegate.isClosed();
        }

        @Override // android.database.Cursor
        public boolean isFirst() {
            return this.delegate.isFirst();
        }

        @Override // android.database.Cursor
        public boolean isLast() {
            return this.delegate.isLast();
        }

        @Override // android.database.Cursor
        public boolean isNull(int i2) {
            return this.delegate.isNull(i2);
        }

        @Override // android.database.Cursor
        public boolean move(int i2) {
            return this.delegate.move(i2);
        }

        @Override // android.database.Cursor
        public boolean moveToFirst() {
            return this.delegate.moveToFirst();
        }

        @Override // android.database.Cursor
        public boolean moveToLast() {
            return this.delegate.moveToLast();
        }

        @Override // android.database.Cursor
        public boolean moveToNext() {
            return this.delegate.moveToNext();
        }

        @Override // android.database.Cursor
        public boolean moveToPosition(int i2) {
            return this.delegate.moveToPosition(i2);
        }

        @Override // android.database.Cursor
        public boolean moveToPrevious() {
            return this.delegate.moveToPrevious();
        }

        @Override // android.database.Cursor
        public void registerContentObserver(ContentObserver contentObserver) {
            this.delegate.registerContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.delegate.registerDataSetObserver(dataSetObserver);
        }

        @Override // android.database.Cursor
        public boolean requery() {
            return this.delegate.requery();
        }

        @Override // android.database.Cursor
        public Bundle respond(Bundle bundle) {
            return this.delegate.respond(bundle);
        }

        @Override // android.database.Cursor
        public void setExtras(Bundle bundle) {
            x0.g.u(bundle, "extras");
            Cursor cursor = this.delegate;
            x0.g.u(cursor, "cursor");
            cursor.setExtras(bundle);
        }

        @Override // android.database.Cursor
        public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
            this.delegate.setNotificationUri(contentResolver, uri);
        }

        @Override // android.database.Cursor
        public void setNotificationUris(ContentResolver contentResolver, List<? extends Uri> list) {
            x0.g.u(contentResolver, "cr");
            x0.g.u(list, "uris");
            Cursor cursor = this.delegate;
            x0.g.u(cursor, "cursor");
            cursor.setNotificationUris(contentResolver, list);
        }

        @Override // android.database.Cursor
        public void unregisterContentObserver(ContentObserver contentObserver) {
            this.delegate.unregisterContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.delegate.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public AutoClosingRoomOpenHelper(h hVar, AutoCloser autoCloser) {
        x0.g.u(hVar, "delegate");
        x0.g.u(autoCloser, "autoCloser");
        this.delegate = hVar;
        this.autoCloser = autoCloser;
        autoCloser.init(getDelegate());
        this.autoClosingDb = new AutoClosingSupportSQLiteDatabase(autoCloser);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.autoClosingDb.close();
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
        this.autoClosingDb.pokeOpen();
        return this.autoClosingDb;
    }

    @Override // c0.h
    public c0.b getWritableDatabase() {
        this.autoClosingDb.pokeOpen();
        return this.autoClosingDb;
    }

    @Override // c0.h
    public void setWriteAheadLoggingEnabled(boolean z2) {
        this.delegate.setWriteAheadLoggingEnabled(z2);
    }
}
