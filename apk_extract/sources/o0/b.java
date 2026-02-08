package o0;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.wonder.dmr.OnInitializationFinishlistener;
import com.wonder.dmr.OnMicGainListener;
import com.wonder.dmr.OnPolicyListener;
import com.wonder.dmr.OnPowerOnListener;
import com.wonder.dmr.OnPowerSavingModeListener;
import com.wonder.dmr.OnTransferInterruptListener;
import com.wonder.dmr.OnVersionListener;

/* loaded from: classes.dex */
public final class b implements OnPowerOnListener, OnInitializationFinishlistener, OnVersionListener, OnMicGainListener, OnPowerSavingModeListener, OnPolicyListener, OnTransferInterruptListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2245a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f2246b;

    public /* synthetic */ b(c cVar, int i2) {
        this.f2245a = i2;
        this.f2246b = cVar;
    }

    @Override // com.wonder.dmr.OnPowerOnListener
    public final void OnCallback() {
        c cVar = this.f2246b;
        Handler handler = cVar.f2247a;
        if (handler != null) {
            Message messageObtainMessage = handler.obtainMessage();
            messageObtainMessage.what = 0;
            cVar.f2247a.sendMessage(messageObtainMessage);
        }
    }

    @Override // com.wonder.dmr.OnInitializationFinishlistener, com.wonder.dmr.OnMicGainListener, com.wonder.dmr.OnPowerSavingModeListener, com.wonder.dmr.OnPolicyListener, com.wonder.dmr.OnTransferInterruptListener
    public final void OnCallback(int i2) {
        int i3 = this.f2245a;
        c cVar = this.f2246b;
        switch (i3) {
            case 1:
                Log.d("wonder", " 查询结果  " + i2);
                Handler handler = cVar.f2247a;
                if (handler != null) {
                    Message messageObtainMessage = handler.obtainMessage();
                    messageObtainMessage.what = 1;
                    messageObtainMessage.arg1 = i2;
                    cVar.f2247a.sendMessage(messageObtainMessage);
                    break;
                }
                break;
            case 2:
            default:
                Handler handler2 = cVar.f2247a;
                if (handler2 != null) {
                    Message messageObtainMessage2 = handler2.obtainMessage();
                    messageObtainMessage2.what = 8;
                    messageObtainMessage2.arg1 = i2;
                    cVar.f2247a.sendMessage(messageObtainMessage2);
                    break;
                }
                break;
            case 3:
                Handler handler3 = cVar.f2247a;
                if (handler3 != null) {
                    Message messageObtainMessage3 = handler3.obtainMessage();
                    messageObtainMessage3.what = 4;
                    messageObtainMessage3.arg1 = i2;
                    cVar.f2247a.sendMessage(messageObtainMessage3);
                    break;
                }
                break;
            case 4:
                Handler handler4 = cVar.f2247a;
                if (handler4 != null) {
                    Message messageObtainMessage4 = handler4.obtainMessage();
                    messageObtainMessage4.what = 5;
                    messageObtainMessage4.arg1 = i2;
                    cVar.f2247a.sendMessage(messageObtainMessage4);
                    break;
                }
                break;
            case 5:
                Handler handler5 = cVar.f2247a;
                if (handler5 != null) {
                    Message messageObtainMessage5 = handler5.obtainMessage();
                    messageObtainMessage5.what = 7;
                    messageObtainMessage5.arg1 = i2;
                    cVar.f2247a.sendMessage(messageObtainMessage5);
                    break;
                }
                break;
        }
    }

    @Override // com.wonder.dmr.OnVersionListener
    public final void OnCallback(int i2, String str) {
        c cVar = this.f2246b;
        Handler handler = cVar.f2247a;
        if (handler != null) {
            Message messageObtainMessage = handler.obtainMessage();
            messageObtainMessage.what = 2;
            messageObtainMessage.arg1 = i2;
            messageObtainMessage.obj = str;
            cVar.f2247a.sendMessage(messageObtainMessage);
        }
    }
}
