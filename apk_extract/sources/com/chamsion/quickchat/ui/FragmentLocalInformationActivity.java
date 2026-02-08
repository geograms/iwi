package com.chamsion.quickchat.ui;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.chamsion.quickchat.R;
import k0.y;
import x0.g;

/* loaded from: classes.dex */
public class FragmentLocalInformationActivity extends AppCompatActivity {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f1373c = 0;

    /* renamed from: a, reason: collision with root package name */
    public TextView f1374a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f1375b;

    @Override // androidx.fragment.app.c0, androidx.activity.h, h.l, android.app.Activity
    public final void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(R.layout.fragment_local_information_activity);
        this.f1375b = (TextView) findViewById(R.id.local_information_software_version_value);
        this.f1374a = (TextView) findViewById(R.id.local_information_dmrfirmware_version_value);
        TextView textView = this.f1375b;
        try {
            str = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            str = "";
        }
        textView.setText(str);
        this.f1374a.setText((String) g.J(this, "version", ""));
        findViewById(R.id.back_button).setOnClickListener(new y(3, this));
    }
}
