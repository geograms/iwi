package c0;

import java.io.Closeable;

/* loaded from: classes.dex */
public interface h extends Closeable {
    String getDatabaseName();

    b getReadableDatabase();

    b getWritableDatabase();

    void setWriteAheadLoggingEnabled(boolean z2);
}
