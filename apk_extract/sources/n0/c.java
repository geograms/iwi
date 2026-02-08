package n0;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.z1;
import com.chamsion.quickchat.R;
import k0.y;

/* loaded from: classes.dex */
public final class c extends z1 {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f2147f = 0;

    /* renamed from: a, reason: collision with root package name */
    public final ImageView f2148a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f2149b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f2150c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f2151d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ d f2152e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, View view) {
        super(view);
        this.f2152e = dVar;
        this.f2148a = (ImageView) view.findViewById(R.id.iv_avatar);
        this.f2149b = (TextView) view.findViewById(R.id.tv_name);
        this.f2150c = (TextView) view.findViewById(R.id.tv_last_message);
        this.f2151d = (TextView) view.findViewById(R.id.tv_time);
        view.setOnClickListener(new y(1, this));
        view.setOnLongClickListener(new b(0, this));
    }
}
