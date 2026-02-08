package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes.dex */
public final class g2 implements Parcelable {
    public static final Parcelable.Creator<g2> CREATOR = new androidx.activity.result.a(9);

    /* renamed from: a, reason: collision with root package name */
    public int f815a;

    /* renamed from: b, reason: collision with root package name */
    public int f816b;

    /* renamed from: c, reason: collision with root package name */
    public int f817c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f818d;

    /* renamed from: e, reason: collision with root package name */
    public int f819e;

    /* renamed from: f, reason: collision with root package name */
    public int[] f820f;

    /* renamed from: g, reason: collision with root package name */
    public List f821g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f822h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f823i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f824j;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f815a);
        parcel.writeInt(this.f816b);
        parcel.writeInt(this.f817c);
        if (this.f817c > 0) {
            parcel.writeIntArray(this.f818d);
        }
        parcel.writeInt(this.f819e);
        if (this.f819e > 0) {
            parcel.writeIntArray(this.f820f);
        }
        parcel.writeInt(this.f822h ? 1 : 0);
        parcel.writeInt(this.f823i ? 1 : 0);
        parcel.writeInt(this.f824j ? 1 : 0);
        parcel.writeList(this.f821g);
    }
}
