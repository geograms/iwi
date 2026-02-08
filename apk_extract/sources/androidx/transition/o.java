package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;

/* loaded from: classes.dex */
public final class o extends n {

    /* renamed from: a, reason: collision with root package name */
    public final Path f1106a;

    /* renamed from: b, reason: collision with root package name */
    public final Matrix f1107b;

    public o(Path path) {
        Path path2 = new Path();
        this.f1106a = path2;
        Matrix matrix = new Matrix();
        this.f1107b = matrix;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, null);
        float f2 = fArr[0];
        float f3 = fArr[1];
        pathMeasure.getPosTan(0.0f, fArr, null);
        float f4 = fArr[0];
        float f5 = fArr[1];
        if (f4 == f2 && f5 == f3) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        matrix.setTranslate(-f4, -f5);
        float f6 = f3 - f5;
        float fSqrt = 1.0f / ((float) Math.sqrt((f6 * f6) + (r3 * r3)));
        matrix.postScale(fSqrt, fSqrt);
        matrix.postRotate((float) Math.toDegrees(-Math.atan2(f6, f2 - f4)));
        path.transform(matrix, path2);
    }

    @Override // androidx.transition.n
    public final Path getPath(float f2, float f3, float f4, float f5) {
        float f6 = f5 - f3;
        float fSqrt = (float) Math.sqrt((f6 * f6) + (r6 * r6));
        double dAtan2 = Math.atan2(f6, f4 - f2);
        Matrix matrix = this.f1107b;
        matrix.setScale(fSqrt, fSqrt);
        matrix.postRotate((float) Math.toDegrees(dAtan2));
        matrix.postTranslate(f2, f3);
        Path path = new Path();
        this.f1106a.transform(matrix, path);
        return path;
    }
}
