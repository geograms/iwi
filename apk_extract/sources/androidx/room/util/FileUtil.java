package androidx.room.util;

import android.annotation.SuppressLint;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import x0.g;

/* loaded from: classes.dex */
public final class FileUtil {
    @SuppressLint({"LambdaLast"})
    public static final void copy(ReadableByteChannel readableByteChannel, FileChannel fileChannel) {
        g.u(readableByteChannel, "input");
        g.u(fileChannel, "output");
        try {
            fileChannel.transferFrom(readableByteChannel, 0L, Long.MAX_VALUE);
            fileChannel.force(false);
        } finally {
            readableByteChannel.close();
            fileChannel.close();
        }
    }
}
