package k0;

import androidx.room.RoomDatabase;
import com.chamsion.quickchat.db.channel.ChannelDatabase;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final RoomDatabase f2022a;

    /* renamed from: b, reason: collision with root package name */
    public final b f2023b;

    /* renamed from: c, reason: collision with root package name */
    public final v f2024c;

    /* renamed from: d, reason: collision with root package name */
    public final w f2025d;

    public x(ChannelDatabase channelDatabase) {
        this.f2022a = channelDatabase;
        int i2 = 1;
        this.f2023b = new b(this, channelDatabase, i2);
        int i3 = 0;
        this.f2024c = new v(channelDatabase, i3);
        new v(channelDatabase, i2);
        this.f2025d = new w(this, channelDatabase, i3);
    }

    public final void a() {
        RoomDatabase roomDatabase = this.f2022a;
        roomDatabase.assertNotSuspendingTransaction();
        w wVar = this.f2025d;
        c0.k kVarAcquire = wVar.acquire();
        try {
            roomDatabase.beginTransaction();
            try {
                kVarAcquire.executeUpdateDelete();
                roomDatabase.setTransactionSuccessful();
            } finally {
                roomDatabase.endTransaction();
            }
        } finally {
            wVar.release(kVarAcquire);
        }
    }

    public final long b(u uVar) {
        RoomDatabase roomDatabase = this.f2022a;
        roomDatabase.assertNotSuspendingTransaction();
        roomDatabase.beginTransaction();
        try {
            long jInsertAndReturnId = this.f2023b.insertAndReturnId(uVar);
            roomDatabase.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            roomDatabase.endTransaction();
        }
    }
}
