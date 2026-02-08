package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class p1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f585a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f586b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f587c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ArrayList f588d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ArrayList f589e;

    public p1(int i2, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.f585a = i2;
        this.f586b = arrayList;
        this.f587c = arrayList2;
        this.f588d = arrayList3;
        this.f589e = arrayList4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (int i2 = 0; i2 < this.f585a; i2++) {
            View view = (View) this.f586b.get(i2);
            String str = (String) this.f587c.get(i2);
            WeakHashMap weakHashMap = androidx.core.view.d1.f138a;
            androidx.core.view.s0.v(view, str);
            androidx.core.view.s0.v((View) this.f588d.get(i2), (String) this.f589e.get(i2));
        }
    }
}
