package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import androidx.recyclerview.widget.f2;
import com.chamsion.quickchat.ui.ChatActivity;
import com.wonder.dmr.OnEnhanceListener;
import com.wonder.dmr.OnReportStatusListener;
import com.wonder.dmr.OnTextMessageListener;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public final class d implements n.c, f.a, OnReportStatusListener, OnEnhanceListener, OnTextMessageListener {

    /* renamed from: a, reason: collision with root package name */
    public Object f476a;

    /* renamed from: b, reason: collision with root package name */
    public Object f477b;

    public /* synthetic */ d(Object obj, Object obj2) {
        this.f477b = obj;
        this.f476a = obj2;
    }

    @Override // com.wonder.dmr.OnReportStatusListener
    public void OnCallback(int i2, int i3) {
        if (i2 != 0) {
            return;
        }
        synchronized (((o0.c) this.f477b).f2252f) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                Object obj = this.f477b;
                if (jCurrentTimeMillis - ((o0.c) obj).f2255i > 5000) {
                    o0.c cVar = (o0.c) obj;
                    cVar.f2253g = -1;
                    cVar.f2254h = 0;
                }
                ((o0.c) obj).f2255i = System.currentTimeMillis();
                Object obj2 = this.f477b;
                if (i3 != ((o0.c) obj2).f2253g) {
                    Object obj3 = this.f476a;
                    if (((p0.r0) obj3) != null) {
                        ((p0.r0) obj3).a(i3);
                    } else {
                        Log.w("MainHelper", "registerReport, listener is null! ");
                    }
                    Object obj4 = this.f477b;
                    ((o0.c) obj4).f2253g = i3;
                    ((o0.c) obj4).f2254h = 1;
                } else {
                    ((o0.c) obj2).f2254h++;
                    if (((o0.c) obj2).f2254h >= 5) {
                        o0.c cVar2 = (o0.c) obj2;
                        cVar2.f2253g = -1;
                        cVar2.f2254h = 0;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.wonder.dmr.OnEnhanceListener
    public void OnCallback_1(int i2, int i3, int i4) {
        ((OnEnhanceListener) this.f476a).OnCallback_1(i2, i3, i4);
    }

    @Override // com.wonder.dmr.OnEnhanceListener
    public void OnCallback_2(int i2) {
        ((OnEnhanceListener) this.f476a).OnCallback_2(i2);
    }

    @Override // n.c
    public void a() {
        ((Animator) this.f476a).end();
    }

    @Override // f.a
    public Object apply(Object obj) {
        return (androidx.activity.result.h) this.f476a;
    }

    public void b() {
        Object obj = this.f476a;
        if (((int[]) obj) != null) {
            Arrays.fill((int[]) obj, -1);
        }
        this.f477b = null;
    }

    public void c(boolean z2) {
        Fragment fragment = ((w0) this.f477b).f664r;
        if (fragment != null) {
            fragment.getParentFragmentManager().f659m.c(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f476a).iterator();
        if (it.hasNext()) {
            a.a.j(it.next());
            if (!z2) {
                throw null;
            }
            throw null;
        }
    }

    public void d(boolean z2) {
        w0 w0Var = (w0) this.f477b;
        Context context = w0Var.f662p.f554b;
        Fragment fragment = w0Var.f664r;
        if (fragment != null) {
            fragment.getParentFragmentManager().f659m.d(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f476a).iterator();
        if (it.hasNext()) {
            a.a.j(it.next());
            if (!z2) {
                throw null;
            }
            throw null;
        }
    }

    public void e(boolean z2) {
        Fragment fragment = ((w0) this.f477b).f664r;
        if (fragment != null) {
            fragment.getParentFragmentManager().f659m.e(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f476a).iterator();
        if (it.hasNext()) {
            a.a.j(it.next());
            if (!z2) {
                throw null;
            }
            throw null;
        }
    }

    public void f(boolean z2) {
        Fragment fragment = ((w0) this.f477b).f664r;
        if (fragment != null) {
            fragment.getParentFragmentManager().f659m.f(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f476a).iterator();
        if (it.hasNext()) {
            a.a.j(it.next());
            if (!z2) {
                throw null;
            }
            throw null;
        }
    }

    public void g(boolean z2) {
        Fragment fragment = ((w0) this.f477b).f664r;
        if (fragment != null) {
            fragment.getParentFragmentManager().f659m.g(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f476a).iterator();
        if (it.hasNext()) {
            a.a.j(it.next());
            if (!z2) {
                throw null;
            }
            throw null;
        }
    }

    public void h(boolean z2) {
        Fragment fragment = ((w0) this.f477b).f664r;
        if (fragment != null) {
            fragment.getParentFragmentManager().f659m.h(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f476a).iterator();
        if (it.hasNext()) {
            a.a.j(it.next());
            if (!z2) {
                throw null;
            }
            throw null;
        }
    }

    public void i(boolean z2) {
        w0 w0Var = (w0) this.f477b;
        Context context = w0Var.f662p.f554b;
        Fragment fragment = w0Var.f664r;
        if (fragment != null) {
            fragment.getParentFragmentManager().f659m.i(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f476a).iterator();
        if (it.hasNext()) {
            a.a.j(it.next());
            if (!z2) {
                throw null;
            }
            throw null;
        }
    }

    public void j(boolean z2) {
        Fragment fragment = ((w0) this.f477b).f664r;
        if (fragment != null) {
            fragment.getParentFragmentManager().f659m.j(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f476a).iterator();
        if (it.hasNext()) {
            a.a.j(it.next());
            if (!z2) {
                throw null;
            }
            throw null;
        }
    }

    public void k(boolean z2) {
        Fragment fragment = ((w0) this.f477b).f664r;
        if (fragment != null) {
            fragment.getParentFragmentManager().f659m.k(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f476a).iterator();
        if (it.hasNext()) {
            a.a.j(it.next());
            if (!z2) {
                throw null;
            }
            throw null;
        }
    }

    public void l(boolean z2) {
        Fragment fragment = ((w0) this.f477b).f664r;
        if (fragment != null) {
            fragment.getParentFragmentManager().f659m.l(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f476a).iterator();
        if (it.hasNext()) {
            a.a.j(it.next());
            if (!z2) {
                throw null;
            }
            throw null;
        }
    }

    public void m(boolean z2) {
        Fragment fragment = ((w0) this.f477b).f664r;
        if (fragment != null) {
            fragment.getParentFragmentManager().f659m.m(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f476a).iterator();
        if (it.hasNext()) {
            a.a.j(it.next());
            if (!z2) {
                throw null;
            }
            throw null;
        }
    }

    public void n(boolean z2) {
        Fragment fragment = ((w0) this.f477b).f664r;
        if (fragment != null) {
            fragment.getParentFragmentManager().f659m.n(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f476a).iterator();
        if (it.hasNext()) {
            a.a.j(it.next());
            if (!z2) {
                throw null;
            }
            throw null;
        }
    }

    public void o(boolean z2) {
        Fragment fragment = ((w0) this.f477b).f664r;
        if (fragment != null) {
            fragment.getParentFragmentManager().f659m.o(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f476a).iterator();
        if (it.hasNext()) {
            a.a.j(it.next());
            if (!z2) {
                throw null;
            }
            throw null;
        }
    }

    public void p(boolean z2) {
        Fragment fragment = ((w0) this.f477b).f664r;
        if (fragment != null) {
            fragment.getParentFragmentManager().f659m.p(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f476a).iterator();
        if (it.hasNext()) {
            a.a.j(it.next());
            if (!z2) {
                throw null;
            }
            throw null;
        }
    }

    public void q(int i2) {
        Object obj = this.f476a;
        if (((int[]) obj) == null) {
            int[] iArr = new int[Math.max(i2, 10) + 1];
            this.f476a = iArr;
            Arrays.fill(iArr, -1);
        } else if (i2 >= ((int[]) obj).length) {
            int[] iArr2 = (int[]) obj;
            int length = ((int[]) obj).length;
            while (length <= i2) {
                length *= 2;
            }
            int[] iArr3 = new int[length];
            this.f476a = iArr3;
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
            Object obj2 = this.f476a;
            Arrays.fill((int[]) obj2, iArr2.length, ((int[]) obj2).length, -1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int r(int r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f476a
            int[] r0 = (int[]) r0
            r1 = -1
            if (r0 != 0) goto L8
            return r1
        L8:
            int r0 = r0.length
            if (r6 < r0) goto Lc
            return r1
        Lc:
            java.lang.Object r0 = r5.f477b
            r2 = r0
            java.util.List r2 = (java.util.List) r2
            if (r2 != 0) goto L15
        L13:
            r0 = r1
            goto L72
        L15:
            java.util.List r0 = (java.util.List) r0
            r2 = 0
            if (r0 != 0) goto L1b
            goto L36
        L1b:
            int r0 = r0.size()
            int r0 = r0 + (-1)
        L21:
            if (r0 < 0) goto L36
            java.lang.Object r3 = r5.f477b
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r3 = r3.get(r0)
            androidx.recyclerview.widget.f2 r3 = (androidx.recyclerview.widget.f2) r3
            int r4 = r3.f797a
            if (r4 != r6) goto L33
            r2 = r3
            goto L36
        L33:
            int r0 = r0 + (-1)
            goto L21
        L36:
            if (r2 == 0) goto L3f
            java.lang.Object r0 = r5.f477b
            java.util.List r0 = (java.util.List) r0
            r0.remove(r2)
        L3f:
            java.lang.Object r0 = r5.f477b
            java.util.List r0 = (java.util.List) r0
            int r0 = r0.size()
            r2 = 0
        L48:
            if (r2 >= r0) goto L5c
            java.lang.Object r3 = r5.f477b
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r3 = r3.get(r2)
            androidx.recyclerview.widget.f2 r3 = (androidx.recyclerview.widget.f2) r3
            int r3 = r3.f797a
            if (r3 < r6) goto L59
            goto L5d
        L59:
            int r2 = r2 + 1
            goto L48
        L5c:
            r2 = r1
        L5d:
            if (r2 == r1) goto L13
            java.lang.Object r0 = r5.f477b
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = r0.get(r2)
            androidx.recyclerview.widget.f2 r0 = (androidx.recyclerview.widget.f2) r0
            java.lang.Object r3 = r5.f477b
            java.util.List r3 = (java.util.List) r3
            r3.remove(r2)
            int r0 = r0.f797a
        L72:
            if (r0 != r1) goto L82
            java.lang.Object r0 = r5.f476a
            int[] r0 = (int[]) r0
            int r2 = r0.length
            java.util.Arrays.fill(r0, r6, r2, r1)
            java.lang.Object r5 = r5.f476a
            int[] r5 = (int[]) r5
            int r5 = r5.length
            return r5
        L82:
            java.lang.Object r5 = r5.f476a
            int[] r5 = (int[]) r5
            int r0 = r0 + 1
            java.util.Arrays.fill(r5, r6, r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.d.r(int):int");
    }

    public void s(int i2, int i3) {
        int[] iArr = (int[]) this.f476a;
        if (iArr == null || i2 >= iArr.length) {
            return;
        }
        int i4 = i2 + i3;
        q(i4);
        int[] iArr2 = (int[]) this.f476a;
        System.arraycopy(iArr2, i2, iArr2, i4, (iArr2.length - i2) - i3);
        Arrays.fill((int[]) this.f476a, i2, i4, -1);
        List list = (List) this.f477b;
        if (list == null) {
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            f2 f2Var = (f2) ((List) this.f477b).get(size);
            int i5 = f2Var.f797a;
            if (i5 >= i2) {
                f2Var.f797a = i5 + i3;
            }
        }
    }

    public void t(int i2, int i3) {
        int[] iArr = (int[]) this.f476a;
        if (iArr == null || i2 >= iArr.length) {
            return;
        }
        int i4 = i2 + i3;
        q(i4);
        int[] iArr2 = (int[]) this.f476a;
        System.arraycopy(iArr2, i4, iArr2, i2, (iArr2.length - i2) - i3);
        int[] iArr3 = (int[]) this.f476a;
        Arrays.fill(iArr3, iArr3.length - i3, iArr3.length, -1);
        List list = (List) this.f477b;
        if (list == null) {
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            f2 f2Var = (f2) ((List) this.f477b).get(size);
            int i5 = f2Var.f797a;
            if (i5 >= i2) {
                if (i5 < i4) {
                    ((List) this.f477b).remove(size);
                } else {
                    f2Var.f797a = i5 - i3;
                }
            }
        }
    }

    public void u(o.h hVar) {
        int i2 = hVar.f2229b;
        if (i2 != 0) {
            ((Handler) this.f477b).post(new androidx.activity.e(this, (k.j) this.f476a, i2));
        } else {
            k.j jVar = (k.j) this.f476a;
            ((Handler) this.f477b).post(new o.a(this, jVar, hVar.f2228a, 0));
        }
    }

    public d(w0 w0Var) {
        this.f476a = new CopyOnWriteArrayList();
        this.f477b = w0Var;
    }

    @Override // com.wonder.dmr.OnTextMessageListener
    public void OnCallback(int i2) {
        if (i2 == 0) {
            ((ChatActivity) this.f477b).f1338c.setText("");
            n0.e eVar = new n0.e();
            Object obj = this.f477b;
            eVar.f2166j = ((ChatActivity) obj).f1342g.f2091b;
            eVar.f2164h = (String) this.f476a;
            eVar.f2167k = 1;
            eVar.f2161e = ((ChatActivity) obj).f1341f;
            if (((ChatActivity) obj).f1342g.f2091b == 0) {
                eVar.f2160d = ((ChatActivity) obj).f1342g.f2092c;
                eVar.f2159c = ((ChatActivity) obj).f1342g.f2093d;
            } else if (((ChatActivity) obj).f1342g.f2091b == 1) {
                eVar.f2163g = ((ChatActivity) obj).f1342g.f2092c;
                eVar.f2162f = ((ChatActivity) obj).f1342g.f2093d;
            }
            ((ChatActivity) obj).f1347l.a(eVar);
        }
    }
}
