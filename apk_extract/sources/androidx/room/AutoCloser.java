package androidx.room;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import c0.h;
import c1.l;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class AutoCloser {
    public static final Companion Companion = new Companion(null);
    public static final String autoCloseBug = "https://issuetracker.google.com/issues/new?component=413107&template=1096568";
    private long autoCloseTimeoutInMs;
    private final Runnable autoCloser;
    private c0.b delegateDatabase;
    public h delegateOpenHelper;
    private final Runnable executeAutoCloser;
    private final Executor executor;
    private final Handler handler;
    private long lastDecrementRefCountTimeStamp;
    private final Object lock;
    private boolean manuallyClosed;
    private Runnable onAutoCloseCallback;
    private int refCount;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public AutoCloser(long j2, TimeUnit timeUnit, Executor executor) {
        x0.g.u(timeUnit, "autoCloseTimeUnit");
        x0.g.u(executor, "autoCloseExecutor");
        this.handler = new Handler(Looper.getMainLooper());
        this.lock = new Object();
        this.autoCloseTimeoutInMs = timeUnit.toMillis(j2);
        this.executor = executor;
        this.lastDecrementRefCountTimeStamp = SystemClock.uptimeMillis();
        final int i2 = 0;
        this.executeAutoCloser = new Runnable(this) { // from class: androidx.room.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AutoCloser f1028b;

            {
                this.f1028b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i3 = i2;
                AutoCloser autoCloser = this.f1028b;
                switch (i3) {
                    case 0:
                        AutoCloser.executeAutoCloser$lambda$0(autoCloser);
                        break;
                    default:
                        AutoCloser.autoCloser$lambda$3(autoCloser);
                        break;
                }
            }
        };
        final int i3 = 1;
        this.autoCloser = new Runnable(this) { // from class: androidx.room.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AutoCloser f1028b;

            {
                this.f1028b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i32 = i3;
                AutoCloser autoCloser = this.f1028b;
                switch (i32) {
                    case 0:
                        AutoCloser.executeAutoCloser$lambda$0(autoCloser);
                        break;
                    default:
                        AutoCloser.autoCloser$lambda$3(autoCloser);
                        break;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void autoCloser$lambda$3(AutoCloser autoCloser) {
        u0.f fVar;
        x0.g.u(autoCloser, "this$0");
        synchronized (autoCloser.lock) {
            try {
                if (SystemClock.uptimeMillis() - autoCloser.lastDecrementRefCountTimeStamp < autoCloser.autoCloseTimeoutInMs) {
                    return;
                }
                if (autoCloser.refCount != 0) {
                    return;
                }
                Runnable runnable = autoCloser.onAutoCloseCallback;
                if (runnable != null) {
                    runnable.run();
                    fVar = u0.f.f2595a;
                } else {
                    fVar = null;
                }
                if (fVar == null) {
                    throw new IllegalStateException("onAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568".toString());
                }
                c0.b bVar = autoCloser.delegateDatabase;
                if (bVar != null && bVar.isOpen()) {
                    bVar.close();
                }
                autoCloser.delegateDatabase = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executeAutoCloser$lambda$0(AutoCloser autoCloser) {
        x0.g.u(autoCloser, "this$0");
        autoCloser.executor.execute(autoCloser.autoCloser);
    }

    public final void closeDatabaseIfOpen() {
        synchronized (this.lock) {
            try {
                this.manuallyClosed = true;
                c0.b bVar = this.delegateDatabase;
                if (bVar != null) {
                    bVar.close();
                }
                this.delegateDatabase = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void decrementCountAndScheduleClose() {
        synchronized (this.lock) {
            int i2 = this.refCount;
            if (i2 <= 0) {
                throw new IllegalStateException("ref count is 0 or lower but we're supposed to decrement".toString());
            }
            int i3 = i2 - 1;
            this.refCount = i3;
            if (i3 == 0) {
                if (this.delegateDatabase == null) {
                } else {
                    this.handler.postDelayed(this.executeAutoCloser, this.autoCloseTimeoutInMs);
                }
            }
        }
    }

    public final <V> V executeRefCountingFunction(l lVar) {
        x0.g.u(lVar, "block");
        try {
            return (V) lVar.invoke(incrementCountAndEnsureDbIsOpen());
        } finally {
            decrementCountAndScheduleClose();
        }
    }

    public final c0.b getDelegateDatabase$room_runtime_release() {
        return this.delegateDatabase;
    }

    public final h getDelegateOpenHelper() {
        h hVar = this.delegateOpenHelper;
        if (hVar != null) {
            return hVar;
        }
        x0.g.B0("delegateOpenHelper");
        throw null;
    }

    public final long getLastDecrementRefCountTimeStamp$room_runtime_release() {
        return this.lastDecrementRefCountTimeStamp;
    }

    public final Runnable getOnAutoCloseCallback$room_runtime_release() {
        return this.onAutoCloseCallback;
    }

    public final int getRefCount$room_runtime_release() {
        return this.refCount;
    }

    public final int getRefCountForTest$room_runtime_release() {
        int i2;
        synchronized (this.lock) {
            i2 = this.refCount;
        }
        return i2;
    }

    public final c0.b incrementCountAndEnsureDbIsOpen() {
        synchronized (this.lock) {
            this.handler.removeCallbacks(this.executeAutoCloser);
            this.refCount++;
            if (!(!this.manuallyClosed)) {
                throw new IllegalStateException("Attempting to open already closed database.".toString());
            }
            c0.b bVar = this.delegateDatabase;
            if (bVar != null && bVar.isOpen()) {
                return bVar;
            }
            c0.b writableDatabase = getDelegateOpenHelper().getWritableDatabase();
            this.delegateDatabase = writableDatabase;
            return writableDatabase;
        }
    }

    public final void init(h hVar) {
        x0.g.u(hVar, "delegateOpenHelper");
        setDelegateOpenHelper(hVar);
    }

    public final boolean isActive() {
        return !this.manuallyClosed;
    }

    public final void setAutoCloseCallback(Runnable runnable) {
        x0.g.u(runnable, "onAutoClose");
        this.onAutoCloseCallback = runnable;
    }

    public final void setDelegateDatabase$room_runtime_release(c0.b bVar) {
        this.delegateDatabase = bVar;
    }

    public final void setDelegateOpenHelper(h hVar) {
        x0.g.u(hVar, "<set-?>");
        this.delegateOpenHelper = hVar;
    }

    public final void setLastDecrementRefCountTimeStamp$room_runtime_release(long j2) {
        this.lastDecrementRefCountTimeStamp = j2;
    }

    public final void setOnAutoCloseCallback$room_runtime_release(Runnable runnable) {
        this.onAutoCloseCallback = runnable;
    }

    public final void setRefCount$room_runtime_release(int i2) {
        this.refCount = i2;
    }
}
