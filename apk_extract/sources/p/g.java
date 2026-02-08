package p;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2273a;

    public abstract boolean a();

    public final boolean b(CharSequence charSequence, int i2) {
        if (charSequence == null || i2 < 0 || charSequence.length() - i2 < 0) {
            throw new IllegalArgumentException();
        }
        f fVar = (f) this.f2273a;
        if (fVar == null) {
            return a();
        }
        int iA = fVar.a(charSequence, i2);
        if (iA == 0) {
            return true;
        }
        if (iA != 1) {
            return a();
        }
        return false;
    }
}
