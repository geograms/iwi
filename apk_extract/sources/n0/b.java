package n0;

import android.app.Dialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import com.chamsion.quickchat.R;
import com.chamsion.quickchat.db.message.MessageDatabase;
import com.chamsion.quickchat.ui.MainActivity;
import p0.c0;
import p0.e0;
import p0.o0;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2145a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2146b;

    public /* synthetic */ b(int i2, Object obj) {
        this.f2145a = i2;
        this.f2146b = obj;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        int i2 = this.f2145a;
        Object obj = this.f2146b;
        switch (i2) {
            case 0:
                c cVar = (c) obj;
                int adapterPosition = cVar.getAdapterPosition();
                if (adapterPosition == -1) {
                    return false;
                }
                d dVar = cVar.f2152e;
                c0 c0Var = dVar.f2154c;
                a aVar = (a) dVar.a(adapterPosition);
                c0Var.getClass();
                int i3 = e0.f2304q;
                final e0 e0Var = c0Var.f2294a;
                e0Var.getClass();
                final int i4 = aVar.f2138a;
                View viewInflate = LayoutInflater.from(e0Var.getContext()).inflate(R.layout.conversation_delete_dialog, (ViewGroup) null);
                ((TextView) viewInflate.findViewById(R.id.tv_delete)).setOnClickListener(new View.OnClickListener() { // from class: p0.d0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        e0 e0Var2 = e0Var;
                        n0.o oVar = e0Var2.f2311m.f2192a;
                        oVar.getClass();
                        MessageDatabase.f1252b.execute(new j.o(i4, 1, oVar));
                        Dialog dialog = e0Var2.f2313o;
                        if (dialog != null) {
                            dialog.dismiss();
                            e0Var2.f2313o = null;
                        }
                    }
                });
                Dialog dialog = new Dialog(e0Var.getContext());
                e0Var.f2313o = dialog;
                dialog.setContentView(viewInflate);
                Dialog dialog2 = e0Var.f2313o;
                int i5 = e0Var.getResources().getDisplayMetrics().widthPixels;
                Window window = dialog2.getWindow();
                if (window != null) {
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.gravity = 80;
                    attributes.y = 100;
                    attributes.width = (int) (i5 * 0.9f);
                    window.setAttributes(attributes);
                    window.setBackgroundDrawableResource(android.R.color.transparent);
                }
                e0Var.f2313o.show();
                return true;
            default:
                o0 o0Var = (o0) obj;
                int[] iArr = o0.f2371h0;
                if (((MainActivity) o0Var.getActivity()).f1426x) {
                    Toast.makeText(o0Var.f2380h, R.string.incall_prompt, 0).show();
                } else if (o0Var.l()) {
                    Log.d(o0Var.f2378g, "mIvPtt onLongClick ");
                    if (i.e.a(o0Var.f2380h, "android.permission.RECORD_AUDIO") == 0) {
                        o0Var.m();
                        o0Var.W = true;
                        return true;
                    }
                    o0Var.requestPermissions(new String[]{"android.permission.RECORD_AUDIO"}, 100);
                }
                return false;
        }
    }
}
