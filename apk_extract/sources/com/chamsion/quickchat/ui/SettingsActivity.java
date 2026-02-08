package com.chamsion.quickchat.ui;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.lifecycle.ViewModelProvider;
import com.chamsion.quickchat.R;
import com.wonder.dmr.DmrManager;
import j0.c;
import java.util.ArrayList;
import k0.t;
import p0.a1;
import p0.b1;
import p0.c1;
import p0.e;
import p0.g;
import p0.s0;
import p0.z0;
import r0.d;

/* loaded from: classes.dex */
public class SettingsActivity extends AppCompatActivity {
    public static final /* synthetic */ int D = 0;

    /* renamed from: b, reason: collision with root package name */
    public RadioGroup f1453b;

    /* renamed from: c, reason: collision with root package name */
    public Switch f1454c;

    /* renamed from: d, reason: collision with root package name */
    public Switch f1455d;

    /* renamed from: e, reason: collision with root package name */
    public Switch f1456e;

    /* renamed from: f, reason: collision with root package name */
    public Switch f1457f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f1458g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f1459h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f1460i;

    /* renamed from: j, reason: collision with root package name */
    public TextView f1461j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f1462k;

    /* renamed from: l, reason: collision with root package name */
    public ImageView f1463l;

    /* renamed from: m, reason: collision with root package name */
    public SeekBar f1464m;

    /* renamed from: n, reason: collision with root package name */
    public SeekBar f1465n;

    /* renamed from: o, reason: collision with root package name */
    public AppCompatSpinner f1466o;

    /* renamed from: p, reason: collision with root package name */
    public AppCompatSpinner f1467p;

    /* renamed from: r, reason: collision with root package name */
    public SettingsActivity f1469r;

    /* renamed from: s, reason: collision with root package name */
    public c1 f1470s;

    /* renamed from: v, reason: collision with root package name */
    public t f1473v;

    /* renamed from: a, reason: collision with root package name */
    public final String f1452a = SettingsActivity.class.getName();

    /* renamed from: q, reason: collision with root package name */
    public d f1468q = null;

    /* renamed from: t, reason: collision with root package name */
    public boolean f1471t = true;

    /* renamed from: u, reason: collision with root package name */
    public boolean f1472u = true;

    /* renamed from: w, reason: collision with root package name */
    public final ArrayList f1474w = new ArrayList();

    /* renamed from: x, reason: collision with root package name */
    public final z0 f1475x = new z0(this, 0);

    /* renamed from: y, reason: collision with root package name */
    public final z0 f1476y = new z0(this, 1);

    /* renamed from: z, reason: collision with root package name */
    public final a1 f1477z = new a1(this);
    public final b1 A = new b1(this);
    public final g B = new g(this, 4);
    public final s0 C = new s0(this, 2);

    @Override // androidx.fragment.app.c0, androidx.activity.h, android.app.Activity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    @Override // androidx.activity.h, android.app.Activity
    public final void onBackPressed() {
        super.onBackPressed();
        setResult(-1, new Intent());
        finish();
    }

    @Override // androidx.fragment.app.c0, androidx.activity.h, h.l, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_settings);
        this.f1469r = this;
        ((TextView) findViewById(R.id.tv_title)).setText(getResources().getString(R.string.rb_settings));
        ImageView imageView = (ImageView) findViewById(R.id.iv_close);
        this.f1463l = imageView;
        imageView.setVisibility(0);
        ImageView imageView2 = this.f1463l;
        g gVar = this.B;
        imageView2.setOnClickListener(gVar);
        this.f1454c = (Switch) findViewById(R.id.sw_save_power);
        this.f1458g = (TextView) findViewById(R.id.tv_local_id);
        this.f1455d = (Switch) findViewById(R.id.sw_switch_channel_voice);
        this.f1456e = (Switch) findViewById(R.id.sw_switch_polite);
        Switch r8 = this.f1454c;
        b1 b1Var = this.A;
        r8.setOnCheckedChangeListener(b1Var);
        this.f1455d.setOnCheckedChangeListener(b1Var);
        this.f1456e.setOnCheckedChangeListener(b1Var);
        AppCompatSpinner appCompatSpinner = (AppCompatSpinner) findViewById(R.id.asp_trans_interr);
        this.f1466o = appCompatSpinner;
        appCompatSpinner.setOnItemSelectedListener(this.f1475x);
        AppCompatSpinner appCompatSpinner2 = (AppCompatSpinner) findViewById(R.id.asp_msg_encode);
        this.f1467p = appCompatSpinner2;
        appCompatSpinner2.setOnItemSelectedListener(this.f1476y);
        this.f1461j = (TextView) findViewById(R.id.tv_app_version);
        this.f1462k = (TextView) findViewById(R.id.tv_dmr_version);
        ((ImageView) findViewById(R.id.iv_edit)).setOnClickListener(gVar);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rg_power);
        this.f1453b = radioGroup;
        radioGroup.setOnCheckedChangeListener(this.C);
        this.f1460i = (TextView) findViewById(R.id.tv_volume);
        SeekBar seekBar = (SeekBar) findViewById(R.id.sb_volume);
        this.f1464m = seekBar;
        a1 a1Var = this.f1477z;
        seekBar.setOnSeekBarChangeListener(a1Var);
        this.f1459h = (TextView) findViewById(R.id.tv_mic);
        SeekBar seekBar2 = (SeekBar) findViewById(R.id.sb_mic);
        this.f1465n = seekBar2;
        seekBar2.setOnSeekBarChangeListener(a1Var);
        ((RelativeLayout) findViewById(R.id.rl_udpate_dmr)).setOnClickListener(gVar);
        ((RelativeLayout) findViewById(R.id.rl_enhance_dmr)).setOnClickListener(gVar);
        Switch r82 = (Switch) findViewById(R.id.sw_switch_interrupt);
        this.f1457f = r82;
        r82.setOnCheckedChangeListener(b1Var);
        Log.d(this.f1452a, "init .... ");
        c1 c1Var = new c1(this, this);
        this.f1470s = c1Var;
        this.f1468q = new d(this.f1469r, c1Var);
        if (((Integer) x0.g.J(this.f1469r, "power", 1)).intValue() == 1) {
            this.f1453b.check(R.id.rb_hight);
        } else {
            this.f1453b.check(R.id.rb_low);
        }
        this.f1454c.setChecked(((Integer) x0.g.J(this.f1469r, "save_power", 2)).intValue() == 1);
        int iIntValue = ((Integer) x0.g.J(this.f1469r, "local_id", 1)).intValue();
        this.f1458g.setText("本机ID：" + iIntValue);
        this.f1455d.setChecked(((Boolean) x0.g.J(this.f1469r, "voice", c.f1902c)).booleanValue());
        int iIntValue2 = ((Integer) x0.g.J(this.f1469r, "mic", 0)).intValue();
        TextView textView = this.f1459h;
        StringBuilder sb = new StringBuilder();
        sb.append(iIntValue2);
        String str = "";
        sb.append("");
        textView.setText(sb.toString());
        this.f1465n.setProgress(iIntValue2);
        int iIntValue3 = ((Integer) x0.g.J(this.f1469r, "volume", 8)).intValue();
        this.f1460i.setText(iIntValue3 + "");
        this.f1464m.setProgress(iIntValue3);
        this.f1462k.setText((String) x0.g.J(this.f1469r, "version", ""));
        TextView textView2 = this.f1461j;
        try {
            str = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        textView2.setText(str);
        this.f1466o.setSelection(((Integer) x0.g.J(this.f1469r, "trans_interr", 2)).intValue() - 1);
        if (((Integer) x0.g.J(this.f1469r, "polite", 1)).intValue() == 1) {
            this.f1456e.setChecked(true);
        } else {
            this.f1456e.setChecked(false);
        }
        this.f1457f.setChecked(((Boolean) x0.g.J(this.f1469r, "launch_interr_enable", Boolean.FALSE)).booleanValue());
        int iIntValue4 = ((Integer) x0.g.J(this.f1469r, "msg_encode", 0)).intValue();
        this.f1467p.setSelection(iIntValue4);
        DmrManager.getInstance().setMessageEncode(getResources().getStringArray(R.array.msg_encode)[iIntValue4]);
    }

    @Override // androidx.fragment.app.c0, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (this.f1473v == null) {
            this.f1473v = (t) new ViewModelProvider(this).get(t.class);
        }
        this.f1473v.f2014b.observe(this, new e(this, 3));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.c0, android.app.Activity
    public final void onStop() {
        super.onStop();
        c1 c1Var = this.f1470s;
        if (c1Var != null) {
            c1Var.removeCallbacksAndMessages(this);
        }
    }
}
