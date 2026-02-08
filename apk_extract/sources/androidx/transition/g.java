package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.d1;
import java.util.HashMap;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class g extends v {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f1070a = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: b, reason: collision with root package name */
    public static final c f1071b;

    /* renamed from: c, reason: collision with root package name */
    public static final c f1072c;

    /* renamed from: d, reason: collision with root package name */
    public static final c f1073d;

    /* renamed from: e, reason: collision with root package name */
    public static final c f1074e;

    /* renamed from: f, reason: collision with root package name */
    public static final c f1075f;

    static {
        new b(PointF.class, "boundsOrigin").f1046a = new Rect();
        f1071b = new c(PointF.class, "topLeft", 0);
        f1072c = new c(PointF.class, "bottomRight", 1);
        f1073d = new c(PointF.class, "bottomRight", 2);
        f1074e = new c(PointF.class, "topLeft", 3);
        f1075f = new c(PointF.class, "position", 4);
    }

    public static void e(c0 c0Var) {
        View view = c0Var.f1054b;
        WeakHashMap weakHashMap = d1.f138a;
        if (!androidx.core.view.p0.c(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        HashMap map = c0Var.f1053a;
        map.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        map.put("android:changeBounds:parent", c0Var.f1054b.getParent());
    }

    @Override // androidx.transition.v
    public final void captureEndValues(c0 c0Var) {
        e(c0Var);
    }

    @Override // androidx.transition.v
    public final void captureStartValues(c0 c0Var) {
        e(c0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.transition.v
    public final Animator createAnimator(ViewGroup viewGroup, c0 c0Var, c0 c0Var2) {
        int i2;
        ObjectAnimator objectAnimatorOfObject;
        if (c0Var == null || c0Var2 == null) {
            return null;
        }
        HashMap map = c0Var.f1053a;
        HashMap map2 = c0Var2.f1053a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view = c0Var2.f1054b;
        Rect rect = (Rect) map.get("android:changeBounds:bounds");
        Rect rect2 = (Rect) map2.get("android:changeBounds:bounds");
        int i3 = rect.left;
        int i4 = rect2.left;
        int i5 = rect.top;
        int i6 = rect2.top;
        int i7 = rect.right;
        int i8 = rect2.right;
        int i9 = rect.bottom;
        int i10 = rect2.bottom;
        int i11 = i7 - i3;
        int i12 = i9 - i5;
        int i13 = i8 - i4;
        int i14 = i10 - i6;
        Rect rect3 = (Rect) map.get("android:changeBounds:clip");
        Rect rect4 = (Rect) map2.get("android:changeBounds:clip");
        if ((i11 == 0 || i12 == 0) && (i13 == 0 || i14 == 0)) {
            i2 = 0;
        } else {
            i2 = (i3 == i4 && i5 == i6) ? 0 : 1;
            if (i7 != i8 || i9 != i10) {
                i2++;
            }
        }
        if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
            i2++;
        }
        int i15 = i2;
        if (i15 <= 0) {
            return null;
        }
        c cVar = e0.f1062a;
        view.setLeftTopRightBottom(i3, i5, i7, i9);
        if (i15 != 2) {
            objectAnimatorOfObject = (i3 == i4 && i5 == i6) ? ObjectAnimator.ofObject(view, f1073d, (TypeConverter) null, getPathMotion().getPath(i7, i9, i8, i10)) : ObjectAnimator.ofObject(view, f1074e, (TypeConverter) null, getPathMotion().getPath(i3, i5, i4, i6));
        } else if (i11 == i13 && i12 == i14) {
            objectAnimatorOfObject = ObjectAnimator.ofObject(view, f1075f, (TypeConverter) null, getPathMotion().getPath(i3, i5, i4, i6));
        } else {
            f fVar = new f();
            fVar.f1067e = view;
            ObjectAnimator objectAnimatorOfObject2 = ObjectAnimator.ofObject(fVar, f1071b, (TypeConverter) null, getPathMotion().getPath(i3, i5, i4, i6));
            ObjectAnimator objectAnimatorOfObject3 = ObjectAnimator.ofObject(fVar, f1072c, (TypeConverter) null, getPathMotion().getPath(i7, i9, i8, i10));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimatorOfObject2, objectAnimatorOfObject3);
            animatorSet.addListener(new d(fVar));
            objectAnimatorOfObject = animatorSet;
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            viewGroup4.suppressLayout(true);
            addListener(new e(viewGroup4));
        }
        return objectAnimatorOfObject;
    }

    @Override // androidx.transition.v
    public final String[] getTransitionProperties() {
        return f1070a;
    }
}
