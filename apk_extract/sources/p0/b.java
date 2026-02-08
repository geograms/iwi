package p0;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.chamsion.quickchat.R;
import com.chamsion.quickchat.ui.AddNewChannelActivity;
import com.chamsion.quickchat.ui.FragmentLocalDeviceAreaActivity;
import com.chamsion.quickchat.ui.FragmentLocalDeviceAreaListActivity;
import com.chamsion.quickchat.ui.FragmentLocalSettingsActivity;
import com.wonder.dmr.utils.SPUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Observer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2286a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2287b;

    public /* synthetic */ b(int i2, Object obj) {
        this.f2286a = i2;
        this.f2287b = obj;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) throws Resources.NotFoundException {
        int i2 = 0;
        int i3 = this.f2286a;
        Object obj2 = this.f2287b;
        switch (i3) {
            case 0:
                AddNewChannelActivity.d((AddNewChannelActivity) obj2, (List) obj);
                break;
            case 1:
                p pVar = (p) obj2;
                List list = (List) obj;
                int i4 = p.C;
                pVar.getClass();
                String str = " roomChannelObserve  .getAllChannels... " + list.size();
                String str2 = pVar.f2399g;
                Log.d(str2, str);
                ArrayList arrayList = pVar.f2410r;
                arrayList.clear();
                arrayList.addAll(list);
                pVar.f2412t.f890a.b(list, null);
                TextView textView = pVar.f2403k;
                Context context = pVar.getContext();
                Uri uri = j0.c.f1900a;
                textView.setText(j0.c.a(context, context.getSharedPreferences(SPUtils.FILE_NAME, 0).getString("pref_person_channel_area_selected_index", j0.c.f1904e)));
                pVar.f2415w = ((Integer) x0.g.J(pVar.f2400h, "index", 0)).intValue();
                Log.d(str2, " updateCurrentChannel,mCurrentIndex = " + pVar.f2415w);
                if (list.isEmpty()) {
                    pVar.f2416x = null;
                } else {
                    int size = list.size();
                    int i5 = pVar.f2415w;
                    if (size > i5) {
                        pVar.f2416x = (k0.a) list.get(i5);
                    }
                    if (pVar.f2416x == null) {
                        pVar.f((k0.a) list.get(0));
                    }
                }
                pVar.f2418z.removeMessages(256);
                pVar.f2418z.sendEmptyMessageDelayed(256, 500L);
                break;
            case 2:
                r rVar = (r) obj2;
                List<m0.a> list2 = (List) obj;
                ArrayList arrayList2 = rVar.f2440u;
                arrayList2.clear();
                ArrayList arrayList3 = rVar.f2441v;
                arrayList3.clear();
                for (m0.a aVar : list2) {
                    if (aVar.f2091b == 0 && !arrayList2.contains(aVar)) {
                        arrayList2.add(aVar);
                    }
                }
                for (m0.a aVar2 : list2) {
                    if (aVar2.f2091b == 1 && !arrayList3.contains(aVar2)) {
                        arrayList3.add(aVar2);
                    }
                }
                int i6 = rVar.f2437r;
                if (i6 == 0) {
                    rVar.f2439t.a(arrayList2);
                } else if (i6 == 1) {
                    rVar.f2439t.a(arrayList3);
                }
                rVar.f2439t.notifyDataSetChanged();
                if (list2.isEmpty()) {
                    rVar.f2442w.setVisibility(0);
                    rVar.f2442w.setText(R.string.empty_contact_warning);
                    rVar.f2431l.setVisibility(8);
                    break;
                } else {
                    rVar.f2442w.setVisibility(8);
                    rVar.f2431l.setVisibility(0);
                    break;
                }
            case 3:
                TextView textView2 = (TextView) obj2;
                List list3 = (List) obj;
                int i7 = FragmentLocalDeviceAreaActivity.f1349m;
                if (list3 != null && list3.isEmpty()) {
                    textView2.setVisibility(8);
                    break;
                }
                break;
            case 4:
                FragmentLocalDeviceAreaListActivity fragmentLocalDeviceAreaListActivity = (FragmentLocalDeviceAreaListActivity) obj2;
                List list4 = (List) obj;
                fragmentLocalDeviceAreaListActivity.f1366d = list4;
                while (true) {
                    if (i2 < fragmentLocalDeviceAreaListActivity.f1366d.size()) {
                        if (((k0.a) fragmentLocalDeviceAreaListActivity.f1366d.get(i2)).f1942f) {
                            fragmentLocalDeviceAreaListActivity.getClass();
                        } else {
                            i2++;
                        }
                    }
                }
                fragmentLocalDeviceAreaListActivity.f1371i.f890a.b(list4, null);
                fragmentLocalDeviceAreaListActivity.f1371i.notifyDataSetChanged();
                break;
            case 5:
                FragmentLocalSettingsActivity fragmentLocalSettingsActivity = (FragmentLocalSettingsActivity) obj2;
                List list5 = (List) obj;
                if (fragmentLocalSettingsActivity.G) {
                    ArrayList arrayList4 = fragmentLocalSettingsActivity.I;
                    arrayList4.clear();
                    arrayList4.addAll(list5);
                    Log.d("FragmentLocalSettings", "mChannelViewModel .... " + arrayList4.size());
                    break;
                }
                break;
            case 6:
                e0 e0Var = (e0) obj2;
                List list6 = (List) obj;
                e0Var.f2310l.f890a.b(list6, null);
                if (list6.isEmpty()) {
                    e0Var.f2312n.setVisibility(0);
                    e0Var.f2312n.setText(R.string.empty_message_warning);
                    e0Var.f2308j.setVisibility(8);
                    break;
                } else {
                    e0Var.f2312n.setVisibility(8);
                    e0Var.f2308j.setVisibility(0);
                    break;
                }
            default:
                o0 o0Var = (o0) obj2;
                List list7 = (List) obj;
                int[] iArr = o0.f2371h0;
                o0Var.getClass();
                Log.d("FragmentPtt", " onChanged 255: " + list7.size());
                int iIntValue = ((Integer) x0.g.J(o0Var.f2380h, "index", 0)).intValue();
                o0Var.f2392t = iIntValue;
                k0.a aVar3 = (k0.a) list7.get(iIntValue);
                ArrayList arrayList5 = o0Var.f2393u;
                arrayList5.clear();
                arrayList5.addAll(list7);
                k0.a aVar4 = o0Var.f2391s;
                if (aVar4 != null) {
                    k0.m mVar = k0.q.f2004e;
                    if (mVar.h(aVar3, aVar4) && mVar.f(aVar3, aVar4)) {
                        Log.d("FragmentPtt", " roomChannelObserve 247: 信道没有任何变化返回");
                        break;
                    }
                }
                String str3 = o0Var.f2378g;
                Log.d(str3, "updateCurrentChannel.");
                if (o0Var.f2392t >= arrayList5.size() || o0Var.f2392t < 0) {
                    Log.d("FragmentPtt", " updateCurrentChannel 297: mCurrentIndex out of range");
                    break;
                } else {
                    arrayList5.size();
                    k0.a aVar5 = (k0.a) arrayList5.get(o0Var.f2392t);
                    o0Var.f2391s = aVar5;
                    if (aVar5 == null) {
                        Log.d(str3, "updateCurrentChannel,如果没有一个就以第一个为当前启用");
                        o0Var.f2391s = (k0.a) list7.get(0);
                        o0Var.f2392t = 0;
                        o0Var.g((k0.a) list7.get(0), -1);
                    }
                    o0Var.f2375d0.removeMessages(256);
                    o0Var.f2375d0.sendEmptyMessageDelayed(256, 500L);
                    o0Var.v(o0Var.f2391s);
                    break;
                }
                break;
        }
    }
}
