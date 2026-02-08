package androidx.cursoradapter.widget;

import android.database.DataSetObserver;

/* loaded from: classes.dex */
public final class b extends DataSetObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f258a;

    public b(c cVar) {
        this.f258a = cVar;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        c cVar = this.f258a;
        cVar.mDataValid = true;
        cVar.notifyDataSetChanged();
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        c cVar = this.f258a;
        cVar.mDataValid = false;
        cVar.notifyDataSetInvalidated();
    }
}
