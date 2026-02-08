package androidx.transition;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class n0 extends v {
    public static final int MODE_IN = 1;
    public static final int MODE_OUT = 2;
    private static final String PROPNAME_SCREEN_LOCATION = "android:visibility:screenLocation";
    private int mMode = 3;
    static final String PROPNAME_VISIBILITY = "android:visibility:visibility";
    private static final String PROPNAME_PARENT = "android:visibility:parent";
    private static final String[] sTransitionProperties = {PROPNAME_VISIBILITY, PROPNAME_PARENT};

    public static void e(c0 c0Var) {
        int visibility = c0Var.f1054b.getVisibility();
        HashMap map = c0Var.f1053a;
        map.put(PROPNAME_VISIBILITY, Integer.valueOf(visibility));
        map.put(PROPNAME_PARENT, c0Var.f1054b.getParent());
        int[] iArr = new int[2];
        c0Var.f1054b.getLocationOnScreen(iArr);
        map.put(PROPNAME_SCREEN_LOCATION, iArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.transition.m0 f(androidx.transition.c0 r8, androidx.transition.c0 r9) {
        /*
            androidx.transition.m0 r0 = new androidx.transition.m0
            r0.<init>()
            r1 = 0
            r0.f1100a = r1
            r0.f1101b = r1
            r2 = 0
            r3 = -1
            java.lang.String r4 = "android:visibility:parent"
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L2f
            java.util.HashMap r6 = r8.f1053a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L2f
            java.lang.Object r7 = r6.get(r5)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r0.f1102c = r7
            java.lang.Object r6 = r6.get(r4)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.f1104e = r6
            goto L33
        L2f:
            r0.f1102c = r3
            r0.f1104e = r2
        L33:
            if (r9 == 0) goto L52
            java.util.HashMap r6 = r9.f1053a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L52
            java.lang.Object r2 = r6.get(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r0.f1103d = r2
            java.lang.Object r2 = r6.get(r4)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f1105f = r2
            goto L56
        L52:
            r0.f1103d = r3
            r0.f1105f = r2
        L56:
            r2 = 1
            if (r8 == 0) goto L8a
            if (r9 == 0) goto L8a
            int r8 = r0.f1102c
            int r9 = r0.f1103d
            if (r8 != r9) goto L68
            android.view.ViewGroup r3 = r0.f1104e
            android.view.ViewGroup r4 = r0.f1105f
            if (r3 != r4) goto L68
            return r0
        L68:
            if (r8 == r9) goto L78
            if (r8 != 0) goto L71
            r0.f1101b = r1
            r0.f1100a = r2
            goto L9f
        L71:
            if (r9 != 0) goto L9f
            r0.f1101b = r2
            r0.f1100a = r2
            goto L9f
        L78:
            android.view.ViewGroup r8 = r0.f1105f
            if (r8 != 0) goto L81
            r0.f1101b = r1
            r0.f1100a = r2
            goto L9f
        L81:
            android.view.ViewGroup r8 = r0.f1104e
            if (r8 != 0) goto L9f
            r0.f1101b = r2
            r0.f1100a = r2
            goto L9f
        L8a:
            if (r8 != 0) goto L95
            int r8 = r0.f1103d
            if (r8 != 0) goto L95
            r0.f1101b = r2
            r0.f1100a = r2
            goto L9f
        L95:
            if (r9 != 0) goto L9f
            int r8 = r0.f1102c
            if (r8 != 0) goto L9f
            r0.f1101b = r1
            r0.f1100a = r2
        L9f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.n0.f(androidx.transition.c0, androidx.transition.c0):androidx.transition.m0");
    }

    @Override // androidx.transition.v
    public void captureEndValues(c0 c0Var) {
        e(c0Var);
    }

    @Override // androidx.transition.v
    public void captureStartValues(c0 c0Var) {
        e(c0Var);
    }

    @Override // androidx.transition.v
    public Animator createAnimator(ViewGroup viewGroup, c0 c0Var, c0 c0Var2) {
        m0 m0VarF = f(c0Var, c0Var2);
        if (!m0VarF.f1100a) {
            return null;
        }
        if (m0VarF.f1104e == null && m0VarF.f1105f == null) {
            return null;
        }
        return m0VarF.f1101b ? onAppear(viewGroup, c0Var, m0VarF.f1102c, c0Var2, m0VarF.f1103d) : onDisappear(viewGroup, c0Var, m0VarF.f1102c, c0Var2, m0VarF.f1103d);
    }

    public int getMode() {
        return this.mMode;
    }

    @Override // androidx.transition.v
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    @Override // androidx.transition.v
    public boolean isTransitionRequired(c0 c0Var, c0 c0Var2) {
        if (c0Var == null && c0Var2 == null) {
            return false;
        }
        if (c0Var != null && c0Var2 != null && c0Var2.f1053a.containsKey(PROPNAME_VISIBILITY) != c0Var.f1053a.containsKey(PROPNAME_VISIBILITY)) {
            return false;
        }
        m0 m0VarF = f(c0Var, c0Var2);
        if (m0VarF.f1100a) {
            return m0VarF.f1102c == 0 || m0VarF.f1103d == 0;
        }
        return false;
    }

    public boolean isVisible(c0 c0Var) {
        if (c0Var == null) {
            return false;
        }
        HashMap map = c0Var.f1053a;
        return ((Integer) map.get(PROPNAME_VISIBILITY)).intValue() == 0 && ((View) map.get(PROPNAME_PARENT)) != null;
    }

    public abstract Animator onAppear(ViewGroup viewGroup, View view, c0 c0Var, c0 c0Var2);

    public Animator onAppear(ViewGroup viewGroup, c0 c0Var, int i2, c0 c0Var2, int i3) {
        if ((this.mMode & 1) != 1 || c0Var2 == null) {
            return null;
        }
        if (c0Var == null) {
            View view = (View) c0Var2.f1054b.getParent();
            if (f(getMatchedTransitionValues(view, false), getTransitionValues(view, false)).f1100a) {
                return null;
            }
        }
        return onAppear(viewGroup, c0Var2.f1054b, c0Var, c0Var2);
    }

    public abstract Animator onDisappear(ViewGroup viewGroup, View view, c0 c0Var, c0 c0Var2);

    /* JADX WARN: Removed duplicated region for block: B:23:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x018f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.animation.Animator onDisappear(android.view.ViewGroup r19, androidx.transition.c0 r20, int r21, androidx.transition.c0 r22, int r23) {
        /*
            Method dump skipped, instructions count: 537
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.n0.onDisappear(android.view.ViewGroup, androidx.transition.c0, int, androidx.transition.c0, int):android.animation.Animator");
    }

    public void setMode(int i2) {
        if ((i2 & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.mMode = i2;
    }
}
