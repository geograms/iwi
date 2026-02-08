package androidx.activity;

import androidx.fragment.app.o0;
import androidx.fragment.app.w0;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f31a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f32b = new ArrayDeque();

    public k(Runnable runnable) {
        this.f31a = runnable;
    }

    public final void a(LifecycleOwner lifecycleOwner, o0 o0Var) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            return;
        }
        o0Var.f579b.add(new OnBackPressedDispatcher$LifecycleOnBackPressedCancellable(this, lifecycle, o0Var));
    }

    public final void b() {
        Iterator itDescendingIterator = this.f32b.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            o0 o0Var = (o0) itDescendingIterator.next();
            if (o0Var.f578a) {
                w0 w0Var = o0Var.f580c;
                w0Var.s(true);
                if (w0Var.f654h.f578a) {
                    w0Var.G();
                    return;
                } else {
                    w0Var.f653g.b();
                    return;
                }
            }
        }
        Runnable runnable = this.f31a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
