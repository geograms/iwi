package t;

import android.content.ClipDescription;
import android.net.Uri;
import java.util.concurrent.Executor;
import x0.g;

/* loaded from: classes.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2549a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2550b;

    public c(Executor executor, g gVar) {
        this.f2549a = executor;
        this.f2550b = gVar;
    }

    @Override // t.d
    public final void a() {
    }

    @Override // t.d
    public final Uri c() {
        return (Uri) this.f2549a;
    }

    @Override // t.d
    public final ClipDescription i() {
        return (ClipDescription) this.f2550b;
    }

    @Override // t.d
    public final Object j() {
        return null;
    }

    @Override // t.d
    public final Uri k() {
        return null;
    }
}
