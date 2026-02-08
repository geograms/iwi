package n0;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.z1;
import com.chamsion.quickchat.R;
import k0.y;

/* loaded from: classes.dex */
public final class m extends z1 {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f2180h = 0;

    /* renamed from: a, reason: collision with root package name */
    public final TextView f2181a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f2182b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f2183c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayout f2184d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f2185e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f2186f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ n f2187g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(n nVar, View view) {
        super(view);
        this.f2187g = nVar;
        this.f2181a = (TextView) view.findViewById(R.id.tv_in);
        this.f2182b = (TextView) view.findViewById(R.id.tv_out);
        this.f2183c = (LinearLayout) view.findViewById(R.id.left_layout);
        this.f2184d = (LinearLayout) view.findViewById(R.id.right_layout);
        this.f2185e = (ImageView) view.findViewById(R.id.iv_in);
        this.f2186f = (ImageView) view.findViewById(R.id.iv_out);
        view.setOnClickListener(new y(2, this));
    }
}
