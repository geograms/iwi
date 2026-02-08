package p0;

import android.util.Log;
import androidx.lifecycle.Observer;
import com.chamsion.quickchat.ui.FragmentLocalDeviceAreaActivity;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class s implements Observer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2447a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FragmentLocalDeviceAreaActivity f2448b;

    public /* synthetic */ s(FragmentLocalDeviceAreaActivity fragmentLocalDeviceAreaActivity, int i2) {
        this.f2447a = i2;
        this.f2448b = fragmentLocalDeviceAreaActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i2 = this.f2447a;
        FragmentLocalDeviceAreaActivity fragmentLocalDeviceAreaActivity = this.f2448b;
        switch (i2) {
            case 0:
                List list = (List) obj;
                int i3 = FragmentLocalDeviceAreaActivity.f1349m;
                fragmentLocalDeviceAreaActivity.getClass();
                if (list != null && !list.isEmpty()) {
                    fragmentLocalDeviceAreaActivity.f1356g = list;
                    k0.a0 a0Var = fragmentLocalDeviceAreaActivity.f1359j;
                    a0Var.f890a.b(list, new androidx.activity.b(7, fragmentLocalDeviceAreaActivity));
                    break;
                }
                break;
            default:
                List list2 = (List) obj;
                int i4 = FragmentLocalDeviceAreaActivity.f1349m;
                fragmentLocalDeviceAreaActivity.getClass();
                if (list2 != null && ((Integer) x0.g.J(fragmentLocalDeviceAreaActivity, "index", 0)).intValue() >= list2.size()) {
                    x0.g.m0(fragmentLocalDeviceAreaActivity, "index", 0);
                    Log.d("FragmentLocalDeviceAreaActivity", "HZH onClick 364: 0");
                    break;
                }
                break;
        }
    }
}
