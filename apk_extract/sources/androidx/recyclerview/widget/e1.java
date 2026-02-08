package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class e1 implements j2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f777a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h1 f778b;

    public /* synthetic */ e1(h1 h1Var, int i2) {
        this.f777a = i2;
        this.f778b = h1Var;
    }

    public final int a(View view) {
        int i2 = this.f777a;
        h1 h1Var = this.f778b;
        switch (i2) {
            case 0:
                return h1Var.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((i1) view.getLayoutParams())).rightMargin;
            default:
                return h1Var.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((i1) view.getLayoutParams())).bottomMargin;
        }
    }

    public final int b(View view) {
        int i2 = this.f777a;
        h1 h1Var = this.f778b;
        switch (i2) {
            case 0:
                return h1Var.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((i1) view.getLayoutParams())).leftMargin;
            default:
                return h1Var.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((i1) view.getLayoutParams())).topMargin;
        }
    }
}
