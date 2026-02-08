package androidx.emoji2.text;

import android.content.Context;
import androidx.room.QueryInterceptorDatabase;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f382a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f383b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f384c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f385d;

    public /* synthetic */ k(Object obj, Object obj2, Object obj3, int i2) {
        this.f382a = i2;
        this.f383b = obj;
        this.f384c = obj2;
        this.f385d = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f382a) {
            case 0:
                k.j jVar = (k.j) this.f383b;
                x0.g gVar = (x0.g) this.f384c;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.f385d;
                jVar.getClass();
                try {
                    s sVarE = x0.g.E((Context) jVar.f1934b);
                    if (sVarE == null) {
                        throw new RuntimeException("EmojiCompat font provider not available on this device.");
                    }
                    r rVar = (r) sVarE.f369a;
                    synchronized (rVar.f406d) {
                        rVar.f408f = threadPoolExecutor;
                    }
                    sVarE.f369a.e(new l(gVar, threadPoolExecutor));
                    return;
                } catch (Throwable th) {
                    gVar.e0(th);
                    threadPoolExecutor.shutdown();
                    return;
                }
            case 1:
                QueryInterceptorDatabase.query$lambda$7((QueryInterceptorDatabase) this.f383b, (String) this.f384c, (Object[]) this.f385d);
                return;
            default:
                QueryInterceptorDatabase.execSQL$lambda$12((QueryInterceptorDatabase) this.f383b, (String) this.f384c, (List) this.f385d);
                return;
        }
    }
}
