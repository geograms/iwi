package s0;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

/* loaded from: classes.dex */
public final /* synthetic */ class j implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2542a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f2543b;

    public /* synthetic */ j(l lVar, int i2) {
        this.f2542a = i2;
        this.f2543b = lVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        int i3 = this.f2542a;
        l lVar = this.f2543b;
        switch (i3) {
            case 0:
                lVar.b();
                break;
            case 1:
                lVar.f2545a.finish();
                break;
            case 2:
                Activity activity = lVar.f2545a;
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                activity.startActivityForResult(intent, 101);
                break;
            case 3:
                lVar.f2545a.finish();
                break;
            case 4:
                lVar.a();
                break;
            case 5:
                lVar.f2545a.finish();
                break;
            case 6:
                h.f.c(lVar.f2545a, new String[]{"android.permission.READ_PHONE_STATE"}, 1003);
                break;
            default:
                lVar.f2545a.finish();
                break;
        }
    }
}
