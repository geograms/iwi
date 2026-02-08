package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class f2 implements Parcelable {
    public static final Parcelable.Creator<f2> CREATOR = new androidx.activity.result.a(8);

    /* renamed from: a, reason: collision with root package name */
    public int f797a;

    /* renamed from: b, reason: collision with root package name */
    public int f798b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f799c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f800d;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "FullSpanItem{mPosition=" + this.f797a + ", mGapDir=" + this.f798b + ", mHasUnwantedGapAfter=" + this.f800d + ", mGapPerSpan=" + Arrays.toString(this.f799c) + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f797a);
        parcel.writeInt(this.f798b);
        parcel.writeInt(this.f800d ? 1 : 0);
        int[] iArr = this.f799c;
        if (iArr == null || iArr.length <= 0) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(iArr.length);
            parcel.writeIntArray(this.f799c);
        }
    }
}
