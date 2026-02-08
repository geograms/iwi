package q0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.recyclerview.widget.v0;
import androidx.recyclerview.widget.z1;
import com.chamsion.quickchat.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class c extends v0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f2484a = c.class.getName();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f2485b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public int f2486c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f2487d = 0;

    @Override // androidx.recyclerview.widget.v0
    public final int getItemCount() {
        return this.f2485b.size();
    }

    @Override // androidx.recyclerview.widget.v0
    public final long getItemId(int i2) {
        return i2;
    }

    @Override // androidx.recyclerview.widget.v0
    public final void onBindViewHolder(z1 z1Var, int i2) {
        b bVar = (b) z1Var;
        bVar.f2482a.setText((CharSequence) this.f2485b.get(i2));
        bVar.f2482a.addTextChangedListener(new a(this, i2, bVar));
    }

    @Override // androidx.recyclerview.widget.v0
    public final z1 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_group_list, viewGroup, false);
        b bVar = new b(viewInflate);
        bVar.f2482a = (EditText) viewInflate.findViewById(R.id.et_group_list);
        bVar.f2483b = (ImageView) viewInflate.findViewById(R.id.iv_error);
        return bVar;
    }
}
