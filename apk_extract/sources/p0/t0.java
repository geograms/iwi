package p0;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import com.chamsion.quickchat.service.DmrService;
import com.chamsion.quickchat.ui.MainActivity;
import com.chamsion.quickchat.ui.UpdateDmrAcitivity;
import com.wonder.dmr.DmrManager;

/* loaded from: classes.dex */
public final class t0 implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MainActivity f2452a;

    public t0(MainActivity mainActivity) {
        this.f2452a = mainActivity;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        MainActivity mainActivity = this.f2452a;
        Log.d(mainActivity.f1403a, "onServiceConnected...mIsUpgrade= " + mainActivity.f1419q);
        o0.a aVar = (o0.a) iBinder;
        mainActivity.f1423u = aVar;
        aVar.getClass();
        int i2 = DmrService.f1256d;
        aVar.f2244a.getClass();
        mainActivity.f1418p = true;
        o0.c cVar = new o0.c(mainActivity.f1410h, mainActivity.f1424v, mainActivity.f1423u);
        mainActivity.f1422t = cVar;
        if (mainActivity.f1419q) {
            mainActivity.startActivity(new Intent(mainActivity, (Class<?>) UpdateDmrAcitivity.class));
            return;
        }
        a.b bVar = cVar.f2250d;
        if (bVar != null) {
            Message messageObtainMessage = bVar.obtainMessage();
            messageObtainMessage.arg1 = 0;
            messageObtainMessage.what = 256;
            cVar.f2250d.sendMessageDelayed(messageObtainMessage, 50L);
        }
        o0.c cVar2 = mainActivity.f1422t;
        r0 r0Var = new r0(mainActivity);
        if (cVar2.f2249c != null) {
            DmrManager.getInstance().setReportStatus(new androidx.fragment.app.d(cVar2, r0Var));
        }
        o0.c cVar3 = mainActivity.f1422t;
        r0 r0Var2 = new r0(mainActivity);
        if (cVar3.f2249c != null) {
            DmrManager.getInstance().setEnhanceListener(new androidx.fragment.app.d(cVar3, r0Var2));
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f2452a.f1418p = false;
    }
}
