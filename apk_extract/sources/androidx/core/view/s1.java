package androidx.core.view;

import android.view.WindowInsets;
import java.util.List;

/* loaded from: classes.dex */
public abstract class s1 {
    public static final int DISPATCH_MODE_CONTINUE_ON_SUBTREE = 1;
    public static final int DISPATCH_MODE_STOP = 0;
    WindowInsets mDispachedInsets;
    private final int mDispatchMode = 0;

    public final int getDispatchMode() {
        return this.mDispatchMode;
    }

    public abstract void onEnd(b2 b2Var);

    public abstract void onPrepare(b2 b2Var);

    public abstract n2 onProgress(n2 n2Var, List list);

    public abstract r1 onStart(b2 b2Var, r1 r1Var);
}
