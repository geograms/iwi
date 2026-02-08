package r0;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.wonder.dmr.DmrManager;
import com.wonder.dmr.OnInitializationFinishlistener;
import com.wonder.dmr.OnMicGainListener;
import com.wonder.dmr.OnPolicyListener;
import com.wonder.dmr.OnPowerOnListener;
import com.wonder.dmr.OnPowerSavingModeListener;
import com.wonder.dmr.OnTransferInterruptListener;
import com.wonder.dmr.OnVersionListener;
import com.wonder.dmr.OnVolumeListener;
import k.j;

/* loaded from: classes.dex */
public final class c implements OnPolicyListener, OnInitializationFinishlistener, OnPowerOnListener, OnVersionListener, OnVolumeListener, OnMicGainListener, OnPowerSavingModeListener, OnTransferInterruptListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2518a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f2519b;

    public /* synthetic */ c(d dVar, int i2) {
        this.f2518a = i2;
        this.f2519b = dVar;
    }

    @Override // com.wonder.dmr.OnPowerOnListener
    public final void OnCallback() {
        d dVar = this.f2519b;
        Handler handler = dVar.f2520a;
        if (handler != null) {
            Message messageObtainMessage = handler.obtainMessage();
            messageObtainMessage.what = 0;
            dVar.f2520a.sendMessage(messageObtainMessage);
        }
    }

    @Override // com.wonder.dmr.OnPolicyListener, com.wonder.dmr.OnTransferInterruptListener
    public final void OnCallback(int i2) {
        int i3 = this.f2518a;
        d dVar = this.f2519b;
        switch (i3) {
            case 0:
                if (i2 == 0) {
                    DmrManager.getInstance().setTransferInterrupt(1, new j(22, this));
                    break;
                }
                break;
            case 1:
                if (i2 == 0) {
                    DmrManager.getInstance().setTransferInterrupt(1, new j(23, this));
                    break;
                }
                break;
            case 2:
                Log.d("wonder", " 查询结果  " + i2);
                Handler handler = dVar.f2520a;
                if (handler != null) {
                    Message messageObtainMessage = handler.obtainMessage();
                    messageObtainMessage.what = 1;
                    messageObtainMessage.arg1 = i2;
                    dVar.f2520a.sendMessage(messageObtainMessage);
                    break;
                }
                break;
            case 3:
            case 4:
            default:
                Handler handler2 = dVar.f2520a;
                if (handler2 != null) {
                    Message messageObtainMessage2 = handler2.obtainMessage();
                    messageObtainMessage2.what = 8;
                    messageObtainMessage2.arg1 = i2;
                    dVar.f2520a.sendMessage(messageObtainMessage2);
                    break;
                }
                break;
            case 5:
                Handler handler3 = dVar.f2520a;
                if (handler3 != null) {
                    Message messageObtainMessage3 = handler3.obtainMessage();
                    messageObtainMessage3.what = 3;
                    messageObtainMessage3.arg1 = i2;
                    dVar.f2520a.sendMessage(messageObtainMessage3);
                    break;
                }
                break;
            case 6:
                Handler handler4 = dVar.f2520a;
                if (handler4 != null) {
                    Message messageObtainMessage4 = handler4.obtainMessage();
                    messageObtainMessage4.what = 4;
                    messageObtainMessage4.arg1 = i2;
                    dVar.f2520a.sendMessage(messageObtainMessage4);
                    break;
                }
                break;
            case 7:
                Handler handler5 = dVar.f2520a;
                if (handler5 != null) {
                    Message messageObtainMessage5 = handler5.obtainMessage();
                    messageObtainMessage5.what = 5;
                    messageObtainMessage5.arg1 = i2;
                    dVar.f2520a.sendMessage(messageObtainMessage5);
                    break;
                }
                break;
            case 8:
                Handler handler6 = dVar.f2520a;
                if (handler6 != null) {
                    Message messageObtainMessage6 = handler6.obtainMessage();
                    messageObtainMessage6.what = 7;
                    messageObtainMessage6.arg1 = i2;
                    dVar.f2520a.sendMessage(messageObtainMessage6);
                    break;
                }
                break;
        }
    }

    @Override // com.wonder.dmr.OnVersionListener
    public final void OnCallback(int i2, String str) {
        d dVar = this.f2519b;
        Handler handler = dVar.f2520a;
        if (handler != null) {
            Message messageObtainMessage = handler.obtainMessage();
            messageObtainMessage.what = 2;
            messageObtainMessage.arg1 = i2;
            messageObtainMessage.obj = str;
            dVar.f2520a.sendMessage(messageObtainMessage);
        }
    }
}
