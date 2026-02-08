package v;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.coordinatorlayout.widget.h;

/* loaded from: classes.dex */
public abstract class b implements Parcelable {
    private final Parcelable mSuperState;
    public static final b EMPTY_STATE = new a();
    public static final Parcelable.Creator<b> CREATOR = new h(1);

    public b() {
        this.mSuperState = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Parcelable getSuperState() {
        return this.mSuperState;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.mSuperState, i2);
    }

    public b(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        this.mSuperState = parcelable == EMPTY_STATE ? null : parcelable;
    }

    public b(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.mSuperState = parcelable == null ? EMPTY_STATE : parcelable;
    }
}
