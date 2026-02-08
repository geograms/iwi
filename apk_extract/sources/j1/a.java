package j1;

/* loaded from: classes.dex */
public final class a extends kotlin.jvm.internal.j implements c1.l {

    /* renamed from: b, reason: collision with root package name */
    public static final a f1905b = new a(0);

    /* renamed from: c, reason: collision with root package name */
    public static final a f1906c = new a(1);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1907a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(int i2) {
        super(1);
        this.f1907a = i2;
    }

    @Override // c1.l
    public final Object invoke(Object obj) {
        switch (this.f1907a) {
            case 0:
                x0.h hVar = (x0.h) obj;
                if (hVar instanceof c) {
                    return (c) hVar;
                }
                return null;
            default:
                x0.h hVar2 = (x0.h) obj;
                if (hVar2 instanceof o) {
                    return (o) hVar2;
                }
                return null;
        }
    }
}
