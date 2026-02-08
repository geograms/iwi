package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

/* loaded from: classes.dex */
public final class o implements Observer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f577a;

    public o(q qVar) {
        this.f577a = qVar;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        if (((LifecycleOwner) obj) != null) {
            q qVar = this.f577a;
            if (qVar.mShowsDialog) {
                View viewRequireView = qVar.requireView();
                if (viewRequireView.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                if (qVar.mDialog != null) {
                    if (Log.isLoggable("FragmentManager", 3)) {
                        Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + qVar.mDialog);
                    }
                    qVar.mDialog.setContentView(viewRequireView);
                }
            }
        }
    }
}
