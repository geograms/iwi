package androidx.room;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1037a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f1038b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f1039c;

    public /* synthetic */ e(QueryInterceptorDatabase queryInterceptorDatabase, String str, int i2) {
        this.f1037a = i2;
        this.f1038b = queryInterceptorDatabase;
        this.f1039c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f1037a;
        String str = this.f1039c;
        QueryInterceptorDatabase queryInterceptorDatabase = this.f1038b;
        switch (i2) {
            case 0:
                QueryInterceptorDatabase.query$lambda$6(queryInterceptorDatabase, str);
                break;
            default:
                QueryInterceptorDatabase.execSQL$lambda$10(queryInterceptorDatabase, str);
                break;
        }
    }
}
