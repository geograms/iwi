package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;

/* loaded from: classes.dex */
public final class h implements i {

    /* renamed from: a, reason: collision with root package name */
    public final ContentInfo.Builder f158a;

    public h(ClipData clipData, int i2) {
        this.f158a = g.d(clipData, i2);
    }

    @Override // androidx.core.view.i
    public final l a() {
        return new l(new k.j(this.f158a.build()));
    }

    @Override // androidx.core.view.i
    public final void c(Uri uri) {
        this.f158a.setLinkUri(uri);
    }

    @Override // androidx.core.view.i
    public final void e(int i2) {
        this.f158a.setFlags(i2);
    }

    @Override // androidx.core.view.i
    public final void setExtras(Bundle bundle) {
        this.f158a.setExtras(bundle);
    }
}
