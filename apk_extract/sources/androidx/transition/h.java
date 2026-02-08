package androidx.transition;

import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class h extends w {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1076a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1077b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1078c;

    public /* synthetic */ h(int i2, Object obj, Object obj2) {
        this.f1076a = i2;
        this.f1078c = obj;
        this.f1077b = obj2;
    }

    @Override // androidx.transition.u
    public final void onTransitionEnd(v vVar) {
        int i2 = this.f1076a;
        Object obj = this.f1077b;
        switch (i2) {
            case 0:
                c cVar = e0.f1062a;
                ((View) obj).setTransitionAlpha(1.0f);
                vVar.removeListener(this);
                break;
            case 1:
                ((ArrayList) ((g.b) obj).getOrDefault(((x) this.f1078c).f1119b, null)).remove(vVar);
                vVar.removeListener(this);
                break;
            default:
                ((v) obj).runAnimators();
                vVar.removeListener(this);
                break;
        }
    }
}
