package t0;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import com.chamsion.quickchat.R;
import k.j;
import p0.g;
import p0.y0;

/* loaded from: classes.dex */
public final class a extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    public Context f2551a;

    /* renamed from: b, reason: collision with root package name */
    public j f2552b;

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.dialog_admin_password);
        EditText editText = (EditText) findViewById(R.id.password_input);
        TextView textView = (TextView) findViewById(R.id.btn_ok);
        TextView textView2 = (TextView) findViewById(R.id.btn_cancel);
        textView.setOnClickListener(new y0(this, editText, 1));
        textView2.setOnClickListener(new g(this, 6));
    }
}
