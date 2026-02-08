package androidx.activity.result;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class j implements Parcelable {
    public static final Parcelable.Creator<j> CREATOR = new a(1);

    /* renamed from: a, reason: collision with root package name */
    public final IntentSender f56a;

    /* renamed from: b, reason: collision with root package name */
    public final Intent f57b;

    /* renamed from: c, reason: collision with root package name */
    public final int f58c;

    /* renamed from: d, reason: collision with root package name */
    public final int f59d;

    public j(IntentSender intentSender, Intent intent, int i2, int i3) {
        this.f56a = intentSender;
        this.f57b = intent;
        this.f58c = i2;
        this.f59d = i3;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f56a, i2);
        parcel.writeParcelable(this.f57b, i2);
        parcel.writeInt(this.f58c);
        parcel.writeInt(this.f59d);
    }

    public j(Parcel parcel) {
        this.f56a = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.f57b = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.f58c = parcel.readInt();
        this.f59d = parcel.readInt();
    }
}
