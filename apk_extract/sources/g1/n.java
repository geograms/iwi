package g1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ n[] f1828a = {new n("PUBLIC", 0), new n("PROTECTED", 1), new n("INTERNAL", 2), new n("PRIVATE", 3)};

    /* JADX INFO: Fake field, exist only in values array */
    n EF5;

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) f1828a.clone();
    }
}
