package g0;

import android.os.Parcel;
import android.util.SparseIntArray;

/* loaded from: classes.dex */
public final class b extends a {

    /* renamed from: d, reason: collision with root package name */
    public final SparseIntArray f1820d;

    /* renamed from: e, reason: collision with root package name */
    public final Parcel f1821e;

    /* renamed from: f, reason: collision with root package name */
    public final int f1822f;

    /* renamed from: g, reason: collision with root package name */
    public final int f1823g;

    /* renamed from: h, reason: collision with root package name */
    public final String f1824h;

    /* renamed from: i, reason: collision with root package name */
    public int f1825i;

    /* renamed from: j, reason: collision with root package name */
    public int f1826j;

    /* renamed from: k, reason: collision with root package name */
    public int f1827k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new g.b(), new g.b(), new g.b());
    }

    @Override // g0.a
    public final b a() {
        Parcel parcel = this.f1821e;
        int iDataPosition = parcel.dataPosition();
        int i2 = this.f1826j;
        if (i2 == this.f1822f) {
            i2 = this.f1823g;
        }
        return new b(parcel, iDataPosition, i2, a.a.e(new StringBuilder(), this.f1824h, "  "), this.f1817a, this.f1818b, this.f1819c);
    }

    @Override // g0.a
    public final boolean e(int i2) {
        while (this.f1826j < this.f1823g) {
            int i3 = this.f1827k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            int i4 = this.f1826j;
            Parcel parcel = this.f1821e;
            parcel.setDataPosition(i4);
            int i5 = parcel.readInt();
            this.f1827k = parcel.readInt();
            this.f1826j += i5;
        }
        return this.f1827k == i2;
    }

    @Override // g0.a
    public final void h(int i2) {
        int i3 = this.f1825i;
        SparseIntArray sparseIntArray = this.f1820d;
        Parcel parcel = this.f1821e;
        if (i3 >= 0) {
            int i4 = sparseIntArray.get(i3);
            int iDataPosition = parcel.dataPosition();
            parcel.setDataPosition(i4);
            parcel.writeInt(iDataPosition - i4);
            parcel.setDataPosition(iDataPosition);
        }
        this.f1825i = i2;
        sparseIntArray.put(i2, parcel.dataPosition());
        parcel.writeInt(0);
        parcel.writeInt(i2);
    }

    public b(Parcel parcel, int i2, int i3, String str, g.b bVar, g.b bVar2, g.b bVar3) {
        super(bVar, bVar2, bVar3);
        this.f1820d = new SparseIntArray();
        this.f1825i = -1;
        this.f1827k = -1;
        this.f1821e = parcel;
        this.f1822f = i2;
        this.f1823g = i3;
        this.f1826j = i2;
        this.f1824h = str;
    }
}
