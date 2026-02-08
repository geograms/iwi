package com.chamsion.quickchat;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.util.Log;
import com.wonder.dmr.utils.SPUtils;
import k0.g;
import k0.h;
import p0.q0;
import s0.f;

/* loaded from: classes.dex */
public class App extends Application {

    /* renamed from: b, reason: collision with root package name */
    public static Context f1233b = null;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f1234c = false;

    /* renamed from: a, reason: collision with root package name */
    public final q0 f1235a = new q0(this, 3);

    @Override // android.app.Application
    public final void onCreate() {
        super.onCreate();
        Configuration configuration = getResources().getConfiguration();
        configuration.fontScale = 1.0f;
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
        Context applicationContext = getApplicationContext();
        f1233b = applicationContext;
        int i2 = 0;
        if (applicationContext.getSharedPreferences(SPUtils.FILE_NAME, 0).getBoolean("first_launch", true)) {
            new g(new h(this), i2, i2).execute(new Void[0]);
            x0.g.n0(f1233b, "first_launch", false);
        }
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(this.f1235a, intentFilter);
    }

    @Override // android.app.Application
    public final void onTerminate() throws IllegalStateException {
        super.onTerminate();
        Log.d("App", "onTerminate 99: ");
        f.a().d();
    }
}
