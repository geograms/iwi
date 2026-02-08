package androidx.coordinatorlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.y;
import androidx.recyclerview.widget.s1;

/* loaded from: classes.dex */
public final class h implements Parcelable.ClassLoaderCreator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f95a;

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        switch (this.f95a) {
            case 0:
                return new i(parcel, classLoader);
            case 1:
                if (parcel.readParcelable(classLoader) == null) {
                    return v.b.EMPTY_STATE;
                }
                throw new IllegalStateException("superState must be null");
            case 2:
                return new w.e(parcel, classLoader);
            case 3:
                return new y(parcel, classLoader);
            default:
                return new s1(parcel, classLoader);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i2) {
        switch (this.f95a) {
            case 0:
                return new i[i2];
            case 1:
                return new v.b[i2];
            case 2:
                return new w.e[i2];
            case 3:
                return new y[i2];
            default:
                return new s1[i2];
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f95a) {
            case 0:
                return new i(parcel, null);
            case 1:
                if (parcel.readParcelable(null) == null) {
                    return v.b.EMPTY_STATE;
                }
                throw new IllegalStateException("superState must be null");
            case 2:
                return new w.e(parcel, null);
            case 3:
                return new y(parcel, null);
            default:
                return new s1(parcel, null);
        }
    }
}
