package k0;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.room.RoomSQLiteQuery;
import com.chamsion.quickchat.db.channel.ChannelDatabase;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2011a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2012b;

    public s(Application application) {
        x xVarB = ChannelDatabase.c(application).b();
        this.f2011a = xVarB;
        xVarB.getClass();
        this.f2012b = xVarB.f2022a.getInvalidationTracker().createLiveData(new String[]{"countries"}, false, new e(xVarB, RoomSQLiteQuery.acquire("SELECT * FROM countries ORDER BY id ASC", 0), 2));
    }

    public final LiveData a(int i2) {
        f fVar = (f) this.f2012b;
        fVar.getClass();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM channels WHERE countryId = ? ORDER BY id ASC", 1);
        roomSQLiteQueryAcquire.bindLong(1, i2);
        return fVar.f1977a.getInvalidationTracker().createLiveData(new String[]{"channels"}, false, new e(fVar, roomSQLiteQueryAcquire, 0));
    }

    public s(Context context) {
        this.f2011a = s.class.getName();
        this.f2012b = ChannelDatabase.c(context).a();
    }
}
