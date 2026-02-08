package a0;

import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import g.m;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public final class d extends a {

    /* renamed from: a, reason: collision with root package name */
    public final LifecycleOwner f6a;

    /* renamed from: b, reason: collision with root package name */
    public final c f7b;

    public d(LifecycleOwner lifecycleOwner, ViewModelStore viewModelStore) {
        this.f6a = lifecycleOwner;
        this.f7b = (c) new ViewModelProvider(viewModelStore, c.f4b).get(c.class);
    }

    public final void b(String str, PrintWriter printWriter) {
        m mVar = this.f7b.f5a;
        if (mVar.f1816c > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            if (mVar.f1816c <= 0) {
                return;
            }
            a.a.j(mVar.f1815b[0]);
            printWriter.print(str);
            printWriter.print("  #");
            printWriter.print(mVar.f1814a[0]);
            printWriter.print(": ");
            throw null;
        }
    }

    public final String toString() {
        int iLastIndexOf;
        StringBuilder sb = new StringBuilder(Optimizer.OPTIMIZATION_GRAPH_WRAP);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        LifecycleOwner lifecycleOwner = this.f6a;
        if (lifecycleOwner == null) {
            sb.append("null");
        } else {
            String simpleName = lifecycleOwner.getClass().getSimpleName();
            if (simpleName.length() <= 0 && (iLastIndexOf = (simpleName = lifecycleOwner.getClass().getName()).lastIndexOf(46)) > 0) {
                simpleName = simpleName.substring(iLastIndexOf + 1);
            }
            sb.append(simpleName);
            sb.append('{');
            sb.append(Integer.toHexString(System.identityHashCode(lifecycleOwner)));
        }
        sb.append("}}");
        return sb.toString();
    }
}
