package b0;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f1210a;

    public a(e eVar) {
        x0.g.u(eVar, "registry");
        this.f1210a = new LinkedHashSet();
        eVar.c("androidx.savedstate.Restarter", this);
    }

    @Override // b0.d
    public final Bundle saveState() {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.f1210a));
        return bundle;
    }
}
