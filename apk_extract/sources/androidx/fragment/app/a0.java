package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.ViewModelStoreOwner;

/* loaded from: classes.dex */
public final class a0 implements b.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0 f435a;

    public a0(c0 c0Var) {
        this.f435a = c0Var;
    }

    @Override // b.b
    public final void onContextAvailable(Context context) {
        c0 c0Var = this.f435a;
        k0 k0Var = c0Var.mFragments.f547a;
        k0Var.f556d.b(k0Var, k0Var, null);
        Bundle bundleA = c0Var.getSavedStateRegistry().a("android:support:fragments");
        if (bundleA != null) {
            Parcelable parcelable = bundleA.getParcelable("android:support:fragments");
            k0 k0Var2 = c0Var.mFragments.f547a;
            if (!(k0Var2 instanceof ViewModelStoreOwner)) {
                throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
            }
            k0Var2.f556d.K(parcelable);
        }
    }
}
