package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;
import g0.a;
import g0.b;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        int i2 = iconCompat.f115a;
        if (aVar.e(1)) {
            i2 = ((b) aVar).f1821e.readInt();
        }
        iconCompat.f115a = i2;
        byte[] bArr = iconCompat.f117c;
        if (aVar.e(2)) {
            Parcel parcel = ((b) aVar).f1821e;
            int i3 = parcel.readInt();
            if (i3 < 0) {
                bArr = null;
            } else {
                byte[] bArr2 = new byte[i3];
                parcel.readByteArray(bArr2);
                bArr = bArr2;
            }
        }
        iconCompat.f117c = bArr;
        iconCompat.f118d = aVar.f(iconCompat.f118d, 3);
        int i4 = iconCompat.f119e;
        if (aVar.e(4)) {
            i4 = ((b) aVar).f1821e.readInt();
        }
        iconCompat.f119e = i4;
        int i5 = iconCompat.f120f;
        if (aVar.e(5)) {
            i5 = ((b) aVar).f1821e.readInt();
        }
        iconCompat.f120f = i5;
        iconCompat.f121g = (ColorStateList) aVar.f(iconCompat.f121g, 6);
        String string = iconCompat.f123i;
        if (aVar.e(7)) {
            string = ((b) aVar).f1821e.readString();
        }
        iconCompat.f123i = string;
        String string2 = iconCompat.f124j;
        if (aVar.e(8)) {
            string2 = ((b) aVar).f1821e.readString();
        }
        iconCompat.f124j = string2;
        iconCompat.f122h = PorterDuff.Mode.valueOf(iconCompat.f123i);
        switch (iconCompat.f115a) {
            case -1:
                Parcelable parcelable = iconCompat.f118d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.f116b = parcelable;
                return iconCompat;
            case 0:
            default:
                return iconCompat;
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.f118d;
                if (parcelable2 != null) {
                    iconCompat.f116b = parcelable2;
                } else {
                    byte[] bArr3 = iconCompat.f117c;
                    iconCompat.f116b = bArr3;
                    iconCompat.f115a = 3;
                    iconCompat.f119e = 0;
                    iconCompat.f120f = bArr3.length;
                }
                return iconCompat;
            case 2:
            case 4:
            case 6:
                String str = new String(iconCompat.f117c, Charset.forName("UTF-16"));
                iconCompat.f116b = str;
                if (iconCompat.f115a == 2 && iconCompat.f124j == null) {
                    iconCompat.f124j = str.split(":", -1)[0];
                }
                return iconCompat;
            case 3:
                iconCompat.f116b = iconCompat.f117c;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.getClass();
        iconCompat.f123i = iconCompat.f122h.name();
        switch (iconCompat.f115a) {
            case -1:
                iconCompat.f118d = (Parcelable) iconCompat.f116b;
                break;
            case 1:
            case 5:
                iconCompat.f118d = (Parcelable) iconCompat.f116b;
                break;
            case 2:
                iconCompat.f117c = ((String) iconCompat.f116b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f117c = (byte[]) iconCompat.f116b;
                break;
            case 4:
            case 6:
                iconCompat.f117c = iconCompat.f116b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i2 = iconCompat.f115a;
        if (-1 != i2) {
            aVar.h(1);
            ((b) aVar).f1821e.writeInt(i2);
        }
        byte[] bArr = iconCompat.f117c;
        if (bArr != null) {
            aVar.h(2);
            int length = bArr.length;
            Parcel parcel = ((b) aVar).f1821e;
            parcel.writeInt(length);
            parcel.writeByteArray(bArr);
        }
        Parcelable parcelable = iconCompat.f118d;
        if (parcelable != null) {
            aVar.h(3);
            ((b) aVar).f1821e.writeParcelable(parcelable, 0);
        }
        int i3 = iconCompat.f119e;
        if (i3 != 0) {
            aVar.h(4);
            ((b) aVar).f1821e.writeInt(i3);
        }
        int i4 = iconCompat.f120f;
        if (i4 != 0) {
            aVar.h(5);
            ((b) aVar).f1821e.writeInt(i4);
        }
        ColorStateList colorStateList = iconCompat.f121g;
        if (colorStateList != null) {
            aVar.h(6);
            ((b) aVar).f1821e.writeParcelable(colorStateList, 0);
        }
        String str = iconCompat.f123i;
        if (str != null) {
            aVar.h(7);
            ((b) aVar).f1821e.writeString(str);
        }
        String str2 = iconCompat.f124j;
        if (str2 != null) {
            aVar.h(8);
            ((b) aVar).f1821e.writeString(str2);
        }
    }
}
