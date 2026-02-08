package androidx.core.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final Lifecycle f202a;

    /* renamed from: b, reason: collision with root package name */
    public LifecycleEventObserver f203b;

    public t(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
        this.f202a = lifecycle;
        this.f203b = lifecycleEventObserver;
        lifecycle.addObserver(lifecycleEventObserver);
    }
}
