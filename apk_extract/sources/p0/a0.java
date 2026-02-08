package p0;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.chamsion.quickchat.R;
import com.chamsion.quickchat.ui.FragmentLocalSettingsActivity;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class a0 extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2282a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f2283b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FragmentLocalSettingsActivity f2284c;

    public /* synthetic */ a0(FragmentLocalSettingsActivity fragmentLocalSettingsActivity, Context context, int i2) {
        this.f2282a = i2;
        this.f2284c = fragmentLocalSettingsActivity;
        this.f2283b = context;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        int i2 = this.f2282a;
        FragmentLocalSettingsActivity fragmentLocalSettingsActivity = this.f2284c;
        switch (i2) {
            case 0:
                return fragmentLocalSettingsActivity.f1395t.size();
            default:
                return fragmentLocalSettingsActivity.f1396u.size();
        }
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i2) {
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        z zVar;
        View viewInflate;
        b0 b0Var;
        View viewInflate2;
        int i3 = this.f2282a;
        FragmentLocalSettingsActivity fragmentLocalSettingsActivity = this.f2284c;
        Context context = this.f2283b;
        switch (i3) {
            case 0:
                if (view == null) {
                    zVar = new z();
                    viewInflate = LayoutInflater.from(context).inflate(R.layout.local_limit_send_time_dialog_list_item, viewGroup, false);
                    zVar.f2471a = (TextView) viewInflate.findViewById(R.id.limit_send_time_title);
                    zVar.f2472b = (ImageView) viewInflate.findViewById(R.id.limit_send_time_seleted);
                    zVar.f2473c = viewInflate.findViewById(R.id.limit_send_time_line);
                    viewInflate.setTag(zVar);
                } else {
                    zVar = (z) view.getTag();
                    viewInflate = view;
                }
                Log.e("FragmentLocalSettings", "getView  position = " + i2);
                Log.e("FragmentLocalSettings", "getView  mDataList = " + fragmentLocalSettingsActivity.f1395t.size());
                TextView textView = zVar.f2471a;
                ArrayList arrayList = fragmentLocalSettingsActivity.f1395t;
                textView.setText((CharSequence) arrayList.get(i2));
                zVar.f2472b.setSelected(fragmentLocalSettingsActivity.f1391p == i2);
                zVar.f2473c.setVisibility(arrayList.size() - 1 != i2 ? 0 : 8);
                return viewInflate;
            default:
                if (view == null) {
                    b0Var = new b0();
                    viewInflate2 = LayoutInflater.from(context).inflate(R.layout.local_limit_send_time_dialog_list_item, viewGroup, false);
                    b0Var.f2288a = (TextView) viewInflate2.findViewById(R.id.limit_send_time_title);
                    b0Var.f2289b = (ImageView) viewInflate2.findViewById(R.id.limit_send_time_seleted);
                    b0Var.f2290c = viewInflate2.findViewById(R.id.limit_send_time_line);
                    viewInflate2.setTag(b0Var);
                } else {
                    b0Var = (b0) view.getTag();
                    viewInflate2 = view;
                }
                Log.e("FragmentLocalSettings", "getView  position = " + i2);
                Log.e("FragmentLocalSettings", "getView  mDataList = " + fragmentLocalSettingsActivity.f1396u.size());
                TextView textView2 = b0Var.f2288a;
                ArrayList arrayList2 = fragmentLocalSettingsActivity.f1396u;
                textView2.setText((CharSequence) arrayList2.get(i2));
                b0Var.f2289b.setSelected(fragmentLocalSettingsActivity.f1392q == i2);
                b0Var.f2290c.setVisibility(arrayList2.size() - 1 != i2 ? 0 : 8);
                return viewInflate2;
        }
    }
}
