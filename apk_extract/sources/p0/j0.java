package p0;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;
import com.chamsion.quickchat.R;
import com.chamsion.quickchat.ui.MessageChatActivity;
import com.wonder.dmr.DmrManager;
import com.wonder.dmr.OnPolicyListener;
import com.wonder.dmr.OnSmsListener;
import com.wonder.dmr.OnTransferInterruptListener;

/* loaded from: classes.dex */
public final /* synthetic */ class j0 implements OnSmsListener, OnTransferInterruptListener, OnPolicyListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2352a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o0 f2353b;

    public /* synthetic */ j0(o0 o0Var, int i2) {
        this.f2352a = i2;
        this.f2353b = o0Var;
    }

    @Override // com.wonder.dmr.OnSmsListener
    public final void OnCallback(int i2, int i3, int i4, String str) {
        int[] iArr = o0.f2371h0;
        o0 o0Var = this.f2353b;
        o0Var.getClass();
        String str2 = "getDmrMessage , state = [" + i2 + "] type = [" + i3 + "] number = [" + i4 + "] sms = [" + str + "] getMesssageIndex = [" + o0Var.i();
        String str3 = o0Var.f2378g;
        Log.d(str3, str2);
        String str4 = new String(str.getBytes());
        if (i2 == 0) {
            int i5 = o0Var.f2391s.f1937a;
            Log.e(str3, "getDmrMessage, MESSAGE_index ->>" + i5);
            n0.e eVar = new n0.e();
            eVar.f2158b = i5;
            eVar.f2166j = i3;
            eVar.f2164h = str4;
            eVar.f2167k = 0;
            eVar.f2161e = o0Var.G;
            eVar.f2165i = System.currentTimeMillis();
            if (i3 == 0) {
                eVar.f2159c = i4;
            } else if (i3 == 1) {
                eVar.f2162f = o0Var.f2391s.f1952p;
            }
            o0Var.K.a(eVar);
            if (o0Var.isAdded() && !o0Var.isDetached() && o0Var.getContext() != null) {
                NotificationManager notificationManager = (NotificationManager) o0Var.f2380h.getSystemService("notification");
                Notification.Builder builder = new Notification.Builder(o0Var.f2380h, "my_package_channel_1");
                NotificationChannel notificationChannel = new NotificationChannel("my_package_channel_1", "my_package_channel", 2);
                notificationChannel.setDescription("my_package_first_channel");
                notificationChannel.enableLights(true);
                notificationManager.createNotificationChannel(notificationChannel);
                Log.e(str3, "sendMsgNotice, mCurrentChannel = " + o0Var.f2391s);
                Intent intent = new Intent(o0Var.f2380h, (Class<?>) MessageChatActivity.class);
                intent.setFlags(603979776);
                intent.putExtra("channel", o0Var.f2391s);
                intent.putExtra("index", o0Var.i());
                builder.setSmallIcon(R.mipmap.icon_message_pressed).setContentTitle(o0Var.getString(R.string.msg_number) + i4 + o0Var.getString(R.string.msg_msg)).setContentText(str4).setContentIntent(PendingIntent.getActivity(o0Var.f2380h, 1, intent, 67108864)).setChannelId("my_package_channel_1").setAutoCancel(true);
                notificationManager.notify(0, builder.build());
            }
            o0Var.f2375d0.sendEmptyMessage(258);
        }
    }

    @Override // com.wonder.dmr.OnTransferInterruptListener
    public final void OnCallback(int i2) {
        int i3 = this.f2352a;
        o0 o0Var = this.f2353b;
        switch (i3) {
            case 1:
                int[] iArr = o0.f2371h0;
                o0Var.getClass();
                if (i2 == 0) {
                    Log.d("MainActivity", "初始化 设置中断回调成功 开始设置礼貌模式: ");
                    int iIntValue = ((Integer) x0.g.J(o0Var.f2380h, "polite", 1)).intValue();
                    Log.d("MainActivity", "初始化 开始设置礼貌模式 ");
                    DmrManager.getInstance().setPolite(iIntValue, new j0(o0Var, 2));
                    break;
                } else {
                    s0.i.a();
                    o0Var.h(o0Var.f2380h);
                    break;
                }
            default:
                int[] iArr2 = o0.f2371h0;
                o0Var.getClass();
                if (i2 == 0) {
                    Log.d("MainActivity", "初始化 礼貌模式设置收到回调成功 ");
                }
                s0.i.a();
                o0Var.h(o0Var.f2380h);
                break;
        }
    }
}
