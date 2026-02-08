package androidx.fragment.app;

import android.content.DialogInterface;

/* loaded from: classes.dex */
public final class n implements DialogInterface.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f573a;

    public n(q qVar) {
        this.f573a = qVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        q qVar = this.f573a;
        if (qVar.mDialog != null) {
            qVar.onDismiss(qVar.mDialog);
        }
    }
}
