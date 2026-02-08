package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class j0 implements Parcelable {
    public static final Parcelable.Creator<j0> CREATOR = new androidx.activity.result.a(7);

    /* renamed from: a, reason: collision with root package name */
    public int f864a;

    /* renamed from: b, reason: collision with root package name */
    public int f865b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f866c;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f864a);
        parcel.writeInt(this.f865b);
        parcel.writeInt(this.f866c ? 1 : 0);
    }
}
