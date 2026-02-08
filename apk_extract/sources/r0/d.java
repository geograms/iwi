package r0;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f2520a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f2521b;

    /* renamed from: c, reason: collision with root package name */
    public final a.b f2522c;

    /* renamed from: d, reason: collision with root package name */
    public final HandlerThread f2523d;

    public d(Context context, Handler handler) {
        this.f2522c = null;
        this.f2523d = null;
        this.f2521b = context;
        this.f2520a = handler;
        HandlerThread handlerThread = new HandlerThread("work-handlerthread");
        this.f2523d = handlerThread;
        handlerThread.start();
        this.f2522c = new a.b(this, this.f2523d.getLooper(), 6);
    }
}
