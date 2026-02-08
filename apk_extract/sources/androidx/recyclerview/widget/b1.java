package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: classes.dex */
public final class b1 {

    /* renamed from: a, reason: collision with root package name */
    public int f741a;

    /* renamed from: b, reason: collision with root package name */
    public int f742b;

    public final void a(z1 z1Var) {
        View view = z1Var.itemView;
        this.f741a = view.getLeft();
        this.f742b = view.getTop();
        view.getRight();
        view.getBottom();
    }
}
