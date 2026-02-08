package androidx.fragment.app;

import android.content.Context;

/* loaded from: classes.dex */
public final class i extends j {

    /* renamed from: c, reason: collision with root package name */
    public boolean f538c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f539d;

    /* renamed from: e, reason: collision with root package name */
    public f0 f540e;

    public final f0 c(Context context) {
        if (this.f539d) {
            return this.f540e;
        }
        u1 u1Var = this.f545a;
        f0 f0VarA = h0.a(context, u1Var.f618c, u1Var.f616a == 2, this.f538c);
        this.f540e = f0VarA;
        this.f539d = true;
        return f0VarA;
    }
}
