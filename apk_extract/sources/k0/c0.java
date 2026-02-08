package k0;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

/* loaded from: classes.dex */
public final class c0 extends AndroidViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final s f1971a;

    /* renamed from: b, reason: collision with root package name */
    public final LiveData f1972b;

    public c0(Application application) {
        super(application);
        s sVar = new s(application);
        this.f1971a = sVar;
        this.f1972b = (LiveData) sVar.f2012b;
    }
}
