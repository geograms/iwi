package n0;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.m0;
import androidx.recyclerview.widget.z1;
import com.chamsion.quickchat.R;
import java.text.SimpleDateFormat;
import java.util.Locale;
import p0.c0;

/* loaded from: classes.dex */
public final class d extends m0 {

    /* renamed from: b, reason: collision with root package name */
    public final c0 f2153b;

    /* renamed from: c, reason: collision with root package name */
    public final c0 f2154c;

    /* renamed from: d, reason: collision with root package name */
    public final SimpleDateFormat f2155d;

    /* renamed from: e, reason: collision with root package name */
    public final Context f2156e;

    public d(androidx.fragment.app.c0 c0Var, c0 c0Var2, c0 c0Var3) {
        super(new k0.m());
        this.f2155d = new SimpleDateFormat("HH:mm", Locale.getDefault());
        this.f2153b = c0Var2;
        this.f2154c = c0Var3;
        this.f2156e = c0Var;
    }

    @Override // androidx.recyclerview.widget.v0
    public final void onBindViewHolder(z1 z1Var, int i2) {
        c cVar = (c) z1Var;
        a aVar = (a) a(i2);
        if (aVar != null) {
            cVar.getClass();
            int i3 = aVar.f2139b;
            byte[] bArr = aVar.f2143f;
            d dVar = cVar.f2152e;
            ImageView imageView = cVar.f2148a;
            if (bArr != null) {
                imageView.setImageDrawable(t0.c.a(dVar.f2156e, BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
            } else if (i3 == 0) {
                imageView.setImageResource(R.drawable.ic_person_circle);
            } else {
                imageView.setImageResource(R.drawable.ic_group_circle);
            }
            cVar.f2149b.setText(aVar.f2140c);
            cVar.f2150c.setText(aVar.f2141d);
            cVar.f2151d.setText(dVar.f2155d.format(Long.valueOf(aVar.f2142e)));
        }
    }

    @Override // androidx.recyclerview.widget.v0
    public final z1 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new c(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_conversation, viewGroup, false));
    }
}
