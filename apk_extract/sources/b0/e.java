package b0;

import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public boolean f1213b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f1214c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1215d;

    /* renamed from: e, reason: collision with root package name */
    public a f1216e;

    /* renamed from: a, reason: collision with root package name */
    public final e.g f1212a = new e.g();

    /* renamed from: f, reason: collision with root package name */
    public boolean f1217f = true;

    public final Bundle a(String str) {
        x0.g.u(str, "key");
        if (!this.f1215d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
        }
        Bundle bundle = this.f1214c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
        Bundle bundle3 = this.f1214c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.f1214c;
        if (bundle4 == null || bundle4.isEmpty()) {
            this.f1214c = null;
        }
        return bundle2;
    }

    public final d b() {
        String str;
        d dVar;
        Iterator it = this.f1212a.iterator();
        do {
            e.e eVar = (e.e) it;
            if (!eVar.hasNext()) {
                return null;
            }
            Map.Entry entry = (Map.Entry) eVar.next();
            x0.g.t(entry, "components");
            str = (String) entry.getKey();
            dVar = (d) entry.getValue();
        } while (!x0.g.g(str, "androidx.lifecycle.internal.SavedStateHandlesProvider"));
        return dVar;
    }

    public final void c(String str, d dVar) {
        x0.g.u(str, "key");
        x0.g.u(dVar, "provider");
        if (((d) this.f1212a.b(str, dVar)) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    public final void d(Class cls) throws NoSuchMethodException, SecurityException {
        if (!this.f1217f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
        }
        a aVar = this.f1216e;
        if (aVar == null) {
            aVar = new a(this);
        }
        this.f1216e = aVar;
        try {
            cls.getDeclaredConstructor(new Class[0]);
            a aVar2 = this.f1216e;
            if (aVar2 != null) {
                aVar2.f1210a.add(cls.getName());
            }
        } catch (NoSuchMethodException e2) {
            throw new IllegalArgumentException("Class " + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
        }
    }
}
