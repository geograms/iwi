package m0;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.v0;
import androidx.recyclerview.widget.z1;
import com.chamsion.quickchat.R;
import java.util.ArrayList;
import java.util.List;
import p0.q;

/* loaded from: classes.dex */
public final class k extends v0 {

    /* renamed from: a, reason: collision with root package name */
    public String f2122a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f2123b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f2124c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2125d;

    /* renamed from: e, reason: collision with root package name */
    public q f2126e;

    /* renamed from: f, reason: collision with root package name */
    public q f2127f;

    public final void a(List list) {
        ArrayList arrayList = this.f2123b;
        arrayList.clear();
        arrayList.addAll(list);
        ArrayList arrayList2 = this.f2124c;
        arrayList2.clear();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(i2, Boolean.FALSE);
        }
    }

    public final void b(boolean z2) {
        ArrayList arrayList = this.f2124c;
        String str = this.f2122a;
        ArrayList arrayList2 = this.f2123b;
        int i2 = 0;
        if (z2) {
            this.f2125d = true;
            while (i2 < arrayList2.size()) {
                Log.d(str, z2 + " setSelectAll, i " + i2);
                arrayList.set(i2, Boolean.TRUE);
                i2++;
            }
        } else {
            this.f2125d = false;
            while (i2 < arrayList2.size()) {
                arrayList.set(i2, Boolean.FALSE);
                Log.d(str, z2 + " setSelectAll, i " + i2);
                i2++;
            }
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.v0
    public final int getItemCount() {
        return this.f2123b.size();
    }

    @Override // androidx.recyclerview.widget.v0
    public final void onBindViewHolder(z1 z1Var, int i2) {
        j jVar = (j) z1Var;
        a aVar = (a) this.f2123b.get(i2);
        Context context = jVar.itemView.getContext();
        jVar.f2115a.setText(aVar.f2092c);
        jVar.f2116b.setText(context.getString(R.string.number) + aVar.f2093d);
        jVar.f2118d.setText(context.getString(R.string.current_channel) + aVar.f2094e);
        byte[] bArr = aVar.f2097h;
        t0.c cVarA = bArr != null ? t0.c.a(context, BitmapFactory.decodeByteArray(bArr, 0, bArr.length)) : null;
        ImageView imageView = jVar.f2119e;
        if (cVarA == null) {
            imageView.setImageResource(R.drawable.ic_big_contacts_default);
        } else {
            imageView.setImageDrawable(cVarA);
        }
        CheckBox checkBox = jVar.f2120f;
        checkBox.setOnCheckedChangeListener(null);
        checkBox.setChecked(((Boolean) this.f2124c.get(i2)).booleanValue());
        checkBox.setOnCheckedChangeListener(new g(this, i2));
        if (this.f2125d) {
            checkBox.setVisibility(0);
        } else {
            checkBox.setVisibility(8);
        }
        jVar.f2117c.setOnClickListener(new h(this, i2, jVar));
        jVar.f2121g.setOnClickListener(new i(this, aVar, jVar));
    }

    @Override // androidx.recyclerview.widget.v0
    public final z1 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_contacts, viewGroup, false);
        j jVar = new j(viewInflate);
        jVar.f2115a = (TextView) viewInflate.findViewById(R.id.tv_name);
        jVar.f2116b = (TextView) viewInflate.findViewById(R.id.tv_number);
        jVar.f2118d = (TextView) viewInflate.findViewById(R.id.tv_channel);
        jVar.f2119e = (ImageView) viewInflate.findViewById(R.id.iv_user_logo);
        jVar.f2117c = (ImageView) viewInflate.findViewById(R.id.iv_more);
        jVar.f2120f = (CheckBox) viewInflate.findViewById(R.id.cb_delete);
        jVar.f2121g = (LinearLayout) viewInflate.findViewById(R.id.ll_item);
        return jVar;
    }
}
