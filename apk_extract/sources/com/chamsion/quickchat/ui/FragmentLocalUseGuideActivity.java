package com.chamsion.quickchat.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.chamsion.quickchat.R;
import k0.y;

/* loaded from: classes.dex */
public class FragmentLocalUseGuideActivity extends AppCompatActivity {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f1402a = 0;

    @Override // androidx.fragment.app.c0, androidx.activity.h, h.l, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fragment_user_guide_activity);
        findViewById(R.id.back_button).setOnClickListener(new y(4, this));
    }
}
