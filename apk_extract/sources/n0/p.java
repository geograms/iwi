package n0;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.chamsion.quickchat.db.message.MessageDatabase;

/* loaded from: classes.dex */
public final class p extends AndroidViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final o f2192a;

    /* renamed from: b, reason: collision with root package name */
    public LiveData f2193b;

    /* renamed from: c, reason: collision with root package name */
    public final Application f2194c;

    public p(Application application) {
        super(application);
        o oVar = new o();
        oVar.f2191a = MessageDatabase.a(application).b();
        this.f2192a = oVar;
        this.f2194c = application;
    }

    public final void a(e eVar) {
        o oVar = this.f2192a;
        oVar.getClass();
        MessageDatabase.f1252b.execute(new j.n(3, oVar, eVar));
    }
}
