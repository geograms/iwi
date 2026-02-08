package androidx.lifecycle;

import d.b;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class ComputableLiveData<T> {
    final AtomicBoolean mComputing;
    final Executor mExecutor;
    final AtomicBoolean mInvalid;
    final Runnable mInvalidationRunnable;
    final LiveData<T> mLiveData;
    final Runnable mRefreshRunnable;

    public ComputableLiveData() {
        this(b.f1700e);
    }

    public abstract T compute();

    public LiveData<T> getLiveData() {
        return this.mLiveData;
    }

    public void invalidate() {
        b bVarE0 = b.E0();
        Runnable runnable = this.mInvalidationRunnable;
        if (bVarE0.F0()) {
            runnable.run();
        } else {
            bVarE0.G0(runnable);
        }
    }

    public ComputableLiveData(Executor executor) {
        this.mInvalid = new AtomicBoolean(true);
        this.mComputing = new AtomicBoolean(false);
        this.mRefreshRunnable = new Runnable() { // from class: androidx.lifecycle.ComputableLiveData.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                while (ComputableLiveData.this.mComputing.compareAndSet(false, true)) {
                    Object objCompute = null;
                    boolean z2 = false;
                    while (ComputableLiveData.this.mInvalid.compareAndSet(true, false)) {
                        try {
                            objCompute = ComputableLiveData.this.compute();
                            z2 = true;
                        } catch (Throwable th) {
                            ComputableLiveData.this.mComputing.set(false);
                            throw th;
                        }
                    }
                    if (z2) {
                        ComputableLiveData.this.mLiveData.postValue(objCompute);
                    }
                    ComputableLiveData.this.mComputing.set(false);
                    if (!z2 || !ComputableLiveData.this.mInvalid.get()) {
                        return;
                    }
                }
            }
        };
        this.mInvalidationRunnable = new Runnable() { // from class: androidx.lifecycle.ComputableLiveData.3
            @Override // java.lang.Runnable
            public void run() {
                boolean zHasActiveObservers = ComputableLiveData.this.mLiveData.hasActiveObservers();
                if (ComputableLiveData.this.mInvalid.compareAndSet(false, true) && zHasActiveObservers) {
                    ComputableLiveData computableLiveData = ComputableLiveData.this;
                    computableLiveData.mExecutor.execute(computableLiveData.mRefreshRunnable);
                }
            }
        };
        this.mExecutor = executor;
        this.mLiveData = new LiveData<T>() { // from class: androidx.lifecycle.ComputableLiveData.1
            @Override // androidx.lifecycle.LiveData
            public void onActive() {
                ComputableLiveData computableLiveData = ComputableLiveData.this;
                computableLiveData.mExecutor.execute(computableLiveData.mRefreshRunnable);
            }
        };
    }
}
