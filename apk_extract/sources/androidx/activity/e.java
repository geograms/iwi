package androidx.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import androidx.fragment.app.n0;
import j.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22a;

    /* renamed from: b, reason: collision with root package name */
    public final int f23b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f24c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f25d;

    public /* synthetic */ e(f fVar, int i2, Object obj, int i3) {
        this.f22a = i3;
        this.f24c = fVar;
        this.f23b = i2;
        this.f25d = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        androidx.activity.result.c cVar;
        int i2 = this.f22a;
        int i3 = 0;
        Object obj = this.f24c;
        int i4 = this.f23b;
        Object obj2 = this.f25d;
        switch (i2) {
            case 0:
                f fVar = (f) obj;
                Object obj3 = ((c.a) obj2).f1221a;
                String str = (String) fVar.f49b.get(Integer.valueOf(i4));
                if (str != null) {
                    androidx.activity.result.f fVar2 = (androidx.activity.result.f) fVar.f53f.get(str);
                    if (fVar2 != null && (cVar = fVar2.f44a) != null) {
                        if (fVar.f52e.remove(str)) {
                            ((n0) cVar).b(obj3);
                            break;
                        }
                    } else {
                        fVar.f55h.remove(str);
                        fVar.f54g.put(str, obj3);
                        break;
                    }
                }
                break;
            case 1:
                ((f) obj).a(i4, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (IntentSender.SendIntentException) obj2));
                break;
            case 2:
                String[] strArr = (String[]) obj2;
                int[] iArr = new int[strArr.length];
                Activity activity = (Activity) obj;
                PackageManager packageManager = activity.getPackageManager();
                String packageName = activity.getPackageName();
                int length = strArr.length;
                while (i3 < length) {
                    iArr[i3] = packageManager.checkPermission(strArr[i3], packageName);
                    i3++;
                }
                ((h.d) activity).onRequestPermissionsResult(i4, strArr, iArr);
                break;
            case 3:
                p pVar = (p) ((k.j) obj2).f1934b;
                if (pVar != null) {
                    pVar.onFontRetrievalFailed(i4);
                    break;
                }
                break;
            default:
                List list = (List) obj2;
                int size = list.size();
                if (i4 == 1) {
                    while (i3 < size) {
                        ((androidx.emoji2.text.h) list.get(i3)).onInitialized();
                        i3++;
                    }
                    break;
                } else {
                    while (i3 < size) {
                        ((androidx.emoji2.text.h) list.get(i3)).onFailed((Throwable) obj);
                        i3++;
                    }
                    break;
                }
        }
    }

    public e(androidx.fragment.app.d dVar, k.j jVar, int i2) {
        this.f22a = 3;
        this.f24c = dVar;
        this.f25d = jVar;
        this.f23b = i2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public e(androidx.emoji2.text.h hVar, int i2) {
        this.f22a = 4;
        androidx.emoji2.text.h[] hVarArr = new androidx.emoji2.text.h[1];
        if (hVar != null) {
            hVarArr[0] = hVar;
            this(Arrays.asList(hVarArr), i2, (Throwable) null);
            return;
        }
        throw new NullPointerException("initCallback cannot be null");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(int i2, ArrayList arrayList) {
        this(arrayList, i2, (Throwable) null);
        this.f22a = 4;
    }

    public e(List list, int i2, Throwable th) {
        this.f22a = 4;
        if (list != null) {
            this.f25d = new ArrayList(list);
            this.f23b = i2;
            this.f24c = th;
            return;
        }
        throw new NullPointerException("initCallbacks cannot be null");
    }
}
