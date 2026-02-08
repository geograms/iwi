package androidx.vectordrawable.graphics.drawable;

/* loaded from: classes.dex */
public abstract class m extends l {

    /* renamed from: a, reason: collision with root package name */
    public k.i[] f1165a;

    /* renamed from: b, reason: collision with root package name */
    public String f1166b;

    /* renamed from: c, reason: collision with root package name */
    public int f1167c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1168d;

    public m() {
        this.f1165a = null;
        this.f1167c = 0;
    }

    public k.i[] getPathData() {
        return this.f1165a;
    }

    public String getPathName() {
        return this.f1166b;
    }

    public void setPathData(k.i[] iVarArr) {
        if (!x0.g.n(this.f1165a, iVarArr)) {
            this.f1165a = x0.g.H(iVarArr);
            return;
        }
        k.i[] iVarArr2 = this.f1165a;
        for (int i2 = 0; i2 < iVarArr.length; i2++) {
            iVarArr2[i2].f1931a = iVarArr[i2].f1931a;
            int i3 = 0;
            while (true) {
                float[] fArr = iVarArr[i2].f1932b;
                if (i3 < fArr.length) {
                    iVarArr2[i2].f1932b[i3] = fArr[i3];
                    i3++;
                }
            }
        }
    }

    public m(m mVar) {
        this.f1165a = null;
        this.f1167c = 0;
        this.f1166b = mVar.f1166b;
        this.f1168d = mVar.f1168d;
        this.f1165a = x0.g.H(mVar.f1165a);
    }
}
