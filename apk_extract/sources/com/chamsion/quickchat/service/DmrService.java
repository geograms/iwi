package com.chamsion.quickchat.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.activity.b;
import androidx.constraintlayout.solver.widgets.Optimizer;
import com.chamsion.quickchat.App;
import com.chamsion.quickchat.R;
import com.wonder.dmr.DmrManager;
import h.n;
import java.util.ArrayList;
import java.util.Iterator;
import o0.a;
import x0.g;

/* loaded from: classes.dex */
public class DmrService extends Service {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f1256d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final String f1257a = DmrService.class.getName();

    /* renamed from: b, reason: collision with root package name */
    public final a f1258b = new a(this);

    /* renamed from: c, reason: collision with root package name */
    public PowerManager.WakeLock f1259c;

    public final void a() {
        try {
            PowerManager.WakeLock wakeLock = this.f1259c;
            if (wakeLock != null && wakeLock.isHeld()) {
                Log.d(this.f1257a, "WakeLock already acquired");
                return;
            }
            PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(536870913, "MultiTypeService:WakeLock");
            this.f1259c = wakeLockNewWakeLock;
            wakeLockNewWakeLock.acquire();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void b() {
        synchronized (DmrService.class) {
            stopForeground(true);
            d();
            DmrManager.getInstance().closeSerial();
            DmrManager.getInstance().resetData();
            App.f1234c = false;
        }
        c();
    }

    public final void c() {
        try {
            PowerManager.WakeLock wakeLock = this.f1259c;
            if (wakeLock == null || !wakeLock.isHeld()) {
                return;
            }
            this.f1259c.release();
            this.f1259c = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void d() {
        Log.d(this.f1257a, "setDmrPowerOff, " + Build.MODEL);
        DmrManager.getInstance().powerCtrl("/sys/devices/platform/intercom/intercom_power_control", 0);
        DmrManager.getInstance().pwdCtrl("/sys/devices/platform/intercom/intercom_pwd_control", 0);
        DmrManager.getInstance().pttCtrl("/sys/devices/platform/intercom/intercom_ptt_control", 0);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        Log.d(this.f1257a, "onBind...");
        return this.f1258b;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        Log.d(this.f1257a, "onCreate...");
        if (((Boolean) g.J(this, "key_screen_off_support", Boolean.FALSE)).booleanValue()) {
            a();
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        Log.d(this.f1257a, "onDestroy...");
        b();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i3) throws Resources.NotFoundException {
        PendingIntent activity;
        Bundle bundle;
        Log.d(this.f1257a, "onStartCommand...");
        if (intent == null) {
            c();
        } else if ("update_wake_lock".equals(intent.getStringExtra("action"))) {
            if (intent.getBooleanExtra("enabled", false)) {
                a();
            } else {
                c();
            }
        }
        DmrManager.getInstance().setDebug(true);
        synchronized (DmrService.class) {
            d();
            new Handler().postDelayed(new b(5, this), 200L);
        }
        Context applicationContext = getApplicationContext();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Notification notification = new Notification();
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        ArrayList arrayList4 = new ArrayList();
        notification.flags |= 16;
        String string = getResources().getString(R.string.app_name);
        CharSequence charSequenceSubSequence = string;
        if (string != null) {
            int length = string.length();
            charSequenceSubSequence = string;
            if (length > 5120) {
                charSequenceSubSequence = string.subSequence(0, 5120);
            }
        }
        notification.icon = R.drawable.ic_mine_normal;
        notification.when = System.currentTimeMillis();
        int i4 = notification.flags;
        notification.defaults = -1;
        notification.flags = i4 | 3;
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        String str = "channelId" + System.currentTimeMillis();
        notificationManager.createNotificationChannel(new NotificationChannel(str, getResources().getString(R.string.app_name), 4));
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.setFlags(270532608);
            activity = PendingIntent.getActivity(this, 0, launchIntentForPackage, 201326592);
        } else {
            activity = null;
        }
        new ArrayList();
        Bundle bundle2 = new Bundle();
        Notification.Builder builder = new Notification.Builder(applicationContext, str);
        builder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequenceSubSequence).setContentText(null).setContentInfo(null).setContentIntent(activity).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & Optimizer.OPTIMIZATION_GRAPH_WRAP) != 0).setLargeIcon((Bitmap) null).setNumber(0).setProgress(0, 0, false);
        builder.setSubText(null).setUsesChronometer(false).setPriority(0);
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            a.a.j(it.next());
            throw null;
        }
        builder.setShowWhen(true);
        builder.setLocalOnly(false).setGroup(null).setGroupSummary(false).setSortKey(null);
        builder.setCategory(null).setColor(0).setVisibility(0).setPublicVersion(null).setSound(notification.sound, notification.audioAttributes);
        if (!arrayList4.isEmpty()) {
            Iterator it2 = arrayList4.iterator();
            while (it2.hasNext()) {
                builder.addPerson((String) it2.next());
            }
        }
        if (arrayList3.size() > 0) {
            bundle = new Bundle();
            Bundle bundle3 = bundle.getBundle("android.car.EXTENSIONS");
            if (bundle3 == null) {
                bundle3 = new Bundle();
            }
            Bundle bundle4 = new Bundle(bundle3);
            Bundle bundle5 = new Bundle();
            if (arrayList3.size() > 0) {
                Integer.toString(0);
                a.a.j(arrayList3.get(0));
                Object obj = n.f1836a;
                new Bundle();
                throw null;
            }
            bundle3.putBundle("invisible_actions", bundle5);
            bundle4.putBundle("invisible_actions", bundle5);
            bundle.putBundle("android.car.EXTENSIONS", bundle3);
            bundle2.putBundle("android.car.EXTENSIONS", bundle4);
        } else {
            bundle = null;
        }
        builder.setExtras(bundle).setRemoteInputHistory(null);
        builder.setBadgeIconType(0).setSettingsText(null).setShortcutId(null).setTimeoutAfter(0L).setGroupAlertBehavior(0);
        if (!TextUtils.isEmpty(str)) {
            builder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
        Iterator it3 = arrayList2.iterator();
        if (it3.hasNext()) {
            a.a.j(it3.next());
            throw null;
        }
        builder.setAllowSystemGeneratedContextualActions(true);
        builder.setBubbleMetadata(null);
        startForeground(222, builder.build(), 144);
        return 2;
    }

    @Override // android.app.Service
    public final void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        b();
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        Log.d(this.f1257a, "onUnbind...");
        DmrManager.getInstance().resetData();
        b();
        return super.onUnbind(intent);
    }
}
