package androidx.dynamicanimation.animation;

import android.view.Choreographer;

/* loaded from: classes.dex */
public final class c extends p.g {

    /* renamed from: b, reason: collision with root package name */
    public final Choreographer f317b;

    /* renamed from: c, reason: collision with root package name */
    public final b f318c;

    public c(k.j jVar) {
        super(jVar);
        this.f317b = Choreographer.getInstance();
        this.f318c = new b(this);
    }

    public final void c() {
        this.f317b.postFrameCallback(this.f318c);
    }
}
