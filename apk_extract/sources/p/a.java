package p;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f2256e = new byte[1792];

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f2257a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2258b;

    /* renamed from: c, reason: collision with root package name */
    public int f2259c;

    /* renamed from: d, reason: collision with root package name */
    public char f2260d;

    static {
        for (int i2 = 0; i2 < 1792; i2++) {
            f2256e[i2] = Character.getDirectionality(i2);
        }
    }

    public a(CharSequence charSequence) {
        this.f2257a = charSequence;
        this.f2258b = charSequence.length();
    }

    public final byte a() {
        int i2 = this.f2259c - 1;
        CharSequence charSequence = this.f2257a;
        char cCharAt = charSequence.charAt(i2);
        this.f2260d = cCharAt;
        if (Character.isLowSurrogate(cCharAt)) {
            int iCodePointBefore = Character.codePointBefore(charSequence, this.f2259c);
            this.f2259c -= Character.charCount(iCodePointBefore);
            return Character.getDirectionality(iCodePointBefore);
        }
        this.f2259c--;
        char c2 = this.f2260d;
        return c2 < 1792 ? f2256e[c2] : Character.getDirectionality(c2);
    }
}
