package c;

import android.content.Intent;
import androidx.activity.h;
import x0.g;

/* loaded from: classes.dex */
public final class e extends b {
    @Override // c.b
    public final Intent a(h hVar, Object obj) {
        Intent intent = (Intent) obj;
        g.u(hVar, "context");
        g.u(intent, "input");
        return intent;
    }

    @Override // c.b
    public final Object c(Intent intent, int i2) {
        return new androidx.activity.result.b(intent, i2);
    }
}
