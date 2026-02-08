package androidx.core.view;

import android.view.WindowInsetsAnimation;

/* loaded from: classes.dex */
public final class r1 {

    /* renamed from: a, reason: collision with root package name */
    public final k.f f198a;

    /* renamed from: b, reason: collision with root package name */
    public final k.f f199b;

    public r1(k.f fVar, k.f fVar2) {
        this.f198a = fVar;
        this.f199b = fVar2;
    }

    public final String toString() {
        return "Bounds{lower=" + this.f198a + " upper=" + this.f199b + "}";
    }

    public r1(WindowInsetsAnimation.Bounds bounds) {
        this.f198a = k.f.c(bounds.getLowerBound());
        this.f199b = k.f.c(bounds.getUpperBound());
    }
}
