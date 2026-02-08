package w;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.coordinatorlayout.widget.h;

/* loaded from: classes.dex */
public final class e extends v.b {
    public static final Parcelable.Creator<e> CREATOR = new h(2);

    /* renamed from: a, reason: collision with root package name */
    public int f2608a;

    /* renamed from: b, reason: collision with root package name */
    public int f2609b;

    /* renamed from: c, reason: collision with root package name */
    public int f2610c;

    /* renamed from: d, reason: collision with root package name */
    public int f2611d;

    /* renamed from: e, reason: collision with root package name */
    public int f2612e;

    public e(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f2608a = 0;
        this.f2608a = parcel.readInt();
        this.f2609b = parcel.readInt();
        this.f2610c = parcel.readInt();
        this.f2611d = parcel.readInt();
        this.f2612e = parcel.readInt();
    }

    @Override // v.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.f2608a);
        parcel.writeInt(this.f2609b);
        parcel.writeInt(this.f2610c);
        parcel.writeInt(this.f2611d);
        parcel.writeInt(this.f2612e);
    }
}
