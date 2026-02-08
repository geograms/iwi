package p0;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.chamsion.quickchat.R;
import com.chamsion.quickchat.ui.SettingsActivity;
import com.chamsion.quickchat.ui.UpdateDmrAcitivity;
import com.chamsion.quickchat.widget.CheckMarkView;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class c1 extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2295a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f2296b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AppCompatActivity f2297c;

    public c1(UpdateDmrAcitivity updateDmrAcitivity, AppCompatActivity appCompatActivity) {
        this.f2297c = updateDmrAcitivity;
        this.f2296b = new WeakReference(appCompatActivity);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        a.b bVar;
        a.b bVar2;
        int i2 = this.f2295a;
        int i3 = 2;
        AppCompatActivity appCompatActivity = this.f2297c;
        switch (i2) {
            case 0:
                if (((SettingsActivity) this.f2296b.get()) != null) {
                    int i4 = message.what;
                    if (i4 == 0) {
                        r0.d dVar = ((SettingsActivity) appCompatActivity).f1468q;
                        if (dVar != null && (bVar = dVar.f2522c) != null) {
                            Message messageObtainMessage = bVar.obtainMessage();
                            messageObtainMessage.arg1 = 1;
                            messageObtainMessage.what = 256;
                            dVar.f2522c.sendMessageDelayed(messageObtainMessage, 100L);
                            break;
                        }
                    } else if (i4 == 1) {
                        r0.d dVar2 = ((SettingsActivity) appCompatActivity).f1468q;
                        if (dVar2 != null && message.arg1 == 0 && (bVar2 = dVar2.f2522c) != null) {
                            Message messageObtainMessage2 = bVar2.obtainMessage();
                            messageObtainMessage2.arg1 = 2;
                            messageObtainMessage2.what = 256;
                            dVar2.f2522c.sendMessageDelayed(messageObtainMessage2, 100L);
                            break;
                        }
                    } else if (i4 == 2) {
                        if (message.arg1 == 0) {
                            ((SettingsActivity) appCompatActivity).f1462k.setText((String) message.obj);
                            break;
                        }
                    } else if (i4 != 3 && i4 != 4 && i4 != 5) {
                        if (i4 == 9) {
                            if (message.arg1 == 0) {
                                SettingsActivity settingsActivity = (SettingsActivity) appCompatActivity;
                                s0.e.a(settingsActivity.f1469r, "传输中断设置中断,关闭礼貌策略");
                                settingsActivity.f1456e.setChecked(false);
                                break;
                            }
                        } else if (i4 == 10 && message.arg1 == 0) {
                            SettingsActivity settingsActivity2 = (SettingsActivity) appCompatActivity;
                            s0.e.a(settingsActivity2.f1469r, "礼貌策略打开，传输中断设置打开");
                            settingsActivity2.f1471t = true;
                            settingsActivity2.f1466o.setSelection(0);
                            x0.g.m0(settingsActivity2.f1469r, "trans_interr", 1);
                            break;
                        }
                    } else if (message.arg1 == 0) {
                        SettingsActivity settingsActivity3 = (SettingsActivity) appCompatActivity;
                        SettingsActivity settingsActivity4 = settingsActivity3.f1469r;
                        String string = settingsActivity3.getString(R.string.already_set);
                        Dialog dialog = new Dialog(settingsActivity4);
                        dialog.setContentView(R.layout.dialog_check_view);
                        Window window = dialog.getWindow();
                        if (window != null) {
                            window.setBackgroundDrawableResource(android.R.color.transparent);
                        }
                        dialog.setCanceledOnTouchOutside(false);
                        ((TextView) dialog.findViewById(R.id.check_mark_text)).setText(string);
                        final CheckMarkView checkMarkView = (CheckMarkView) dialog.findViewById(R.id.check_mark);
                        if (checkMarkView != null) {
                            if (!checkMarkView.f1514d) {
                                checkMarkView.f1514d = true;
                                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                                valueAnimatorOfFloat.setDuration(1000L);
                                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: t0.b
                                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                        int i5 = CheckMarkView.f1510f;
                                        CheckMarkView checkMarkView2 = checkMarkView;
                                        checkMarkView2.getClass();
                                        checkMarkView2.f1513c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                        checkMarkView2.invalidate();
                                    }
                                });
                                valueAnimatorOfFloat.addListener(new androidx.transition.r(i3, checkMarkView));
                                valueAnimatorOfFloat.start();
                            }
                            checkMarkView.f1515e.add(new s0.c(dialog));
                        }
                        dialog.show();
                        break;
                    }
                }
                break;
            default:
                super.handleMessage(message);
                if (((AppCompatActivity) this.f2296b.get()) != null) {
                    int i5 = message.what;
                    if (i5 == 1) {
                        UpdateDmrAcitivity updateDmrAcitivity = (UpdateDmrAcitivity) appCompatActivity;
                        updateDmrAcitivity.f1484g.setText(updateDmrAcitivity.f1496s.toString());
                        updateDmrAcitivity.f1481d.setText(updateDmrAcitivity.f1500w);
                        break;
                    } else if (i5 == 2) {
                        UpdateDmrAcitivity updateDmrAcitivity2 = (UpdateDmrAcitivity) appCompatActivity;
                        updateDmrAcitivity2.f1482e.setProgress(updateDmrAcitivity2.f1494q);
                        break;
                    } else if (i5 == 3) {
                        ((UpdateDmrAcitivity) appCompatActivity).f1479b.setEnabled(true);
                        break;
                    }
                }
                break;
        }
    }

    public c1(SettingsActivity settingsActivity, SettingsActivity settingsActivity2) {
        this.f2297c = settingsActivity;
        this.f2296b = new WeakReference(settingsActivity2);
    }
}
