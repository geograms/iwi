package androidx.fragment.app;

import android.animation.Animator;
import android.view.animation.Animation;

/* loaded from: classes.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public final Animation f499a;

    /* renamed from: b, reason: collision with root package name */
    public final Animator f500b;

    public f0(Animation animation) {
        this.f499a = animation;
        this.f500b = null;
    }

    public f0(Animator animator) {
        this.f499a = null;
        this.f500b = animator;
    }
}
