package androidx.transition;

import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class k implements u {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f1081a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1082b;

    public k(View view, ArrayList arrayList) {
        this.f1081a = view;
        this.f1082b = arrayList;
    }

    @Override // androidx.transition.u
    public final void onTransitionCancel(v vVar) {
    }

    @Override // androidx.transition.u
    public final void onTransitionEnd(v vVar) {
        vVar.removeListener(this);
        this.f1081a.setVisibility(8);
        ArrayList arrayList = this.f1082b;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((View) arrayList.get(i2)).setVisibility(0);
        }
    }

    @Override // androidx.transition.u
    public final void onTransitionPause(v vVar) {
    }

    @Override // androidx.transition.u
    public final void onTransitionResume(v vVar) {
    }

    @Override // androidx.transition.u
    public final void onTransitionStart(v vVar) {
    }
}
