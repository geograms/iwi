package androidx.core.view;

import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
public abstract class k0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f178a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f179b;

    /* renamed from: c, reason: collision with root package name */
    public final int f180c;

    /* renamed from: d, reason: collision with root package name */
    public final int f181d;

    public k0(int i2, Class cls, int i3, int i4) {
        this.f178a = i2;
        this.f179b = cls;
        this.f181d = i3;
        this.f180c = i4;
    }

    public final Object a(View view) {
        if (Build.VERSION.SDK_INT < this.f180c) {
            Object tag = view.getTag(this.f178a);
            if (this.f179b.isInstance(tag)) {
                return tag;
            }
            return null;
        }
        int i2 = ((i0) this).f160e;
        switch (i2) {
            case 0:
                switch (i2) {
                    case 0:
                        return Boolean.valueOf(x0.d(view));
                    default:
                        return Boolean.valueOf(x0.c(view));
                }
            case 1:
                switch (i2) {
                    case 1:
                        return x0.b(view);
                    default:
                        return z0.a(view);
                }
            case 2:
                switch (i2) {
                    case 1:
                        return x0.b(view);
                    default:
                        return z0.a(view);
                }
            default:
                switch (i2) {
                    case 0:
                        return Boolean.valueOf(x0.d(view));
                    default:
                        return Boolean.valueOf(x0.c(view));
                }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:23:0x0064. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(android.view.View r6, java.lang.Object r7) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.k0.b(android.view.View, java.lang.Object):void");
    }
}
