package n;

import android.os.Bundle;
import android.os.IBinder;
import x0.g;

/* loaded from: classes.dex */
public abstract class a {
    public static final void a(Bundle bundle, String str, IBinder iBinder) {
        g.u(bundle, "bundle");
        g.u(str, "key");
        bundle.putBinder(str, iBinder);
    }
}
