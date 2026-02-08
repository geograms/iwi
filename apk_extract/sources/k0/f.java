package k0;

import androidx.room.RoomDatabase;
import com.chamsion.quickchat.db.channel.ChannelDatabase;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final RoomDatabase f1977a;

    /* renamed from: b, reason: collision with root package name */
    public final b f1978b;

    /* renamed from: c, reason: collision with root package name */
    public final c f1979c;

    /* renamed from: d, reason: collision with root package name */
    public final c f1980d;

    /* renamed from: e, reason: collision with root package name */
    public final d f1981e;

    /* renamed from: f, reason: collision with root package name */
    public final d f1982f;

    public f(ChannelDatabase channelDatabase) {
        this.f1977a = channelDatabase;
        int i2 = 0;
        this.f1978b = new b(this, channelDatabase, i2);
        this.f1979c = new c(channelDatabase, i2);
        int i3 = 1;
        this.f1980d = new c(channelDatabase, i3);
        this.f1981e = new d(channelDatabase, i2);
        this.f1982f = new d(channelDatabase, i3);
    }

    public final void a() {
        RoomDatabase roomDatabase = this.f1977a;
        roomDatabase.assertNotSuspendingTransaction();
        d dVar = this.f1981e;
        c0.k kVarAcquire = dVar.acquire();
        try {
            roomDatabase.beginTransaction();
            try {
                kVarAcquire.executeUpdateDelete();
                roomDatabase.setTransactionSuccessful();
            } finally {
                roomDatabase.endTransaction();
            }
        } finally {
            dVar.release(kVarAcquire);
        }
    }

    public final void b(a aVar) {
        RoomDatabase roomDatabase = this.f1977a;
        roomDatabase.assertNotSuspendingTransaction();
        roomDatabase.beginTransaction();
        try {
            this.f1978b.insertAndReturnId(aVar);
            roomDatabase.setTransactionSuccessful();
        } finally {
            roomDatabase.endTransaction();
        }
    }
}
