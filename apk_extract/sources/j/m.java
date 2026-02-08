package j;

import android.content.res.Resources;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final Resources f1871a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources.Theme f1872b;

    public m(Resources resources, Resources.Theme theme) {
        this.f1871a = resources;
        this.f1872b = theme;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        return this.f1871a.equals(mVar.f1871a) && q.b.a(this.f1872b, mVar.f1872b);
    }

    public final int hashCode() {
        return q.b.b(this.f1871a, this.f1872b);
    }
}
