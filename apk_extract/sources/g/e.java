package g;

/* loaded from: classes.dex */
public final class e implements Cloneable {

    /* renamed from: e, reason: collision with root package name */
    public static final Object f1786e = new Object();

    /* renamed from: a, reason: collision with root package name */
    public boolean f1787a;

    /* renamed from: b, reason: collision with root package name */
    public long[] f1788b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f1789c;

    /* renamed from: d, reason: collision with root package name */
    public int f1790d;

    public e() {
        this(10);
    }

    public final void a(long j2, Long l2) {
        int i2 = this.f1790d;
        if (i2 != 0 && j2 <= this.f1788b[i2 - 1]) {
            g(j2, l2);
            return;
        }
        if (this.f1787a && i2 >= this.f1788b.length) {
            d();
        }
        int i3 = this.f1790d;
        if (i3 >= this.f1788b.length) {
            int i4 = (i3 + 1) * 8;
            int i5 = 4;
            while (true) {
                if (i5 >= 32) {
                    break;
                }
                int i6 = (1 << i5) - 12;
                if (i4 <= i6) {
                    i4 = i6;
                    break;
                }
                i5++;
            }
            int i7 = i4 / 8;
            long[] jArr = new long[i7];
            Object[] objArr = new Object[i7];
            long[] jArr2 = this.f1788b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.f1789c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f1788b = jArr;
            this.f1789c = objArr;
        }
        this.f1788b[i3] = j2;
        this.f1789c[i3] = l2;
        this.f1790d = i3 + 1;
    }

    public final void b() {
        int i2 = this.f1790d;
        Object[] objArr = this.f1789c;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f1790d = 0;
        this.f1787a = false;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final e clone() {
        try {
            e eVar = (e) super.clone();
            eVar.f1788b = (long[]) this.f1788b.clone();
            eVar.f1789c = (Object[]) this.f1789c.clone();
            return eVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final void d() {
        int i2 = this.f1790d;
        long[] jArr = this.f1788b;
        Object[] objArr = this.f1789c;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f1786e) {
                if (i4 != i3) {
                    jArr[i3] = jArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f1787a = false;
        this.f1790d = i3;
    }

    public final Object e(long j2, Long l2) {
        Object obj;
        int iB = d.b(this.f1788b, this.f1790d, j2);
        return (iB < 0 || (obj = this.f1789c[iB]) == f1786e) ? l2 : obj;
    }

    public final long f(int i2) {
        if (this.f1787a) {
            d();
        }
        return this.f1788b[i2];
    }

    public final void g(long j2, Object obj) {
        int iB = d.b(this.f1788b, this.f1790d, j2);
        if (iB >= 0) {
            this.f1789c[iB] = obj;
            return;
        }
        int i2 = ~iB;
        int i3 = this.f1790d;
        if (i2 < i3) {
            Object[] objArr = this.f1789c;
            if (objArr[i2] == f1786e) {
                this.f1788b[i2] = j2;
                objArr[i2] = obj;
                return;
            }
        }
        if (this.f1787a && i3 >= this.f1788b.length) {
            d();
            i2 = ~d.b(this.f1788b, this.f1790d, j2);
        }
        int i4 = this.f1790d;
        if (i4 >= this.f1788b.length) {
            int i5 = (i4 + 1) * 8;
            int i6 = 4;
            while (true) {
                if (i6 >= 32) {
                    break;
                }
                int i7 = (1 << i6) - 12;
                if (i5 <= i7) {
                    i5 = i7;
                    break;
                }
                i6++;
            }
            int i8 = i5 / 8;
            long[] jArr = new long[i8];
            Object[] objArr2 = new Object[i8];
            long[] jArr2 = this.f1788b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f1789c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1788b = jArr;
            this.f1789c = objArr2;
        }
        int i9 = this.f1790d - i2;
        if (i9 != 0) {
            long[] jArr3 = this.f1788b;
            int i10 = i2 + 1;
            System.arraycopy(jArr3, i2, jArr3, i10, i9);
            Object[] objArr4 = this.f1789c;
            System.arraycopy(objArr4, i2, objArr4, i10, this.f1790d - i2);
        }
        this.f1788b[i2] = j2;
        this.f1789c[i2] = obj;
        this.f1790d++;
    }

    public final int h() {
        if (this.f1787a) {
            d();
        }
        return this.f1790d;
    }

    public final Object i(int i2) {
        if (this.f1787a) {
            d();
        }
        return this.f1789c[i2];
    }

    public final String toString() {
        if (h() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1790d * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f1790d; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(f(i2));
            sb.append('=');
            Object objI = i(i2);
            if (objI != this) {
                sb.append(objI);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public e(int i2) {
        this.f1787a = false;
        if (i2 == 0) {
            this.f1788b = d.f1784b;
            this.f1789c = d.f1785c;
            return;
        }
        int i3 = i2 * 8;
        int i4 = 4;
        while (true) {
            if (i4 >= 32) {
                break;
            }
            int i5 = (1 << i4) - 12;
            if (i3 <= i5) {
                i3 = i5;
                break;
            }
            i4++;
        }
        int i6 = i3 / 8;
        this.f1788b = new long[i6];
        this.f1789c = new Object[i6];
    }
}
