package com.chamsion.quickchat.ui;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.chamsion.quickchat.R;
import p0.g;
import p0.s0;
import p0.v;

/* loaded from: classes.dex */
public class ManagerActivity extends AppCompatActivity {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f1429h = 0;

    /* renamed from: a, reason: collision with root package name */
    public ImageView f1430a;

    /* renamed from: b, reason: collision with root package name */
    public EditText f1431b;

    /* renamed from: c, reason: collision with root package name */
    public ManagerActivity f1432c;

    /* renamed from: d, reason: collision with root package name */
    public final g f1433d = new g(this, 3);

    /* renamed from: e, reason: collision with root package name */
    public int f1434e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f1435f = 0;

    /* renamed from: g, reason: collision with root package name */
    public final s0 f1436g = new s0(this, 1);

    @Override // androidx.fragment.app.c0, androidx.activity.h, h.l, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_manager);
        this.f1432c = this;
        ((TextView) findViewById(R.id.tv_title)).setText(getResources().getString(R.string.manager_enhance));
        ImageView imageView = (ImageView) findViewById(R.id.iv_close);
        this.f1430a = imageView;
        imageView.setVisibility(0);
        ImageView imageView2 = this.f1430a;
        g gVar = this.f1433d;
        imageView2.setOnClickListener(gVar);
        ((RadioGroup) findViewById(R.id.rg_enhance)).setOnCheckedChangeListener(this.f1436g);
        this.f1431b = (EditText) findViewById(R.id.et_id);
        ((TextView) findViewById(R.id.btn_send)).setOnClickListener(gVar);
        this.f1431b.addTextChangedListener(new v(this, 1));
    }

    @Override // androidx.fragment.app.c0, android.app.Activity
    public final void onResume() {
        super.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.c0, android.app.Activity
    public final void onStop() {
        super.onStop();
    }
}
