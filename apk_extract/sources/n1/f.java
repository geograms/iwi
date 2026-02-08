package n1;

import j1.p;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final p f2208a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [h1.a] */
    static {
        String property;
        Object next;
        int i2 = h.f2209a;
        p pVarCreateDispatcher = null;
        try {
            property = System.getProperty("kotlinx.coroutines.fast.service.loader");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null) {
            Boolean.parseBoolean(property);
        }
        Iterator itL = a.a.l();
        x0.g.u(itL, "<this>");
        h1.d dVar = new h1.d(itL);
        if (!(dVar instanceof h1.a)) {
            dVar = new h1.a(dVar);
        }
        List listE0 = h1.c.E0(dVar);
        Iterator it = listE0.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                int loadPriority = ((e) next).getLoadPriority();
                do {
                    Object next2 = it.next();
                    int loadPriority2 = ((e) next2).getLoadPriority();
                    if (loadPriority < loadPriority2) {
                        next = next2;
                        loadPriority = loadPriority2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        e eVar = (e) next;
        if (eVar != null) {
            try {
                pVarCreateDispatcher = eVar.createDispatcher(listE0);
            } catch (Throwable unused2) {
                eVar.hintOnError();
            }
        }
        if (pVarCreateDispatcher == null) {
            throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
        }
        f2208a = pVarCreateDispatcher;
    }
}
