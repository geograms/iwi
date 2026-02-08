package androidx.lifecycle;

import android.content.Context;
import f0.b;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements b {
    @Override // f0.b
    public List<Class<? extends b>> dependencies() {
        return Collections.emptyList();
    }

    @Override // f0.b
    public LifecycleOwner create(Context context) {
        if (!f0.a.c(context).f1761b.contains(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily. \nPlease ensure that you have: \n<meta-data\n    android:name='androidx.lifecycle.ProcessLifecycleInitializer' \n    android:value='androidx.startup' /> \nunder InitializationProvider in your AndroidManifest.xml");
        }
        LifecycleDispatcher.init(context);
        ProcessLifecycleOwner.init(context);
        return ProcessLifecycleOwner.get();
    }
}
