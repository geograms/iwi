package r0;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static volatile b f2513e;

    /* renamed from: b, reason: collision with root package name */
    public final Context f2515b;

    /* renamed from: d, reason: collision with root package name */
    public MediaPlayer f2517d;

    /* renamed from: a, reason: collision with root package name */
    public final String f2514a = b.class.getName();

    /* renamed from: c, reason: collision with root package name */
    public final a f2516c = new AudioManager.OnAudioFocusChangeListener() { // from class: r0.a
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int i2) {
            b bVar = this.f2512a;
            bVar.getClass();
            Log.d(bVar.f2514a, "onAudioFocusChange, i = " + i2);
        }
    };

    /* JADX WARN: Type inference failed for: r0v2, types: [r0.a] */
    public b(Context context) {
        this.f2515b = context;
    }

    public static b a(Context context) {
        if (f2513e == null) {
            synchronized (b.class) {
                try {
                    if (f2513e == null) {
                        f2513e = new b(context);
                    }
                } finally {
                }
            }
        }
        return f2513e;
    }
}
