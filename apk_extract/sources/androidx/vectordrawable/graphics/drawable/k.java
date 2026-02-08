package androidx.vectordrawable.graphics.drawable;

import android.graphics.Matrix;
import android.graphics.Paint;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class k extends l {

    /* renamed from: a, reason: collision with root package name */
    public final Matrix f1153a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f1154b;

    /* renamed from: c, reason: collision with root package name */
    public float f1155c;

    /* renamed from: d, reason: collision with root package name */
    public float f1156d;

    /* renamed from: e, reason: collision with root package name */
    public float f1157e;

    /* renamed from: f, reason: collision with root package name */
    public float f1158f;

    /* renamed from: g, reason: collision with root package name */
    public float f1159g;

    /* renamed from: h, reason: collision with root package name */
    public float f1160h;

    /* renamed from: i, reason: collision with root package name */
    public float f1161i;

    /* renamed from: j, reason: collision with root package name */
    public final Matrix f1162j;

    /* renamed from: k, reason: collision with root package name */
    public final int f1163k;

    /* renamed from: l, reason: collision with root package name */
    public String f1164l;

    public k() {
        this.f1153a = new Matrix();
        this.f1154b = new ArrayList();
        this.f1155c = 0.0f;
        this.f1156d = 0.0f;
        this.f1157e = 0.0f;
        this.f1158f = 1.0f;
        this.f1159g = 1.0f;
        this.f1160h = 0.0f;
        this.f1161i = 0.0f;
        this.f1162j = new Matrix();
        this.f1164l = null;
    }

    @Override // androidx.vectordrawable.graphics.drawable.l
    public final boolean a() {
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f1154b;
            if (i2 >= arrayList.size()) {
                return false;
            }
            if (((l) arrayList.get(i2)).a()) {
                return true;
            }
            i2++;
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.l
    public final boolean b(int[] iArr) {
        int i2 = 0;
        boolean zB = false;
        while (true) {
            ArrayList arrayList = this.f1154b;
            if (i2 >= arrayList.size()) {
                return zB;
            }
            zB |= ((l) arrayList.get(i2)).b(iArr);
            i2++;
        }
    }

    public final void c() {
        Matrix matrix = this.f1162j;
        matrix.reset();
        matrix.postTranslate(-this.f1156d, -this.f1157e);
        matrix.postScale(this.f1158f, this.f1159g);
        matrix.postRotate(this.f1155c, 0.0f, 0.0f);
        matrix.postTranslate(this.f1160h + this.f1156d, this.f1161i + this.f1157e);
    }

    public String getGroupName() {
        return this.f1164l;
    }

    public Matrix getLocalMatrix() {
        return this.f1162j;
    }

    public float getPivotX() {
        return this.f1156d;
    }

    public float getPivotY() {
        return this.f1157e;
    }

    public float getRotation() {
        return this.f1155c;
    }

    public float getScaleX() {
        return this.f1158f;
    }

    public float getScaleY() {
        return this.f1159g;
    }

    public float getTranslateX() {
        return this.f1160h;
    }

    public float getTranslateY() {
        return this.f1161i;
    }

    public void setPivotX(float f2) {
        if (f2 != this.f1156d) {
            this.f1156d = f2;
            c();
        }
    }

    public void setPivotY(float f2) {
        if (f2 != this.f1157e) {
            this.f1157e = f2;
            c();
        }
    }

    public void setRotation(float f2) {
        if (f2 != this.f1155c) {
            this.f1155c = f2;
            c();
        }
    }

    public void setScaleX(float f2) {
        if (f2 != this.f1158f) {
            this.f1158f = f2;
            c();
        }
    }

    public void setScaleY(float f2) {
        if (f2 != this.f1159g) {
            this.f1159g = f2;
            c();
        }
    }

    public void setTranslateX(float f2) {
        if (f2 != this.f1160h) {
            this.f1160h = f2;
            c();
        }
    }

    public void setTranslateY(float f2) {
        if (f2 != this.f1161i) {
            this.f1161i = f2;
            c();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(k kVar, g.b bVar) {
        i iVar;
        this.f1153a = new Matrix();
        this.f1154b = new ArrayList();
        this.f1155c = 0.0f;
        this.f1156d = 0.0f;
        this.f1157e = 0.0f;
        this.f1158f = 1.0f;
        this.f1159g = 1.0f;
        this.f1160h = 0.0f;
        this.f1161i = 0.0f;
        Matrix matrix = new Matrix();
        this.f1162j = matrix;
        this.f1164l = null;
        this.f1155c = kVar.f1155c;
        this.f1156d = kVar.f1156d;
        this.f1157e = kVar.f1157e;
        this.f1158f = kVar.f1158f;
        this.f1159g = kVar.f1159g;
        this.f1160h = kVar.f1160h;
        this.f1161i = kVar.f1161i;
        String str = kVar.f1164l;
        this.f1164l = str;
        this.f1163k = kVar.f1163k;
        if (str != null) {
            bVar.put(str, this);
        }
        matrix.set(kVar.f1162j);
        ArrayList arrayList = kVar.f1154b;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Object obj = arrayList.get(i2);
            if (obj instanceof k) {
                this.f1154b.add(new k((k) obj, bVar));
            } else {
                if (obj instanceof j) {
                    j jVar = (j) obj;
                    j jVar2 = new j(jVar);
                    jVar2.f1143f = 0.0f;
                    jVar2.f1145h = 1.0f;
                    jVar2.f1146i = 1.0f;
                    jVar2.f1147j = 0.0f;
                    jVar2.f1148k = 1.0f;
                    jVar2.f1149l = 0.0f;
                    jVar2.f1150m = Paint.Cap.BUTT;
                    jVar2.f1151n = Paint.Join.MITER;
                    jVar2.f1152o = 4.0f;
                    jVar2.f1142e = jVar.f1142e;
                    jVar2.f1143f = jVar.f1143f;
                    jVar2.f1145h = jVar.f1145h;
                    jVar2.f1144g = jVar.f1144g;
                    jVar2.f1167c = jVar.f1167c;
                    jVar2.f1146i = jVar.f1146i;
                    jVar2.f1147j = jVar.f1147j;
                    jVar2.f1148k = jVar.f1148k;
                    jVar2.f1149l = jVar.f1149l;
                    jVar2.f1150m = jVar.f1150m;
                    jVar2.f1151n = jVar.f1151n;
                    jVar2.f1152o = jVar.f1152o;
                    iVar = jVar2;
                } else if (obj instanceof i) {
                    iVar = new i((i) obj);
                } else {
                    throw new IllegalStateException("Unknown object in the tree!");
                }
                this.f1154b.add(iVar);
                Object obj2 = iVar.f1166b;
                if (obj2 != null) {
                    bVar.put(obj2, iVar);
                }
            }
        }
    }
}
