package j0;

import android.app.ProgressDialog;
import android.os.Handler;
import android.view.View;
import androidx.fragment.app.Fragment;

/* loaded from: classes.dex */
public abstract class b extends Fragment {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f1894f = 0;

    /* renamed from: a, reason: collision with root package name */
    public boolean f1895a;

    /* renamed from: b, reason: collision with root package name */
    public ProgressDialog f1896b;

    /* renamed from: c, reason: collision with root package name */
    public final androidx.activity.b f1897c = new androidx.activity.b(4, this);

    /* renamed from: d, reason: collision with root package name */
    public final Handler f1898d = new Handler();

    /* renamed from: e, reason: collision with root package name */
    public View f1899e;

    public void d() {
        if (this.f1896b == null || !isAdded()) {
            return;
        }
        this.f1896b.dismiss();
    }

    public abstract void e();

    @Override // androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
        if (!getUserVisibleHint()) {
            this.f1895a = false;
        } else {
            this.f1895a = true;
            e();
        }
    }
}
