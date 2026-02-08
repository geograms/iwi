package p0;

import android.app.Dialog;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.chamsion.quickchat.ui.ManagerActivity;
import com.chamsion.quickchat.ui.SettingsActivity;

/* loaded from: classes.dex */
public final class y0 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2468a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ KeyEvent.Callback f2469b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2470c;

    public /* synthetic */ y0(Object obj, KeyEvent.Callback callback, int i2) {
        this.f2468a = i2;
        this.f2470c = obj;
        this.f2469b = callback;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i2 = this.f2468a;
        KeyEvent.Callback callback = this.f2469b;
        switch (i2) {
            case 0:
                ((Dialog) callback).dismiss();
                break;
            default:
                String strTrim = ((EditText) callback).getText().toString().trim();
                boolean zIsEmpty = strTrim.isEmpty();
                Object obj = this.f2470c;
                if (!zIsEmpty) {
                    t0.a aVar = (t0.a) obj;
                    k.j jVar = aVar.f2552b;
                    if (jVar != null) {
                        if ("123654".equals(strTrim)) {
                            ((SettingsActivity) jVar.f1934b).startActivity(new Intent(((SettingsActivity) jVar.f1934b).f1469r, (Class<?>) ManagerActivity.class));
                        } else {
                            Toast.makeText(((SettingsActivity) jVar.f1934b).f1469r, "密码错误", 0).show();
                        }
                    }
                    aVar.dismiss();
                    break;
                } else {
                    Toast.makeText(((t0.a) obj).f2551a, "密码不能为空", 0).show();
                    break;
                }
        }
    }
}
