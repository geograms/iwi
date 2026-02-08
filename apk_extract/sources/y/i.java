package y;

import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class i extends c.c {

    /* renamed from: b, reason: collision with root package name */
    public final h f2680b;

    public i(TextView textView) {
        super(13);
        this.f2680b = new h(textView);
    }

    @Override // c.c
    public final InputFilter[] e(InputFilter[] inputFilterArr) {
        return (androidx.emoji2.text.j.f373j != null) ^ true ? inputFilterArr : this.f2680b.e(inputFilterArr);
    }

    @Override // c.c
    public final boolean j() {
        return this.f2680b.f2679d;
    }

    @Override // c.c
    public final void k(boolean z2) {
        if (!(androidx.emoji2.text.j.f373j != null)) {
            return;
        }
        this.f2680b.k(z2);
    }

    @Override // c.c
    public final void n(boolean z2) {
        boolean z3 = !(androidx.emoji2.text.j.f373j != null);
        h hVar = this.f2680b;
        if (z3) {
            hVar.f2679d = z2;
        } else {
            hVar.n(z2);
        }
    }

    @Override // c.c
    public final TransformationMethod p(TransformationMethod transformationMethod) {
        return (androidx.emoji2.text.j.f373j != null) ^ true ? transformationMethod : this.f2680b.p(transformationMethod);
    }
}
