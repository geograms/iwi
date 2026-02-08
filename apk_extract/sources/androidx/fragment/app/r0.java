package androidx.fragment.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/* loaded from: classes.dex */
public final class r0 extends c.b {
    @Override // c.b
    public final Intent a(androidx.activity.h hVar, Object obj) {
        Bundle bundleExtra;
        androidx.activity.result.j jVar = (androidx.activity.result.j) obj;
        Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
        Intent intent2 = jVar.f57b;
        if (intent2 != null && (bundleExtra = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
            intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            if (intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                jVar = new androidx.activity.result.j(jVar.f56a, null, jVar.f58c, jVar.f59d);
            }
        }
        intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", jVar);
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
        }
        return intent;
    }

    @Override // c.b
    public final Object c(Intent intent, int i2) {
        return new androidx.activity.result.b(intent, i2);
    }
}
