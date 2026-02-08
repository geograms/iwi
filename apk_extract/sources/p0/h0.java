package p0;

import android.app.ProgressDialog;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.chamsion.quickchat.App;
import com.chamsion.quickchat.R;
import com.wonder.dmr.utils.SPUtils;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
public final /* synthetic */ class h0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2345a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o0 f2346b;

    public /* synthetic */ h0(o0 o0Var, int i2) {
        this.f2345a = i2;
        this.f2346b = o0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f2345a;
        o0 o0Var = this.f2346b;
        switch (i2) {
            case 0:
                o0Var.f2385m.setEnabled(true);
                o0Var.f2384l.setEnabled(true);
                o0Var.f2382j.setEnabled(true);
                return;
            case 1:
                int[] iArr = o0.f2371h0;
                o0Var.getClass();
                try {
                    try {
                        byte[] bArr = new byte[o0Var.A];
                        while (o0Var.f2398z) {
                            if (-3 != o0Var.B.read(bArr, 0, o0Var.A)) {
                                try {
                                    String[] strArrSplit = x0.g.m(bArr).split(",");
                                    LinkedBlockingQueue linkedBlockingQueue = o0Var.C;
                                    linkedBlockingQueue.addAll(Arrays.asList(strArrSplit));
                                    StringBuilder sb = new StringBuilder();
                                    while (true) {
                                        boolean zIsEmpty = linkedBlockingQueue.isEmpty();
                                        LinkedList linkedList = o0Var.D;
                                        if (zIsEmpty) {
                                            while (SystemClock.uptimeMillis() - o0Var.E < 10) {
                                            }
                                            o0Var.E = SystemClock.uptimeMillis();
                                            while (!linkedList.isEmpty()) {
                                                String str = (String) linkedList.poll();
                                                Message messageObtain = Message.obtain();
                                                messageObtain.what = 1;
                                                messageObtain.obj = str;
                                                o0Var.f2375d0.sendMessage(messageObtain);
                                            }
                                        } else {
                                            sb.append((String) linkedBlockingQueue.poll());
                                            if (sb.length() == o0Var.A * 2) {
                                                linkedList.add(sb.toString());
                                                sb.setLength(0);
                                            }
                                        }
                                    }
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    Log.d(o0Var.f2378g, "Recorder error:" + e2.getMessage());
                                }
                            }
                            SystemClock.sleep(1L);
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    o0Var.t();
                    return;
                } catch (Throwable th) {
                    o0Var.t();
                    throw th;
                }
            case 2:
                int[] iArr2 = o0.f2371h0;
                o0Var.getClass();
                if (App.f1233b.getSharedPreferences(SPUtils.FILE_NAME, 0).getBoolean("pref_person_ptt_end_tone", true)) {
                    o0Var.o();
                }
                o0Var.f2382j.setImageResource(R.mipmap.icon_ptt_button_normal);
                o0Var.t();
                o0Var.p();
                o0Var.D.clear();
                o0Var.C.clear();
                return;
            default:
                int[] iArr3 = o0.f2371h0;
                ProgressDialog progressDialog = o0Var.X;
                if (progressDialog != null) {
                    progressDialog.dismiss();
                    return;
                }
                return;
        }
    }
}
