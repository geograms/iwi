package o;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public final class m implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public String f2242a;

    /* renamed from: b, reason: collision with root package name */
    public int f2243b;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new l(runnable, this.f2242a, this.f2243b);
    }
}
