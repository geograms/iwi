package p0;

import android.content.res.Resources;
import android.util.Log;
import com.chamsion.quickchat.ui.MessageChatActivity;
import com.wonder.dmr.OnAnalogCmdListener;
import com.wonder.dmr.OnDigitalCmdListener;
import com.wonder.dmr.OnTextMessageListener;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final /* synthetic */ class g0 implements OnAnalogCmdListener, OnDigitalCmdListener, OnTextMessageListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2339a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2340b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2341c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Serializable f2342d;

    public /* synthetic */ g0(MessageChatActivity messageChatActivity, String str, int i2) {
        this.f2339a = 2;
        this.f2340b = messageChatActivity;
        this.f2342d = str;
        this.f2341c = i2;
    }

    @Override // com.wonder.dmr.OnAnalogCmdListener, com.wonder.dmr.OnEnhancementsListener, com.wonder.dmr.OnUpgradeModeListener, com.wonder.dmr.OnTransferInterruptListener
    public final void OnCallback(int i2) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        Object obj = this.f2340b;
        int i3 = this.f2339a;
        int i4 = this.f2341c;
        Serializable serializable = this.f2342d;
        switch (i3) {
            case 0:
                o0 o0Var = (o0) obj;
                k0.a aVar = (k0.a) serializable;
                int[] iArr = o0.f2371h0;
                o0Var.getClass();
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            s0.i.a();
                            Log.d("FragmentPtt", "初始化 信道设置失败 937: ");
                            break;
                        }
                    } else {
                        s0.i.a();
                        Log.d("FragmentPtt", "初始化 信道设置失败 934: ");
                        break;
                    }
                } else {
                    Log.d("FragmentPtt", "初始化 模拟信道设置成功 ");
                    o0Var.q();
                    if (i4 != -1) {
                        o0Var.w(i4);
                        o0Var.u(aVar);
                        o0Var.v(aVar);
                        break;
                    }
                }
                break;
            case 1:
                o0 o0Var2 = (o0) obj;
                k0.a aVar2 = (k0.a) serializable;
                int[] iArr2 = o0.f2371h0;
                o0Var2.getClass();
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            s0.i.a();
                            Log.d("FragmentPtt", "初始化 信道设置失败 980: ");
                            break;
                        }
                    } else {
                        s0.i.a();
                        Log.d("FragmentPtt", "初始化 信道设置失败 978: ");
                        break;
                    }
                } else {
                    Log.d("FragmentPtt", "初始化 数字信道设置成功 ");
                    o0Var2.q();
                    if (i4 != -1) {
                        o0Var2.w(i4);
                        o0Var2.u(aVar2);
                        o0Var2.v(aVar2);
                        break;
                    }
                }
                break;
            default:
                MessageChatActivity messageChatActivity = (MessageChatActivity) obj;
                String str = (String) serializable;
                if (i2 != 0) {
                    int i5 = MessageChatActivity.f1437o;
                    messageChatActivity.getClass();
                    break;
                } else {
                    messageChatActivity.f1440c.setText("");
                    n0.e eVar = new n0.e();
                    eVar.f2158b = messageChatActivity.f1447j;
                    eVar.f2166j = messageChatActivity.f1446i;
                    eVar.f2164h = str;
                    eVar.f2167k = 1;
                    eVar.f2161e = messageChatActivity.f1443f;
                    eVar.f2165i = System.currentTimeMillis();
                    byte b2 = (byte) messageChatActivity.f1444g.f1953q;
                    if (b2 == 0) {
                        eVar.f2160d = "";
                        eVar.f2159c = i4;
                    } else if (b2 == 1) {
                        eVar.f2163g = "";
                        eVar.f2162f = i4;
                    }
                    messageChatActivity.f1448k.a(eVar);
                    break;
                }
        }
    }

    public /* synthetic */ g0(o0 o0Var, int i2, k0.a aVar, int i3) {
        this.f2339a = i3;
        this.f2340b = o0Var;
        this.f2341c = i2;
        this.f2342d = aVar;
    }
}
