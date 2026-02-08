package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;

/* loaded from: classes.dex */
public final class k1 extends Transition.EpicenterCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f557a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Rect f558b;

    public /* synthetic */ k1(Rect rect, int i2) {
        this.f557a = i2;
        this.f558b = rect;
    }

    @Override // android.transition.Transition.EpicenterCallback
    public final Rect onGetEpicenter(Transition transition) {
        int i2 = this.f557a;
        Rect rect = this.f558b;
        switch (i2) {
            case 0:
                break;
            default:
                if (rect == null || rect.isEmpty()) {
                }
                break;
        }
        return rect;
    }
}
