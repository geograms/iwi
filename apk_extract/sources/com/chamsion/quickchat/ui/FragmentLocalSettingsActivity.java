package com.chamsion.quickchat.ui;

import a.b;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.chamsion.quickchat.R;
import com.chamsion.quickchat.service.DmrService;
import com.wonder.dmr.DmrManager;
import com.wonder.dmr.utils.SPUtils;
import j0.c;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import k0.a;
import k0.t;
import p0.a0;
import p0.m;
import p0.x;
import p0.y;
import r0.d;
import x0.g;

/* loaded from: classes.dex */
public class FragmentLocalSettingsActivity extends AppCompatActivity implements View.OnClickListener {
    public static final /* synthetic */ int M = 0;
    public ListView A;
    public a0 B;
    public a0 C;
    public Toast D;
    public d F;
    public t H;
    public RelativeLayout J;
    public Switch K;
    public Dialog L;

    /* renamed from: a, reason: collision with root package name */
    public TextView f1376a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f1377b;

    /* renamed from: c, reason: collision with root package name */
    public Switch f1378c;

    /* renamed from: d, reason: collision with root package name */
    public Switch f1379d;

    /* renamed from: e, reason: collision with root package name */
    public Switch f1380e;

    /* renamed from: f, reason: collision with root package name */
    public Switch f1381f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f1382g;

    /* renamed from: h, reason: collision with root package name */
    public RelativeLayout f1383h;

    /* renamed from: i, reason: collision with root package name */
    public RelativeLayout f1384i;

    /* renamed from: j, reason: collision with root package name */
    public int f1385j;

    /* renamed from: k, reason: collision with root package name */
    public int f1386k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1387l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1388m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f1389n;

    /* renamed from: o, reason: collision with root package name */
    public int f1390o;

    /* renamed from: p, reason: collision with root package name */
    public int f1391p;

    /* renamed from: q, reason: collision with root package name */
    public int f1392q;

    /* renamed from: r, reason: collision with root package name */
    public int[] f1393r;

    /* renamed from: s, reason: collision with root package name */
    public int[] f1394s;

    /* renamed from: v, reason: collision with root package name */
    public Dialog f1397v;

    /* renamed from: w, reason: collision with root package name */
    public Dialog f1398w;

    /* renamed from: x, reason: collision with root package name */
    public Dialog f1399x;

    /* renamed from: y, reason: collision with root package name */
    public EditText f1400y;

    /* renamed from: z, reason: collision with root package name */
    public ListView f1401z;

    /* renamed from: t, reason: collision with root package name */
    public final ArrayList f1395t = new ArrayList();

    /* renamed from: u, reason: collision with root package name */
    public final ArrayList f1396u = new ArrayList();
    public final Handler E = new Handler();
    public final boolean G = true;
    public final ArrayList I = new ArrayList();

    public final boolean d() {
        return getSharedPreferences(SPUtils.FILE_NAME, 0).getInt("pref_person_send_status", 0) == 1;
    }

    public final void e(boolean z2) {
        this.K.setChecked(z2);
        g.m0(this, "key_screen_off_support", Boolean.valueOf(z2));
        Intent intent = new Intent(this, (Class<?>) DmrService.class);
        intent.putExtra("action", "update_wake_lock");
        intent.putExtra("enabled", z2);
        startForegroundService(intent);
        if (!z2) {
            getContentResolver().delete(c.f1900a, null, null);
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.putNull("dummy");
        getContentResolver().insert(c.f1900a, contentValues);
    }

    public final void f() {
        if (this.K.isChecked()) {
            e(false);
            return;
        }
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.local_screen_off_setting_dialog, (ViewGroup) null);
        Dialog dialog = new Dialog(this);
        this.L = dialog;
        dialog.setContentView(viewInflate);
        Window window = this.L.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.y = 100;
            attributes.width = (int) (getResources().getDisplayMetrics().widthPixels * 0.9f);
            window.setAttributes(attributes);
            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
        this.L.show();
        viewInflate.findViewById(R.id.btn_support_screen_off_cancel).setOnClickListener(new x(this, 2));
        viewInflate.findViewById(R.id.btn_support_screen_off_confirm).setOnClickListener(new x(this, 3));
    }

    public final void g(boolean z2) {
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.local_device_kill_revive_walkie_talkies, (ViewGroup) null);
        Dialog dialog = new Dialog(this);
        this.f1397v = dialog;
        dialog.setContentView(viewInflate);
        Window window = this.f1397v.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.y = 100;
            attributes.width = (int) (getResources().getDisplayMetrics().widthPixels * 0.9f);
            window.setAttributes(attributes);
            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
        EditText editText = (EditText) viewInflate.findViewById(R.id.local_device_id_edit);
        this.f1400y = editText;
        editText.setInputType(2);
        Button button = (Button) viewInflate.findViewById(R.id.bt_local_device_kill_revive_cancel);
        button.setOnClickListener(this);
        button.setTag(Boolean.valueOf(z2));
        Button button2 = (Button) viewInflate.findViewById(R.id.bt_local_device_kill_revive_ok);
        button2.setTag(Boolean.valueOf(z2));
        button2.setOnClickListener(this);
        ((TextView) viewInflate.findViewById(R.id.title)).setText(z2 ? R.string.interphone_kill : R.string.interphone_revive);
        this.f1397v.show();
    }

    public final void h(int i2) {
        Toast toast = this.D;
        if (toast != null) {
            toast.cancel();
        }
        Toast toastMakeText = Toast.makeText(this, i2, 0);
        this.D = toastMakeText;
        toastMakeText.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (view.getId() == R.id.back_button) {
            onBackPressed();
            return;
        }
        int i2 = 1;
        if (d()) {
            int id = view.getId();
            if (id == R.id.local_device_id_cancle) {
                Dialog dialog = this.f1397v;
                if (dialog != null) {
                    dialog.dismiss();
                }
            } else if (id == R.id.local_setting_busy_no_sending_switch) {
                this.f1381f.setChecked(this.f1390o == 1);
            } else if (id == R.id.local_setting_ptt_end_tone_switch) {
                this.f1379d.setChecked(this.f1388m);
            } else if (id == R.id.local_setting_ptt_record_switch) {
                this.f1380e.setChecked(this.f1389n);
            } else if (id == R.id.local_setting_ptt_start_tone_switch) {
                this.f1378c.setChecked(this.f1387l);
            }
            h(R.string.interphone_talk_send_status_toast);
            return;
        }
        int id2 = view.getId();
        if (id2 == R.id.bt_local_device_kill_revive_cancel) {
            Dialog dialog2 = this.f1397v;
            if (dialog2 != null) {
                dialog2.dismiss();
                return;
            }
            return;
        }
        if (id2 == R.id.bt_local_device_kill_revive_ok) {
            EditText editText = this.f1400y;
            if (editText == null) {
                return;
            }
            String string = editText.getText().toString();
            if (string.isEmpty()) {
                h(R.string.fragment_local_setting_device_id_dialog_edit_toast);
                return;
            }
            try {
                int i3 = Integer.parseInt(string);
                if (i3 < 1 || i3 > 16776415) {
                    h(R.string.fragment_local_setting_device_id_person_number_edit_limit_toast);
                } else {
                    DmrManager.getInstance().setEnhancements(((Boolean) view.getTag()).booleanValue() ? 4 : 5, i3, new m());
                    Dialog dialog3 = this.f1397v;
                    if (dialog3 != null) {
                        dialog3.dismiss();
                    }
                }
                return;
            } catch (NumberFormatException unused) {
                h(R.string.fragment_local_setting_device_id_illegal_char_toast);
                return;
            }
        }
        if (id2 == R.id.local_device_id_cancle) {
            Dialog dialog4 = this.f1397v;
            if (dialog4 != null) {
                dialog4.dismiss();
                return;
            }
            return;
        }
        if (id2 == R.id.local_device_id_ok) {
            EditText editText2 = this.f1400y;
            if (editText2 == null) {
                return;
            }
            String string2 = editText2.getText().toString();
            if (string2.isEmpty()) {
                h(R.string.fragment_local_setting_device_id_dialog_edit_toast);
                return;
            }
            if (!string2.matches("[0-9]+")) {
                h(R.string.fragment_local_setting_device_id_illegal_char_toast);
                return;
            }
            try {
                int i4 = Integer.parseInt(string2);
                if (i4 >= 1 && i4 <= 16776415) {
                    this.f1376a.setText(string2);
                    g.o0(this, Integer.parseInt(string2), "pref_person_device_id");
                    g.m0(this, "local_id", Integer.valueOf(i4));
                    Iterator it = this.I.iterator();
                    while (it.hasNext()) {
                        a aVar = (a) it.next();
                        aVar.f1950n = i4;
                        this.H.a(aVar);
                        Log.d("FragmentLocalSettings", "setLocalId .... ");
                    }
                    Dialog dialog5 = this.f1397v;
                    if (dialog5 != null) {
                        dialog5.dismiss();
                        return;
                    }
                    return;
                }
                h(R.string.fragment_local_setting_device_id_person_number_edit_limit_toast);
                return;
            } catch (NumberFormatException unused2) {
                h(R.string.fragment_local_setting_device_id_illegal_char_toast);
                return;
            }
        }
        if (id2 == R.id.local_setting_busy_no_sending_switch) {
            g.m0(this, "launch_interr_enable", Boolean.valueOf(this.f1390o == 1));
            boolean zIsChecked = this.f1381f.isChecked();
            this.f1390o = zIsChecked ? 1 : 0;
            g.m0(this, "polite", Integer.valueOf(zIsChecked ? 1 : 0));
            d dVar = this.F;
            int i5 = this.f1390o;
            b bVar = dVar.f2522c;
            if (bVar != null) {
                Message messageObtainMessage = bVar.obtainMessage();
                messageObtainMessage.arg1 = 6;
                messageObtainMessage.arg2 = i5;
                messageObtainMessage.what = 256;
                dVar.f2522c.sendMessageDelayed(messageObtainMessage, 100L);
                return;
            }
            return;
        }
        if (id2 == R.id.local_setting_channel_mic_gain) {
            View viewInflate = LayoutInflater.from(this).inflate(R.layout.local_mic_gain_value_dialog, (ViewGroup) null);
            Dialog dialog6 = new Dialog(this);
            this.f1399x = dialog6;
            dialog6.setContentView(viewInflate);
            Window window = this.f1399x.getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.gravity = 80;
                attributes.y = 100;
                attributes.width = (int) (getResources().getDisplayMetrics().widthPixels * 0.9f);
                window.setAttributes(attributes);
                window.setBackgroundDrawableResource(android.R.color.transparent);
            }
            this.A = (ListView) viewInflate.findViewById(R.id.local_mic_gain_value_list);
            a0 a0Var = new a0(this, this, 1);
            this.C = a0Var;
            this.A.setAdapter((ListAdapter) a0Var);
            this.A.setDivider(null);
            this.A.setOnItemClickListener(new y(this, i2));
            this.f1399x.show();
            return;
        }
        if (id2 == R.id.local_setting_device_id) {
            View viewInflate2 = LayoutInflater.from(this).inflate(R.layout.local_device_id_dialog, (ViewGroup) null);
            Dialog dialog7 = new Dialog(this);
            this.f1397v = dialog7;
            dialog7.setContentView(viewInflate2);
            Window window2 = this.f1397v.getWindow();
            if (window2 != null) {
                WindowManager.LayoutParams attributes2 = window2.getAttributes();
                attributes2.gravity = 80;
                attributes2.y = 100;
                attributes2.width = (int) (getResources().getDisplayMetrics().widthPixels * 0.9f);
                window2.setAttributes(attributes2);
                window2.setBackgroundDrawableResource(android.R.color.transparent);
            }
            this.f1397v.show();
            EditText editText3 = (EditText) viewInflate2.findViewById(R.id.local_device_id_edit);
            this.f1400y = editText3;
            editText3.setText(getSharedPreferences(SPUtils.FILE_NAME, 0).getInt("pref_person_device_id", 1) + "");
            viewInflate2.findViewById(R.id.local_device_id_cancle).setOnClickListener(this);
            viewInflate2.findViewById(R.id.local_device_id_ok).setOnClickListener(this);
            return;
        }
        if (id2 == R.id.local_setting_kill_other_device) {
            g(true);
            return;
        }
        if (id2 == R.id.local_setting_limit_send_time) {
            View viewInflate3 = LayoutInflater.from(this).inflate(R.layout.local_limit_send_time_dialog, (ViewGroup) null);
            Dialog dialog8 = new Dialog(this);
            this.f1398w = dialog8;
            dialog8.setContentView(viewInflate3);
            Window window3 = this.f1398w.getWindow();
            if (window3 != null) {
                WindowManager.LayoutParams attributes3 = window3.getAttributes();
                attributes3.gravity = 80;
                attributes3.y = 100;
                attributes3.width = (int) (getResources().getDisplayMetrics().widthPixels * 0.9f);
                window3.setAttributes(attributes3);
                window3.setBackgroundDrawableResource(android.R.color.transparent);
            }
            this.f1401z = (ListView) viewInflate3.findViewById(R.id.local_limit_send_time_list);
            a0 a0Var2 = new a0(this, this, 0);
            this.B = a0Var2;
            this.f1401z.setAdapter((ListAdapter) a0Var2);
            this.f1401z.setDivider(null);
            this.f1401z.setOnItemClickListener(new y(this, z ? 1 : 0));
            this.f1398w.show();
            return;
        }
        if (id2 == R.id.local_setting_ptt_end_tone_switch) {
            boolean z2 = !this.f1388m;
            this.f1388m = z2;
            this.f1379d.setChecked(z2);
            g.n0(this, "pref_person_ptt_end_tone", this.f1388m);
            return;
        }
        if (id2 == R.id.local_setting_ptt_record_switch) {
            boolean z3 = !this.f1389n;
            this.f1389n = z3;
            this.f1380e.setChecked(z3);
            g.n0(this, "pref_person_ptt_record", this.f1389n);
            return;
        }
        if (id2 != R.id.local_setting_ptt_start_tone_switch) {
            if (id2 == R.id.local_setting_revive_other_device) {
                g(false);
            }
        } else {
            boolean z4 = !this.f1387l;
            this.f1387l = z4;
            this.f1378c.setChecked(z4);
            g.n0(this, "pref_person_ptt_start_tone", this.f1387l);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.c0, androidx.activity.h, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Dialog dialog = this.f1397v;
        if (dialog != null && dialog.isShowing()) {
            this.f1397v.dismiss();
            this.f1397v = null;
        }
        Dialog dialog2 = this.f1398w;
        if (dialog2 != null && dialog2.isShowing()) {
            this.f1398w.dismiss();
            this.f1398w = null;
        }
        Dialog dialog3 = this.f1399x;
        if (dialog3 == null || !dialog3.isShowing()) {
            return;
        }
        this.f1399x.dismiss();
        this.f1399x = null;
    }

    @Override // androidx.fragment.app.c0, androidx.activity.h, h.l, android.app.Activity
    public final void onCreate(Bundle bundle) throws Resources.NotFoundException {
        ArrayList arrayList;
        super.onCreate(bundle);
        setContentView(R.layout.fragment_local_settings_activity);
        View viewFindViewById = findViewById(R.id.local_setting_device_id);
        viewFindViewById.setOnClickListener(this);
        TextView textView = (TextView) findViewById(R.id.local_setting_device_id_value);
        this.f1376a = textView;
        int i2 = 0;
        textView.setText(String.valueOf(getSharedPreferences(SPUtils.FILE_NAME, 0).getInt("pref_person_device_id", 1)));
        View viewFindViewById2 = findViewById(R.id.local_setting_limit_send_time);
        viewFindViewById2.setOnClickListener(this);
        this.f1377b = (TextView) findViewById(R.id.local_setting_limit_send_time_value);
        this.f1385j = getSharedPreferences(SPUtils.FILE_NAME, 0).getInt("pref_person_limit_send_time", 30);
        Switch r8 = (Switch) findViewById(R.id.local_setting_ptt_start_tone_switch);
        this.f1378c = r8;
        r8.setOnClickListener(this);
        Switch r82 = (Switch) findViewById(R.id.local_setting_ptt_end_tone_switch);
        this.f1379d = r82;
        r82.setOnClickListener(this);
        Switch r83 = (Switch) findViewById(R.id.local_setting_ptt_record_switch);
        this.f1380e = r83;
        r83.setOnClickListener(this);
        Switch r84 = (Switch) findViewById(R.id.local_setting_busy_no_sending_switch);
        this.f1381f = r84;
        r84.setOnClickListener(this);
        this.J = (RelativeLayout) findViewById(R.id.ll_screen_off_settings);
        this.K = (Switch) findViewById(R.id.sw_screen_off_setting);
        this.J.setOnClickListener(new x(this, 0));
        this.K.setOnClickListener(new x(this, 1));
        findViewById(R.id.local_setting_channel_mic_gain).setOnClickListener(this);
        this.f1382g = (TextView) findViewById(R.id.fragment_local_setting_mic_gain_value);
        this.f1386k = getSharedPreferences(SPUtils.FILE_NAME, 0).getInt("pref_person_mic_gan_value", 0);
        this.f1383h = (RelativeLayout) findViewById(R.id.local_setting_kill_other_device);
        this.f1384i = (RelativeLayout) findViewById(R.id.local_setting_revive_other_device);
        this.f1383h.setOnClickListener(this);
        this.f1384i.setOnClickListener(this);
        findViewById(R.id.back_button).setOnClickListener(this);
        this.F = new d(this, this.E);
        String[] stringArray = getResources().getStringArray(R.array.local_settings_limit_send_time);
        this.f1393r = getResources().getIntArray(R.array.local_settings_limit_send_time_value);
        this.f1391p = 0;
        int i3 = 0;
        while (true) {
            int[] iArr = this.f1393r;
            int length = iArr.length;
            arrayList = this.f1395t;
            if (i3 >= length) {
                break;
            }
            if (iArr[i3] == this.f1385j) {
                this.f1391p = i3;
            }
            arrayList.add(stringArray[i3]);
            i3++;
        }
        boolean z2 = getSharedPreferences(SPUtils.FILE_NAME, 0).getBoolean("pref_person_ptt_start_tone", true);
        this.f1387l = z2;
        this.f1378c.setChecked(z2);
        boolean z3 = getSharedPreferences(SPUtils.FILE_NAME, 0).getBoolean("pref_person_ptt_end_tone", true);
        this.f1388m = z3;
        this.f1379d.setChecked(z3);
        boolean z4 = getSharedPreferences(SPUtils.FILE_NAME, 0).getBoolean("pref_person_ptt_record", false);
        this.f1389n = z4;
        this.f1380e.setChecked(z4);
        int i4 = getSharedPreferences(SPUtils.FILE_NAME, 0).getInt("polite", 1);
        this.f1390o = i4;
        this.f1381f.setChecked(i4 == 1);
        this.K.setChecked(getSharedPreferences(SPUtils.FILE_NAME, 0).getBoolean("key_screen_off_support", false));
        this.f1377b.setText((CharSequence) arrayList.get(this.f1391p));
        String[] stringArray2 = getResources().getStringArray(R.array.local_settings_mic_gain);
        this.f1394s = getResources().getIntArray(R.array.local_settings_mic_gain_value);
        while (true) {
            int[] iArr2 = this.f1394s;
            int length2 = iArr2.length;
            ArrayList arrayList2 = this.f1396u;
            if (i2 >= length2) {
                this.f1382g.setText((CharSequence) arrayList2.get(this.f1392q));
                return;
            }
            if (iArr2[i2] == this.f1386k) {
                this.f1392q = i2;
            }
            arrayList2.add(stringArray2[i2]);
            i2++;
        }
    }

    @Override // androidx.fragment.app.c0, android.app.Activity
    public final void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.c0, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (this.H == null) {
            this.H = (t) new ViewModelProvider(this).get(t.class);
        }
        this.H.f2013a.a(getSharedPreferences(SPUtils.FILE_NAME, 0).getInt("curr_country_id", 1)).observe(this, new p0.b(5, this));
    }
}
