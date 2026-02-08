package androidx.emoji2.text;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f388d = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    public final int f389a;

    /* renamed from: b, reason: collision with root package name */
    public final u f390b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f391c = 0;

    public n(u uVar, int i2) {
        this.f390b = uVar;
        this.f389a = i2;
    }

    public final int a(int i2) {
        x.a aVarC = c();
        int iA = aVarC.a(16);
        if (iA == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = aVarC.f2649b;
        int i3 = iA + aVarC.f2648a;
        return byteBuffer.getInt((i2 * 4) + byteBuffer.getInt(i3) + i3 + 4);
    }

    public final int b() {
        x.a aVarC = c();
        int iA = aVarC.a(16);
        if (iA == 0) {
            return 0;
        }
        int i2 = iA + aVarC.f2648a;
        return aVarC.f2649b.getInt(aVarC.f2649b.getInt(i2) + i2);
    }

    public final x.a c() {
        ThreadLocal threadLocal = f388d;
        x.a aVar = (x.a) threadLocal.get();
        if (aVar == null) {
            aVar = new x.a();
            threadLocal.set(aVar);
        }
        x.b bVar = (x.b) this.f390b.f414a;
        int iA = bVar.a(6);
        if (iA != 0) {
            int i2 = iA + bVar.f2648a;
            int i3 = (this.f389a * 4) + bVar.f2649b.getInt(i2) + i2 + 4;
            int i4 = bVar.f2649b.getInt(i3) + i3;
            ByteBuffer byteBuffer = bVar.f2649b;
            aVar.f2649b = byteBuffer;
            if (byteBuffer != null) {
                aVar.f2648a = i4;
                int i5 = i4 - byteBuffer.getInt(i4);
                aVar.f2650c = i5;
                aVar.f2651d = aVar.f2649b.getShort(i5);
            } else {
                aVar.f2648a = 0;
                aVar.f2650c = 0;
                aVar.f2651d = 0;
            }
        }
        return aVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        x.a aVarC = c();
        int iA = aVarC.a(4);
        sb.append(Integer.toHexString(iA != 0 ? aVarC.f2649b.getInt(iA + aVarC.f2648a) : 0));
        sb.append(", codepoints:");
        int iB = b();
        for (int i2 = 0; i2 < iB; i2++) {
            sb.append(Integer.toHexString(a(i2)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
