package k0;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.m0;
import androidx.recyclerview.widget.z1;
import com.chamsion.quickchat.R;

/* loaded from: classes.dex */
public final class q extends m0 {

    /* renamed from: e, reason: collision with root package name */
    public static final m f2004e = new m(0);

    /* renamed from: b, reason: collision with root package name */
    public boolean f2005b;

    /* renamed from: c, reason: collision with root package name */
    public p0.n f2006c;

    /* renamed from: d, reason: collision with root package name */
    public o f2007d;

    public q() {
        super(f2004e);
        this.f2005b = false;
        this.f2006c = null;
    }

    @Override // androidx.recyclerview.widget.v0
    public final void onBindViewHolder(z1 z1Var, int i2) {
        final p pVar = (p) z1Var;
        final a aVar = (a) a(i2);
        String string = aVar.f1940d;
        if (TextUtils.isEmpty(string)) {
            StringBuilder sb = new StringBuilder();
            sb.append(pVar.f1997a.getContext().getResources().getString(aVar.f1941e == 1 ? R.string.analog_channel : R.string.digital_channel));
            sb.append(aVar.f1939c);
            string = sb.toString();
        }
        pVar.f1997a.setText(string);
        String str = "Tx:" + aVar.f1945i;
        TextView textView = pVar.f1998b;
        textView.setText(str);
        pVar.f1999c.setText("Rx:" + aVar.f1944h);
        boolean z2 = this.f2005b;
        CheckBox checkBox = pVar.f2002f;
        if (z2) {
            checkBox.setVisibility(0);
        } else {
            checkBox.setVisibility(8);
        }
        pVar.f2000d.setOnClickListener(new View.OnClickListener() { // from class: k0.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p0.n nVar = this.f1989a.f2006c;
                if (nVar != null) {
                    nVar.a(aVar, pVar.getAdapterPosition());
                }
            }
        });
        boolean z3 = i2 == ((Integer) x0.g.J(textView.getContext(), "index", 0)).intValue();
        aVar.f1942f = z3;
        ImageView imageView = pVar.f2001e;
        if (z3) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(4);
        }
        pVar.f2003g.setOnClickListener(new n(this, aVar, pVar, 0));
    }

    @Override // androidx.recyclerview.widget.v0
    public final z1 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_channel, viewGroup, false);
        p pVar = new p(viewInflate);
        pVar.f1997a = (TextView) viewInflate.findViewById(R.id.tv_name);
        pVar.f1998b = (TextView) viewInflate.findViewById(R.id.tv_tx);
        pVar.f1999c = (TextView) viewInflate.findViewById(R.id.tv_rx);
        pVar.f2000d = (ImageView) viewInflate.findViewById(R.id.iv_more);
        pVar.f2002f = (CheckBox) viewInflate.findViewById(R.id.cb_delete);
        pVar.f2001e = (ImageView) viewInflate.findViewById(R.id.iv_enable);
        pVar.f2003g = (LinearLayout) viewInflate.findViewById(R.id.ll_item);
        return pVar;
    }
}
