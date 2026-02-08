package m0;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.RoomSQLiteQuery;
import com.chamsion.quickchat.db.contacts.ContactDatabase;

/* loaded from: classes.dex */
public final class n extends AndroidViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final m f2132a;

    /* renamed from: b, reason: collision with root package name */
    public final LiveData f2133b;

    public n(Application application) {
        super(application);
        m mVar = new m();
        d dVarA = ContactDatabase.b(application).a();
        mVar.f2131a = dVarA;
        dVarA.getClass();
        LiveData liveDataCreateLiveData = dVarA.f2101a.getInvalidationTracker().createLiveData(new String[]{"contacts_table"}, false, new c(dVarA, RoomSQLiteQuery.acquire("SELECT * FROM contacts_table ORDER BY ID ASC", 0)));
        this.f2132a = mVar;
        this.f2133b = liveDataCreateLiveData;
    }
}
