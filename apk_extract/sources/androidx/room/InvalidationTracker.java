package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.room.InvalidationTracker;
import c0.k;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import v0.h;
import v0.l;
import v0.m;
import w0.i;

/* loaded from: classes.dex */
public class InvalidationTracker {
    private static final String CREATE_TRACKING_TABLE_SQL = "CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)";
    private static final String INVALIDATED_COLUMN_NAME = "invalidated";
    public static final String RESET_UPDATED_TABLES_SQL = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1";
    public static final String SELECT_UPDATED_TABLES_SQL = "SELECT * FROM room_table_modification_log WHERE invalidated = 1;";
    private static final String TABLE_ID_COLUMN_NAME = "table_id";
    private static final String UPDATE_TABLE_NAME = "room_table_modification_log";
    private AutoCloser autoCloser;
    private volatile k cleanupStatement;
    private final RoomDatabase database;
    private volatile boolean initialized;
    private final InvalidationLiveDataContainer invalidationLiveDataContainer;
    private MultiInstanceInvalidationClient multiInstanceInvalidationClient;
    private final ObservedTableTracker observedTableTracker;
    private final e.g observerMap;
    private final AtomicBoolean pendingRefresh;
    public final Runnable refreshRunnable;
    private final Map<String, String> shadowTablesMap;
    private final Object syncTriggersLock;
    private final Map<String, Integer> tableIdLookup;
    private final String[] tablesNames;
    private final Object trackerLock;
    private final Map<String, Set<String>> viewTables;
    public static final Companion Companion = new Companion(null);
    private static final String[] TRIGGERS = {"UPDATE", "DELETE", "INSERT"};

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        public static /* synthetic */ void getRESET_UPDATED_TABLES_SQL$room_runtime_release$annotations() {
        }

        public static /* synthetic */ void getSELECT_UPDATED_TABLES_SQL$room_runtime_release$annotations() {
        }

        public final void beginTransactionInternal$room_runtime_release(c0.b bVar) {
            x0.g.u(bVar, "database");
            if (bVar.isWriteAheadLoggingEnabled()) {
                bVar.beginTransactionNonExclusive();
            } else {
                bVar.beginTransaction();
            }
        }

        public final String getTriggerName$room_runtime_release(String str, String str2) {
            x0.g.u(str, "tableName");
            x0.g.u(str2, "triggerType");
            return "`room_table_modification_trigger_" + str + '_' + str2 + '`';
        }
    }

    public static final class ObservedTableTracker {
        public static final int ADD = 1;
        public static final Companion Companion = new Companion(null);
        public static final int NO_OP = 0;
        public static final int REMOVE = 2;
        private boolean needsSync;
        private final long[] tableObservers;
        private final int[] triggerStateChanges;
        private final boolean[] triggerStates;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
                this();
            }
        }

        public ObservedTableTracker(int i2) {
            this.tableObservers = new long[i2];
            this.triggerStates = new boolean[i2];
            this.triggerStateChanges = new int[i2];
        }

        public final boolean getNeedsSync() {
            return this.needsSync;
        }

        public final long[] getTableObservers() {
            return this.tableObservers;
        }

        public final int[] getTablesToSync() {
            synchronized (this) {
                try {
                    if (!this.needsSync) {
                        return null;
                    }
                    long[] jArr = this.tableObservers;
                    int length = jArr.length;
                    int i2 = 0;
                    int i3 = 0;
                    while (i2 < length) {
                        int i4 = i3 + 1;
                        int i5 = 1;
                        boolean z2 = jArr[i2] > 0;
                        boolean[] zArr = this.triggerStates;
                        if (z2 != zArr[i3]) {
                            int[] iArr = this.triggerStateChanges;
                            if (!z2) {
                                i5 = 2;
                            }
                            iArr[i3] = i5;
                        } else {
                            this.triggerStateChanges[i3] = 0;
                        }
                        zArr[i3] = z2;
                        i2++;
                        i3 = i4;
                    }
                    this.needsSync = false;
                    return (int[]) this.triggerStateChanges.clone();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final boolean onAdded(int... iArr) {
            boolean z2;
            x0.g.u(iArr, "tableIds");
            synchronized (this) {
                z2 = false;
                for (int i2 : iArr) {
                    long[] jArr = this.tableObservers;
                    long j2 = jArr[i2];
                    jArr[i2] = 1 + j2;
                    if (j2 == 0) {
                        z2 = true;
                        this.needsSync = true;
                    }
                }
            }
            return z2;
        }

        public final boolean onRemoved(int... iArr) {
            boolean z2;
            x0.g.u(iArr, "tableIds");
            synchronized (this) {
                z2 = false;
                for (int i2 : iArr) {
                    long[] jArr = this.tableObservers;
                    long j2 = jArr[i2];
                    jArr[i2] = j2 - 1;
                    if (j2 == 1) {
                        z2 = true;
                        this.needsSync = true;
                    }
                }
            }
            return z2;
        }

        public final void resetTriggerState() {
            synchronized (this) {
                Arrays.fill(this.triggerStates, false);
                this.needsSync = true;
            }
        }

        public final void setNeedsSync(boolean z2) {
            this.needsSync = z2;
        }
    }

    public static final class ObserverWrapper {
        private final Observer observer;
        private final Set<String> singleTableSet;
        private final int[] tableIds;
        private final String[] tableNames;

        public ObserverWrapper(Observer observer, int[] iArr, String[] strArr) {
            Set<String> setSingleton;
            x0.g.u(observer, "observer");
            x0.g.u(iArr, "tableIds");
            x0.g.u(strArr, "tableNames");
            this.observer = observer;
            this.tableIds = iArr;
            this.tableNames = strArr;
            if (!(strArr.length == 0)) {
                setSingleton = Collections.singleton(strArr[0]);
                x0.g.t(setSingleton, "singleton(element)");
            } else {
                setSingleton = m.f2602a;
            }
            this.singleTableSet = setSingleton;
            if (iArr.length != strArr.length) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }

        public final Observer getObserver$room_runtime_release() {
            return this.observer;
        }

        public final int[] getTableIds$room_runtime_release() {
            return this.tableIds;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v3, types: [w0.i] */
        public final void notifyByTableInvalidStatus$room_runtime_release(Set<Integer> set) {
            x0.g.u(set, "invalidatedTablesIds");
            int[] iArr = this.tableIds;
            int length = iArr.length;
            Set set2 = m.f2602a;
            Set set3 = set2;
            if (length != 0) {
                int i2 = 0;
                if (length != 1) {
                    ?? iVar = new i();
                    int[] iArr2 = this.tableIds;
                    int length2 = iArr2.length;
                    int i3 = 0;
                    while (i2 < length2) {
                        int i4 = i3 + 1;
                        if (set.contains(Integer.valueOf(iArr2[i2]))) {
                            iVar.add(this.tableNames[i3]);
                        }
                        i2++;
                        i3 = i4;
                    }
                    x0.g.l(iVar);
                    set3 = iVar;
                } else {
                    set3 = set2;
                    if (set.contains(Integer.valueOf(iArr[0]))) {
                        set3 = this.singleTableSet;
                    }
                }
            }
            if (!set3.isEmpty()) {
                this.observer.onInvalidated(set3);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v1, types: [androidx.room.InvalidationTracker$Observer] */
        /* JADX WARN: Type inference failed for: r1v0, types: [v0.m] */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Collection, java.util.Set] */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.util.Set<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r1v3, types: [w0.i] */
        public final void notifyByTableNames$room_runtime_release(String[] strArr) {
            x0.g.u(strArr, "tables");
            int length = this.tableNames.length;
            ?? iVar = m.f2602a;
            if (length != 0) {
                if (length != 1) {
                    iVar = new i();
                    for (String str : strArr) {
                        for (String str2 : this.tableNames) {
                            if (i1.c.F0(str2, str)) {
                                iVar.add(str2);
                            }
                        }
                    }
                    x0.g.l(iVar);
                } else {
                    int length2 = strArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length2) {
                            break;
                        }
                        if (i1.c.F0(strArr[i2], this.tableNames[0])) {
                            iVar = this.singleTableSet;
                            break;
                        }
                        i2++;
                    }
                }
            }
            if (!iVar.isEmpty()) {
                this.observer.onInvalidated(iVar);
            }
        }
    }

    public static final class WeakObserver extends Observer {
        private final WeakReference<Observer> delegateRef;
        private final InvalidationTracker tracker;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WeakObserver(InvalidationTracker invalidationTracker, Observer observer) {
            super(observer.getTables$room_runtime_release());
            x0.g.u(invalidationTracker, "tracker");
            x0.g.u(observer, "delegate");
            this.tracker = invalidationTracker;
            this.delegateRef = new WeakReference<>(observer);
        }

        public final WeakReference<Observer> getDelegateRef() {
            return this.delegateRef;
        }

        public final InvalidationTracker getTracker() {
            return this.tracker;
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public void onInvalidated(Set<String> set) {
            x0.g.u(set, "tables");
            Observer observer = this.delegateRef.get();
            if (observer == null) {
                this.tracker.removeObserver(this);
            } else {
                observer.onInvalidated(set);
            }
        }
    }

    public InvalidationTracker(RoomDatabase roomDatabase, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        String lowerCase;
        x0.g.u(roomDatabase, "database");
        x0.g.u(map, "shadowTablesMap");
        x0.g.u(map2, "viewTables");
        x0.g.u(strArr, "tableNames");
        this.database = roomDatabase;
        this.shadowTablesMap = map;
        this.viewTables = map2;
        this.pendingRefresh = new AtomicBoolean(false);
        this.observedTableTracker = new ObservedTableTracker(strArr.length);
        this.invalidationLiveDataContainer = new InvalidationLiveDataContainer(roomDatabase);
        this.observerMap = new e.g();
        this.syncTriggersLock = new Object();
        this.trackerLock = new Object();
        this.tableIdLookup = new LinkedHashMap();
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String str = strArr[i2];
            Locale locale = Locale.US;
            x0.g.t(locale, "US");
            String lowerCase2 = str.toLowerCase(locale);
            x0.g.t(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            this.tableIdLookup.put(lowerCase2, Integer.valueOf(i2));
            String str2 = this.shadowTablesMap.get(strArr[i2]);
            if (str2 != null) {
                x0.g.t(locale, "US");
                lowerCase = str2.toLowerCase(locale);
                x0.g.t(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr2[i2] = lowerCase2;
        }
        this.tablesNames = strArr2;
        for (Map.Entry<String, String> entry : this.shadowTablesMap.entrySet()) {
            String value = entry.getValue();
            Locale locale2 = Locale.US;
            x0.g.t(locale2, "US");
            String lowerCase3 = value.toLowerCase(locale2);
            x0.g.t(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
            if (this.tableIdLookup.containsKey(lowerCase3)) {
                String key = entry.getKey();
                x0.g.t(locale2, "US");
                String lowerCase4 = key.toLowerCase(locale2);
                x0.g.t(lowerCase4, "this as java.lang.String).toLowerCase(locale)");
                Map<String, Integer> map3 = this.tableIdLookup;
                x0.g.u(map3, "<this>");
                Integer num = map3.get(lowerCase3);
                if (num == null && !map3.containsKey(lowerCase3)) {
                    throw new NoSuchElementException("Key " + ((Object) lowerCase3) + " is missing in the map.");
                }
                map3.put(lowerCase4, num);
            }
        }
        this.refreshRunnable = new Runnable() { // from class: androidx.room.InvalidationTracker$refreshRunnable$1
            private final Set<Integer> checkUpdatedTable() throws IOException {
                InvalidationTracker invalidationTracker = this.this$0;
                i iVar = new i();
                Cursor cursorQuery$default = RoomDatabase.query$default(invalidationTracker.getDatabase$room_runtime_release(), new c0.a(InvalidationTracker.SELECT_UPDATED_TABLES_SQL), null, 2, null);
                while (cursorQuery$default.moveToNext()) {
                    try {
                        iVar.add(Integer.valueOf(cursorQuery$default.getInt(0)));
                    } finally {
                    }
                }
                x0.g.y(cursorQuery$default, null);
                x0.g.l(iVar);
                if (!iVar.f2647a.isEmpty()) {
                    if (this.this$0.getCleanupStatement$room_runtime_release() == null) {
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    k cleanupStatement$room_runtime_release = this.this$0.getCleanupStatement$room_runtime_release();
                    if (cleanupStatement$room_runtime_release == null) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    cleanupStatement$room_runtime_release.executeUpdateDelete();
                }
                return iVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Set<Integer> setCheckUpdatedTable;
                AutoCloser autoCloser;
                AutoCloser autoCloser2;
                Lock closeLock$room_runtime_release = this.this$0.getDatabase$room_runtime_release().getCloseLock$room_runtime_release();
                closeLock$room_runtime_release.lock();
                try {
                    try {
                    } finally {
                        closeLock$room_runtime_release.unlock();
                        autoCloser2 = this.this$0.autoCloser;
                        if (autoCloser2 != null) {
                            autoCloser2.decrementCountAndScheduleClose();
                        }
                    }
                } catch (SQLiteException e2) {
                    Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e2);
                    setCheckUpdatedTable = m.f2602a;
                    closeLock$room_runtime_release.unlock();
                    autoCloser = this.this$0.autoCloser;
                    if (autoCloser != null) {
                    }
                } catch (IllegalStateException e3) {
                    Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e3);
                    setCheckUpdatedTable = m.f2602a;
                    closeLock$room_runtime_release.unlock();
                    autoCloser = this.this$0.autoCloser;
                    if (autoCloser != null) {
                    }
                }
                if (!this.this$0.ensureInitialization$room_runtime_release()) {
                    if (autoCloser2 != null) {
                        return;
                    } else {
                        return;
                    }
                }
                if (!this.this$0.getPendingRefresh().compareAndSet(true, false)) {
                    closeLock$room_runtime_release.unlock();
                    AutoCloser autoCloser3 = this.this$0.autoCloser;
                    if (autoCloser3 != null) {
                        autoCloser3.decrementCountAndScheduleClose();
                        return;
                    }
                    return;
                }
                if (this.this$0.getDatabase$room_runtime_release().inTransaction()) {
                    closeLock$room_runtime_release.unlock();
                    AutoCloser autoCloser4 = this.this$0.autoCloser;
                    if (autoCloser4 != null) {
                        autoCloser4.decrementCountAndScheduleClose();
                        return;
                    }
                    return;
                }
                c0.b writableDatabase = this.this$0.getDatabase$room_runtime_release().getOpenHelper().getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    setCheckUpdatedTable = checkUpdatedTable();
                    writableDatabase.setTransactionSuccessful();
                    closeLock$room_runtime_release.unlock();
                    autoCloser = this.this$0.autoCloser;
                    if (autoCloser != null) {
                        autoCloser.decrementCountAndScheduleClose();
                    }
                    if (!setCheckUpdatedTable.isEmpty()) {
                        e.g observerMap$room_runtime_release = this.this$0.getObserverMap$room_runtime_release();
                        InvalidationTracker invalidationTracker = this.this$0;
                        synchronized (observerMap$room_runtime_release) {
                            Iterator it = invalidationTracker.getObserverMap$room_runtime_release().iterator();
                            while (it.hasNext()) {
                                ((InvalidationTracker.ObserverWrapper) ((Map.Entry) it.next()).getValue()).notifyByTableInvalidStatus$room_runtime_release(setCheckUpdatedTable);
                            }
                        }
                    }
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        };
    }

    public static /* synthetic */ void getRefreshRunnable$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAutoCloseCallback() {
        synchronized (this.trackerLock) {
            this.initialized = false;
            this.observedTableTracker.resetTriggerState();
            k kVar = this.cleanupStatement;
            if (kVar != null) {
                kVar.close();
            }
        }
    }

    private final String[] resolveViews(String[] strArr) {
        i iVar = new i();
        for (String str : strArr) {
            Map<String, Set<String>> map = this.viewTables;
            Locale locale = Locale.US;
            x0.g.t(locale, "US");
            String lowerCase = str.toLowerCase(locale);
            x0.g.t(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (map.containsKey(lowerCase)) {
                Map<String, Set<String>> map2 = this.viewTables;
                String lowerCase2 = str.toLowerCase(locale);
                x0.g.t(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                Set<String> set = map2.get(lowerCase2);
                x0.g.q(set);
                iVar.addAll(set);
            } else {
                iVar.add(str);
            }
        }
        x0.g.l(iVar);
        return (String[]) iVar.toArray(new String[0]);
    }

    private final void startTrackingTable(c0.b bVar, int i2) {
        bVar.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i2 + ", 0)");
        String str = this.tablesNames[i2];
        for (String str2 : TRIGGERS) {
            String str3 = "CREATE TEMP TRIGGER IF NOT EXISTS " + Companion.getTriggerName$room_runtime_release(str, str2) + " AFTER " + str2 + " ON `" + str + "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = " + i2 + " AND invalidated = 0; END";
            x0.g.t(str3, "StringBuilder().apply(builderAction).toString()");
            bVar.execSQL(str3);
        }
    }

    private final void stopTrackingTable(c0.b bVar, int i2) {
        String str = this.tablesNames[i2];
        for (String str2 : TRIGGERS) {
            String str3 = "DROP TRIGGER IF EXISTS " + Companion.getTriggerName$room_runtime_release(str, str2);
            x0.g.t(str3, "StringBuilder().apply(builderAction).toString()");
            bVar.execSQL(str3);
        }
    }

    private final String[] validateAndResolveTableNames(String[] strArr) {
        String[] strArrResolveViews = resolveViews(strArr);
        for (String str : strArrResolveViews) {
            Map<String, Integer> map = this.tableIdLookup;
            Locale locale = Locale.US;
            x0.g.t(locale, "US");
            String lowerCase = str.toLowerCase(locale);
            x0.g.t(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (!map.containsKey(lowerCase)) {
                throw new IllegalArgumentException("There is no table with name ".concat(str).toString());
            }
        }
        return strArrResolveViews;
    }

    @SuppressLint({"RestrictedApi"})
    public void addObserver(Observer observer) {
        ObserverWrapper observerWrapper;
        x0.g.u(observer, "observer");
        String[] strArrResolveViews = resolveViews(observer.getTables$room_runtime_release());
        ArrayList arrayList = new ArrayList(strArrResolveViews.length);
        for (String str : strArrResolveViews) {
            Map<String, Integer> map = this.tableIdLookup;
            Locale locale = Locale.US;
            x0.g.t(locale, "US");
            String lowerCase = str.toLowerCase(locale);
            x0.g.t(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            Integer num = map.get(lowerCase);
            if (num == null) {
                throw new IllegalArgumentException("There is no table with name ".concat(str));
            }
            arrayList.add(Integer.valueOf(num.intValue()));
        }
        int[] iArrO0 = v0.i.O0(arrayList);
        ObserverWrapper observerWrapper2 = new ObserverWrapper(observer, iArrO0, strArrResolveViews);
        synchronized (this.observerMap) {
            observerWrapper = (ObserverWrapper) this.observerMap.b(observer, observerWrapper2);
        }
        if (observerWrapper == null && this.observedTableTracker.onAdded(Arrays.copyOf(iArrO0, iArrO0.length))) {
            syncTriggers$room_runtime_release();
        }
    }

    public void addWeakObserver(Observer observer) {
        x0.g.u(observer, "observer");
        addObserver(new WeakObserver(this, observer));
    }

    public <T> LiveData<T> createLiveData(String[] strArr, Callable<T> callable) {
        x0.g.u(strArr, "tableNames");
        x0.g.u(callable, "computeFunction");
        return createLiveData(strArr, false, callable);
    }

    public final boolean ensureInitialization$room_runtime_release() {
        if (!this.database.isOpenInternal()) {
            return false;
        }
        if (!this.initialized) {
            this.database.getOpenHelper().getWritableDatabase();
        }
        if (this.initialized) {
            return true;
        }
        Log.e(Room.LOG_TAG, "database is not initialized even though it is open");
        return false;
    }

    public final k getCleanupStatement$room_runtime_release() {
        return this.cleanupStatement;
    }

    public final RoomDatabase getDatabase$room_runtime_release() {
        return this.database;
    }

    public final e.g getObserverMap$room_runtime_release() {
        return this.observerMap;
    }

    public final AtomicBoolean getPendingRefresh() {
        return this.pendingRefresh;
    }

    public final Map<String, Integer> getTableIdLookup$room_runtime_release() {
        return this.tableIdLookup;
    }

    public final String[] getTablesNames$room_runtime_release() {
        return this.tablesNames;
    }

    public final void internalInit$room_runtime_release(c0.b bVar) {
        x0.g.u(bVar, "database");
        synchronized (this.trackerLock) {
            if (this.initialized) {
                Log.e(Room.LOG_TAG, "Invalidation tracker is initialized twice :/.");
                return;
            }
            bVar.execSQL("PRAGMA temp_store = MEMORY;");
            bVar.execSQL("PRAGMA recursive_triggers='ON';");
            bVar.execSQL(CREATE_TRACKING_TABLE_SQL);
            syncTriggers$room_runtime_release(bVar);
            this.cleanupStatement = bVar.compileStatement(RESET_UPDATED_TABLES_SQL);
            this.initialized = true;
        }
    }

    public final void notifyObserversByTableNames(String... strArr) {
        x0.g.u(strArr, "tables");
        synchronized (this.observerMap) {
            for (Map.Entry entry : this.observerMap) {
                x0.g.t(entry, "(observer, wrapper)");
                Observer observer = (Observer) entry.getKey();
                ObserverWrapper observerWrapper = (ObserverWrapper) entry.getValue();
                if (!observer.isRemote$room_runtime_release()) {
                    observerWrapper.notifyByTableNames$room_runtime_release(strArr);
                }
            }
        }
    }

    public void refreshVersionsAsync() {
        if (this.pendingRefresh.compareAndSet(false, true)) {
            AutoCloser autoCloser = this.autoCloser;
            if (autoCloser != null) {
                autoCloser.incrementCountAndEnsureDbIsOpen();
            }
            this.database.getQueryExecutor().execute(this.refreshRunnable);
        }
    }

    public void refreshVersionsSync() {
        AutoCloser autoCloser = this.autoCloser;
        if (autoCloser != null) {
            autoCloser.incrementCountAndEnsureDbIsOpen();
        }
        syncTriggers$room_runtime_release();
        this.refreshRunnable.run();
    }

    @SuppressLint({"RestrictedApi"})
    public void removeObserver(Observer observer) {
        ObserverWrapper observerWrapper;
        x0.g.u(observer, "observer");
        synchronized (this.observerMap) {
            observerWrapper = (ObserverWrapper) this.observerMap.c(observer);
        }
        if (observerWrapper != null) {
            ObservedTableTracker observedTableTracker = this.observedTableTracker;
            int[] tableIds$room_runtime_release = observerWrapper.getTableIds$room_runtime_release();
            if (observedTableTracker.onRemoved(Arrays.copyOf(tableIds$room_runtime_release, tableIds$room_runtime_release.length))) {
                syncTriggers$room_runtime_release();
            }
        }
    }

    public final void setAutoCloser$room_runtime_release(AutoCloser autoCloser) {
        x0.g.u(autoCloser, "autoCloser");
        this.autoCloser = autoCloser;
        autoCloser.setAutoCloseCallback(new androidx.activity.b(3, this));
    }

    public final void setCleanupStatement$room_runtime_release(k kVar) {
        this.cleanupStatement = kVar;
    }

    public final void startMultiInstanceInvalidation$room_runtime_release(Context context, String str, Intent intent) {
        x0.g.u(context, "context");
        x0.g.u(str, "name");
        x0.g.u(intent, "serviceIntent");
        this.multiInstanceInvalidationClient = new MultiInstanceInvalidationClient(context, str, intent, this, this.database.getQueryExecutor());
    }

    public final void stopMultiInstanceInvalidation$room_runtime_release() {
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.multiInstanceInvalidationClient;
        if (multiInstanceInvalidationClient != null) {
            multiInstanceInvalidationClient.stop();
        }
        this.multiInstanceInvalidationClient = null;
    }

    public final void syncTriggers$room_runtime_release(c0.b bVar) {
        x0.g.u(bVar, "database");
        if (bVar.inTransaction()) {
            return;
        }
        try {
            Lock closeLock$room_runtime_release = this.database.getCloseLock$room_runtime_release();
            closeLock$room_runtime_release.lock();
            try {
                synchronized (this.syncTriggersLock) {
                    int[] tablesToSync = this.observedTableTracker.getTablesToSync();
                    if (tablesToSync == null) {
                        return;
                    }
                    Companion.beginTransactionInternal$room_runtime_release(bVar);
                    try {
                        int length = tablesToSync.length;
                        int i2 = 0;
                        int i3 = 0;
                        while (i2 < length) {
                            int i4 = tablesToSync[i2];
                            int i5 = i3 + 1;
                            if (i4 == 1) {
                                startTrackingTable(bVar, i3);
                            } else if (i4 == 2) {
                                stopTrackingTable(bVar, i3);
                            }
                            i2++;
                            i3 = i5;
                        }
                        bVar.setTransactionSuccessful();
                        bVar.endTransaction();
                    } catch (Throwable th) {
                        bVar.endTransaction();
                        throw th;
                    }
                }
            } finally {
                closeLock$room_runtime_release.unlock();
            }
        } catch (SQLiteException e2) {
            Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e2);
        } catch (IllegalStateException e3) {
            Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e3);
        }
    }

    public <T> LiveData<T> createLiveData(String[] strArr, boolean z2, Callable<T> callable) {
        x0.g.u(strArr, "tableNames");
        x0.g.u(callable, "computeFunction");
        return this.invalidationLiveDataContainer.create(validateAndResolveTableNames(strArr), z2, callable);
    }

    public static abstract class Observer {
        private final String[] tables;

        public Observer(String str, String... strArr) {
            x0.g.u(str, "firstTable");
            x0.g.u(strArr, "rest");
            w0.b bVar = new w0.b();
            h.M0(bVar, strArr);
            bVar.add(str);
            x0.g.k(bVar);
            this((String[]) bVar.toArray(new String[0]));
        }

        public final String[] getTables$room_runtime_release() {
            return this.tables;
        }

        public boolean isRemote$room_runtime_release() {
            return false;
        }

        public abstract void onInvalidated(Set<String> set);

        public Observer(String[] strArr) {
            x0.g.u(strArr, "tables");
            this.tables = strArr;
        }
    }

    public final void syncTriggers$room_runtime_release() {
        if (this.database.isOpenInternal()) {
            syncTriggers$room_runtime_release(this.database.getOpenHelper().getWritableDatabase());
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public InvalidationTracker(RoomDatabase roomDatabase, String... strArr) {
        x0.g.u(roomDatabase, "database");
        x0.g.u(strArr, "tableNames");
        l lVar = l.f2601a;
        this(roomDatabase, lVar, lVar, (String[]) Arrays.copyOf(strArr, strArr.length));
    }
}
