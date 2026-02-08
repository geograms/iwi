package p0;

import android.view.View;
import android.widget.Switch;
import com.chamsion.quickchat.ui.FragmentLocalSettingsActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class x implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2463a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FragmentLocalSettingsActivity f2464b;

    public /* synthetic */ x(FragmentLocalSettingsActivity fragmentLocalSettingsActivity, int i2) {
        this.f2463a = i2;
        this.f2464b = fragmentLocalSettingsActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i2 = this.f2463a;
        FragmentLocalSettingsActivity fragmentLocalSettingsActivity = this.f2464b;
        switch (i2) {
            case 0:
                int i3 = FragmentLocalSettingsActivity.M;
                fragmentLocalSettingsActivity.f();
                break;
            case 1:
                Switch r3 = fragmentLocalSettingsActivity.K;
                r3.setChecked(true ^ r3.isChecked());
                fragmentLocalSettingsActivity.f();
                break;
            case 2:
                int i4 = FragmentLocalSettingsActivity.M;
                fragmentLocalSettingsActivity.e(false);
                fragmentLocalSettingsActivity.L.dismiss();
                break;
            default:
                int i5 = FragmentLocalSettingsActivity.M;
                fragmentLocalSettingsActivity.e(true);
                fragmentLocalSettingsActivity.L.dismiss();
                break;
        }
    }
}
