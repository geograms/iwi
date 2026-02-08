package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
public final class f0 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final View f143a;

    /* renamed from: b, reason: collision with root package name */
    public ViewTreeObserver f144b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f145c;

    public f0(View view, Runnable runnable) {
        this.f143a = view;
        this.f144b = view.getViewTreeObserver();
        this.f145c = runnable;
    }

    public static void a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        f0 f0Var = new f0(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(f0Var);
        view.addOnAttachStateChangeListener(f0Var);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        boolean zIsAlive = this.f144b.isAlive();
        View view = this.f143a;
        if (zIsAlive) {
            this.f144b.removeOnPreDrawListener(this);
        } else {
            view.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view.removeOnAttachStateChangeListener(this);
        this.f145c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.f144b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        boolean zIsAlive = this.f144b.isAlive();
        View view2 = this.f143a;
        if (zIsAlive) {
            this.f144b.removeOnPreDrawListener(this);
        } else {
            view2.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view2.removeOnAttachStateChangeListener(this);
    }
}
