package c;

import android.view.accessibility.AccessibilityNodeInfo;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1221a;

    public /* synthetic */ a(Object obj) {
        this.f1221a = obj;
    }

    public static a a(int i2, int i3, int i4, int i5, boolean z2, boolean z3) {
        return new a(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z2, z3));
    }

    public static a b(int i2, int i3, int i4, boolean z2) {
        return new a(AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, z2, i4));
    }
}
