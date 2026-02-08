package o;

import android.os.Process;

/* loaded from: classes.dex */
public final class l extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final int f2241a;

    public l(Runnable runnable, String str, int i2) {
        super(runnable, str);
        this.f2241a = i2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(this.f2241a);
        super.run();
    }
}
