package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
import java.util.Locale;

/* loaded from: classes.dex */
public final class j implements i, k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f164a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final ClipData f165b;

    /* renamed from: c, reason: collision with root package name */
    public final int f166c;

    /* renamed from: d, reason: collision with root package name */
    public int f167d;

    /* renamed from: e, reason: collision with root package name */
    public Uri f168e;

    /* renamed from: f, reason: collision with root package name */
    public Bundle f169f;

    public j(j jVar) {
        ClipData clipData = jVar.f165b;
        clipData.getClass();
        this.f165b = clipData;
        int i2 = jVar.f166c;
        if (i2 < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", "source", 0, 5));
        }
        if (i2 > 5) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", "source", 0, 5));
        }
        this.f166c = i2;
        int i3 = jVar.f167d;
        if ((i3 & 1) == i3) {
            this.f167d = i3;
            this.f168e = jVar.f168e;
            this.f169f = jVar.f169f;
        } else {
            throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i3) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
        }
    }

    @Override // androidx.core.view.i
    public final l a() {
        return new l(new j(this));
    }

    @Override // androidx.core.view.k
    public final ClipData b() {
        return this.f165b;
    }

    @Override // androidx.core.view.i
    public final void c(Uri uri) {
        this.f168e = uri;
    }

    @Override // androidx.core.view.k
    public final int d() {
        return this.f167d;
    }

    @Override // androidx.core.view.i
    public final void e(int i2) {
        this.f167d = i2;
    }

    @Override // androidx.core.view.k
    public final ContentInfo g() {
        return null;
    }

    @Override // androidx.core.view.k
    public final int h() {
        return this.f166c;
    }

    @Override // androidx.core.view.i
    public final void setExtras(Bundle bundle) {
        this.f169f = bundle;
    }

    public final String toString() {
        String str;
        switch (this.f164a) {
            case 1:
                StringBuilder sb = new StringBuilder("ContentInfoCompat{clip=");
                sb.append(this.f165b.getDescription());
                sb.append(", source=");
                int i2 = this.f166c;
                sb.append(i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? String.valueOf(i2) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP");
                sb.append(", flags=");
                int i3 = this.f167d;
                sb.append((i3 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i3));
                if (this.f168e == null) {
                    str = "";
                } else {
                    str = ", hasLinkUri(" + this.f168e.toString().length() + ")";
                }
                sb.append(str);
                return a.a.e(sb, this.f169f != null ? ", hasExtras" : "", "}");
            default:
                return super.toString();
        }
    }

    public j(ClipData clipData, int i2) {
        this.f165b = clipData;
        this.f166c = i2;
    }
}
