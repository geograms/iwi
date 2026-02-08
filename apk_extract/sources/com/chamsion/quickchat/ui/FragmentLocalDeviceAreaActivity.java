package com.chamsion.quickchat.ui;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chamsion.quickchat.R;
import com.chamsion.quickchat.db.channel.ChannelDatabase;
import com.chamsion.quickchat.ui.FragmentLocalDeviceAreaActivity;
import com.google.android.material.search.a;
import com.wonder.dmr.utils.SPUtils;
import j0.c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import k0.a0;
import k0.b0;
import k0.c0;
import k0.g;
import k0.h;
import k0.t;
import k0.u;
import p0.b;
import p0.s;
import p0.v;

/* loaded from: classes.dex */
public class FragmentLocalDeviceAreaActivity extends AppCompatActivity implements View.OnClickListener {

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f1349m = 0;

    /* renamed from: a, reason: collision with root package name */
    public AlertDialog f1350a;

    /* renamed from: b, reason: collision with root package name */
    public Dialog f1351b;

    /* renamed from: c, reason: collision with root package name */
    public Dialog f1352c;

    /* renamed from: d, reason: collision with root package name */
    public EditText f1353d;

    /* renamed from: e, reason: collision with root package name */
    public Toast f1354e;

    /* renamed from: f, reason: collision with root package name */
    public RecyclerView f1355f;

    /* renamed from: g, reason: collision with root package name */
    public List f1356g;

    /* renamed from: h, reason: collision with root package name */
    public String f1357h;

    /* renamed from: i, reason: collision with root package name */
    public String f1358i;

    /* renamed from: j, reason: collision with root package name */
    public a0 f1359j;

    /* renamed from: k, reason: collision with root package name */
    public c0 f1360k;

    /* renamed from: l, reason: collision with root package name */
    public t f1361l;

    public final int d(String str) {
        List<u> list = this.f1356g;
        if (list == null) {
            return -1;
        }
        for (u uVar : list) {
            if (uVar.f2017b.equals(str)) {
                return uVar.f2016a;
            }
        }
        return -1;
    }

    public final boolean e() throws Resources.NotFoundException {
        boolean z2 = getSharedPreferences(SPUtils.FILE_NAME, 0).getInt("pref_person_send_status", 0) == 1;
        if (z2) {
            h(R.string.interphone_talk_send_status_toast);
        }
        return z2;
    }

    public final void f(Dialog dialog) {
        int i2 = getResources().getDisplayMetrics().widthPixels;
        Window window = dialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.y = 100;
            attributes.width = (int) (i2 * 0.9f);
            window.setAttributes(attributes);
            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
    }

    public final void g(String str, boolean z2) {
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.local_device_area_dialog, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.local_device_area_dialog_use);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.local_device_area_dialog_edit);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.local_device_area_dialog_delete);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.local_device_area_dialog_reset);
        textView.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
        textView4.setOnClickListener(this);
        if (z2) {
            textView.setVisibility(8);
            textView3.setVisibility(8);
            textView4.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView3.setVisibility(0);
            if (c.f1903d.containsKey(str)) {
                textView4.setVisibility(0);
            } else {
                textView4.setVisibility(8);
                t tVar = this.f1361l;
                tVar.f2013a.a(d(str)).observe(this, new b(3, textView));
            }
        }
        Dialog dialog = new Dialog(this);
        this.f1352c = dialog;
        dialog.setContentView(viewInflate);
        f(this.f1352c);
        this.f1352c.show();
    }

    public final void h(int i2) throws Resources.NotFoundException {
        Toast toast = this.f1354e;
        if (toast != null) {
            toast.cancel();
        }
        Toast toastMakeText = Toast.makeText(this, i2, 0);
        this.f1354e = toastMakeText;
        toastMakeText.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        int id = view.getId();
        if (id == R.id.back_button) {
            onBackPressed();
            return;
        }
        if (id == R.id.local_device_area_add) {
            return;
        }
        if (id == R.id.local_device_area_cancle) {
            Dialog dialog = this.f1351b;
            if (dialog != null) {
                dialog.dismiss();
                this.f1351b = null;
                return;
            }
            return;
        }
        final int i2 = 0;
        final int i3 = 1;
        if (id == R.id.local_device_area_dialog_delete) {
            Dialog dialog2 = this.f1352c;
            if (dialog2 != null) {
                dialog2.dismiss();
                this.f1352c = null;
            }
            if (e() || ActivityManager.isUserAMonkey()) {
                return;
            }
            String string = getString(R.string.interphone_delete_channel_dialog_info, c.a(this, this.f1358i));
            AlertDialog alertDialog = this.f1350a;
            if (alertDialog == null) {
                this.f1350a = new AlertDialog.Builder(this).setTitle(getString(R.string.interphone_delete_area_dialog_title)).setMessage(string).setNegativeButton(getString(android.R.string.cancel), new DialogInterface.OnClickListener(this) { // from class: p0.u

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ FragmentLocalDeviceAreaActivity f2454b;

                    {
                        this.f2454b = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        int i5 = i2;
                        FragmentLocalDeviceAreaActivity fragmentLocalDeviceAreaActivity = this.f2454b;
                        switch (i5) {
                            case 0:
                                fragmentLocalDeviceAreaActivity.f1350a.dismiss();
                                break;
                            default:
                                int i6 = FragmentLocalDeviceAreaActivity.f1349m;
                                if (!fragmentLocalDeviceAreaActivity.e()) {
                                    k0.c0 c0Var = fragmentLocalDeviceAreaActivity.f1360k;
                                    String str = fragmentLocalDeviceAreaActivity.f1358i;
                                    List list = fragmentLocalDeviceAreaActivity.f1356g;
                                    k0.u uVar = null;
                                    if (list != null) {
                                        Iterator it = list.iterator();
                                        while (true) {
                                            if (it.hasNext()) {
                                                k0.u uVar2 = (k0.u) it.next();
                                                if (uVar2.f2017b.equals(str)) {
                                                    uVar = uVar2;
                                                }
                                            }
                                        }
                                    }
                                    k0.s sVar = c0Var.f1971a;
                                    sVar.getClass();
                                    ChannelDatabase.f1237b.execute(new k0.b0(sVar, uVar, 1));
                                }
                                fragmentLocalDeviceAreaActivity.f1350a.dismiss();
                                break;
                        }
                    }
                }).setPositiveButton(getString(android.R.string.ok), new DialogInterface.OnClickListener(this) { // from class: p0.u

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ FragmentLocalDeviceAreaActivity f2454b;

                    {
                        this.f2454b = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        int i5 = i3;
                        FragmentLocalDeviceAreaActivity fragmentLocalDeviceAreaActivity = this.f2454b;
                        switch (i5) {
                            case 0:
                                fragmentLocalDeviceAreaActivity.f1350a.dismiss();
                                break;
                            default:
                                int i6 = FragmentLocalDeviceAreaActivity.f1349m;
                                if (!fragmentLocalDeviceAreaActivity.e()) {
                                    k0.c0 c0Var = fragmentLocalDeviceAreaActivity.f1360k;
                                    String str = fragmentLocalDeviceAreaActivity.f1358i;
                                    List list = fragmentLocalDeviceAreaActivity.f1356g;
                                    k0.u uVar = null;
                                    if (list != null) {
                                        Iterator it = list.iterator();
                                        while (true) {
                                            if (it.hasNext()) {
                                                k0.u uVar2 = (k0.u) it.next();
                                                if (uVar2.f2017b.equals(str)) {
                                                    uVar = uVar2;
                                                }
                                            }
                                        }
                                    }
                                    k0.s sVar = c0Var.f1971a;
                                    sVar.getClass();
                                    ChannelDatabase.f1237b.execute(new k0.b0(sVar, uVar, 1));
                                }
                                fragmentLocalDeviceAreaActivity.f1350a.dismiss();
                                break;
                        }
                    }
                }).create();
            } else {
                alertDialog.setMessage(string);
            }
            this.f1350a.show();
            return;
        }
        if (id == R.id.local_device_area_dialog_edit) {
            Dialog dialog3 = this.f1352c;
            if (dialog3 != null) {
                dialog3.dismiss();
                this.f1352c = null;
            }
            if (e() || ActivityManager.isUserAMonkey()) {
                return;
            }
            Intent intent = new Intent(this, (Class<?>) FragmentLocalDeviceAreaListActivity.class);
            intent.putExtra("title", c.a(getApplicationContext(), this.f1358i));
            intent.putExtra("selectedId", d(this.f1358i));
            startActivity(intent);
            return;
        }
        if (id == R.id.local_device_area_dialog_reset) {
            if (!ActivityManager.isUserAMonkey() && !e()) {
                new g(new h(this), i3, i2).execute(Integer.valueOf(d(this.f1358i)));
            }
            Dialog dialog4 = this.f1352c;
            if (dialog4 != null) {
                dialog4.dismiss();
                this.f1352c = null;
                return;
            }
            return;
        }
        if (id == R.id.local_device_area_dialog_use) {
            Dialog dialog5 = this.f1352c;
            if (dialog5 != null) {
                dialog5.dismiss();
                this.f1352c = null;
            }
            if (e() || ActivityManager.isUserAMonkey()) {
                return;
            }
            String str = this.f1358i;
            this.f1357h = str;
            Uri uri = c.f1900a;
            SharedPreferences.Editor editorEdit = getSharedPreferences(SPUtils.FILE_NAME, 0).edit();
            editorEdit.putString("pref_person_channel_area_selected_index", str);
            editorEdit.commit();
            this.f1359j.b(this.f1358i);
            int iD = d(this.f1358i);
            this.f1361l.f2015c.setValue(Integer.valueOf(iD));
            x0.g.o0(this, iD, "curr_country_id");
            this.f1361l.f2013a.a(iD).observe(this, new s(this, i3));
            return;
        }
        if (id == R.id.local_device_area_ok) {
            if (!e()) {
                EditText editText = this.f1353d;
                if (editText == null || editText.getText().toString().isEmpty()) {
                    h(R.string.fragment_local_setting_device_id_dialog_edit_toast);
                } else {
                    final String strTrim = Pattern.compile("[^a-zA-Z0-9\\u4e00-\\u9fa5]").matcher(this.f1353d.getText().toString()).replaceAll("").trim();
                    if (c.f1903d.values().stream().anyMatch(new Predicate() { // from class: p0.t
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            int i4 = FragmentLocalDeviceAreaActivity.f1349m;
                            return ((String) obj).equals(strTrim);
                        }
                    })) {
                        h(R.string.fragment_local_setting_device_id_dialog_edit_reset_toast);
                    } else {
                        String str2 = "extra_channel_area_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
                        if (d(str2) == -1) {
                            c0 c0Var = this.f1360k;
                            u uVar = new u(str2);
                            k0.s sVar = c0Var.f1971a;
                            sVar.getClass();
                            ChannelDatabase.f1237b.execute(new b0(sVar, uVar, i2));
                        } else {
                            h(R.string.fragment_local_setting_device_id_dialog_edit_reset_toast);
                        }
                    }
                }
            }
            Dialog dialog6 = this.f1351b;
            if (dialog6 != null) {
                dialog6.dismiss();
                this.f1351b = null;
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.c0, androidx.activity.h, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Dialog dialog = this.f1352c;
        if (dialog != null && dialog.isShowing()) {
            this.f1352c.dismiss();
            this.f1352c = null;
            g(this.f1358i, this.f1357h.equals(this.f1358i));
        }
        Dialog dialog2 = this.f1351b;
        if (dialog2 == null || !dialog2.isShowing()) {
            return;
        }
        this.f1351b.dismiss();
        this.f1351b = null;
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.local_device_area_add_dialog, (ViewGroup) null);
        Dialog dialog3 = new Dialog(this);
        this.f1351b = dialog3;
        dialog3.setContentView(viewInflate);
        f(this.f1351b);
        this.f1351b.show();
        Button button = (Button) viewInflate.findViewById(R.id.local_device_area_cancle);
        Button button2 = (Button) viewInflate.findViewById(R.id.local_device_area_ok);
        this.f1353d = (EditText) viewInflate.findViewById(R.id.local_device_area_edit);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        this.f1353d.addTextChangedListener(new v(this, 0));
    }

    @Override // androidx.fragment.app.c0, androidx.activity.h, h.l, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fragment_local_device_area_activity);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.local_device_area_list);
        this.f1355f = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager());
        this.f1355f.setHasFixedSize(true);
        ((Button) findViewById(R.id.local_device_area_add)).setOnClickListener(this);
        findViewById(R.id.back_button).setOnClickListener(this);
        Uri uri = c.f1900a;
        this.f1357h = getSharedPreferences(SPUtils.FILE_NAME, 0).getString("pref_person_channel_area_selected_index", c.f1904e);
        Log.d("FragmentLocalDeviceAreaActivity", "当前选中的区域ID: " + this.f1357h);
        this.f1360k = (c0) new ViewModelProvider(this).get(c0.class);
        this.f1361l = (t) new ViewModelProvider(this).get(t.class);
        a0 a0Var = new a0(a0.f1963c);
        this.f1359j = a0Var;
        this.f1355f.setAdapter(a0Var);
        this.f1360k.f1972b.observe(this, new s(this, 0));
        this.f1359j.f1964b = new a(this);
    }

    @Override // androidx.activity.h, android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
