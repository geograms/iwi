package androidx.room;

import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class InvalidationLiveDataContainer {
    private final RoomDatabase database;
    private final Set<LiveData<?>> liveDataSet;

    public InvalidationLiveDataContainer(RoomDatabase roomDatabase) {
        x0.g.u(roomDatabase, "database");
        this.database = roomDatabase;
        Set<LiveData<?>> setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        x0.g.t(setNewSetFromMap, "newSetFromMap(IdentityHashMap())");
        this.liveDataSet = setNewSetFromMap;
    }

    public final <T> LiveData<T> create(String[] strArr, boolean z2, Callable<T> callable) {
        x0.g.u(strArr, "tableNames");
        x0.g.u(callable, "computeFunction");
        return new RoomTrackingLiveData(this.database, this, z2, callable, strArr);
    }

    public final Set<LiveData<?>> getLiveDataSet$room_runtime_release() {
        return this.liveDataSet;
    }

    public final void onActive(LiveData<?> liveData) {
        x0.g.u(liveData, "liveData");
        this.liveDataSet.add(liveData);
    }

    public final void onInactive(LiveData<?> liveData) {
        x0.g.u(liveData, "liveData");
        this.liveDataSet.remove(liveData);
    }
}
