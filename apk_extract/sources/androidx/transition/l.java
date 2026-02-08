package androidx.transition;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class l extends w {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f1087a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1088b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1089c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1090d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f1091e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1092f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ m f1093g;

    public l(m mVar, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
        this.f1093g = mVar;
        this.f1087a = obj;
        this.f1088b = arrayList;
        this.f1089c = obj2;
        this.f1090d = arrayList2;
        this.f1091e = obj3;
        this.f1092f = arrayList3;
    }

    @Override // androidx.transition.u
    public final void onTransitionEnd(v vVar) {
        vVar.removeListener(this);
    }

    @Override // androidx.transition.w, androidx.transition.u
    public final void onTransitionStart(v vVar) {
        m mVar = this.f1093g;
        Object obj = this.f1087a;
        if (obj != null) {
            mVar.v(obj, this.f1088b, null);
        }
        Object obj2 = this.f1089c;
        if (obj2 != null) {
            mVar.v(obj2, this.f1090d, null);
        }
        Object obj3 = this.f1091e;
        if (obj3 != null) {
            mVar.v(obj3, this.f1092f, null);
        }
    }
}
