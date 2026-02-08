package androidx.activity;

import android.app.Dialog;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import androidx.room.InvalidationTracker;
import com.chamsion.quickchat.service.DmrService;
import com.chamsion.quickchat.ui.AddNewContactsActivity;
import com.chamsion.quickchat.ui.FragmentLocalDeviceAreaActivity;
import com.wonder.dmr.DmrManager;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f18b;

    public /* synthetic */ b(int i2, Object obj) {
        this.f17a = i2;
        this.f18b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f17a;
        Object obj = this.f18b;
        switch (i2) {
            case 0:
                ((h) obj).invalidateMenu();
                break;
            case 1:
                i.a((i) obj);
                break;
            case 2:
            default:
                ((Dialog) obj).dismiss();
                break;
            case 3:
                ((InvalidationTracker) obj).onAutoCloseCallback();
                break;
            case 4:
                int i3 = j0.b.f1894f;
                ((j0.b) obj).d();
                break;
            case 5:
                DmrService dmrService = (DmrService) obj;
                int i4 = DmrService.f1256d;
                dmrService.getClass();
                Log.d(dmrService.f1257a, "setDmrPowerOn, " + Build.MODEL);
                new Handler().postDelayed(new j0.a(6), 100L);
                DmrManager.getInstance().openSerial("/dev/ttyS0", 57600);
                break;
            case 6:
                int i5 = AddNewContactsActivity.f1312w;
                ((AddNewContactsActivity) obj).finish();
                break;
            case 7:
                FragmentLocalDeviceAreaActivity fragmentLocalDeviceAreaActivity = (FragmentLocalDeviceAreaActivity) obj;
                fragmentLocalDeviceAreaActivity.f1359j.b(fragmentLocalDeviceAreaActivity.f1357h);
                break;
        }
    }
}
