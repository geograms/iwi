package k;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f1922a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ b[] f1923b;

    static {
        b bVar = new b("CLEAR", 0);
        f1922a = bVar;
        f1923b = new b[]{bVar, new b("SRC", 1), new b("DST", 2), new b("SRC_OVER", 3), new b("DST_OVER", 4), new b("SRC_IN", 5), new b("DST_IN", 6), new b("SRC_OUT", 7), new b("DST_OUT", 8), new b("SRC_ATOP", 9), new b("DST_ATOP", 10), new b("XOR", 11), new b("PLUS", 12), new b("MODULATE", 13), new b("SCREEN", 14), new b("OVERLAY", 15), new b("DARKEN", 16), new b("LIGHTEN", 17), new b("COLOR_DODGE", 18), new b("COLOR_BURN", 19), new b("HARD_LIGHT", 20), new b("SOFT_LIGHT", 21), new b("DIFFERENCE", 22), new b("EXCLUSION", 23), new b("MULTIPLY", 24), new b("HUE", 25), new b("SATURATION", 26), new b("COLOR", 27), new b("LUMINOSITY", 28)};
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f1923b.clone();
    }
}
