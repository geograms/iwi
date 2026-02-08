package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.fragment.R$animator;
import androidx.fragment.R$id;

/* loaded from: classes.dex */
public abstract class h0 {
    public static f0 a(Context context, Fragment fragment, boolean z2, boolean z3) {
        int nextTransition = fragment.getNextTransition();
        int popEnterAnim = z3 ? z2 ? fragment.getPopEnterAnim() : fragment.getPopExitAnim() : z2 ? fragment.getEnterAnim() : fragment.getExitAnim();
        fragment.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && viewGroup.getTag(R$id.visible_removing_fragment_view_tag) != null) {
            fragment.mContainer.setTag(R$id.visible_removing_fragment_view_tag, null);
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation animationOnCreateAnimation = fragment.onCreateAnimation(nextTransition, z2, popEnterAnim);
        if (animationOnCreateAnimation != null) {
            return new f0(animationOnCreateAnimation);
        }
        Animator animatorOnCreateAnimator = fragment.onCreateAnimator(nextTransition, z2, popEnterAnim);
        if (animatorOnCreateAnimator != null) {
            return new f0(animatorOnCreateAnimator);
        }
        if (popEnterAnim == 0 && nextTransition != 0) {
            popEnterAnim = nextTransition != 4097 ? nextTransition != 4099 ? nextTransition != 8194 ? -1 : z2 ? R$animator.fragment_close_enter : R$animator.fragment_close_exit : z2 ? R$animator.fragment_fade_enter : R$animator.fragment_fade_exit : z2 ? R$animator.fragment_open_enter : R$animator.fragment_open_exit;
        }
        if (popEnterAnim != 0) {
            boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(popEnterAnim));
            if (zEquals) {
                try {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, popEnterAnim);
                    if (animationLoadAnimation != null) {
                        return new f0(animationLoadAnimation);
                    }
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            } else {
                try {
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, popEnterAnim);
                    if (animatorLoadAnimator != null) {
                        return new f0(animatorLoadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (zEquals) {
                        throw e3;
                    }
                    Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, popEnterAnim);
                    if (animationLoadAnimation2 != null) {
                        return new f0(animationLoadAnimation2);
                    }
                }
            }
        }
        return null;
    }
}
