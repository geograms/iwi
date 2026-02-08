package androidx.recyclerview.widget;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: h, reason: collision with root package name */
    public static final e f780h = new e();

    /* renamed from: a, reason: collision with root package name */
    public final n0 f781a;

    /* renamed from: b, reason: collision with root package name */
    public final t.c f782b;

    /* renamed from: e, reason: collision with root package name */
    public List f785e;

    /* renamed from: g, reason: collision with root package name */
    public int f787g;

    /* renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArrayList f784d = new CopyOnWriteArrayList();

    /* renamed from: f, reason: collision with root package name */
    public List f786f = Collections.emptyList();

    /* renamed from: c, reason: collision with root package name */
    public final e f783c = f780h;

    public f(o0 o0Var, t.c cVar) {
        this.f781a = o0Var;
        this.f782b = cVar;
    }

    public final void a(Runnable runnable) {
        Iterator it = this.f784d.iterator();
        while (it.hasNext()) {
            ((l0) it.next()).f880a.getClass();
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void b(List list, androidx.activity.b bVar) {
        int i2 = this.f787g + 1;
        this.f787g = i2;
        List list2 = this.f785e;
        if (list == list2) {
            if (bVar != null) {
                bVar.run();
                return;
            }
            return;
        }
        n0 n0Var = this.f781a;
        if (list == null) {
            int size = list2.size();
            this.f785e = null;
            this.f786f = Collections.emptyList();
            n0Var.a(0, size);
            a(bVar);
            return;
        }
        if (list2 != null) {
            ((Executor) this.f782b.f2549a).execute(new d(this, list2, list, i2, bVar));
            return;
        }
        this.f785e = list;
        this.f786f = Collections.unmodifiableList(list);
        n0Var.b(0, list.size());
        a(bVar);
    }
}
