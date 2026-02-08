package o;

import android.graphics.Typeface;
import android.os.Handler;
import j.p;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2210a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2211b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f2212c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f2213d;

    public /* synthetic */ a(Object obj, Object obj2, Object obj3, int i2) {
        this.f2210a = i2;
        this.f2213d = obj;
        this.f2211b = obj2;
        this.f2212c = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() throws Exception {
        Object objCall;
        Object obj = this.f2212c;
        Object obj2 = this.f2211b;
        switch (this.f2210a) {
            case 0:
                Typeface typeface = (Typeface) obj;
                p pVar = (p) ((k.j) obj2).f1934b;
                if (pVar != null) {
                    pVar.onFontRetrieved(typeface);
                    break;
                }
                break;
            case 1:
                ((g) ((q.a) obj2)).a(obj);
                break;
            default:
                try {
                    objCall = ((Callable) obj2).call();
                } catch (Exception unused) {
                    objCall = null;
                }
                ((Handler) this.f2213d).post(new a(this, (q.a) obj, objCall, 1));
                break;
        }
    }
}
