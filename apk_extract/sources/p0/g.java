package p0;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import com.chamsion.quickchat.R;
import com.chamsion.quickchat.db.contacts.ContactDatabase;
import com.chamsion.quickchat.ui.AddNewChannelActivity;
import com.chamsion.quickchat.ui.AddNewContactsActivity;
import com.chamsion.quickchat.ui.ChatActivity;
import com.chamsion.quickchat.ui.ManagerActivity;
import com.chamsion.quickchat.ui.SettingsActivity;
import com.chamsion.quickchat.ui.UpdateDmrAcitivity;
import com.wonder.dmr.DmrManager;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class g implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2337a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View.OnCreateContextMenuListener f2338b;

    public /* synthetic */ g(View.OnCreateContextMenuListener onCreateContextMenuListener, int i2) {
        this.f2337a = i2;
        this.f2338b = onCreateContextMenuListener;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i2 = this.f2337a;
        final int i3 = 0;
        final int i4 = 1;
        View.OnCreateContextMenuListener onCreateContextMenuListener = this.f2338b;
        switch (i2) {
            case 0:
                AddNewChannelActivity addNewChannelActivity = (AddNewChannelActivity) onCreateContextMenuListener;
                if (addNewChannelActivity.f1298t.getSelectedItem().equals(addNewChannelActivity.getString(R.string.interphone_channel_contact_type_default))) {
                    String[] strArr = new String[addNewChannelActivity.E0.size()];
                    for (int i5 = 0; i5 < addNewChannelActivity.E0.size(); i5++) {
                        strArr[i5] = ((m0.a) addNewChannelActivity.E0.get(i5)).f2092c + "    " + ((m0.a) addNewChannelActivity.E0.get(i5)).f2093d;
                    }
                    AddNewChannelActivity addNewChannelActivity2 = addNewChannelActivity.f1262b;
                    new AlertDialog.Builder(addNewChannelActivity2).setTitle(addNewChannelActivity.getString(R.string.select_contact)).setItems(strArr, new DialogInterface.OnClickListener(this) { // from class: p0.f

                        /* renamed from: b, reason: collision with root package name */
                        public final /* synthetic */ g f2316b;

                        {
                            this.f2316b = this;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i6) {
                            int i7 = i3;
                            g gVar = this.f2316b;
                            switch (i7) {
                                case 0:
                                    AddNewChannelActivity addNewChannelActivity3 = (AddNewChannelActivity) gVar.f2338b;
                                    addNewChannelActivity3.f1281k0 = ((m0.a) addNewChannelActivity3.E0.get(i6)).f2093d;
                                    addNewChannelActivity3.S.setText(addNewChannelActivity3.f1281k0 + "");
                                    break;
                                default:
                                    AddNewChannelActivity addNewChannelActivity4 = (AddNewChannelActivity) gVar.f2338b;
                                    addNewChannelActivity4.f1281k0 = ((m0.a) addNewChannelActivity4.F0.get(i6)).f2093d;
                                    addNewChannelActivity4.S.setText(addNewChannelActivity4.f1281k0 + "");
                                    break;
                            }
                        }
                    }).show();
                    break;
                } else if (addNewChannelActivity.f1298t.getSelectedItem().equals(addNewChannelActivity.getString(R.string.interphone_channel_contact_type_group))) {
                    String[] strArr2 = new String[addNewChannelActivity.F0.size()];
                    while (i3 < addNewChannelActivity.F0.size()) {
                        strArr2[i3] = ((m0.a) addNewChannelActivity.F0.get(i3)).f2092c + "    " + ((m0.a) addNewChannelActivity.F0.get(i3)).f2093d;
                        i3++;
                    }
                    AddNewChannelActivity addNewChannelActivity3 = addNewChannelActivity.f1262b;
                    new AlertDialog.Builder(addNewChannelActivity3).setTitle(addNewChannelActivity.getString(R.string.select_contact)).setItems(strArr2, new DialogInterface.OnClickListener(this) { // from class: p0.f

                        /* renamed from: b, reason: collision with root package name */
                        public final /* synthetic */ g f2316b;

                        {
                            this.f2316b = this;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i6) {
                            int i7 = i4;
                            g gVar = this.f2316b;
                            switch (i7) {
                                case 0:
                                    AddNewChannelActivity addNewChannelActivity32 = (AddNewChannelActivity) gVar.f2338b;
                                    addNewChannelActivity32.f1281k0 = ((m0.a) addNewChannelActivity32.E0.get(i6)).f2093d;
                                    addNewChannelActivity32.S.setText(addNewChannelActivity32.f1281k0 + "");
                                    break;
                                default:
                                    AddNewChannelActivity addNewChannelActivity4 = (AddNewChannelActivity) gVar.f2338b;
                                    addNewChannelActivity4.f1281k0 = ((m0.a) addNewChannelActivity4.F0.get(i6)).f2093d;
                                    addNewChannelActivity4.S.setText(addNewChannelActivity4.f1281k0 + "");
                                    break;
                            }
                        }
                    }).show();
                    break;
                }
                break;
            case 1:
                int id = view.getId();
                if (id == R.id.btn_send) {
                    ChatActivity chatActivity = (ChatActivity) onCreateContextMenuListener;
                    if (chatActivity.f1345j) {
                        String string = chatActivity.f1338c.getText().toString();
                        Log.d(chatActivity.f1336a, "roomMessageObserve,TYPE_PERSON, ID:" + chatActivity.f1342g.f2093d + " type " + chatActivity.f1342g.f2091b);
                        if (!TextUtils.isEmpty(string)) {
                            DmrManager.getInstance().sendMsg(2, chatActivity.f1342g.f2093d, string, new androidx.fragment.app.d(chatActivity, string));
                            Handler handler = chatActivity.f1348m;
                            if (handler != null) {
                                handler.sendEmptyMessageDelayed(256, 1500L);
                            }
                            chatActivity.f1345j = false;
                            break;
                        }
                    }
                } else if (id == R.id.iv_close) {
                    ((ChatActivity) onCreateContextMenuListener).finish();
                    break;
                }
                break;
            case 2:
                int id2 = view.getId();
                if (id2 == R.id.ib_person) {
                    r rVar = (r) onCreateContextMenuListener;
                    int i6 = r.D;
                    rVar.f2429j.setSelected(true);
                    rVar.f2430k.setSelected(false);
                    rVar.f2437r = 0;
                    rVar.f2439t.a(rVar.f2440u);
                    rVar.f2439t.notifyDataSetChanged();
                    break;
                } else if (id2 == R.id.ib_group) {
                    r rVar2 = (r) onCreateContextMenuListener;
                    rVar2.f2429j.setSelected(false);
                    rVar2.f2430k.setSelected(true);
                    rVar2.f2437r = 1;
                    rVar2.f2439t.a(rVar2.f2441v);
                    rVar2.f2439t.notifyDataSetChanged();
                    break;
                } else if (id2 == R.id.iv_add) {
                    r rVar3 = (r) onCreateContextMenuListener;
                    int i7 = r.D;
                    rVar3.f2434o.setEnabled(false);
                    Intent intent = new Intent(rVar3.getActivity(), (Class<?>) AddNewContactsActivity.class);
                    intent.putExtra("type_contacts", rVar3.f2437r);
                    intent.putExtra("what", "add");
                    rVar3.startActivityForResult(intent, 1);
                    break;
                } else if (id2 == R.id.iv_delete) {
                    int i8 = r.D;
                    ((r) onCreateContextMenuListener).g(true);
                    break;
                } else if (id2 == R.id.iv_delete_comfirm) {
                    r rVar4 = (r) onCreateContextMenuListener;
                    m0.k kVar = rVar4.f2439t;
                    kVar.getClass();
                    ArrayList arrayList = new ArrayList();
                    int i9 = 0;
                    while (true) {
                        ArrayList arrayList2 = kVar.f2123b;
                        if (i9 >= arrayList2.size()) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                m0.a aVar = (m0.a) it.next();
                                m0.m mVar = rVar4.f2443x.f2132a;
                                mVar.getClass();
                                ContactDatabase.f1247b.execute(new m0.l(mVar, aVar, i4));
                            }
                            rVar4.g(false);
                            break;
                        } else {
                            if (((Boolean) kVar.f2124c.get(i9)).booleanValue()) {
                                arrayList.add((m0.a) arrayList2.get(i9));
                            }
                            i9++;
                        }
                    }
                } else if (id2 == R.id.tv_select_cancel) {
                    int i10 = r.D;
                    ((r) onCreateContextMenuListener).g(false);
                    break;
                } else if (id2 == R.id.tv_select_all) {
                    r rVar5 = (r) onCreateContextMenuListener;
                    int i11 = r.D;
                    Log.d(rVar5.f2426g, "selectAll");
                    rVar5.f2439t.b(true);
                    break;
                } else if (id2 == R.id.channel_list_area_dialog_edit) {
                    r rVar6 = (r) onCreateContextMenuListener;
                    Dialog dialog = rVar6.C;
                    if (dialog != null) {
                        dialog.dismiss();
                        rVar6.C = null;
                    }
                    r.f(rVar6, rVar6.f2444y);
                    break;
                } else if (id2 == R.id.channel_list_area_dialog_delete) {
                    r rVar7 = (r) onCreateContextMenuListener;
                    Dialog dialog2 = rVar7.C;
                    if (dialog2 != null) {
                        dialog2.dismiss();
                        rVar7.C = null;
                    }
                    m0.n nVar = rVar7.f2443x;
                    m0.a aVar2 = rVar7.f2444y;
                    m0.m mVar2 = nVar.f2132a;
                    mVar2.getClass();
                    ContactDatabase.f1247b.execute(new m0.l(mVar2, aVar2, i4));
                    break;
                }
                break;
            case 3:
                if (view.getId() == R.id.iv_close) {
                    ManagerActivity managerActivity = (ManagerActivity) onCreateContextMenuListener;
                    managerActivity.setResult(-1, new Intent());
                    managerActivity.finish();
                    break;
                } else if (view.getId() == R.id.btn_send) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    ManagerActivity managerActivity2 = (ManagerActivity) onCreateContextMenuListener;
                    int i12 = ManagerActivity.f1429h;
                    managerActivity2.getClass();
                    if (jCurrentTimeMillis > 1000) {
                        if (managerActivity2.f1434e == 0) {
                            s0.e.a(managerActivity2.f1432c, "请选择功能！");
                        }
                        if (managerActivity2.f1435f == 0) {
                            managerActivity2.f1431b.setError("请输入对方ID！");
                            break;
                        } else {
                            DmrManager.getInstance().setEnhancements(managerActivity2.f1434e, managerActivity2.f1435f, new k.j(18, managerActivity2));
                            break;
                        }
                    } else {
                        Toast.makeText(managerActivity2.f1432c, "按太快了", 0).show();
                        break;
                    }
                }
                break;
            case 4:
                int id3 = view.getId();
                if (id3 == R.id.iv_edit) {
                    SettingsActivity settingsActivity = (SettingsActivity) onCreateContextMenuListener;
                    int i13 = SettingsActivity.D;
                    settingsActivity.getClass();
                    Dialog dialog3 = new Dialog(settingsActivity.f1469r);
                    dialog3.setContentView(R.layout.dialog_edit_text);
                    int i14 = settingsActivity.getResources().getDisplayMetrics().widthPixels;
                    Window window = dialog3.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.gravity = 80;
                    attributes.y = 60;
                    attributes.width = (int) (i14 * 0.9f);
                    window.setAttributes(attributes);
                    window.setBackgroundDrawableResource(android.R.color.transparent);
                    EditText editText = (EditText) dialog3.findViewById(R.id.device_id_input);
                    TextView textView = (TextView) dialog3.findViewById(R.id.btn_id_ok);
                    TextView textView2 = (TextView) dialog3.findViewById(R.id.btn_id_cancel);
                    textView.setOnClickListener(new k0.n(settingsActivity, editText, dialog3, i4));
                    textView2.setOnClickListener(new y0(settingsActivity, dialog3, i3));
                    dialog3.show();
                    break;
                } else if (id3 == R.id.iv_close) {
                    SettingsActivity settingsActivity2 = (SettingsActivity) onCreateContextMenuListener;
                    settingsActivity2.setResult(-1, new Intent());
                    settingsActivity2.finish();
                    break;
                } else if (id3 == R.id.rl_udpate_dmr) {
                    SettingsActivity settingsActivity3 = (SettingsActivity) onCreateContextMenuListener;
                    settingsActivity3.finish();
                    int i15 = SettingsActivity.D;
                    settingsActivity3.startActivity(new Intent(settingsActivity3, (Class<?>) UpdateDmrAcitivity.class));
                    break;
                } else if (id3 == R.id.rl_enhance_dmr) {
                    SettingsActivity settingsActivity4 = (SettingsActivity) onCreateContextMenuListener;
                    int i16 = SettingsActivity.D;
                    settingsActivity4.getClass();
                    k.j jVar = new k.j(20, settingsActivity4);
                    t0.a aVar3 = new t0.a(settingsActivity4);
                    aVar3.f2551a = settingsActivity4;
                    aVar3.f2552b = jVar;
                    aVar3.show();
                    break;
                }
                break;
            case 5:
                int id4 = view.getId();
                if (id4 == R.id.btn_update) {
                    UpdateDmrAcitivity updateDmrAcitivity = (UpdateDmrAcitivity) onCreateContextMenuListener;
                    if (!updateDmrAcitivity.f1489l) {
                        String string2 = updateDmrAcitivity.getString(R.string.upgrading_please_wait);
                        if (updateDmrAcitivity.f1486i == null) {
                            ProgressDialog progressDialog = new ProgressDialog(updateDmrAcitivity);
                            updateDmrAcitivity.f1486i = progressDialog;
                            progressDialog.setCancelable(false);
                            updateDmrAcitivity.f1486i.setCanceledOnTouchOutside(false);
                        }
                        if (updateDmrAcitivity.f1487j) {
                            updateDmrAcitivity.f1486i.setMessage(string2);
                        } else {
                            updateDmrAcitivity.f1486i.setMessage(string2);
                            updateDmrAcitivity.f1486i.show();
                            updateDmrAcitivity.f1487j = true;
                        }
                        Toast.makeText(updateDmrAcitivity.f1483f, R.string.update_starting, 0).show();
                        updateDmrAcitivity.f1491n.sendEmptyMessage(258);
                        break;
                    }
                } else if (id4 == R.id.iv_close) {
                    if (DmrManager.getInstance().isDmrUpgrade()) {
                        int i17 = UpdateDmrAcitivity.A;
                        ((UpdateDmrAcitivity) onCreateContextMenuListener).h();
                        break;
                    } else {
                        UpdateDmrAcitivity updateDmrAcitivity2 = (UpdateDmrAcitivity) onCreateContextMenuListener;
                        s0.e.a(updateDmrAcitivity2.f1483f, updateDmrAcitivity2.getString(R.string.exit_and_reboot_model));
                        updateDmrAcitivity2.h();
                        break;
                    }
                } else if (id4 == R.id.btn_update_file) {
                    UpdateDmrAcitivity updateDmrAcitivity3 = (UpdateDmrAcitivity) onCreateContextMenuListener;
                    if (!updateDmrAcitivity3.f1489l) {
                        if (Build.VERSION.SDK_INT >= 30) {
                            if (Environment.isExternalStorageManager()) {
                                updateDmrAcitivity3.g();
                                break;
                            } else {
                                updateDmrAcitivity3.startActivityForResult(new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION"), 1);
                                break;
                            }
                        } else if (i.e.a(updateDmrAcitivity3, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
                            h.f.c(updateDmrAcitivity3, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
                            break;
                        } else {
                            updateDmrAcitivity3.g();
                            break;
                        }
                    }
                }
                break;
            default:
                ((t0.a) onCreateContextMenuListener).dismiss();
                break;
        }
    }
}
