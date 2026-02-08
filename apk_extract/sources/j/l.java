package j;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final ColorStateList f1868a;

    /* renamed from: b, reason: collision with root package name */
    public final Configuration f1869b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1870c;

    public l(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
        this.f1868a = colorStateList;
        this.f1869b = configuration;
        this.f1870c = theme == null ? 0 : theme.hashCode();
    }
}
