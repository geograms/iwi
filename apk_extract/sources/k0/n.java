package k0;

import android.app.Dialog;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.chamsion.quickchat.ui.SettingsActivity;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class n implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1993a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1994b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1995c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f1996d;

    public /* synthetic */ n(Object obj, Object obj2, Object obj3, int i2) {
        this.f1993a = i2;
        this.f1996d = obj;
        this.f1994b = obj2;
        this.f1995c = obj3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i2;
        int i3 = this.f1993a;
        Object obj = this.f1995c;
        Object obj2 = this.f1996d;
        Object obj3 = this.f1994b;
        switch (i3) {
            case 0:
                o oVar = ((q) obj2).f2007d;
                if (oVar != null) {
                    oVar.a((a) obj3, ((p) obj).getAdapterPosition());
                    break;
                }
                break;
            default:
                String string = ((EditText) obj3).getText().toString();
                if (!x0.g.Y(string)) {
                    Toast.makeText(((SettingsActivity) obj2).f1469r, "号码必须为数字", 0).show();
                } else if (!string.isEmpty()) {
                    if (string.length() >= 9 || (i2 = Integer.parseInt(string)) < 1 || i2 > 16776415) {
                        s0.e.a(((SettingsActivity) obj2).f1469r, "超出范围！");
                    } else {
                        SettingsActivity settingsActivity = (SettingsActivity) obj2;
                        x0.g.m0(settingsActivity.f1469r, "local_id", Integer.valueOf(i2));
                        settingsActivity.f1472u = false;
                        ArrayList arrayList = new ArrayList();
                        arrayList.clear();
                        arrayList.addAll(settingsActivity.f1474w);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            a aVar = (a) it.next();
                            aVar.f1950n = i2;
                            settingsActivity.f1473v.a(aVar);
                            Log.d(settingsActivity.f1452a, "setLocalId .... ");
                        }
                        settingsActivity.f1472u = true;
                        settingsActivity.f1458g.setText("本机号码：" + i2);
                    }
                }
                ((Dialog) obj).dismiss();
                break;
        }
    }
}
