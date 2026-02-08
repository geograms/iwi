package c;

import android.content.Intent;
import androidx.activity.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import v0.f;
import v0.l;
import x0.g;

/* loaded from: classes.dex */
public final class d extends b {
    @Override // c.b
    public final Intent a(h hVar, Object obj) {
        String[] strArr = (String[]) obj;
        g.u(hVar, "context");
        g.u(strArr, "input");
        Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
        g.t(intentPutExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
        return intentPutExtra;
    }

    @Override // c.b
    public final a b(h hVar, Object obj) {
        String[] strArr = (String[]) obj;
        g.u(hVar, "context");
        g.u(strArr, "input");
        if (strArr.length == 0) {
            return new a(l.f2601a);
        }
        for (String str : strArr) {
            if (i.e.a(hVar, str) != 0) {
                return null;
            }
        }
        int iA0 = g.a0(strArr.length);
        if (iA0 < 16) {
            iA0 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iA0);
        for (String str2 : strArr) {
            linkedHashMap.put(str2, Boolean.TRUE);
        }
        return new a(linkedHashMap);
    }

    @Override // c.b
    public final Object c(Intent intent, int i2) {
        l lVar = l.f2601a;
        if (i2 != -1 || intent == null) {
            return lVar;
        }
        String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        if (intArrayExtra == null || stringArrayExtra == null) {
            return lVar;
        }
        ArrayList arrayList = new ArrayList(intArrayExtra.length);
        for (int i3 : intArrayExtra) {
            arrayList.add(Boolean.valueOf(i3 == 0));
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str : stringArrayExtra) {
            if (str != null) {
                arrayList2.add(str);
            }
        }
        Iterator it = arrayList2.iterator();
        Iterator it2 = arrayList.iterator();
        ArrayList arrayList3 = new ArrayList(Math.min(f.E0(arrayList2), f.E0(arrayList)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList3.add(new u0.b(it.next(), it2.next()));
        }
        return f.K0(arrayList3);
    }
}
