package o;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final g.f f2230a = new g.f(16);

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadPoolExecutor f2231b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f2232c;

    /* renamed from: d, reason: collision with root package name */
    public static final g.l f2233d;

    static {
        m mVar = new m();
        mVar.f2242a = "fonts-androidx";
        mVar.f2243b = 10;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), mVar);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f2231b = threadPoolExecutor;
        f2232c = new Object();
        f2233d = new g.l();
    }

    public static h a(String str, Context context, e eVar, int i2) throws Throwable {
        g.f fVar = f2230a;
        Typeface typeface = (Typeface) fVar.get(str);
        if (typeface != null) {
            return new h(typeface);
        }
        try {
            j jVarA = d.a(context, eVar);
            int i3 = jVarA.f2234a;
            int i4 = 1;
            Object[] objArr = jVarA.f2235b;
            if (i3 != 0) {
                i4 = i3 != 1 ? -3 : -2;
            } else {
                k[] kVarArr = (k[]) objArr;
                if (kVarArr != null && kVarArr.length != 0) {
                    int length = kVarArr.length;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length) {
                            i4 = 0;
                            break;
                        }
                        int i6 = kVarArr[i5].f2240e;
                        if (i6 == 0) {
                            i5++;
                        } else if (i6 >= 0) {
                            i4 = i6;
                        }
                    }
                }
            }
            if (i4 != 0) {
                return new h(i4);
            }
            Typeface typefaceN = k.k.f1935a.n(context, (k[]) objArr, i2);
            if (typefaceN == null) {
                return new h(-3);
            }
            fVar.put(str, typefaceN);
            return new h(typefaceN);
        } catch (PackageManager.NameNotFoundException unused) {
            return new h(-1);
        }
    }
}
