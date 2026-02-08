package k0;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.z1;
import com.chamsion.quickchat.R;

/* loaded from: classes.dex */
public final class z extends z1 {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f2028a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f2029b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a0 f2030c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(a0 a0Var, View view) {
        super(view);
        this.f2030c = a0Var;
        this.f2028a = (TextView) view.findViewById(R.id.local_device_area_list_item_title);
        this.f2029b = (ImageView) view.findViewById(R.id.local_device_area_list_item_select);
        view.setOnClickListener(new y(0, this));
    }
}
