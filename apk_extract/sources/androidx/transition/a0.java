package androidx.transition;

/* loaded from: classes.dex */
public final class a0 extends w {

    /* renamed from: a, reason: collision with root package name */
    public b0 f1045a;

    @Override // androidx.transition.u
    public final void onTransitionEnd(v vVar) {
        b0 b0Var = this.f1045a;
        int i2 = b0Var.f1049c - 1;
        b0Var.f1049c = i2;
        if (i2 == 0) {
            b0Var.f1050d = false;
            b0Var.end();
        }
        vVar.removeListener(this);
    }

    @Override // androidx.transition.w, androidx.transition.u
    public final void onTransitionStart(v vVar) {
        b0 b0Var = this.f1045a;
        if (b0Var.f1050d) {
            return;
        }
        b0Var.start();
        b0Var.f1050d = true;
    }
}
