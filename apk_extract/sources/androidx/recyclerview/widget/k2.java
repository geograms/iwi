package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: classes.dex */
public final class k2 {

    /* renamed from: a, reason: collision with root package name */
    public final j2 f872a;

    /* renamed from: b, reason: collision with root package name */
    public final i2 f873b;

    public k2(e1 e1Var) {
        this.f872a = e1Var;
        i2 i2Var = new i2();
        i2Var.f856a = 0;
        this.f873b = i2Var;
    }

    public final View a(int i2, int i3, int i4, int i5) {
        int paddingLeft;
        int width;
        int paddingRight;
        View childAt;
        e1 e1Var = (e1) this.f872a;
        int i6 = e1Var.f777a;
        h1 h1Var = e1Var.f778b;
        switch (i6) {
            case 0:
                paddingLeft = h1Var.getPaddingLeft();
                break;
            default:
                paddingLeft = h1Var.getPaddingTop();
                break;
        }
        int i7 = e1Var.f777a;
        h1 h1Var2 = e1Var.f778b;
        switch (i7) {
            case 0:
                width = h1Var2.getWidth();
                paddingRight = h1Var2.getPaddingRight();
                break;
            default:
                width = h1Var2.getHeight();
                paddingRight = h1Var2.getPaddingBottom();
                break;
        }
        int i8 = width - paddingRight;
        int i9 = i3 > i2 ? 1 : -1;
        View view = null;
        while (i2 != i3) {
            int i10 = e1Var.f777a;
            h1 h1Var3 = e1Var.f778b;
            switch (i10) {
                case 0:
                    childAt = h1Var3.getChildAt(i2);
                    break;
                default:
                    childAt = h1Var3.getChildAt(i2);
                    break;
            }
            int iB = e1Var.b(childAt);
            int iA = e1Var.a(childAt);
            i2 i2Var = this.f873b;
            i2Var.f857b = paddingLeft;
            i2Var.f858c = i8;
            i2Var.f859d = iB;
            i2Var.f860e = iA;
            if (i4 != 0) {
                i2Var.f856a = i4;
                if (i2Var.a()) {
                    return childAt;
                }
            }
            if (i5 != 0) {
                i2Var.f856a = i5;
                if (i2Var.a()) {
                    view = childAt;
                }
            }
            i2 += i9;
        }
        return view;
    }

    public final boolean b(View view) {
        int paddingLeft;
        int width;
        int paddingRight;
        e1 e1Var = (e1) this.f872a;
        int i2 = e1Var.f777a;
        h1 h1Var = e1Var.f778b;
        switch (i2) {
            case 0:
                paddingLeft = h1Var.getPaddingLeft();
                break;
            default:
                paddingLeft = h1Var.getPaddingTop();
                break;
        }
        int i3 = e1Var.f777a;
        h1 h1Var2 = e1Var.f778b;
        switch (i3) {
            case 0:
                width = h1Var2.getWidth();
                paddingRight = h1Var2.getPaddingRight();
                break;
            default:
                width = h1Var2.getHeight();
                paddingRight = h1Var2.getPaddingBottom();
                break;
        }
        int i4 = width - paddingRight;
        int iB = e1Var.b(view);
        int iA = e1Var.a(view);
        i2 i2Var = this.f873b;
        i2Var.f857b = paddingLeft;
        i2Var.f858c = i4;
        i2Var.f859d = iB;
        i2Var.f860e = iA;
        i2Var.f856a = 24579;
        return i2Var.a();
    }
}
