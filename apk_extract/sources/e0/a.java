package e0;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    public static final HashMap f1753e = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f1754a;

    /* renamed from: b, reason: collision with root package name */
    public final File f1755b;

    /* renamed from: c, reason: collision with root package name */
    public final Lock f1756c;

    /* renamed from: d, reason: collision with root package name */
    public FileChannel f1757d;

    public a(String str, File file, boolean z2) {
        Lock lock;
        this.f1754a = z2;
        this.f1755b = file != null ? new File(file, str.concat(".lck")) : null;
        HashMap map = f1753e;
        synchronized (map) {
            try {
                Object reentrantLock = map.get(str);
                if (reentrantLock == null) {
                    reentrantLock = new ReentrantLock();
                    map.put(str, reentrantLock);
                }
                lock = (Lock) reentrantLock;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f1756c = lock;
    }

    public final void a(boolean z2) throws IOException {
        this.f1756c.lock();
        if (z2) {
            File file = this.f1755b;
            try {
                if (file == null) {
                    throw new IOException("No lock directory was provided.");
                }
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileChannel channel = new FileOutputStream(file).getChannel();
                channel.lock();
                this.f1757d = channel;
            } catch (IOException e2) {
                this.f1757d = null;
                Log.w("SupportSQLiteLock", "Unable to grab file lock.", e2);
            }
        }
    }

    public final void b() throws IOException {
        try {
            FileChannel fileChannel = this.f1757d;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.f1756c.unlock();
    }
}
