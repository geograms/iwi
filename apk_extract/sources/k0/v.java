package k0;

import androidx.room.EntityDeletionOrUpdateAdapter;
import com.chamsion.quickchat.db.channel.ChannelDatabase;

/* loaded from: classes.dex */
public final class v extends EntityDeletionOrUpdateAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2019a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v(ChannelDatabase channelDatabase, int i2) {
        super(channelDatabase);
        this.f2019a = i2;
    }

    public final void a(c0.k kVar, u uVar) {
        switch (this.f2019a) {
            case 0:
                kVar.bindLong(1, uVar.f2016a);
                break;
            default:
                kVar.bindLong(1, uVar.f2016a);
                String str = uVar.f2017b;
                if (str == null) {
                    kVar.bindNull(2);
                } else {
                    kVar.bindString(2, str);
                }
                kVar.bindLong(3, uVar.f2018c ? 1L : 0L);
                kVar.bindLong(4, uVar.f2016a);
                break;
        }
    }

    @Override // androidx.room.EntityDeletionOrUpdateAdapter
    public final /* bridge */ /* synthetic */ void bind(c0.k kVar, Object obj) {
        switch (this.f2019a) {
            case 0:
                a(kVar, (u) obj);
                break;
            default:
                a(kVar, (u) obj);
                break;
        }
    }

    @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        switch (this.f2019a) {
            case 0:
                return "DELETE FROM `countries` WHERE `id` = ?";
            default:
                return "UPDATE OR ABORT `countries` SET `id` = ?,`countryCode` = ?,`isSelected` = ? WHERE `id` = ?";
        }
    }
}
