package p0;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import com.chamsion.quickchat.ui.AddNewChannelActivity;
import com.chamsion.quickchat.ui.ChatActivity;
import com.chamsion.quickchat.ui.MainActivity;
import com.chamsion.quickchat.ui.SettingsActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class e implements Observer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2302a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppCompatActivity f2303b;

    public /* synthetic */ e(AppCompatActivity appCompatActivity, int i2) {
        this.f2302a = i2;
        this.f2303b = appCompatActivity;
    }

    public final void a(List list) {
        int i2 = this.f2302a;
        AppCompatActivity appCompatActivity = this.f2303b;
        switch (i2) {
            case 0:
                AddNewChannelActivity addNewChannelActivity = (AddNewChannelActivity) appCompatActivity;
                Log.d(addNewChannelActivity.f1260a, "roomObserveContacts " + list.size());
                ArrayList arrayList = addNewChannelActivity.E0;
                arrayList.clear();
                ArrayList arrayList2 = addNewChannelActivity.F0;
                arrayList2.clear();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    m0.a aVar = (m0.a) it.next();
                    if (aVar.f2091b == 0 && !arrayList.contains(aVar)) {
                        arrayList.add(aVar);
                    }
                }
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    m0.a aVar2 = (m0.a) it2.next();
                    if (aVar2.f2091b == 1 && !arrayList2.contains(aVar2)) {
                        arrayList2.add(aVar2);
                    }
                }
                if (addNewChannelActivity.Y) {
                    Iterator it3 = list.iterator();
                    while (it3.hasNext()) {
                        int i3 = ((m0.a) it3.next()).f2095f;
                        int i4 = addNewChannelActivity.X.f1937a;
                    }
                    break;
                }
                break;
            case 1:
                ChatActivity chatActivity = (ChatActivity) appCompatActivity;
                int i5 = ChatActivity.f1335n;
                chatActivity.getClass();
                Log.d(chatActivity.f1336a, "updateMessageList , " + list.size());
                ArrayList arrayList3 = chatActivity.f1344i;
                arrayList3.clear();
                arrayList3.addAll(list);
                int itemCount = chatActivity.f1343h.getItemCount();
                if (itemCount > 0) {
                    chatActivity.f1343h.smoothScrollToPosition(chatActivity.f1339d, null, itemCount - 1);
                    break;
                }
                break;
            case 2:
                ArrayList arrayList4 = ((MainActivity) appCompatActivity).f1412j;
                arrayList4.clear();
                arrayList4.addAll(list);
                break;
            default:
                SettingsActivity settingsActivity = (SettingsActivity) appCompatActivity;
                if (settingsActivity.f1472u) {
                    settingsActivity.f1474w.clear();
                    settingsActivity.f1474w.addAll(list);
                    Log.d(settingsActivity.f1452a, "mChannelViewModel .... " + settingsActivity.f1474w.size());
                    break;
                }
                break;
        }
    }

    @Override // androidx.lifecycle.Observer
    public final /* bridge */ /* synthetic */ void onChanged(Object obj) {
        switch (this.f2302a) {
            case 0:
                a((List) obj);
                break;
            case 1:
                a((List) obj);
                break;
            case 2:
                a((List) obj);
                break;
            default:
                a((List) obj);
                break;
        }
    }
}
