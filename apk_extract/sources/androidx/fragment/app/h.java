package androidx.fragment.app;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f520a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f521b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f522c;

    public /* synthetic */ h(int i2, Object obj, Object obj2) {
        this.f520a = i2;
        this.f521b = obj;
        this.f522c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f520a;
        Object obj = this.f522c;
        switch (i2) {
            case 0:
                j1.b((ArrayList) obj, 4);
                break;
            case 1:
                ((k) obj).a();
                break;
            default:
                ((w1) obj).c();
                break;
        }
    }
}
