package p0;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Handler;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;
import com.chamsion.quickchat.App;
import com.chamsion.quickchat.R;
import com.chamsion.quickchat.ui.MainActivity;

/* loaded from: classes.dex */
public final class q0 extends BroadcastReceiver {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f2423c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2424a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ContextWrapper f2425b;

    public /* synthetic */ q0(ContextWrapper contextWrapper, int i2) {
        this.f2424a = i2;
        this.f2425b = contextWrapper;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        o0 o0Var;
        o0 o0Var2;
        int i2 = this.f2424a;
        ContextWrapper contextWrapper = this.f2425b;
        switch (i2) {
            case 0:
                String action = intent.getAction();
                boolean zBooleanValue = ((Boolean) x0.g.J(context, "key_screen_off_support", Boolean.FALSE)).booleanValue();
                if (!"android.intent.action.SCREEN_OFF".equals(action)) {
                    if ("android.intent.action.SCREEN_ON".equals(action) && !zBooleanValue && (o0Var = ((MainActivity) contextWrapper).f1413k) != null) {
                        androidx.fragment.app.c0 c0Var = o0Var.f2380h;
                        ProgressDialog progressDialog = s0.i.f2540a;
                        String string = c0Var.getString(R.string.init_string);
                        s0.i.a();
                        s0.i.f2541b.post(new s0.h(c0Var, string));
                        break;
                    }
                } else if (!zBooleanValue && (o0Var2 = ((MainActivity) contextWrapper).f1413k) != null) {
                    o0Var2.t();
                    o0Var2.f2373b0 = false;
                    o0Var2.p();
                    o0Var2.f2382j.setImageResource(R.mipmap.icon_ptt_button_normal);
                    x0.g.o0(App.f1233b, 0, "pref_person_send_status");
                    o0Var2.J = false;
                    break;
                }
                break;
            case 1:
                if ("android.intent.action.PHONE_STATE".equals(intent.getAction())) {
                    String stringExtra = intent.getStringExtra("state");
                    MainActivity mainActivity = (MainActivity) contextWrapper;
                    boolean z2 = mainActivity.f1426x;
                    if (TelephonyManager.EXTRA_STATE_RINGING.equals(stringExtra) || TelephonyManager.EXTRA_STATE_OFFHOOK.equals(stringExtra)) {
                        mainActivity.f1426x = true;
                    } else if (TelephonyManager.EXTRA_STATE_IDLE.equals(stringExtra)) {
                        mainActivity.f1426x = false;
                    }
                    boolean z3 = mainActivity.f1426x;
                    if (z2 != z3 && z3) {
                        Toast.makeText(mainActivity, R.string.incall_prompt, 0).show();
                        Log.d(mainActivity.f1403a, "broadcast,handlePttKeyUp. ");
                        mainActivity.f1413k.n();
                        break;
                    }
                }
                break;
            case 2:
                if (App.f1234c) {
                    MainActivity mainActivity2 = (MainActivity) contextWrapper;
                    if (!mainActivity2.f1426x) {
                        if (!((Boolean) x0.g.J(context, "key_screen_off_support", Boolean.FALSE)).booleanValue() && !((PowerManager) mainActivity2.f1410h.getSystemService("power")).isInteractive()) {
                            Log.d("MainActivity", "灭屏对讲关闭 且 灭屏 return ");
                            break;
                        } else {
                            String action2 = intent.getAction();
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            if (action2 != null && mainActivity2.f1413k != null) {
                                boolean zEquals = action2.equals("android.intent.action.PTT.down");
                                String str = mainActivity2.f1403a;
                                if (!zEquals) {
                                    if (action2.equals("android.intent.action.PTT.up") && mainActivity2.F && jCurrentTimeMillis - mainActivity2.E >= 1500) {
                                        mainActivity2.E = jCurrentTimeMillis;
                                        mainActivity2.F = false;
                                        Log.d(str, "PttKeyReceiver , BROADCAST_PTT_KEY_UP");
                                        Log.d(str, "broadcast,handlePttKeyUp. ");
                                        mainActivity2.f1413k.n();
                                        break;
                                    }
                                } else if (!mainActivity2.F && jCurrentTimeMillis - mainActivity2.D >= 1500) {
                                    mainActivity2.D = jCurrentTimeMillis;
                                    mainActivity2.F = true;
                                    Log.d(str, "PttKeyReceiver , BROADCAST_PTT_KEY_DOWN");
                                    Log.d(str, "broadcast,handlePttKeyDown. ");
                                    o0 o0Var3 = mainActivity2.f1413k;
                                    if (o0Var3 != null) {
                                        o0Var3.m();
                                        break;
                                    }
                                }
                            }
                        }
                    } else {
                        Log.d("MainActivity", "来电状态 不支持对讲 return");
                        break;
                    }
                }
                break;
            default:
                String action3 = intent.getAction();
                boolean zBooleanValue2 = ((Boolean) x0.g.J(context, "key_screen_off_support", Boolean.FALSE)).booleanValue();
                if (!"android.intent.action.SCREEN_OFF".equals(action3)) {
                    if ("android.intent.action.SCREEN_ON".equals(action3) && !zBooleanValue2) {
                        new Handler().post(new j0.a(1));
                        break;
                    }
                } else if (!zBooleanValue2) {
                    new Handler().post(new j0.a(0));
                    break;
                }
                break;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q0(MainActivity mainActivity) {
        this(mainActivity, 1);
        this.f2424a = 1;
    }
}
