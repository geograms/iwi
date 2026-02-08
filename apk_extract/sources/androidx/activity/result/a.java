package androidx.activity.result;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.c1;
import androidx.fragment.app.s0;
import androidx.fragment.app.y0;
import androidx.recyclerview.widget.f2;
import androidx.recyclerview.widget.g2;
import androidx.recyclerview.widget.j0;
import androidx.versionedparcelable.ParcelImpl;
import java.util.ArrayList;
import u.l;

/* loaded from: classes.dex */
public final class a implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f37a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f37a) {
            case 0:
                return new b(parcel);
            case 1:
                return new j(parcel);
            case 2:
                l lVar = new l(parcel);
                lVar.f2587a = parcel.readInt();
                return lVar;
            case 3:
                return new androidx.fragment.app.b(parcel);
            case 4:
                s0 s0Var = new s0();
                s0Var.f599a = parcel.readString();
                s0Var.f600b = parcel.readInt();
                return s0Var;
            case 5:
                y0 y0Var = new y0();
                y0Var.f683e = null;
                y0Var.f684f = new ArrayList();
                y0Var.f685g = new ArrayList();
                y0Var.f679a = parcel.createTypedArrayList(c1.CREATOR);
                y0Var.f680b = parcel.createStringArrayList();
                y0Var.f681c = (androidx.fragment.app.b[]) parcel.createTypedArray(androidx.fragment.app.b.CREATOR);
                y0Var.f682d = parcel.readInt();
                y0Var.f683e = parcel.readString();
                y0Var.f684f = parcel.createStringArrayList();
                y0Var.f685g = parcel.createTypedArrayList(Bundle.CREATOR);
                y0Var.f686h = parcel.createTypedArrayList(s0.CREATOR);
                return y0Var;
            case 6:
                return new c1(parcel);
            case 7:
                j0 j0Var = new j0();
                j0Var.f864a = parcel.readInt();
                j0Var.f865b = parcel.readInt();
                j0Var.f866c = parcel.readInt() == 1;
                return j0Var;
            case 8:
                f2 f2Var = new f2();
                f2Var.f797a = parcel.readInt();
                f2Var.f798b = parcel.readInt();
                f2Var.f800d = parcel.readInt() == 1;
                int i2 = parcel.readInt();
                if (i2 > 0) {
                    int[] iArr = new int[i2];
                    f2Var.f799c = iArr;
                    parcel.readIntArray(iArr);
                }
                return f2Var;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                g2 g2Var = new g2();
                g2Var.f815a = parcel.readInt();
                g2Var.f816b = parcel.readInt();
                int i3 = parcel.readInt();
                g2Var.f817c = i3;
                if (i3 > 0) {
                    int[] iArr2 = new int[i3];
                    g2Var.f818d = iArr2;
                    parcel.readIntArray(iArr2);
                }
                int i4 = parcel.readInt();
                g2Var.f819e = i4;
                if (i4 > 0) {
                    int[] iArr3 = new int[i4];
                    g2Var.f820f = iArr3;
                    parcel.readIntArray(iArr3);
                }
                g2Var.f822h = parcel.readInt() == 1;
                g2Var.f823i = parcel.readInt() == 1;
                g2Var.f824j = parcel.readInt() == 1;
                g2Var.f821g = parcel.readArrayList(f2.class.getClassLoader());
                return g2Var;
            default:
                return new ParcelImpl(parcel);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i2) {
        switch (this.f37a) {
            case 0:
                return new b[i2];
            case 1:
                return new j[i2];
            case 2:
                return new l[i2];
            case 3:
                return new androidx.fragment.app.b[i2];
            case 4:
                return new s0[i2];
            case 5:
                return new y0[i2];
            case 6:
                return new c1[i2];
            case 7:
                return new j0[i2];
            case 8:
                return new f2[i2];
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                return new g2[i2];
            default:
                return new ParcelImpl[i2];
        }
    }
}
