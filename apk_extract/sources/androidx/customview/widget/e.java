package androidx.customview.widget;

import android.graphics.Rect;
import java.util.Comparator;

/* loaded from: classes.dex */
public final class e implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f261a = new Rect();

    /* renamed from: b, reason: collision with root package name */
    public final Rect f262b = new Rect();

    /* renamed from: c, reason: collision with root package name */
    public final boolean f263c;

    /* renamed from: d, reason: collision with root package name */
    public final c f264d;

    public e(boolean z2, c cVar) {
        this.f263c = z2;
        this.f264d = cVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        c.c cVar = (c.c) this.f264d;
        cVar.getClass();
        Rect rect = this.f261a;
        ((r.g) obj).d(rect);
        cVar.getClass();
        Rect rect2 = this.f262b;
        ((r.g) obj2).d(rect2);
        int i2 = rect.top;
        int i3 = rect2.top;
        if (i2 < i3) {
            return -1;
        }
        if (i2 > i3) {
            return 1;
        }
        int i4 = rect.left;
        int i5 = rect2.left;
        boolean z2 = this.f263c;
        if (i4 < i5) {
            return z2 ? 1 : -1;
        }
        if (i4 > i5) {
            return z2 ? -1 : 1;
        }
        int i6 = rect.bottom;
        int i7 = rect2.bottom;
        if (i6 < i7) {
            return -1;
        }
        if (i6 > i7) {
            return 1;
        }
        int i8 = rect.right;
        int i9 = rect2.right;
        if (i8 < i9) {
            return z2 ? 1 : -1;
        }
        if (i8 > i9) {
            return z2 ? -1 : 1;
        }
        return 0;
    }
}
