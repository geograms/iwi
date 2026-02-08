package s0;

import android.app.ProgressDialog;
import android.content.Context;
import androidx.fragment.app.c0;

/* loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f2537a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2538b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f2539c = true;

    public /* synthetic */ h(c0 c0Var, String str) {
        this.f2537a = c0Var;
        this.f2538b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f2537a;
        String str = this.f2538b;
        boolean z2 = this.f2539c;
        try {
            ProgressDialog progressDialog = new ProgressDialog(context);
            i.f2540a = progressDialog;
            progressDialog.setMessage(str);
            i.f2540a.setCancelable(z2);
            i.f2540a.setCanceledOnTouchOutside(false);
            if (i.f2540a.isShowing()) {
                return;
            }
            i.f2540a.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
