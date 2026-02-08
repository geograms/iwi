package androidx.emoji2.text;

import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.widgets.Optimizer;

/* loaded from: classes.dex */
public final class u implements n.c {

    /* renamed from: a, reason: collision with root package name */
    public final Object f414a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f415b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f416c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f417d;

    public u(Typeface typeface, x.b bVar) {
        int i2;
        int i3;
        this.f417d = typeface;
        this.f414a = bVar;
        this.f416c = new t(Optimizer.OPTIMIZATION_GROUPING);
        int iA = bVar.a(6);
        if (iA != 0) {
            int i4 = iA + bVar.f2648a;
            i2 = bVar.f2649b.getInt(bVar.f2649b.getInt(i4) + i4);
        } else {
            i2 = 0;
        }
        this.f415b = new char[i2 * 2];
        int iA2 = bVar.a(6);
        if (iA2 != 0) {
            int i5 = iA2 + bVar.f2648a;
            i3 = bVar.f2649b.getInt(bVar.f2649b.getInt(i5) + i5);
        } else {
            i3 = 0;
        }
        for (int i6 = 0; i6 < i3; i6++) {
            n nVar = new n(this, i6);
            x.a aVarC = nVar.c();
            int iA3 = aVarC.a(4);
            Character.toChars(iA3 != 0 ? aVarC.f2649b.getInt(iA3 + aVarC.f2648a) : 0, (char[]) this.f415b, i6 * 2);
            x0.g.o("invalid metadata codepoint length", nVar.b() > 0);
            ((t) this.f416c).a(nVar, 0, nVar.b() - 1);
        }
    }

    @Override // n.c
    public final void a() {
        Object obj = this.f414a;
        ((View) obj).clearAnimation();
        ((ViewGroup) this.f415b).endViewTransition((View) obj);
        ((androidx.fragment.app.i) this.f416c).a();
    }

    public u(View view, ViewGroup viewGroup, androidx.fragment.app.i iVar, androidx.fragment.app.l lVar) {
        this.f417d = lVar;
        this.f414a = view;
        this.f415b = viewGroup;
        this.f416c = iVar;
    }
}
