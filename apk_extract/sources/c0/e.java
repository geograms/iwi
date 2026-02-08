package c0;

import android.content.Context;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1225a;

    /* renamed from: b, reason: collision with root package name */
    public String f1226b;

    /* renamed from: c, reason: collision with root package name */
    public d f1227c;

    public e(Context context) {
        x0.g.u(context, "context");
        this.f1225a = context;
    }

    public final f a() {
        d dVar = this.f1227c;
        if (dVar != null) {
            return new f(this.f1225a, this.f1226b, dVar);
        }
        throw new IllegalArgumentException("Must set a callback to create the configuration.".toString());
    }
}
