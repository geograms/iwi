package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class s0 implements Parcelable {
    public static final Parcelable.Creator<s0> CREATOR = new androidx.activity.result.a(4);

    /* renamed from: a, reason: collision with root package name */
    public String f599a;

    /* renamed from: b, reason: collision with root package name */
    public int f600b;

    public s0(String str, int i2) {
        this.f599a = str;
        this.f600b = i2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f599a);
        parcel.writeInt(this.f600b);
    }
}
