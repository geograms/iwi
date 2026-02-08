package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new androidx.activity.result.a(3);

    /* renamed from: a, reason: collision with root package name */
    public final int[] f443a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f444b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f445c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f446d;

    /* renamed from: e, reason: collision with root package name */
    public final int f447e;

    /* renamed from: f, reason: collision with root package name */
    public final String f448f;

    /* renamed from: g, reason: collision with root package name */
    public final int f449g;

    /* renamed from: h, reason: collision with root package name */
    public final int f450h;

    /* renamed from: i, reason: collision with root package name */
    public final CharSequence f451i;

    /* renamed from: j, reason: collision with root package name */
    public final int f452j;

    /* renamed from: k, reason: collision with root package name */
    public final CharSequence f453k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f454l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f455m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f456n;

    public b(a aVar) {
        int size = aVar.f523a.size();
        this.f443a = new int[size * 5];
        if (!aVar.f529g) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f444b = new ArrayList(size);
        this.f445c = new int[size];
        this.f446d = new int[size];
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            g1 g1Var = (g1) aVar.f523a.get(i3);
            int i4 = i2 + 1;
            this.f443a[i2] = g1Var.f512a;
            ArrayList arrayList = this.f444b;
            Fragment fragment = g1Var.f513b;
            arrayList.add(fragment != null ? fragment.mWho : null);
            int[] iArr = this.f443a;
            iArr[i4] = g1Var.f514c;
            iArr[i2 + 2] = g1Var.f515d;
            int i5 = i2 + 4;
            iArr[i2 + 3] = g1Var.f516e;
            i2 += 5;
            iArr[i5] = g1Var.f517f;
            this.f445c[i3] = g1Var.f518g.ordinal();
            this.f446d[i3] = g1Var.f519h.ordinal();
        }
        this.f447e = aVar.f528f;
        this.f448f = aVar.f530h;
        this.f449g = aVar.f434r;
        this.f450h = aVar.f531i;
        this.f451i = aVar.f532j;
        this.f452j = aVar.f533k;
        this.f453k = aVar.f534l;
        this.f454l = aVar.f535m;
        this.f455m = aVar.f536n;
        this.f456n = aVar.f537o;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.f443a);
        parcel.writeStringList(this.f444b);
        parcel.writeIntArray(this.f445c);
        parcel.writeIntArray(this.f446d);
        parcel.writeInt(this.f447e);
        parcel.writeString(this.f448f);
        parcel.writeInt(this.f449g);
        parcel.writeInt(this.f450h);
        TextUtils.writeToParcel(this.f451i, parcel, 0);
        parcel.writeInt(this.f452j);
        TextUtils.writeToParcel(this.f453k, parcel, 0);
        parcel.writeStringList(this.f454l);
        parcel.writeStringList(this.f455m);
        parcel.writeInt(this.f456n ? 1 : 0);
    }

    public b(Parcel parcel) {
        this.f443a = parcel.createIntArray();
        this.f444b = parcel.createStringArrayList();
        this.f445c = parcel.createIntArray();
        this.f446d = parcel.createIntArray();
        this.f447e = parcel.readInt();
        this.f448f = parcel.readString();
        this.f449g = parcel.readInt();
        this.f450h = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f451i = (CharSequence) creator.createFromParcel(parcel);
        this.f452j = parcel.readInt();
        this.f453k = (CharSequence) creator.createFromParcel(parcel);
        this.f454l = parcel.createStringArrayList();
        this.f455m = parcel.createStringArrayList();
        this.f456n = parcel.readInt() != 0;
    }
}
