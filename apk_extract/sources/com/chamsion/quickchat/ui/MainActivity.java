package com.chamsion.quickchat.ui;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.lifecycle.ViewModelProvider;
import com.chamsion.quickchat.R;
import com.chamsion.quickchat.service.DmrService;
import h.f;
import java.util.ArrayList;
import java.util.HashMap;
import k0.t;
import o0.a;
import o0.c;
import p0.e0;
import p0.f0;
import p0.o0;
import p0.p;
import p0.p0;
import p0.q0;
import p0.r;
import p0.r0;
import p0.s0;
import p0.t0;
import r0.b;
import s0.e;
import s0.j;
import s0.l;
import x0.g;

/* loaded from: classes.dex */
public class MainActivity extends AppCompatActivity {
    public static final /* synthetic */ int I = 0;
    public final q0 A;
    public final r0 B;
    public q0 C;
    public long D;
    public long E;
    public boolean F;
    public final s0 G;
    public final t0 H;

    /* renamed from: b, reason: collision with root package name */
    public RadioButton f1404b;

    /* renamed from: c, reason: collision with root package name */
    public RadioButton f1405c;

    /* renamed from: d, reason: collision with root package name */
    public RadioButton f1406d;

    /* renamed from: e, reason: collision with root package name */
    public RadioButton f1407e;

    /* renamed from: f, reason: collision with root package name */
    public RadioButton f1408f;

    /* renamed from: g, reason: collision with root package name */
    public RadioGroup f1409g;

    /* renamed from: h, reason: collision with root package name */
    public MainActivity f1410h;

    /* renamed from: i, reason: collision with root package name */
    public t f1411i;

    /* renamed from: k, reason: collision with root package name */
    public o0 f1413k;

    /* renamed from: l, reason: collision with root package name */
    public p f1414l;

    /* renamed from: m, reason: collision with root package name */
    public r f1415m;

    /* renamed from: n, reason: collision with root package name */
    public e0 f1416n;

    /* renamed from: o, reason: collision with root package name */
    public f0 f1417o;

    /* renamed from: r, reason: collision with root package name */
    public final int f1420r;

    /* renamed from: s, reason: collision with root package name */
    public long f1421s;

    /* renamed from: t, reason: collision with root package name */
    public c f1422t;

    /* renamed from: u, reason: collision with root package name */
    public a f1423u;

    /* renamed from: v, reason: collision with root package name */
    public Handler f1424v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f1425w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f1426x;

    /* renamed from: y, reason: collision with root package name */
    public l f1427y;

    /* renamed from: z, reason: collision with root package name */
    public q0 f1428z;

    /* renamed from: a, reason: collision with root package name */
    public final String f1403a = MainActivity.class.getName();

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f1412j = new ArrayList();

    /* renamed from: p, reason: collision with root package name */
    public boolean f1418p = false;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1419q = false;

    public MainActivity() {
        int i2 = 0;
        new Handler();
        this.f1420r = 1;
        this.f1421s = 0L;
        this.f1422t = null;
        this.f1424v = null;
        this.f1426x = false;
        this.A = new q0(this, i2);
        this.B = new r0(this);
        this.D = 0L;
        this.E = 0L;
        this.F = false;
        this.G = new s0(this, i2);
        this.H = new t0(this);
    }

    public final void d() {
        b bVar = new b(this);
        String str = bVar.f2514a;
        Log.d(str, "closeSpeaker.");
        AudioManager audioManager = (AudioManager) getSystemService("audio");
        audioManager.setParameters("pdt_play=off");
        r0.a aVar = bVar.f2516c;
        audioManager.abandonAudioFocus(aVar);
        Log.d(str, "closeMic.");
        AudioManager audioManager2 = (AudioManager) getSystemService("audio");
        audioManager2.setParameters("pdt_mic=off");
        audioManager2.abandonAudioFocus(aVar);
        AudioManager audioManager3 = (AudioManager) bVar.f2515b.getSystemService("audio");
        if (audioManager3 != null) {
            audioManager3.adjustStreamVolume(3, -100, 0);
        }
        if (this.f1418p) {
            this.f1418p = false;
            unbindService(this.H);
        }
        stopService(new Intent(this.f1410h, (Class<?>) DmrService.class));
        AudioManager audioManager4 = (AudioManager) bVar.f2515b.getSystemService("audio");
        if (audioManager4 != null) {
            audioManager4.adjustStreamVolume(3, 100, 0);
        }
    }

    public final void e(int i2) {
        if (i2 == R.id.rb_ptt) {
            this.f1404b.setSelected(true);
            this.f1405c.setSelected(false);
            this.f1406d.setSelected(false);
            this.f1407e.setSelected(false);
            this.f1408f.setSelected(false);
            return;
        }
        if (i2 == R.id.rb_channel) {
            this.f1404b.setSelected(false);
            this.f1405c.setSelected(true);
            this.f1406d.setSelected(false);
            this.f1407e.setSelected(false);
            this.f1408f.setSelected(false);
            return;
        }
        if (i2 == R.id.rb_contacts) {
            this.f1404b.setSelected(false);
            this.f1405c.setSelected(false);
            this.f1406d.setSelected(true);
            this.f1407e.setSelected(false);
            this.f1408f.setSelected(false);
            return;
        }
        if (i2 == R.id.rb_message) {
            this.f1404b.setSelected(false);
            this.f1405c.setSelected(false);
            this.f1406d.setSelected(false);
            this.f1407e.setSelected(true);
            this.f1408f.setSelected(false);
            return;
        }
        if (i2 == R.id.rb_mine) {
            this.f1404b.setSelected(false);
            this.f1405c.setSelected(false);
            this.f1406d.setSelected(false);
            this.f1407e.setSelected(false);
            this.f1408f.setSelected(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    @Override // androidx.fragment.app.c0, androidx.activity.h, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onActivityResult(int r8, int r9, android.content.Intent r10) {
        /*
            r7 = this;
            super.onActivityResult(r8, r9, r10)
            s0.l r0 = r7.f1427y
            r1 = 101(0x65, float:1.42E-43)
            r2 = 0
            r3 = 1
            if (r8 != r1) goto L49
            java.lang.String[] r1 = s0.g.f2536a
            android.app.Activity r4 = r0.f2545a
            r5 = r2
        L10:
            r6 = 2
            if (r5 >= r6) goto L20
            r6 = r1[r5]
            int r6 = i.e.a(r4, r6)
            if (r6 == 0) goto L1d
            r1 = r2
            goto L21
        L1d:
            int r5 = r5 + 1
            goto L10
        L20:
            r1 = r3
        L21:
            p0.r0 r5 = r0.f2546b
            if (r1 == 0) goto L29
            r5.b()
            goto L4c
        L29:
            java.lang.String r1 = "android.permission.RECORD_AUDIO"
            int r1 = i.e.a(r4, r1)
            if (r1 != 0) goto L41
            java.lang.String r1 = "android.permission.READ_PHONE_STATE"
            int r1 = i.e.a(r4, r1)
            if (r1 != 0) goto L3d
            r5.b()
            goto L4c
        L3d:
            r0.a()
            goto L4c
        L41:
            com.chamsion.quickchat.ui.MainActivity r0 = r5.f2446a
            s0.l r0 = r0.f1427y
            r0.c()
            goto L4c
        L49:
            r0.getClass()
        L4c:
            r0 = 1002(0x3ea, float:1.404E-42)
            if (r8 == r0) goto L58
            r0 = 1001(0x3e9, float:1.403E-42)
            if (r8 == r0) goto L58
            r0 = 1003(0x3eb, float:1.406E-42)
            if (r8 != r0) goto Lc2
        L58:
            r0 = -1
            if (r9 != r0) goto Lc2
            p0.f0 r7 = r7.f1417o
            if (r10 == 0) goto L6e
            r7.getClass()
            android.net.Uri r9 = r10.getData()
            if (r9 != 0) goto L69
            goto L6e
        L69:
            android.net.Uri r9 = r10.getData()
            goto L70
        L6e:
            android.net.Uri r9 = r7.C
        L70:
            java.lang.String r10 = r7.f2317g
            if (r9 != 0) goto L7a
            java.lang.String r7 = "Invalid pictureUri null"
            android.util.Log.e(r10, r7)
            goto Lc2
        L7a:
            java.lang.String r0 = "content"
            java.lang.String r1 = r9.getScheme()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L9c
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Invalid pictureUri scheme: "
            r7.<init>(r8)
            java.lang.String r8 = r9.getScheme()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            android.util.Log.e(r10, r7)
            goto Lc2
        L9c:
            switch(r8) {
                case 1001: goto Lac;
                case 1002: goto Lac;
                case 1003: goto La0;
                default: goto L9f;
            }
        L9f:
            goto Lc2
        La0:
            p0.l r8 = new p0.l
            r8.<init>(r7, r9, r3)
            java.util.concurrent.Executor r7 = android.os.AsyncTask.THREAD_POOL_EXECUTOR
            r9 = 0
            r8.executeOnExecutor(r7, r9)
            goto Lc2
        Lac:
            android.net.Uri r8 = r7.C
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto Lb8
            r7.g()
            goto Lc2
        Lb8:
            p0.k r8 = new p0.k
            r8.<init>(r7, r9, r3)
            java.lang.Void[] r7 = new java.lang.Void[r2]
            r8.execute(r7)
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chamsion.quickchat.ui.MainActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // androidx.activity.h, android.app.Activity
    public final void onBackPressed() {
        e.b(this.f1410h, getString(R.string.fragment_local_exit_app), getString(R.string.exit_app), getString(R.string.ok), getString(R.string.cancel), new p0(0, this));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.c0, androidx.activity.h, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i2 = configuration.colorMode;
        e(((Integer) g.J(this.f1410h, "nav_rb_id", Integer.valueOf(R.id.rb_ptt))).intValue());
        this.f1425w = true;
        this.f1404b.setText(R.string.rb_ptt);
        this.f1405c.setText(R.string.rb_channel);
        this.f1406d.setText(R.string.rb_contacts);
        this.f1407e.setText(R.string.rb_message);
        this.f1408f.setText(R.string.rb_mine);
    }

    @Override // androidx.fragment.app.c0, androidx.activity.h, h.l, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main_1);
        this.f1410h = this;
        l lVar = new l();
        lVar.f2545a = this;
        r0 r0Var = this.B;
        lVar.f2546b = r0Var;
        this.f1427y = lVar;
        String[] strArr = s0.g.f2536a;
        int i2 = 0;
        while (true) {
            if (i2 >= 2) {
                r0Var.b();
                break;
            }
            if (i.e.a(this, strArr[i2]) != 0) {
                int i3 = 0;
                while (true) {
                    if (i3 >= 2) {
                        lVar.b();
                        break;
                    }
                    String str = strArr[i3];
                    int i4 = f.f1829b;
                    if (h.c.c(this, str)) {
                        new AlertDialog.Builder(this).setTitle(R.string.must_permission).setMessage(R.string.rationale_permission).setCancelable(false).setPositiveButton(R.string.phone_permission_go, new j(lVar, 0)).setNegativeButton(R.string.fragment_local_exit_app, new j(lVar, 1)).show();
                        break;
                    }
                    i3++;
                }
            } else {
                i2++;
            }
        }
        getWindow().addFlags(Optimizer.OPTIMIZATION_GRAPH_WRAP);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.c0, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        d();
        try {
            q0 q0Var = this.C;
            if (q0Var != null) {
                unregisterReceiver(q0Var);
            }
            q0 q0Var2 = this.A;
            if (q0Var2 != null) {
                unregisterReceiver(q0Var2);
            }
            q0 q0Var3 = this.f1428z;
            if (q0Var3 != null) {
                unregisterReceiver(q0Var3);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        b.a(this).getClass();
        getWindow().clearFlags(Optimizer.OPTIMIZATION_GRAPH_WRAP);
    }

    @Override // androidx.fragment.app.c0, androidx.activity.h, android.app.Activity
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        l lVar = this.f1427y;
        lVar.getClass();
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < strArr.length; i3++) {
            String str = strArr[i3];
            boolean z2 = iArr[i3] == 0;
            map.put(str, Boolean.valueOf(z2));
            if (z2) {
                arrayList.add(str);
            } else {
                arrayList2.add(str);
            }
        }
        boolean zIsEmpty = arrayList2.isEmpty();
        r0 r0Var = lVar.f2546b;
        if (zIsEmpty) {
            r0Var.b();
        } else {
            Boolean bool = Boolean.FALSE;
            if (!((Boolean) map.getOrDefault("android.permission.RECORD_AUDIO", bool)).booleanValue()) {
                r0Var.f2446a.f1427y.c();
            } else if (((Boolean) map.getOrDefault("android.permission.READ_PHONE_STATE", bool)).booleanValue()) {
                r0Var.b();
            } else {
                new AlertDialog.Builder(lVar.f2545a).setTitle(R.string.phone_permission_title).setMessage(R.string.phone_permission_message).setCancelable(false).setPositiveButton(R.string.phone_permission_go, new j(lVar, 4)).setNegativeButton(R.string.fragment_local_exit_app, new j(lVar, 5)).show();
            }
        }
        if (i2 == 1003) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                lVar.c();
            }
        }
    }

    @Override // androidx.fragment.app.c0, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (this.f1411i == null) {
            this.f1411i = (t) new ViewModelProvider(this).get(t.class);
        }
        this.f1411i.f2014b.observe(this, new p0.e(this, 2));
    }
}
