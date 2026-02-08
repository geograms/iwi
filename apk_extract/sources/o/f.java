package o;

import android.content.Context;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class f implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2221a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2222b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f2223c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e f2224d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f2225e;

    public /* synthetic */ f(String str, Context context, e eVar, int i2, int i3) {
        this.f2221a = i3;
        this.f2222b = str;
        this.f2223c = context;
        this.f2224d = eVar;
        this.f2225e = i2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String str = this.f2222b;
        Context context = this.f2223c;
        e eVar = this.f2224d;
        int i2 = this.f2225e;
        int i3 = this.f2221a;
        switch (i3) {
            case 0:
                switch (i3) {
                }
            default:
                switch (i3) {
                }
        }
        return i.a(str, context, eVar, i2);
    }
}
