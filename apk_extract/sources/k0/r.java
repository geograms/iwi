package k0;

import androidx.room.RoomDatabase;

/* loaded from: classes.dex */
public final /* synthetic */ class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2008a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f2009b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f2010c;

    public /* synthetic */ r(s sVar, a aVar, int i2) {
        this.f2008a = i2;
        this.f2009b = sVar;
        this.f2010c = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RoomDatabase roomDatabase;
        int i2 = this.f2008a;
        s sVar = this.f2009b;
        a aVar = this.f2010c;
        switch (i2) {
            case 0:
                f fVar = (f) sVar.f2012b;
                roomDatabase = fVar.f1977a;
                roomDatabase.assertNotSuspendingTransaction();
                roomDatabase.beginTransaction();
                try {
                    fVar.f1980d.handle(aVar);
                    roomDatabase.setTransactionSuccessful();
                    return;
                } finally {
                }
            case 1:
                ((f) sVar.f2012b).b(aVar);
                return;
            default:
                f fVar2 = (f) sVar.f2012b;
                roomDatabase = fVar2.f1977a;
                roomDatabase.assertNotSuspendingTransaction();
                roomDatabase.beginTransaction();
                try {
                    fVar2.f1979c.handle(aVar);
                    roomDatabase.setTransactionSuccessful();
                    return;
                } finally {
                }
        }
    }
}
