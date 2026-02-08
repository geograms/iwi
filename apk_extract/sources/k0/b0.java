package k0;

import androidx.room.RoomDatabase;

/* loaded from: classes.dex */
public final /* synthetic */ class b0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1967a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f1968b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ u f1969c;

    public /* synthetic */ b0(s sVar, u uVar, int i2) {
        this.f1967a = i2;
        this.f1968b = sVar;
        this.f1969c = uVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f1967a;
        s sVar = this.f1968b;
        u uVar = this.f1969c;
        switch (i2) {
            case 0:
                ((x) sVar.f2011a).b(uVar);
                return;
            default:
                x xVar = (x) sVar.f2011a;
                RoomDatabase roomDatabase = xVar.f2022a;
                roomDatabase.assertNotSuspendingTransaction();
                roomDatabase.beginTransaction();
                try {
                    xVar.f2024c.handle(uVar);
                    roomDatabase.setTransactionSuccessful();
                    return;
                } finally {
                    roomDatabase.endTransaction();
                }
        }
    }
}
