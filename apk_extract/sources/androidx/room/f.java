package androidx.room;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1040a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorStatement f1041b;

    public /* synthetic */ f(QueryInterceptorStatement queryInterceptorStatement, int i2) {
        this.f1040a = i2;
        this.f1041b = queryInterceptorStatement;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f1040a;
        QueryInterceptorStatement queryInterceptorStatement = this.f1041b;
        switch (i2) {
            case 0:
                QueryInterceptorStatement.executeUpdateDelete$lambda$1(queryInterceptorStatement);
                break;
            case 1:
                QueryInterceptorStatement.execute$lambda$0(queryInterceptorStatement);
                break;
            case 2:
                QueryInterceptorStatement.executeInsert$lambda$2(queryInterceptorStatement);
                break;
            case 3:
                QueryInterceptorStatement.simpleQueryForString$lambda$4(queryInterceptorStatement);
                break;
            default:
                QueryInterceptorStatement.simpleQueryForLong$lambda$3(queryInterceptorStatement);
                break;
        }
    }
}
