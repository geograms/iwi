package androidx.activity;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.core.view.d1;
import androidx.core.view.m0;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.c0;
import com.chamsion.quickchat.R;
import com.chamsion.quickchat.ui.AddNewContactsActivity;
import com.chamsion.quickchat.ui.UpdateDmrAcitivity;
import com.wonder.dmr.DmrManager;
import com.wonder.dmr.utils.SPUtils;
import java.util.WeakHashMap;
import p0.f0;

/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f21b;

    public /* synthetic */ d(int i2, Object obj) {
        this.f20a = i2;
        this.f21b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View viewD;
        int width;
        int i2 = this.f20a;
        Object obj = this.f21b;
        switch (i2) {
            case 0:
                try {
                    super/*android.app.Activity*/.onBackPressed();
                    return;
                } catch (IllegalStateException e2) {
                    if (!TextUtils.equals(e2.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                        throw e2;
                    }
                    return;
                }
            case 1:
                u.g gVar = (u.g) obj;
                if (gVar.f2583o) {
                    boolean z2 = gVar.f2581m;
                    u.a aVar = gVar.f2569a;
                    if (z2) {
                        gVar.f2581m = false;
                        aVar.getClass();
                        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                        aVar.f2563e = jCurrentAnimationTimeMillis;
                        aVar.f2565g = -1L;
                        aVar.f2564f = jCurrentAnimationTimeMillis;
                        aVar.f2566h = 0.5f;
                    }
                    if ((aVar.f2565g > 0 && AnimationUtils.currentAnimationTimeMillis() > aVar.f2565g + aVar.f2567i) || !gVar.f()) {
                        gVar.f2583o = false;
                        return;
                    }
                    boolean z3 = gVar.f2582n;
                    View view = gVar.f2571c;
                    if (z3) {
                        gVar.f2582n = false;
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                        view.onTouchEvent(motionEventObtain);
                        motionEventObtain.recycle();
                    }
                    if (aVar.f2564f == 0) {
                        throw new RuntimeException("Cannot compute scroll delta before calling start()");
                    }
                    long jCurrentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                    float fA = aVar.a(jCurrentAnimationTimeMillis2);
                    long j2 = jCurrentAnimationTimeMillis2 - aVar.f2564f;
                    aVar.f2564f = jCurrentAnimationTimeMillis2;
                    u.h.b(gVar.f2585q, (int) (j2 * ((fA * 4.0f) + ((-4.0f) * fA * fA)) * aVar.f2562d));
                    WeakHashMap weakHashMap = d1.f138a;
                    m0.m(view, this);
                    return;
                }
                return;
            case 2:
                ((androidx.customview.widget.h) obj).q(0);
                return;
            case 3:
                w.f fVar = (w.f) obj;
                int i3 = fVar.f2614b.f281o;
                int i4 = fVar.f2613a;
                boolean z4 = i4 == 3;
                DrawerLayout drawerLayout = fVar.f2616d;
                if (z4) {
                    viewD = drawerLayout.d(3);
                    width = (viewD != null ? -viewD.getWidth() : 0) + i3;
                } else {
                    viewD = drawerLayout.d(5);
                    width = drawerLayout.getWidth() - i3;
                }
                if (viewD != null) {
                    if (((!z4 || viewD.getLeft() >= width) && (z4 || viewD.getLeft() <= width)) || drawerLayout.h(viewD) != 0) {
                        return;
                    }
                    w.d dVar = (w.d) viewD.getLayoutParams();
                    fVar.f2614b.t(viewD, width, viewD.getTop());
                    dVar.f2606c = true;
                    drawerLayout.invalidate();
                    View viewD2 = drawerLayout.d(i4 == 3 ? 5 : 3);
                    if (viewD2 != null) {
                        drawerLayout.b(viewD2);
                    }
                    if (drawerLayout.f306q) {
                        return;
                    }
                    long jUptimeMillis2 = SystemClock.uptimeMillis();
                    MotionEvent motionEventObtain2 = MotionEvent.obtain(jUptimeMillis2, jUptimeMillis2, 3, 0.0f, 0.0f, 0);
                    int childCount = drawerLayout.getChildCount();
                    for (int i5 = 0; i5 < childCount; i5++) {
                        drawerLayout.getChildAt(i5).dispatchTouchEvent(motionEventObtain2);
                    }
                    motionEventObtain2.recycle();
                    drawerLayout.f306q = true;
                    return;
                }
                return;
            case 4:
                a.a.j(obj);
                SystemClock.uptimeMillis();
                throw null;
            case 5:
                ((AddNewContactsActivity) obj).finish();
                return;
            case 6:
                f0 f0Var = (f0) obj;
                TextView textView = f0Var.f2331u;
                if (textView != null) {
                    c0 activity = f0Var.getActivity();
                    Uri uri = j0.c.f1900a;
                    textView.setText(j0.c.a(activity, activity.getSharedPreferences(SPUtils.FILE_NAME, 0).getString("pref_person_channel_area_selected_index", j0.c.f1904e)));
                }
                f0Var.f2335y.setText(R.string.fragment_local_device_area);
                f0Var.B.setText(R.string.fragment_local_exit_app);
                f0Var.f2336z.setText(R.string.fragment_local_factory_reset);
                f0Var.f2334x.setText(R.string.fragment_local_information);
                f0Var.f2333w.setText(R.string.fragment_local_setting);
                f0Var.A.setText(R.string.fragment_local_use_assistant);
                f0Var.f2332v.setText(R.string.dmr_update);
                return;
            case 7:
                DmrManager.getInstance().powerCtrl("/sys/devices/platform/intercom/intercom_ptt_control", 1);
                d dVar2 = (d) obj;
                UpdateDmrAcitivity.e((UpdateDmrAcitivity) ((d) dVar2.f21b).f21b, 0);
                ((UpdateDmrAcitivity) ((d) dVar2.f21b).f21b).f1491n.sendEmptyMessageDelayed(Optimizer.OPTIMIZATION_STANDARD, 50L);
                return;
            case 8:
                DmrManager.getInstance().powerCtrl("/sys/devices/platform/intercom/intercom_power_control", 1);
                DmrManager.getInstance().powerCtrl("/sys/devices/platform/intercom/intercom_pwd_control", 1);
                new Handler().postDelayed(new d(7, this), 1050L);
                return;
            default:
                DmrManager.getInstance().powerCtrl("/sys/devices/platform/intercom/intercom_ptt_control", 0);
                new Handler().postDelayed(new d(8, this), 55L);
                return;
        }
    }
}
