package s0;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.chamsion.quickchat.R;
import java.util.ArrayList;
import p0.r0;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public Activity f2545a;

    /* renamed from: b, reason: collision with root package name */
    public r0 f2546b;

    public final void a() {
        Activity activity = this.f2545a;
        if (i.e.a(activity, "android.permission.READ_PHONE_STATE") == 0) {
            return;
        }
        int i2 = h.f.f1829b;
        if (h.c.c(activity, "android.permission.READ_PHONE_STATE")) {
            new AlertDialog.Builder(activity).setTitle(R.string.phone_permission_title).setMessage(R.string.phone_permission_message).setCancelable(false).setPositiveButton(R.string.phone_permission_go, new j(this, 6)).setNegativeButton(R.string.fragment_local_exit_app, new j(this, 7)).show();
        } else {
            h.f.c(this.f2545a, new String[]{"android.permission.READ_PHONE_STATE"}, 1003);
        }
    }

    public final void b() {
        Activity activity;
        String[] strArr = g.f2536a;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            activity = this.f2545a;
            if (i2 >= 2) {
                break;
            }
            String str = strArr[i2];
            if (i.e.a(activity, str) != 0) {
                arrayList.add(str);
            }
            i2++;
        }
        if (arrayList.isEmpty()) {
            return;
        }
        h.f.c(activity, (String[]) arrayList.toArray(new String[0]), 100);
    }

    public final void c() {
        new AlertDialog.Builder(this.f2545a).setTitle(R.string.must_permission).setMessage(R.string.rationale_permission).setCancelable(false).setPositiveButton(R.string.go_to_settings, new j(this, 2)).setNegativeButton(R.string.fragment_local_exit_app, new j(this, 3)).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: s0.k
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                Activity activity = this.f2544a.f2545a;
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                activity.startActivityForResult(intent, 101);
            }
        }).show();
    }
}
