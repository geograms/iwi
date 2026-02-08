package androidx.vectordrawable.graphics.drawable;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: p, reason: collision with root package name */
    public static final Matrix f1169p = new Matrix();

    /* renamed from: a, reason: collision with root package name */
    public final Path f1170a;

    /* renamed from: b, reason: collision with root package name */
    public final Path f1171b;

    /* renamed from: c, reason: collision with root package name */
    public final Matrix f1172c;

    /* renamed from: d, reason: collision with root package name */
    public Paint f1173d;

    /* renamed from: e, reason: collision with root package name */
    public Paint f1174e;

    /* renamed from: f, reason: collision with root package name */
    public PathMeasure f1175f;

    /* renamed from: g, reason: collision with root package name */
    public final k f1176g;

    /* renamed from: h, reason: collision with root package name */
    public float f1177h;

    /* renamed from: i, reason: collision with root package name */
    public float f1178i;

    /* renamed from: j, reason: collision with root package name */
    public float f1179j;

    /* renamed from: k, reason: collision with root package name */
    public float f1180k;

    /* renamed from: l, reason: collision with root package name */
    public int f1181l;

    /* renamed from: m, reason: collision with root package name */
    public String f1182m;

    /* renamed from: n, reason: collision with root package name */
    public Boolean f1183n;

    /* renamed from: o, reason: collision with root package name */
    public final g.b f1184o;

    public n() {
        this.f1172c = new Matrix();
        this.f1177h = 0.0f;
        this.f1178i = 0.0f;
        this.f1179j = 0.0f;
        this.f1180k = 0.0f;
        this.f1181l = 255;
        this.f1182m = null;
        this.f1183n = null;
        this.f1184o = new g.b();
        this.f1176g = new k();
        this.f1170a = new Path();
        this.f1171b = new Path();
    }

    public final void a(k kVar, Matrix matrix, Canvas canvas, int i2, int i3) {
        int i4;
        float f2;
        kVar.f1153a.set(matrix);
        Matrix matrix2 = kVar.f1153a;
        matrix2.preConcat(kVar.f1162j);
        canvas.save();
        char c2 = 0;
        int i5 = 0;
        while (true) {
            ArrayList arrayList = kVar.f1154b;
            if (i5 >= arrayList.size()) {
                canvas.restore();
                return;
            }
            l lVar = (l) arrayList.get(i5);
            if (lVar instanceof k) {
                a((k) lVar, matrix2, canvas, i2, i3);
            } else {
                if (lVar instanceof m) {
                    m mVar = (m) lVar;
                    float f3 = i2 / this.f1179j;
                    float f4 = i3 / this.f1180k;
                    float fMin = Math.min(f3, f4);
                    Matrix matrix3 = this.f1172c;
                    matrix3.set(matrix2);
                    matrix3.postScale(f3, f4);
                    float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                    matrix2.mapVectors(fArr);
                    float fHypot = (float) Math.hypot(fArr[c2], fArr[1]);
                    i4 = i5;
                    float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
                    float f5 = (fArr[0] * fArr[3]) - (fArr[1] * fArr[2]);
                    float fMax = Math.max(fHypot, fHypot2);
                    float fAbs = fMax > 0.0f ? Math.abs(f5) / fMax : 0.0f;
                    if (fAbs != 0.0f) {
                        mVar.getClass();
                        Path path = this.f1170a;
                        path.reset();
                        k.i[] iVarArr = mVar.f1165a;
                        if (iVarArr != null) {
                            k.i.b(iVarArr, path);
                        }
                        Path path2 = this.f1171b;
                        path2.reset();
                        if (mVar instanceof i) {
                            path2.setFillType(mVar.f1167c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                            path2.addPath(path, matrix3);
                            canvas.clipPath(path2);
                        } else {
                            j jVar = (j) mVar;
                            float f6 = jVar.f1147j;
                            if (f6 != 0.0f || jVar.f1148k != 1.0f) {
                                float f7 = jVar.f1149l;
                                float f8 = (f6 + f7) % 1.0f;
                                float f9 = (jVar.f1148k + f7) % 1.0f;
                                if (this.f1175f == null) {
                                    this.f1175f = new PathMeasure();
                                }
                                this.f1175f.setPath(path, false);
                                float length = this.f1175f.getLength();
                                float f10 = f8 * length;
                                float f11 = f9 * length;
                                path.reset();
                                if (f10 > f11) {
                                    this.f1175f.getSegment(f10, length, path, true);
                                    f2 = 0.0f;
                                    this.f1175f.getSegment(0.0f, f11, path, true);
                                } else {
                                    f2 = 0.0f;
                                    this.f1175f.getSegment(f10, f11, path, true);
                                }
                                path.rLineTo(f2, f2);
                            }
                            path2.addPath(path, matrix3);
                            j.d dVar = jVar.f1144g;
                            if ((dVar.f1855a == null && dVar.f1857c == 0) ? false : true) {
                                if (this.f1174e == null) {
                                    Paint paint = new Paint(1);
                                    this.f1174e = paint;
                                    paint.setStyle(Paint.Style.FILL);
                                }
                                Paint paint2 = this.f1174e;
                                Shader shader = dVar.f1855a;
                                if (shader != null) {
                                    shader.setLocalMatrix(matrix3);
                                    paint2.setShader(shader);
                                    paint2.setAlpha(Math.round(jVar.f1146i * 255.0f));
                                } else {
                                    paint2.setShader(null);
                                    paint2.setAlpha(255);
                                    int i6 = dVar.f1857c;
                                    float f12 = jVar.f1146i;
                                    PorterDuff.Mode mode = q.f1198j;
                                    paint2.setColor((i6 & 16777215) | (((int) (Color.alpha(i6) * f12)) << 24));
                                }
                                paint2.setColorFilter(null);
                                path2.setFillType(jVar.f1167c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                                canvas.drawPath(path2, paint2);
                            }
                            j.d dVar2 = jVar.f1142e;
                            if (dVar2.f1855a != null || dVar2.f1857c != 0) {
                                if (this.f1173d == null) {
                                    Paint paint3 = new Paint(1);
                                    this.f1173d = paint3;
                                    paint3.setStyle(Paint.Style.STROKE);
                                }
                                Paint paint4 = this.f1173d;
                                Paint.Join join = jVar.f1151n;
                                if (join != null) {
                                    paint4.setStrokeJoin(join);
                                }
                                Paint.Cap cap = jVar.f1150m;
                                if (cap != null) {
                                    paint4.setStrokeCap(cap);
                                }
                                paint4.setStrokeMiter(jVar.f1152o);
                                Shader shader2 = dVar2.f1855a;
                                if (shader2 != null) {
                                    shader2.setLocalMatrix(matrix3);
                                    paint4.setShader(shader2);
                                    paint4.setAlpha(Math.round(jVar.f1145h * 255.0f));
                                } else {
                                    paint4.setShader(null);
                                    paint4.setAlpha(255);
                                    int i7 = dVar2.f1857c;
                                    float f13 = jVar.f1145h;
                                    PorterDuff.Mode mode2 = q.f1198j;
                                    paint4.setColor((i7 & 16777215) | (((int) (Color.alpha(i7) * f13)) << 24));
                                }
                                paint4.setColorFilter(null);
                                paint4.setStrokeWidth(jVar.f1143f * fAbs * fMin);
                                canvas.drawPath(path2, paint4);
                            }
                        }
                    }
                }
                i5 = i4 + 1;
                c2 = 0;
            }
            i4 = i5;
            i5 = i4 + 1;
            c2 = 0;
        }
    }

    public float getAlpha() {
        return getRootAlpha() / 255.0f;
    }

    public int getRootAlpha() {
        return this.f1181l;
    }

    public void setAlpha(float f2) {
        setRootAlpha((int) (f2 * 255.0f));
    }

    public void setRootAlpha(int i2) {
        this.f1181l = i2;
    }

    public n(n nVar) {
        this.f1172c = new Matrix();
        this.f1177h = 0.0f;
        this.f1178i = 0.0f;
        this.f1179j = 0.0f;
        this.f1180k = 0.0f;
        this.f1181l = 255;
        this.f1182m = null;
        this.f1183n = null;
        g.b bVar = new g.b();
        this.f1184o = bVar;
        this.f1176g = new k(nVar.f1176g, bVar);
        this.f1170a = new Path(nVar.f1170a);
        this.f1171b = new Path(nVar.f1171b);
        this.f1177h = nVar.f1177h;
        this.f1178i = nVar.f1178i;
        this.f1179j = nVar.f1179j;
        this.f1180k = nVar.f1180k;
        this.f1181l = nVar.f1181l;
        this.f1182m = nVar.f1182m;
        String str = nVar.f1182m;
        if (str != null) {
            bVar.put(str, this);
        }
        this.f1183n = nVar.f1183n;
    }
}
