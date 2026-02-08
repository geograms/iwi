package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class MultiInstanceInvalidationClient {
    private final Context appContext;
    private final IMultiInstanceInvalidationCallback callback;
    private int clientId;
    private final Executor executor;
    private final InvalidationTracker invalidationTracker;
    private final String name;
    public InvalidationTracker.Observer observer;
    private final Runnable removeObserverRunnable;
    private IMultiInstanceInvalidationService service;
    private final ServiceConnection serviceConnection;
    private final Runnable setUpRunnable;
    private final AtomicBoolean stopped;

    public MultiInstanceInvalidationClient(Context context, String str, Intent intent, InvalidationTracker invalidationTracker, Executor executor) {
        x0.g.u(context, "context");
        x0.g.u(str, "name");
        x0.g.u(intent, "serviceIntent");
        x0.g.u(invalidationTracker, "invalidationTracker");
        x0.g.u(executor, "executor");
        this.name = str;
        this.invalidationTracker = invalidationTracker;
        this.executor = executor;
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        this.callback = new MultiInstanceInvalidationClient$callback$1(this);
        final int i2 = 0;
        this.stopped = new AtomicBoolean(false);
        ServiceConnection serviceConnection = new ServiceConnection() { // from class: androidx.room.MultiInstanceInvalidationClient$serviceConnection$1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                x0.g.u(componentName, "name");
                x0.g.u(iBinder, "service");
                this.this$0.setService(IMultiInstanceInvalidationService.Stub.asInterface(iBinder));
                this.this$0.getExecutor().execute(this.this$0.getSetUpRunnable());
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                x0.g.u(componentName, "name");
                this.this$0.getExecutor().execute(this.this$0.getRemoveObserverRunnable());
                this.this$0.setService(null);
            }
        };
        this.serviceConnection = serviceConnection;
        this.setUpRunnable = new Runnable(this) { // from class: androidx.room.b

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MultiInstanceInvalidationClient f1030b;

            {
                this.f1030b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i3 = i2;
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.f1030b;
                switch (i3) {
                    case 0:
                        MultiInstanceInvalidationClient.setUpRunnable$lambda$1(multiInstanceInvalidationClient);
                        break;
                    default:
                        MultiInstanceInvalidationClient.removeObserverRunnable$lambda$2(multiInstanceInvalidationClient);
                        break;
                }
            }
        };
        final int i3 = 1;
        this.removeObserverRunnable = new Runnable(this) { // from class: androidx.room.b

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MultiInstanceInvalidationClient f1030b;

            {
                this.f1030b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i32 = i3;
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.f1030b;
                switch (i32) {
                    case 0:
                        MultiInstanceInvalidationClient.setUpRunnable$lambda$1(multiInstanceInvalidationClient);
                        break;
                    default:
                        MultiInstanceInvalidationClient.removeObserverRunnable$lambda$2(multiInstanceInvalidationClient);
                        break;
                }
            }
        };
        setObserver(new InvalidationTracker.Observer((String[]) invalidationTracker.getTableIdLookup$room_runtime_release().keySet().toArray(new String[0])) { // from class: androidx.room.MultiInstanceInvalidationClient.1
            @Override // androidx.room.InvalidationTracker.Observer
            public boolean isRemote$room_runtime_release() {
                return true;
            }

            @Override // androidx.room.InvalidationTracker.Observer
            public void onInvalidated(Set<String> set) {
                x0.g.u(set, "tables");
                if (MultiInstanceInvalidationClient.this.getStopped().get()) {
                    return;
                }
                try {
                    IMultiInstanceInvalidationService service = MultiInstanceInvalidationClient.this.getService();
                    if (service != null) {
                        service.broadcastInvalidation(MultiInstanceInvalidationClient.this.getClientId(), (String[]) set.toArray(new String[0]));
                    }
                } catch (RemoteException e2) {
                    Log.w(Room.LOG_TAG, "Cannot broadcast invalidation", e2);
                }
            }
        });
        applicationContext.bindService(intent, serviceConnection, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeObserverRunnable$lambda$2(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        x0.g.u(multiInstanceInvalidationClient, "this$0");
        multiInstanceInvalidationClient.invalidationTracker.removeObserver(multiInstanceInvalidationClient.getObserver());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUpRunnable$lambda$1(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        x0.g.u(multiInstanceInvalidationClient, "this$0");
        try {
            IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient.service;
            if (iMultiInstanceInvalidationService != null) {
                multiInstanceInvalidationClient.clientId = iMultiInstanceInvalidationService.registerCallback(multiInstanceInvalidationClient.callback, multiInstanceInvalidationClient.name);
                multiInstanceInvalidationClient.invalidationTracker.addObserver(multiInstanceInvalidationClient.getObserver());
            }
        } catch (RemoteException e2) {
            Log.w(Room.LOG_TAG, "Cannot register multi-instance invalidation callback", e2);
        }
    }

    public final IMultiInstanceInvalidationCallback getCallback() {
        return this.callback;
    }

    public final int getClientId() {
        return this.clientId;
    }

    public final Executor getExecutor() {
        return this.executor;
    }

    public final InvalidationTracker getInvalidationTracker() {
        return this.invalidationTracker;
    }

    public final String getName() {
        return this.name;
    }

    public final InvalidationTracker.Observer getObserver() {
        InvalidationTracker.Observer observer = this.observer;
        if (observer != null) {
            return observer;
        }
        x0.g.B0("observer");
        throw null;
    }

    public final Runnable getRemoveObserverRunnable() {
        return this.removeObserverRunnable;
    }

    public final IMultiInstanceInvalidationService getService() {
        return this.service;
    }

    public final ServiceConnection getServiceConnection() {
        return this.serviceConnection;
    }

    public final Runnable getSetUpRunnable() {
        return this.setUpRunnable;
    }

    public final AtomicBoolean getStopped() {
        return this.stopped;
    }

    public final void setClientId(int i2) {
        this.clientId = i2;
    }

    public final void setObserver(InvalidationTracker.Observer observer) {
        x0.g.u(observer, "<set-?>");
        this.observer = observer;
    }

    public final void setService(IMultiInstanceInvalidationService iMultiInstanceInvalidationService) {
        this.service = iMultiInstanceInvalidationService;
    }

    public final void stop() {
        if (this.stopped.compareAndSet(false, true)) {
            this.invalidationTracker.removeObserver(getObserver());
            try {
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this.service;
                if (iMultiInstanceInvalidationService != null) {
                    iMultiInstanceInvalidationService.unregisterCallback(this.callback, this.clientId);
                }
            } catch (RemoteException e2) {
                Log.w(Room.LOG_TAG, "Cannot unregister multi-instance invalidation callback", e2);
            }
            this.appContext.unbindService(this.serviceConnection);
        }
    }
}
