package com.chamsion.quickchat.ui;

import a.b;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.PowerManager;
import android.os.Process;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.d;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Optimizer;
import com.chamsion.quickchat.R;
import com.wonder.dmr.DmrManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import k.j;
import p0.c1;
import p0.g;
import p0.p0;
import s0.e;

/* loaded from: classes.dex */
public class UpdateDmrAcitivity extends AppCompatActivity {
    public static final /* synthetic */ int A = 0;

    /* renamed from: b, reason: collision with root package name */
    public Button f1479b;

    /* renamed from: c, reason: collision with root package name */
    public Button f1480c;

    /* renamed from: d, reason: collision with root package name */
    public EditText f1481d;

    /* renamed from: e, reason: collision with root package name */
    public SeekBar f1482e;

    /* renamed from: f, reason: collision with root package name */
    public UpdateDmrAcitivity f1483f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f1484g;

    /* renamed from: h, reason: collision with root package name */
    public ImageView f1485h;

    /* renamed from: i, reason: collision with root package name */
    public ProgressDialog f1486i;

    /* renamed from: k, reason: collision with root package name */
    public String f1488k;

    /* renamed from: m, reason: collision with root package name */
    public c1 f1490m;

    /* renamed from: v, reason: collision with root package name */
    public byte[] f1499v;

    /* renamed from: w, reason: collision with root package name */
    public String f1500w;

    /* renamed from: x, reason: collision with root package name */
    public int f1501x;

    /* renamed from: a, reason: collision with root package name */
    public final String f1478a = UpdateDmrAcitivity.class.getName();

    /* renamed from: j, reason: collision with root package name */
    public boolean f1487j = false;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1489l = false;

    /* renamed from: n, reason: collision with root package name */
    public b f1491n = null;

    /* renamed from: o, reason: collision with root package name */
    public HandlerThread f1492o = null;

    /* renamed from: p, reason: collision with root package name */
    public int f1493p = 0;

    /* renamed from: q, reason: collision with root package name */
    public int f1494q = 1;

    /* renamed from: r, reason: collision with root package name */
    public int f1495r = 1;

    /* renamed from: s, reason: collision with root package name */
    public StringBuilder f1496s = null;

    /* renamed from: t, reason: collision with root package name */
    public int f1497t = 0;

    /* renamed from: u, reason: collision with root package name */
    public final g f1498u = new g(this, 5);

    /* renamed from: y, reason: collision with root package name */
    public final int f1502y = Optimizer.OPTIMIZATION_GROUPING;

    /* renamed from: z, reason: collision with root package name */
    public PowerManager.WakeLock f1503z = null;

    public static void d(UpdateDmrAcitivity updateDmrAcitivity, int i2, int i3, int i4) {
        if (updateDmrAcitivity.f1499v == null) {
            updateDmrAcitivity.f1496s.append(updateDmrAcitivity.getString(R.string.select_file) + "\n");
            updateDmrAcitivity.f1490m.sendEmptyMessageDelayed(1, 0L);
            return;
        }
        int i5 = i2 == 1 ? Optimizer.OPTIMIZATION_GRAPH_WRAP : i2 == 2 ? Optimizer.OPTIMIZATION_GROUPING : 0;
        byte[] bArr = new byte[i5];
        StringBuilder sb = new StringBuilder("【");
        sb.append(i4);
        sb.append("】 , sendFile ,(cnt-1)*dataLen) = 【");
        int i6 = (i4 - 1) * i5;
        sb.append(i6);
        sb.append("】");
        String string = sb.toString();
        String str = updateDmrAcitivity.f1478a;
        Log.e(str, string);
        if (i4 * i5 > updateDmrAcitivity.f1501x) {
            Log.e(str, "sendFile ,固件包拆包，每包1024，有余数时，最后一帧处理。");
            System.arraycopy(updateDmrAcitivity.f1499v, i6, bArr, 0, updateDmrAcitivity.f1501x % i5);
        } else {
            System.arraycopy(updateDmrAcitivity.f1499v, i6, bArr, 0, i5);
        }
        DmrManager.getInstance().sendUpgradeDataPackage(i3, bArr);
    }

    public static void e(UpdateDmrAcitivity updateDmrAcitivity, int i2) {
        updateDmrAcitivity.getClass();
        Log.e(updateDmrAcitivity.f1478a, "setUpgradeState ,state = 【" + i2 + "】");
        DmrManager.getInstance().setDmrUpgradeProcessStage(i2);
    }

    public final void f(Uri uri, File file) throws IOException {
        try {
            InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[Optimizer.OPTIMIZATION_GROUPING];
                    while (true) {
                        int i2 = inputStreamOpenInputStream.read(bArr);
                        if (i2 <= 0) {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            inputStreamOpenInputStream.close();
                            return;
                        }
                        fileOutputStream.write(bArr, 0, i2);
                    }
                } finally {
                }
            } finally {
            }
        } catch (IOException e2) {
            Log.e("FileUtils", "File copy failed", e2);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public final void g() {
        this.f1496s.setLength(0);
        this.f1496s.append(getString(R.string.update_mode_select_file) + "\n");
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("*/*");
        intent.addCategory("android.intent.category.OPENABLE");
        try {
            startActivityForResult(Intent.createChooser(intent, "Select a File"), 42);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, "Please install a File Manager.", 0).show();
        }
    }

    public final void h() {
        e.b(this.f1483f, getString(R.string.exit_update), getString(R.string.exit_update_content), getString(R.string.ok), getString(R.string.cancel), new p0(1, this));
    }

    public final void i() {
        String str = "setDmrPowerOff, " + Build.MODEL;
        String str2 = this.f1478a;
        Log.d(str2, str);
        Log.d(str2, "setDmrPowerOff, case:XPLORE 1");
        DmrManager.getInstance().powerCtrl("/sys/devices/platform/intercom/intercom_power_control", 0);
        DmrManager.getInstance().pwdCtrl("/sys/devices/platform/intercom/intercom_pwd_control", 0);
        DmrManager.getInstance().pttCtrl("/sys/devices/platform/intercom/intercom_ptt_control", 0);
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(268435456);
        startActivity(intent);
        Process.killProcess(Process.myPid());
    }

    @Override // androidx.fragment.app.c0, androidx.activity.h, android.app.Activity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 42 || i3 != -1 || intent == null || intent.getData() == null) {
            return;
        }
        Uri data = intent.getData();
        Message messageObtainMessage = this.f1491n.obtainMessage();
        messageObtainMessage.obj = data;
        messageObtainMessage.what = 256;
        this.f1491n.sendMessageDelayed(messageObtainMessage, 10L);
    }

    @Override // androidx.activity.h, android.app.Activity
    public final void onBackPressed() {
        h();
    }

    @Override // androidx.fragment.app.c0, androidx.activity.h, h.l, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_update_dmr);
        this.f1483f = this;
        ((TextView) findViewById(R.id.tv_title)).setText(getResources().getString(R.string.dmr_update));
        this.f1484g = (TextView) findViewById(R.id.tv_update_desc);
        ImageView imageView = (ImageView) findViewById(R.id.iv_close);
        this.f1485h = imageView;
        imageView.setVisibility(0);
        ImageView imageView2 = this.f1485h;
        g gVar = this.f1498u;
        imageView2.setOnClickListener(gVar);
        Button button = (Button) findViewById(R.id.btn_update);
        this.f1479b = button;
        button.setEnabled(false);
        this.f1479b.setOnClickListener(gVar);
        Button button2 = (Button) findViewById(R.id.btn_update_file);
        this.f1480c = button2;
        button2.setOnClickListener(gVar);
        this.f1480c.setEnabled(false);
        this.f1481d = (EditText) findViewById(R.id.et_update_file);
        this.f1482e = (SeekBar) findViewById(R.id.sb_update);
        this.f1481d.setEnabled(false);
        this.f1496s = new StringBuilder();
        this.f1490m = new c1(this, this);
        HandlerThread handlerThread = new HandlerThread("work-handlerthread");
        this.f1492o = handlerThread;
        handlerThread.start();
        this.f1491n = new b(this, this.f1492o.getLooper(), 5);
        this.f1488k = (String) x0.g.J(this, "version", "");
        Log.e(this.f1478a, "init, mDmrVersion = " + this.f1488k);
        DmrManager.getInstance().setDmrUpgradeListener(new j(21, this));
        this.f1496s.append(getString(R.string.dmr_settings) + "\n");
        this.f1490m.sendEmptyMessageDelayed(1, 0L);
        DmrManager.getInstance().powerCtrl("/sys/devices/platform/intercom/intercom_power_control", 0);
        DmrManager.getInstance().powerCtrl("/sys/devices/platform/intercom/intercom_pwd_control", 0);
        new Handler().postDelayed(new d(9, this), 55L);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.c0, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        this.f1490m.removeCallbacksAndMessages(null);
        this.f1491n.removeCallbacksAndMessages(null);
        PowerManager.WakeLock wakeLock = this.f1503z;
        if (wakeLock == null || !wakeLock.isHeld()) {
            return;
        }
        Log.d(this.f1478a, "Release wake lock");
        this.f1503z.release();
        this.f1503z = null;
    }

    @Override // androidx.fragment.app.c0, androidx.activity.h, android.app.Activity
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 1) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(this, R.string.need_storage_permission, 0).show();
            } else {
                g();
            }
        }
    }

    @Override // androidx.fragment.app.c0, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (this.f1503z == null) {
            Log.d(this.f1478a, "Acquiring wake lock");
            PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(6, getClass().getCanonicalName());
            this.f1503z = wakeLockNewWakeLock;
            wakeLockNewWakeLock.acquire();
        }
    }
}
