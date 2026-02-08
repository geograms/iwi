package androidx.lifecycle;

import android.view.View;
import x0.g;

/* loaded from: classes.dex */
public final class ViewTreeViewModelKt {
    public static final ViewModelStoreOwner findViewTreeViewModelStoreOwner(View view) {
        g.u(view, "<this>");
        return ViewTreeViewModelStoreOwner.get(view);
    }
}
