package p0;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioRecord;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.chamsion.quickchat.App;
import com.chamsion.quickchat.R;
import com.chamsion.quickchat.service.DmrService;
import com.chamsion.quickchat.ui.MainActivity;
import com.wonder.dmr.DmrManager;
import com.wonder.dmr.OnEnhanceListener;
import com.wonder.dmr.utils.SPUtils;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class r0 implements OnEnhanceListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MainActivity f2446a;

    public /* synthetic */ r0(MainActivity mainActivity) {
        this.f2446a = mainActivity;
    }

    @Override // com.wonder.dmr.OnEnhanceListener
    public final void OnCallback_1(int i2, int i3, int i4) {
        if (i2 == 0) {
            MainActivity mainActivity = this.f2446a;
            if (i3 == 2) {
                Toast.makeText(mainActivity.f1410h, R.string.call_prompt, 0).show();
            } else if (i3 == 5) {
                s0.e.a(mainActivity.f1410h, mainActivity.getString(R.string.already_live));
            } else if (i3 == 4) {
                s0.e.a(mainActivity.f1410h, mainActivity.getString(R.string.already_killed));
            }
        }
    }

    @Override // com.wonder.dmr.OnEnhanceListener
    public final void OnCallback_2(int i2) {
        MainActivity mainActivity = this.f2446a;
        if (i2 == 4) {
            s0.e.a(mainActivity.f1410h, mainActivity.getString(R.string.already_killed));
        } else if (i2 == 5) {
            s0.e.a(mainActivity.f1410h, mainActivity.getString(R.string.already_live));
        }
    }

    public final void a(int i2) throws IllegalStateException {
        o0 o0Var = this.f2446a.f1413k;
        if (o0Var != null) {
            String strC = a.a.c(" handleReport...device_status : ", i2);
            String str = o0Var.f2378g;
            Log.i(str, strC);
            int i3 = 1;
            if (i2 == 1) {
                o0Var.f2382j.setImageResource(R.mipmap.icon_ptt_button_receive);
                o0Var.f2382j.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                o0Var.J = true;
                return;
            }
            int i4 = 0;
            if (i2 == 2) {
                o0Var.f2382j.setImageResource(R.mipmap.icon_ptt_button_normal);
                o0Var.J = false;
                Log.d("FragmentPtt", " 接收结束 : ");
                s0.f fVarA = s0.f.a();
                fVarA.f2527b = 0L;
                fVarA.f2528c = 0L;
                fVarA.f2529d = 0L;
                fVarA.f2530e = 0L;
                return;
            }
            if (i2 != 3) {
                if (i2 == 4) {
                    return;
                }
                if (i2 == 5) {
                    DmrManager.getInstance().getSms(new j0(o0Var, i4));
                    return;
                }
                if (i2 == 8) {
                    Toast.makeText(o0Var.f2380h, R.string.confirm_msg_send_success, 0).show();
                    return;
                }
                if (i2 == 9) {
                    Toast.makeText(o0Var.f2380h, R.string.confirm_msg_send_success, 0).show();
                    return;
                }
                if (i2 == 6) {
                    Toast.makeText(o0Var.f2380h, R.string.make_live_timeout, 0).show();
                    return;
                } else {
                    if (i2 == 7) {
                        o0Var.n();
                        o0Var.m();
                        return;
                    }
                    return;
                }
            }
            if (App.f1233b.getSharedPreferences(SPUtils.FILE_NAME, 0).getBoolean("pref_person_ptt_start_tone", true)) {
                o0Var.o();
            }
            o0Var.J = false;
            Log.d(str, "openMic: ");
            o0Var.f2382j.setImageResource(R.mipmap.icon_ptt_button_pressed);
            o0Var.f2398z = true;
            if (i.e.a(o0Var.f2380h, "android.permission.RECORD_AUDIO") == 0) {
                o0Var.A = 160;
                o0Var.B = new AudioRecord(1, 8000, 16, 2, o0Var.A);
            }
            o0Var.B.startRecording();
            Executors.newSingleThreadExecutor().execute(new h0(o0Var, i3));
            o0Var.f2396x.setVisibility(0);
            int iN = x0.g.N(App.f1233b, 30, "pref_person_limit_send_time");
            if (iN > 0) {
                int i5 = iN * 1000;
                m0 m0Var = new m0(o0Var, i5, i5);
                o0Var.f2397y = m0Var;
                m0Var.start();
            }
        }
    }

    public final void b() {
        int i2 = MainActivity.I;
        int i3 = R.id.nav_group;
        MainActivity mainActivity = this.f2446a;
        mainActivity.f1409g = (RadioGroup) mainActivity.findViewById(i3);
        mainActivity.f1404b = (RadioButton) mainActivity.findViewById(R.id.rb_ptt);
        mainActivity.f1405c = (RadioButton) mainActivity.findViewById(R.id.rb_channel);
        mainActivity.f1406d = (RadioButton) mainActivity.findViewById(R.id.rb_contacts);
        mainActivity.f1407e = (RadioButton) mainActivity.findViewById(R.id.rb_message);
        mainActivity.f1408f = (RadioButton) mainActivity.findViewById(R.id.rb_mine);
        mainActivity.f1409g.setOnCheckedChangeListener(mainActivity.G);
        if (mainActivity.f1425w) {
            mainActivity.f1425w = false;
        } else {
            mainActivity.e(R.id.rb_ptt);
        }
        Log.d(mainActivity.f1403a, a.a.c("smallestScreenWidth- dp - ", mainActivity.getResources().getConfiguration().smallestScreenWidthDp));
        int i4 = 2;
        if (!((Boolean) x0.g.J(mainActivity.f1410h, "has_init_sp", j0.c.f1901b)).booleanValue()) {
            x0.g.m0(mainActivity.f1410h, "local_id", 1);
            x0.g.m0(mainActivity.f1410h, "local_name", "User");
            x0.g.m0(mainActivity.f1410h, "power", 1);
            x0.g.m0(mainActivity.f1410h, "save_power", 2);
            x0.g.m0(mainActivity.f1410h, "mic", 0);
            x0.g.m0(mainActivity.f1410h, "relay", 2);
            x0.g.m0(mainActivity.f1410h, "voice", j0.c.f1902c);
            x0.g.m0(mainActivity.f1410h, "has_init_sp", Boolean.TRUE);
            x0.g.m0(mainActivity.f1410h, "index", 0);
            x0.g.m0(mainActivity.f1410h, "polite", 1);
            x0.g.m0(mainActivity.f1410h, "trans_interr", 2);
            x0.g.m0(mainActivity.f1410h, "msg_encode", 0);
            MainActivity mainActivity2 = mainActivity.f1410h;
            Boolean bool = Boolean.FALSE;
            x0.g.m0(mainActivity2, "upgrade_flag", bool);
            x0.g.m0(mainActivity.f1410h, "launch_interr_enable", bool);
            x0.g.m0(mainActivity.f1410h, "tts_support", bool);
        }
        int iIntValue = ((Integer) x0.g.J(mainActivity.f1410h, "msg_encode", 0)).intValue();
        DmrManager.getInstance().setMessageEncode(mainActivity.getResources().getStringArray(R.array.msg_encode)[iIntValue]);
        mainActivity.f1419q = ((Boolean) x0.g.J(mainActivity.f1410h, "upgrade_flag", Boolean.FALSE)).booleanValue();
        mainActivity.f1424v = new Handler(new a.c(i4, mainActivity));
        androidx.fragment.app.w0 supportFragmentManager = mainActivity.getSupportFragmentManager();
        supportFragmentManager.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(supportFragmentManager);
        if (mainActivity.f1413k == null) {
            String string = mainActivity.getString(R.string.rb_ptt);
            o0 o0Var = new o0();
            Bundle bundle = new Bundle();
            bundle.putString("quickchat", string);
            o0Var.setArguments(bundle);
            mainActivity.f1413k = o0Var;
        }
        int i5 = R.id.layFrame;
        o0 o0Var2 = mainActivity.f1413k;
        if (i5 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        aVar.c(i5, o0Var2, null, 2);
        aVar.e(false);
        if (!App.f1234c) {
            ProgressDialog progressDialog = s0.i.f2540a;
            String string2 = mainActivity.getString(R.string.init_string);
            s0.i.a();
            s0.i.f2541b.post(new s0.h(mainActivity, string2));
        }
        Intent intent = new Intent(mainActivity.f1410h, (Class<?>) DmrService.class);
        mainActivity.startForegroundService(intent);
        mainActivity.bindService(intent, mainActivity.H, 1);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PTT.up");
        intentFilter.addAction("android.intent.action.PTT.down");
        q0 q0Var = new q0(mainActivity, i4);
        mainActivity.C = q0Var;
        mainActivity.registerReceiver(q0Var, intentFilter, 4);
        IntentFilter intentFilter2 = new IntentFilter("android.intent.action.SCREEN_ON");
        intentFilter2.addAction("android.intent.action.SCREEN_OFF");
        mainActivity.registerReceiver(mainActivity.A, intentFilter2);
        mainActivity.f1428z = new q0(mainActivity);
        IntentFilter intentFilter3 = new IntentFilter();
        intentFilter3.addAction("android.intent.action.PHONE_STATE");
        mainActivity.registerReceiver(mainActivity.f1428z, intentFilter3);
    }
}
