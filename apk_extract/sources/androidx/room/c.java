package androidx.room;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1031a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f1032b;

    public /* synthetic */ c(QueryInterceptorDatabase queryInterceptorDatabase, int i2) {
        this.f1031a = i2;
        this.f1032b = queryInterceptorDatabase;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f1031a;
        QueryInterceptorDatabase queryInterceptorDatabase = this.f1032b;
        switch (i2) {
            case 0:
                QueryInterceptorDatabase.beginTransactionNonExclusive$lambda$1(queryInterceptorDatabase);
                break;
            case 1:
                QueryInterceptorDatabase.setTransactionSuccessful$lambda$5(queryInterceptorDatabase);
                break;
            case 2:
                QueryInterceptorDatabase.beginTransactionWithListenerNonExclusive$lambda$3(queryInterceptorDatabase);
                break;
            case 3:
                QueryInterceptorDatabase.beginTransaction$lambda$0(queryInterceptorDatabase);
                break;
            case 4:
                QueryInterceptorDatabase.endTransaction$lambda$4(queryInterceptorDatabase);
                break;
            default:
                QueryInterceptorDatabase.beginTransactionWithListener$lambda$2(queryInterceptorDatabase);
                break;
        }
    }
}
