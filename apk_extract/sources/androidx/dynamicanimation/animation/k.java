package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class k implements a {

    /* renamed from: p, reason: collision with root package name */
    public static final e f330p = new e("scaleX", 8);

    /* renamed from: q, reason: collision with root package name */
    public static final e f331q = new e("scaleY", 9);

    /* renamed from: r, reason: collision with root package name */
    public static final e f332r = new e("rotation", 10);

    /* renamed from: s, reason: collision with root package name */
    public static final e f333s = new e("rotationX", 11);

    /* renamed from: t, reason: collision with root package name */
    public static final e f334t = new e("rotationY", 12);

    /* renamed from: u, reason: collision with root package name */
    public static final e f335u = new e("alpha", 2);

    /* renamed from: d, reason: collision with root package name */
    public final Object f339d;

    /* renamed from: e, reason: collision with root package name */
    public final j f340e;

    /* renamed from: j, reason: collision with root package name */
    public final float f345j;

    /* renamed from: m, reason: collision with root package name */
    public l f348m;

    /* renamed from: n, reason: collision with root package name */
    public float f349n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f350o;

    /* renamed from: a, reason: collision with root package name */
    public float f336a = 0.0f;

    /* renamed from: b, reason: collision with root package name */
    public float f337b = Float.MAX_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public boolean f338c = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f341f = false;

    /* renamed from: g, reason: collision with root package name */
    public final float f342g = Float.MAX_VALUE;

    /* renamed from: h, reason: collision with root package name */
    public final float f343h = -3.4028235E38f;

    /* renamed from: i, reason: collision with root package name */
    public long f344i = 0;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f346k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f347l = new ArrayList();

    public k(Object obj, j jVar) {
        this.f339d = obj;
        this.f340e = jVar;
        if (jVar == f332r || jVar == f333s || jVar == f334t) {
            this.f345j = 0.1f;
        } else if (jVar == f335u || jVar == f330p || jVar == f331q) {
            this.f345j = 0.00390625f;
        } else {
            this.f345j = 1.0f;
        }
        this.f348m = null;
        this.f349n = Float.MAX_VALUE;
        this.f350o = false;
    }

    public final void a(float f2) {
        this.f340e.setValue(this.f339d, f2);
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f347l;
            if (i2 >= arrayList.size()) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (arrayList.get(size) == null) {
                        arrayList.remove(size);
                    }
                }
                return;
            }
            if (arrayList.get(i2) != null) {
                a.a.j(arrayList.get(i2));
                throw null;
            }
            i2++;
        }
    }

    public final void b() {
        if (this.f348m.f352b <= 0.0d) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f341f) {
            this.f350o = true;
        }
    }
}
