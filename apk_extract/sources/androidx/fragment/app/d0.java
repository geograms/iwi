package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class d0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f478a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f479b;

    public /* synthetic */ d0(int i2, Object obj) {
        this.f478a = i2;
        this.f479b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f478a;
        Object obj = this.f479b;
        switch (i2) {
            case 0:
                e eVar = (e) obj;
                if (((Fragment) eVar.f483c).getAnimatingAway() != null) {
                    Object obj2 = eVar.f483c;
                    ((Fragment) obj2).setAnimatingAway(null);
                    ((n0) eVar.f484d).c((Fragment) obj2, (n.d) eVar.f485e);
                    break;
                }
                break;
            case 1:
                e eVar2 = (e) obj;
                eVar2.f482b.endViewTransition((View) eVar2.f483c);
                ((i) eVar2.f484d).a();
                break;
            case 2:
                q qVar = (q) obj;
                qVar.mOnDismissListener.onDismiss(qVar.mDialog);
                break;
            case 3:
                ((w0) obj).s(true);
                break;
            default:
                j1.b((ArrayList) obj, 4);
                break;
        }
    }
}
