package c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import c0.f;
import c0.g;
import c0.h;
import c0.i;
import k.j;

/* loaded from: classes.dex */
public class c implements androidx.customview.widget.c, androidx.customview.widget.d, g, l1.a {

    /* renamed from: a, reason: collision with root package name */
    public static c f1222a;

    public /* synthetic */ c(int i2) {
    }

    public static void a(i iVar, Object[] objArr) {
        if (objArr == null) {
            return;
        }
        int length = objArr.length;
        int i2 = 0;
        while (i2 < length) {
            Object obj = objArr[i2];
            i2++;
            if (obj == null) {
                iVar.bindNull(i2);
            } else if (obj instanceof byte[]) {
                iVar.bindBlob(i2, (byte[]) obj);
            } else if (obj instanceof Float) {
                iVar.bindDouble(i2, ((Number) obj).floatValue());
            } else if (obj instanceof Double) {
                iVar.bindDouble(i2, ((Number) obj).doubleValue());
            } else if (obj instanceof Long) {
                iVar.bindLong(i2, ((Number) obj).longValue());
            } else if (obj instanceof Integer) {
                iVar.bindLong(i2, ((Number) obj).intValue());
            } else if (obj instanceof Short) {
                iVar.bindLong(i2, ((Number) obj).shortValue());
            } else if (obj instanceof Byte) {
                iVar.bindLong(i2, ((Number) obj).byteValue());
            } else if (obj instanceof String) {
                iVar.bindString(i2, (String) obj);
            } else {
                if (!(obj instanceof Boolean)) {
                    throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i2 + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
                }
                iVar.bindLong(i2, ((Boolean) obj).booleanValue() ? 1L : 0L);
            }
        }
    }

    public static c0.e b(Context context) {
        x0.g.u(context, "context");
        return new c0.e(context);
    }

    public static void c(int i2, int i3) {
        if (i2 < 0 || i2 >= i3) {
            throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
        }
    }

    public static void d(int i2, int i3) {
        if (i2 < 0 || i2 > i3) {
            throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
        }
    }

    public static d0.d f(j jVar, SQLiteDatabase sQLiteDatabase) {
        x0.g.u(jVar, "refHolder");
        x0.g.u(sQLiteDatabase, "sqLiteDatabase");
        d0.d dVar = (d0.d) jVar.f1934b;
        if (dVar != null && x0.g.g(dVar.f1712a, sQLiteDatabase)) {
            return dVar;
        }
        d0.d dVar2 = new d0.d(sQLiteDatabase);
        jVar.f1934b = dVar2;
        return dVar2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004b, code lost:
    
        if (java.lang.Character.isHighSurrogate(r5) != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0088, code lost:
    
        if (java.lang.Character.isLowSurrogate(r5) != false) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0072 A[EDGE_INSN: B:91:0x0072->B:48:0x0072 BREAK  A[LOOP:2: B:49:0x0074->B:60:0x008b, LOOP_LABEL: LOOP:2: B:49:0x0074->B:60:0x008b], EDGE_INSN: B:94:0x0072->B:48:0x0072 BREAK  A[LOOP:2: B:49:0x0074->B:60:0x008b]] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00a8 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean g(android.view.inputmethod.InputConnection r7, android.text.Editable r8, int r9, int r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.g(android.view.inputmethod.InputConnection, android.text.Editable, int, int, boolean):boolean");
    }

    @Override // c0.g
    public h create(f fVar) {
        x0.g.u(fVar, "configuration");
        return new d0.i(fVar.f1228a, fVar.f1229b, fVar.f1230c, fVar.f1231d, fVar.f1232e);
    }

    public InputFilter[] e(InputFilter[] inputFilterArr) {
        return inputFilterArr;
    }

    public void h() {
    }

    public boolean i() {
        return false;
    }

    public boolean j() {
        return false;
    }

    public void k(boolean z2) {
    }

    public void l(boolean z2) {
    }

    public void m(boolean z2) {
    }

    public void n(boolean z2) {
    }

    public void o() {
    }

    public TransformationMethod p(TransformationMethod transformationMethod) {
        return transformationMethod;
    }

    public /* synthetic */ c(int i2, int i3) {
        if (i2 != 1) {
            switch (i2) {
            }
        }
    }
}
