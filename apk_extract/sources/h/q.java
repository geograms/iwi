package h;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class q implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f1837a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final Context f1838b;

    public q(Context context) {
        this.f1838b = context;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f1837a.iterator();
    }
}
