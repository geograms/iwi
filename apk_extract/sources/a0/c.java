package a0;

import androidx.lifecycle.ViewModel;
import g.m;

/* loaded from: classes.dex */
public final class c extends ViewModel {

    /* renamed from: b, reason: collision with root package name */
    public static final b f4b = new b();

    /* renamed from: a, reason: collision with root package name */
    public final m f5a = new m();

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        super.onCleared();
        m mVar = this.f5a;
        int i2 = mVar.f1816c;
        if (i2 > 0) {
            a.a.j(mVar.f1815b[0]);
            throw null;
        }
        Object[] objArr = mVar.f1815b;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        mVar.f1816c = 0;
    }
}
