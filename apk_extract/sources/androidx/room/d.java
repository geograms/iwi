package androidx.room;

import c0.j;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1033a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f1034b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j f1035c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorProgram f1036d;

    public /* synthetic */ d(QueryInterceptorDatabase queryInterceptorDatabase, j jVar, QueryInterceptorProgram queryInterceptorProgram, int i2) {
        this.f1033a = i2;
        this.f1034b = queryInterceptorDatabase;
        this.f1035c = jVar;
        this.f1036d = queryInterceptorProgram;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f1033a;
        QueryInterceptorDatabase queryInterceptorDatabase = this.f1034b;
        QueryInterceptorProgram queryInterceptorProgram = this.f1036d;
        j jVar = this.f1035c;
        switch (i2) {
            case 0:
                QueryInterceptorDatabase.query$lambda$9(queryInterceptorDatabase, jVar, queryInterceptorProgram);
                break;
            default:
                QueryInterceptorDatabase.query$lambda$8(queryInterceptorDatabase, jVar, queryInterceptorProgram);
                break;
        }
    }
}
