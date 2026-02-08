package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public final class f extends androidx.activity.result.h {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ h f26i;

    public f(h hVar) {
        this.f26i = hVar;
    }

    @Override // androidx.activity.result.h
    public final void b(int i2, c.b bVar, Object obj) {
        Bundle bundle;
        h hVar = this.f26i;
        c.a aVarB = bVar.b(hVar, obj);
        int i3 = 0;
        if (aVarB != null) {
            new Handler(Looper.getMainLooper()).post(new e(this, i2, aVarB, i3));
            return;
        }
        Intent intentA = bVar.a(hVar, obj);
        if (intentA.getExtras() != null && intentA.getExtras().getClassLoader() == null) {
            intentA.setExtrasClassLoader(hVar.getClassLoader());
        }
        if (intentA.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            Bundle bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            bundle = bundleExtra;
        } else {
            bundle = null;
        }
        if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intentA.getAction())) {
            String[] stringArrayExtra = intentA.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            h.f.c(hVar, stringArrayExtra, i2);
            return;
        }
        if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentA.getAction())) {
            int i4 = h.f.f1829b;
            h.a.b(hVar, intentA, i2, bundle);
            return;
        }
        androidx.activity.result.j jVar = (androidx.activity.result.j) intentA.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
        try {
            IntentSender intentSender = jVar.f56a;
            Intent intent = jVar.f57b;
            int i5 = jVar.f58c;
            int i6 = jVar.f59d;
            int i7 = h.f.f1829b;
            h.a.c(hVar, intentSender, i2, intent, i5, i6, 0, bundle);
        } catch (IntentSender.SendIntentException e2) {
            new Handler(Looper.getMainLooper()).post(new e(this, i2, e2, 1));
        }
    }
}
