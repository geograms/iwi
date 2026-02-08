package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public final class g implements n0 {

    /* renamed from: a, reason: collision with root package name */
    public final n0 f801a;

    /* renamed from: b, reason: collision with root package name */
    public int f802b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f803c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f804d = -1;

    /* renamed from: e, reason: collision with root package name */
    public Object f805e = null;

    public g(n0 n0Var) {
        this.f801a = n0Var;
    }

    @Override // androidx.recyclerview.widget.n0
    public final void a(int i2, int i3) {
        int i4;
        if (this.f802b == 2 && (i4 = this.f803c) >= i2 && i4 <= i2 + i3) {
            this.f804d += i3;
            this.f803c = i2;
        } else {
            e();
            this.f803c = i2;
            this.f804d = i3;
            this.f802b = 2;
        }
    }

    @Override // androidx.recyclerview.widget.n0
    public final void b(int i2, int i3) {
        int i4;
        if (this.f802b == 1 && i2 >= (i4 = this.f803c)) {
            int i5 = this.f804d;
            if (i2 <= i4 + i5) {
                this.f804d = i5 + i3;
                this.f803c = Math.min(i2, i4);
                return;
            }
        }
        e();
        this.f803c = i2;
        this.f804d = i3;
        this.f802b = 1;
    }

    @Override // androidx.recyclerview.widget.n0
    public final void c(int i2, int i3) {
        e();
        this.f801a.c(i2, i3);
    }

    @Override // androidx.recyclerview.widget.n0
    public final void d(int i2, int i3, Object obj) {
        int i4;
        if (this.f802b == 3) {
            int i5 = this.f803c;
            int i6 = this.f804d;
            if (i2 <= i5 + i6 && (i4 = i2 + i3) >= i5 && this.f805e == obj) {
                this.f803c = Math.min(i2, i5);
                this.f804d = Math.max(i6 + i5, i4) - this.f803c;
                return;
            }
        }
        e();
        this.f803c = i2;
        this.f804d = i3;
        this.f805e = obj;
        this.f802b = 3;
    }

    public final void e() {
        int i2 = this.f802b;
        if (i2 == 0) {
            return;
        }
        n0 n0Var = this.f801a;
        if (i2 == 1) {
            n0Var.b(this.f803c, this.f804d);
        } else if (i2 == 2) {
            n0Var.a(this.f803c, this.f804d);
        } else if (i2 == 3) {
            n0Var.d(this.f803c, this.f804d, this.f805e);
        }
        this.f805e = null;
        this.f802b = 0;
    }
}
