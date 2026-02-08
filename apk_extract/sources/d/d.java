package d;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import x0.g;

/* loaded from: classes.dex */
public final class d extends g {

    /* renamed from: c, reason: collision with root package name */
    public final Object f1703c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public final ExecutorService f1704d = Executors.newFixedThreadPool(4, new c());

    /* renamed from: e, reason: collision with root package name */
    public volatile Handler f1705e;

    public final boolean E0() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public final void F0(Runnable runnable) {
        if (this.f1705e == null) {
            synchronized (this.f1703c) {
                try {
                    if (this.f1705e == null) {
                        this.f1705e = Handler.createAsync(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        this.f1705e.post(runnable);
    }
}
