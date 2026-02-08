package s0;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static ProgressDialog f2540a;

    /* renamed from: b, reason: collision with root package name */
    public static final Handler f2541b = new Handler(Looper.getMainLooper());

    public static void a() {
        f2541b.post(new j0.a(7));
    }
}
