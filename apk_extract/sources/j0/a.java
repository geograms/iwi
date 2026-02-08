package j0;

import android.app.ProgressDialog;
import com.chamsion.quickchat.App;
import com.chamsion.quickchat.service.DmrService;
import com.wonder.dmr.DmrManager;
import p0.q0;
import s0.i;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1893a;

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1893a) {
            case 0:
                int i2 = q0.f2423c;
                DmrManager.getInstance().powerCtrl("/sys/devices/platform/intercom/intercom_power_control", 0);
                DmrManager.getInstance().pwdCtrl("/sys/devices/platform/intercom/intercom_pwd_control", 0);
                DmrManager.getInstance().pttCtrl("/sys/devices/platform/intercom/intercom_ptt_control", 0);
                App.f1234c = false;
                break;
            case 1:
                int i3 = q0.f2423c;
                App.f1234c = false;
                DmrManager.getInstance().powerCtrl("/sys/devices/platform/intercom/intercom_power_control", 1);
                DmrManager.getInstance().pwdCtrl("/sys/devices/platform/intercom/intercom_pwd_control", 1);
                DmrManager.getInstance().pttCtrl("/sys/devices/platform/intercom/intercom_ptt_control", 1);
                DmrManager.getInstance().openSerial("/dev/ttyS0", 57600);
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                break;
            case 6:
                int i4 = DmrService.f1256d;
                DmrManager.getInstance().powerCtrl("/sys/devices/platform/intercom/intercom_power_control", 1);
                DmrManager.getInstance().pwdCtrl("/sys/devices/platform/intercom/intercom_pwd_control", 1);
                DmrManager.getInstance().pttCtrl("/sys/devices/platform/intercom/intercom_ptt_control", 1);
                break;
            default:
                try {
                    ProgressDialog progressDialog = i.f2540a;
                    if (progressDialog != null && progressDialog.isShowing()) {
                        i.f2540a.dismiss();
                    }
                    i.f2540a = null;
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
        }
    }
}
