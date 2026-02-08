package k;

import android.graphics.Path;
import android.util.Log;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public char f1931a;

    /* renamed from: b, reason: collision with root package name */
    public float[] f1932b;

    public static void a(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z2, boolean z3) {
        double d2;
        double d3;
        double radians = Math.toRadians(f8);
        double dCos = Math.cos(radians);
        double dSin = Math.sin(radians);
        double d4 = f2;
        double d5 = f3;
        double d6 = (d5 * dSin) + (d4 * dCos);
        double d7 = d4;
        double d8 = f6;
        double d9 = d6 / d8;
        double d10 = f7;
        double d11 = ((d5 * dCos) + ((-f2) * dSin)) / d10;
        double d12 = d5;
        double d13 = f5;
        double d14 = ((d13 * dSin) + (f4 * dCos)) / d8;
        double d15 = ((d13 * dCos) + ((-f4) * dSin)) / d10;
        double d16 = d9 - d14;
        double d17 = d11 - d15;
        double d18 = (d9 + d14) / 2.0d;
        double d19 = (d11 + d15) / 2.0d;
        double d20 = (d17 * d17) + (d16 * d16);
        if (d20 == 0.0d) {
            Log.w("PathParser", " Points are coincident");
            return;
        }
        double d21 = (1.0d / d20) - 0.25d;
        if (d21 < 0.0d) {
            Log.w("PathParser", "Points are too far apart " + d20);
            float fSqrt = (float) (Math.sqrt(d20) / 1.99999d);
            a(path, f2, f3, f4, f5, f6 * fSqrt, f7 * fSqrt, f8, z2, z3);
            return;
        }
        double dSqrt = Math.sqrt(d21);
        double d22 = d16 * dSqrt;
        double d23 = dSqrt * d17;
        if (z2 == z3) {
            d2 = d18 - d23;
            d3 = d19 + d22;
        } else {
            d2 = d18 + d23;
            d3 = d19 - d22;
        }
        double dAtan2 = Math.atan2(d11 - d3, d9 - d2);
        double dAtan22 = Math.atan2(d15 - d3, d14 - d2) - dAtan2;
        if (z3 != (dAtan22 >= 0.0d)) {
            dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
        }
        double d24 = d2 * d8;
        double d25 = d3 * d10;
        double d26 = (d24 * dCos) - (d25 * dSin);
        double d27 = (d25 * dCos) + (d24 * dSin);
        int iCeil = (int) Math.ceil(Math.abs((dAtan22 * 4.0d) / 3.141592653589793d));
        double dCos2 = Math.cos(radians);
        double dSin2 = Math.sin(radians);
        double dCos3 = Math.cos(dAtan2);
        double dSin3 = Math.sin(dAtan2);
        double d28 = -d8;
        double d29 = d28 * dCos2;
        double d30 = d10 * dSin2;
        double d31 = (d29 * dSin3) - (d30 * dCos3);
        double d32 = d28 * dSin2;
        double d33 = d10 * dCos2;
        double d34 = (dCos3 * d33) + (dSin3 * d32);
        double d35 = d33;
        double d36 = dAtan22 / iCeil;
        int i2 = 0;
        while (i2 < iCeil) {
            double d37 = dAtan2 + d36;
            double dSin4 = Math.sin(d37);
            double dCos4 = Math.cos(d37);
            double d38 = d36;
            double d39 = (((d8 * dCos2) * dCos4) + d26) - (d30 * dSin4);
            double d40 = d35;
            double d41 = d26;
            double d42 = (d40 * dSin4) + (d8 * dSin2 * dCos4) + d27;
            double d43 = (d29 * dSin4) - (d30 * dCos4);
            double d44 = (dCos4 * d40) + (dSin4 * d32);
            double d45 = d37 - dAtan2;
            double dTan = Math.tan(d45 / 2.0d);
            double dSqrt2 = ((Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d) * Math.sin(d45)) / 3.0d;
            path.rLineTo(0.0f, 0.0f);
            path.cubicTo((float) ((d31 * dSqrt2) + d7), (float) ((d34 * dSqrt2) + d12), (float) (d39 - (dSqrt2 * d43)), (float) (d42 - (dSqrt2 * d44)), (float) d39, (float) d42);
            i2++;
            dAtan2 = d37;
            d32 = d32;
            dCos2 = dCos2;
            iCeil = iCeil;
            d34 = d44;
            d8 = d8;
            d31 = d43;
            d7 = d39;
            d12 = d42;
            d26 = d41;
            d36 = d38;
            d35 = d40;
        }
    }

    public static void b(i[] iVarArr, Path path) {
        int i2;
        int i3;
        float[] fArr;
        char c2;
        int i4;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        i[] iVarArr2 = iVarArr;
        int i5 = 6;
        float[] fArr2 = new float[6];
        char c3 = 'm';
        int i6 = 0;
        char c4 = 'm';
        int i7 = 0;
        while (i7 < iVarArr2.length) {
            i iVar = iVarArr2[i7];
            char c5 = iVar.f1931a;
            float[] fArr3 = iVar.f1932b;
            float f16 = fArr2[i6];
            float f17 = fArr2[1];
            float f18 = fArr2[2];
            float f19 = fArr2[3];
            float f20 = fArr2[4];
            float f21 = fArr2[5];
            switch (c5) {
                case 'A':
                case 'a':
                    i2 = 7;
                    break;
                case 'C':
                case 'c':
                    i2 = i5;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i2 = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i2 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f20, f21);
                    f16 = f20;
                    f18 = f16;
                    f17 = f21;
                    f19 = f17;
                default:
                    i2 = 2;
                    break;
            }
            float f22 = f20;
            float f23 = f21;
            float f24 = f16;
            float f25 = f17;
            int i8 = i6;
            while (i8 < fArr3.length) {
                if (c5 != 'A') {
                    if (c5 != 'C') {
                        if (c5 == 'H') {
                            i3 = i8;
                            fArr = fArr3;
                            c2 = c5;
                            i4 = i7;
                            path.lineTo(fArr[i3], f25);
                            f24 = fArr[i3];
                        } else if (c5 == 'Q') {
                            i3 = i8;
                            fArr = fArr3;
                            c2 = c5;
                            i4 = i7;
                            int i9 = i3 + 1;
                            int i10 = i3 + 2;
                            int i11 = i3 + 3;
                            path.quadTo(fArr[i3], fArr[i9], fArr[i10], fArr[i11]);
                            f2 = fArr[i3];
                            f3 = fArr[i9];
                            f24 = fArr[i10];
                            f25 = fArr[i11];
                        } else if (c5 == 'V') {
                            i3 = i8;
                            fArr = fArr3;
                            c2 = c5;
                            i4 = i7;
                            path.lineTo(f24, fArr[i3]);
                            f25 = fArr[i3];
                        } else if (c5 != 'a') {
                            if (c5 != 'c') {
                                if (c5 == 'h') {
                                    i3 = i8;
                                    path.rLineTo(fArr3[i3], 0.0f);
                                    f24 += fArr3[i3];
                                } else if (c5 == 'q') {
                                    i3 = i8;
                                    float f26 = f25;
                                    float f27 = f24;
                                    int i12 = i3 + 1;
                                    int i13 = i3 + 2;
                                    int i14 = i3 + 3;
                                    path.rQuadTo(fArr3[i3], fArr3[i12], fArr3[i13], fArr3[i14]);
                                    float f28 = f27 + fArr3[i3];
                                    float f29 = fArr3[i12] + f26;
                                    float f30 = f27 + fArr3[i13];
                                    f25 = f26 + fArr3[i14];
                                    f19 = f29;
                                    f18 = f28;
                                    fArr = fArr3;
                                    c2 = c5;
                                    i4 = i7;
                                    f24 = f30;
                                } else if (c5 == 'v') {
                                    i3 = i8;
                                    path.rLineTo(0.0f, fArr3[i3]);
                                    f25 += fArr3[i3];
                                } else if (c5 == 'L') {
                                    i3 = i8;
                                    int i15 = i3 + 1;
                                    path.lineTo(fArr3[i3], fArr3[i15]);
                                    f24 = fArr3[i3];
                                    f25 = fArr3[i15];
                                } else if (c5 == 'M') {
                                    i3 = i8;
                                    f24 = fArr3[i3];
                                    f25 = fArr3[i3 + 1];
                                    if (i3 > 0) {
                                        path.lineTo(f24, f25);
                                    } else {
                                        path.moveTo(f24, f25);
                                        f23 = f25;
                                        f22 = f24;
                                    }
                                } else if (c5 == 'S') {
                                    i3 = i8;
                                    float f31 = f25;
                                    float f32 = f24;
                                    if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                        f10 = (f31 * 2.0f) - f19;
                                        f11 = (f32 * 2.0f) - f18;
                                    } else {
                                        f11 = f32;
                                        f10 = f31;
                                    }
                                    int i16 = i3 + 1;
                                    int i17 = i3 + 2;
                                    int i18 = i3 + 3;
                                    path.cubicTo(f11, f10, fArr3[i3], fArr3[i16], fArr3[i17], fArr3[i18]);
                                    float f33 = fArr3[i3];
                                    float f34 = fArr3[i16];
                                    f24 = fArr3[i17];
                                    f25 = fArr3[i18];
                                    f19 = f34;
                                    f18 = f33;
                                } else if (c5 == 'T') {
                                    i3 = i8;
                                    float f35 = f25;
                                    float f36 = f24;
                                    if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                        f5 = (f36 * 2.0f) - f18;
                                        f6 = (f35 * 2.0f) - f19;
                                    } else {
                                        f5 = f36;
                                        f6 = f35;
                                    }
                                    int i19 = i3 + 1;
                                    path.quadTo(f5, f6, fArr3[i3], fArr3[i19]);
                                    f7 = fArr3[i3];
                                    f9 = fArr3[i19];
                                    f19 = f6;
                                    f18 = f5;
                                    fArr = fArr3;
                                    c2 = c5;
                                    i4 = i7;
                                    f24 = f7;
                                    f25 = f9;
                                } else if (c5 == 'l') {
                                    i3 = i8;
                                    int i20 = i3 + 1;
                                    path.rLineTo(fArr3[i3], fArr3[i20]);
                                    f24 += fArr3[i3];
                                    f25 += fArr3[i20];
                                } else if (c5 == c3) {
                                    i3 = i8;
                                    float f37 = fArr3[i3];
                                    f24 += f37;
                                    float f38 = fArr3[i3 + 1];
                                    f25 += f38;
                                    if (i3 > 0) {
                                        path.rLineTo(f37, f38);
                                    } else {
                                        path.rMoveTo(f37, f38);
                                        f23 = f25;
                                        f22 = f24;
                                    }
                                } else if (c5 == 's') {
                                    if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                        f12 = f25 - f19;
                                        f13 = f24 - f18;
                                    } else {
                                        f13 = 0.0f;
                                        f12 = 0.0f;
                                    }
                                    int i21 = i8 + 1;
                                    int i22 = i8 + 2;
                                    int i23 = i8 + 3;
                                    i3 = i8;
                                    f4 = f25;
                                    float f39 = f24;
                                    path.rCubicTo(f13, f12, fArr3[i8], fArr3[i21], fArr3[i22], fArr3[i23]);
                                    f5 = f39 + fArr3[i3];
                                    f6 = f4 + fArr3[i21];
                                    f7 = f39 + fArr3[i22];
                                    f8 = fArr3[i23];
                                } else if (c5 != 't') {
                                    i3 = i8;
                                } else {
                                    if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                        f14 = f24 - f18;
                                        f15 = f25 - f19;
                                    } else {
                                        f15 = 0.0f;
                                        f14 = 0.0f;
                                    }
                                    int i24 = i8 + 1;
                                    path.rQuadTo(f14, f15, fArr3[i8], fArr3[i24]);
                                    float f40 = f14 + f24;
                                    float f41 = f15 + f25;
                                    f24 += fArr3[i8];
                                    f25 += fArr3[i24];
                                    f19 = f41;
                                    i3 = i8;
                                    fArr = fArr3;
                                    c2 = c5;
                                    i4 = i7;
                                    f18 = f40;
                                }
                                fArr = fArr3;
                                c2 = c5;
                                i4 = i7;
                            } else {
                                i3 = i8;
                                f4 = f25;
                                float f42 = f24;
                                int i25 = i3 + 2;
                                int i26 = i3 + 3;
                                int i27 = i3 + 4;
                                int i28 = i3 + 5;
                                path.rCubicTo(fArr3[i3], fArr3[i3 + 1], fArr3[i25], fArr3[i26], fArr3[i27], fArr3[i28]);
                                f5 = f42 + fArr3[i25];
                                f6 = f4 + fArr3[i26];
                                f7 = f42 + fArr3[i27];
                                f8 = fArr3[i28];
                            }
                            f9 = f8 + f4;
                            f19 = f6;
                            f18 = f5;
                            fArr = fArr3;
                            c2 = c5;
                            i4 = i7;
                            f24 = f7;
                            f25 = f9;
                        } else {
                            i3 = i8;
                            float f43 = f25;
                            float f44 = f24;
                            int i29 = i3 + 5;
                            int i30 = i3 + 6;
                            fArr = fArr3;
                            c2 = c5;
                            i4 = i7;
                            a(path, f44, f43, fArr3[i29] + f44, fArr3[i30] + f43, fArr3[i3], fArr3[i3 + 1], fArr3[i3 + 2], fArr3[i3 + 3] != 0.0f, fArr3[i3 + 4] != 0.0f);
                            f24 = f44 + fArr[i29];
                            f25 = f43 + fArr[i30];
                        }
                        i8 = i3 + i2;
                        c4 = c2;
                        c5 = c4;
                        fArr3 = fArr;
                        i7 = i4;
                        c3 = 'm';
                        i6 = 0;
                    } else {
                        i3 = i8;
                        fArr = fArr3;
                        c2 = c5;
                        i4 = i7;
                        int i31 = i3 + 2;
                        int i32 = i3 + 3;
                        int i33 = i3 + 4;
                        int i34 = i3 + 5;
                        path.cubicTo(fArr[i3], fArr[i3 + 1], fArr[i31], fArr[i32], fArr[i33], fArr[i34]);
                        f24 = fArr[i33];
                        f25 = fArr[i34];
                        f2 = fArr[i31];
                        f3 = fArr[i32];
                    }
                    f18 = f2;
                    f19 = f3;
                    i8 = i3 + i2;
                    c4 = c2;
                    c5 = c4;
                    fArr3 = fArr;
                    i7 = i4;
                    c3 = 'm';
                    i6 = 0;
                } else {
                    i3 = i8;
                    fArr = fArr3;
                    c2 = c5;
                    i4 = i7;
                    int i35 = i3 + 5;
                    int i36 = i3 + 6;
                    a(path, f24, f25, fArr[i35], fArr[i36], fArr[i3], fArr[i3 + 1], fArr[i3 + 2], fArr[i3 + 3] != 0.0f, fArr[i3 + 4] != 0.0f);
                    f24 = fArr[i35];
                    f25 = fArr[i36];
                }
                f19 = f25;
                f18 = f24;
                i8 = i3 + i2;
                c4 = c2;
                c5 = c4;
                fArr3 = fArr;
                i7 = i4;
                c3 = 'm';
                i6 = 0;
            }
            int i37 = i7;
            int i38 = i6;
            fArr2[i38] = f24;
            fArr2[1] = f25;
            fArr2[2] = f18;
            fArr2[3] = f19;
            fArr2[4] = f22;
            fArr2[5] = f23;
            i7 = i37 + 1;
            i5 = 6;
            c3 = 'm';
            i6 = i38;
            c4 = iVarArr[i37].f1931a;
            iVarArr2 = iVarArr;
        }
    }
}
