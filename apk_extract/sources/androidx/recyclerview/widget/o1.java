package androidx.recyclerview.widget;

import android.util.SparseArray;

/* loaded from: classes.dex */
public final class o1 {

    /* renamed from: a, reason: collision with root package name */
    public SparseArray f909a;

    /* renamed from: b, reason: collision with root package name */
    public int f910b;

    public final n1 a(int i2) {
        SparseArray sparseArray = this.f909a;
        n1 n1Var = (n1) sparseArray.get(i2);
        if (n1Var != null) {
            return n1Var;
        }
        n1 n1Var2 = new n1();
        sparseArray.put(i2, n1Var2);
        return n1Var2;
    }
}
