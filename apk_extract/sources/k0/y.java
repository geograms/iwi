package k0;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.chamsion.quickchat.R;
import com.chamsion.quickchat.ui.AddNewChannelActivity;
import com.chamsion.quickchat.ui.FragmentLocalDeviceAreaActivity;
import com.chamsion.quickchat.ui.FragmentLocalInformationActivity;
import com.chamsion.quickchat.ui.FragmentLocalUseGuideActivity;
import com.chamsion.quickchat.ui.MessageChatActivity;
import com.chamsion.quickchat.ui.SettingsActivity;
import com.wonder.dmr.DmrManager;
import java.util.ArrayList;
import p0.e0;
import p0.o0;

/* loaded from: classes.dex */
public final /* synthetic */ class y implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2026a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2027b;

    public /* synthetic */ y(int i2, Object obj) {
        this.f2026a = i2;
        this.f2027b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i2 = this.f2026a;
        Object obj = this.f2027b;
        switch (i2) {
            case 0:
                z zVar = (z) obj;
                int adapterPosition = zVar.getAdapterPosition();
                a0 a0Var = zVar.f2030c;
                com.google.android.material.search.a aVar = a0Var.f1964b;
                if (aVar != null && adapterPosition != -1) {
                    u uVar = (u) a0Var.a(adapterPosition);
                    FragmentLocalDeviceAreaActivity fragmentLocalDeviceAreaActivity = (FragmentLocalDeviceAreaActivity) aVar.f1575a;
                    int i3 = FragmentLocalDeviceAreaActivity.f1349m;
                    if (!fragmentLocalDeviceAreaActivity.e()) {
                        fragmentLocalDeviceAreaActivity.f1358i = uVar.f2017b;
                        Log.d("FragmentLocalDeviceAreaActivity", "点击的区域ID: " + fragmentLocalDeviceAreaActivity.f1358i);
                        if (!fragmentLocalDeviceAreaActivity.f1357h.equals(fragmentLocalDeviceAreaActivity.f1358i)) {
                            fragmentLocalDeviceAreaActivity.g(fragmentLocalDeviceAreaActivity.f1358i, false);
                            break;
                        } else {
                            fragmentLocalDeviceAreaActivity.g(fragmentLocalDeviceAreaActivity.f1358i, true);
                            break;
                        }
                    }
                }
                break;
            case 1:
                n0.c cVar = (n0.c) obj;
                int i4 = n0.c.f2147f;
                int adapterPosition2 = cVar.getAdapterPosition();
                if (adapterPosition2 != -1) {
                    n0.d dVar = cVar.f2152e;
                    p0.c0 c0Var = dVar.f2153b;
                    n0.a aVar2 = (n0.a) dVar.a(adapterPosition2);
                    c0Var.getClass();
                    int i5 = e0.f2304q;
                    e0 e0Var = c0Var.f2294a;
                    e0Var.getClass();
                    int i6 = aVar2.f2138a;
                    int i7 = aVar2.f2139b;
                    int i8 = aVar2.f2144g;
                    a aVarF = e0Var.f();
                    if (aVarF != null && aVarF.f1941e == 0) {
                        Intent intent = new Intent(e0Var.f2309k, (Class<?>) MessageChatActivity.class);
                        intent.putExtra("targetId", i6);
                        intent.putExtra("msgType", i7);
                        intent.putExtra("channelId", i8);
                        e0Var.startActivity(intent);
                        break;
                    } else {
                        Toast.makeText(e0Var.f2309k, R.string.analog_cannot_send_msg, 0).show();
                        break;
                    }
                }
                break;
            case 2:
                n0.m mVar = (n0.m) obj;
                int i9 = n0.m.f2180h;
                int adapterPosition3 = mVar.getAdapterPosition();
                if (adapterPosition3 != -1) {
                    n0.n nVar = mVar.f2187g;
                    n0.l lVar = nVar.f2190d;
                    lVar.f();
                    break;
                }
                break;
            case 3:
                int i10 = FragmentLocalInformationActivity.f1373c;
                ((FragmentLocalInformationActivity) obj).onBackPressed();
                break;
            case 4:
                int i11 = FragmentLocalUseGuideActivity.f1402a;
                ((FragmentLocalUseGuideActivity) obj).onBackPressed();
                break;
            case 5:
                e0 e0Var2 = (e0) obj;
                int i12 = e0.f2304q;
                a aVarF2 = e0Var2.f();
                if (aVarF2 != null && aVarF2.f1941e == 0) {
                    Intent intent2 = new Intent(e0Var2.f2309k, (Class<?>) MessageChatActivity.class);
                    intent2.putExtra("targetId", -1);
                    intent2.putExtra("msgType", -1);
                    intent2.putExtra("channelId", -1);
                    e0Var2.startActivity(intent2);
                    break;
                } else {
                    Toast.makeText(e0Var2.f2309k, R.string.analog_cannot_send_msg, 0).show();
                    break;
                }
                break;
            default:
                o0 o0Var = (o0) obj;
                int[] iArr = o0.f2371h0;
                o0Var.getClass();
                DmrManager.getInstance().resetData();
                int id = view.getId();
                if (id != R.id.iv_menu) {
                    int i13 = R.id.iv_previous;
                    ArrayList arrayList = o0Var.f2393u;
                    if (id != i13) {
                        if (id != R.id.iv_next) {
                            if (id != R.id.fab_edit_channel) {
                                if (id == R.id.fab_send_msg) {
                                    int i14 = o0Var.i();
                                    String strC = a.a.c("短信 - index = ", i14);
                                    String str = o0Var.f2378g;
                                    Log.e(str, strC);
                                    Log.d(str, "startMessageActivity  .position = " + i14 + ", " + ((a) arrayList.get(i14)).f1943g);
                                    ((Integer) x0.g.J(o0Var.f2380h, "index", 0)).intValue();
                                    Intent intent3 = new Intent(o0Var.getActivity(), (Class<?>) MessageChatActivity.class);
                                    intent3.putExtra("channel", o0Var.f2391s);
                                    intent3.putExtra("index", i14);
                                    intent3.putExtra("smsType", ((a) arrayList.get(i14)).f1943g);
                                    o0Var.startActivity(intent3);
                                    break;
                                }
                            } else if (o0Var.f2391s != null) {
                                Intent intent4 = new Intent(o0Var.getActivity(), (Class<?>) AddNewChannelActivity.class);
                                intent4.putExtra("channel", o0Var.f2391s);
                                intent4.putExtra("what", "modify");
                                o0Var.startActivityForResult(intent4, 1);
                                break;
                            }
                        } else if (o0Var.l()) {
                            int i15 = o0Var.f2392t + 1;
                            if (i15 > arrayList.size() - 1) {
                                o0Var.s(o0Var.getString(R.string.already_max_channel));
                                break;
                            } else {
                                o0Var.X = s0.e.c(o0Var.f2380h, "", o0Var.getString(R.string.interphone_channel_change_dialog_title));
                                o0Var.g((a) arrayList.get(i15), 0);
                                break;
                            }
                        }
                    } else if (o0Var.l()) {
                        int i16 = o0Var.f2392t - 1;
                        if (i16 < 0) {
                            o0Var.s(o0Var.getString(R.string.already_smallest_channel));
                            break;
                        } else {
                            o0Var.X = s0.e.c(o0Var.f2380h, "", o0Var.getString(R.string.interphone_channel_change_dialog_title));
                            o0Var.g((a) arrayList.get(i16), 1);
                            break;
                        }
                    }
                } else {
                    o0Var.startActivityForResult(new Intent(o0Var.getActivity(), (Class<?>) SettingsActivity.class), 1);
                    break;
                }
                break;
        }
    }
}
