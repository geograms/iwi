package n0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.m0;
import androidx.recyclerview.widget.z1;
import com.chamsion.quickchat.R;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public final class n extends m0 {

    /* renamed from: b, reason: collision with root package name */
    public final String f2188b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f2189c;

    /* renamed from: d, reason: collision with root package name */
    public final l f2190d;

    public n(Context context, l lVar) {
        super(new k0.m((Object) null));
        this.f2188b = n.class.getName();
        this.f2189c = context;
        this.f2190d = lVar;
    }

    @Override // androidx.recyclerview.widget.v0
    public final int getItemViewType(int i2) {
        return ((e) a(i2)).f2167k;
    }

    @Override // androidx.recyclerview.widget.v0
    public final void onBindViewHolder(z1 z1Var, int i2) throws Resources.NotFoundException {
        m mVar = (m) z1Var;
        e eVar = (e) a(i2);
        String str = this.f2188b;
        StringBuilder sb = new StringBuilder("MESSAGE = ");
        String str2 = eVar.f2164h;
        Context context = this.f2189c;
        int iIntValue = ((Integer) x0.g.J(context, "msg_encode", 0)).intValue();
        String[] stringArray = context.getResources().getStringArray(R.array.msg_encode);
        try {
            Log.e(str, "encode[type] = " + stringArray[iIntValue]);
            sb.append(str2 != null ? new String(str2.getBytes(), stringArray[iIntValue]) : null);
            Log.e(str, sb.toString());
            byte[] bArr = eVar.f2168l;
            t0.c cVarA = bArr != null ? t0.c.a(context, BitmapFactory.decodeByteArray(bArr, 0, bArr.length)) : null;
            int i3 = eVar.f2167k;
            if (i3 == 0) {
                mVar.f2183c.setVisibility(0);
                ImageView imageView = mVar.f2185e;
                imageView.setVisibility(0);
                mVar.f2186f.setVisibility(8);
                mVar.f2184d.setVisibility(8);
                mVar.f2181a.setText(eVar.f2164h);
                if (cVarA != null) {
                    imageView.setImageDrawable(cVarA);
                    return;
                }
                return;
            }
            if (i3 == 1) {
                mVar.f2183c.setVisibility(8);
                ImageView imageView2 = mVar.f2186f;
                imageView2.setVisibility(0);
                mVar.f2185e.setVisibility(8);
                mVar.f2184d.setVisibility(0);
                mVar.f2182b.setText(eVar.f2164h);
                if (cVarA != null) {
                    imageView2.setImageDrawable(cVarA);
                } else {
                    imageView2.setImageDrawable(t0.c.a(context, x0.g.M(context, x0.g.K(context))));
                }
            }
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // androidx.recyclerview.widget.v0
    public final z1 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new m(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_message, viewGroup, false));
    }
}
