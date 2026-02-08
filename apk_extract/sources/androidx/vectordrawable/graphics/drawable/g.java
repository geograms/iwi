package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.transition.r;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public final class g extends h implements Animatable {

    /* renamed from: c, reason: collision with root package name */
    public final Context f1137c;

    /* renamed from: d, reason: collision with root package name */
    public r f1138d = null;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f1139e = null;

    /* renamed from: f, reason: collision with root package name */
    public final d f1140f = new d(this);

    /* renamed from: b, reason: collision with root package name */
    public final e f1136b = new e();

    public g(Context context) {
        this.f1137c = context;
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            l.b.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            return l.b.b(drawable);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        e eVar = this.f1136b;
        eVar.f1131a.draw(canvas);
        if (eVar.f1132b.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f1141a;
        return drawable != null ? l.a.a(drawable) : this.f1136b.f1131a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        int changingConfigurations = super.getChangingConfigurations();
        this.f1136b.getClass();
        return changingConfigurations | 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f1141a;
        return drawable != null ? l.b.c(drawable) : this.f1136b.f1131a.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f1141a != null) {
            return new f(this.f1141a.getConstantState());
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f1141a;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f1136b.f1131a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f1141a;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f1136b.f1131a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f1141a;
        return drawable != null ? drawable.getOpacity() : this.f1136b.f1131a.getOpacity();
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ca, code lost:
    
        if (r3.f1132b != null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00cc, code lost:
    
        r3.f1132b = new android.animation.AnimatorSet();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d3, code lost:
    
        r3.f1132b.playTogether(r3.f1133c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00da, code lost:
    
        return;
     */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void inflate(android.content.res.Resources r10, org.xmlpull.v1.XmlPullParser r11, android.util.AttributeSet r12, android.content.res.Resources.Theme r13) {
        /*
            r9 = this;
            android.graphics.drawable.Drawable r0 = r9.f1141a
            if (r0 == 0) goto L8
            l.b.d(r0, r10, r11, r12, r13)
            return
        L8:
            int r0 = r11.getEventType()
            int r1 = r11.getDepth()
            r2 = 1
            int r1 = r1 + r2
        L12:
            androidx.vectordrawable.graphics.drawable.e r3 = r9.f1136b
            if (r0 == r2) goto Lc8
            int r4 = r11.getDepth()
            if (r4 >= r1) goto L1f
            r4 = 3
            if (r0 == r4) goto Lc8
        L1f:
            r4 = 2
            if (r0 != r4) goto Lc2
            java.lang.String r0 = r11.getName()
            java.lang.String r4 = "animated-vector"
            boolean r4 = r4.equals(r0)
            r5 = 0
            r6 = 0
            if (r4 == 0) goto L68
            int[] r0 = androidx.vectordrawable.graphics.drawable.a.f1127e
            android.content.res.TypedArray r0 = x0.g.d0(r10, r13, r12, r0)
            int r4 = r0.getResourceId(r6, r6)
            if (r4 == 0) goto L64
            androidx.vectordrawable.graphics.drawable.q r7 = new androidx.vectordrawable.graphics.drawable.q
            r7.<init>()
            java.lang.ThreadLocal r8 = j.r.f1879a
            android.graphics.drawable.Drawable r4 = j.j.a(r10, r4, r13)
            r7.f1141a = r4
            androidx.vectordrawable.graphics.drawable.p r4 = new androidx.vectordrawable.graphics.drawable.p
            android.graphics.drawable.Drawable r8 = r7.f1141a
            android.graphics.drawable.Drawable$ConstantState r8 = r8.getConstantState()
            r4.<init>(r8)
            r7.f1203f = r6
            androidx.vectordrawable.graphics.drawable.d r4 = r9.f1140f
            r7.setCallback(r4)
            androidx.vectordrawable.graphics.drawable.q r4 = r3.f1131a
            if (r4 == 0) goto L62
            r4.setCallback(r5)
        L62:
            r3.f1131a = r7
        L64:
            r0.recycle()
            goto Lc2
        L68:
            java.lang.String r4 = "target"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lc2
            int[] r0 = androidx.vectordrawable.graphics.drawable.a.f1128f
            android.content.res.TypedArray r0 = r10.obtainAttributes(r12, r0)
            java.lang.String r4 = r0.getString(r6)
            int r6 = r0.getResourceId(r2, r6)
            if (r6 == 0) goto Lbf
            android.content.Context r7 = r9.f1137c
            if (r7 == 0) goto Lb4
            android.animation.Animator r6 = android.animation.AnimatorInflater.loadAnimator(r7, r6)
            androidx.vectordrawable.graphics.drawable.q r7 = r3.f1131a
            androidx.vectordrawable.graphics.drawable.o r7 = r7.f1199b
            androidx.vectordrawable.graphics.drawable.n r7 = r7.f1186b
            g.b r7 = r7.f1184o
            java.lang.Object r5 = r7.getOrDefault(r4, r5)
            r6.setTarget(r5)
            java.util.ArrayList r5 = r3.f1133c
            if (r5 != 0) goto La9
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r3.f1133c = r5
            g.b r5 = new g.b
            r5.<init>()
            r3.f1134d = r5
        La9:
            java.util.ArrayList r5 = r3.f1133c
            r5.add(r6)
            g.b r3 = r3.f1134d
            r3.put(r6, r4)
            goto Lbf
        Lb4:
            r0.recycle()
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Context can't be null when inflating animators"
            r9.<init>(r10)
            throw r9
        Lbf:
            r0.recycle()
        Lc2:
            int r0 = r11.next()
            goto L12
        Lc8:
            android.animation.AnimatorSet r9 = r3.f1132b
            if (r9 != 0) goto Ld3
            android.animation.AnimatorSet r9 = new android.animation.AnimatorSet
            r9.<init>()
            r3.f1132b = r9
        Ld3:
            android.animation.AnimatorSet r9 = r3.f1132b
            java.util.ArrayList r10 = r3.f1133c
            r9.playTogether(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.g.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f1141a;
        return drawable != null ? l.a.d(drawable) : this.f1136b.f1131a.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        Drawable drawable = this.f1141a;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f1136b.f1132b.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.f1141a;
        return drawable != null ? drawable.isStateful() : this.f1136b.f1131a.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f1136b.f1131a.setBounds(rect);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i2) {
        Drawable drawable = this.f1141a;
        return drawable != null ? drawable.setLevel(i2) : this.f1136b.f1131a.setLevel(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f1141a;
        return drawable != null ? drawable.setState(iArr) : this.f1136b.f1131a.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else {
            this.f1136b.f1131a.setAlpha(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z2) {
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            l.a.e(drawable, z2);
        } else {
            this.f1136b.f1131a.setAutoMirrored(z2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f1136b.f1131a.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i2) {
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            x0.g.v0(drawable, i2);
        } else {
            this.f1136b.f1131a.setTint(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            l.b.h(drawable, colorStateList);
        } else {
            this.f1136b.f1131a.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            x0.g.w0(drawable, mode);
        } else {
            this.f1136b.f1131a.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z2, boolean z3) {
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            return drawable.setVisible(z2, z3);
        }
        this.f1136b.f1131a.setVisible(z2, z3);
        return super.setVisible(z2, z3);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
            return;
        }
        e eVar = this.f1136b;
        if (eVar.f1132b.isStarted()) {
            return;
        }
        eVar.f1132b.start();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f1136b.f1132b.end();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
