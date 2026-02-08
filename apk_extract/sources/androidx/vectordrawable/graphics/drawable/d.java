package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class d implements Drawable.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f1130a;

    public d(g gVar) {
        this.f1130a = gVar;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        this.f1130a.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        this.f1130a.scheduleSelf(runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.f1130a.unscheduleSelf(runnable);
    }
}
