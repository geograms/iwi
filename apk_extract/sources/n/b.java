package n;

import android.os.Bundle;
import android.util.Size;
import android.util.SizeF;
import x0.g;

/* loaded from: classes.dex */
public abstract class b {
    public static final void a(Bundle bundle, String str, Size size) {
        g.u(bundle, "bundle");
        g.u(str, "key");
        bundle.putSize(str, size);
    }

    public static final void b(Bundle bundle, String str, SizeF sizeF) {
        g.u(bundle, "bundle");
        g.u(str, "key");
        bundle.putSizeF(str, sizeF);
    }
}
