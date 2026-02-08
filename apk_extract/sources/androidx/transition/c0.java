package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: b, reason: collision with root package name */
    public View f1054b;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f1053a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f1055c = new ArrayList();

    public c0(View view) {
        this.f1054b = view;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return this.f1054b == c0Var.f1054b && this.f1053a.equals(c0Var.f1053a);
    }

    public final int hashCode() {
        return this.f1053a.hashCode() + (this.f1054b.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sbG = a.a.g("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n", "    view = ");
        sbG.append(this.f1054b);
        sbG.append("\n");
        String strD = a.a.d(sbG.toString(), "    values:");
        HashMap map = this.f1053a;
        for (String str : map.keySet()) {
            strD = strD + "    " + str + ": " + map.get(str) + "\n";
        }
        return strD;
    }
}
