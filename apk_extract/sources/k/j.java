package k;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.ContentInfo;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import com.chamsion.quickchat.R;
import com.chamsion.quickchat.ui.UpdateDmrAcitivity;
import com.wonder.dmr.OnAnalogCmdListener;
import com.wonder.dmr.OnEnhancementsListener;
import com.wonder.dmr.OnTransferInterruptListener;
import com.wonder.dmr.OnUpgradeModeListener;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p0.p;
import p0.p0;
import r.n;
import r.v;

/* loaded from: classes.dex */
public class j implements androidx.core.view.k, t.d, v, androidx.emoji2.text.i, OnAnalogCmdListener, OnEnhancementsListener, n0.l, OnUpgradeModeListener, OnTransferInterruptListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1933a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1934b;

    public /* synthetic */ j(int i2, Object obj) {
        this.f1933a = i2;
        this.f1934b = obj;
    }

    @Override // com.wonder.dmr.OnAnalogCmdListener, com.wonder.dmr.OnEnhancementsListener, com.wonder.dmr.OnUpgradeModeListener, com.wonder.dmr.OnTransferInterruptListener
    public final void OnCallback(int i2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        switch (this.f1933a) {
            case 17:
                if (i2 == 0) {
                    p pVar = (p) this.f1934b;
                    int i3 = p.C;
                    pVar.g();
                    break;
                }
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
            case 20:
            default:
                Handler handler = ((r0.c) this.f1934b).f2519b.f2520a;
                if (handler != null) {
                    Message messageObtainMessage = handler.obtainMessage();
                    messageObtainMessage.what = 10;
                    messageObtainMessage.arg1 = i2;
                    ((r0.c) this.f1934b).f2519b.f2520a.sendMessage(messageObtainMessage);
                    break;
                }
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                if (i2 != 0) {
                    int i4 = 2;
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                if (i2 == 4) {
                                    ((UpdateDmrAcitivity) this.f1934b).f1496s.append(((UpdateDmrAcitivity) this.f1934b).getString(R.string.update_done) + "\n");
                                    x0.g.m0(((UpdateDmrAcitivity) this.f1934b).f1483f, "upgrade_flag", Boolean.FALSE);
                                    UpdateDmrAcitivity updateDmrAcitivity = (UpdateDmrAcitivity) this.f1934b;
                                    ProgressDialog progressDialog = updateDmrAcitivity.f1486i;
                                    if (progressDialog != null && updateDmrAcitivity.f1487j) {
                                        progressDialog.dismiss();
                                        updateDmrAcitivity.f1487j = false;
                                    }
                                    ((UpdateDmrAcitivity) this.f1934b).f1490m.sendEmptyMessageDelayed(1, 0L);
                                    UpdateDmrAcitivity updateDmrAcitivity2 = (UpdateDmrAcitivity) this.f1934b;
                                    s0.e.b(updateDmrAcitivity2.f1483f, updateDmrAcitivity2.getString(R.string.dmr_update), ((UpdateDmrAcitivity) this.f1934b).getString(R.string.pls_reboot), ((UpdateDmrAcitivity) this.f1934b).getString(R.string.ok), "", new p0(i4, this));
                                    break;
                                }
                            } else {
                                ((UpdateDmrAcitivity) this.f1934b).f1496s.append(((UpdateDmrAcitivity) this.f1934b).getString(R.string.firmware_send_success) + "\n");
                                ((UpdateDmrAcitivity) this.f1934b).f1490m.sendEmptyMessageDelayed(1, 0L);
                                ((UpdateDmrAcitivity) this.f1934b).f1491n.sendEmptyMessage(261);
                                break;
                            }
                        } else {
                            UpdateDmrAcitivity updateDmrAcitivity3 = (UpdateDmrAcitivity) this.f1934b;
                            updateDmrAcitivity3.f1494q++;
                            int i5 = updateDmrAcitivity3.f1495r + 1;
                            updateDmrAcitivity3.f1495r = i5;
                            if (i5 > 255) {
                                updateDmrAcitivity3.f1495r = 0;
                            }
                            Log.e(updateDmrAcitivity3.f1478a, ((UpdateDmrAcitivity) this.f1934b).f1488k + "updateListener, mSendCnt = 【" + ((UpdateDmrAcitivity) this.f1934b).f1494q + "】   mDataIndex = 【" + ((UpdateDmrAcitivity) this.f1934b).f1495r + "】     Total Cnt = 【" + ((UpdateDmrAcitivity) this.f1934b).f1493p + "】");
                            ((UpdateDmrAcitivity) this.f1934b).f1490m.sendEmptyMessageDelayed(2, 0L);
                            UpdateDmrAcitivity updateDmrAcitivity4 = (UpdateDmrAcitivity) this.f1934b;
                            if (updateDmrAcitivity4.f1494q > updateDmrAcitivity4.f1493p) {
                                updateDmrAcitivity4.f1491n.sendEmptyMessage(260);
                                break;
                            } else {
                                updateDmrAcitivity4.f1491n.removeMessages(259);
                                ((UpdateDmrAcitivity) this.f1934b).f1491n.sendEmptyMessageDelayed(259, 5L);
                                break;
                            }
                        }
                    } else {
                        x0.g.m0(((UpdateDmrAcitivity) this.f1934b).f1483f, "upgrade_flag", Boolean.TRUE);
                        UpdateDmrAcitivity updateDmrAcitivity5 = (UpdateDmrAcitivity) this.f1934b;
                        updateDmrAcitivity5.f1489l = true;
                        updateDmrAcitivity5.f1496s.append(((UpdateDmrAcitivity) this.f1934b).getString(R.string.start_updating) + "\n");
                        ((UpdateDmrAcitivity) this.f1934b).f1490m.sendEmptyMessageDelayed(1, 0L);
                        UpdateDmrAcitivity.e((UpdateDmrAcitivity) this.f1934b, 2);
                        ((UpdateDmrAcitivity) this.f1934b).f1491n.sendEmptyMessage(259);
                        ((UpdateDmrAcitivity) this.f1934b).f1482e.setVisibility(0);
                        ((UpdateDmrAcitivity) this.f1934b).f1480c.setEnabled(false);
                        ((UpdateDmrAcitivity) this.f1934b).f1479b.setEnabled(false);
                        UpdateDmrAcitivity updateDmrAcitivity6 = (UpdateDmrAcitivity) this.f1934b;
                        updateDmrAcitivity6.f1482e.setMax(updateDmrAcitivity6.f1493p);
                        UpdateDmrAcitivity updateDmrAcitivity7 = (UpdateDmrAcitivity) this.f1934b;
                        updateDmrAcitivity7.f1482e.setProgress(updateDmrAcitivity7.f1494q);
                        Log.e(((UpdateDmrAcitivity) this.f1934b).f1478a, ((UpdateDmrAcitivity) this.f1934b).f1488k + "updateListener, mSendCnt = 【" + ((UpdateDmrAcitivity) this.f1934b).f1494q + "】   mDataIndex = 【" + ((UpdateDmrAcitivity) this.f1934b).f1495r + "】     Total Cnt = 【" + ((UpdateDmrAcitivity) this.f1934b).f1493p + "】");
                        break;
                    }
                } else {
                    UpdateDmrAcitivity updateDmrAcitivity8 = (UpdateDmrAcitivity) this.f1934b;
                    int i6 = updateDmrAcitivity8.f1497t;
                    if (i6 == 0) {
                        updateDmrAcitivity8.f1497t = i6 + 1;
                        updateDmrAcitivity8.f1496s.append(((UpdateDmrAcitivity) this.f1934b).getString(R.string.update_mode_select_file) + "\n");
                        ((UpdateDmrAcitivity) this.f1934b).f1490m.sendEmptyMessageDelayed(1, 0L);
                        ((UpdateDmrAcitivity) this.f1934b).f1480c.setEnabled(true);
                        break;
                    }
                }
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                Handler handler2 = ((r0.c) this.f1934b).f2519b.f2520a;
                if (handler2 != null) {
                    Message messageObtainMessage2 = handler2.obtainMessage();
                    messageObtainMessage2.what = 9;
                    messageObtainMessage2.arg1 = i2;
                    ((r0.c) this.f1934b).f2519b.f2520a.sendMessage(messageObtainMessage2);
                    break;
                }
                break;
        }
    }

    @Override // t.d
    public final void a() {
        switch (this.f1933a) {
            case 6:
                ((InputContentInfo) this.f1934b).requestPermission();
                break;
            default:
                ((t.d) this.f1934b).a();
                break;
        }
    }

    @Override // androidx.core.view.k
    public final ClipData b() {
        return ((ContentInfo) this.f1934b).getClip();
    }

    @Override // t.d
    public final Uri c() {
        switch (this.f1933a) {
            case 6:
                return ((InputContentInfo) this.f1934b).getLinkUri();
            default:
                return ((t.d) this.f1934b).c();
        }
    }

    @Override // androidx.core.view.k
    public final int d() {
        return ((ContentInfo) this.f1934b).getFlags();
    }

    @Override // androidx.emoji2.text.i
    public final void e(x0.g gVar) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new androidx.emoji2.text.a("EmojiCompatInitializer"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new androidx.emoji2.text.k(this, gVar, threadPoolExecutor, 0));
    }

    @Override // n0.l
    public final void f() {
    }

    @Override // androidx.core.view.k
    public final ContentInfo g() {
        return (ContentInfo) this.f1934b;
    }

    @Override // androidx.core.view.k
    public final int h() {
        return ((ContentInfo) this.f1934b).getSource();
    }

    @Override // t.d
    public final ClipDescription i() {
        switch (this.f1933a) {
            case 6:
                return ((InputContentInfo) this.f1934b).getDescription();
            default:
                return ((t.d) this.f1934b).i();
        }
    }

    @Override // t.d
    public final Object j() {
        return (InputContentInfo) this.f1934b;
    }

    @Override // t.d
    public final Uri k() {
        switch (this.f1933a) {
            case 6:
                return ((InputContentInfo) this.f1934b).getContentUri();
            default:
                return ((t.d) this.f1934b).k();
        }
    }

    public final long l() {
        return ((ByteBuffer) this.f1934b).getInt() & 4294967295L;
    }

    public final void m(int i2) {
        Object obj = this.f1934b;
        ((ByteBuffer) obj).position(((ByteBuffer) obj).position() + i2);
    }

    @Override // r.v
    public final boolean perform(View view, n nVar) {
        ((DrawerLayout) this.f1934b).getClass();
        if (!DrawerLayout.l(view) || ((DrawerLayout) this.f1934b).h(view) == 2) {
            return false;
        }
        ((DrawerLayout) this.f1934b).b(view);
        return true;
    }

    public final String toString() {
        switch (this.f1933a) {
            case 3:
                return "ContentInfoCompat{" + ((ContentInfo) this.f1934b) + "}";
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                return "<" + ((String) this.f1934b) + '>';
            default:
                return super.toString();
        }
    }

    public j(j.p pVar) {
        this.f1933a = 0;
        this.f1934b = pVar;
    }

    public j() {
        this.f1933a = 1;
        this.f1934b = new ConcurrentHashMap();
    }

    public j(Object obj) {
        this.f1933a = 6;
        this.f1934b = (InputContentInfo) obj;
    }

    public j(Context context) {
        this.f1933a = 12;
        this.f1934b = context.getApplicationContext();
    }

    public j(ByteBuffer byteBuffer) {
        this.f1933a = 13;
        this.f1934b = byteBuffer;
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
    }

    public j(ContentInfo contentInfo) {
        this.f1933a = 3;
        contentInfo.getClass();
        this.f1934b = androidx.core.view.g.f(contentInfo);
    }
}
