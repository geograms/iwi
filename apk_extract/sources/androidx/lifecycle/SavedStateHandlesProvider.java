package androidx.lifecycle;

import android.os.Bundle;
import b0.d;
import b0.e;
import java.util.Map;
import x0.g;

/* loaded from: classes.dex */
public final class SavedStateHandlesProvider implements d {
    private boolean restored;
    private Bundle restoredState;
    private final e savedStateRegistry;
    private final u0.a viewModel$delegate;

    public SavedStateHandlesProvider(e eVar, ViewModelStoreOwner viewModelStoreOwner) {
        g.u(eVar, "savedStateRegistry");
        g.u(viewModelStoreOwner, "viewModelStoreOwner");
        this.savedStateRegistry = eVar;
        this.viewModel$delegate = new u0.d(new SavedStateHandlesProvider$viewModel$2(viewModelStoreOwner));
    }

    private final SavedStateHandlesVM getViewModel() {
        return (SavedStateHandlesVM) this.viewModel$delegate.getValue();
    }

    public final Bundle consumeRestoredStateForKey(String str) {
        g.u(str, "key");
        performRestore();
        Bundle bundle = this.restoredState;
        Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
        Bundle bundle3 = this.restoredState;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.restoredState;
        if (bundle4 != null && bundle4.isEmpty()) {
            this.restoredState = null;
        }
        return bundle2;
    }

    public final void performRestore() {
        if (this.restored) {
            return;
        }
        this.restoredState = this.savedStateRegistry.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
        this.restored = true;
        getViewModel();
    }

    @Override // b0.d
    public Bundle saveState() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.restoredState;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry<String, SavedStateHandle> entry : getViewModel().getHandles().entrySet()) {
            String key = entry.getKey();
            Bundle bundleSaveState = entry.getValue().savedStateProvider().saveState();
            if (!g.g(bundleSaveState, Bundle.EMPTY)) {
                bundle.putBundle(key, bundleSaveState);
            }
        }
        this.restored = false;
        return bundle;
    }
}
