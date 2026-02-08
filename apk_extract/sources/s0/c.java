package s0;

import android.animation.Animator;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import java.util.Objects;

/* loaded from: classes.dex */
public final class c implements Animator.AnimatorListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Dialog f2524a;

    public c(Dialog dialog) {
        this.f2524a = dialog;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f2524a.dismiss();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        Handler handler = new Handler(Looper.getMainLooper());
        Dialog dialog = this.f2524a;
        Objects.requireNonNull(dialog);
        handler.postDelayed(new androidx.activity.b(8, dialog), 1000L);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
