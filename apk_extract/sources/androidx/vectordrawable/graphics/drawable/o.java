package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class o extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    public int f1185a;

    /* renamed from: b, reason: collision with root package name */
    public n f1186b;

    /* renamed from: c, reason: collision with root package name */
    public ColorStateList f1187c;

    /* renamed from: d, reason: collision with root package name */
    public PorterDuff.Mode f1188d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1189e;

    /* renamed from: f, reason: collision with root package name */
    public Bitmap f1190f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f1191g;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f1192h;

    /* renamed from: i, reason: collision with root package name */
    public int f1193i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1194j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1195k;

    /* renamed from: l, reason: collision with root package name */
    public Paint f1196l;

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.f1185a;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new q(this);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        return new q(this);
    }
}
