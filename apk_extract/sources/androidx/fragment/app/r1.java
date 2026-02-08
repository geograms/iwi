package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

/* loaded from: classes.dex */
public final class r1 implements HasDefaultViewModelProviderFactory, b0.g, ViewModelStoreOwner {

    /* renamed from: a, reason: collision with root package name */
    public final Fragment f593a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewModelStore f594b;

    /* renamed from: c, reason: collision with root package name */
    public ViewModelProvider.Factory f595c;

    /* renamed from: d, reason: collision with root package name */
    public LifecycleRegistry f596d = null;

    /* renamed from: e, reason: collision with root package name */
    public b0.f f597e = null;

    public r1(Fragment fragment, ViewModelStore viewModelStore) {
        this.f593a = fragment;
        this.f594b = viewModelStore;
    }

    public final void a(Lifecycle.Event event) {
        this.f596d.handleLifecycleEvent(event);
    }

    public final void b() {
        if (this.f596d == null) {
            this.f596d = new LifecycleRegistry(this);
            this.f597e = new b0.f(this);
        }
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public final ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        Application application;
        Fragment fragment = this.f593a;
        ViewModelProvider.Factory defaultViewModelProviderFactory = fragment.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(fragment.mDefaultFactory)) {
            this.f595c = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.f595c == null) {
            Context applicationContext = fragment.requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            this.f595c = new SavedStateViewModelFactory(application, this, fragment.getArguments());
        }
        return this.f595c;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        b();
        return this.f596d;
    }

    @Override // b0.g
    public final b0.e getSavedStateRegistry() {
        b();
        return this.f597e.f1219b;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public final ViewModelStore getViewModelStore() {
        b();
        return this.f594b;
    }
}
