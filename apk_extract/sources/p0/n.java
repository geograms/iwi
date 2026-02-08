package p0;

import android.app.Dialog;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.chamsion.quickchat.R;
import com.chamsion.quickchat.ui.AddNewChannelActivity;
import com.wonder.dmr.DmrManager;
import com.wonder.dmr.OnDigitalCmdListener;
import com.wonder.dmr.OnPolicyListener;
import com.wonder.dmr.OnTransferInterruptListener;

/* loaded from: classes.dex */
public final /* synthetic */ class n implements OnDigitalCmdListener, k0.o, OnTransferInterruptListener, OnPolicyListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2366a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f2367b;

    public /* synthetic */ n(p pVar, int i2) {
        this.f2366a = i2;
        this.f2367b = pVar;
    }

    @Override // com.wonder.dmr.OnDigitalCmdListener, com.wonder.dmr.OnTransferInterruptListener
    public final void OnCallback(int i2) {
        int i3 = this.f2366a;
        p pVar = this.f2367b;
        switch (i3) {
            case 0:
                int i4 = p.C;
                if (i2 != 0) {
                    pVar.getClass();
                    break;
                } else {
                    pVar.g();
                    break;
                }
            case 3:
                if (i2 != 0) {
                    int i5 = p.C;
                    pVar.getClass();
                    break;
                } else {
                    DmrManager.getInstance().setPolite(((Integer) x0.g.J(pVar.f2400h, "polite", 1)).intValue(), new n(pVar, 4));
                    break;
                }
            default:
                int i6 = p.C;
                pVar.getClass();
                break;
        }
    }

    @Override // k0.o
    public final void a(k0.a aVar, int i2) {
        int i3 = this.f2366a;
        p pVar = this.f2367b;
        switch (i3) {
            case 1:
                int i4 = p.C;
                pVar.getClass();
                Log.d(pVar.f2399g, "onClick ," + aVar);
                if (!pVar.f2417y) {
                    DmrManager.getInstance().resetData();
                    pVar.f2413u = i2;
                    pVar.f2414v = aVar;
                    View viewInflate = LayoutInflater.from(pVar.f2400h).inflate(R.layout.dialog_bottom_sheet, (ViewGroup) null);
                    ((TextView) viewInflate.findViewById(R.id.channel_list_area_dialog_title)).setText(aVar.f1940d);
                    TextView textView = (TextView) viewInflate.findViewById(R.id.channel_list_area_dialog_use);
                    textView.setOnClickListener(pVar);
                    ((TextView) viewInflate.findViewById(R.id.channel_list_area_dialog_edit)).setOnClickListener(pVar);
                    TextView textView2 = (TextView) viewInflate.findViewById(R.id.channel_list_area_dialog_delete);
                    textView2.setOnClickListener(pVar);
                    if (aVar.f1942f) {
                        textView.setVisibility(8);
                        textView2.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                        textView2.setVisibility(0);
                    }
                    Dialog dialog = new Dialog(pVar.f2400h);
                    pVar.B = dialog;
                    dialog.setContentView(viewInflate);
                    Dialog dialog2 = pVar.B;
                    int i5 = pVar.getResources().getDisplayMetrics().widthPixels;
                    Window window = dialog2.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.gravity = 80;
                    attributes.y = 60;
                    attributes.width = (int) (i5 * 0.9f);
                    window.setAttributes(attributes);
                    window.setBackgroundDrawableResource(android.R.color.transparent);
                    pVar.B.show();
                    break;
                }
                break;
            default:
                int i6 = p.C;
                pVar.getClass();
                Intent intent = new Intent(pVar.getActivity(), (Class<?>) AddNewChannelActivity.class);
                intent.putExtra("channel", aVar);
                intent.putExtra("what", "modify");
                pVar.startActivityForResult(intent, 1);
                break;
        }
    }
}
