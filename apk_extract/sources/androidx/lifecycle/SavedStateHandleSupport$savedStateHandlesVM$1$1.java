package androidx.lifecycle;

import androidx.lifecycle.viewmodel.CreationExtras;
import c1.l;
import kotlin.jvm.internal.j;
import x0.g;

/* loaded from: classes.dex */
public final class SavedStateHandleSupport$savedStateHandlesVM$1$1 extends j implements l {
    public static final SavedStateHandleSupport$savedStateHandlesVM$1$1 INSTANCE = new SavedStateHandleSupport$savedStateHandlesVM$1$1();

    public SavedStateHandleSupport$savedStateHandlesVM$1$1() {
        super(1);
    }

    @Override // c1.l
    public final SavedStateHandlesVM invoke(CreationExtras creationExtras) {
        g.u(creationExtras, "$this$initializer");
        return new SavedStateHandlesVM();
    }
}
