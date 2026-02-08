package g;

/* loaded from: classes.dex */
public final class a extends k {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f1770d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f1771e;

    public a(int i2, Object obj) {
        this.f1770d = i2;
        this.f1771e = obj;
    }

    @Override // g.k
    public final Object a(int i2, int i3) {
        int i4 = this.f1770d;
        Object obj = this.f1771e;
        switch (i4) {
            case 0:
                return ((b) obj).f1811b[(i2 << 1) + i3];
            default:
                return ((c) obj).f1780b[i2];
        }
    }

    @Override // g.k
    public final int b() {
        int i2 = this.f1770d;
        Object obj = this.f1771e;
        switch (i2) {
            case 0:
                return ((b) obj).f1812c;
            default:
                return ((c) obj).f1781c;
        }
    }

    @Override // g.k
    public final void c(int i2) {
        int i3 = this.f1770d;
        Object obj = this.f1771e;
        switch (i3) {
            case 0:
                ((b) obj).i(i2);
                break;
            default:
                ((c) obj).e(i2);
                break;
        }
    }
}
