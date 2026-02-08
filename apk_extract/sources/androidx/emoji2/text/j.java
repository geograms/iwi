package androidx.emoji2.text;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: i, reason: collision with root package name */
    public static final Object f372i = new Object();

    /* renamed from: j, reason: collision with root package name */
    public static volatile j f373j;

    /* renamed from: a, reason: collision with root package name */
    public final ReentrantReadWriteLock f374a;

    /* renamed from: b, reason: collision with root package name */
    public final g.c f375b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f376c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f377d;

    /* renamed from: e, reason: collision with root package name */
    public final e f378e;

    /* renamed from: f, reason: collision with root package name */
    public final i f379f;

    /* renamed from: g, reason: collision with root package name */
    public final int f380g;

    /* renamed from: h, reason: collision with root package name */
    public final c f381h;

    public j(s sVar) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f374a = reentrantReadWriteLock;
        this.f376c = 3;
        this.f379f = sVar.f369a;
        int i2 = sVar.f370b;
        this.f380g = i2;
        this.f381h = sVar.f371c;
        this.f377d = new Handler(Looper.getMainLooper());
        this.f375b = new g.c(0);
        e eVar = new e(11, this);
        this.f378e = eVar;
        reentrantReadWriteLock.writeLock().lock();
        if (i2 == 0) {
            try {
                this.f376c = 0;
            } catch (Throwable th) {
                this.f374a.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (b() == 0) {
            eVar.n();
        }
    }

    public static j a() {
        j jVar;
        synchronized (f372i) {
            try {
                jVar = f373j;
                if (!(jVar != null)) {
                    throw new IllegalStateException("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
                }
            } finally {
            }
        }
        return jVar;
    }

    public final int b() {
        this.f374a.readLock().lock();
        try {
            return this.f376c;
        } finally {
            this.f374a.readLock().unlock();
        }
    }

    public final void c() {
        if (!(this.f380g == 1)) {
            throw new IllegalStateException("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        }
        if (b() == 1) {
            return;
        }
        this.f374a.writeLock().lock();
        try {
            if (this.f376c == 0) {
                return;
            }
            this.f376c = 0;
            this.f374a.writeLock().unlock();
            this.f378e.n();
        } finally {
            this.f374a.writeLock().unlock();
        }
    }

    public final void d(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f374a.writeLock().lock();
        try {
            this.f376c = 2;
            arrayList.addAll(this.f375b);
            this.f375b.clear();
            this.f374a.writeLock().unlock();
            this.f377d.post(new androidx.activity.e(arrayList, this.f376c, th));
        } catch (Throwable th2) {
            this.f374a.writeLock().unlock();
            throw th2;
        }
    }

    public final void e() {
        ArrayList arrayList = new ArrayList();
        this.f374a.writeLock().lock();
        try {
            this.f376c = 1;
            arrayList.addAll(this.f375b);
            this.f375b.clear();
            this.f374a.writeLock().unlock();
            this.f377d.post(new androidx.activity.e(this.f376c, arrayList));
        } catch (Throwable th) {
            this.f374a.writeLock().unlock();
            throw th;
        }
    }

    public final CharSequence f(int i2, int i3, CharSequence charSequence) {
        if (!(b() == 1)) {
            throw new IllegalStateException("Not initialized yet");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("start cannot be negative");
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("end cannot be negative");
        }
        x0.g.o("start should be <= than end", i2 <= i3);
        if (charSequence == null) {
            return null;
        }
        x0.g.o("start should be < than charSequence length", i2 <= charSequence.length());
        x0.g.o("end should be < than charSequence length", i3 <= charSequence.length());
        return (charSequence.length() == 0 || i2 == i3) ? charSequence : this.f378e.o(charSequence, i2, i3, false);
    }

    public final void g(h hVar) {
        if (hVar == null) {
            throw new NullPointerException("initCallback cannot be null");
        }
        this.f374a.writeLock().lock();
        try {
            if (this.f376c == 1 || this.f376c == 2) {
                this.f377d.post(new androidx.activity.e(hVar, this.f376c));
            } else {
                this.f375b.add(hVar);
            }
            this.f374a.writeLock().unlock();
        } catch (Throwable th) {
            this.f374a.writeLock().unlock();
            throw th;
        }
    }
}
