package androidx.emoji2.text;

import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public final class l extends x0.g {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x0.g f386c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ThreadPoolExecutor f387d;

    public l(x0.g gVar, ThreadPoolExecutor threadPoolExecutor) {
        this.f386c = gVar;
        this.f387d = threadPoolExecutor;
    }

    @Override // x0.g
    public final void e0(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.f387d;
        try {
            this.f386c.e0(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // x0.g
    public final void f0(u uVar) {
        ThreadPoolExecutor threadPoolExecutor = this.f387d;
        try {
            this.f386c.f0(uVar);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
