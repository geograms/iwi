package p0;

import android.media.AudioManager;
import android.os.Message;
import android.util.Log;
import android.widget.SeekBar;
import com.chamsion.quickchat.ui.SettingsActivity;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class a1 implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SettingsActivity f2285a;

    public a1(SettingsActivity settingsActivity) {
        this.f2285a = settingsActivity;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
        SettingsActivity settingsActivity = this.f2285a;
        if (seekBar.equals(settingsActivity.f1464m)) {
            settingsActivity.f1460i.setText(i2 + "");
            return;
        }
        if (seekBar.equals(settingsActivity.f1465n)) {
            settingsActivity.f1459h.setText(i2 + "");
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        a.b bVar;
        int progress = seekBar.getProgress();
        SettingsActivity settingsActivity = this.f2285a;
        settingsActivity.f1472u = false;
        if (seekBar.equals(settingsActivity.f1464m)) {
            x0.g.m0(settingsActivity.f1469r, "volume", Integer.valueOf(progress));
            Iterator it = settingsActivity.f1474w.iterator();
            while (it.hasNext()) {
                k0.a aVar = (k0.a) it.next();
                aVar.f1948l = (byte) progress;
                settingsActivity.f1473v.a(aVar);
            }
            r0.d dVar = settingsActivity.f1468q;
            if (dVar != null) {
                AudioManager audioManager = (AudioManager) dVar.f2521b.getSystemService("audio");
                Log.d("GGG", "maxVolume: " + audioManager.getStreamMaxVolume(3));
                audioManager.setStreamVolume(3, progress, 1);
            }
        } else if (seekBar.equals(settingsActivity.f1465n)) {
            x0.g.m0(settingsActivity.f1469r, "mic", Integer.valueOf(progress));
            Iterator it2 = settingsActivity.f1474w.iterator();
            while (it2.hasNext()) {
                k0.a aVar2 = (k0.a) it2.next();
                aVar2.f1960x = (byte) progress;
                settingsActivity.f1473v.a(aVar2);
            }
            r0.d dVar2 = settingsActivity.f1468q;
            if (dVar2 != null && (bVar = dVar2.f2522c) != null) {
                Message messageObtainMessage = bVar.obtainMessage();
                messageObtainMessage.arg1 = 4;
                messageObtainMessage.arg2 = progress;
                messageObtainMessage.what = 256;
                dVar2.f2522c.sendMessageDelayed(messageObtainMessage, 100L);
            }
        }
        settingsActivity.f1472u = true;
    }
}
