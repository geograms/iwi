package p0;

import android.content.DialogInterface;
import com.chamsion.quickchat.ui.MainActivity;
import com.chamsion.quickchat.ui.UpdateDmrAcitivity;
import com.wonder.dmr.DmrManager;

/* loaded from: classes.dex */
public final /* synthetic */ class p0 implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2419a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2420b;

    public /* synthetic */ p0(int i2, Object obj) {
        this.f2419a = i2;
        this.f2420b = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        int i3 = this.f2419a;
        Object obj = this.f2420b;
        switch (i3) {
            case 0:
                MainActivity mainActivity = (MainActivity) obj;
                int i4 = MainActivity.I;
                mainActivity.d();
                mainActivity.finish();
                break;
            case 1:
                UpdateDmrAcitivity updateDmrAcitivity = (UpdateDmrAcitivity) obj;
                int i5 = UpdateDmrAcitivity.A;
                updateDmrAcitivity.getClass();
                DmrManager.getInstance().closeSerial();
                DmrManager.getInstance().resetData();
                updateDmrAcitivity.i();
                break;
            default:
                k.j jVar = (k.j) obj;
                UpdateDmrAcitivity updateDmrAcitivity2 = (UpdateDmrAcitivity) jVar.f1934b;
                int i6 = UpdateDmrAcitivity.A;
                updateDmrAcitivity2.getClass();
                DmrManager.getInstance().closeSerial();
                DmrManager.getInstance().resetData();
                ((UpdateDmrAcitivity) jVar.f1934b).i();
                break;
        }
    }
}
