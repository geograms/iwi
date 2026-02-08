package m0;

import android.view.View;
import p0.q;

/* loaded from: classes.dex */
public final class h implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2109a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f2110b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f2111c;

    public h(k kVar, int i2, j jVar) {
        this.f2111c = kVar;
        this.f2109a = i2;
        this.f2110b = jVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        k kVar = this.f2111c;
        q qVar = kVar.f2126e;
        if (qVar != null) {
            a aVar = (a) kVar.f2123b.get(this.f2109a);
            this.f2110b.getAdapterPosition();
            qVar.a(aVar);
        }
    }
}
