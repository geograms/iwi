package androidx.core.view;

import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
public class l2 {

    /* renamed from: b, reason: collision with root package name */
    public static final n2 f185b;

    /* renamed from: a, reason: collision with root package name */
    public final n2 f186a;

    static {
        f185b = (Build.VERSION.SDK_INT >= 30 ? new e2() : new d2()).b().f189a.a().f189a.b().f189a.c();
    }

    public l2(n2 n2Var) {
        this.f186a = n2Var;
    }

    public n2 a() {
        return this.f186a;
    }

    public n2 b() {
        return this.f186a;
    }

    public n2 c() {
        return this.f186a;
    }

    public void d(View view) {
    }

    public n e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l2)) {
            return false;
        }
        l2 l2Var = (l2) obj;
        return n() == l2Var.n() && m() == l2Var.m() && q.b.a(j(), l2Var.j()) && q.b.a(h(), l2Var.h()) && q.b.a(e(), l2Var.e());
    }

    public k.f f(int i2) {
        return k.f.f1925e;
    }

    public k.f g() {
        return j();
    }

    public k.f h() {
        return k.f.f1925e;
    }

    public int hashCode() {
        return q.b.b(Boolean.valueOf(n()), Boolean.valueOf(m()), j(), h(), e());
    }

    public k.f i() {
        return j();
    }

    public k.f j() {
        return k.f.f1925e;
    }

    public k.f k() {
        return j();
    }

    public n2 l(int i2, int i3, int i4, int i5) {
        return f185b;
    }

    public boolean m() {
        return false;
    }

    public boolean n() {
        return false;
    }

    public void o(k.f[] fVarArr) {
    }

    public void p(n2 n2Var) {
    }
}
