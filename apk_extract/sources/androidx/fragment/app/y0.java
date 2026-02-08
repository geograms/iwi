package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class y0 implements Parcelable {
    public static final Parcelable.Creator<y0> CREATOR = new androidx.activity.result.a(5);

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f679a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f680b;

    /* renamed from: c, reason: collision with root package name */
    public b[] f681c;

    /* renamed from: d, reason: collision with root package name */
    public int f682d;

    /* renamed from: e, reason: collision with root package name */
    public String f683e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f684f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f685g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f686h;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.f679a);
        parcel.writeStringList(this.f680b);
        parcel.writeTypedArray(this.f681c, i2);
        parcel.writeInt(this.f682d);
        parcel.writeString(this.f683e);
        parcel.writeStringList(this.f684f);
        parcel.writeTypedList(this.f685g);
        parcel.writeTypedList(this.f686h);
    }
}
