package h;

import android.util.Log;
import androidx.recyclerview.widget.n0;
import androidx.recyclerview.widget.o0;
import androidx.recyclerview.widget.r;
import androidx.recyclerview.widget.t;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1830a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1831b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1832c;

    public /* synthetic */ g(int i2, Object obj, Object obj2) {
        this.f1830a = i2;
        this.f1832c = obj;
        this.f1831b = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        int[] iArr;
        t tVar;
        int i2;
        int i3 = this.f1830a;
        Object obj = this.f1831b;
        Object obj2 = this.f1832c;
        switch (i3) {
            case 2:
                try {
                    Method method = h.f1834b;
                    if (method != null) {
                        method.invoke(obj2, obj, Boolean.FALSE, "AppCompat recreation");
                    } else {
                        h.f1835c.invoke(obj2, obj, Boolean.FALSE);
                    }
                    return;
                } catch (RuntimeException e2) {
                    if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                        throw e2;
                    }
                    return;
                } catch (Throwable th) {
                    Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                    return;
                }
            default:
                androidx.recyclerview.widget.d dVar = (androidx.recyclerview.widget.d) obj2;
                androidx.recyclerview.widget.f fVar = dVar.f764e;
                if (fVar.f787g == dVar.f762c) {
                    androidx.recyclerview.widget.q qVar = (androidx.recyclerview.widget.q) obj;
                    List list = dVar.f761b;
                    fVar.f785e = list;
                    fVar.f786f = Collections.unmodifiableList(list);
                    qVar.getClass();
                    n0 n0Var = fVar.f781a;
                    androidx.recyclerview.widget.g gVar = n0Var instanceof androidx.recyclerview.widget.g ? (androidx.recyclerview.widget.g) n0Var : new androidx.recyclerview.widget.g(n0Var);
                    ArrayList arrayList = new ArrayList();
                    List list2 = qVar.f933a;
                    int size = list2.size() - 1;
                    int i4 = qVar.f937e;
                    int i5 = qVar.f938f;
                    while (size >= 0) {
                        t tVar2 = (t) list2.get(size);
                        int i6 = tVar2.f959c;
                        int i7 = tVar2.f957a + i6;
                        int i8 = tVar2.f958b + i6;
                        String str3 = " ";
                        int[] iArr2 = qVar.f934b;
                        List list3 = list2;
                        boolean z2 = qVar.f939g;
                        androidx.recyclerview.widget.f fVar2 = fVar;
                        o0 o0Var = qVar.f936d;
                        if (i7 < i4) {
                            int i9 = i4 - i7;
                            if (z2) {
                                int i10 = i9 - 1;
                                while (i10 >= 0) {
                                    androidx.recyclerview.widget.d dVar2 = dVar;
                                    int i11 = i7 + i10;
                                    int i12 = iArr2[i11];
                                    int i13 = size;
                                    int i14 = i12 & 31;
                                    if (i14 != 0) {
                                        iArr = iArr2;
                                        if (i14 == 4 || i14 == 8) {
                                            int i15 = i12 >> 5;
                                            tVar = tVar2;
                                            i2 = i6;
                                            r rVarB = androidx.recyclerview.widget.q.b(i15, false, arrayList);
                                            str2 = str3;
                                            gVar.c(i11, rVarB.f944b - 1);
                                            if (i14 == 4) {
                                                int i16 = rVarB.f944b - 1;
                                                o0Var.g(i11, i15);
                                                gVar.d(i16, 1, null);
                                            }
                                        } else {
                                            if (i14 != 16) {
                                                throw new IllegalStateException("unknown flag for pos " + i11 + str3 + Long.toBinaryString(i14));
                                            }
                                            arrayList.add(new r(i11, i11, true));
                                            str2 = str3;
                                            tVar = tVar2;
                                            i2 = i6;
                                        }
                                    } else {
                                        str2 = str3;
                                        iArr = iArr2;
                                        tVar = tVar2;
                                        i2 = i6;
                                        int i17 = 1;
                                        gVar.a(i11, 1);
                                        Iterator it = arrayList.iterator();
                                        while (it.hasNext()) {
                                            ((r) it.next()).f944b -= i17;
                                            i17 = 1;
                                        }
                                    }
                                    i10--;
                                    dVar = dVar2;
                                    tVar2 = tVar;
                                    size = i13;
                                    iArr2 = iArr;
                                    i6 = i2;
                                    str3 = str2;
                                }
                            } else {
                                gVar.a(i7, i9);
                            }
                        }
                        androidx.recyclerview.widget.d dVar3 = dVar;
                        String str4 = str3;
                        int[] iArr3 = iArr2;
                        int i18 = size;
                        t tVar3 = tVar2;
                        int i19 = i6;
                        if (i8 < i5) {
                            int i20 = i5 - i8;
                            if (z2) {
                                int i21 = i20 - 1;
                                while (i21 >= 0) {
                                    int i22 = i8 + i21;
                                    int i23 = qVar.f935c[i22];
                                    int i24 = i23 & 31;
                                    if (i24 == 0) {
                                        str = str4;
                                        int i25 = 1;
                                        gVar.b(i7, 1);
                                        Iterator it2 = arrayList.iterator();
                                        while (it2.hasNext()) {
                                            ((r) it2.next()).f944b += i25;
                                            i25 = 1;
                                        }
                                    } else if (i24 == 4 || i24 == 8) {
                                        str = str4;
                                        int i26 = i23 >> 5;
                                        gVar.c(androidx.recyclerview.widget.q.b(i26, true, arrayList).f944b, i7);
                                        if (i24 == 4) {
                                            o0Var.g(i26, i22);
                                            gVar.d(i7, 1, null);
                                        }
                                    } else {
                                        if (i24 != 16) {
                                            throw new IllegalStateException("unknown flag for pos " + i22 + str4 + Long.toBinaryString(i24));
                                        }
                                        arrayList.add(new r(i22, i7, false));
                                        str = str4;
                                    }
                                    i21--;
                                    str4 = str;
                                }
                            } else {
                                gVar.b(i7, i20);
                            }
                        }
                        int i27 = i19 - 1;
                        while (i27 >= 0) {
                            t tVar4 = tVar3;
                            int i28 = tVar4.f957a + i27;
                            if ((iArr3[i28] & 31) == 2) {
                                o0Var.g(i28, tVar4.f958b + i27);
                                gVar.d(i28, 1, null);
                            }
                            i27--;
                            tVar3 = tVar4;
                        }
                        t tVar5 = tVar3;
                        i4 = tVar5.f957a;
                        i5 = tVar5.f958b;
                        size = i18 - 1;
                        list2 = list3;
                        fVar = fVar2;
                        dVar = dVar3;
                    }
                    gVar.e();
                    fVar.a(dVar.f763d);
                    return;
                }
                return;
        }
    }
}
