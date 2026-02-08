package o0;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.chamsion.quickchat.ui.MainActivity;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f2247a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f2248b;

    /* renamed from: c, reason: collision with root package name */
    public final a f2249c;

    /* renamed from: d, reason: collision with root package name */
    public final a.b f2250d;

    /* renamed from: e, reason: collision with root package name */
    public final HandlerThread f2251e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f2252f = new Object();

    /* renamed from: g, reason: collision with root package name */
    public int f2253g = -1;

    /* renamed from: h, reason: collision with root package name */
    public int f2254h = 0;

    /* renamed from: i, reason: collision with root package name */
    public long f2255i = 0;

    public c(MainActivity mainActivity, Handler handler, a aVar) {
        this.f2250d = null;
        this.f2251e = null;
        this.f2248b = mainActivity;
        this.f2247a = handler;
        this.f2249c = aVar;
        HandlerThread handlerThread = new HandlerThread("work-handlerthread");
        this.f2251e = handlerThread;
        handlerThread.start();
        this.f2250d = new a.b(this, this.f2251e.getLooper(), 2);
    }
}
