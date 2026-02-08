package androidx.emoji2.text;

import android.util.SparseArray;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public int f392a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final t f393b;

    /* renamed from: c, reason: collision with root package name */
    public t f394c;

    /* renamed from: d, reason: collision with root package name */
    public t f395d;

    /* renamed from: e, reason: collision with root package name */
    public int f396e;

    /* renamed from: f, reason: collision with root package name */
    public int f397f;

    public o(t tVar) {
        this.f393b = tVar;
        this.f394c = tVar;
    }

    public final int a(int i2) {
        SparseArray sparseArray = this.f394c.f412a;
        t tVar = sparseArray == null ? null : (t) sparseArray.get(i2);
        int i3 = 1;
        int i4 = 2;
        if (this.f392a == 2) {
            if (tVar != null) {
                this.f394c = tVar;
                this.f397f++;
            } else if (i2 == 65038) {
                b();
            } else if (i2 != 65039) {
                t tVar2 = this.f394c;
                if (tVar2.f413b != null) {
                    i4 = 3;
                    if (this.f397f != 1) {
                        this.f395d = tVar2;
                        b();
                    } else if (c()) {
                        this.f395d = this.f394c;
                        b();
                    } else {
                        b();
                    }
                } else {
                    b();
                }
            }
            i3 = i4;
        } else if (tVar == null) {
            b();
        } else {
            this.f392a = 2;
            this.f394c = tVar;
            this.f397f = 1;
            i3 = i4;
        }
        this.f396e = i2;
        return i3;
    }

    public final void b() {
        this.f392a = 1;
        this.f394c = this.f393b;
        this.f397f = 0;
    }

    public final boolean c() {
        x.a aVarC = this.f394c.f413b.c();
        int iA = aVarC.a(6);
        return !(iA == 0 || aVarC.f2649b.get(iA + aVarC.f2648a) == 0) || this.f396e == 65039;
    }
}
