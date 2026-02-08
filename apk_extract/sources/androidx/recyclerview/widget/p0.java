package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class p0 extends q0 {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f924d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p0(h1 h1Var, int i2) {
        super(h1Var);
        this.f924d = i2;
    }

    @Override // androidx.recyclerview.widget.q0
    public final int b(View view) {
        int i2 = this.f924d;
        h1 h1Var = this.f940a;
        switch (i2) {
            case 0:
                return h1Var.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((i1) view.getLayoutParams())).rightMargin;
            default:
                return h1Var.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((i1) view.getLayoutParams())).bottomMargin;
        }
    }

    @Override // androidx.recyclerview.widget.q0
    public final int c(View view) {
        int i2 = this.f924d;
        h1 h1Var = this.f940a;
        switch (i2) {
            case 0:
                i1 i1Var = (i1) view.getLayoutParams();
                return h1Var.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) i1Var).leftMargin + ((ViewGroup.MarginLayoutParams) i1Var).rightMargin;
            default:
                i1 i1Var2 = (i1) view.getLayoutParams();
                return h1Var.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) i1Var2).topMargin + ((ViewGroup.MarginLayoutParams) i1Var2).bottomMargin;
        }
    }

    @Override // androidx.recyclerview.widget.q0
    public final int d(View view) {
        int i2 = this.f924d;
        h1 h1Var = this.f940a;
        switch (i2) {
            case 0:
                i1 i1Var = (i1) view.getLayoutParams();
                return h1Var.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) i1Var).topMargin + ((ViewGroup.MarginLayoutParams) i1Var).bottomMargin;
            default:
                i1 i1Var2 = (i1) view.getLayoutParams();
                return h1Var.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) i1Var2).leftMargin + ((ViewGroup.MarginLayoutParams) i1Var2).rightMargin;
        }
    }

    @Override // androidx.recyclerview.widget.q0
    public final int e(View view) {
        int i2 = this.f924d;
        h1 h1Var = this.f940a;
        switch (i2) {
            case 0:
                return h1Var.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((i1) view.getLayoutParams())).leftMargin;
            default:
                return h1Var.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((i1) view.getLayoutParams())).topMargin;
        }
    }

    @Override // androidx.recyclerview.widget.q0
    public final int f() {
        int i2 = this.f924d;
        h1 h1Var = this.f940a;
        switch (i2) {
            case 0:
                return h1Var.getWidth() - h1Var.getPaddingRight();
            default:
                return h1Var.getHeight() - h1Var.getPaddingBottom();
        }
    }

    @Override // androidx.recyclerview.widget.q0
    public final int g() {
        int i2 = this.f924d;
        h1 h1Var = this.f940a;
        switch (i2) {
            case 0:
                return h1Var.getWidthMode();
            default:
                return h1Var.getHeightMode();
        }
    }

    @Override // androidx.recyclerview.widget.q0
    public final int h() {
        int i2 = this.f924d;
        h1 h1Var = this.f940a;
        switch (i2) {
            case 0:
                return h1Var.getPaddingLeft();
            default:
                return h1Var.getPaddingTop();
        }
    }

    @Override // androidx.recyclerview.widget.q0
    public final int i() {
        int i2 = this.f924d;
        h1 h1Var = this.f940a;
        switch (i2) {
            case 0:
                return (h1Var.getWidth() - h1Var.getPaddingLeft()) - h1Var.getPaddingRight();
            default:
                return (h1Var.getHeight() - h1Var.getPaddingTop()) - h1Var.getPaddingBottom();
        }
    }

    @Override // androidx.recyclerview.widget.q0
    public final int k(View view) {
        int i2 = this.f924d;
        Rect rect = this.f942c;
        h1 h1Var = this.f940a;
        switch (i2) {
            case 0:
                h1Var.getTransformedBoundingBox(view, true, rect);
                return rect.right;
            default:
                h1Var.getTransformedBoundingBox(view, true, rect);
                return rect.bottom;
        }
    }

    @Override // androidx.recyclerview.widget.q0
    public final int l(View view) {
        int i2 = this.f924d;
        Rect rect = this.f942c;
        h1 h1Var = this.f940a;
        switch (i2) {
            case 0:
                h1Var.getTransformedBoundingBox(view, true, rect);
                return rect.left;
            default:
                h1Var.getTransformedBoundingBox(view, true, rect);
                return rect.top;
        }
    }

    @Override // androidx.recyclerview.widget.q0
    public final void m(int i2) {
        int i3 = this.f924d;
        h1 h1Var = this.f940a;
        switch (i3) {
            case 0:
                h1Var.offsetChildrenHorizontal(i2);
                break;
            default:
                h1Var.offsetChildrenVertical(i2);
                break;
        }
    }
}
