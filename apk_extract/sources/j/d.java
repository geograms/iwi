package j;

import android.content.res.ColorStateList;
import android.graphics.Shader;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Shader f1855a;

    /* renamed from: b, reason: collision with root package name */
    public final ColorStateList f1856b;

    /* renamed from: c, reason: collision with root package name */
    public int f1857c;

    public d(Shader shader, ColorStateList colorStateList, int i2) {
        this.f1855a = shader;
        this.f1856b = colorStateList;
        this.f1857c = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0246, code lost:
    
        if (r9 == 1) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0248, code lost:
    
        if (r9 == r1) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x024a, code lost:
    
        r16 = (int[]) r0.f476a;
        r17 = (float[]) r0.f477b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0258, code lost:
    
        if (r5 == 1) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x025a, code lost:
    
        if (r5 == r1) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x025c, code lost:
    
        r0 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0261, code lost:
    
        r0 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0264, code lost:
    
        r0 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0267, code lost:
    
        r3 = new android.graphics.LinearGradient(r12, r26, r25, r24, r16, r17, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0272, code lost:
    
        r3 = new android.graphics.SweepGradient(r20, r21, (int[]) r0.f476a, (float[]) r0.f477b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x028b, code lost:
    
        if (r22 <= 0.0f) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x028d, code lost:
    
        r20 = (int[]) r0.f476a;
        r21 = (float[]) r0.f477b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x029c, code lost:
    
        if (r5 == 1) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x029f, code lost:
    
        if (r5 == 2) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x02a1, code lost:
    
        r0 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x02a4, code lost:
    
        r0 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x02a7, code lost:
    
        r0 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x02a9, code lost:
    
        r3 = new android.graphics.RadialGradient(r20, r21, r22, r20, r21, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02bd, code lost:
    
        return new j.d(r3, null, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x02c5, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01dd, code lost:
    
        if (r15.size() <= 0) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01df, code lost:
    
        r0 = new androidx.fragment.app.d();
        r1 = r15.size();
        r0.f476a = new int[r1];
        r0.f477b = new float[r1];
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01f1, code lost:
    
        if (r2 >= r1) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01f3, code lost:
    
        ((int[]) r0.f476a)[r2] = ((java.lang.Integer) r15.get(r2)).intValue();
        ((float[]) r0.f477b)[r2] = ((java.lang.Float) r8.get(r2)).floatValue();
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0216, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0217, code lost:
    
        if (r0 == null) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0219, code lost:
    
        r1 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x021c, code lost:
    
        if (r18 == false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x021e, code lost:
    
        r0 = new androidx.fragment.app.d();
        r0.f476a = new int[]{r6, r10, r11};
        r0.f477b = new float[]{0.0f, 0.5f, 1.0f};
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0232, code lost:
    
        r0 = new androidx.fragment.app.d();
        r0.f476a = new int[]{r6, r11};
        r1 = 2;
        r0.f477b = new float[]{0.0f, 1.0f};
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static j.d a(android.content.res.Resources r27, int r28, android.content.res.Resources.Theme r29) {
        /*
            Method dump skipped, instructions count: 766
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j.d.a(android.content.res.Resources, int, android.content.res.Resources$Theme):j.d");
    }

    public final boolean b() {
        ColorStateList colorStateList;
        return this.f1855a == null && (colorStateList = this.f1856b) != null && colorStateList.isStateful();
    }
}
