package kotlinx.coroutines.scheduling;

/* loaded from: classes.dex */
public final class d extends g {

    /* renamed from: c, reason: collision with root package name */
    public static final d f2065c = new d(k.f2073b, k.f2074c, k.f2075d);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // j1.c
    public final String toString() {
        return "Dispatchers.Default";
    }
}
