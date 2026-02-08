package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class i1 extends ViewGroup.MarginLayoutParams {

    /* renamed from: a, reason: collision with root package name */
    public z1 f852a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f853b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f854c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f855d;

    public i1(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f853b = new Rect();
        this.f854c = true;
        this.f855d = false;
    }

    public i1(int i2, int i3) {
        super(i2, i3);
        this.f853b = new Rect();
        this.f854c = true;
        this.f855d = false;
    }

    public i1(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f853b = new Rect();
        this.f854c = true;
        this.f855d = false;
    }

    public i1(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f853b = new Rect();
        this.f854c = true;
        this.f855d = false;
    }

    public i1(i1 i1Var) {
        super((ViewGroup.LayoutParams) i1Var);
        this.f853b = new Rect();
        this.f854c = true;
        this.f855d = false;
    }
}
