package androidx.room;

import c0.h;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class SQLiteCopyOpenHelperFactory implements c0.g {
    private final String mCopyFromAssetPath;
    private final File mCopyFromFile;
    private final Callable<InputStream> mCopyFromInputStream;
    private final c0.g mDelegate;

    public SQLiteCopyOpenHelperFactory(String str, File file, Callable<InputStream> callable, c0.g gVar) {
        x0.g.u(gVar, "mDelegate");
        this.mCopyFromAssetPath = str;
        this.mCopyFromFile = file;
        this.mCopyFromInputStream = callable;
        this.mDelegate = gVar;
    }

    @Override // c0.g
    public h create(c0.f fVar) {
        x0.g.u(fVar, "configuration");
        return new SQLiteCopyOpenHelper(fVar.f1228a, this.mCopyFromAssetPath, this.mCopyFromFile, this.mCopyFromInputStream, fVar.f1230c.version, this.mDelegate.create(fVar));
    }
}
