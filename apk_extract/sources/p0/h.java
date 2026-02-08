package p0;

import android.content.Intent;
import com.chamsion.quickchat.ui.AddNewChannelActivity;

/* loaded from: classes.dex */
public final class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2343a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AddNewChannelActivity f2344b;

    public /* synthetic */ h(AddNewChannelActivity addNewChannelActivity, int i2) {
        this.f2343a = i2;
        this.f2344b = addNewChannelActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f2343a;
        AddNewChannelActivity addNewChannelActivity = this.f2344b;
        switch (i2) {
            case 0:
                addNewChannelActivity.finish();
                break;
            default:
                int i3 = AddNewChannelActivity.I0;
                addNewChannelActivity.getClass();
                addNewChannelActivity.setResult(-1, new Intent());
                addNewChannelActivity.finish();
                break;
        }
    }
}
