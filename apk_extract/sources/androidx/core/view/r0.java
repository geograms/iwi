package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class r0 implements View.OnApplyWindowInsetsListener {

    /* renamed from: a, reason: collision with root package name */
    public n2 f195a = null;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f196b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c0 f197c;

    public r0(View view, c0 c0Var) {
        this.f196b = view;
        this.f197c = c0Var;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        n2 n2VarG = n2.g(view, windowInsets);
        int i2 = Build.VERSION.SDK_INT;
        c0 c0Var = this.f197c;
        if (i2 < 30) {
            s0.a(windowInsets, this.f196b);
            if (n2VarG.equals(this.f195a)) {
                return c0Var.onApplyWindowInsets(view, n2VarG).f();
            }
        }
        this.f195a = n2VarG;
        n2 n2VarOnApplyWindowInsets = c0Var.onApplyWindowInsets(view, n2VarG);
        if (i2 >= 30) {
            return n2VarOnApplyWindowInsets.f();
        }
        WeakHashMap weakHashMap = d1.f138a;
        q0.c(view);
        return n2VarOnApplyWindowInsets.f();
    }
}
