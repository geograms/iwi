package k0;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.chamsion.quickchat.db.channel.ChannelDatabase;

/* loaded from: classes.dex */
public final class t extends AndroidViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final s f2013a;

    /* renamed from: b, reason: collision with root package name */
    public final LiveData f2014b;

    /* renamed from: c, reason: collision with root package name */
    public final MutableLiveData f2015c;

    public t(Application application) {
        super(application);
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.f2015c = mutableLiveData;
        this.f2013a = new s((Context) application);
        this.f2014b = Transformations.switchMap(mutableLiveData, new com.google.android.material.search.a(this));
    }

    public final void a(a aVar) {
        s sVar = this.f2013a;
        sVar.getClass();
        ChannelDatabase.f1237b.execute(new r(sVar, aVar, 0));
    }
}
