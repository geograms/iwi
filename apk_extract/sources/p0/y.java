package p0;

import android.app.Dialog;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import com.chamsion.quickchat.App;
import com.chamsion.quickchat.R;
import com.chamsion.quickchat.ui.FragmentLocalSettingsActivity;
import com.wonder.dmr.DmrManager;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class y implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2466a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FragmentLocalSettingsActivity f2467b;

    public /* synthetic */ y(FragmentLocalSettingsActivity fragmentLocalSettingsActivity, int i2) {
        this.f2466a = i2;
        this.f2467b = fragmentLocalSettingsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        a.b bVar;
        int i3 = this.f2466a;
        FragmentLocalSettingsActivity fragmentLocalSettingsActivity = this.f2467b;
        switch (i3) {
            case 0:
                int i4 = FragmentLocalSettingsActivity.M;
                if (fragmentLocalSettingsActivity.d()) {
                    fragmentLocalSettingsActivity.h(R.string.interphone_talk_send_status_toast);
                } else {
                    String str = (String) fragmentLocalSettingsActivity.f1395t.get(i2);
                    a0 a0Var = fragmentLocalSettingsActivity.B;
                    if (a0Var != null) {
                        a0Var.notifyDataSetChanged();
                    }
                    fragmentLocalSettingsActivity.f1377b.setText(str);
                    int i5 = fragmentLocalSettingsActivity.f1393r[i2];
                    x0.g.o0(App.f1233b, i5, "pref_person_limit_send_time");
                    DmrManager.getInstance().setTot(i5, null);
                    fragmentLocalSettingsActivity.f1391p = i2;
                }
                Dialog dialog = fragmentLocalSettingsActivity.f1398w;
                if (dialog != null) {
                    dialog.dismiss();
                    break;
                }
                break;
            default:
                int i6 = FragmentLocalSettingsActivity.M;
                if (fragmentLocalSettingsActivity.d()) {
                    fragmentLocalSettingsActivity.h(R.string.interphone_talk_send_status_toast);
                } else {
                    String str2 = (String) fragmentLocalSettingsActivity.f1396u.get(i2);
                    a0 a0Var2 = fragmentLocalSettingsActivity.C;
                    if (a0Var2 != null) {
                        a0Var2.notifyDataSetChanged();
                    }
                    fragmentLocalSettingsActivity.f1382g.setText(str2);
                    int i7 = fragmentLocalSettingsActivity.f1394s[i2];
                    x0.g.o0(App.f1233b, i7, "pref_person_mic_gan_value");
                    fragmentLocalSettingsActivity.f1392q = i2;
                    x0.g.m0(App.f1233b, "mic", Integer.valueOf(i7));
                    Iterator it = fragmentLocalSettingsActivity.I.iterator();
                    while (it.hasNext()) {
                        k0.a aVar = (k0.a) it.next();
                        aVar.f1960x = (byte) i7;
                        fragmentLocalSettingsActivity.H.a(aVar);
                    }
                    r0.d dVar = fragmentLocalSettingsActivity.F;
                    if (dVar != null && (bVar = dVar.f2522c) != null) {
                        Message messageObtainMessage = bVar.obtainMessage();
                        messageObtainMessage.arg1 = 4;
                        messageObtainMessage.arg2 = i7;
                        messageObtainMessage.what = 256;
                        dVar.f2522c.sendMessageDelayed(messageObtainMessage, 100L);
                    }
                }
                Dialog dialog2 = fragmentLocalSettingsActivity.f1399x;
                if (dialog2 != null) {
                    dialog2.dismiss();
                    break;
                }
                break;
        }
    }
}
