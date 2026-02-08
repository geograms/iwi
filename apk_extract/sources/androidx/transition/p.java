package androidx.transition;

import android.graphics.Path;

/* loaded from: classes.dex */
public final class p extends n {
    @Override // androidx.transition.n
    public final Path getPath(float f2, float f3, float f4, float f5) {
        Path path = new Path();
        path.moveTo(f2, f3);
        path.lineTo(f4, f5);
        return path;
    }
}
