package androidx.fragment.app;

import android.content.DialogInterface;

/* loaded from: classes.dex */
public final class m implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f564a;

    public m(q qVar) {
        this.f564a = qVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        q qVar = this.f564a;
        if (qVar.mDialog != null) {
            qVar.onCancel(qVar.mDialog);
        }
    }
}
