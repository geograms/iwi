package d0;

/* loaded from: classes.dex */
public final class f extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final int f1715a;

    /* renamed from: b, reason: collision with root package name */
    public final Throwable f1716b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(int i2, Throwable th) {
        super(th);
        a.a.i(i2, "callbackName");
        this.f1715a = i2;
        this.f1716b = th;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.f1716b;
    }
}
