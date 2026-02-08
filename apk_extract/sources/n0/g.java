package n0;

import androidx.room.EntityDeletionOrUpdateAdapter;
import com.chamsion.quickchat.db.message.MessageDatabase;

/* loaded from: classes.dex */
public final class g extends EntityDeletionOrUpdateAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2173a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(MessageDatabase messageDatabase, int i2) {
        super(messageDatabase);
        this.f2173a = i2;
    }

    public final void a(c0.k kVar, e eVar) {
        switch (this.f2173a) {
            case 0:
                kVar.bindLong(1, eVar.f2157a);
                break;
            default:
                kVar.bindLong(1, eVar.f2157a);
                kVar.bindLong(2, eVar.f2158b);
                kVar.bindLong(3, eVar.f2159c);
                String str = eVar.f2160d;
                if (str == null) {
                    kVar.bindNull(4);
                } else {
                    kVar.bindString(4, str);
                }
                kVar.bindLong(5, eVar.f2161e);
                kVar.bindLong(6, eVar.f2162f);
                String str2 = eVar.f2163g;
                if (str2 == null) {
                    kVar.bindNull(7);
                } else {
                    kVar.bindString(7, str2);
                }
                String str3 = eVar.f2164h;
                if (str3 == null) {
                    kVar.bindNull(8);
                } else {
                    kVar.bindString(8, str3);
                }
                kVar.bindLong(9, eVar.f2165i);
                kVar.bindLong(10, eVar.f2166j);
                kVar.bindLong(11, eVar.f2167k);
                byte[] bArr = eVar.f2168l;
                if (bArr == null) {
                    kVar.bindNull(12);
                } else {
                    kVar.bindBlob(12, bArr);
                }
                String str4 = eVar.f2169m;
                if (str4 == null) {
                    kVar.bindNull(13);
                } else {
                    kVar.bindString(13, str4);
                }
                kVar.bindLong(14, eVar.f2157a);
                break;
        }
    }

    @Override // androidx.room.EntityDeletionOrUpdateAdapter
    public final /* bridge */ /* synthetic */ void bind(c0.k kVar, Object obj) {
        switch (this.f2173a) {
            case 0:
                a(kVar, (e) obj);
                break;
            default:
                a(kVar, (e) obj);
                break;
        }
    }

    @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        switch (this.f2173a) {
            case 0:
                return "DELETE FROM `message_table` WHERE `id` = ?";
            default:
                return "UPDATE OR ABORT `message_table` SET `id` = ?,`channelIndex` = ?,`senderId` = ?,`senderName` = ?,`receiverId` = ?,`groupId` = ?,`groupName` = ?,`message` = ?,`timestamp` = ?,`messageType` = ?,`messageDirection` = ?,`avatarData` = ?,`receiverName` = ? WHERE `id` = ?";
        }
    }
}
