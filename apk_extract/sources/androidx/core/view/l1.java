package androidx.core.view;

import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class l1 {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f184a;

    public l1(View view) {
        this.f184a = new WeakReference(view);
    }

    public final void a(float f2) {
        View view = (View) this.f184a.get();
        if (view != null) {
            view.animate().alpha(f2);
        }
    }

    public final void b() {
        View view = (View) this.f184a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void c(long j2) {
        View view = (View) this.f184a.get();
        if (view != null) {
            view.animate().setDuration(j2);
        }
    }

    public final void d(m1 m1Var) {
        View view = (View) this.f184a.get();
        if (view != null) {
            if (m1Var != null) {
                view.animate().setListener(new j1(this, m1Var, view, 0));
            } else {
                view.animate().setListener(null);
            }
        }
    }

    public final void e(float f2) {
        View view = (View) this.f184a.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
    }
}
