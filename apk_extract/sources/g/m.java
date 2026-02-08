package g;

/* loaded from: classes.dex */
public final class m implements Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public static final Object f1813d = new Object();

    /* renamed from: a, reason: collision with root package name */
    public int[] f1814a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f1815b;

    /* renamed from: c, reason: collision with root package name */
    public int f1816c;

    public m() {
        int i2;
        int i3 = 4;
        while (true) {
            i2 = 40;
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (40 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        int i5 = i2 / 4;
        this.f1814a = new int[i5];
        this.f1815b = new Object[i5];
    }

    public final void a(int i2, Object obj) {
        int i3 = this.f1816c;
        if (i3 != 0 && i2 <= this.f1814a[i3 - 1]) {
            d(i2, obj);
            return;
        }
        if (i3 >= this.f1814a.length) {
            int i4 = (i3 + 1) * 4;
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
            int i7 = i4 / 4;
            int[] iArr = new int[i7];
            Object[] objArr = new Object[i7];
            int[] iArr2 = this.f1814a;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f1815b;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f1814a = iArr;
            this.f1815b = objArr;
        }
        this.f1814a[i3] = i2;
        this.f1815b[i3] = obj;
        this.f1816c = i3 + 1;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final m clone() {
        try {
            m mVar = (m) super.clone();
            mVar.f1814a = (int[]) this.f1814a.clone();
            mVar.f1815b = (Object[]) this.f1815b.clone();
            return mVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final Object c(int i2, Integer num) {
        Object obj;
        int iA = d.a(this.f1816c, i2, this.f1814a);
        return (iA < 0 || (obj = this.f1815b[iA]) == f1813d) ? num : obj;
    }

    public final void d(int i2, Object obj) {
        int iA = d.a(this.f1816c, i2, this.f1814a);
        if (iA >= 0) {
            this.f1815b[iA] = obj;
            return;
        }
        int i3 = ~iA;
        int i4 = this.f1816c;
        if (i3 < i4) {
            Object[] objArr = this.f1815b;
            if (objArr[i3] == f1813d) {
                this.f1814a[i3] = i2;
                objArr[i3] = obj;
                return;
            }
        }
        if (i4 >= this.f1814a.length) {
            int i5 = (i4 + 1) * 4;
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
            int i8 = i5 / 4;
            int[] iArr = new int[i8];
            Object[] objArr2 = new Object[i8];
            int[] iArr2 = this.f1814a;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f1815b;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1814a = iArr;
            this.f1815b = objArr2;
        }
        int i9 = this.f1816c - i3;
        if (i9 != 0) {
            int[] iArr3 = this.f1814a;
            int i10 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i10, i9);
            Object[] objArr4 = this.f1815b;
            System.arraycopy(objArr4, i3, objArr4, i10, this.f1816c - i3);
        }
        this.f1814a[i3] = i2;
        this.f1815b[i3] = obj;
        this.f1816c++;
    }

    public final String toString() {
        int i2 = this.f1816c;
        if (i2 <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i2 * 28);
        sb.append('{');
        for (int i3 = 0; i3 < this.f1816c; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            sb.append(this.f1814a[i3]);
            sb.append('=');
            Object obj = this.f1815b[i3];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
