package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final List f933a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f934b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f935c;

    /* renamed from: d, reason: collision with root package name */
    public final o0 f936d;

    /* renamed from: e, reason: collision with root package name */
    public final int f937e;

    /* renamed from: f, reason: collision with root package name */
    public final int f938f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f939g;

    public q(o0 o0Var, ArrayList arrayList, int[] iArr, int[] iArr2) {
        this.f933a = arrayList;
        this.f934b = iArr;
        this.f935c = iArr2;
        Arrays.fill(iArr, 0);
        Arrays.fill(iArr2, 0);
        this.f936d = o0Var;
        Object obj = o0Var.f908a;
        int size = ((d) obj).f760a.size();
        this.f937e = size;
        int size2 = ((d) obj).f761b.size();
        this.f938f = size2;
        this.f939g = true;
        t tVar = arrayList.isEmpty() ? null : (t) arrayList.get(0);
        if (tVar == null || tVar.f957a != 0 || tVar.f958b != 0) {
            t tVar2 = new t();
            tVar2.f957a = 0;
            tVar2.f958b = 0;
            tVar2.f960d = false;
            tVar2.f959c = 0;
            tVar2.f961e = false;
            arrayList.add(0, tVar2);
        }
        for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
            t tVar3 = (t) arrayList.get(size3);
            int i2 = tVar3.f957a;
            int i3 = tVar3.f959c;
            int i4 = i2 + i3;
            int i5 = tVar3.f958b + i3;
            boolean z2 = this.f939g;
            int[] iArr3 = this.f935c;
            int[] iArr4 = this.f934b;
            if (z2) {
                while (size > i4) {
                    if (iArr4[size - 1] == 0) {
                        a(size, size2, size3, false);
                    }
                    size--;
                }
                while (size2 > i5) {
                    if (iArr3[size2 - 1] == 0) {
                        a(size, size2, size3, true);
                    }
                    size2--;
                }
            }
            for (int i6 = 0; i6 < tVar3.f959c; i6++) {
                int i7 = tVar3.f957a + i6;
                int i8 = tVar3.f958b + i6;
                int i9 = this.f936d.e(i7, i8) ? 1 : 2;
                iArr4[i7] = (i8 << 5) | i9;
                iArr3[i8] = (i7 << 5) | i9;
            }
            size = tVar3.f957a;
            size2 = tVar3.f958b;
        }
    }

    public static r b(int i2, boolean z2, ArrayList arrayList) {
        int size = arrayList.size() - 1;
        while (size >= 0) {
            r rVar = (r) arrayList.get(size);
            if (rVar.f943a == i2 && rVar.f945c == z2) {
                arrayList.remove(size);
                while (size < arrayList.size()) {
                    ((r) arrayList.get(size)).f944b += z2 ? 1 : -1;
                    size++;
                }
                return rVar;
            }
            size--;
        }
        return null;
    }

    public final void a(int i2, int i3, int i4, boolean z2) {
        int i5;
        int i6;
        int i7;
        if (z2) {
            i3--;
            i6 = i2;
            i5 = i3;
        } else {
            i5 = i2 - 1;
            i6 = i5;
        }
        while (i4 >= 0) {
            t tVar = (t) this.f933a.get(i4);
            int i8 = tVar.f957a;
            int i9 = tVar.f959c;
            int i10 = i8 + i9;
            int i11 = tVar.f958b + i9;
            int[] iArr = this.f934b;
            int[] iArr2 = this.f935c;
            o0 o0Var = this.f936d;
            if (z2) {
                for (int i12 = i6 - 1; i12 >= i10; i12--) {
                    if (o0Var.f(i12, i5)) {
                        i7 = o0Var.e(i12, i5) ? 8 : 4;
                        iArr2[i5] = (i12 << 5) | 16;
                        iArr[i12] = (i5 << 5) | i7;
                        return;
                    }
                }
            } else {
                for (int i13 = i3 - 1; i13 >= i11; i13--) {
                    if (o0Var.f(i5, i13)) {
                        i7 = o0Var.e(i5, i13) ? 8 : 4;
                        int i14 = i2 - 1;
                        iArr[i14] = (i13 << 5) | 16;
                        iArr2[i13] = (i14 << 5) | i7;
                        return;
                    }
                }
            }
            i6 = tVar.f957a;
            i3 = tVar.f958b;
            i4--;
        }
    }
}
