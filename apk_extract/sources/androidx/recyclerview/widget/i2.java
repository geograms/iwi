package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public final class i2 {

    /* renamed from: a, reason: collision with root package name */
    public int f856a;

    /* renamed from: b, reason: collision with root package name */
    public int f857b;

    /* renamed from: c, reason: collision with root package name */
    public int f858c;

    /* renamed from: d, reason: collision with root package name */
    public int f859d;

    /* renamed from: e, reason: collision with root package name */
    public int f860e;

    public final boolean a() {
        int i2 = this.f856a;
        int i3 = 2;
        if ((i2 & 7) != 0) {
            int i4 = this.f859d;
            int i5 = this.f857b;
            if (((i4 > i5 ? 1 : i4 == i5 ? 2 : 4) & i2) == 0) {
                return false;
            }
        }
        if ((i2 & 112) != 0) {
            int i6 = this.f859d;
            int i7 = this.f858c;
            if ((((i6 > i7 ? 1 : i6 == i7 ? 2 : 4) << 4) & i2) == 0) {
                return false;
            }
        }
        if ((i2 & 1792) != 0) {
            int i8 = this.f860e;
            int i9 = this.f857b;
            if ((((i8 > i9 ? 1 : i8 == i9 ? 2 : 4) << 8) & i2) == 0) {
                return false;
            }
        }
        if ((i2 & 28672) != 0) {
            int i10 = this.f860e;
            int i11 = this.f858c;
            if (i10 > i11) {
                i3 = 1;
            } else if (i10 != i11) {
                i3 = 4;
            }
            if (((i3 << 12) & i2) == 0) {
                return false;
            }
        }
        return true;
    }
}
