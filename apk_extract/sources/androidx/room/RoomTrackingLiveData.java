package androidx.room;

import android.annotation.SuppressLint;
import androidx.lifecycle.LiveData;
import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class RoomTrackingLiveData<T> extends LiveData<T> {
    private final Callable<T> computeFunction;
    private final AtomicBoolean computing;
    private final InvalidationLiveDataContainer container;
    private final RoomDatabase database;
    private final boolean inTransaction;
    private final AtomicBoolean invalid;
    private final Runnable invalidationRunnable;
    private final InvalidationTracker.Observer observer;
    private final Runnable refreshRunnable;
    private final AtomicBoolean registeredObserver;

    public RoomTrackingLiveData(RoomDatabase roomDatabase, InvalidationLiveDataContainer invalidationLiveDataContainer, boolean z2, Callable<T> callable, final String[] strArr) {
        x0.g.u(roomDatabase, "database");
        x0.g.u(invalidationLiveDataContainer, "container");
        x0.g.u(callable, "computeFunction");
        x0.g.u(strArr, "tableNames");
        this.database = roomDatabase;
        this.container = invalidationLiveDataContainer;
        this.inTransaction = z2;
        this.computeFunction = callable;
        this.observer = new InvalidationTracker.Observer(strArr) { // from class: androidx.room.RoomTrackingLiveData$observer$1
            @Override // androidx.room.InvalidationTracker.Observer
            public void onInvalidated(Set<String> set) {
                x0.g.u(set, "tables");
                d.b bVarE0 = d.b.E0();
                Runnable invalidationRunnable = this.getInvalidationRunnable();
                if (bVarE0.F0()) {
                    invalidationRunnable.run();
                } else {
                    bVarE0.G0(invalidationRunnable);
                }
            }
        };
        final int i2 = 1;
        this.invalid = new AtomicBoolean(true);
        final int i3 = 0;
        this.computing = new AtomicBoolean(false);
        this.registeredObserver = new AtomicBoolean(false);
        this.refreshRunnable = new Runnable(this) { // from class: androidx.room.g

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ RoomTrackingLiveData f1043b;

            {
                this.f1043b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i4 = i3;
                RoomTrackingLiveData roomTrackingLiveData = this.f1043b;
                switch (i4) {
                    case 0:
                        RoomTrackingLiveData.refreshRunnable$lambda$0(roomTrackingLiveData);
                        break;
                    default:
                        RoomTrackingLiveData.invalidationRunnable$lambda$1(roomTrackingLiveData);
                        break;
                }
            }
        };
        this.invalidationRunnable = new Runnable(this) { // from class: androidx.room.g

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ RoomTrackingLiveData f1043b;

            {
                this.f1043b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i4 = i2;
                RoomTrackingLiveData roomTrackingLiveData = this.f1043b;
                switch (i4) {
                    case 0:
                        RoomTrackingLiveData.refreshRunnable$lambda$0(roomTrackingLiveData);
                        break;
                    default:
                        RoomTrackingLiveData.invalidationRunnable$lambda$1(roomTrackingLiveData);
                        break;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invalidationRunnable$lambda$1(RoomTrackingLiveData roomTrackingLiveData) {
        x0.g.u(roomTrackingLiveData, "this$0");
        boolean zHasActiveObservers = roomTrackingLiveData.hasActiveObservers();
        if (roomTrackingLiveData.invalid.compareAndSet(false, true) && zHasActiveObservers) {
            roomTrackingLiveData.getQueryExecutor().execute(roomTrackingLiveData.refreshRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshRunnable$lambda$0(RoomTrackingLiveData roomTrackingLiveData) {
        x0.g.u(roomTrackingLiveData, "this$0");
        if (roomTrackingLiveData.registeredObserver.compareAndSet(false, true)) {
            roomTrackingLiveData.database.getInvalidationTracker().addWeakObserver(roomTrackingLiveData.observer);
        }
        while (roomTrackingLiveData.computing.compareAndSet(false, true)) {
            T tCall = null;
            boolean z2 = false;
            while (roomTrackingLiveData.invalid.compareAndSet(true, false)) {
                try {
                    try {
                        tCall = roomTrackingLiveData.computeFunction.call();
                        z2 = true;
                    } catch (Exception e2) {
                        throw new RuntimeException("Exception while computing database live data.", e2);
                    }
                } finally {
                    roomTrackingLiveData.computing.set(false);
                }
            }
            if (z2) {
                roomTrackingLiveData.postValue(tCall);
            }
            if (!z2 || !roomTrackingLiveData.invalid.get()) {
                return;
            }
        }
    }

    public final Callable<T> getComputeFunction() {
        return this.computeFunction;
    }

    public final AtomicBoolean getComputing() {
        return this.computing;
    }

    public final RoomDatabase getDatabase() {
        return this.database;
    }

    public final boolean getInTransaction() {
        return this.inTransaction;
    }

    public final AtomicBoolean getInvalid() {
        return this.invalid;
    }

    public final Runnable getInvalidationRunnable() {
        return this.invalidationRunnable;
    }

    public final InvalidationTracker.Observer getObserver() {
        return this.observer;
    }

    public final Executor getQueryExecutor() {
        return this.inTransaction ? this.database.getTransactionExecutor() : this.database.getQueryExecutor();
    }

    public final Runnable getRefreshRunnable() {
        return this.refreshRunnable;
    }

    public final AtomicBoolean getRegisteredObserver() {
        return this.registeredObserver;
    }

    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        super.onActive();
        this.container.onActive(this);
        getQueryExecutor().execute(this.refreshRunnable);
    }

    @Override // androidx.lifecycle.LiveData
    public void onInactive() {
        super.onInactive();
        this.container.onInactive(this);
    }
}
