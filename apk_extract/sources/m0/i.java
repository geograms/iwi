package m0;

import android.view.View;
import p0.q;

/* loaded from: classes.dex */
public final class i implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f2112a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f2113b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f2114c;

    public i(k kVar, a aVar, j jVar) {
        this.f2114c = kVar;
        this.f2112a = aVar;
        this.f2113b = jVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        q qVar = this.f2114c.f2127f;
        if (qVar != null) {
            this.f2113b.getAdapterPosition();
            qVar.a(this.f2112a);
        }
    }
}
