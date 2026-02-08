package androidx.activity.result;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class e extends d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f40a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Serializable f41b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c.b f42c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f43d;

    public e(Object obj, Serializable serializable, c.b bVar, int i2) {
        this.f40a = i2;
        this.f43d = obj;
        this.f41b = serializable;
        this.f42c = bVar;
    }

    @Override // androidx.activity.result.d
    public final void a(Object obj) {
        int i2 = this.f40a;
        c.b bVar = this.f42c;
        Object obj2 = this.f43d;
        Serializable serializable = this.f41b;
        switch (i2) {
            case 0:
                h hVar = (h) obj2;
                String str = (String) serializable;
                Integer num = (Integer) hVar.f50c.get(str);
                if (num != null) {
                    hVar.f52e.add(str);
                    try {
                        ((h) obj2).b(num.intValue(), bVar, obj);
                        return;
                    } catch (Exception e2) {
                        hVar.f52e.remove(str);
                        throw e2;
                    }
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + bVar + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
            case 1:
                h hVar2 = (h) obj2;
                String str2 = (String) serializable;
                Integer num2 = (Integer) hVar2.f50c.get(str2);
                if (num2 != null) {
                    hVar2.f52e.add(str2);
                    hVar2.b(num2.intValue(), bVar, obj);
                    return;
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + bVar + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
            default:
                d dVar = (d) ((AtomicReference) serializable).get();
                if (dVar == null) {
                    throw new IllegalStateException("Operation cannot be started before fragment is in created state");
                }
                dVar.a(obj);
                return;
        }
    }

    @Override // androidx.activity.result.d
    public final void b() {
        int i2 = this.f40a;
        Object obj = this.f43d;
        Serializable serializable = this.f41b;
        switch (i2) {
            case 0:
                ((h) obj).f((String) serializable);
                break;
            case 1:
                ((h) obj).f((String) serializable);
                break;
            default:
                d dVar = (d) ((AtomicReference) serializable).getAndSet(null);
                if (dVar != null) {
                    dVar.b();
                    break;
                }
                break;
        }
    }
}
