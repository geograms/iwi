package l0;

import androidx.room.EntityDeletionOrUpdateAdapter;
import c0.k;
import com.chamsion.quickchat.db.channelMessage.ChannelMessageDatabase;

/* loaded from: classes.dex */
public final class b extends EntityDeletionOrUpdateAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2085a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(ChannelMessageDatabase channelMessageDatabase, int i2) {
        super(channelMessageDatabase);
        this.f2085a = i2;
    }

    @Override // androidx.room.EntityDeletionOrUpdateAdapter
    public final void bind(k kVar, Object obj) {
        int i2 = this.f2085a;
        switch (i2) {
            case 0:
                a.a.j(obj);
                switch (i2) {
                    case 0:
                        throw null;
                    default:
                        throw null;
                }
            default:
                a.a.j(obj);
                switch (i2) {
                    case 0:
                        throw null;
                    default:
                        throw null;
                }
        }
    }

    @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        switch (this.f2085a) {
            case 0:
                return "DELETE FROM `channel_message_table` WHERE `id` = ?";
            default:
                return "UPDATE OR ABORT `channel_message_table` SET `id` = ?,`channelIndex` = ?,`channelName` = ?,`timestamp` = ?,`msgCount` = ? WHERE `id` = ?";
        }
    }
}
