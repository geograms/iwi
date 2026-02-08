package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class x implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public v f1118a;

    /* renamed from: b, reason: collision with root package name */
    public ViewGroup f1119b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ViewGroup viewGroup = this.f1119b;
        viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
        viewGroup.removeOnAttachStateChangeListener(this);
        ArrayList arrayList = y.f1122c;
        ViewGroup viewGroup2 = this.f1119b;
        if (!arrayList.remove(viewGroup2)) {
            return true;
        }
        g.b bVarB = y.b();
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = (ArrayList) bVarB.getOrDefault(viewGroup2, null);
        if (arrayList3 == null) {
            arrayList3 = new ArrayList();
            bVarB.put(viewGroup2, arrayList3);
        } else if (arrayList3.size() > 0) {
            arrayList2 = new ArrayList(arrayList3);
        }
        v vVar = this.f1118a;
        arrayList3.add(vVar);
        vVar.addListener(new h(1, this, bVarB));
        vVar.captureValues(viewGroup2, false);
        if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                ((v) it.next()).resume(viewGroup2);
            }
        }
        vVar.playTransition(viewGroup2);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        ViewGroup viewGroup = this.f1119b;
        viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
        viewGroup.removeOnAttachStateChangeListener(this);
        ArrayList arrayList = y.f1122c;
        ViewGroup viewGroup2 = this.f1119b;
        arrayList.remove(viewGroup2);
        ArrayList arrayList2 = (ArrayList) y.b().getOrDefault(viewGroup2, null);
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                ((v) it.next()).resume(viewGroup2);
            }
        }
        this.f1118a.clearValues(true);
    }
}
