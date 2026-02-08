package androidx.recyclerview.widget;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class d2 {

    /* renamed from: a, reason: collision with root package name */
    public int f767a;

    /* renamed from: b, reason: collision with root package name */
    public int f768b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f769c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f770d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f771e;

    /* renamed from: f, reason: collision with root package name */
    public int[] f772f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ StaggeredGridLayoutManager f773g;

    public d2(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.f773g = staggeredGridLayoutManager;
        a();
    }

    public final void a() {
        this.f767a = -1;
        this.f768b = Integer.MIN_VALUE;
        this.f769c = false;
        this.f770d = false;
        this.f771e = false;
        int[] iArr = this.f772f;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
    }
}
