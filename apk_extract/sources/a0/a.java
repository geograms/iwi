package a0;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;

/* loaded from: classes.dex */
public abstract class a {
    public static d a(LifecycleOwner lifecycleOwner) {
        return new d(lifecycleOwner, ((ViewModelStoreOwner) lifecycleOwner).getViewModelStore());
    }
}
