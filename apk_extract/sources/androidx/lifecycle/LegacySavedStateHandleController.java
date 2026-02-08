package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import b0.c;
import b0.e;
import b0.g;
import java.util.Iterator;

/* loaded from: classes.dex */
class LegacySavedStateHandleController {
    static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";

    public static final class OnRecreation implements c {
        @Override // b0.c
        public void onRecreated(g gVar) throws NoSuchMethodException, SecurityException {
            if (!(gVar instanceof ViewModelStoreOwner)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
            }
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) gVar).getViewModelStore();
            e savedStateRegistry = gVar.getSavedStateRegistry();
            Iterator<String> it = viewModelStore.keys().iterator();
            while (it.hasNext()) {
                LegacySavedStateHandleController.attachHandleIfNeeded(viewModelStore.get(it.next()), savedStateRegistry, gVar.getLifecycle());
            }
            if (viewModelStore.keys().isEmpty()) {
                return;
            }
            savedStateRegistry.d(OnRecreation.class);
        }
    }

    private LegacySavedStateHandleController() {
    }

    public static void attachHandleIfNeeded(ViewModel viewModel, e eVar, Lifecycle lifecycle) throws NoSuchMethodException, SecurityException {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) viewModel.getTag(TAG_SAVED_STATE_HANDLE_CONTROLLER);
        if (savedStateHandleController == null || savedStateHandleController.isAttached()) {
            return;
        }
        savedStateHandleController.attachToLifecycle(eVar, lifecycle);
        tryToAddRecreator(eVar, lifecycle);
    }

    public static SavedStateHandleController create(e eVar, Lifecycle lifecycle, String str, Bundle bundle) throws NoSuchMethodException, SecurityException {
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, SavedStateHandle.createHandle(eVar.a(str), bundle));
        savedStateHandleController.attachToLifecycle(eVar, lifecycle);
        tryToAddRecreator(eVar, lifecycle);
        return savedStateHandleController;
    }

    private static void tryToAddRecreator(final e eVar, final Lifecycle lifecycle) throws NoSuchMethodException, SecurityException {
        Lifecycle.State currentState = lifecycle.getCurrentState();
        if (currentState == Lifecycle.State.INITIALIZED || currentState.isAtLeast(Lifecycle.State.STARTED)) {
            eVar.d(OnRecreation.class);
        } else {
            lifecycle.addObserver(new LifecycleEventObserver() { // from class: androidx.lifecycle.LegacySavedStateHandleController.1
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) throws NoSuchMethodException, SecurityException {
                    if (event == Lifecycle.Event.ON_START) {
                        lifecycle.removeObserver(this);
                        eVar.d(OnRecreation.class);
                    }
                }
            });
        }
    }
}
