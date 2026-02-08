package p0;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.chamsion.quickchat.R;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2421a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r f2422b;

    public /* synthetic */ q(r rVar, int i2) {
        this.f2421a = i2;
        this.f2422b = rVar;
    }

    public final void a(m0.a aVar) {
        int i2 = this.f2421a;
        r rVar = this.f2422b;
        switch (i2) {
            case 0:
                int i3 = r.D;
                rVar.getClass();
                rVar.f2444y = aVar;
                View viewInflate = LayoutInflater.from(rVar.f2427h).inflate(R.layout.dialog_bottom_sheet, (ViewGroup) null);
                ((TextView) viewInflate.findViewById(R.id.channel_list_area_dialog_title)).setText(rVar.getString(R.string.channel_dialog_area));
                TextView textView = (TextView) viewInflate.findViewById(R.id.channel_list_area_dialog_edit);
                g gVar = rVar.B;
                textView.setOnClickListener(gVar);
                ((TextView) viewInflate.findViewById(R.id.channel_list_area_dialog_use)).setVisibility(8);
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.channel_list_area_dialog_delete);
                textView2.setOnClickListener(gVar);
                textView2.setVisibility(0);
                Dialog dialog = new Dialog(rVar.f2427h);
                rVar.C = dialog;
                dialog.setContentView(viewInflate);
                Dialog dialog2 = rVar.C;
                int i4 = rVar.getResources().getDisplayMetrics().widthPixels;
                Window window = dialog2.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.gravity = 80;
                attributes.y = 60;
                attributes.width = (int) (i4 * 0.9f);
                window.setAttributes(attributes);
                window.setBackgroundDrawableResource(android.R.color.transparent);
                rVar.C.show();
                break;
            default:
                r.f(rVar, aVar);
                break;
        }
    }
}
