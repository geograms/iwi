package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;

/* loaded from: classes.dex */
public final class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q1 f504a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f505b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Rect f506c;

    public g(q1 q1Var, View view, Rect rect) {
        this.f504a = q1Var;
        this.f505b = view;
        this.f506c = rect;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f504a.getClass();
        q1.g(this.f505b, this.f506c);
    }
}
