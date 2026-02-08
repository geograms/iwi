package p0;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.appcompat.app.AppCompatActivity;
import com.chamsion.quickchat.ui.FragmentLocalDeviceAreaActivity;
import com.chamsion.quickchat.ui.ManagerActivity;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class v implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2455a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppCompatActivity f2456b;

    public /* synthetic */ v(AppCompatActivity appCompatActivity, int i2) {
        this.f2455a = i2;
        this.f2456b = appCompatActivity;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        switch (this.f2455a) {
            case 0:
                String string = editable.toString();
                String strTrim = Pattern.compile("[^a-zA-Z0-9\\u4e00-\\u9fa5]").matcher(string).replaceAll("").trim();
                if (!string.equals(strTrim)) {
                    FragmentLocalDeviceAreaActivity fragmentLocalDeviceAreaActivity = (FragmentLocalDeviceAreaActivity) this.f2456b;
                    fragmentLocalDeviceAreaActivity.f1353d.setText(strTrim);
                    fragmentLocalDeviceAreaActivity.f1353d.setSelection(strTrim.length() <= 13 ? strTrim.length() : 13);
                    break;
                }
                break;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        switch (this.f2455a) {
            case 0:
                break;
            default:
                boolean zY = x0.g.Y(charSequence.toString());
                AppCompatActivity appCompatActivity = this.f2456b;
                if (!zY) {
                    s0.e.a(((ManagerActivity) appCompatActivity).f1432c, "号码必须为数字");
                    break;
                } else if (charSequence.length() > 0) {
                    if (charSequence.length() >= 9) {
                        ManagerActivity managerActivity = (ManagerActivity) appCompatActivity;
                        s0.e.a(managerActivity.f1432c, "超出范围！");
                        managerActivity.f1431b.setText("");
                        managerActivity.f1435f = 0;
                        break;
                    } else {
                        int iIntValue = Integer.valueOf(charSequence.toString()).intValue();
                        if (iIntValue >= 1 && iIntValue <= 16776415) {
                            ((ManagerActivity) appCompatActivity).f1435f = iIntValue;
                            break;
                        } else {
                            ManagerActivity managerActivity2 = (ManagerActivity) appCompatActivity;
                            s0.e.a(managerActivity2.f1432c, "超出范围！");
                            managerActivity2.f1431b.setText("");
                            managerActivity2.f1435f = 0;
                            break;
                        }
                    }
                }
                break;
        }
    }
}
