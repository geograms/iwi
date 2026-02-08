package androidx.activity;

import androidx.fragment.app.o0;
import java.util.ArrayDeque;

/* loaded from: classes.dex */
public final class j implements a {

    /* renamed from: a, reason: collision with root package name */
    public final o0 f29a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f30b;

    public j(k kVar, o0 o0Var) {
        this.f30b = kVar;
        this.f29a = o0Var;
    }

    @Override // androidx.activity.a
    public final void cancel() {
        ArrayDeque arrayDeque = this.f30b.f32b;
        o0 o0Var = this.f29a;
        arrayDeque.remove(o0Var);
        o0Var.f579b.remove(this);
    }
}
