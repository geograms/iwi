package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.solver.widgets.Optimizer;

/* loaded from: classes.dex */
public final class c1 implements Parcelable {
    public static final Parcelable.Creator<c1> CREATOR = new androidx.activity.result.a(6);

    /* renamed from: a, reason: collision with root package name */
    public final String f463a;

    /* renamed from: b, reason: collision with root package name */
    public final String f464b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f465c;

    /* renamed from: d, reason: collision with root package name */
    public final int f466d;

    /* renamed from: e, reason: collision with root package name */
    public final int f467e;

    /* renamed from: f, reason: collision with root package name */
    public final String f468f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f469g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f470h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f471i;

    /* renamed from: j, reason: collision with root package name */
    public final Bundle f472j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f473k;

    /* renamed from: l, reason: collision with root package name */
    public final int f474l;

    /* renamed from: m, reason: collision with root package name */
    public Bundle f475m;

    public c1(Fragment fragment) {
        this.f463a = fragment.getClass().getName();
        this.f464b = fragment.mWho;
        this.f465c = fragment.mFromLayout;
        this.f466d = fragment.mFragmentId;
        this.f467e = fragment.mContainerId;
        this.f468f = fragment.mTag;
        this.f469g = fragment.mRetainInstance;
        this.f470h = fragment.mRemoving;
        this.f471i = fragment.mDetached;
        this.f472j = fragment.mArguments;
        this.f473k = fragment.mHidden;
        this.f474l = fragment.mMaxState.ordinal();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(Optimizer.OPTIMIZATION_GRAPH_WRAP);
        sb.append("FragmentState{");
        sb.append(this.f463a);
        sb.append(" (");
        sb.append(this.f464b);
        sb.append(")}:");
        if (this.f465c) {
            sb.append(" fromLayout");
        }
        int i2 = this.f467e;
        if (i2 != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(i2));
        }
        String str = this.f468f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(str);
        }
        if (this.f469g) {
            sb.append(" retainInstance");
        }
        if (this.f470h) {
            sb.append(" removing");
        }
        if (this.f471i) {
            sb.append(" detached");
        }
        if (this.f473k) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f463a);
        parcel.writeString(this.f464b);
        parcel.writeInt(this.f465c ? 1 : 0);
        parcel.writeInt(this.f466d);
        parcel.writeInt(this.f467e);
        parcel.writeString(this.f468f);
        parcel.writeInt(this.f469g ? 1 : 0);
        parcel.writeInt(this.f470h ? 1 : 0);
        parcel.writeInt(this.f471i ? 1 : 0);
        parcel.writeBundle(this.f472j);
        parcel.writeInt(this.f473k ? 1 : 0);
        parcel.writeBundle(this.f475m);
        parcel.writeInt(this.f474l);
    }

    public c1(Parcel parcel) {
        this.f463a = parcel.readString();
        this.f464b = parcel.readString();
        this.f465c = parcel.readInt() != 0;
        this.f466d = parcel.readInt();
        this.f467e = parcel.readInt();
        this.f468f = parcel.readString();
        this.f469g = parcel.readInt() != 0;
        this.f470h = parcel.readInt() != 0;
        this.f471i = parcel.readInt() != 0;
        this.f472j = parcel.readBundle();
        this.f473k = parcel.readInt() != 0;
        this.f475m = parcel.readBundle();
        this.f474l = parcel.readInt();
    }
}
