package androidx.emoji2.text;

import android.util.SparseArray;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f412a;

    /* renamed from: b, reason: collision with root package name */
    public n f413b;

    public t(int i2) {
        this.f412a = new SparseArray(i2);
    }

    public final void a(n nVar, int i2, int i3) {
        int iA = nVar.a(i2);
        SparseArray sparseArray = this.f412a;
        t tVar = sparseArray == null ? null : (t) sparseArray.get(iA);
        if (tVar == null) {
            tVar = new t(1);
            sparseArray.put(nVar.a(i2), tVar);
        }
        if (i3 > i2) {
            tVar.a(nVar, i2 + 1, i3);
        } else {
            tVar.f413b = nVar;
        }
    }
}
