package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Handler;
import java.nio.MappedByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class r implements i {

    /* renamed from: a, reason: collision with root package name */
    public final Context f403a;

    /* renamed from: b, reason: collision with root package name */
    public final o.e f404b;

    /* renamed from: c, reason: collision with root package name */
    public final c.c f405c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f406d;

    /* renamed from: e, reason: collision with root package name */
    public Handler f407e;

    /* renamed from: f, reason: collision with root package name */
    public Executor f408f;

    /* renamed from: g, reason: collision with root package name */
    public ThreadPoolExecutor f409g;

    /* renamed from: h, reason: collision with root package name */
    public x0.g f410h;

    public r(Context context, o.e eVar) {
        c.c cVar = s.f411d;
        this.f406d = new Object();
        if (context == null) {
            throw new NullPointerException("Context cannot be null");
        }
        this.f403a = context.getApplicationContext();
        this.f404b = eVar;
        this.f405c = cVar;
    }

    public final void a() {
        synchronized (this.f406d) {
            try {
                this.f410h = null;
                Handler handler = this.f407e;
                if (handler != null) {
                    handler.removeCallbacks(null);
                }
                this.f407e = null;
                ThreadPoolExecutor threadPoolExecutor = this.f409g;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f408f = null;
                this.f409g = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (this.f406d) {
            try {
                if (this.f410h == null) {
                    return;
                }
                if (this.f408f == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a("emojiCompat"));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    this.f409g = threadPoolExecutor;
                    this.f408f = threadPoolExecutor;
                }
                final int i2 = 0;
                this.f408f.execute(new Runnable(this) { // from class: androidx.emoji2.text.q

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ r f402b;

                    {
                        this.f402b = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        int i3 = i2;
                        r rVar = this.f402b;
                        switch (i3) {
                            case 0:
                                synchronized (rVar.f406d) {
                                    try {
                                        if (rVar.f410h == null) {
                                            return;
                                        }
                                        try {
                                            o.k kVarC = rVar.c();
                                            int i4 = kVarC.f2240e;
                                            if (i4 == 2) {
                                                synchronized (rVar.f406d) {
                                                }
                                            }
                                            if (i4 != 0) {
                                                throw new RuntimeException("fetchFonts result is not OK. (" + i4 + ")");
                                            }
                                            try {
                                                n.e.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                                                c.c cVar = rVar.f405c;
                                                Context context = rVar.f403a;
                                                cVar.getClass();
                                                Typeface typefaceN = k.k.f1935a.n(context, new o.k[]{kVarC}, 0);
                                                MappedByteBuffer mappedByteBufferC0 = x0.g.c0(rVar.f403a, kVarC.f2236a);
                                                if (mappedByteBufferC0 == null || typefaceN == null) {
                                                    throw new RuntimeException("Unable to open file.");
                                                }
                                                try {
                                                    n.e.a("EmojiCompat.MetadataRepo.create");
                                                    u uVar = new u(typefaceN, x0.g.p0(mappedByteBufferC0));
                                                    n.e.b();
                                                    synchronized (rVar.f406d) {
                                                        try {
                                                            x0.g gVar = rVar.f410h;
                                                            if (gVar != null) {
                                                                gVar.f0(uVar);
                                                            }
                                                        } finally {
                                                        }
                                                    }
                                                    rVar.a();
                                                    return;
                                                } finally {
                                                    n.e.b();
                                                }
                                            } catch (Throwable th) {
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            synchronized (rVar.f406d) {
                                                try {
                                                    x0.g gVar2 = rVar.f410h;
                                                    if (gVar2 != null) {
                                                        gVar2.e0(th2);
                                                    }
                                                    rVar.a();
                                                    return;
                                                } finally {
                                                }
                                            }
                                        }
                                    } finally {
                                    }
                                }
                            default:
                                rVar.b();
                                return;
                        }
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final o.k c() throws Throwable {
        try {
            c.c cVar = this.f405c;
            Context context = this.f403a;
            o.e eVar = this.f404b;
            cVar.getClass();
            o.j jVarA = o.d.a(context, eVar);
            if (jVarA.f2234a != 0) {
                throw new RuntimeException("fetchFonts failed (" + jVarA.f2234a + ")");
            }
            o.k[] kVarArr = (o.k[]) jVarA.f2235b;
            if (kVarArr == null || kVarArr.length == 0) {
                throw new RuntimeException("fetchFonts failed (empty result)");
            }
            return kVarArr[0];
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException("provider not found", e2);
        }
    }

    @Override // androidx.emoji2.text.i
    public final void e(x0.g gVar) {
        synchronized (this.f406d) {
            this.f410h = gVar;
        }
        b();
    }
}
