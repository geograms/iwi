package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public abstract class c {
    Animatable2.AnimationCallback mPlatformCallback;

    public Animatable2.AnimationCallback getPlatformCallback() {
        if (this.mPlatformCallback == null) {
            this.mPlatformCallback = new b(this);
        }
        return this.mPlatformCallback;
    }

    public abstract void onAnimationEnd(Drawable drawable);

    public void onAnimationStart(Drawable drawable) {
    }
}
