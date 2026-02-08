package androidx.room;

import c0.i;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class QueryInterceptorProgram implements i {
    private final List<Object> bindArgsCache = new ArrayList();

    private final void saveArgsToCache(int i2, Object obj) {
        int size;
        int i3 = i2 - 1;
        if (i3 >= this.bindArgsCache.size() && (size = this.bindArgsCache.size()) <= i3) {
            while (true) {
                this.bindArgsCache.add(null);
                if (size == i3) {
                    break;
                } else {
                    size++;
                }
            }
        }
        this.bindArgsCache.set(i3, obj);
    }

    @Override // c0.i
    public void bindBlob(int i2, byte[] bArr) {
        x0.g.u(bArr, "value");
        saveArgsToCache(i2, bArr);
    }

    @Override // c0.i
    public void bindDouble(int i2, double d2) {
        saveArgsToCache(i2, Double.valueOf(d2));
    }

    @Override // c0.i
    public void bindLong(int i2, long j2) {
        saveArgsToCache(i2, Long.valueOf(j2));
    }

    @Override // c0.i
    public void bindNull(int i2) {
        saveArgsToCache(i2, null);
    }

    @Override // c0.i
    public void bindString(int i2, String str) {
        x0.g.u(str, "value");
        saveArgsToCache(i2, str);
    }

    @Override // c0.i
    public void clearBindings() {
        this.bindArgsCache.clear();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final List<Object> getBindArgsCache$room_runtime_release() {
        return this.bindArgsCache;
    }
}
