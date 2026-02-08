package androidx.appcompat.widget;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f64a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f65b;

    public /* synthetic */ a(int i2, Object obj) {
        this.f64a = i2;
        this.f65b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f64a;
        Object obj = this.f65b;
        switch (i2) {
            case 0:
                ((TooltipCompatHandler) obj).lambda$new$0();
                break;
            case 1:
                ((TooltipCompatHandler) obj).hide();
                break;
            default:
                ((Toolbar) obj).invalidateMenu();
                break;
        }
    }
}
