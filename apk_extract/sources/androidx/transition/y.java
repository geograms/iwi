package androidx.transition;

import android.view.ViewGroup;
import androidx.core.view.d1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1120a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f1121b = new ThreadLocal();

    /* renamed from: c, reason: collision with root package name */
    public static final ArrayList f1122c = new ArrayList();

    public static void a(ViewGroup viewGroup, v vVar) {
        ArrayList arrayList = f1122c;
        if (arrayList.contains(viewGroup)) {
            return;
        }
        WeakHashMap weakHashMap = d1.f138a;
        if (androidx.core.view.p0.c(viewGroup)) {
            arrayList.add(viewGroup);
            if (vVar == null) {
                vVar = f1120a;
            }
            v vVarMo2clone = vVar.mo2clone();
            ArrayList arrayList2 = (ArrayList) b().getOrDefault(viewGroup, null);
            if (arrayList2 != null && arrayList2.size() > 0) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((v) it.next()).pause(viewGroup);
                }
            }
            if (vVarMo2clone != null) {
                vVarMo2clone.captureValues(viewGroup, true);
            }
            a.a.j(viewGroup.getTag(R$id.transition_current_scene));
            viewGroup.setTag(R$id.transition_current_scene, null);
            if (vVarMo2clone != null) {
                x xVar = new x();
                xVar.f1118a = vVarMo2clone;
                xVar.f1119b = viewGroup;
                viewGroup.addOnAttachStateChangeListener(xVar);
                viewGroup.getViewTreeObserver().addOnPreDrawListener(xVar);
            }
        }
    }

    public static g.b b() {
        g.b bVar;
        ThreadLocal threadLocal = f1121b;
        WeakReference weakReference = (WeakReference) threadLocal.get();
        if (weakReference != null && (bVar = (g.b) weakReference.get()) != null) {
            return bVar;
        }
        g.b bVar2 = new g.b();
        threadLocal.set(new WeakReference(bVar2));
        return bVar2;
    }
}
