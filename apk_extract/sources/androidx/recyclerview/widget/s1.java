package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class s1 extends v.b {
    public static final Parcelable.Creator<s1> CREATOR = new androidx.coordinatorlayout.widget.h(4);

    /* renamed from: a, reason: collision with root package name */
    public Parcelable f956a;

    public s1(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f956a = parcel.readParcelable(classLoader == null ? h1.class.getClassLoader() : classLoader);
    }

    @Override // v.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeParcelable(this.f956a, 0);
    }
}
