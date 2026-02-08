package m0;

import androidx.room.RoomDatabase;

/* loaded from: classes.dex */
public final /* synthetic */ class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2128a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f2129b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f2130c;

    public /* synthetic */ l(m mVar, a aVar, int i2) {
        this.f2128a = i2;
        this.f2129b = mVar;
        this.f2130c = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RoomDatabase roomDatabase;
        int i2 = this.f2128a;
        m mVar = this.f2129b;
        a aVar = this.f2130c;
        switch (i2) {
            case 0:
                d dVar = mVar.f2131a;
                roomDatabase = dVar.f2101a;
                roomDatabase.assertNotSuspendingTransaction();
                roomDatabase.beginTransaction();
                try {
                    dVar.f2104d.handle(aVar);
                    roomDatabase.setTransactionSuccessful();
                    return;
                } finally {
                }
            case 1:
                d dVar2 = mVar.f2131a;
                roomDatabase = dVar2.f2101a;
                roomDatabase.assertNotSuspendingTransaction();
                roomDatabase.beginTransaction();
                try {
                    dVar2.f2103c.handle(aVar);
                    roomDatabase.setTransactionSuccessful();
                    return;
                } finally {
                }
            default:
                d dVar3 = mVar.f2131a;
                roomDatabase = dVar3.f2101a;
                roomDatabase.assertNotSuspendingTransaction();
                roomDatabase.beginTransaction();
                try {
                    dVar3.f2102b.insert((k0.b) aVar);
                    roomDatabase.setTransactionSuccessful();
                    return;
                } finally {
                }
        }
    }
}
