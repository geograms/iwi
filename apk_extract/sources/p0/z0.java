package p0;

import android.content.res.Resources;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import com.chamsion.quickchat.R;
import com.chamsion.quickchat.ui.SettingsActivity;
import com.wonder.dmr.DmrManager;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class z0 implements AdapterView.OnItemSelectedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2474a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SettingsActivity f2475b;

    public /* synthetic */ z0(SettingsActivity settingsActivity, int i2) {
        this.f2474a = i2;
        this.f2475b = settingsActivity;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i2, long j2) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        int i3 = this.f2474a;
        SettingsActivity settingsActivity = this.f2475b;
        switch (i3) {
            case 0:
                int i4 = i2 + 1;
                Log.e(settingsActivity.f1452a, "TRANS_INTERR. onItemSelected, mode = " + i4);
                if (!settingsActivity.f1471t && settingsActivity.f1468q != null) {
                    x0.g.m0(settingsActivity.f1469r, "trans_interr", Integer.valueOf(i4));
                    r0.d dVar = settingsActivity.f1468q;
                    a.b bVar = dVar.f2522c;
                    if (bVar != null) {
                        Message messageObtainMessage = bVar.obtainMessage();
                        messageObtainMessage.arg1 = 7;
                        messageObtainMessage.arg2 = i4;
                        messageObtainMessage.what = 256;
                        dVar.f2522c.sendMessageDelayed(messageObtainMessage, 100L);
                    }
                }
                if (settingsActivity.f1471t) {
                    settingsActivity.f1471t = false;
                    break;
                }
                break;
            default:
                Charset charsetDefaultCharset = Charset.defaultCharset();
                Log.e(settingsActivity.f1452a, "mOnMsgEncodeItemSelectedListener. , defCharset = " + charsetDefaultCharset);
                x0.g.m0(settingsActivity.f1469r, "msg_encode", Integer.valueOf(i2));
                DmrManager.getInstance().setMessageEncode(settingsActivity.getResources().getStringArray(R.array.msg_encode)[i2]);
                break;
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
    }
}
