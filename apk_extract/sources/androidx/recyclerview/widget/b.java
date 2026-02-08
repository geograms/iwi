package androidx.recyclerview.widget;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    public final u0 f733d;

    /* renamed from: a, reason: collision with root package name */
    public final o.j f730a = new o.j(30);

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f731b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f732c = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public int f735f = 0;

    /* renamed from: e, reason: collision with root package name */
    public final o0 f734e = new o0(this);

    public b(u0 u0Var) {
        this.f733d = u0Var;
    }

    public final boolean a(int i2) {
        ArrayList arrayList = this.f732c;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            a aVar = (a) arrayList.get(i3);
            int i4 = aVar.f720a;
            if (i4 == 8) {
                if (f(aVar.f723d, i3 + 1) == i2) {
                    return true;
                }
            } else if (i4 == 1) {
                int i5 = aVar.f721b;
                int i6 = aVar.f723d + i5;
                while (i5 < i6) {
                    if (f(i5, i3 + 1) == i2) {
                        return true;
                    }
                    i5++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public final void b() {
        ArrayList arrayList = this.f732c;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f733d.a((a) arrayList.get(i2));
        }
        l(arrayList);
        this.f735f = 0;
    }

    public final void c() {
        b();
        ArrayList arrayList = this.f731b;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = (a) arrayList.get(i2);
            int i3 = aVar.f720a;
            u0 u0Var = this.f733d;
            if (i3 == 1) {
                u0Var.a(aVar);
                int i4 = aVar.f721b;
                int i5 = aVar.f723d;
                RecyclerView recyclerView = u0Var.f972a;
                recyclerView.offsetPositionRecordsForInsert(i4, i5);
                recyclerView.mItemsAddedOrRemoved = true;
            } else if (i3 == 2) {
                u0Var.a(aVar);
                int i6 = aVar.f721b;
                int i7 = aVar.f723d;
                RecyclerView recyclerView2 = u0Var.f972a;
                recyclerView2.offsetPositionRecordsForRemove(i6, i7, true);
                recyclerView2.mItemsAddedOrRemoved = true;
                recyclerView2.mState.f978c += i7;
            } else if (i3 == 4) {
                u0Var.a(aVar);
                int i8 = aVar.f721b;
                int i9 = aVar.f723d;
                Object obj = aVar.f722c;
                RecyclerView recyclerView3 = u0Var.f972a;
                recyclerView3.viewRangeUpdate(i8, i9, obj);
                recyclerView3.mItemsChanged = true;
            } else if (i3 == 8) {
                u0Var.a(aVar);
                int i10 = aVar.f721b;
                int i11 = aVar.f723d;
                RecyclerView recyclerView4 = u0Var.f972a;
                recyclerView4.offsetPositionRecordsForMove(i10, i11);
                recyclerView4.mItemsAddedOrRemoved = true;
            }
        }
        l(arrayList);
        this.f735f = 0;
    }

    public final void d(a aVar) {
        int i2;
        int i3 = aVar.f720a;
        if (i3 == 1 || i3 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iM = m(aVar.f721b, i3);
        int i4 = aVar.f721b;
        int i5 = aVar.f720a;
        if (i5 == 2) {
            i2 = 0;
        } else {
            if (i5 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + aVar);
            }
            i2 = 1;
        }
        int i6 = 1;
        for (int i7 = 1; i7 < aVar.f723d; i7++) {
            int iM2 = m((i2 * i7) + aVar.f721b, aVar.f720a);
            int i8 = aVar.f720a;
            if (i8 == 2 ? iM2 != iM : !(i8 == 4 && iM2 == iM + 1)) {
                a aVarH = h(aVar.f722c, i8, iM, i6);
                e(aVarH, i4);
                k(aVarH);
                if (aVar.f720a == 4) {
                    i4 += i6;
                }
                i6 = 1;
                iM = iM2;
            } else {
                i6++;
            }
        }
        Object obj = aVar.f722c;
        k(aVar);
        if (i6 > 0) {
            a aVarH2 = h(obj, aVar.f720a, iM, i6);
            e(aVarH2, i4);
            k(aVarH2);
        }
    }

    public final void e(a aVar, int i2) {
        u0 u0Var = this.f733d;
        u0Var.a(aVar);
        int i3 = aVar.f720a;
        RecyclerView recyclerView = u0Var.f972a;
        if (i3 != 2) {
            if (i3 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            recyclerView.viewRangeUpdate(i2, aVar.f723d, aVar.f722c);
            recyclerView.mItemsChanged = true;
            return;
        }
        int i4 = aVar.f723d;
        recyclerView.offsetPositionRecordsForRemove(i2, i4, true);
        recyclerView.mItemsAddedOrRemoved = true;
        recyclerView.mState.f978c += i4;
    }

    public final int f(int i2, int i3) {
        ArrayList arrayList = this.f732c;
        int size = arrayList.size();
        while (i3 < size) {
            a aVar = (a) arrayList.get(i3);
            int i4 = aVar.f720a;
            if (i4 == 8) {
                int i5 = aVar.f721b;
                if (i5 == i2) {
                    i2 = aVar.f723d;
                } else {
                    if (i5 < i2) {
                        i2--;
                    }
                    if (aVar.f723d <= i2) {
                        i2++;
                    }
                }
            } else {
                int i6 = aVar.f721b;
                if (i6 > i2) {
                    continue;
                } else if (i4 == 2) {
                    int i7 = aVar.f723d;
                    if (i2 < i6 + i7) {
                        return -1;
                    }
                    i2 -= i7;
                } else if (i4 == 1) {
                    i2 += aVar.f723d;
                }
            }
            i3++;
        }
        return i2;
    }

    public final boolean g() {
        return this.f731b.size() > 0;
    }

    public final a h(Object obj, int i2, int i3, int i4) {
        a aVar = (a) this.f730a.acquire();
        if (aVar != null) {
            aVar.f720a = i2;
            aVar.f721b = i3;
            aVar.f723d = i4;
            aVar.f722c = obj;
            return aVar;
        }
        a aVar2 = new a();
        aVar2.f720a = i2;
        aVar2.f721b = i3;
        aVar2.f723d = i4;
        aVar2.f722c = obj;
        return aVar2;
    }

    public final void i(a aVar) {
        this.f732c.add(aVar);
        int i2 = aVar.f720a;
        u0 u0Var = this.f733d;
        if (i2 == 1) {
            int i3 = aVar.f721b;
            int i4 = aVar.f723d;
            RecyclerView recyclerView = u0Var.f972a;
            recyclerView.offsetPositionRecordsForInsert(i3, i4);
            recyclerView.mItemsAddedOrRemoved = true;
            return;
        }
        if (i2 == 2) {
            int i5 = aVar.f721b;
            int i6 = aVar.f723d;
            RecyclerView recyclerView2 = u0Var.f972a;
            recyclerView2.offsetPositionRecordsForRemove(i5, i6, false);
            recyclerView2.mItemsAddedOrRemoved = true;
            return;
        }
        if (i2 == 4) {
            int i7 = aVar.f721b;
            int i8 = aVar.f723d;
            Object obj = aVar.f722c;
            RecyclerView recyclerView3 = u0Var.f972a;
            recyclerView3.viewRangeUpdate(i7, i8, obj);
            recyclerView3.mItemsChanged = true;
            return;
        }
        if (i2 != 8) {
            throw new IllegalArgumentException("Unknown update op type for " + aVar);
        }
        int i9 = aVar.f721b;
        int i10 = aVar.f723d;
        RecyclerView recyclerView4 = u0Var.f972a;
        recyclerView4.offsetPositionRecordsForMove(i9, i10);
        recyclerView4.mItemsAddedOrRemoved = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:195:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0009 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j() {
        /*
            Method dump skipped, instructions count: 705
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.b.j():void");
    }

    public final void k(a aVar) {
        aVar.f722c = null;
        this.f730a.release(aVar);
    }

    public final void l(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            k((a) arrayList.get(i2));
        }
        arrayList.clear();
    }

    public final int m(int i2, int i3) {
        int i4;
        int i5;
        ArrayList arrayList = this.f732c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            a aVar = (a) arrayList.get(size);
            int i6 = aVar.f720a;
            if (i6 == 8) {
                int i7 = aVar.f721b;
                int i8 = aVar.f723d;
                if (i7 < i8) {
                    i5 = i7;
                    i4 = i8;
                } else {
                    i4 = i7;
                    i5 = i8;
                }
                if (i2 < i5 || i2 > i4) {
                    if (i2 < i7) {
                        if (i3 == 1) {
                            aVar.f721b = i7 + 1;
                            aVar.f723d = i8 + 1;
                        } else if (i3 == 2) {
                            aVar.f721b = i7 - 1;
                            aVar.f723d = i8 - 1;
                        }
                    }
                } else if (i5 == i7) {
                    if (i3 == 1) {
                        aVar.f723d = i8 + 1;
                    } else if (i3 == 2) {
                        aVar.f723d = i8 - 1;
                    }
                    i2++;
                } else {
                    if (i3 == 1) {
                        aVar.f721b = i7 + 1;
                    } else if (i3 == 2) {
                        aVar.f721b = i7 - 1;
                    }
                    i2--;
                }
            } else {
                int i9 = aVar.f721b;
                if (i9 <= i2) {
                    if (i6 == 1) {
                        i2 -= aVar.f723d;
                    } else if (i6 == 2) {
                        i2 += aVar.f723d;
                    }
                } else if (i3 == 1) {
                    aVar.f721b = i9 + 1;
                } else if (i3 == 2) {
                    aVar.f721b = i9 - 1;
                }
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            a aVar2 = (a) arrayList.get(size2);
            if (aVar2.f720a == 8) {
                int i10 = aVar2.f723d;
                if (i10 == aVar2.f721b || i10 < 0) {
                    arrayList.remove(size2);
                    k(aVar2);
                }
            } else if (aVar2.f723d <= 0) {
                arrayList.remove(size2);
                k(aVar2);
            }
        }
        return i2;
    }
}
