package com.chamsion.quickchat.ui;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chamsion.quickchat.R;
import com.chamsion.quickchat.db.channel.ChannelDatabase;
import com.chamsion.quickchat.ui.FragmentLocalDeviceAreaListActivity;
import com.google.android.material.search.a;
import com.wonder.dmr.utils.SPUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import k0.q;
import k0.t;
import p0.b;

/* loaded from: classes.dex */
public class FragmentLocalDeviceAreaListActivity extends AppCompatActivity implements View.OnClickListener {

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f1362k = 0;

    /* renamed from: a, reason: collision with root package name */
    public RecyclerView f1363a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f1364b;

    /* renamed from: c, reason: collision with root package name */
    public int f1365c;

    /* renamed from: d, reason: collision with root package name */
    public List f1366d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public int f1367e = -1;

    /* renamed from: f, reason: collision with root package name */
    public Dialog f1368f;

    /* renamed from: g, reason: collision with root package name */
    public AlertDialog f1369g;

    /* renamed from: h, reason: collision with root package name */
    public Toast f1370h;

    /* renamed from: i, reason: collision with root package name */
    public q f1371i;

    /* renamed from: j, reason: collision with root package name */
    public t f1372j;

    public final void d() {
        Intent intent = getIntent();
        this.f1365c = intent.getIntExtra("selectedId", 1);
        this.f1364b.setText(intent.getStringExtra("title"));
        q qVar = new q();
        this.f1371i = qVar;
        this.f1363a.setAdapter(qVar);
        t tVar = (t) new ViewModelProvider(this).get(t.class);
        this.f1372j = tVar;
        tVar.f2013a.a(this.f1365c).observe(this, new b(4, this));
        this.f1371i.f2007d = new a(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        int id = view.getId();
        if (id == R.id.back_button) {
            onBackPressed();
            return;
        }
        if (id == R.id.local_device_area_add) {
            Intent intent = new Intent(this, (Class<?>) AddNewChannelActivity.class);
            intent.putExtra("currentAreaId", this.f1365c);
            startActivity(intent);
            return;
        }
        if (id != R.id.local_device_area_dialog_delete) {
            if (id == R.id.local_device_area_dialog_edit) {
                Dialog dialog = this.f1368f;
                if (dialog != null) {
                    dialog.dismiss();
                    this.f1368f = null;
                }
                if (ActivityManager.isUserAMonkey()) {
                    return;
                }
                Intent intent2 = new Intent(this, (Class<?>) AddNewChannelActivity.class);
                intent2.putExtra("channel", (Serializable) this.f1366d.get(this.f1367e));
                intent2.putExtra("what", "modify");
                startActivityForResult(intent2, 1005);
                return;
            }
            return;
        }
        Dialog dialog2 = this.f1368f;
        if (dialog2 != null) {
            dialog2.dismiss();
            this.f1368f = null;
        }
        if (ActivityManager.isUserAMonkey()) {
            return;
        }
        k0.a aVar = (k0.a) this.f1366d.get(this.f1367e);
        String str = aVar.f1940d;
        if (str == null || str.isEmpty()) {
            StringBuilder sbF = a.a.f(aVar.f1941e == 0 ? getString(R.string.interphone_channel_type_digital) : getString(R.string.interphone_channel_type_analog));
            sbF.append(aVar.f1937a);
            string = sbF.toString();
        } else {
            string = aVar.f1940d;
        }
        String string2 = getString(R.string.interphone_delete_channel_dialog_info, string);
        AlertDialog alertDialog = this.f1369g;
        if (alertDialog == null) {
            final int i2 = 0;
            final int i3 = 1;
            this.f1369g = new AlertDialog.Builder(this).setTitle(getString(R.string.interphone_delete_channel_dialog_title)).setMessage(string2).setNegativeButton(getString(android.R.string.cancel), new DialogInterface.OnClickListener(this) { // from class: p0.w

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ FragmentLocalDeviceAreaListActivity f2460b;

                {
                    this.f2460b = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) throws Resources.NotFoundException {
                    int i5 = i2;
                    FragmentLocalDeviceAreaListActivity fragmentLocalDeviceAreaListActivity = this.f2460b;
                    switch (i5) {
                        case 0:
                            AlertDialog alertDialog2 = fragmentLocalDeviceAreaListActivity.f1369g;
                            if (alertDialog2 != null) {
                                alertDialog2.dismiss();
                                break;
                            }
                            break;
                        default:
                            int i6 = FragmentLocalDeviceAreaListActivity.f1362k;
                            boolean z2 = fragmentLocalDeviceAreaListActivity.getSharedPreferences(SPUtils.FILE_NAME, 0).getInt("pref_person_send_status", 0) == 1;
                            if (z2) {
                                int i7 = R.string.interphone_talk_send_status_toast;
                                Toast toast = fragmentLocalDeviceAreaListActivity.f1370h;
                                if (toast != null) {
                                    toast.cancel();
                                }
                                Toast toastMakeText = Toast.makeText(fragmentLocalDeviceAreaListActivity, i7, 0);
                                fragmentLocalDeviceAreaListActivity.f1370h = toastMakeText;
                                toastMakeText.show();
                            }
                            if (!z2) {
                                k0.a aVar2 = (k0.a) fragmentLocalDeviceAreaListActivity.f1366d.get(fragmentLocalDeviceAreaListActivity.f1367e);
                                if (aVar2.f1942f) {
                                    int i8 = R.string.interphone_delete_channel_warning;
                                    Toast toast2 = fragmentLocalDeviceAreaListActivity.f1370h;
                                    if (toast2 != null) {
                                        toast2.cancel();
                                    }
                                    Toast toastMakeText2 = Toast.makeText(fragmentLocalDeviceAreaListActivity, i8, 0);
                                    fragmentLocalDeviceAreaListActivity.f1370h = toastMakeText2;
                                    toastMakeText2.show();
                                } else {
                                    k0.s sVar = fragmentLocalDeviceAreaListActivity.f1372j.f2013a;
                                    sVar.getClass();
                                    ChannelDatabase.f1237b.execute(new k0.r(sVar, aVar2, 2));
                                }
                            }
                            AlertDialog alertDialog3 = fragmentLocalDeviceAreaListActivity.f1369g;
                            if (alertDialog3 != null) {
                                alertDialog3.dismiss();
                                break;
                            }
                            break;
                    }
                }
            }).setPositiveButton(getString(android.R.string.ok), new DialogInterface.OnClickListener(this) { // from class: p0.w

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ FragmentLocalDeviceAreaListActivity f2460b;

                {
                    this.f2460b = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) throws Resources.NotFoundException {
                    int i5 = i3;
                    FragmentLocalDeviceAreaListActivity fragmentLocalDeviceAreaListActivity = this.f2460b;
                    switch (i5) {
                        case 0:
                            AlertDialog alertDialog2 = fragmentLocalDeviceAreaListActivity.f1369g;
                            if (alertDialog2 != null) {
                                alertDialog2.dismiss();
                                break;
                            }
                            break;
                        default:
                            int i6 = FragmentLocalDeviceAreaListActivity.f1362k;
                            boolean z2 = fragmentLocalDeviceAreaListActivity.getSharedPreferences(SPUtils.FILE_NAME, 0).getInt("pref_person_send_status", 0) == 1;
                            if (z2) {
                                int i7 = R.string.interphone_talk_send_status_toast;
                                Toast toast = fragmentLocalDeviceAreaListActivity.f1370h;
                                if (toast != null) {
                                    toast.cancel();
                                }
                                Toast toastMakeText = Toast.makeText(fragmentLocalDeviceAreaListActivity, i7, 0);
                                fragmentLocalDeviceAreaListActivity.f1370h = toastMakeText;
                                toastMakeText.show();
                            }
                            if (!z2) {
                                k0.a aVar2 = (k0.a) fragmentLocalDeviceAreaListActivity.f1366d.get(fragmentLocalDeviceAreaListActivity.f1367e);
                                if (aVar2.f1942f) {
                                    int i8 = R.string.interphone_delete_channel_warning;
                                    Toast toast2 = fragmentLocalDeviceAreaListActivity.f1370h;
                                    if (toast2 != null) {
                                        toast2.cancel();
                                    }
                                    Toast toastMakeText2 = Toast.makeText(fragmentLocalDeviceAreaListActivity, i8, 0);
                                    fragmentLocalDeviceAreaListActivity.f1370h = toastMakeText2;
                                    toastMakeText2.show();
                                } else {
                                    k0.s sVar = fragmentLocalDeviceAreaListActivity.f1372j.f2013a;
                                    sVar.getClass();
                                    ChannelDatabase.f1237b.execute(new k0.r(sVar, aVar2, 2));
                                }
                            }
                            AlertDialog alertDialog3 = fragmentLocalDeviceAreaListActivity.f1369g;
                            if (alertDialog3 != null) {
                                alertDialog3.dismiss();
                                break;
                            }
                            break;
                    }
                }
            }).create();
        } else {
            alertDialog.setMessage(string2);
        }
        this.f1369g.show();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.c0, androidx.activity.h, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        d();
    }

    @Override // androidx.fragment.app.c0, androidx.activity.h, h.l, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fragment_local_device_area_list_activity);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.local_device_area_list);
        this.f1363a = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager());
        this.f1364b = (TextView) findViewById(R.id.fragment_local_device_area_list_title);
        ((Button) findViewById(R.id.local_device_area_add)).setOnClickListener(this);
        findViewById(R.id.back_button).setOnClickListener(this);
        d();
    }

    @Override // androidx.activity.h, android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override // androidx.fragment.app.c0, android.app.Activity
    public final void onResume() {
        super.onResume();
    }
}
