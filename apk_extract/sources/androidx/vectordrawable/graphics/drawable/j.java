package androidx.vectordrawable.graphics.drawable;

import android.graphics.Paint;

/* loaded from: classes.dex */
public final class j extends m {

    /* renamed from: e, reason: collision with root package name */
    public j.d f1142e;

    /* renamed from: f, reason: collision with root package name */
    public float f1143f;

    /* renamed from: g, reason: collision with root package name */
    public j.d f1144g;

    /* renamed from: h, reason: collision with root package name */
    public float f1145h;

    /* renamed from: i, reason: collision with root package name */
    public float f1146i;

    /* renamed from: j, reason: collision with root package name */
    public float f1147j;

    /* renamed from: k, reason: collision with root package name */
    public float f1148k;

    /* renamed from: l, reason: collision with root package name */
    public float f1149l;

    /* renamed from: m, reason: collision with root package name */
    public Paint.Cap f1150m;

    /* renamed from: n, reason: collision with root package name */
    public Paint.Join f1151n;

    /* renamed from: o, reason: collision with root package name */
    public float f1152o;

    @Override // androidx.vectordrawable.graphics.drawable.l
    public final boolean a() {
        return this.f1144g.b() || this.f1142e.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    @Override // androidx.vectordrawable.graphics.drawable.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(int[] r6) {
        /*
            r5 = this;
            j.d r0 = r5.f1144g
            boolean r1 = r0.b()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L1c
            android.content.res.ColorStateList r1 = r0.f1856b
            int r4 = r1.getDefaultColor()
            int r1 = r1.getColorForState(r6, r4)
            int r4 = r0.f1857c
            if (r1 == r4) goto L1c
            r0.f1857c = r1
            r0 = r3
            goto L1d
        L1c:
            r0 = r2
        L1d:
            j.d r5 = r5.f1142e
            boolean r1 = r5.b()
            if (r1 == 0) goto L36
            android.content.res.ColorStateList r1 = r5.f1856b
            int r4 = r1.getDefaultColor()
            int r6 = r1.getColorForState(r6, r4)
            int r1 = r5.f1857c
            if (r6 == r1) goto L36
            r5.f1857c = r6
            r2 = r3
        L36:
            r5 = r0 | r2
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.j.b(int[]):boolean");
    }

    public float getFillAlpha() {
        return this.f1146i;
    }

    public int getFillColor() {
        return this.f1144g.f1857c;
    }

    public float getStrokeAlpha() {
        return this.f1145h;
    }

    public int getStrokeColor() {
        return this.f1142e.f1857c;
    }

    public float getStrokeWidth() {
        return this.f1143f;
    }

    public float getTrimPathEnd() {
        return this.f1148k;
    }

    public float getTrimPathOffset() {
        return this.f1149l;
    }

    public float getTrimPathStart() {
        return this.f1147j;
    }

    public void setFillAlpha(float f2) {
        this.f1146i = f2;
    }

    public void setFillColor(int i2) {
        this.f1144g.f1857c = i2;
    }

    public void setStrokeAlpha(float f2) {
        this.f1145h = f2;
    }

    public void setStrokeColor(int i2) {
        this.f1142e.f1857c = i2;
    }

    public void setStrokeWidth(float f2) {
        this.f1143f = f2;
    }

    public void setTrimPathEnd(float f2) {
        this.f1148k = f2;
    }

    public void setTrimPathOffset(float f2) {
        this.f1149l = f2;
    }

    public void setTrimPathStart(float f2) {
        this.f1147j = f2;
    }
}
