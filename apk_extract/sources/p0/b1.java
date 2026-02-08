package p0;

import android.os.Message;
import android.util.Log;
import android.widget.CompoundButton;
import com.chamsion.quickchat.ui.SettingsActivity;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class b1 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SettingsActivity f2291a;

    public b1(SettingsActivity settingsActivity) {
        this.f2291a = settingsActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        a.b bVar;
        SettingsActivity settingsActivity = this.f2291a;
        Log.d(settingsActivity.f1452a, "onCheckedChanged, boolean = " + z2);
        settingsActivity.f1472u = false;
        if (compoundButton.equals(settingsActivity.f1454c)) {
            x0.g.m0(settingsActivity.f1469r, "save_power", Integer.valueOf(z2 ? 1 : 2));
            Iterator it = settingsActivity.f1474w.iterator();
            while (it.hasNext()) {
                k0.a aVar = (k0.a) it.next();
                aVar.f1947k = (byte) (z2 ? 1 : 2);
                settingsActivity.f1473v.a(aVar);
            }
            r0.d dVar = settingsActivity.f1468q;
            if (dVar != null && (bVar = dVar.f2522c) != null) {
                Message messageObtainMessage = bVar.obtainMessage();
                messageObtainMessage.arg1 = 5;
                messageObtainMessage.arg2 = z2 ? 1 : 2;
                messageObtainMessage.what = 256;
                dVar.f2522c.sendMessageDelayed(messageObtainMessage, 100L);
            }
        } else if (compoundButton.equals(settingsActivity.f1455d)) {
            boolean zBooleanValue = ((Boolean) x0.g.J(settingsActivity.f1469r, "tts_support", Boolean.FALSE)).booleanValue();
            if (z2 && !zBooleanValue) {
                s0.e.a(settingsActivity.f1469r, "设备系统不支持TTS语音引擎");
                settingsActivity.f1455d.setChecked(false);
                return;
            }
            x0.g.m0(settingsActivity.f1469r, "voice", Boolean.valueOf(z2));
        } else {
            boolean zEquals = compoundButton.equals(settingsActivity.f1456e);
            String str = settingsActivity.f1452a;
            if (zEquals) {
                Log.e(str, "mSwPolite.  = " + z2);
                x0.g.m0(settingsActivity.f1469r, "polite", Integer.valueOf(z2 ? 1 : 0));
                if (z2) {
                    s0.e.a(settingsActivity.f1469r, "礼貌策略打开，需关闭发射中断功能");
                    if (settingsActivity.f1457f.isChecked()) {
                        settingsActivity.f1457f.setChecked(false);
                    }
                }
                r0.d dVar2 = settingsActivity.f1468q;
                a.b bVar2 = dVar2.f2522c;
                if (bVar2 != null) {
                    Message messageObtainMessage2 = bVar2.obtainMessage();
                    messageObtainMessage2.arg1 = 6;
                    messageObtainMessage2.arg2 = z2 ? 1 : 0;
                    messageObtainMessage2.what = 256;
                    dVar2.f2522c.sendMessageDelayed(messageObtainMessage2, 100L);
                }
            } else if (compoundButton.equals(settingsActivity.f1457f)) {
                Log.e(str, "mSwInterruptEnable.  = " + z2);
                x0.g.m0(settingsActivity.f1469r, "launch_interr_enable", Boolean.valueOf(z2));
                if (z2) {
                    s0.e.a(settingsActivity.f1469r, "发射中断功能打开,关闭礼貌策略");
                    if (settingsActivity.f1456e.isChecked()) {
                        settingsActivity.f1456e.setChecked(false);
                    }
                }
            }
        }
        settingsActivity.f1472u = true;
    }
}
