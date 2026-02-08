package kotlinx.coroutines.android;

import android.os.Looper;
import j1.p;
import java.util.List;
import k1.a;
import k1.b;
import n1.e;

/* loaded from: classes.dex */
public final class AndroidDispatcherFactory implements e {
    @Override // n1.e
    public p createDispatcher(List<? extends e> list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new a(b.a(mainLooper));
        }
        throw new IllegalStateException("The main looper is not available");
    }

    @Override // n1.e
    public int getLoadPriority() {
        return 1073741823;
    }

    @Override // n1.e
    public String hintOnError() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }
}
