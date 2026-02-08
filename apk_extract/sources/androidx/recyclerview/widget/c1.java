package androidx.recyclerview.widget;

import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class c1 {

    /* renamed from: a, reason: collision with root package name */
    public a1 f752a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f753b;

    /* renamed from: c, reason: collision with root package name */
    public long f754c;

    /* renamed from: d, reason: collision with root package name */
    public long f755d;

    /* renamed from: e, reason: collision with root package name */
    public long f756e;

    /* renamed from: f, reason: collision with root package name */
    public long f757f;

    public static void b(z1 z1Var) {
        int i2 = z1Var.mFlags;
        if (!z1Var.isInvalid() && (i2 & 4) == 0) {
            z1Var.getOldPosition();
            z1Var.getAdapterPosition();
        }
    }

    public abstract boolean a(z1 z1Var, z1 z1Var2, b1 b1Var, b1 b1Var2);

    public final void c(z1 z1Var) {
        a1 a1Var = this.f752a;
        if (a1Var != null) {
            u0 u0Var = (u0) a1Var;
            u0Var.getClass();
            z1Var.setIsRecyclable(true);
            if (z1Var.mShadowedHolder != null && z1Var.mShadowingHolder == null) {
                z1Var.mShadowedHolder = null;
            }
            z1Var.mShadowingHolder = null;
            if (z1Var.shouldBeKeptAsChild()) {
                return;
            }
            View view = z1Var.itemView;
            RecyclerView recyclerView = u0Var.f972a;
            if (recyclerView.removeAnimatingView(view) || !z1Var.isTmpDetached()) {
                return;
            }
            recyclerView.removeDetachedView(z1Var.itemView, false);
        }
    }

    public abstract void d(z1 z1Var);

    public abstract void e();

    public abstract boolean f();
}
