package s;

import android.graphics.Path;
import android.view.animation.PathInterpolator;

/* loaded from: classes.dex */
public abstract class a {
    public static PathInterpolator a(float f2, float f3) {
        return new PathInterpolator(f2, f3);
    }

    public static PathInterpolator b(float f2, float f3, float f4, float f5) {
        return new PathInterpolator(f2, f3, f4, f5);
    }

    public static PathInterpolator c(Path path) {
        return new PathInterpolator(path);
    }
}
