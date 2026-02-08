package androidx.activity;

import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* loaded from: classes.dex */
final class ImmLeaksCleaner implements LifecycleEventObserver {

    /* renamed from: a, reason: collision with root package name */
    public static int f12a;

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) throws SecurityException {
        if (event != Lifecycle.Event.ON_DESTROY) {
            return;
        }
        if (f12a == 0) {
            try {
                f12a = 2;
                InputMethodManager.class.getDeclaredField("mServedView").setAccessible(true);
                InputMethodManager.class.getDeclaredField("mNextServedView").setAccessible(true);
                InputMethodManager.class.getDeclaredField("mH").setAccessible(true);
                f12a = 1;
            } catch (NoSuchFieldException unused) {
            }
        }
        if (f12a == 1) {
            throw null;
        }
    }
}
