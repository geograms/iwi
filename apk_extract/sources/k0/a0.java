package k0;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.m0;
import androidx.recyclerview.widget.z1;
import com.chamsion.quickchat.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class a0 extends m0 {

    /* renamed from: c, reason: collision with root package name */
    public static final m f1963c = new m(1);

    /* renamed from: b, reason: collision with root package name */
    public com.google.android.material.search.a f1964b;

    public final void b(String str) {
        ArrayList arrayList = new ArrayList();
        androidx.recyclerview.widget.f fVar = this.f890a;
        for (u uVar : fVar.f786f) {
            String str2 = uVar.f2017b;
            u uVar2 = new u(str2);
            uVar2.f2016a = uVar.f2016a;
            uVar2.f2018c = str.equals(str2);
            arrayList.add(uVar2);
        }
        fVar.b(arrayList, null);
    }

    @Override // androidx.recyclerview.widget.v0
    public final void onBindViewHolder(z1 z1Var, int i2) {
        z zVar = (z) z1Var;
        u uVar = (u) a(i2);
        String string = uVar.f2017b;
        int identifier = zVar.itemView.getContext().getResources().getIdentifier(string, "string", zVar.itemView.getContext().getPackageName());
        if (identifier != 0) {
            string = zVar.itemView.getContext().getString(identifier);
        }
        zVar.f2028a.setText(string);
        zVar.f2029b.setVisibility(uVar.f2018c ? 0 : 8);
    }

    @Override // androidx.recyclerview.widget.v0
    public final z1 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new z(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_local_device_area_list_item, viewGroup, false));
    }
}
