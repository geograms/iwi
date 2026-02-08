package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import g0.a;
import g0.b;
import g0.c;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        c cVarG = remoteActionCompat.f104a;
        if (aVar.e(1)) {
            cVarG = aVar.g();
        }
        remoteActionCompat.f104a = (IconCompat) cVarG;
        CharSequence charSequence = remoteActionCompat.f105b;
        if (aVar.e(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((b) aVar).f1821e);
        }
        remoteActionCompat.f105b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.f106c;
        if (aVar.e(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((b) aVar).f1821e);
        }
        remoteActionCompat.f106c = charSequence2;
        remoteActionCompat.f107d = (PendingIntent) aVar.f(remoteActionCompat.f107d, 4);
        boolean z2 = remoteActionCompat.f108e;
        if (aVar.e(5)) {
            z2 = ((b) aVar).f1821e.readInt() != 0;
        }
        remoteActionCompat.f108e = z2;
        boolean z3 = remoteActionCompat.f109f;
        if (aVar.e(6)) {
            z3 = ((b) aVar).f1821e.readInt() != 0;
        }
        remoteActionCompat.f109f = z3;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        aVar.getClass();
        IconCompat iconCompat = remoteActionCompat.f104a;
        aVar.h(1);
        aVar.i(iconCompat);
        CharSequence charSequence = remoteActionCompat.f105b;
        aVar.h(2);
        Parcel parcel = ((b) aVar).f1821e;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.f106c;
        aVar.h(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        PendingIntent pendingIntent = remoteActionCompat.f107d;
        aVar.h(4);
        parcel.writeParcelable(pendingIntent, 0);
        boolean z2 = remoteActionCompat.f108e;
        aVar.h(5);
        parcel.writeInt(z2 ? 1 : 0);
        boolean z3 = remoteActionCompat.f109f;
        aVar.h(6);
        parcel.writeInt(z3 ? 1 : 0);
    }
}
