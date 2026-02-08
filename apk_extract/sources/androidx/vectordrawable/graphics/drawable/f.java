package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class f extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    public final Drawable.ConstantState f1135a;

    public f(Drawable.ConstantState constantState) {
        this.f1135a = constantState;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final boolean canApplyTheme() {
        return this.f1135a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return this.f1135a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        g gVar = new g(null);
        Drawable drawableNewDrawable = this.f1135a.newDrawable();
        gVar.f1141a = drawableNewDrawable;
        drawableNewDrawable.setCallback(gVar.f1140f);
        return gVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        g gVar = new g(null);
        Drawable drawableNewDrawable = this.f1135a.newDrawable(resources);
        gVar.f1141a = drawableNewDrawable;
        drawableNewDrawable.setCallback(gVar.f1140f);
        return gVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
        g gVar = new g(null);
        Drawable drawableNewDrawable = this.f1135a.newDrawable(resources, theme);
        gVar.f1141a = drawableNewDrawable;
        drawableNewDrawable.setCallback(gVar.f1140f);
        return gVar;
    }
}
