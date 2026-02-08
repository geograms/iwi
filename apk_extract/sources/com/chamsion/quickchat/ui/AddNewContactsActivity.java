package com.chamsion.quickchat.ui;

import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.b;
import androidx.activity.d;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.lifecycle.ViewModelProvider;
import com.chamsion.quickchat.R;
import com.chamsion.quickchat.db.contacts.ContactDatabase;
import com.chamsion.quickchat.ui.AddNewContactsActivity;
import java.io.File;
import m0.a;
import m0.m;
import m0.n;
import p0.j;
import p0.k;
import p0.l;
import s0.e;
import t0.c;

/* loaded from: classes.dex */
public class AddNewContactsActivity extends AppCompatActivity implements View.OnClickListener {

    /* renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f1312w = 0;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f1314b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f1315c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f1316d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f1317e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f1318f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f1319g;

    /* renamed from: j, reason: collision with root package name */
    public a f1322j;

    /* renamed from: k, reason: collision with root package name */
    public EditText f1323k;

    /* renamed from: l, reason: collision with root package name */
    public EditText f1324l;

    /* renamed from: o, reason: collision with root package name */
    public AddNewContactsActivity f1327o;

    /* renamed from: p, reason: collision with root package name */
    public n f1328p;

    /* renamed from: q, reason: collision with root package name */
    public Dialog f1329q;

    /* renamed from: r, reason: collision with root package name */
    public Uri f1330r;

    /* renamed from: t, reason: collision with root package name */
    public Uri f1332t;

    /* renamed from: a, reason: collision with root package name */
    public final String f1313a = AddNewContactsActivity.class.getName();

    /* renamed from: h, reason: collision with root package name */
    public int f1320h = -1;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1321i = false;

    /* renamed from: m, reason: collision with root package name */
    public String f1325m = "";

    /* renamed from: n, reason: collision with root package name */
    public int f1326n = 0;

    /* renamed from: s, reason: collision with root package name */
    public final int f1331s = 720;

    /* renamed from: u, reason: collision with root package name */
    public Bitmap f1333u = null;

    /* renamed from: v, reason: collision with root package name */
    public String f1334v = "";

    public static Uri d(Context context, String str) {
        File cacheDir = context.getCacheDir();
        cacheDir.mkdirs();
        return FileProvider.b(context, new File(cacheDir, str));
    }

    public final void e() {
        this.f1332t = d(this, "CropEditUserPhoto.jpg");
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(this.f1330r, "image/*");
        Uri uri = this.f1332t;
        intent.putExtra("output", uri);
        intent.addFlags(3);
        intent.setClipData(ClipData.newRawUri("output", uri));
        intent.putExtra("crop", "true");
        intent.putExtra("scale", true);
        intent.putExtra("scaleUpIfNeeded", true);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        int i2 = this.f1331s;
        intent.putExtra("outputX", i2);
        intent.putExtra("outputY", i2);
        intent.resolveActivity(getPackageManager());
        startActivityForResult(intent, 1003);
    }

    public final void f() {
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.interphone_camera_dialog, (ViewGroup) null);
        Dialog dialog = new Dialog(this);
        this.f1329q = dialog;
        dialog.setContentView(viewInflate);
        Dialog dialog2 = this.f1329q;
        int i2 = getResources().getDisplayMetrics().widthPixels;
        Window window = dialog2.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        attributes.y = 60;
        attributes.width = (int) (i2 * 0.9f);
        window.setAttributes(attributes);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        this.f1329q.show();
        viewInflate.findViewById(R.id.interphone_camera_take_picture).setOnClickListener(this);
        viewInflate.findViewById(R.id.interphone_camera_seleted_picture).setOnClickListener(this);
    }

    @Override // androidx.fragment.app.c0, androidx.activity.h, android.app.Activity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        Uri data = (intent == null || intent.getData() == null) ? this.f1330r : intent.getData();
        String str = this.f1313a;
        if (data == null) {
            Log.e(str, "Invalid pictureUri null");
        }
        if (!"content".equals(data.getScheme())) {
            Log.e(str, "Invalid pictureUri scheme: " + data.getScheme());
            return;
        }
        int i4 = 0;
        switch (i2) {
            case 1001:
            case 1002:
                if (!this.f1330r.equals(data)) {
                    new k(this, data, i4).execute(new Void[0]);
                    break;
                } else {
                    e();
                    break;
                }
            case 1003:
                new l(this, data, i4).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        if (view.getId() != R.id.iv_done) {
            if (view.getId() == R.id.iv_close) {
                finish();
                return;
            }
            if (view.getId() == R.id.ib_add_contact_camera) {
                f();
                return;
            }
            if (view.getId() == R.id.interphone_camera_seleted_picture) {
                Dialog dialog2 = this.f1329q;
                if (dialog2 != null) {
                    dialog2.dismiss();
                    this.f1330r = d(this, "TakeEditUserPhoto2.jpg");
                    Intent intent = new Intent("android.intent.action.GET_CONTENT", (Uri) null);
                    intent.setType("image/*");
                    Uri uri = this.f1330r;
                    intent.putExtra("output", uri);
                    intent.addFlags(3);
                    intent.setClipData(ClipData.newRawUri("output", uri));
                    startActivityForResult(intent, 1001);
                    return;
                }
                return;
            }
            if (view.getId() != R.id.interphone_camera_take_picture || (dialog = this.f1329q) == null) {
                return;
            }
            dialog.dismiss();
            this.f1330r = d(this, "TakeEditUserPhoto2.jpg");
            Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
            Uri uri2 = this.f1330r;
            intent2.putExtra("output", uri2);
            intent2.addFlags(3);
            intent2.setClipData(ClipData.newRawUri("output", uri2));
            intent2.addFlags(3);
            startActivityForResult(intent2, 1002);
            return;
        }
        this.f1334v = "";
        String strTrim = this.f1323k.getText().toString().trim();
        this.f1325m = strTrim;
        if (TextUtils.isEmpty(strTrim)) {
            this.f1323k.setError(this.f1327o.getString(R.string.cannot_be_empty));
        }
        int i2 = this.f1326n;
        if (i2 < 1 || i2 > 16776415) {
            this.f1324l.setError(this.f1327o.getString(R.string.out_range));
        }
        String str = "check, mEtNumber = " + ((Object) this.f1324l.getError());
        String str2 = this.f1313a;
        Log.d(str2, str);
        Log.d(str2, "check, mEtName = " + ((Object) this.f1323k.getError()));
        this.f1334v = "" + ((Object) this.f1323k.getError()) + ((Object) this.f1324l.getError());
        if (this.f1323k.getError() == null && this.f1324l.getError() == null) {
            Log.d(str2, "check, A ");
        } else {
            if (TextUtils.isEmpty(this.f1334v) && !this.f1334v.equals(null)) {
                return;
            }
            Log.d(str2, "check, B ");
            if (!TextUtils.isEmpty(this.f1334v)) {
                return;
            }
        }
        int i3 = 0;
        this.f1315c.setEnabled(false);
        if (!this.f1321i) {
            int i4 = this.f1320h;
            Log.d(str2, "saveToDatabase, type = " + i4);
            e.c(this.f1327o, getString(R.string.wait), getString(R.string.loading));
            int i5 = 2;
            if (i4 == 0) {
                Log.d(str2, "savePerson");
                a aVar = new a();
                aVar.f2091b = 0;
                aVar.f2092c = this.f1325m;
                aVar.f2094e = "";
                aVar.f2093d = this.f1326n;
                aVar.a(this.f1333u);
                m mVar = this.f1328p.f2132a;
                mVar.getClass();
                ContactDatabase.f1247b.execute(new m0.l(mVar, aVar, i5));
            } else if (i4 == 1) {
                Log.d(str2, "saveGroup");
                a aVar2 = new a();
                aVar2.f2091b = 1;
                aVar2.f2092c = this.f1325m;
                aVar2.f2094e = "";
                aVar2.f2093d = this.f1326n;
                aVar2.a(this.f1333u);
                m mVar2 = this.f1328p.f2132a;
                mVar2.getClass();
                ContactDatabase.f1247b.execute(new m0.l(mVar2, aVar2, i5));
            }
            new Handler().postDelayed(new b(6, this), 1000L);
            return;
        }
        int i6 = this.f1320h;
        Log.d(str2, "saveToDatabase, type = " + i6);
        e.c(this.f1327o, getString(R.string.wait), getString(R.string.loading));
        if (i6 == 0) {
            Log.d(str2, "savePerson");
            a aVar3 = new a();
            aVar3.f2090a = this.f1322j.f2090a;
            aVar3.f2091b = 0;
            aVar3.f2092c = this.f1325m;
            aVar3.f2094e = "";
            aVar3.f2093d = this.f1326n;
            aVar3.a(this.f1333u);
            m mVar3 = this.f1328p.f2132a;
            mVar3.getClass();
            ContactDatabase.f1247b.execute(new m0.l(mVar3, aVar3, i3));
        } else if (i6 == 1) {
            Log.d(str2, "saveGroup");
            a aVar4 = new a();
            aVar4.f2090a = this.f1322j.f2090a;
            aVar4.f2091b = 1;
            aVar4.f2092c = this.f1325m;
            aVar4.f2094e = "";
            aVar4.f2093d = this.f1326n;
            aVar4.a(this.f1333u);
            m mVar4 = this.f1328p.f2132a;
            mVar4.getClass();
            ContactDatabase.f1247b.execute(new m0.l(mVar4, aVar4, i3));
        }
        new Handler().postDelayed(new d(5, this), 1000L);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.c0, androidx.activity.h, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Dialog dialog = this.f1329q;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.f1329q.dismiss();
        this.f1329q = null;
        f();
    }

    @Override // androidx.fragment.app.c0, androidx.activity.h, h.l, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_add_new_contacts);
        this.f1327o = this;
        Intent intent = getIntent();
        final int i2 = 0;
        this.f1320h = intent.getIntExtra("type_contacts", 0);
        String stringExtra = intent.getStringExtra("what");
        findViewById(R.id.tv_title).setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.tv_center_title);
        this.f1317e = textView;
        textView.setVisibility(0);
        ImageView imageView = (ImageView) findViewById(R.id.iv_close);
        this.f1314b = imageView;
        imageView.setVisibility(0);
        ImageView imageView2 = (ImageView) findViewById(R.id.iv_done);
        this.f1315c = imageView2;
        imageView2.setVisibility(0);
        this.f1316d = (ImageView) findViewById(R.id.iv_user_logo);
        this.f1318f = (TextView) findViewById(R.id.tv_type_name);
        this.f1319g = (TextView) findViewById(R.id.tv_type_number);
        this.f1323k = (EditText) findViewById(R.id.et_contacts_name);
        this.f1324l = (EditText) findViewById(R.id.et_contacts_number);
        int i3 = this.f1320h;
        final int i4 = 1;
        if (i3 == 0) {
            this.f1318f.setText(R.string.person_call_name);
            this.f1319g.setText(R.string.person_call_number);
        } else if (i3 == 1) {
            this.f1318f.setText(R.string.team_call_name);
            this.f1319g.setText(R.string.team_call_num);
        }
        if (stringExtra.equals("modify")) {
            this.f1317e.setText(this.f1320h == 0 ? getResources().getString(R.string.modify_contacts) : getResources().getString(R.string.modify_group));
            a aVar = (a) intent.getSerializableExtra("contacts");
            this.f1322j = aVar;
            this.f1321i = true;
            this.f1323k.setText(aVar.f2092c);
            this.f1324l.setText(this.f1322j.f2093d + "");
            this.f1326n = Integer.valueOf(this.f1324l.getText().toString()).intValue();
            a aVar2 = this.f1322j;
            AddNewContactsActivity addNewContactsActivity = this.f1327o;
            byte[] bArr = aVar2.f2097h;
            c cVarA = bArr != null ? c.a(addNewContactsActivity, BitmapFactory.decodeByteArray(bArr, 0, bArr.length)) : null;
            if (cVarA == null) {
                this.f1316d.setImageResource(R.drawable.ic_person_circle);
            } else {
                this.f1316d.setImageDrawable(cVarA);
            }
        } else if (stringExtra.equals("add")) {
            this.f1317e.setText(this.f1320h == 0 ? getResources().getString(R.string.add_new_contacts) : getResources().getString(R.string.add_new_group));
        }
        findViewById(R.id.ib_add_contact_camera).setOnClickListener(this);
        this.f1314b.setOnClickListener(new View.OnClickListener(this) { // from class: p0.i

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AddNewContactsActivity f2348b;

            {
                this.f2348b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i5 = i2;
                this.f2348b.onClick(view);
            }
        });
        this.f1315c.setOnClickListener(new View.OnClickListener(this) { // from class: p0.i

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AddNewContactsActivity f2348b;

            {
                this.f2348b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i5 = i4;
                this.f2348b.onClick(view);
            }
        });
        if (this.f1328p == null) {
            this.f1328p = (n) new ViewModelProvider(this).get(n.class);
        }
        this.f1324l.addTextChangedListener(new j(this, 0));
        this.f1323k.addTextChangedListener(new j(this, 1));
    }
}
